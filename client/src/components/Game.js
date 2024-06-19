import React, { useEffect, useState } from 'react';
import Board from "./Board";
import GameModel from "../models/GameModel";
import axios from "axios";
import ChessApi from "../ChessApi";
import EvaluationModel from "../models/EvaluationModel";
import EvaluationBar from "./EvaluationBar";

/**
 * @typedef GameProps
 * @prop {"WHITE" | "BLACK"} player
 */

/** @param {GameProps} param0  */
function Game({ player }) {
    /** @type {ReturnType<typeof useState<GameModel>>} */
    const [game, setGame] = useState();
    /** @type {ReturnType<typeof useState<Object>>} */
    const [evaluation, setEvaluation] = useState();
    /** @type {ReturnType<typeof useState<string>>} */
    const [moveOrigin, setMoveOrigin] = useState("");
    
    useEffect(() => {
        axios.get(ChessApi.url + "startpos").then(res => {
            setGame(new GameModel(res.data));
        });
    }, []);
        
    useEffect(() => {
        if (game && game.turn != player) {
            makeMove();
        }
    }, [game]);

    
    /**
     * @param {string} position 
     * @param {PieceModel} piece 
     */
    function handleMove(position, piece) {
        if (moveOrigin) {
            if (moveOrigin == position) {
                setMoveOrigin("");
            } else {
                if (piece && piece.color == player) {
                    setMoveOrigin(position);
                } else {
                    makeMove(moveOrigin + position);
                }
            }
        } else {
            if (piece && piece.color == player) {
                setMoveOrigin(position);
            }
        }
    }

    function makeMove(move) {
        setMoveOrigin("");

        const body = {
            move: move,
            depth: 8,
            game: game
        };
        axios.post(ChessApi.url + "makemove", body).then(res => {
            setGame(new GameModel(res.data.game));
            setEvaluation(new EvaluationModel(res.data.evaluation));
        });
        
        if (move) {
            game.board?.makeMove(move);
            setGame(new GameModel(game));
        }
    }

    return (
        <div className="game">
            <EvaluationBar evaluation={evaluation} />
            <Board
                player={player}
                board={game?.board}
                handleMove={handleMove}
                moveOrigin={moveOrigin}
            />
        </div>
    );
}

export default Game;
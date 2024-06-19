import React from 'react';
import Square from "./Square";
import BoardModel from "../models/BoardModel";
import PieceModel from "../models/PieceModel";

/**
 * @typedef GameProps
 * @prop {BoardModel} board
 * @prop {"WHITE" | "BLACK"} player
 * @prop {(position: string, piece: PieceModel) => void} handleMove
 * @prop {string} moveOrigin
 */

/** @param {GameProps} param0  */
function Board({ board, player, handleMove, moveOrigin }) {
    const indexes = [...new Array(64).keys()];

    if (player == "BLACK") {
        indexes.reverse()
    }

    return (
        <div className="board-container">
            <div className="board">
                <div className="squares-container">
                    {indexes.map(i => (
                        <Square index={i} board={board}
                            onClick={handleMove}
                            moveOrigin={moveOrigin}
                            key={i}
                        />
                    ))}
                </div>
            </div>
        </div>
    );
}

export default Board;
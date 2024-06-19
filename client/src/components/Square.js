import React from 'react';
import GameModel from "../models/GameModel";
import PieceIcon from "./PieceIcon";

/**
 * @typedef SquareProps
 * @prop {number} index
 * @prop {GameModel} board
 * @prop {(position: string, piece: Piece) => void} onClick
 * @prop {string} moveOrigin
 * */

/**
 * @param {SquareProps} param0
 */
function Square({ index, board, onClick, moveOrigin }) {
    const classes = ["square"];

    if ((index % 8) % 2 == Math.floor(index / 8) % 2 == 1) {
        classes.push("white");
    } else {
        classes.push("black");
    }

    const piece = board?.pieces[index];

    function getPosition() {
        const column = index % 8;
        const row = Math.floor(index / 8);

        return "abcdefgh"[column] + (8 - row);
    }

    if (moveOrigin == getPosition()) classes.push("move");

    function handleClick() {
        onClick(getPosition(), piece);
    }

    return (
        <div className={classes.join(" ")} onClick={handleClick}>
            <PieceIcon piece={piece} />
        </div>
    );
}

export default Square;
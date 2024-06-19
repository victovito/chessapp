import React from 'react';
import PieceModel from "../models/PieceModel";

import white_k from "../assets/svgs/white_k.svg"
import white_q from "../assets/svgs/white_q.svg"
import white_r from "../assets/svgs/white_r.svg"
import white_b from "../assets/svgs/white_b.svg"
import white_n from "../assets/svgs/white_n.svg"
import white_p from "../assets/svgs/white_p.svg"

import black_k from "../assets/svgs/black_k.svg"
import black_q from "../assets/svgs/black_q.svg"
import black_r from "../assets/svgs/black_r.svg"
import black_b from "../assets/svgs/black_b.svg"
import black_n from "../assets/svgs/black_n.svg"
import black_p from "../assets/svgs/black_p.svg"

/**
 * @typedef PieceIconProps
 * @prop {PieceModel} piece
*/

/**
 * @param {PieceIconProps} param0 
 */
function PieceIcon({ piece }) {
    if (!piece) return;
    const icon = icons[piece.color][piece.type];
    return (
        icon ? (<img className="piece-icon" src={icon}></img>) : (<>NO ICON</>)
    );
}

export default PieceIcon;

const icons = {
    "WHITE": {
        "KING": white_k,
        "QUEEN": white_q,
        "ROOK": white_r,
        "BISHOP": white_b,
        "KNIGHT": white_n,
        "PAWN": white_p,
    },
    "BLACK": {
        "KING": black_k,
        "QUEEN": black_q,
        "ROOK": black_r,
        "BISHOP": black_b,
        "KNIGHT": black_n,
        "PAWN": black_p,
    },
}

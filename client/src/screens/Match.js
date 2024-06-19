import React from 'react';
import Game from "../components/Game";

/**
 * @typedef MatchProps
 * @prop {"WHITE" | "BLACK"} player
 */

/** @param {MatchProps} param0  */
function Match({ player = "WHITE" }) {
    return (
        <div>
            <Game player={player} />
        </div>
    );
}

export default Match;
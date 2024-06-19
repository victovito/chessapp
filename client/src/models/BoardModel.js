import PieceModel from "./PieceModel";

export default class BoardModel {
    /** @type {PieceModel[]} */
    pieces;

    /** @param {BoardModel} data  */
    constructor(data) {
        this.pieces = data.pieces.map(p => p ? new PieceModel(p) : null);
    }

    /** @param {string} move  */
    makeMove(move) {
        const origin = this.positionToCoord(move.slice(0, 2));
        const target = this.positionToCoord(move.slice(2, 4));

        const i1 = this.mapIndex(origin[0], origin[1]);
        const i2 = this.mapIndex(target[0], target[1]);

        const piece = this.pieces[i1];

        this.pieces[i1] = null;
        this.pieces[i2] = piece;
    }
    
    /** @param {string} move  */
    positionToCoord(position) {
        const column = "abcdefgh".indexOf(position[0]);
        const row = Number.parseInt(position[1]) - 1;
        return [column, row];
    }

    mapIndex(column, row) {
        return (7 - row) * 8 + column;
    }
}
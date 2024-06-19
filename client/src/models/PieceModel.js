export default class PieceModel {
    /** @type {"KING" | "QUEEN" | "ROOK" | "BISHOP" | "KNIGHT" | "PAWN"} */
    type;
    /** @type {"WHITE" | "BLACK"} */
    color;

    /**
     * @param {PieceModel} data 
     */
    constructor(data) {
        this.type = data.type;
        this.color = data.color;
    }
}
import BoardModel from "./BoardModel";
import CastlesModel from "./CastlesModel";

export default class GameModel {
    /** @type {BoardModel} */
    board;
    /** @type {"WHITE" | "BLACK"} */
    turn;
    /** @type {CastlesModel} */
    castles;

    /** 
     * @param {GameModel} data 
    */
    constructor(data) {
        this.board = new BoardModel(data.board);
        this.turn = data.turn;
        this.castles = new CastlesModel(data.castles);
    }
}

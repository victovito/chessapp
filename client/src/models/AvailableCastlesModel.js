export default class AvailableCastlesModel {
    /** @type {boolean} */
    kingSide;
    /** @type {boolean} */
    queenSide;

    /**
     * @param {AvailableCastlesModel} data 
     */
    constructor(data) {
        this.kingSide = data.kingSide;
        this.queenSide = data.queenSide;
    }
}
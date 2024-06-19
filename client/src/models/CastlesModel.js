import AvailableCastlesModel from "./AvailableCastlesModel";

export default class CastlesModel {
    /** @type {AvailableCastlesModel} */
    white;
    /** @type {AvailableCastlesModel} */
    black;

    /**
     * @param {CastlesModel} data 
     */
    constructor(data) {
        this.white = new AvailableCastlesModel(data.white);
        this.black = new AvailableCastlesModel(data.black);
    }
}
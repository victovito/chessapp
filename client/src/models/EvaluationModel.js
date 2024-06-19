export default class EvaluationModel {
    /** @type {boolean} */
    success;
    /** @type {string} */
    bestmove;
    /** @type {number} */
    evaluation;
    /** @type {number} */
    mate;
    /** @type {string} */
    continuation;

    /** @param {EvaluationModel} data  */
    constructor(data) {
        this.success = data.success;
        this.bestmove = data.bestmove;
        this.evaluation = data.evaluation;
        this.mate = data.mate;
        this.continuation = data.continuation;
    }

}
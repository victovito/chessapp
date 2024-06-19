import React from 'react';
import EvaluationModel from "../models/EvaluationModel";

/**
 * @typedef EvaluationBarProps
 * @prop {EvaluationModel} evaluation
 */

/** @param {EvaluationBarProps} param0  */
function EvaluationBar({ evaluation }) {
    const engineEval = evaluation?.evaluation ?? 0;
    // const finalEval = (1 - (1 / (Math.abs(engineEval / 10) + 1))) * Math.sign(engineEval);
    const finalEval = Math.log10(Math.abs(engineEval) + 1) / 1.2 * Math.sign(engineEval);

    console.log(engineEval, finalEval);
    
    const whiteSize = `${Math.max(Math.min((finalEval + 1) / 2, 1), 0) * 100}%`;

    return (
        <div className="eval-bar">
            <div className="white bar" style={{height: whiteSize}} />
            <div className="black bar" />
        </div>
    );
}

export default EvaluationBar;
package com.victovito.chessapp.models;

public class ChessAPIResponseModel {
    boolean success;
    String bestmove;
    double evaluation;
    int mate;
    String continuation;

    public ChessAPIResponseModel() {}

    public boolean isSuccess() {
        return success;
    }
    public String getBestmove() {
        return bestmove;
    }
    public double getEvaluation() {
        return evaluation;
    }
    public int getMate() {
        return mate;
    }
    public String getContinuation() {
        return continuation;
    }
}

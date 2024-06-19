package com.victovito.chessapp.models;

public class BotMoveResponseModel {
    String move;
    GameModel game;
    ChessAPIResponseModel evaluation;

    public BotMoveResponseModel(String move, GameModel game, ChessAPIResponseModel evaluation) {
        this.move = move;
        this.game = game;
        this.evaluation = evaluation;
    }

    public String getMove() {
        return move;
    }

    public GameModel getGame() {
        return game;
    }

    public ChessAPIResponseModel getEvaluation() {
        return evaluation;
    }
    
}

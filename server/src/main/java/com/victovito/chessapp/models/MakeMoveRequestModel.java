package com.victovito.chessapp.models;

public class MakeMoveRequestModel {
    String move;
    int depth;
    GameModel game;
    
    public MakeMoveRequestModel() {}

    public GameModel getGame() {
        return game;
    }

    public int getDepth() {
        return depth;
    }

    public String getMove() {
        return move;
    }

}

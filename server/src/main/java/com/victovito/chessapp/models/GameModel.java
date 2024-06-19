package com.victovito.chessapp.models;

import com.victovito.chessapp.enums.Color;
import com.victovito.chessapp.objects.Game;

public class GameModel {
    BoardModel board;
    Color turn;
    CastlesModel castles;
    
    public GameModel() {}

    public GameModel(Game game) {
        board = new BoardModel(game.getBoard());
        turn = game.getTurn();
        castles = new CastlesModel(game.getCastles());
    }

    public BoardModel getBoard() {
        return board;
    }

    public Color getTurn() {
        return turn;
    }

    public CastlesModel getCastles() {
        return castles;
    }
    
}

package com.victovito.chessapp.models;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.victovito.chessapp.objects.Board;

public class BoardModel {
    ArrayList<PieceModel> pieces;

    public BoardModel() {}

    public BoardModel(Board board) {
        pieces = new ArrayList<PieceModel>(board.getPieces().stream().map(p -> p != null ? new PieceModel(p) : null).collect(Collectors.toList()));
    }

    public ArrayList<PieceModel> getPieces() {
        return pieces;
    }

}

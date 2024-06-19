package com.victovito.chessapp.models;

import com.victovito.chessapp.enums.Color;
import com.victovito.chessapp.enums.Type;
import com.victovito.chessapp.objects.Piece;

public class PieceModel {
    Type type;
    Color color;

    public PieceModel() {}

    public PieceModel(Piece piece) {
        type = piece.getType();
        color = piece.getColor();
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
    
}

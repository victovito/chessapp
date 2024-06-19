package com.victovito.chessapp.objects;

import com.victovito.chessapp.enums.Color;
import com.victovito.chessapp.enums.Type;
import com.victovito.chessapp.models.PieceModel;

public class Piece {
    Type type;
    Color color;

    public Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public Piece(String code) {
        this.color = code.charAt(0) < 'a' ? Color.WHITE : Color.BLACK;
        switch (code.toLowerCase()) {
            case "k":
                type = Type.KING;
                break;
            case "q":
                type = Type.QUEEN;
                break;
            case "r":
                type = Type.ROOK;
                break;
            case "b":
                type = Type.BISHOP;
                break;
            case "n":
                type = Type.KNIGHT;
                break;
            default:
                type = Type.PAWN;
                break;
        }
    }

    public Piece(PieceModel piece) {
        type = piece.getType();
        color = piece.getColor();
    }

    public char getCode() {
        String symbol;
        switch (type) {
            case Type.KING:
                symbol = "k";
                break;
            case Type.QUEEN:
                symbol = "q";
                break;
            case Type.ROOK:
                symbol = "r";
                break;
            case Type.BISHOP:
                symbol = "b";
                break;
            case Type.KNIGHT:
                symbol = "n";
                break;
            default:
                symbol = "p";
                break;
        }
        if (color == Color.WHITE) {
            symbol = symbol.toUpperCase();
        }
        return symbol.charAt(0);
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
    
    public static final Piece WhiteKing = new Piece(Type.KING, Color.WHITE);
    public static final Piece WhiteQueen = new Piece(Type.QUEEN, Color.WHITE);
    public static final Piece WhiteRook = new Piece(Type.ROOK, Color.WHITE);
    public static final Piece WhiteBishop = new Piece(Type.BISHOP, Color.WHITE);
    public static final Piece WhiteKnight = new Piece(Type.KNIGHT, Color.WHITE);
    public static final Piece WhitePawn = new Piece(Type.PAWN, Color.WHITE);

    public static final Piece BlackKing = new Piece(Type.KING, Color.BLACK);
    public static final Piece BlackQueen = new Piece(Type.QUEEN, Color.BLACK);
    public static final Piece BlackRook = new Piece(Type.ROOK, Color.BLACK);
    public static final Piece BlackBishop = new Piece(Type.BISHOP, Color.BLACK);
    public static final Piece BlackKnight = new Piece(Type.KNIGHT, Color.BLACK);
    public static final Piece BlackPawn = new Piece(Type.PAWN, Color.BLACK);
}

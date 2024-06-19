package com.victovito.chessapp.objects;

import com.victovito.chessapp.enums.Color;
import com.victovito.chessapp.enums.Type;
import com.victovito.chessapp.models.GameModel;

public class Game {
    Board board;
    Color turn;
    Castles castles;

    public Game(Board board, Color turn, Castles castles) {
        this.board = board;
        this.turn = turn;
        this.castles = castles;
    }

    public Game(GameModel game) {
        board = new Board(game.getBoard());
        turn = game.getTurn();
        castles = new Castles(game.getCastles());
    }

    public Game(String fen) {
        setFen(fen);
    }

    public String getFen() {
        String position = this.board.getFenPosition();
        String turn = this.turn == Color.WHITE ? "w" : "b";
        String castles = this.castles.getFenCastles();
        String enPassant = "-";

        if (castles.isEmpty()) castles = "-";

        return String.format("%s %s %s %s 0 1", position, turn, castles, enPassant);
    }

    public void setFen(String fen) {
        var values = fen.split(" ");

        Board board = new Board();
        board.setFenPosition(values[0]);

        Color turn = values[1].equals("w") ? Color.WHITE : Color.BLACK;

        Castles castles = new Castles();
        castles.setFenCastles(values[2]);

        this.board = board;
        this.turn = turn;
        this.castles = castles;
    }

    public void makeMove(String move) {
        move = move.toLowerCase();

        String origin = move.substring(0, 2);
        String target = move.substring(2, 4);
        
        Piece piece = board.getSquare(origin);

        board.setSquare(null, origin);
        board.setSquare(piece, target);

        if (piece != null) {
            handleCastle(piece, origin, target);
            handlePromotion(piece, target);
        }

        flipTurn();
    }

    public Board getBoard() {
        return board;
    }

    public Color getTurn() {
        return turn;
    }

    public Castles getCastles() {
        return castles;
    }

    void flipTurn() {
        if (turn == Color.WHITE) {
            turn = Color.BLACK;
        } else {
            turn = Color.WHITE;
        }
    }

    void handleCastle(Piece piece, String origin, String target) {
        var availableCastles = piece.getColor() == Color.WHITE ? castles.white : castles.black;
        
        int[] targetCoord = Board.transformCoord(target);
        if (piece.getType() == Type.KING) {
            if (availableCastles.queenSide) {
                if (targetCoord[0] == 2) {
                    board.setSquare(new Piece(Type.ROOK, piece.color), 3, targetCoord[1]);
                    board.setSquare(null, 0, targetCoord[1]);
                }
            }
            if (availableCastles.kingSide) {
                if (targetCoord[0] == 6) {
                    board.setSquare(new Piece(Type.ROOK, piece.color), 5, targetCoord[1]);
                    board.setSquare(null, 7, targetCoord[1]);
                }
            }
        }
        
        updateCastles(piece, origin, target);
    }

    void updateCastles(Piece piece, String origin, String target) {
        var availableCastles = piece.getColor() == Color.WHITE ? castles.white : castles.black;
        if (piece.getType() == Type.KING) {
            availableCastles.setKingSide(false);
            availableCastles.setQueenSide(false);
        } else
        if (piece.getType() == Type.ROOK) {
            int[] coord = Board.transformCoord(origin);
            if (coord[0] == 0) {
                availableCastles.setQueenSide(false);
            } else
            if (coord[0] == 7) {
                availableCastles.setKingSide(false);
            }
        }
    }

    void handlePromotion(Piece piece, String target) {
        if (piece.getType() == Type.PAWN) {
            int[] coord = Board.transformCoord(target);
            if ((piece.getColor() == Color.WHITE && coord[1] == 7) || (piece.getColor() == Color.BLACK && coord[1] == 0)) {
                board.setSquare(new Piece(Type.QUEEN, piece.color), target);
            }
        }
    }

}

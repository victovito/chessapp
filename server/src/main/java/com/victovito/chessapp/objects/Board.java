package com.victovito.chessapp.objects;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.victovito.chessapp.exceptions.InvalidBoard;
import com.victovito.chessapp.models.BoardModel;

public class Board {
    ArrayList<Piece> pieces;

    public Board() {}

    public Board(ArrayList<Piece> pieces) throws InvalidBoard {
        if (pieces.size() != 64) {
            throw new InvalidBoard();
        }
        this.pieces = pieces;
    }

    public Board(BoardModel board) {
        pieces = new ArrayList<Piece>(board.getPieces().stream().map(p -> p != null ? new Piece(p) : null).collect(Collectors.toList()));
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public String getFenPosition() {
        String position = "";
        for (int i = 7; i >= 0; i--) {
            int empty = 0;
            for (int j = 0; j < 8; j++) {
                Piece curr = getSquare(j, i);
                if (curr == null) {
                    empty++;
                } else {
                    if (empty > 0) position += empty;
                    position += curr.getCode();
                    empty = 0;
                }
            }
            if (empty > 0) position += empty;
            if (i > 0) position += "/";
        }
        return position;
    }

    public void setFenPosition(String fenPosition) {
        pieces = new ArrayList<>();

        for (int i = 0; i < fenPosition.length(); i++) {
            char symbol = fenPosition.charAt(i);

            if (symbol >= '0' && symbol <= '9') {
                int value = symbol - '0';
                for (int j = 0; j < value; j++) {
                    pieces.add(null);
                }
            }

            if ((symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z')) {
                pieces.add(new Piece(String.valueOf(symbol)));
            }
        }
    }

    public Piece getSquare(String coord) {
        int[] intCoord = transformCoord(coord);
        return getSquare(intCoord[0], intCoord[1]);
    }

    public void setSquare(Piece piece, String coord) {
        int[] intCoord = transformCoord(coord);
        setSquare(piece, intCoord[0], intCoord[1]);
    }

    public Piece getSquare(int column, int row) {
        return pieces.get(mapIndex(column, row));
    }

    public void setSquare(Piece piece, int column, int row) {
        pieces.set(mapIndex(column, row), piece);
    }

    int mapIndex(int column, int row) {
        return (7 - row) * 8 + column;
    }

    public static int[] transformCoord(String coord) {
        coord = coord.toLowerCase();
        int column = coord.charAt(0) - 'a';
        int row = coord.charAt(1) - '0' - 1;
        return new int[] { column, row };
    }
}

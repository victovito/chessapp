package com.victovito.chessapp.exceptions;

public class InvalidBoard extends Exception {
    public InvalidBoard() {
        super("The board is invalid.");
    }
}

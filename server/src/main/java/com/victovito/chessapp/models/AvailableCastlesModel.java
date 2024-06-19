package com.victovito.chessapp.models;

import com.victovito.chessapp.objects.AvailableCastles;

public class AvailableCastlesModel {
    boolean kingSide;
    boolean queenSide;

    public AvailableCastlesModel() {}

    public AvailableCastlesModel(AvailableCastles availableCastles) {
        kingSide = availableCastles.getKingSide();
        queenSide = availableCastles.getQueenSide();
    }

    public boolean getKingSide() {
        return kingSide;
    }

    public boolean getQueenSide() {
        return queenSide;
    }
    
}

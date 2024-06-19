package com.victovito.chessapp.objects;

import com.victovito.chessapp.models.AvailableCastlesModel;

public class AvailableCastles {
    boolean kingSide;
    boolean queenSide;

    public AvailableCastles() {}

    public AvailableCastles(boolean kingSide, boolean queenSide) {
        this.kingSide = kingSide;
        this.queenSide = queenSide;
    }

    public AvailableCastles(AvailableCastlesModel availableCastles) {
        kingSide = availableCastles.getKingSide();
        queenSide = availableCastles.getQueenSide();
    }

    public boolean getKingSide() {
        return kingSide;
    }

    public boolean getQueenSide() {
        return queenSide;
    }

    public void setKingSide(boolean kingSide) {
        this.kingSide = kingSide;
    }

    public void setQueenSide(boolean queenSide) {
        this.queenSide = queenSide;
    }

}

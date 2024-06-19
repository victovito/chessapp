package com.victovito.chessapp.models;

import com.victovito.chessapp.objects.Castles;

public class CastlesModel {
    AvailableCastlesModel white;
    AvailableCastlesModel black;
    
    public CastlesModel() {}

    public CastlesModel(Castles castles) {
        white = new AvailableCastlesModel(castles.getWhite());
        black = new AvailableCastlesModel(castles.getBlack());
    }

    public AvailableCastlesModel getWhite() {
        return white;
    }

    public AvailableCastlesModel getBlack() {
        return black;
    }
    
}

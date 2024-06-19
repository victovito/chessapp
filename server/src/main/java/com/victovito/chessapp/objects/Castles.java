package com.victovito.chessapp.objects;

import com.victovito.chessapp.models.CastlesModel;

public class Castles {
    AvailableCastles white;
    AvailableCastles black;

    public Castles() {}

    public Castles(AvailableCastles white, AvailableCastles black) {
        this.white = white;
        this.black = black;
    }

    public Castles(CastlesModel castles) {
        white = new AvailableCastles(castles.getWhite());
        black = new AvailableCastles(castles.getBlack());
    }

    public String getFenCastles() {
        String white = (this.white.getKingSide() ? "K" : "") + (this.white.getQueenSide() ? "Q" : "");
        String black = (this.black.getKingSide() ? "k" : "") + (this.black.getQueenSide() ? "q" : "");
        return white + black;
    }

    public void setFenCastles(String fenCastles) {
        if (fenCastles.equals("-")) {
            white = new AvailableCastles(false, false);
            black = new AvailableCastles(false, false);
            return;
        };

        white = new AvailableCastles(
            fenCastles.charAt(0) == 'K', fenCastles.charAt(1) == 'Q'
        );
        black = new AvailableCastles(
            fenCastles.charAt(2) == 'k', fenCastles.charAt(3) == 'q'
        );
    }

    public AvailableCastles getWhite() {
        return white;
    }

    public AvailableCastles getBlack() {
        return black;
    }
}

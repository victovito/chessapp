package com.victovito.chessapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.victovito.chessapp.models.MakeMoveRequestModel;
import com.victovito.chessapp.models.BotMoveResponseModel;
import com.victovito.chessapp.models.GameModel;
import com.victovito.chessapp.objects.Game;
import com.victovito.chessapp.services.ChessAPIService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ChessController {
    
    @Autowired
    ChessAPIService chess;

    @PostMapping("/makemove")
    public ResponseEntity<BotMoveResponseModel> makeMove(@RequestBody MakeMoveRequestModel body) {
        try {
            Game game = new Game(body.getGame());

            if (body.getMove() != null) {
                game.makeMove(body.getMove());
            }

            var evaluation = chess.EvaluatePosition(game, body.getDepth());
            String move = evaluation.getBestmove().split(" ")[1];
            game.makeMove(move);

            var response = new BotMoveResponseModel(move, new GameModel(game), evaluation);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/startpos")
    public ResponseEntity<GameModel> getStartPos() {
        try {
            Game game = new Game("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
            return new ResponseEntity<>(new GameModel(game), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

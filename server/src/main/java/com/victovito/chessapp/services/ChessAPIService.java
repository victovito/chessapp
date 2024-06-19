package com.victovito.chessapp.services;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.UriEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.victovito.chessapp.models.ChessAPIResponseModel;
import com.victovito.chessapp.objects.Game;

@Service
public class ChessAPIService {

    final String apiUrl = "https://stockfish.online/api/s/v2.php";
    final HttpClient client = HttpClients.createDefault();

    public ChessAPIResponseModel EvaluatePosition(Game game, int depth) throws IOException {
        try {
            String url = String.format("%s?fen=%s&depth=%d", apiUrl, UriEncoder.encode(game.getFen()), depth);
            HttpGet request = new HttpGet(url);

            String response = client.execute(request, new BasicResponseHandler());

            ObjectMapper mapper = new ObjectMapper();
            ChessAPIResponseModel evaluation = mapper.readValue(response, ChessAPIResponseModel.class);

            return evaluation;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}

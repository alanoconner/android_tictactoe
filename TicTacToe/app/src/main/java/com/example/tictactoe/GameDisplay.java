package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainButton = findViewById(R.id.button3);
        Button homeButton = findViewById(R.id.button4);
        TextView playerTurn = findViewById(R.id.textView5);

        playAgainButton.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if(playerNames!=null){
            playerTurn.setText((playerNames[0]+"'s Turn"));
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setUpGame(playAgainButton, homeButton, playerTurn,playerNames);
    }

    public void playAgainButton(View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
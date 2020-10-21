package com.example.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player = 1;
    int[] box = {0,0,0,0,0,0,0,0,0};
    int[][] checkWin = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean won = false;
    int drawn = 0;

    public void dropIn(View view){

        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        Button playAgainButton = (Button)findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView)findViewById(R.id.winnerTextView);
        if(box[tappedCounter] == 0 && !won) {
            box[tappedCounter] = player;
            drawn++;
            if (player == 1) {
                counter.setImageResource(R.drawable.yellow);

                player = 2;
            } else {
                counter.setImageResource(R.drawable.red);

                player = 1;
            }

            if(drawn == 9){
                for (int[] x : checkWin) {
                    if (box[x[0]] == box[x[1]] && box[x[1]] == box[x[2]] && box[x[0]] != 0) {
                        won = true;
                        String message;
                        if (box[x[0]] == 1) {
                            message = "Yellow";
                        } else {
                            message = "Red";
                        }

                        winnerTextView.setText(message + " has WON!");
                        playAgainButton.setVisibility(View.VISIBLE);
                        winnerTextView.setVisibility(View.VISIBLE);
                    }
                }
                if(!won) {
                    winnerTextView.setText("Match Drawn!");
                    playAgainButton.setVisibility(View.VISIBLE);
                    winnerTextView.setVisibility(View.VISIBLE);
                }
            }else {
                for (int[] x : checkWin) {
                    if (box[x[0]] == box[x[1]] && box[x[1]] == box[x[2]] && box[x[0]] != 0) {
                        won = true;
                        String message;
                        if (box[x[0]] == 1) {
                            message = "Yellow";
                        } else {
                            message = "Red";
                        }

                        winnerTextView.setText(message + " has WON!");
                        playAgainButton.setVisibility(View.VISIBLE);
                        winnerTextView.setVisibility(View.VISIBLE);
                    }
                }
            }

        }
    }

    public void playAgain(View view){
        Button playAgainButton = (Button)findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView)findViewById(R.id.winnerTextView);
        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
        android.support.v7.widget.GridLayout gridLayout = (android.support.v7.widget.GridLayout)findViewById(R.id.gridLayout);
        //GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for(int i = 0; i<gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
        player = 1;
        for(int i = 0; i < box.length; i++){
            box[i] = 0;
        }
        won = false;
        drawn = 0;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

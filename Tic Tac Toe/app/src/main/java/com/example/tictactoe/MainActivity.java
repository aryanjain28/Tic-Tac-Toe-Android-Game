package com.example.tictactoe;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int flag = 0, c=0;
    Button b;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    static int round = 1, p=0, q=0;
    TextView roundCounter, p1, p2;
    static int player1Points  = 0, player2Points  = 0;
    ImageView p1Wins, p2Wins, tied;
    private SoundPlayer sound;

    int[] Xarr = {0,0,0,0,0};
    int[] Oarr = {0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sound = new SoundPlayer(this);

    }

    public void ButtonPressed(View view){

        Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
        vb.vibrate(100);

        int p1Points =0, p2Points =0;

        c = c + 1;

        b = findViewById(view.getId());

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        if(view.getId() == R.id.b1) {
            if (flag == 1)
                Xarr[p++] = 1;
            else
                Oarr[q++] = 1;
        }

        else if(view.getId() == R.id.b2) {
            if (flag == 1)
                Xarr[p++] = 2;
            else
                Oarr[q++] = 2;
        }

        else if(view.getId() == R.id.b3) {
            if (flag == 1)
                Xarr[p++] = 3;
            else
                Oarr[q++] = 3;
        }

        else if(view.getId() == R.id.b4) {
            if (flag == 1)
                Xarr[p++] = 4;
            else
                Oarr[q++] = 4;
        }

        else if(view.getId() == R.id.b5) {
            if (flag == 1)
                Xarr[p++] = 5;
            else
                Oarr[q++] = 5;
        }

        else if(view.getId() == R.id.b6) {
            if (flag == 1)
                Xarr[p++] = 6;
            else
                Oarr[q++] = 6;
        }

        else if(view.getId() == R.id.b7) {
            if (flag == 1)
                Xarr[p++] = 7;
            else
                Oarr[q++] = 7;
        }

        else if(view.getId() == R.id.b8) {
            if (flag == 1)
                Xarr[p++] = 8;
            else
                Oarr[q++] = 8;
        }

        else if(view.getId() == R.id.b9) {
            if (flag == 1)
                Xarr[p++] = 9;
            else
                Oarr[q++] = 9;
        }

        switch (flag){

            case 1 : b.setText("X");
                b.setEnabled(false);
                b.setTextColor(Color.BLACK);
                if(c >= 5){
                    if      (CombinationCheck(Xarr[0], Xarr[1], Xarr[2]) == 1)
                        p1Points+=1;
                    else if((CombinationCheck(Xarr[0], Xarr[1], Xarr[3]) == 1) && (ArrayCounter(Xarr) > 3))
                        p1Points+=1;
                    else if((CombinationCheck(Xarr[0], Xarr[1], Xarr[4]) == 1) && (ArrayCounter(Xarr) > 4))
                        p1Points+=1;
                    else if((CombinationCheck(Xarr[0], Xarr[2], Xarr[3]) == 1) && (ArrayCounter(Xarr) > 3))
                        p1Points+=1;
                    else if((CombinationCheck(Xarr[0], Xarr[2], Xarr[4]) == 1) && (ArrayCounter(Xarr) > 4))
                        p1Points+=1;
                    else if((CombinationCheck(Xarr[0], Xarr[3], Xarr[4]) == 1) && (ArrayCounter(Xarr) > 4))
                        p1Points+=1;
                    else if((CombinationCheck(Xarr[1], Xarr[2], Xarr[3]) == 1) && (ArrayCounter(Xarr) > 3))
                        p1Points+=1;
                    else if((CombinationCheck(Xarr[1], Xarr[2], Xarr[4]) == 1) && (ArrayCounter(Xarr) > 4))
                        p1Points+=1;
                    else if((CombinationCheck(Xarr[1], Xarr[3], Xarr[4]) == 1) && (ArrayCounter(Xarr) > 4))
                        p1Points+=1;
                    else if((CombinationCheck(Xarr[2], Xarr[3], Xarr[4]) == 1) && (ArrayCounter(Xarr) > 4))
                        p1Points+=1;
                }
                flag=0;
                break;

            case 0 : b.setText("O");
                b.setEnabled(false);
                b.setTextColor(Color.BLACK);
                if(c >= 5){
                        if (CombinationCheck(Oarr[0], Oarr[1], Oarr[2]) == 1)
                        p2Points+=1;
                    else if((CombinationCheck(Oarr[0], Oarr[1], Oarr[3]) == 1) && (ArrayCounter(Oarr) > 3))
                        p2Points+=1;
                    else if((CombinationCheck(Oarr[0], Oarr[1], Oarr[4]) == 1) && (ArrayCounter(Oarr) > 4))
                        p2Points+=1;
                    else if((CombinationCheck(Oarr[0], Oarr[2], Oarr[3]) == 1) && (ArrayCounter(Oarr) > 3))
                        p2Points+=1;
                    else if((CombinationCheck(Oarr[0], Oarr[2], Oarr[4]) == 1) && (ArrayCounter(Oarr) > 4))
                        p2Points+=1;
                    else if((CombinationCheck(Oarr[0], Oarr[3], Oarr[4]) == 1) && (ArrayCounter(Oarr) > 4))
                        p2Points+=1;
                    else if((CombinationCheck(Oarr[1], Oarr[2], Oarr[3]) == 1) && (ArrayCounter(Oarr) > 3))
                        p2Points+=1;
                    else if((CombinationCheck(Oarr[1], Oarr[2], Oarr[4]) == 1) && (ArrayCounter(Oarr) > 4))
                        p2Points+=1;
                    else if((CombinationCheck(Oarr[1], Oarr[3], Oarr[4]) == 1) && (ArrayCounter(Oarr) > 4))
                        p2Points+=1;
                    else if((CombinationCheck(Oarr[2], Oarr[3], Oarr[4]) == 1) && (ArrayCounter(Oarr) > 4))
                        p2Points+=1;
                }
                flag=1;
                break;
        }


        if(p1Points > 0) {
            player1Points = player1Points + p1Points;
            p1 = findViewById(R.id.p1);
            p1.setText("Player 1 : " + player1Points);
            p1Wins = findViewById(R.id.PlayerOneWins);
            p1Wins.setVisibility(View.VISIBLE);

            sound.playWinSound();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    p1Wins.setVisibility(View.INVISIBLE);

                }
            }, 2000);

            reset(view);
        }

        else if(p2Points > 0) {
            player2Points = player2Points + p2Points;
            p2 = findViewById(R.id.p2);
            p2.setText("Player 2 : " + player2Points);

            p2Wins = findViewById(R.id.PlayerTwoWins);
            p2Wins.setVisibility(View.VISIBLE);

            sound.playWinSound();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    p2Wins.setVisibility(View.INVISIBLE);
                }
            }, 2000);

            reset(view);
        }

        else if(c == 9){
            tied = findViewById(R.id.gametied);
            tied.setVisibility(View.VISIBLE);

            sound.playDrawSound();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    tied.setVisibility(View.INVISIBLE);
                }
            }, 2000);

            reset(view);
        }
    }

    public int ArrayCounter(int theArray[]){
        int counter = 0;

        for (int i = 0; i < theArray.length; i ++) {
            if (theArray[i] != 0)
                counter=counter+1;
        }

        return counter;
    }

    public void restart(View view){
        round = 0;
        c = 0;
        p=0;
        q=0;
        for(int i=0; i<5; i++){
            Xarr[i] = 0;
            Oarr[i] = 0;
        }


        player1Points = 0;
        player2Points = 0;
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p1.setText("Player 1 : " + player1Points);
        p2.setText("Player 2 : " + player2Points);
        reset(view);
    }

    public int CombinationCheck(int x, int y, int z){

        int positive = 0;

        int[][] table =
                {{1,2,3},
                 {4,5,6},
                 {7,8,9},
                 {1,4,7},
                 {2,5,8},
                 {3,6,9},
                 {1,5,9},
                 {3,5,7}};

        for(int i=0; i<8; i++){

            if(x == table[i][0])
                if((y == table[i][1] && z == table[i][2]) ||  (z == table[i][1] && y == table[i][2]))
                    positive = 1;

            if(y == table[i][0])
                if((x == table[i][1] && z == table[i][2]) ||  (z == table[i][1] && x == table[i][2]))
                    positive = 1;

            if(z == table[i][0])
                if((y == table[i][1] && x == table[i][2]) ||  (x == table[i][1] && y == table[i][2]))
                    positive = 1;
        }

        if(positive == 1)
            return 1;
        return 0;

    }

    public void reset(View view){

        c = 0;
        p=0;
        q=0;
        for(int i=0; i<5; i++){
            Xarr[i] = 0;
            Oarr[i] = 0;
        }

        roundCounter = findViewById(R.id.roundCounter);
        roundCounter.setText("Round : " + (++round));

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
    }
}
package com.example.tictoctoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<int[]> combinationsList = new ArrayList<>() ;
    private int [] boxPositions = {0,0,0,0,0,0,0,0,0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;
    private LinearLayout playerOneLayout,playerTwoLayout ;
    private TextView playerOneName,playerTwoName;
    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         playerOneName = findViewById(R.id.PlayerOneName);
         playerTwoName = findViewById(R.id.PlayerTwoName);

         playerOneLayout = findViewById(R.id.PlayerOneLayout);
         playerTwoLayout = findViewById(R.id.PlayerTwoLayout);

        image1 = findViewById(R.id.image1);
         image2 = findViewById(R.id.image2);
         image3 = findViewById(R.id.image3);
         image4 = findViewById(R.id.image4);
         image5 = findViewById(R.id.image5);
         image6 = findViewById(R.id.image6);
         image7 = findViewById(R.id.image7);
         image8 = findViewById(R.id.image8);
         image9 = findViewById(R.id.image9);

         combinationsList.add(new int[]{0,1,2});
         combinationsList.add(new int[]{3,4,5});
         combinationsList.add(new int[]{6,7,8});
         combinationsList.add(new int[]{0,3,6});
         combinationsList.add(new int[]{1,4,7});
         combinationsList.add(new int[]{2,5,8});
         combinationsList.add(new int[]{2,4,6});
         combinationsList.add(new int[]{0,4,8});

         final String getPlayerOneName =getIntent().getStringExtra("PlayerOne");
         final String getPlayerTwoName =getIntent().getStringExtra("PlayerTwo");
         playerOneName.setText(getPlayerOneName);
         playerTwoName.setText(getPlayerTwoName);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(0)){
                    perFormAction((ImageView)view,0);

                }

            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(1)){
                    perFormAction((ImageView)view,1);

                }

            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(2)){
                    perFormAction((ImageView)view,2);
                }

            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(3)){
                    perFormAction((ImageView)view,3);

                }

            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(4)){
                    perFormAction((ImageView)view,4);

                }

            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(5)){
                    perFormAction((ImageView)view,5);
                }

            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(6)){
                    perFormAction((ImageView)view,6);

                }

            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(7)){
                    perFormAction((ImageView)view,7);

                }

            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(8)){
                 perFormAction((ImageView)view,8);
                }

            }
        });
    }
    private void perFormAction(ImageView imageView,int selectedBoxPosition){
        boxPositions[selectedBoxPosition]=playerTurn;
        if (playerTurn==1){
            imageView.setImageResource(R.drawable.close);
            if (checkPlayerWin()){
                WinDialog winDialog = new WinDialog(MainActivity.this,playerOneName.getText().toString()+ " has won the match",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else if (totalSelectedBoxes == 9) {
                WinDialog winDialog = new WinDialog(MainActivity.this,"It is a draw!",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }else {
                changePlayerTurn(2);
                totalSelectedBoxes++;

            }
        }else {
            imageView.setImageResource(R.drawable.o);
            if (checkPlayerWin()){
                WinDialog winDialog = new WinDialog(MainActivity.this,playerTwoName.getText().toString()+ " has won the match",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();

            } else if (totalSelectedBoxes == 9) {
                WinDialog winDialog = new WinDialog(MainActivity.this,"It is a draw!",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }
    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if (playerTurn==1){
            playerOneLayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_darkblue);

        }else {
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playerOneLayout.setBackgroundResource(R.drawable.round_back_darkblue);
        }

    }
    private boolean checkPlayerWin(){
        boolean response= false;
        for (int i=0;i<combinationsList.size();i++){
            final int[] combination= combinationsList.get(i);
            if (boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn && boxPositions[combination[2]]==playerTurn ){
                response = true;
            }
        }
        return response ;
    }
    private boolean isBoxSelectable(int boxPosition){
        boolean response = false;
        if (boxPositions[boxPosition]==0){
            response=true;
        }
        return response;
    }
    public void restartMatch(){
        boxPositions = new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalSelectedBoxes = 1;
        image1.setImageResource(R.drawable.darkbluebackground);
        image2.setImageResource(R.drawable.darkbluebackground);
        image3.setImageResource(R.drawable.darkbluebackground);
        image4.setImageResource(R.drawable.darkbluebackground);
        image5.setImageResource(R.drawable.darkbluebackground);
        image6.setImageResource(R.drawable.darkbluebackground);
        image7.setImageResource(R.drawable.darkbluebackground);
        image8.setImageResource(R.drawable.darkbluebackground);
        image9.setImageResource(R.drawable.darkbluebackground);
    }
}
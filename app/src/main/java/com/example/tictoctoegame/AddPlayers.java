package com.example.tictoctoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        final EditText playerOne = findViewById(R.id.PlayerOneName);
        final EditText playerTwo = findViewById(R.id.PlayerTwoName);
        final Button startGameBtn= findViewById(R.id.startGameBtn);

        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getPlayerOneName = playerOne.getText().toString();
                final String getPlayerTwoName = playerTwo.getText().toString();

                if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){
                    Toast.makeText(AddPlayers.this, "Please Enter Player Names", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(AddPlayers.this,MainActivity.class);
                    intent.putExtra("PlayerOne ",getPlayerOneName);
                    intent.putExtra("PlayerTwo ",getPlayerTwoName);
                    startActivity(intent);
                }
            }
        });
    }
}
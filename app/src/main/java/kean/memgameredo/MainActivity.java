package kean.memgameredo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton = (Button) findViewById(R.id.menuStartGameButton);
        Button menuHighScoreButton = (Button) findViewById(R.id.menuHighScoreButton);

        //  Action Listener: new game button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UserChoiceActivity.class);
                startActivity(i);
            }
        });


        //  Action Listener: view high scores -> goes to high score selection menu (# of cards)
        menuHighScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UserChoiceHighScoreActivity.class);
                startActivity(i);
            }
        });


        //In charge of toggling music
        final MediaPlayer gameSong = MediaPlayer.create(MainActivity.this, R.raw.darudesandstorm);
        gameSong.setLooping(true);
        gameSong.start();
        final ToggleButton toggleMusic = (ToggleButton) findViewById(R.id.menuMusicToggleButton);
        toggleMusic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (toggleMusic.isChecked()) {
                    // music is currently playing, so turn off
                    gameSong.setVolume(1,1);
                }else{
                    //toggleMusic.setText("ON");
                    gameSong.setVolume(0,0);
                }
            }
        });


    }





}

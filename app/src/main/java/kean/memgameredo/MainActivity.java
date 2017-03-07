package kean.memgameredo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    private String[] possibelSizes = {"fourCards_","sixCards_","eightCards_","tenCards_","twelveCards_","fourteenCards_",
            "sixteenCards_","eighteenCards_","twentyCards_"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = this.getSharedPreferences("scores", Context.MODE_PRIVATE);
        // If you want to resent values in high scores
        // uncomment below, run app once, and then recomment
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putString("DNE", "true");
//        editor.commit();
        if(!prefs.getString("DNE","").equals("false"))
            setUpPrefs(prefs);


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
//        SharedPreferences mp = this.getSharedPreferences("muiscPlayer", Context.MODE_PRIVATE);
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

    public void setUpPrefs(SharedPreferences prefs) {
        HighScores sco = new HighScores();
        User[] users = sco.getUserArray();

        SharedPreferences.Editor editor = prefs.edit();

        for(int i = 0; i < possibelSizes.length; ++i) {
            editor.putInt(possibelSizes[i] + "firstScore", users[0].getScore());
            editor.putString(possibelSizes[i] + "firstName", users[0].getName());
            editor.putInt(possibelSizes[i] + "secondScore", users[1].getScore());
            editor.putString(possibelSizes[i] + "secondName", users[1].getName());
            editor.putInt(possibelSizes[i] + "thirdScore", users[2].getScore());
            editor.putString(possibelSizes[i] + "thirdName", users[2].getName());
        }


        editor.putString("DNE", "false");
        editor.commit();
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }



}

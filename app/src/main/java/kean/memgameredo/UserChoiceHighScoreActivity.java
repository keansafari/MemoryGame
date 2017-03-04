package kean.memgameredo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;


import static kean.memgameredo.R.id.a0;

public class UserChoiceHighScoreActivity extends AppCompatActivity {

    public static int gameSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);



        // READ ME ~~~~~ ACTION LISTENERS ~~~~~~ //
        
        //THIS CLASS IS RESPONSIBLE FOR THE 9 CARD BUTTONS
        //WHEN YOU CLICK IT, IT GOES TO THE HIGHSCOREACTIVITY.JAVA SCREEN
        //THE HIGHSCOREACTIVITY.JAVA THEN SHOWS THE USER THE TOP 3 SCORES FOR THEIR SELECTED
        //CHOICE. USER MUST HIT THE BACK BUTTON TO RETURN TO OLD SCREEN.
        //
        // To alter serial index you want to pass, change the "game size" integer to whatever you want to make 
        // it easier to call from future classes
        // use UserChoiceHighScoreActivity.getSize(); to get the serializable index you need

        //action listener: Game with 4 cards
        ImageButton fourCards = (ImageButton) findViewById(R.id.fourCards);
        fourCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 6;
                Intent i = new Intent(UserChoiceHighScoreActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

        //action listener: Game with 6 cards
        ImageButton sixCards = (ImageButton) findViewById(R.id.sixCards);
        sixCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 6;
                Intent i = new Intent(UserChoiceHighScoreActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

        //action listener: Game with 8 cards
        ImageButton eightCards = (ImageButton) findViewById(R.id.eightCards);
        eightCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 8;
                Intent i = new Intent(UserChoiceHighScoreActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

        //action listener: Game with 10 cards
        ImageButton tenCards = (ImageButton) findViewById(R.id.tenCards);
        tenCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 10;
                Intent i = new Intent(UserChoiceHighScoreActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

        //action listener: Game with 12 cards
        ImageButton twelveCards = (ImageButton) findViewById(R.id.twelveCards);
        twelveCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 12;
                Intent i = new Intent(UserChoiceHighScoreActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

        //action listener: Game with 14 cards
        ImageButton fourteenCards = (ImageButton) findViewById(R.id.fourteenCards);
        fourteenCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 14;
                Intent i = new Intent(UserChoiceHighScoreActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

        //action listener: Game with 16 cards
        ImageButton sixteenCards = (ImageButton) findViewById(R.id.sixteenCards);
        sixteenCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 16;
                Intent i = new Intent(UserChoiceHighScoreActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

        //action listener: Game with 18 cards
        ImageButton eighteenCards = (ImageButton) findViewById(R.id.eighteenCards);

        eighteenCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 18;
                Intent i = new Intent(UserChoiceHighScoreActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

        //action listener: Game with 20 cards
        ImageButton twentyCards = (ImageButton) findViewById(R.id.twentyCards);
        twentyCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 20;
                Intent i = new Intent(UserChoiceHighScoreActivity.this, HighScoreActivity.class);
                startActivity(i);
            }
        });

    }

    public static int getSize() { return gameSize;}


}

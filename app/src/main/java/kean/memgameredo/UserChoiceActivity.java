package kean.memgameredo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;


import static kean.memgameredo.R.id.a0;

public class UserChoiceActivity extends AppCompatActivity {

    public int gameSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);



        // ~~~~~ ACTION LISTENERS ~~~~~~ //

        //action listener: Game with 4 cards
        ImageButton fourCards = (ImageButton) findViewById(R.id.fourCards);
        fourCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 4;
                ImageButton a0;
                a0 = (ImageButton) findViewById(R.id.a0);

                Intent i = new Intent(UserChoiceActivity.this, MemoryGameActivity.class);

//
                //i.putExtra("Size", gameSize);
                //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        //action listener: Game with 6 cards
        ImageButton sixCards = (ImageButton) findViewById(R.id.sixCards);
        sixCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 6;
                Intent i = new Intent(UserChoiceActivity.this, MemoryGameActivity.class);
                i.putExtra("Size", gameSize);
                startActivity(i);
            }
        });

        //action listener: Game with 8 cards
        ImageButton eightCards = (ImageButton) findViewById(R.id.eightCards);
        eightCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 8;
                Intent i = new Intent(UserChoiceActivity.this, MemoryGameActivity.class);
                i.putExtra("Size", gameSize);
                startActivity(i);
            }
        });

        //action listener: Game with 10 cards
        ImageButton tenCards = (ImageButton) findViewById(R.id.tenCards);
        tenCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 10;
                Intent i = new Intent(UserChoiceActivity.this, MemoryGameActivity.class);
                i.putExtra("Size", gameSize);
                startActivity(i);
            }
        });

        //action listener: Game with 12 cards
        ImageButton twelveCards = (ImageButton) findViewById(R.id.twelveCards);
        twelveCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 12;
                Intent i = new Intent(UserChoiceActivity.this, MemoryGameActivity.class);
                i.putExtra("Size", gameSize);
                startActivity(i);
            }
        });

        //action listener: Game with 14 cards
        ImageButton fourteenCards = (ImageButton) findViewById(R.id.fourteenCards);
        fourteenCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 14;
                Intent i = new Intent(UserChoiceActivity.this, MemoryGameActivity.class);
                i.putExtra("Size", gameSize);
                startActivity(i);
            }
        });

        //action listener: Game with 16 cards
        ImageButton sixteenCards = (ImageButton) findViewById(R.id.sixteenCards);
        sixteenCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 16;
                Intent i = new Intent(UserChoiceActivity.this, MemoryGameActivity.class);
                i.putExtra("Size", gameSize);
                startActivity(i);
            }
        });

        //action listener: Game with 18 cards
        ImageButton eighteenCards = (ImageButton) findViewById(R.id.eighteenCards);

        eighteenCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 18;
                Intent i = new Intent(UserChoiceActivity.this, MemoryGameActivity.class);
                i.putExtra("Size", gameSize);
                startActivity(i);
            }
        });

        //action listener: Game with 20 cards
        ImageButton twentyCards = (ImageButton) findViewById(R.id.twentyCards);

        twentyCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSize = 20;
                Intent i = new Intent(UserChoiceActivity.this, MemoryGameActivity.class);
                i.putExtra("Size", gameSize);
                startActivity(i);
            }
        });

    }


}

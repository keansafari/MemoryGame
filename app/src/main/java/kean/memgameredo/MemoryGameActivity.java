package kean.memgameredo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MemoryGameActivity extends AppCompatActivity {
/*
    private Button newGameButton;
    private Button endGameButton;
    private Button tryAgainButton;
    private ImageButton a0;
    private ImageButton a1;
    private ImageButton a2;
    private ImageButton a3;
    private ImageButton a4;
    private ImageButton a5;
    private ImageButton a6;
    private ImageButton a7;
    private ImageButton a8;
    private ImageButton a9;
    private ImageButton a10;
    private ImageButton a11;
    private ImageButton a12;
    private ImageButton a13;
    private ImageButton a14;
    private ImageButton a15;
    private ImageButton a16;
    private ImageButton a17;
    private ImageButton a18;
    private ImageButton a19;
    private TextView b0;
    private TextView b1;
    private TextView b2;
    private TextView b3;
    private TextView b4;
    private TextView b5;
    private TextView b6;
    private TextView b7;
    private TextView b8;
    private TextView b9;
    private TextView b10;
    private TextView b11;
    private TextView b12;
    private TextView b13;
    private TextView b14;
    private TextView b15;
    private TextView b16;
    private TextView b17;
    private TextView b18;
    private TextView b19;
*/

    private int score = 0;
    private int counter = 0;
    private String matchOne, matchTwo;
    private boolean match;
    private String header;
    private String[] possibelSizes = {"fourCards_","sixCards_","eightCards_","tenCards_","twelveCards_","fourteenCards_",
            "sixteenCards_","eighteenCards_","twentyCards_"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);

        setHeader();

        MemoryGame list = new MemoryGame(UserChoiceActivity.getSize());

        //creates local copy of arraylist just to make it easier to use throughout the class
        final ArrayList<String> wordBoard = list.getBoard();

        //builds board: proper number of as and hides proper words underneath
        buildMemoryBoard(UserChoiceActivity.getSize(), wordBoard);

        matchOne = "";
        matchTwo = "";

        //Declaring all the buttons

        final ImageButton a0 = (ImageButton) findViewById(R.id.a0);
        final ImageButton a1 = (ImageButton) findViewById(R.id.a1);
        final ImageButton a2 = (ImageButton) findViewById(R.id.a2);
        final ImageButton a3 = (ImageButton) findViewById(R.id.a3);
        final ImageButton a4 = (ImageButton) findViewById(R.id.a4);
        final ImageButton a5 = (ImageButton) findViewById(R.id.a5);
        final ImageButton a6 = (ImageButton) findViewById(R.id.a6);
        final ImageButton a7 = (ImageButton) findViewById(R.id.a7);
        final ImageButton a8 = (ImageButton) findViewById(R.id.a8);
        final ImageButton a9 = (ImageButton) findViewById(R.id.a9);
        final ImageButton a10 = (ImageButton) findViewById(R.id.a10);
        final ImageButton a11 = (ImageButton) findViewById(R.id.a11);
        final ImageButton a12 = (ImageButton) findViewById(R.id.a12);
        final ImageButton a13 = (ImageButton) findViewById(R.id.a13);
        final ImageButton a14 = (ImageButton) findViewById(R.id.a14);
        final ImageButton a15 = (ImageButton) findViewById(R.id.a15);
        final ImageButton a16 = (ImageButton) findViewById(R.id.a16);
        final ImageButton a17 = (ImageButton) findViewById(R.id.a17);
        final ImageButton a18 = (ImageButton) findViewById(R.id.a18);
        final ImageButton a19 = (ImageButton) findViewById(R.id.a19);

        final TextView b0 = (TextView) findViewById(R.id.b0);
        final TextView b1 = (TextView) findViewById(R.id.b1);
        final TextView b2 = (TextView) findViewById(R.id.b2);
        final TextView b3 = (TextView) findViewById(R.id.b3);
        final TextView b4 = (TextView) findViewById(R.id.b4);
        final TextView b5 = (TextView) findViewById(R.id.b5);
        final TextView b6 = (TextView) findViewById(R.id.b6);
        final TextView b7 = (TextView) findViewById(R.id.b7);
        final TextView b8 = (TextView) findViewById(R.id.b8);
        final TextView b9 = (TextView) findViewById(R.id.b9);
        final TextView b10 = (TextView) findViewById(R.id.b10);
        final TextView b11 = (TextView) findViewById(R.id.b11);
        final TextView b12 = (TextView) findViewById(R.id.b12);
        final TextView b13 = (TextView) findViewById(R.id.b13);
        final TextView b14 = (TextView) findViewById(R.id.b14);
        final TextView b15 = (TextView) findViewById(R.id.b15);
        final TextView b16 = (TextView) findViewById(R.id.b16);
        final TextView b17 = (TextView) findViewById(R.id.b17);
        final TextView b18 = (TextView) findViewById(R.id.b18);
        final TextView b19 = (TextView) findViewById(R.id.b19);
        final Button tryAgainButton = (Button) findViewById(R.id.tryAgainButton);
        final Button newGameButton = (Button) findViewById(R.id.newGameButton);
        final Button endGameButton = (Button) findViewById(R.id.endGameButton);
        final Button cheatButton = (Button) findViewById(R.id.cheatButton);



        //Functional Action Buttons

        newGameButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        endGameButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MemoryGameActivity.this, MainActivity.class));
            }
        });

        tryAgainButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                buildMemoryBoard(UserChoiceActivity.getSize(), wordBoard);
                final ImageView yaoming = (ImageView) findViewById(R.id.yaoming);
                //yaoming.setVisibility(View.INVISIBLE);
                reactivateEveryButton();
                setAllWordsInvisible();
            }
        });

        cheatButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllWordsVisible();
            }
        });

        //Action Buttons for Grid

        // a0 clicked - show a0
        a0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a0.setVisibility(View.INVISIBLE);
                a0.setClickable(false);
                b0.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(0);
                }
                else {
                    matchOne = wordBoard.get(0);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }

            }
        });

        a1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a1.setVisibility(View.INVISIBLE);
                a1.setClickable(false);
                b1.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(1);
                }
                else {
                    matchOne = wordBoard.get(1);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a2.setVisibility(View.INVISIBLE);
                a2.setClickable(false);
                        b2.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(2);
                }
                else {
                    matchOne = wordBoard.get(2);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a3.setVisibility(View.INVISIBLE);
                a3.setClickable(false);
                b3.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(3);
                }
                else {
                    matchOne = wordBoard.get(3);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a4.setVisibility(View.INVISIBLE);
                a4.setClickable(false);
                b4.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(4);
                }
                else {
                    matchOne = wordBoard.get(4);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a5.setVisibility(View.INVISIBLE);
                a5.setClickable(false);
                b5.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(5);
                }
                else {
                    matchOne = wordBoard.get(5);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a6.setVisibility(View.INVISIBLE);
                a6.setClickable(false);
                b6.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(6);
                }
                else {
                    matchOne = wordBoard.get(6);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a7.setVisibility(View.INVISIBLE);
                a7.setClickable(false);
                b7.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(7);
                }
                else {
                    matchOne = wordBoard.get(7);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a8.setVisibility(View.INVISIBLE);
                a8.setClickable(false);
                b8.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(8);
                }
                else {
                    matchOne = wordBoard.get(8);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a9.setVisibility(View.INVISIBLE);
                a9.setClickable(false);
                b9.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(9);
                }
                else {
                    matchOne = wordBoard.get(9);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a10.setVisibility(View.INVISIBLE);
                a10.setClickable(false);
                b10.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(10);
                }
                else {
                    matchOne = wordBoard.get(10);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a11.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a11.setVisibility(View.INVISIBLE);
                a11.setClickable(false);
                b11.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(11);
                }
                else {
                    matchOne = wordBoard.get(11);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a12.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a12.setVisibility(View.INVISIBLE);
                a12.setClickable(false);
                b12.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(12);
                }
                else {
                    matchOne = wordBoard.get(12);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a13.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a13.setVisibility(View.INVISIBLE);
                a13.setClickable(false);
                b13.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(13);
                }
                else {
                    matchOne = wordBoard.get(13);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a14.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a14.setVisibility(View.INVISIBLE);
                a14.setClickable(false);
                b14.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(14);
                }
                else {
                    matchOne = wordBoard.get(14);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a15.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a15.setVisibility(View.INVISIBLE);
                a15.setClickable(false);
                b15.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(15);
                }
                else {
                    matchOne = wordBoard.get(15);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a16.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a16.setVisibility(View.INVISIBLE);
                a16.setClickable(false);
                b16.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(16);
                }
                else {
                    matchOne = wordBoard.get(16);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a17.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a17.setVisibility(View.INVISIBLE);
                a17.setClickable(false);
                b17.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(17);
                }
                else {
                    matchOne = wordBoard.get(17);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a18.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a18.setVisibility(View.INVISIBLE);
                a18.setClickable(false);
                b18.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(18);
                }
                else {
                    matchOne = wordBoard.get(18);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

        a19.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                a19.setVisibility(View.INVISIBLE);
                a19.setClickable(false);
                b19.setVisibility(View.VISIBLE);
                if (matchOne.length() > 0) {
                    matchTwo = wordBoard.get(19);
                }
                else {
                    matchOne = wordBoard.get(19);
                }
                match = checkMatch();
                if (!match) {
                    disableAllButtonsExceptTryAgain();
                    youLose();
                }
            }
        });

    }



    public boolean checkIfHighScore() {
        SharedPreferences prefs = getSharedPreferences("scores",0);
        int lowestScore = prefs.getInt(header + "thirdScore", 0);
        if (score >= lowestScore) {
            return true;
        }
        return false;
    }

    public void reactivateEveryButton() {
        final Button tryAgainButton = (Button) findViewById(R.id.tryAgainButton);
        final Button newGameButton = (Button) findViewById(R.id.newGameButton);
        final Button endGameButton = (Button) findViewById(R.id.endGameButton);
        tryAgainButton.setClickable(true);
        newGameButton.setClickable(true);
        endGameButton.setClickable(true);
        final ImageButton a0 = (ImageButton) findViewById(R.id.a0);
        final ImageButton a1 = (ImageButton) findViewById(R.id.a1);
        final ImageButton a2 = (ImageButton) findViewById(R.id.a2);
        final ImageButton a3 = (ImageButton) findViewById(R.id.a3);
        final ImageButton a4 = (ImageButton) findViewById(R.id.a4);
        final ImageButton a5 = (ImageButton) findViewById(R.id.a5);
        final ImageButton a6 = (ImageButton) findViewById(R.id.a6);
        final ImageButton a7 = (ImageButton) findViewById(R.id.a7);
        final ImageButton a8 = (ImageButton) findViewById(R.id.a8);
        final ImageButton a9 = (ImageButton) findViewById(R.id.a9);
        final ImageButton a10 = (ImageButton) findViewById(R.id.a10);
        final ImageButton a11 = (ImageButton) findViewById(R.id.a11);
        final ImageButton a12 = (ImageButton) findViewById(R.id.a12);
        final ImageButton a13 = (ImageButton) findViewById(R.id.a13);
        final ImageButton a14 = (ImageButton) findViewById(R.id.a14);
        final ImageButton a15 = (ImageButton) findViewById(R.id.a15);
        final ImageButton a16 = (ImageButton) findViewById(R.id.a16);
        final ImageButton a17 = (ImageButton) findViewById(R.id.a17);
        final ImageButton a18 = (ImageButton) findViewById(R.id.a18);
        final ImageButton a19 = (ImageButton) findViewById(R.id.a19);
        a0.setClickable(true);
        a1.setClickable(true);
        a2.setClickable(true);
        a3.setClickable(true);
        a4.setClickable(true);
        a5.setClickable(true);
        a6.setClickable(true);
        a7.setClickable(true);
        a8.setClickable(true);
        a9.setClickable(true);
        a10.setClickable(true);
        a11.setClickable(true);
        a12.setClickable(true);
        a13.setClickable(true);
        a14.setClickable(true);
        a15.setClickable(true);
        a16.setClickable(true);
        a17.setClickable(true);
        a18.setClickable(true);
        a19.setClickable(true);
    }

    public void youLose() {
        //setCardsInvisible();
        //setAllWordsInvisible();
        final ImageView yaoming = (ImageView) findViewById(R.id.yaoming);
        yaoming.setVisibility(View.VISIBLE);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "You Messed Up LOL\nClick Try Again!";
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        updateScore();
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          yaoming.setVisibility(View.INVISIBLE);
                                      }
                                  }, 2 * 1000);
    }

    public void youWin() {
        Context context = getApplicationContext();
        CharSequence text = "You Win!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        boolean highScoreCheck = checkIfHighScore();

        //if high score, then create high score - else go back to main menu
        Intent toHighScore = new Intent(MemoryGameActivity.this, CreateHighScoreActivity.class);
        if (highScoreCheck) {
            toHighScore.putExtra("gameScore", score);
            startActivity(toHighScore);
            //startActivity(new Intent(MemoryGameActivity.this, CreateHighScoreActivity.class));
        } else {
            startActivity(new Intent(MemoryGameActivity.this, MainActivity.class));
        }
    }

    public boolean checkMatch() {

        //if not ready to check because we don't have two words
        if (matchTwo.equals(""))
            return true;

        //if user is correct
        if (matchOne.equals(matchTwo)) {
            counter++;
            score += 2;
            updateScore();
            matchOne = "";
            matchTwo = "";
            if(counter == UserChoiceActivity.getSize()/2) {
                youWin();
                return true;
            }
            return true;
        }


        //if user is wrong
        matchOne = "";
        matchTwo = "";
        counter = 0;
        if (score > 0)
            score --;
        updateScore();
        return false;



    }

    public void setAllWordsVisible() {
        final TextView b0 = (TextView) findViewById(R.id.b0);
        final TextView b1 = (TextView) findViewById(R.id.b1);
        final TextView b3 = (TextView) findViewById(R.id.b3);
        final TextView b2 = (TextView) findViewById(R.id.b2);
        final TextView b5 = (TextView) findViewById(R.id.b5);
        final TextView b4 = (TextView) findViewById(R.id.b4);
        final TextView b19= (TextView) findViewById(R.id.b19);
        final TextView b18 = (TextView) findViewById(R.id.b18);
        final TextView b17 = (TextView) findViewById(R.id.b17);
        final TextView b16 = (TextView) findViewById(R.id.b16);
        final TextView b15 = (TextView) findViewById(R.id.b15);
        final TextView b14 = (TextView) findViewById(R.id.b14);
        final TextView b13 = (TextView) findViewById(R.id.b13);
        final TextView b12 = (TextView) findViewById(R.id.b12);
        final TextView b11 = (TextView) findViewById(R.id.b11);
        final TextView b10 = (TextView) findViewById(R.id.b10);
        final TextView b9 = (TextView) findViewById(R.id.b9);
        final TextView b8 = (TextView) findViewById(R.id.b8);
        final TextView b7 = (TextView) findViewById(R.id.b7);
        final TextView b6 = (TextView) findViewById(R.id.b6);

        b0.setVisibility(View.VISIBLE);
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        b5.setVisibility(View.VISIBLE);
        b6.setVisibility(View.VISIBLE);
        b7.setVisibility(View.VISIBLE);
        b8.setVisibility(View.VISIBLE);
        b9.setVisibility(View.VISIBLE);
        b10.setVisibility(View.VISIBLE);
        b11.setVisibility(View.VISIBLE);
        b12.setVisibility(View.VISIBLE);
        b13.setVisibility(View.VISIBLE);
        b14.setVisibility(View.VISIBLE);
        b15.setVisibility(View.VISIBLE);
        b16.setVisibility(View.VISIBLE);
        b17.setVisibility(View.VISIBLE);
        b18.setVisibility(View.VISIBLE);
        b19.setVisibility(View.VISIBLE);
    }

    public void setAllWordsInvisible() {

        final TextView b0 = (TextView) findViewById(R.id.b0);
        final TextView b1 = (TextView) findViewById(R.id.b1);
        final TextView b3 = (TextView) findViewById(R.id.b3);
        final TextView b2 = (TextView) findViewById(R.id.b2);
        final TextView b5 = (TextView) findViewById(R.id.b5);
        final TextView b4 = (TextView) findViewById(R.id.b4);
        final TextView b19= (TextView) findViewById(R.id.b19);
        final TextView b18 = (TextView) findViewById(R.id.b18);
        final TextView b17 = (TextView) findViewById(R.id.b17);
        final TextView b16 = (TextView) findViewById(R.id.b16);
        final TextView b15 = (TextView) findViewById(R.id.b15);
        final TextView b14 = (TextView) findViewById(R.id.b14);
        final TextView b13 = (TextView) findViewById(R.id.b13);
        final TextView b12 = (TextView) findViewById(R.id.b12);
        final TextView b11 = (TextView) findViewById(R.id.b11);
        final TextView b10 = (TextView) findViewById(R.id.b10);
        final TextView b9 = (TextView) findViewById(R.id.b9);
        final TextView b8 = (TextView) findViewById(R.id.b8);
        final TextView b7 = (TextView) findViewById(R.id.b7);
        final TextView b6 = (TextView) findViewById(R.id.b6);

        b0.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        b5.setVisibility(View.INVISIBLE);
        b6.setVisibility(View.INVISIBLE);
        b7.setVisibility(View.INVISIBLE);
        b8.setVisibility(View.INVISIBLE);
        b9.setVisibility(View.INVISIBLE);
        b10.setVisibility(View.INVISIBLE);
        b11.setVisibility(View.INVISIBLE);
        b12.setVisibility(View.INVISIBLE);
        b13.setVisibility(View.INVISIBLE);
        b14.setVisibility(View.INVISIBLE);
        b15.setVisibility(View.INVISIBLE);
        b16.setVisibility(View.INVISIBLE);
        b17.setVisibility(View.INVISIBLE);
        b18.setVisibility(View.INVISIBLE);
        b19.setVisibility(View.INVISIBLE);

    }

    public void updateScore() {
        final TextView scoreText = (TextView) findViewById(R.id.scoreText);
        scoreText.setText(""+score);
    }

    public void buildMemoryBoard(int size, ArrayList<String> list ) {
        //reverse waterfall switch statement implementation to save code and time
        switch (size) {
            case 20:
                final ImageButton a18 = (ImageButton) findViewById(R.id.a18);
                final ImageButton a19 = (ImageButton) findViewById(R.id.a19);
                final TextView b19= (TextView) findViewById(R.id.b19);
                final TextView b18 = (TextView) findViewById(R.id.b18);
                a18.setVisibility(View.VISIBLE);
                a19.setVisibility(View.VISIBLE);
                b19.setText(list.get(19));
                b18.setText(list.get(18));
            case 18:
                final ImageButton a16 = (ImageButton) findViewById(R.id.a16);
                final ImageButton a17 = (ImageButton) findViewById(R.id.a17);
                final TextView b17 = (TextView) findViewById(R.id.b17);
                final TextView b16 = (TextView) findViewById(R.id.b16);
                a16.setVisibility(View.VISIBLE);
                a17.setVisibility(View.VISIBLE);
                b17.setText(list.get(17));
                b16.setText(list.get(16));
            case 16:
                final ImageButton a14 = (ImageButton) findViewById(R.id.a14);
                final ImageButton a15 = (ImageButton) findViewById(R.id.a15);
                final TextView b15 = (TextView) findViewById(R.id.b15);
                final TextView b14 = (TextView) findViewById(R.id.b14);
                a14.setVisibility(View.VISIBLE);
                a15.setVisibility(View.VISIBLE);
                b15.setText(list.get(15));
                b14.setText(list.get(14));
            case 14:
                final ImageButton a12 = (ImageButton) findViewById(R.id.a12);
                final ImageButton a13 = (ImageButton) findViewById(R.id.a13);
                final TextView b13 = (TextView) findViewById(R.id.b13);
                final TextView b12 = (TextView) findViewById(R.id.b12);
                a12.setVisibility(View.VISIBLE);
                a13.setVisibility(View.VISIBLE);
                b13.setText(list.get(13));
                b12.setText(list.get(12));
            case 12:
                final ImageButton a10 = (ImageButton) findViewById(R.id.a10);
                final ImageButton a11 = (ImageButton) findViewById(R.id.a11);
                final TextView b11 = (TextView) findViewById(R.id.b11);
                final TextView b10 = (TextView) findViewById(R.id.b10);
                a10.setVisibility(View.VISIBLE);
                a11.setVisibility(View.VISIBLE);
                b11.setText(list.get(11));
                b10.setText(list.get(10));
            case 10:
                final ImageButton a8 = (ImageButton) findViewById(R.id.a8);
                final ImageButton a9 = (ImageButton) findViewById(R.id.a9);
                final TextView b9 = (TextView) findViewById(R.id.b9);
                final TextView b8 = (TextView) findViewById(R.id.b8);
                a8.setVisibility(View.VISIBLE);
                a9.setVisibility(View.VISIBLE);
                b9.setText(list.get(9));
                b8.setText(list.get(8));
            case 8:
                final ImageButton a6 = (ImageButton) findViewById(R.id.a6);
                final ImageButton a7 = (ImageButton) findViewById(R.id.a7);
                final TextView b7 = (TextView) findViewById(R.id.b7);
                final TextView b6 = (TextView) findViewById(R.id.b6);
                a6.setVisibility(View.VISIBLE);
                a7.setVisibility(View.VISIBLE);
                b7.setText(list.get(7));
                b6.setText(list.get(6));
            case 6:
                final ImageButton a4 = (ImageButton) findViewById(R.id.a4);
                final ImageButton a5 = (ImageButton) findViewById(R.id.a5);
                final TextView b5 = (TextView) findViewById(R.id.b5);
                final TextView b4 = (TextView) findViewById(R.id.b4);
                a4.setVisibility(View.VISIBLE);
                a5.setVisibility(View.VISIBLE);
                b5.setText(list.get(5));
                b4.setText(list.get(4));
            case 4:
                final ImageButton a0 = (ImageButton) findViewById(R.id.a0);
                final ImageButton a1 = (ImageButton) findViewById(R.id.a1);
                final ImageButton a2 = (ImageButton) findViewById(R.id.a2);
                final ImageButton a3 = (ImageButton) findViewById(R.id.a3);
                final TextView b3 = (TextView) findViewById(R.id.b3);
                final TextView b2 = (TextView) findViewById(R.id.b2);
                final TextView b1 = (TextView) findViewById(R.id.b1);
                final TextView b0 = (TextView) findViewById(R.id.b0);
                a0.setVisibility(View.VISIBLE);
                a1.setVisibility(View.VISIBLE);
                a2.setVisibility(View.VISIBLE);
                a3.setVisibility(View.VISIBLE);
                b3.setText(list.get(3));
                b2.setText(list.get(2));
                b1.setText(list.get(1));
                b0.setText(list.get(0));
                break;
        }

    }

    public void setCardsInvisible() {
        final ImageButton a0 = (ImageButton) findViewById(R.id.a0);
        final ImageButton a1 = (ImageButton) findViewById(R.id.a1);
        final ImageButton a2 = (ImageButton) findViewById(R.id.a2);
        final ImageButton a3 = (ImageButton) findViewById(R.id.a3);
        final ImageButton a4 = (ImageButton) findViewById(R.id.a4);
        final ImageButton a5 = (ImageButton) findViewById(R.id.a5);
        final ImageButton a6 = (ImageButton) findViewById(R.id.a6);
        final ImageButton a7 = (ImageButton) findViewById(R.id.a7);
        final ImageButton a8 = (ImageButton) findViewById(R.id.a8);
        final ImageButton a9 = (ImageButton) findViewById(R.id.a9);
        final ImageButton a10 = (ImageButton) findViewById(R.id.a10);
        final ImageButton a11 = (ImageButton) findViewById(R.id.a11);
        final ImageButton a12 = (ImageButton) findViewById(R.id.a12);
        final ImageButton a13 = (ImageButton) findViewById(R.id.a13);
        final ImageButton a14 = (ImageButton) findViewById(R.id.a14);
        final ImageButton a15 = (ImageButton) findViewById(R.id.a15);
        final ImageButton a16 = (ImageButton) findViewById(R.id.a16);
        final ImageButton a17 = (ImageButton) findViewById(R.id.a17);
        final ImageButton a18 = (ImageButton) findViewById(R.id.a18);
        final ImageButton a19 = (ImageButton) findViewById(R.id.a19);
        a0.setVisibility(View.INVISIBLE);
        a1.setVisibility(View.INVISIBLE);
        a2.setVisibility(View.INVISIBLE);
        a3.setVisibility(View.INVISIBLE);
        a4.setVisibility(View.INVISIBLE);
        a5.setVisibility(View.INVISIBLE);
        a6.setVisibility(View.INVISIBLE);
        a7.setVisibility(View.INVISIBLE);
        a8.setVisibility(View.INVISIBLE);
        a9.setVisibility(View.INVISIBLE);
        a10.setVisibility(View.INVISIBLE);
        a11.setVisibility(View.INVISIBLE);
        a12.setVisibility(View.INVISIBLE);
        a13.setVisibility(View.INVISIBLE);
        a14.setVisibility(View.INVISIBLE);
        a15.setVisibility(View.INVISIBLE);
        a16.setVisibility(View.INVISIBLE);
        a17.setVisibility(View.INVISIBLE);
        a18.setVisibility(View.INVISIBLE);
        a19.setVisibility(View.INVISIBLE);
    }

    public void resetBoard() {
        final ImageButton a0 = (ImageButton) findViewById(R.id.a0);
        final ImageButton a1 = (ImageButton) findViewById(R.id.a1);
        final ImageButton a2 = (ImageButton) findViewById(R.id.a2);
        final ImageButton a3 = (ImageButton) findViewById(R.id.a3);
        final ImageButton a4 = (ImageButton) findViewById(R.id.a4);
        final ImageButton a5 = (ImageButton) findViewById(R.id.a5);
        final ImageButton a6 = (ImageButton) findViewById(R.id.a6);
        final ImageButton a7 = (ImageButton) findViewById(R.id.a7);
        final ImageButton a8 = (ImageButton) findViewById(R.id.a8);
        final ImageButton a9 = (ImageButton) findViewById(R.id.a9);
        final ImageButton a10 = (ImageButton) findViewById(R.id.a10);
        final ImageButton a11 = (ImageButton) findViewById(R.id.a11);
        final ImageButton a12 = (ImageButton) findViewById(R.id.a12);
        final ImageButton a13 = (ImageButton) findViewById(R.id.a13);
        final ImageButton a14 = (ImageButton) findViewById(R.id.a14);
        final ImageButton a15 = (ImageButton) findViewById(R.id.a15);
        final ImageButton a16 = (ImageButton) findViewById(R.id.a16);
        final ImageButton a17 = (ImageButton) findViewById(R.id.a17);
        final ImageButton a18 = (ImageButton) findViewById(R.id.a18);
        final ImageButton a19 = (ImageButton) findViewById(R.id.a19);
        a0.setVisibility(View.VISIBLE);
        a1.setVisibility(View.VISIBLE);
        a2.setVisibility(View.VISIBLE);
        a3.setVisibility(View.VISIBLE);
        a4.setVisibility(View.VISIBLE);
        a5.setVisibility(View.VISIBLE);
        a6.setVisibility(View.VISIBLE);
        a7.setVisibility(View.VISIBLE);
        a8.setVisibility(View.VISIBLE);
        a9.setVisibility(View.VISIBLE);
        a10.setVisibility(View.VISIBLE);
        a11.setVisibility(View.VISIBLE);
        a12.setVisibility(View.VISIBLE);
        a13.setVisibility(View.VISIBLE);
        a14.setVisibility(View.VISIBLE);
        a15.setVisibility(View.VISIBLE);
        a16.setVisibility(View.VISIBLE);
        a17.setVisibility(View.VISIBLE);
        a18.setVisibility(View.VISIBLE);
        a19.setVisibility(View.VISIBLE);
    }

    public void disableAllButtonsExceptTryAgain() {
        final ImageButton a0 = (ImageButton) findViewById(R.id.a0);
        final ImageButton a1 = (ImageButton) findViewById(R.id.a1);
        final ImageButton a2 = (ImageButton) findViewById(R.id.a2);
        final ImageButton a3 = (ImageButton) findViewById(R.id.a3);
        final ImageButton a4 = (ImageButton) findViewById(R.id.a4);
        final ImageButton a5 = (ImageButton) findViewById(R.id.a5);
        final ImageButton a6 = (ImageButton) findViewById(R.id.a6);
        final ImageButton a7 = (ImageButton) findViewById(R.id.a7);
        final ImageButton a8 = (ImageButton) findViewById(R.id.a8);
        final ImageButton a9 = (ImageButton) findViewById(R.id.a9);
        final ImageButton a10 = (ImageButton) findViewById(R.id.a10);
        final ImageButton a11 = (ImageButton) findViewById(R.id.a11);
        final ImageButton a12 = (ImageButton) findViewById(R.id.a12);
        final ImageButton a13 = (ImageButton) findViewById(R.id.a13);
        final ImageButton a14 = (ImageButton) findViewById(R.id.a14);
        final ImageButton a15 = (ImageButton) findViewById(R.id.a15);
        final ImageButton a16 = (ImageButton) findViewById(R.id.a16);
        final ImageButton a17 = (ImageButton) findViewById(R.id.a17);
        final ImageButton a18 = (ImageButton) findViewById(R.id.a18);
        final ImageButton a19 = (ImageButton) findViewById(R.id.a19);

        a0.setClickable(false);
        a1.setClickable(false);
        a2.setClickable(false);
        a3.setClickable(false);
        a4.setClickable(false);
        a5.setClickable(false);
        a6.setClickable(false);
        a7.setClickable(false);
        a8.setClickable(false);
        a9.setClickable(false);
        a10.setClickable(false);
        a11.setClickable(false);
        a12.setClickable(false);
        a13.setClickable(false);
        a14.setClickable(false);
        a15.setClickable(false);
        a16.setClickable(false);
        a17.setClickable(false);
        a18.setClickable(false);
        a19.setClickable(false);
    }

    public void setHeader() {
        int size = UserChoiceActivity.getSize();
        //header = possibelSizes[(size/4)];
        switch (size) {
            case 4:
                header = possibelSizes[0];
                break;
            case 6:
                header = possibelSizes[1];
                break;
            case 8:
                header = possibelSizes[2];
                break;
            case 10:
                header = possibelSizes[3];
                break;
            case 12:
                header = possibelSizes[4];
                break;
            case 14:
                header = possibelSizes[5];
                break;
            case 16:
                header = possibelSizes[6];
                break;
            case 18:
                header = possibelSizes[7];
                break;
            case 20:
                header = possibelSizes[8];
                break;
        }
    }

}

package kean.memgameredo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

// @Brian - This is where to link up the gui and the program -

public class HighScoreActivity extends AppCompatActivity {

    private int gameSize;
    private TextView firstHighScore;
    private  TextView secondHighScore;
    private TextView thirdHighScore;
    private  String header;
    private String[] possibelSizes = {"fourCards_","sixCards_","eightCards_","tenCards_","twelveCards_","fourteenCards_",
            "sixteenCards_","eighteenCards_","twentyCards_"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        //Don't touch the first two lines! start editing after!!

        gameSize = UserChoiceHighScoreActivity.getSize();
        //scores = new HighScores();
        firstHighScore = (TextView) findViewById(R.id.firstPlaceText);
        secondHighScore = (TextView) findViewById(R.id.secondPlaceText);
        thirdHighScore = (TextView) findViewById(R.id.thirdPlaceText);

        setHeader();;
        initValues();

        firstHighScore.setEnabled(false);
        secondHighScore.setEnabled(false);
        thirdHighScore.setEnabled(false);
    }

    public void setHeader() {
        int size = UserChoiceHighScoreActivity.getSize();
        //header = possibelSizes[(size/4)];
        String check = size + " ";
        Log.v("name", check);
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

    public void initValues() {
        //scores.load();
        //User[] users = scores.getUserArray();
//
//
        //final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        SharedPreferences prefs = getSharedPreferences("scores",0);

        String p1 = prefs.getString(header + "firstName", "")  + prefs.getInt(header + "firstScore", 0);
        String p2 = prefs.getString(header + "secondName", "")  + prefs.getInt(header + "secondScore", 0);
        String p3 = prefs.getString(header + "thirdName", "")  + prefs.getInt(header + "thirdScore", 0);
        Log.v("name", p1 );
        Log.v("name", p2 );
        Log.v("name", p3 );
        firstHighScore.setText(prefs.getString(header + "firstName", "") + "            " + prefs.getInt(header + "firstScore", 0));
        secondHighScore.setText(prefs.getString(header + "secondName", "") + "            " + prefs.getInt(header + "secondScore", 0));
        thirdHighScore.setText(prefs.getString(header + "thirdName", "") + "            " + prefs.getInt(header + "thirdScore", 0));


    }

}

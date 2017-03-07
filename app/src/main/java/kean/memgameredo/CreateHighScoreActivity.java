package kean.memgameredo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateHighScoreActivity extends AppCompatActivity {

    private EditText userNameText;
    private String userName;
    private int score;
    private String[] possibelSizes = {"fourCards_","sixCards_","eightCards_","tenCards_","twelveCards_","fourteenCards_",
    "sixteenCards_","eighteenCards_","twentyCards_"};

    private String header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_high_score);

//        userNameText = (EditText) findViewById(R.id.usersName);

        Bundle mike = getIntent().getExtras();
        if(mike != null)
            score = mike.getInt("gameScore");

        setHeader();
//        SharedPreferences prefs = this.getSharedPreferences("scores", Context.MODE_PRIVATE);
//        userNameText.setText(prefs.getString("firstName", ""));

        final EditText usersName = (EditText) findViewById(R.id.usersName);
        final Button createHSButton = (Button) findViewById(R.id.createHSButton);
        createHSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This is where you can type the code for creating a high score class and
                //adding the user into the hs
                final EditText usersName = (EditText) findViewById(R.id.usersName);
                userName = usersName.getText().toString();
                highScoreSavedToast();
                Intent i = new Intent(CreateHighScoreActivity.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        final Button returnToMenu = (Button) findViewById(R.id.returnToMenu);
        returnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreateHighScoreActivity.this, MainActivity.class);
                highScoreNotSavedToast();
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });


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

    public void highScoreSavedToast() {
        Context context = getApplicationContext();

        SharedPreferences prefs = getSharedPreferences("scores",0);

        HighScores sco = createHighScores(prefs);
        sco.add(userName, score);
        User[] users = sco.getUserArray();


        Log.v("name", header + "firstScore" + users[0].getScore());
        //saveSharedPreferences(prefs);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(header + "firstScore", users[0].getScore());
        editor.putString(header + "firstName", users[0].getName());
        editor.putInt( header + "secondScore", users[1].getScore());
        editor.putString( header + "secondName", users[1].getName());
        editor.putInt(header + "thirdScore", users[2].getScore());
        editor.putString(header + "thirdName", users[2].getName());
        editor.commit();

        Log.v("name", prefs.getString(header + "firstName", "") + " " + prefs.getInt("firstScore", 0));
        Log.v("name", prefs.getString(header + "secondName", "") + " " + prefs.getInt(header + "secondScore", 0));
        Log.v("name", prefs.getString(header + "thirdName", "") + " " + prefs.getInt(header + "thirdScore", 0));

        CharSequence text = "High Score Saved!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

//    public void saveSharedPreferences(SharedPreferences prefs) {
//        SharedPreferences.Editor editor = prefs.edit();
//        int sizeOfGame = UserChoiceActivity.getSize();
//
//
//
//        editor.commit();
//    }

    public HighScores createHighScores(SharedPreferences prefs) {
        HighScores scores = new HighScores();
        scores.add(prefs.getString(header + "firstName", ""), prefs.getInt(header + "firstScore", 0));
        scores.add(prefs.getString(header + "secondName", ""), prefs.getInt(header + "secondScore", 0));
        scores.add(prefs.getString(header + "thirdName", ""), prefs.getInt(header + "thirdScore", 0));
        return scores;
    }

    public void highScoreNotSavedToast() {
        Context context = getApplicationContext();
        CharSequence text = "High Score was not Saved";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public String getUserName() {
        return userName;
    }
}

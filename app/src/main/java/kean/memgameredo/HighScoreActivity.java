package kean.memgameredo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {

    private TextView firstHighScore;
    private TextView secondHighScore;
    private TextView thirdHighScore;
    private HighScores scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        scores = new HighScores();
        //firstHighScore = (TextView) findViewById(R.id.firstHighScore);
        //secondHighScore = (TextView) findViewById(R.id.secondHighScore);
        //thirdHighScore = (TextView) findViewById(R.id.thirdHighScore);

        initValues();
    }

    public void initValues() {
        //scores.load();
        User[] users = scores.getUserArray();

        firstHighScore.setText("1. " + users[0].getName() + "\t" + users[0].getScore());
        secondHighScore.setText("2. " + users[1].getName() + "\t" + users[1].getScore());
        thirdHighScore.setText("3. " + users[2].getName() + "\t" + users[2].getScore());

    }

}

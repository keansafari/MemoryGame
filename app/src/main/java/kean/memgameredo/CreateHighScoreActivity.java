package kean.memgameredo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateHighScoreActivity extends AppCompatActivity {

    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_high_score);

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
                startActivity(i);
            }
        });

        final Button returnToMenu = (Button) findViewById(R.id.returnToMenu);
        returnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreateHighScoreActivity.this, MainActivity.class);
                highScoreNotSavedToast();
                startActivity(i);
            }
        });


    }

    public void highScoreSavedToast() {
        Context context = getApplicationContext();
        CharSequence text = "High Score Saved!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
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

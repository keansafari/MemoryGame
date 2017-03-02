package kean.memgameredo;

import java.io.Serializable;

/**
 * Created by blou on 2/20/17.
 */

public class User implements Serializable {

    private String name;
    private int score;

    public User() {
        name = "";
        score = 0;
    }

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // returns the name of the user
    public String getName() { return name; }

    // returns the user's score
    public int getScore() { return score; }

    // will set the user's score if it needs to change
    public void setScore(int n) { score = n; }
}
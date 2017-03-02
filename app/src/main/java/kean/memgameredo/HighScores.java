package kean.memgameredo;

/**
 * Created by kean on 3/2/2017.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by blou on 2/20/17.
 */

public class HighScores implements Serializable {

    // will store a total of 5 user scores
    private User[] gameData;
    // will hold the lowest score
    // to determine whether a user makes the list
    private int lowestScore;

    public HighScores(String load) {
        load();
    }

    public HighScores() {
        gameData = new User[3];
        reset();
    }

    // method: reset
    // purpose: will reset the values in the highscore
    // to be empty and all scores 0
    public void reset() {
        for(int i = 0; i < gameData.length; ++i) {
            gameData[i] = new User("EMPTY", 0);
        }
        lowestScore = 0;
    }

    // method: add
    // purpose: if a user scores higher than the lowest score
    // the user's score will be added to the list, and then the list
    // will be sorted
    public boolean add(String user, int score) {

        if(score >= lowestScore) {
            gameData[2] = new User(user, score);
            sort();
            lowestScore = gameData[2].getScore();
            return true;
        }
        return false;
    }

    // method: getUserArray
    // purpose: will return the data of the high scores
    public User[] getUserArray() {
        return gameData;
    }

    // method: sort
    // purpose: will use a bubble sort to sort the users
    // by their scores
    private void sort() {
        int n = gameData.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (gameData[i].getScore() < gameData[k].getScore()) {
                    User temp;
                    temp = gameData[i];
                    gameData[i] = gameData[k];
                    gameData[k] = temp;
                }
            }
        }
    }

    /**
     * serializes high score data to a serializable stream
     * method: save
     * purpose: will save the gameData array to a serialized file
     */
    public void save() {

        try {
            FileOutputStream outStream = new FileOutputStream("highScores.ser");
            ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
            fileObjectOut.writeObject(gameData);
            fileObjectOut.close();
            outStream.close();
        } catch (Exception e) {
            return;
        }

    }

    /**
     * deserializes hs data to be able to be posted on high score page
     * method: load
     * purpose: will search for the highScores serialized file, if it exists it
     * it will make the gameData equal to what it was, if not, then it will
     * return to the calling function and continue
     */
    public void load() {

        try {
            FileInputStream inStream = new FileInputStream("highScores.ser");
            ObjectInputStream fileObjectIn = new ObjectInputStream(inStream);
            gameData = (User[]) fileObjectIn.readObject();
            //System.out.println(user);
            fileObjectIn.close();
            inStream.close();
        } catch (Exception e) {
            return;
        }



    }



}
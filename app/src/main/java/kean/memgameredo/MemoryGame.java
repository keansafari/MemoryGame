package kean.memgameredo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by kean on 2/28/2017.
 */

public class MemoryGame {

    private ArrayList<String> board;

    public MemoryGame(int gameSize) {

        board = new ArrayList<>();
        String[] avalibleWords = {"PANDA", "LION", "KOALA", "RAT", "HIPPO", "DOG", "CAT", "BIRD", "CROC", "ANT"};
        for(int i = 0; i < gameSize/2; ++i) {
            //cards.add(new Card((avalibleWords[i])));
            //cards.add(new Card(avalibleWords[i]));
            board.add(i, avalibleWords[i]);
            board.add(i, avalibleWords[i]);
        }
        //To shuffle array list of words
        Collections.shuffle(board);
    }

    public ArrayList<String> getBoard() {
        return board;
    }




}

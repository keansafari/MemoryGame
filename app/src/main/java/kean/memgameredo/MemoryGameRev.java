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

public class MemoryGameRev {

    protected String[] board = new String[20];

    public MemoryGameRev(int gameSize) {

        String[] avalibleWords = {"PANDA", "LION", "KOALA", "RAT", "HIPPO", "DOG", "CAT", "BIRD", "CROC", "ANT"};
        for(int i = 0; i < gameSize/2; ++i) {
            //cards.add(new Card((avalibleWords[i])));
            //cards.add(new Card(avalibleWords[i]));
            //board.add(i, avalibleWords[i]);
            //board.add(i, avalibleWords[i]);
            board[i] = avalibleWords[i];
            board[i+1] =  avalibleWords[i];
            i++;
        }


        //To shuffle array list of words
        //Collections.shuffle(board);

    }

    public String[] getBoard() {
        return board;
    }




}

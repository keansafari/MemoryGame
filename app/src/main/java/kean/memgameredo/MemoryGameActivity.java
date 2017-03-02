package kean.memgameredo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;


public class MemoryGameActivity extends AppCompatActivity {

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




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //MemoryGame list = new MemoryGameRev(20);
        //String[] list2 = list.getBoard();


        //Initialize arraylist of bs and cards/words on board
        //MemoryGame board = new MemoryGame(size);

        //creates local copy of arraylist for simplicity
        //ArrayList<String> list = board.getBoard();

        //builds board: proper number of as and hides proper words underneath
        //buildMemoryBoard(size, list2);

        //Must create and prepare the board prior to showing screen
        //setAllCardsVisible();


        setContentView(R.layout.activity_memory_game);

    }

    /*
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_memory_game, container, false);
        MemoryGame game = new MemoryGame(20);
        ArrayList<String> list = game.getBoard();
        //buildMemoryBoard(20, list);
        a0 = (ImageButton)rootView.findViewById(R.id.a0);
        a0.setVisibility(View.VISIBLE);
        return rootView;
    }
*/
    /*
    //Creates the board -- 4, 6, 8, 10, 12, 14, 16, 18, 20 card difficulty
    public void buildMemoryBoard(int size, ArrayList<String> list ) {

        //reverse waterfall switch statement implementation to save code and time
        switch (size) {
            case 20: a18.setVisibility(View.VISIBLE);
                a19.setVisibility(View.VISIBLE);
                b18.setText(list.get(20));
                b19.setText(list.get(19));
            case 18: a16.setVisibility(View.VISIBLE);
                a17.setVisibility(View.VISIBLE);
                b16.setText(list.get(16));
                b17.setText(list.get(17));
            case 16: a14.setVisibility(View.VISIBLE);
                a15.setVisibility(View.VISIBLE);
                b14.setText(list.get(14));
                b15.setText(list.get(15));
            case 14: a12.setVisibility(View.VISIBLE);
                a13.setVisibility(View.VISIBLE);
                b12.setText(list.get(12));
                b13.setText(list.get(13));
            case 12: a10.setVisibility(View.VISIBLE);
                a11.setVisibility(View.VISIBLE);
                b10.setText(list.get(10));
                b11.setText(list.get(11));
            case 10: a8.setVisibility(View.VISIBLE);
                a9.setVisibility(View.VISIBLE);
                b8.setText(list.get(8));
                b9.setText(list.get(9));
            case 8: a6.setVisibility(View.VISIBLE);
                a7.setVisibility(View.VISIBLE);
                b6.setText(list.get(6));
                b7.setText(list.get(7));
            case 6: a4.setVisibility(View.VISIBLE);
                a5.setVisibility(View.VISIBLE);
                b4.setText(list.get(4));
                b5.setText(list.get(5));
            case 4: a0.setVisibility(View.VISIBLE);
                a1.setVisibility(View.VISIBLE);
                a2.setVisibility(View.VISIBLE);
                a3.setVisibility(View.VISIBLE);
                b0.setText(list.get(0));
                b1.setText(list.get(1));
                b2.setText(list.get(2));
                b3.setText(list.get(3));
                break;
        }

    }
*/

/*
    public MemoryGameActivity() {
        MemoryGame game = new MemoryGame(20);
        ArrayList<String> list = game.getBoard();
        //buildMemoryBoard(20, list);
        a0.setVisibility(View.VISIBLE);
    }

    public void buildMemoryBoard(int size, ArrayList<String> list ) {

        //reverse waterfall switch statement implementation to save code and time
        switch (size) {
            case 20: a18.setVisibility(View.VISIBLE);
                a19.setVisibility(View.VISIBLE);
                b19.setText(list.get(19));
                b18.setText(list.get(18));
            case 18: a16.setVisibility(View.VISIBLE);
                a17.setVisibility(View.VISIBLE);
                b17.setText(list.get(17));
                b16.setText(list.get(16));
            case 16: a14.setVisibility(View.VISIBLE);
                a15.setVisibility(View.VISIBLE);
                b15.setText(list.get(15));
                b14.setText(list.get(14));
            case 14: a12.setVisibility(View.VISIBLE);
                a13.setVisibility(View.VISIBLE);
                b13.setText(list.get(13));
                b12.setText(list.get(12));
            case 12: a10.setVisibility(View.VISIBLE);
                a11.setVisibility(View.VISIBLE);
                b11.setText(list.get(11));
                b10.setText(list.get(10));
            case 10: a8.setVisibility(View.VISIBLE);
                a9.setVisibility(View.VISIBLE);
                b9.setText(list.get(9));
                b8.setText(list.get(8));
            case 8: a6.setVisibility(View.VISIBLE);
                a7.setVisibility(View.VISIBLE);
                b7.setText(list.get(7));
                b6.setText(list.get(6));
            case 6: a4.setVisibility(View.VISIBLE);
                a5.setVisibility(View.VISIBLE);
                b5.setText(list.get(5));
                b4.setText(list.get(4));
            case 4: a0.setVisibility(View.VISIBLE);
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
*/

}

















    /*
    //Clears entire board for next game -- cards and words
    public void resetBoard() {
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


    public void buildMemoryBoard(int size, String[] list ) {

        //reverse waterfall switch statement implementation to save code and time
        switch (size) {
            case 20: a18.setVisibility(View.VISIBLE);
                a19.setVisibility(View.VISIBLE);
                b18.setText(list[19]);
                b19.setText(list[18]);
            case 18: a16.setVisibility(View.VISIBLE);
                a17.setVisibility(View.VISIBLE);
                b17.setText(list[17]);
                b16.setText(list[16]);
            case 16: a14.setVisibility(View.VISIBLE);
                a15.setVisibility(View.VISIBLE);
                b15.setText(list[15]);
                b14.setText(list[14]);
            case 14: a12.setVisibility(View.VISIBLE);
                a13.setVisibility(View.VISIBLE);
                b13.setText(list[13]);
                b12.setText(list[12]);
            case 12: a10.setVisibility(View.VISIBLE);
                a11.setVisibility(View.VISIBLE);
                b11.setText(list[11]);
                b10.setText(list[10]);
            case 10: a8.setVisibility(View.VISIBLE);
                a9.setVisibility(View.VISIBLE);
                b9.setText(list[9]);
                b8.setText(list[8]);
            case 8: a6.setVisibility(View.VISIBLE);
                a7.setVisibility(View.VISIBLE);
                b7.setText(list[7]);
                b6.setText(list[6]);
            case 6: a4.setVisibility(View.VISIBLE);
                a5.setVisibility(View.VISIBLE);
                b5.setText(list[5]);
                b4.setText(list[4]);
            case 4: a0.setVisibility(View.VISIBLE);
                a1.setVisibility(View.VISIBLE);
                a2.setVisibility(View.VISIBLE);
                a3.setVisibility(View.VISIBLE);
                b3.setText(list[3]);
                b2.setText(list[2]);
                b1.setText(list[1]);
                b0.setText(list[0]);
                break;
        }

    }



    public void setAllCardsVisible() {


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
*/













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
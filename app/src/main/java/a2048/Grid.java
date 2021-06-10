package a2048;

import android.view.View;

import com.example.a2048.R;

/**
 *
 */
public class Grid {
    private int Score;

    public Tile[] tiles;
    public View grid;
    public final int UP = 0;
    public final int END = 1;
    public final int DOWN = 2;
    public final int START = 3;

    public void NewGrid(MainActivity context) {
        tiles = new Tile[16];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile(0, "textView" + i, context);
        }
    }

    public Grid(MainActivity context){
        grid = context.findViewById(R.id.grid);
        NewGrid(context);
    }

    public void UpdateGrid() {
    }

    public void UpdateScore() {
    }

    public void SendScore() {
    }

    /**
     * @return Score
     */
    public int getScore() {
        return Score;
    }

    /**
     * @param score set Score of the game
     */
    public void setScore(int score) {
        Score = score;
    }

    public void modifyGrid(int direction) {
        System.out.println("swipe detected");
        System.out.println(direction);
    }
}

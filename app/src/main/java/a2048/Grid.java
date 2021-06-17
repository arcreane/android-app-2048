package a2048;

import android.view.View;

import com.example.a2048.R;

import java.util.Arrays;
import java.util.Random;

/**
 *
 */
public class Grid {

    public Tile[][] tiles;
    public View grid;
    public final int UP = 0;
    public final int END = 1;
    public final int DOWN = 2;
    public final int START = 3;

    public void NewGrid(MainActivity context) {

        tiles = new Tile[4][4];
        int cpt = 1;
        for (int i = 1; i <= tiles.length; i++) {
            for (int y = 1; y <= tiles[i - 1].length; y++) {
                tiles[i - 1][y - 1] = new Tile(0, "textView" + cpt, context);
                cpt++;
            }
        }
        tiles[this.GetRandomNbr(0, 1)][this.GetRandomNbr(0, 1)].changeValue((int) Math.pow(2, this.GetRandomNbr(1, 2)));
        tiles[this.GetRandomNbr(2, 3)][this.GetRandomNbr(2, 3)].changeValue((int) Math.pow(2, this.GetRandomNbr(1, 2)));
    }

    public Grid(MainActivity context) {
        grid = context.findViewById(R.id.grid);
        NewGrid(context);
    }

    public int GetRandomNbr(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public void UpdateGrid() {
    }

    public void modifyGrid(int direction) {
        System.out.println("swipe detected");
        System.out.println(direction);

    }
}

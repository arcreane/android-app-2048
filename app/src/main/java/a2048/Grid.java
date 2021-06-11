package a2048;

import android.view.View;

import com.example.a2048.R;

import java.util.Random;

import a2048.tools.SWIPE;

/**
 *
 */
public class Grid {
    private int Score;

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

    public void UpdateScore() {
    }

    public void SendScore(int value) {
        this.setScore(value);
    }

    /**
     * @return Score
     */
    public int getScore() {
        return this.Score;
    }

    /**
     * @param score set Score of the game
     */
    public void setScore(int score) {
        this.Score = score;
    }

    public void modifyGrid(int direction) {
        System.out.println("swipe detected");
        System.out.println(direction);

    }

    public void checkCase(int x, int y, SWIPE swipe) {

        if (swipe.getDirection().equals("right") || swipe.getDirection().equals("left")) {
            if (y + swipe.getValue() != this.tiles[x].length && y + swipe.getValue() >= 0) {
                if (this.checkActionRightLeft(x, y, swipe.getValue())) {
                    this.checkCase(x, y + swipe.getValue(), swipe);
                }
            }
        } else {
            if (x + swipe.getValue() != this.tiles.length && x + swipe.getValue() >= 0){
                System.out.println("y = " + y + " x = " + x + " swipe = "+swipe.getValue());
                if (this.checkActionUpDown(x, y, swipe.getValue())) {
                    this.checkCase(x + swipe.getValue(), y, swipe);
                }
            }

        }

    }

    private boolean checkActionRightLeft(int x, int y, int direction) {
        System.out.println("right left " + (y + direction) + " " + this.tiles[x][y + direction].getValue());
        if (this.tiles[x][y + direction].getValue() == 0 || this.tiles[x][y + direction].getValue() == this.tiles[x][y].getValue()) {
            System.out.println("je passe");
            return this.changeValueRightLeft(x, y, direction);
        }
        return false;
    }

    private boolean checkActionUpDown(int x, int y, int direction) {
        System.out.println("up  down " + (x + direction));
        if (this.tiles[x + direction][y].getValue() == 0 || this.tiles[x + direction][y].getValue() == this.tiles[x][y].getValue()) {
            return this.changeValueUpDown(x, y, direction);
        }
        return false;
    }


    private boolean changeValueRightLeft(int x, int y, int direction) {
        this.tiles[x][y + direction].changeValue(this.tiles[x][y].getValue());
        this.tiles[x][y].resetValue();
        return true;
    }

    private boolean changeValueUpDown(int x, int y, int direction) {
        this.tiles[x + direction][y].changeValue(this.tiles[x][y].getValue());
        this.tiles[x][y].resetValue();
        return true;
    }
}


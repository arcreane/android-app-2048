package a2048;

import android.view.View;

import com.example.a2048.R;

import java.util.ArrayList;
import java.util.Random;

import a2048.tools.SWIPE;

/**
 *
 */
public class Grid implements Subject{

    public Tile[][] tiles;
    public View grid;

    public ArrayList<ScoreObserver> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<ScoreObserver> observers) {
        this.observers = observers;
    }

    private ArrayList<ScoreObserver> observers;
    public void NewGrid(MainActivity context) {

        tiles = new Tile[4][4];
        int cpt = 1;
        for (int i = 1; i <= tiles.length; i++) {
            for (int y = 1; y <= tiles[i - 1].length; y++) {
                tiles[i - 1][y - 1] = new Tile(0, "textView" + cpt, context);
                cpt++;
            }
        }
        this.createRandomTile();
        this.createRandomTile();
    }

    public Grid(MainActivity context) {
        this.observers = new ArrayList<>();
        grid = context.findViewById(R.id.grid);
        NewGrid(context);
    }

    public int GetRandomNbr(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
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
                if (this.checkActionUpDown(x, y, swipe.getValue())) {
                    this.checkCase(x + swipe.getValue(), y, swipe);
                }
            }

        }

    }

    private boolean checkActionRightLeft(int x, int y, int direction) {
        if (this.tiles[x][y + direction].getValue() == 0 || this.tiles[x][y + direction].getValue() == this.tiles[x][y].getValue()) {
            return this.changeValueRightLeft(x, y, direction);
        }
        return false;
    }

    private boolean checkActionUpDown(int x, int y, int direction) {
        if (this.tiles[x + direction][y].getValue() == 0 || this.tiles[x + direction][y].getValue() == this.tiles[x][y].getValue()) {
            return this.changeValueUpDown(x, y, direction);
        }
        return false;
    }


    private boolean changeValueRightLeft(int x, int y, int direction) {
        boolean fusion = this.tiles[x][y + direction].getValue() != 0;

        this.tiles[x][y + direction].changeValue(this.tiles[x][y].getValue());
        this.tiles[x][y].resetValue();
        if (fusion) {
            this.notifyObserver(this.tiles[x][y + direction].getValue());
        }
        return true;
    }

    private boolean changeValueUpDown(int x, int y, int direction) {
        boolean fusion = this.tiles[x + direction][y].getValue() != 0;
        this.tiles[x + direction][y].changeValue(this.tiles[x][y].getValue());
        this.tiles[x][y].resetValue();
        if (fusion) {
            this.notifyObserver(this.tiles[x + direction][y].getValue());
        }
        return true;
    }

    public void createRandomTile() {
        int value = 0;
        int x = 0;
        int y = 0;
        do {
            x = this.GetRandomNbr(0, 3);
            y = this.GetRandomNbr(0, 3);
            value = tiles[x][y].getValue();
        } while (value != 0);
        tiles[x][y].changeValue((int) Math.pow(2, this.GetRandomNbr(1, 2)));
    }

    @Override
    public void registerObserver(ScoreObserver scoreObserver) {
        this.getObservers().add(scoreObserver);
    }

    @Override
    public void notifyObserver(int newScore) {
        for (ScoreObserver observer: observers) {
            observer.onCaseFusion(newScore);
        }
    }
}


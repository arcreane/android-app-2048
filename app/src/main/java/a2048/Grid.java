package a2048;

import android.view.View;

import com.example.a2048.R;

import java.util.ArrayList;
import java.util.Random;

import a2048.tools.SWIPE;

/**
 * The type Grid.
 */
public class Grid implements Subject {

    private Tile[][] tiles;
    private View grid;
    private ArrayList<ScoreObserver> observers;

    /**
     * Instantiates a new Grid.
     *
     * @param context the context
     */
    public Grid(MainActivity context) {
        this.observers = new ArrayList<>();
        grid = context.findViewById(R.id.grid);
        NewGrid(context);
    }

    /**
     * New grid.
     *
     * @param context the context
     */
    public void NewGrid(MainActivity context) {

        setTiles(new Tile[4][4]);
        int cpt = 1;
        for (int i = 1; i <= this.getTiles().length; i++) {
            for (int y = 1; y <= this.getTiles()[i - 1].length; y++) {
                this.getTiles()[i - 1][y - 1] = new Tile(0, "textView" + cpt, context);
                cpt++;
            }
        }
        this.createRandomTile();
        this.createRandomTile();
    }

    /**
     * Get random nbr int.
     *
     * @param min the min
     * @param max the max
     * @return the int
     */
    public int GetRandomNbr(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    /**
     * Check case.
     *
     * @param x     the x
     * @param y     the y
     * @param swipe the swipe
     */
    public void checkCase(int x, int y, SWIPE swipe) {

        if (swipe.getDirection().equals("right") || swipe.getDirection().equals("left")) {
            if (y + swipe.getValue() != this.getTiles()[x].length && y + swipe.getValue() >= 0) {
                if (this.checkActionRightLeft(x, y, swipe.getValue())) {
                    this.checkCase(x, y + swipe.getValue(), swipe);
                }
            }
        } else {
            if (x + swipe.getValue() != this.getTiles().length && x + swipe.getValue() >= 0) {
                if (this.checkActionUpDown(x, y, swipe.getValue())) {
                    this.checkCase(x + swipe.getValue(), y, swipe);
                }
            }

        }

    }

    private boolean checkActionRightLeft(int x, int y, int direction) {
        if (this.getTiles()[x][y + direction].getValue() == 0 || this.getTiles()[x][y + direction].getValue() == this.getTiles()[x][y].getValue()) {
            return this.changeValueRightLeft(x, y, direction);
        }
        return false;
    }

    private boolean checkActionUpDown(int x, int y, int direction) {
        if (this.getTiles()[x + direction][y].getValue() == 0 || this.getTiles()[x + direction][y].getValue() == this.getTiles()[x][y].getValue()) {
            return this.changeValueUpDown(x, y, direction);
        }
        return false;
    }

    private boolean changeValueRightLeft(int x, int y, int direction) {
        boolean fusion = this.getTiles()[x][y + direction].getValue() != 0;

        this.getTiles()[x][y + direction].changeValue(this.getTiles()[x][y].getValue());
        this.getTiles()[x][y].resetValue();
        if (fusion) {
            this.notifyObserver(this.getTiles()[x][y + direction].getValue());
        }
        return true;
    }

    private boolean changeValueUpDown(int x, int y, int direction) {
        boolean fusion = this.getTiles()[x + direction][y].getValue() != 0;
        this.getTiles()[x + direction][y].changeValue(this.getTiles()[x][y].getValue());
        this.getTiles()[x][y].resetValue();
        if (fusion) {
            this.notifyObserver(this.getTiles()[x + direction][y].getValue());
        }
        return true;
    }

    /**
     * Create random tile.
     */
    public void createRandomTile() {
        int value;
        int x;
        int y;
        do {
            x = this.GetRandomNbr(0, 3);
            y = this.GetRandomNbr(0, 3);
            value = this.getTiles()[x][y].getValue();
        } while (value != 0);
        this.getTiles()[x][y].changeValue((int) Math.pow(2, this.GetRandomNbr(1, 2)));
    }

    @Override
    public void registerObserver(ScoreObserver scoreObserver) {
        this.getObservers().add(scoreObserver);
    }

    @Override
    public void notifyObserver(int newScore) {
        for (ScoreObserver observer : observers) {
            observer.onCaseFusion(newScore);
        }
    }

    /**
     * Reset table boolean.
     *
     * @return the boolean
     */
    public boolean resetTable() {
        for (int i = 0; i < this.getTiles().length; i++) {
            for (int y = 0; y < this.getTiles()[i].length; y++) {
                this.getTiles()[i][y].resetValue();
            }
        }
        this.createRandomTile();
        this.createRandomTile();

        return true;
    }

    /**
     * Get tiles tile [ ] [ ].
     *
     * @return the tile [ ] [ ]
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * Sets tiles.
     *
     * @param tiles the tiles
     */
    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    /**
     * Gets grid.
     *
     * @return the grid
     */
    public View getGrid() {
        return grid;
    }

    /**
     * Sets grid.
     *
     * @param grid the grid
     */
    public void setGrid(View grid) {
        this.grid = grid;
    }

    /**
     * Gets observers.
     *
     * @return the observers
     */
    public ArrayList<ScoreObserver> getObservers() {
        return observers;
    }

    /**
     * Sets observers.
     *
     * @param observers the observers
     */
    public void setObservers(ArrayList<ScoreObserver> observers) {
        this.observers = observers;
    }
}


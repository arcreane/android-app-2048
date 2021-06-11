package a2048;

import a2048.tools.SWIPE;

/**
 *
 */


public class Game {

    public
    Grid grid;

    public Game(MainActivity context) {
        StartGame(context);
    }

    public void StartGame(MainActivity context) {
        this.grid = new Grid(context);
    }

    public void swipe(SWIPE swipe) {
        if (swipe.getDirection().equals("right") || swipe.getDirection().equals("down")) {
            for (int i = this.grid.tiles.length - 1; i >= 0; i--) {
                for (int y = this.grid.tiles[i].length -1; y >= 0; y--) {
                    this.grid.checkCase(i, y, swipe);
                }
            }
        } else {
            for (int i = 0; i < this.grid.tiles.length; i++) {
                for (int y = 0; y < this.grid.tiles[i].length; y++) {
                    this.grid.checkCase(i, y, swipe);
                }
            }
        }
    }

    public void EndGame() {

    }
}

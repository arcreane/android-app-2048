package a2048;

import a2048.tools.SWIPE;

/**
 *
 */
public class Game {


    public Game(MainActivity context) {
        StartGame(context);
    }

    public void StartGame(MainActivity context) {
        this.grid = new Grid(context);
        new Grid(context);
        this.SendScore(18);
        this.SendScore(89);
        this.SendScore(256);
    }

    public void swipeRight()
    {

    }
    public void EndGame() {

    }
}

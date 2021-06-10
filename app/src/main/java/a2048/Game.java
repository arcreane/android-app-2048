package a2048;

import android.content.Context;

/**
 *
 */
public class Game {
    public Game(MainActivity context) {
        StartGame(context);
    }

    public void StartGame(MainActivity context) {
        new Grid(context);
    }

    public void EndGame() {

    }
}

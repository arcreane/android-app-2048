package a2048;

import android.content.Context;

import androidx.core.view.GestureDetectorCompat;

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

    public void swipeRight()
    {

    }
    public void EndGame() {

    }
}

package a2048;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.a2048.R;
import a2048.tools.OnSwipeTouchListener;

/**
 *
 */
public class Grid extends Activity {
    private int Score;

    public MainActivity context;
    public final int UP = 0;
    public final int END = 1;
    public final int DOWN = 2;
    public final int START = 3;

    public void NewGrid() {

    }

    public void Swipe() {
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

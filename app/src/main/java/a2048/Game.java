package a2048;

import android.widget.TextView;

import com.example.a2048.R;

import java.text.MessageFormat;

import a2048.tools.SWIPE;

/**
 *
 */


public class Game implements ScoreObserver {
    private Grid grid;
    private User user;
    private int Score;
    private MainActivity context;
    public Game(MainActivity context, User user) {
        this.setContext(context);
        this.setScore(0);
        this.setUser(user);
        StartGame(context);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MainActivity getContext() {
        return context;
    }

    public void setContext(MainActivity context) {
        this.context = context;
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
        TextView textScore = this.getContext().findViewById(R.id.score);
        textScore.setText(MessageFormat.format("Score: {0}", score));
        this.Score = score;

    }

    public void StartGame(MainActivity context) {
        this.setGrid(new Grid(context));
        this.getGrid().registerObserver(this);
    }

    public void swipe(SWIPE swipe) {
        if (swipe.getDirection().equals("right") || swipe.getDirection().equals("down")) {
            for (int i = this.getGrid().getTiles().length - 1; i >= 0; i--) {
                for (int y = this.getGrid().getTiles()[i].length - 1; y >= 0; y--) {
                    this.getGrid().checkCase(i, y, swipe);
                }
            }
        } else {
            for (int i = 0; i < this.grid.getTiles().length; i++) {
                for (int y = 0; y < this.grid.getTiles()[i].length; y++) {
                    this.getGrid().checkCase(i, y, swipe);
                }
            }
        }
        this.getGrid().createRandomTile();
    }

    public void EndGame() {
        this.SendScore(this.getScore());
        this.getGrid().resetTable();
    }


    public void UpdateScore(int score) {
        this.setScore(this.getScore() + score);
    }

    public void SendScore(int score) {
        this.getUser().setNewScore(score);
        this.setScore(0);
    }

    @Override
    public void onCaseFusion(int newScore) {
        this.UpdateScore(newScore);
    }
}

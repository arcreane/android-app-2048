package a2048;

import android.widget.TextView;

import com.example.a2048.R;

import java.text.MessageFormat;

import a2048.tools.SWIPE;

/**
 *
 */


public class Game implements ScoreObserver {
    public Grid grid;
    private User user;
    private int Score;
    private MainActivity context;

    public Game(MainActivity context, User user) {
        this.setContext(context);
        this.setScore(0);
        this.setUser(user);
        StartGame(context);
    }

    public MainActivity getContext() {
        return context;
    }

    public void setContext(MainActivity context) {
        this.context = context;
    }

    public void StartGame(MainActivity context) {
        this.grid = new Grid(context);
        this.grid.registerObserver(this);
    }

    public void swipe(SWIPE swipe) {
        if (swipe.getDirection().equals("right") || swipe.getDirection().equals("down")) {
            for (int i = this.grid.tiles.length - 1; i >= 0; i--) {
                for (int y = this.grid.tiles[i].length - 1; y >= 0; y--) {
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
        this.grid.createRandomTile();
    }

    public void EndGame() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void UpdateScore(int score) {
        this.setScore(this.getScore() + score);
    }

    public void SendScore(int score) {
        this.getUser().setNewScore(score);
        this.setScore(0);
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

    @Override
    public void onCaseFusion(int newScore) {
        this.UpdateScore(newScore);
    }
}

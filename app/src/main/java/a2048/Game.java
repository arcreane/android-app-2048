package a2048;

import android.widget.TextView;
import android.widget.Toast;

import com.example.a2048.R;

import java.text.MessageFormat;

import a2048.tools.SWIPE;

/**
 * The type Game.
 */


public class Game implements ScoreObserver {
    private Grid grid;
    private User user;
    private int Score;
    private MainActivity context;

    /**
     * Instantiates a new Game.
     *
     * @param context the context
     * @param user    the user
     */
    public Game(MainActivity context, User user) {
        this.setContext(context);
        this.setScore(0);
        this.setUser(user);
        StartGame(context);
    }

    /**
     * Start game.
     *
     * @param context the context
     */
    public void StartGame(MainActivity context) {
        this.setGrid(new Grid(context));
        this.getGrid().registerObserver(this);
    }

    /**
     * Swipe.
     *
     * @param swipe the swipe
     */
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

    /**
     * End game.
     */
    public void EndGame() {
        this.SendScore(this.getScore());
        if (this.getGrid().resetTable()) {
            this.sendToastMessage("Start new Game");
        }
    }

    /**
     * Send toast message.
     *
     * @param message the message
     */
    public void sendToastMessage(String message) {
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this.getContext(), message, duration);
        toast.show();
    }

    /**
     * Update score.
     *
     * @param score the score
     */
    public void UpdateScore(int score) {
        this.setScore(this.getScore() + score);
    }

    /**
     * Send score.
     *
     * @param score the score
     */
    public void SendScore(int score) {
        this.getUser().setNewScore(score);
        this.setScore(0);
    }

    @Override
    public void onCaseFusion(int newScore) {
        this.UpdateScore(newScore);
    }

    /**
     * Gets grid.
     *
     * @return the grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Sets grid.
     *
     * @param grid the grid
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public MainActivity getContext() {
        return context;
    }

    /**
     * Sets context.
     *
     * @param context the context
     */
    public void setContext(MainActivity context) {
        this.context = context;
    }

    /**
     * Gets score.
     *
     * @return Score score
     */
    public int getScore() {
        return this.Score;
    }

    /**
     * Sets score.
     *
     * @param score set Score of the game
     */
    public void setScore(int score) {
        TextView textScore = this.getContext().findViewById(R.id.score);
        textScore.setText(MessageFormat.format("Score: {0}", score));
        this.Score = score;

    }
}

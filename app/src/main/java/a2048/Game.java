package a2048;

import a2048.tools.SWIPE;

/**
 *
 */


public class Game {
    private User user;
    private int Score;

    public
    Grid grid;

    public Game(MainActivity context, User user) {
        this.setUser(user);
        StartGame(context);
    }

    public void StartGame(MainActivity context) {
        new Grid(context);
        this.SendScore(18);
        this.SendScore(89);
        this.SendScore(256);
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

    public User getUser() {
        return user;
    }

    public void UpdateScore(int score) {
        this.setScore(this.getScore() + score);
        this.SendScore(this.getScore());
    }

    public void SendScore(int score) {
        this.getUser().setNewScore(score);
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
        this.Score = score;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

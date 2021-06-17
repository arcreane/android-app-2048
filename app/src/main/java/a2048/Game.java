package a2048;
/**
 *
 */
public class Game {
    private User user;
    private int Score;


    public Game(MainActivity context, User user) {
        this.setUser(user);
        StartGame(context);
    }

    public void StartGame(MainActivity context) {
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

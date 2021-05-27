package a2048;

/**
 *
 */
public class User {
    private String Pseudo;
    private int[] HighScore;

    /**
     * @param HighScore ranking the best score of the user
     */
    public User(int[] HighScore) {

    }

    public void DisplayHighScore() {
    }

    public void SendScore() {
    }

    public void OrderHighScore() {
    }

    /**
     * @return String
     */
    public String getPseudo() {
        return Pseudo;
    }

    /**
     * @param pseudo set pseudo of the user
     */
    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    /**
     * @return HighScore
     */
    public int[] getHighScore() {
        return HighScore;
    }

    /**
     * @param highScore set HighScore of the actual user
     */
    public void setHighScore(int[] highScore) {
        HighScore = highScore;
    }
}

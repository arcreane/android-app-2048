package a2048;

/**
 * The type User.
 */
public class User {
    private String Pseudo;
    private int[] HighScore;

    /**
     * Instantiates a new User.
     *
     * @param pseudo the pseudo
     */
    public User(String pseudo) {
        this.setPseudo(pseudo);
        this.setHighScore(new int[0]);
    }

    /**
     * Display high score.
     */
    public void DisplayHighScore() {
    }

    /**
     * Order highScore.
     *
     * @param arrayScore the array score
     */
    public void OrderHighScore(int[] arrayScore) {
        int tmp;
        for (int i = 0; i < arrayScore.length; i++) {
            for (int j = 1; j < (arrayScore.length - i); j++) {
                if (arrayScore[j - 1] > arrayScore[j]) {
                    tmp = arrayScore[j - 1];
                    arrayScore[j - 1] = arrayScore[j];
                    arrayScore[j] = tmp;
                }
            }
        }
        this.setHighScore(arrayScore);
    }

    /**
     * Gets pseudo.
     *
     * @return String pseudo
     */
    public String getPseudo() {
        return Pseudo;
    }

    /**
     * Sets pseudo.
     *
     * @param pseudo set pseudo of the user
     */
    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    /**
     * Get high score int [ ].
     *
     * @return HighScore int [ ]
     */
    public int[] getHighScore() {
        return HighScore;
    }

    /**
     * Sets high score.
     *
     * @param highScore set HighScore of the actual user
     */
    public void setHighScore(int[] highScore) {
        HighScore = highScore;
    }

    /**
     * Sets new score.
     *
     * @param score the score
     */
    public void setNewScore(int score) {
        int length = this.getHighScore().length;
        int[] arrayScore = new int[length + 1];

        arrayScore[length] = score;
        for (int i = 0; i < length; i++) {
            arrayScore[i] = this.getHighScore()[i];
        }
        this.OrderHighScore(arrayScore);
    }
}

package a2048;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.example.a2048.R;

/**
 * The type User.
 */
public class User {
    private String Pseudo;
    private int[] HighScore;
    private MainActivity context;

    public User(MainActivity context) {
        this.setHighScore(new int[0]);
        this.setContext(context);
    }

    public void changePseudo(String pseudo) {
        this.setPseudo(pseudo);
        EditText PseudoTextView = this.getContext().findViewById(R.id.pseudo);
        PseudoTextView.setText(this.getPseudo());
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

    public MainActivity getContext() {
        return context;
    }

    public void setContext(MainActivity context) {
        this.context = context;
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
        SharedPreferences mPrefs = this.getContext().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("Pseudo", pseudo);
        prefsEditor.apply();
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
}

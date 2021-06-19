package a2048;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

/**
 * The type High score dialog fragment.
 */
public class HighScoreDialogFragment extends DialogFragment {
    private int[] highScore;

    /**
     * Instantiates a new High score dialog fragment.
     *
     * @param highScore the high score
     */
    public HighScoreDialogFragment(int[] highScore) {
        this.setHighScore(highScore);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(this.HighScoreTableBuilder().equals("Score: \n") ? "No Score register yet :(" : this.HighScoreTableBuilder())
                .setPositiveButton("Wow, this is incredible!", (dialog, id) -> {
                });
        return builder.create();
    }

    private String HighScoreTableBuilder() {
        StringBuilder HighScoreTable = new StringBuilder();
        HighScoreTable.append("Score: \n");
        for (int i = this.getHighScore().length; i > 0; i--) {
            HighScoreTable.append(this.getHighScore()[i - 1]).append("\n");
        }
        return HighScoreTable.toString();
    }

    /**
     * Get high score int [ ].
     *
     * @return the int [ ]
     */
    public int[] getHighScore() {
        return highScore;
    }

    /**
     * Sets high score.
     *
     * @param highScore the high score
     */
    public void setHighScore(int[] highScore) {
        this.highScore = highScore;
    }


}
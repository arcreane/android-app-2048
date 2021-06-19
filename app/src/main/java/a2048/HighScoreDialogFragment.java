package a2048;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class HighScoreDialogFragment extends DialogFragment {
    private int[] highScore;

    public HighScoreDialogFragment(int[] highScore) {
        this.setHighScore(highScore);
    }

    public int[] getHighScore() {
        return highScore;
    }

    public void setHighScore(int[] highScore) {
        this.highScore = highScore;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(this.HighScoreTableBuilder().equals("") ? "No Score register yet :(" : this.HighScoreTableBuilder())
                .setPositiveButton("Wow, this is incredible!", (dialog, id) -> {
                });
        return builder.create();
    }

    private String HighScoreTableBuilder() {
        StringBuilder HighScoreTable = new StringBuilder();
        for (int i : this.getHighScore()) {
            HighScoreTable.append(getHighScore()[i]);
        }
        return HighScoreTable.toString();
    }


}
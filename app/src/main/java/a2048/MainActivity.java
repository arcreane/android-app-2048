package a2048;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import com.example.a2048.R;

import java.util.Objects;

import a2048.tools.MyGestureListener;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat MDetector;
    private Game game;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(this.getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setGame(new Game(this, this.initUser()));
        MDetector = new GestureDetectorCompat(this, new MyGestureListener(this.getGame()));
        this.setMDetector(MDetector);
    }

    private User initUser() {
        User user = new User(this);
        SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        String pseudo = mPrefs.getString("Pseudo", "");
        user.changePseudo(pseudo.equals("") ? "undefined" : pseudo);
        this.setUser(user);
        this.pseudoChangeListener();
        return user;
    }

    private void pseudoChangeListener() {
        EditText PseudoTextView = findViewById(R.id.pseudo);
        User currentUser = this.getUser();

        PseudoTextView.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentUser.setPseudo(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

    protected void resetGame() {
        this.getGame().EndGame();
    }

    protected void showHighScore() {
        HighScoreDialogFragment HighScoreModal = new HighScoreDialogFragment(this.getUser().getHighScore());
        HighScoreModal.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.getMDetector().onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    protected GestureDetectorCompat getMDetector() {
        return MDetector;
    }

    protected void setMDetector(GestureDetectorCompat MDetector) {
        this.MDetector = MDetector;
    }

    protected Game getGame() {
        return game;
    }

    protected void setGame(Game game) {
        this.game = game;
    }

    protected User getUser() {
        return user;
    }

    protected void setUser(User user) {
        this.user = user;
    }

}

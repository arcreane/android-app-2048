package a2048;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import com.example.a2048.R;

import a2048.tools.MyGestureListener;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat MDetector;
    private Game game;
    private User user;

    public GestureDetectorCompat getMDetector() {
        return MDetector;
    }

    public void setMDetector(GestureDetectorCompat MDetector) {
        this.MDetector = MDetector;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setGame(new Game(this, this.initUser()));
        MDetector = new GestureDetectorCompat(this, new MyGestureListener(this.getGame()));
        this.setMDetector(MDetector);
    }

    private User initUser() {
        User user = new User("DomLeBoss");
        this.setUser(user);
        TextView PseudoTextView = findViewById(R.id.pseudo);
        PseudoTextView.setText(user.getPseudo());
        return user;
    }

    public void resetGame(View button) {
        this.getGame().EndGame();
    }

    public void showHighScore(View TextView) {
        HighScoreDialogFragment HighScoreModal = new HighScoreDialogFragment(this.getUser().getHighScore());
        HighScoreModal.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.getMDetector().onTouchEvent(event);
        return super.onTouchEvent(event);
    }

}

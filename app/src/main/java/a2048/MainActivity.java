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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setGame(new Game(this, this.initUser()));
        MDetector = new GestureDetectorCompat(this, new MyGestureListener(this.getGame()));
    }

    private User initUser() {
        User user = new User("DomLeBoss");
        TextView PseudoTextView = findViewById(R.id.pseudo);
        PseudoTextView.setText(user.getPseudo());
        return user;
    }

    public void resetGame(View button) {
        this.getGame().EndGame();
    }

    public void showHighScore(View TextView) {
        HighScoreDialogFragment HighScoreModal = new HighScoreDialogFragment();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.getMDetector().onTouchEvent(event);
        return super.onTouchEvent(event);
    }


}

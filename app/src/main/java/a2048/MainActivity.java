package a2048;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import com.example.a2048.R;

import a2048.tools.MyGestureListener;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener(new Game(this)));
        this.initUser();
        System.out.println("elem");
    }

    private void initUser() {
        User user = new User();
        TextView button2 = findViewById(R.id.pseudo);
        button2.setText(user.getPseudo());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


}

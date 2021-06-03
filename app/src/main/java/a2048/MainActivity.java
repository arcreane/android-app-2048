package a2048;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2048.R;

import a2048.tools.OnSwipeTouchListener;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initUser();
        new OnSwipeTouchListener(this, new Grid());
        System.out.println("elem");
    }

    private void initUser() {
        User user = new User();
        TextView button2 = (TextView) findViewById(R.id.pseudo);
        button2.setText(user.getPseudo());
    }
}

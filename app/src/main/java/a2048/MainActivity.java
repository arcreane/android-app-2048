package a2048;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2048.R;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initUser();
    }

    private void initUser(){
        User user = new User();
        TextView button2 = (TextView)findViewById(R.id.pseudo);
        button2.setText(user.getPseudo());
    }
}

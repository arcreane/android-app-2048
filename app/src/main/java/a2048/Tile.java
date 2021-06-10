package a2048;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.a2048.R;

public class Tile {
    public int Value;
    public String id;
    public TextView tile;
    public String color;

    public Tile(int value, String id, MainActivity context) {
        super();
        Value = value;
        this.id = id;
        updateTileUi(context);
    }

    public void updateTileUi(MainActivity context) {
        int nbr = context.getResources().getIdentifier(this.id, "id", context.getPackageName());
        this.tile = context.findViewById(nbr);
        this.tile.setText(this.id);
    }
}

package a2048;

import android.widget.TextView;

public class Tile {
    public int value;
    public String id;
    public TextView tile;
    public String color;

    public Tile(int value, String id, MainActivity context) {
        super();
        this.value = value;
        this.id = id;
        int nbr = context.getResources().getIdentifier(this.id, "id", context.getPackageName());
        this.tile = context.findViewById(nbr);
    }

    public void updateTileUi(MainActivity context) {
       //this.tile.setBackgroundColor();
        this.tile.setText(this.value);
    }

}

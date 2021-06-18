package a2048;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.widget.TextView;

enum Range {
    MIN("C0B0A1"),
    MAX("e92406");
    public final String value;

    Range(String value) {
        this.value = value;
    }
}

public class Tile {
    public String id;
    public TextView tile;
    public String color;
    private int value;

    public Tile(int value, String id, MainActivity context) {
        super();
        this.value = value;
        this.id = id;
        int nbr = context.getResources().getIdentifier(this.id, "id", context.getPackageName());
        this.tile = context.findViewById(nbr);
        this.updateTileUi();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TextView getTile() {
        return tile;
    }

    public void setTile(TextView tile) {
        this.tile = tile;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @SuppressLint("SetTextI18n")
    public void updateTileUi() {
        //this.tile.setBackgroundColor(this.updateColorBackground());
        this.tile.setText(Integer.toString(this.value));
    }

    public void changeValue(int value) {
        this.value += value;
        this.updateTileUi();
    }

    public void resetValue(){
        this.setValue(0);
        this.updateTileUi();
    }

    private int updateColorBackground() {
        return (Integer) new ArgbEvaluator().evaluate((float) 0.5, Range.MAX.value, Range.MIN.value);
    }

}

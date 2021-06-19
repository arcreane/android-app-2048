package a2048;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
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

    @SuppressLint("SetTextI18n")
    public void updateTileUi() {
        // this.tile.setBackgroundColor(this.updateColorBackground());
        if (this.value == 0) {
            this.tile.setText("");
            this.tile.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C0B0A1")));
        } else {
            String s = String.valueOf(this.value);
            this.tile.setText(Integer.toString(this.value));
            float factor = Float.parseFloat("0." + s + "f");
            System.out.println("COlLOR = " + factor);
            //this.tile.getBackgroundTintList().
            this.tile.setBackgroundTintList(ColorStateList.valueOf(this.darkenColor(this.tile.getBackgroundTintList().getDefaultColor(), factor)));
        }
    }

    public void changeValue(int value) {
        this.value += value;
        this.updateTileUi();
    }

    public void resetValue() {
        this.setValue(0);
        this.updateTileUi();
    }

    private int updateColorBackground() {
        return (Integer) new ArgbEvaluator().evaluate((float) 0.5, Range.MAX.value, Range.MIN.value);
    }

    public int darkenColor(int color, float factor) {

        int a = Color.alpha(color);
        int r = Math.round(Color.red(color) * factor);
        int g = Math.round(Color.green(color) * factor);
        int b = Math.round(Color.blue(color) * factor);
        System.out.println("COLOR = " + Color.argb(a,
                Math.min(r, 255),
                Math.min(g, 255),
                Math.min(b, 255)));
        return Color.argb(a,
                Math.min(r, 255),
                Math.min(g, 255),
                Math.min(b, 255));
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

        this.updateTileUi();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}

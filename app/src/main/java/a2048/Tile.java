package a2048;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.TextView;

/**
 * The type Tile.
 */
public class Tile {
    private TextView tile;
    private int value;

    /**
     * Instantiates a new Tile.
     *
     * @param value   the value
     * @param id      the id
     * @param context the context
     */
    public Tile(int value, String id, MainActivity context) {
        super();
        this.setValue(value);
        int nbr = context.getResources().getIdentifier(id, "id", context.getPackageName());
        this.setTile(context.findViewById(nbr));
        this.updateTileUi();

    }

    /**
     * Update tile ui.
     */
    @SuppressLint("SetTextI18n")
    public void updateTileUi() {
        if (this.getValue() == 0) {
            this.getTile().setText("");
            this.getTile().setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C0B0A1")));
        } else {
            String s = String.valueOf(this.getValue());
            this.getTile().setText(Integer.toString(this.getValue()));
            float factor = Float.parseFloat("0." + s + "f");
            this.getTile().setBackgroundTintList(ColorStateList.valueOf(this.darkenColor(Color.parseColor("#FF4A68"), factor)));
        }
    }
    

    /**
     * Change value.
     *
     * @param value the value
     */
    public void changeValue(int value) {
        this.setValue(this.getValue() + value);
        this.updateTileUi();
    }

    /**
     * Reset value.
     */
    public void resetValue() {
        this.setValue(0);
        this.updateTileUi();
    }

    /**
     * Darken color int.
     *
     * @param color  the color
     * @param factor the factor
     * @return the int
     */
    public int darkenColor(int color, float factor) {

        int a = Color.alpha(color);
        int r = Math.round(Color.red(color) / factor);
        int g = Math.round(Color.green(color) / factor);
        int b = Math.round(Color.blue(color) / factor);
        return Color.argb(a,
                Math.min(r, 255),
                Math.min(g, 255),
                Math.min(b, 255));
    }

    /**
     * Gets tile.
     *
     * @return the tile
     */
    public TextView getTile() {
        return tile;
    }

    /**
     * Sets tile.
     *
     * @param tile the tile
     */
    public void setTile(TextView tile) {
        this.tile = tile;

        this.updateTileUi();
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(int value) {
        this.value = value;
    }


}

package a2048.tools;

/**
 * The enum Swipe.
 */
public enum SWIPE {
    /**
     * Right swipe.
     */
    RIGHT(1, "right"),
    /**
     * Left swipe.
     */
    LEFT(-1, "left"),
    /**
     * Up swipe.
     */
    UP(-1, "up"),
    /**
     * Down swipe.
     */
    DOWN(1, "down");

    private final int value;
    private final String direction;

    SWIPE(int value, String direction) {
        this.value = value;
        this.direction = direction;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public String getDirection() {
        return this.direction;
    }
}

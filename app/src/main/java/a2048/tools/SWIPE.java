package a2048.tools;

public enum SWIPE {
    RIGHT(1, "right"),
    LEFT(-1, "left"),
    UP(-1, "up"),
    DOWN(1, "down");

    private final int value;
    private final String direction;

    SWIPE(int value, String direction) {
        this.value = value;
        this.direction = direction;
    }

    public int getValue() {
        return this.value;
    }

    public String getDirection() {
        return this.direction;
    }
}

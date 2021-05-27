/**
 *
 */
public class Case {
    private int Value;
    private int PosX;
    private int PosY;

    /**
     * @param value Value of the case
     * @param posX Localisation of the case in X axis
     * @param posY Localisation of the case in Y axis
     */
    public Case(int value, int posX, int posY) {
        Value = value;
        PosX = posX;
        PosY = posY;
    }

    /**
     *
     */
    public void InitCase() {

    }

    /**
     *
     */
    public void Fusion() {

    }

    /**
     *
     */
    public void Move() {
    }

    /**
     *
     */
    public void FusionCase() {

    }

    /**
     * @return Value
     */
    public int getValue() {
        return Value;
    }

    /**
     * @param value Set value of the case
     */
    public void setValue(int value) {
        Value = value;
    }

    /**
     * @return PosX of the case
     */
    public int getPosX() {
        return PosX;
    }

    /**
     * @param posX Set X axis of the case
     */
    public void setPosX(int posX) {
        PosX = posX;
    }

    /**
     * @return PosY of the case
     */
    public int getPosY() {
        return PosY;
    }

    /**
     * @param posY Set Y axis of the case
     */
    public void setPosY(int posY) {
        PosY = posY;
    }
}

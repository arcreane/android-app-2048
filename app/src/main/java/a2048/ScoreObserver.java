package a2048;

/**
 * The interface Score observer.
 */
public interface ScoreObserver {
    /**
     * On case fusion.
     *
     * @param newScore the new score
     */
    void onCaseFusion(int newScore);
}

package a2048;

/**
 * The interface Subject.
 */
public interface Subject {
    /**
     * Register observer.
     *
     * @param scoreObserver the score observer
     */
    void registerObserver(ScoreObserver scoreObserver);

    /**
     * Notify observer.
     *
     * @param newScore the new score
     */
    void notifyObserver(int newScore);
}

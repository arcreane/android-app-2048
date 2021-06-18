package a2048;

public interface Subject {
    void registerObserver(ScoreObserver scoreObserver);

    void notifyObserver(int newScore);
}

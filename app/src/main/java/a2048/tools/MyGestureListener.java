package a2048.tools;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import a2048.Game;

public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
    private static final String DEBUG_TAG = "Gestures";
    private static final int SWIPE_THRESHOLD = 5;
    private static final int SWIPE_VELOCITY_THRESHOLD = 5;
    private final Game callbackGame;

    public MyGestureListener(Game callbackGame) {
        this.callbackGame = callbackGame;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
        float diffY = event2.getY() - event1.getY();
        float diffX = event2.getX() - event1.getX();
        if (Math.abs(diffX) > Math.abs(diffY)) {
            if (Math.abs(diffX) > SWIPE_THRESHOLD &&
                    Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    //right
                    callbackGame.swipe(SWIPE.RIGHT);
                } else {
                    Log.d(DEBUG_TAG, "onFling: left");
                    callbackGame.swipe(SWIPE.LEFT);
                }
            }
        } else {
            if (Math.abs(diffY) > SWIPE_THRESHOLD &&
                    Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    Log.d(DEBUG_TAG, "onFling: down");
                    callbackGame.swipe(SWIPE.DOWN);
                } else {
                    Log.d(DEBUG_TAG, "onFling: up");
                    callbackGame.swipe(SWIPE.UP);
                }
            }
        }
        return false;
    }
}

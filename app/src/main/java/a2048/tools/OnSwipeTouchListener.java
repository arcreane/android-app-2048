package a2048.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import a2048.Grid;


public class OnSwipeTouchListener implements OnTouchListener {

    private final GestureDetector gestureDetector;
    private final Grid grid;

    public OnSwipeTouchListener(Context context, Grid grid) {
        this.grid = grid;
        this.gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public boolean onTouch(View view, MotionEvent event) {
        System.out.println("touch");
        view.performClick();
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 5;
        private static final int SWIPE_VELOCITY_THRESHOLD = 5;

        @Override
        public boolean onDown(MotionEvent event) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            System.out.println("fling");
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD &&
                        Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                }
            } else {
                if (Math.abs(diffY) > SWIPE_THRESHOLD &&
                        Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeDown();
                    } else {
                        onSwipeUp();
                    }
                }
            }
            return false;
        }
    }

    private void onSwipeUp() {

        grid.modifyGrid(grid.UP);
    }

    private void onSwipeRight() {
        grid.modifyGrid(grid.END);
    }

    private void onSwipeDown() {
        grid.modifyGrid(grid.DOWN);
    }

    private void onSwipeLeft() {
        grid.modifyGrid(grid.START);
    }
}

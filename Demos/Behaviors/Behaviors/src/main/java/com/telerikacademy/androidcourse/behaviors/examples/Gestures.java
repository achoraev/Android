package com.telerikacademy.androidcourse.behaviors.examples;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import java.util.Random;

public class Gestures extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomClass(this));
    }

    class CustomClass extends View implements GestureDetector.OnDoubleTapListener,
    GestureDetector.OnGestureListener,
            ScaleGestureDetector.OnScaleGestureListener{

        private Paint paint;
        private Point position;

        private int size;
        private float speed = 0.001f;

        private Random random;

        private GestureDetector gestureDetector;
        private ScaleGestureDetector scaleGestureDetector;
        private float velocityX;
        private float velocityY;

        public CustomClass(Context context) {
            super(context);

            this.gestureDetector = new GestureDetector(context, this);
            this.scaleGestureDetector = new ScaleGestureDetector(context, this);
            this.position = new Point();
            this.random = new Random();
            this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        }

        @Override
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);

            this.size = (int) ((right - left) * .20f);
            centerElement();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawRect(position.x, position.y, position.x + size, position.y + size, paint);

            int distance = (int) (velocityX * speed);
            if (velocityX != 0 || velocityY != 0) {
                if (velocityX > 0) {
                    velocityX += -distance;
                } else {
                    velocityX += +distance;
                }

                position.x += distance;

                distance = (int) (velocityY * speed);
                if (velocityY > 0) {
                    velocityY += -distance;
                } else {
                    velocityY += +distance;
                }

                position.y += distance;

                invalidate();
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //Log.d("jekozo", "Event is received!");

            /*if (event.getAction() == MotionEvent.ACTION_DOWN)
                return false;*/

            boolean handledByScaleGestureDetector = this.scaleGestureDetector.onTouchEvent(event);
            boolean handledByGestureDetector = this.gestureDetector.onTouchEvent(event);

            return handledByGestureDetector || handledByScaleGestureDetector;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (!pointIsWithinElement(e.getX(), e.getY()))
                return false;

            paint.setColor(Color.rgb(
                    random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255)
            ));

            invalidate();

            return true;
        }

        private boolean pointIsWithinElement(float x, float y) {
            return x > position.x && x < position.x + size &&
                    y > position.y && y < position.y + size;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            centerElement();
            invalidate();
            return true;
        }

        private void centerElement() {
            position.x = (getWidth() / 2) - (size / 2);
            position.y = (getHeight() / 2) - (size / 2);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            reset();
            return false;
        }

        private void reset() {
            this.velocityX = 0;
            this.velocityY = 0;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            this.position.x -= distanceX;
            this.position.y -= distanceY;

            invalidate();

            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            reset();

            position.x = (int) (e.getX() - size / 2);
            position.y = (int) (e.getY() - size / 2);

            invalidate();
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            this.velocityX = velocityX;
            this.velocityY = velocityY;

            return false;
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            return false;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return false;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

        }
    }
}

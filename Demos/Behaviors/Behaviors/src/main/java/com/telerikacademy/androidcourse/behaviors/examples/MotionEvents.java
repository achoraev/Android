package com.telerikacademy.androidcourse.behaviors.examples;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.telerikacademy.androidcourse.behaviors.R;

import java.util.Iterator;
import java.util.LinkedList;

public class MotionEvents extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));
    }

    class CustomView extends View {

        private final int rowHeight;
        private float currentX;
        private float currentY;
        private LinkedList<String> actions;

        private Paint paint;
        private int pointersCount;

        public CustomView(Context context) {
            super(context);

            this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            this.paint.setTextSize(getResources().getDimension(R.dimen.info_text_size));

            Rect bounds = new Rect();
            this.paint.getTextBounds("X", 0, 1, bounds);
            this.rowHeight = (int) (bounds.height() * 1.2F);
            this.actions = new LinkedList<String>();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            this.currentX = event.getX();
            this.currentY = event.getY();

            this.actions.add(MotionEvent.actionToString(event.getAction()));
            this.pointersCount = event.getPointerCount();

            invalidate();

            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int row = 1;
            canvas.drawText("x: " + currentX, 20, rowHeight * row++, this.paint);
            canvas.drawText("y: " + currentY, 20, rowHeight * row++, this.paint);
            canvas.drawText("pointers: " + pointersCount, 20, rowHeight * row++, this.paint);

            int y = rowHeight * ++row;

            Iterator<String> iterator = this.actions.descendingIterator();
            while (iterator.hasNext()) {
                canvas.drawText(iterator.next(), 20, y, this.paint);
                y += rowHeight;
            }
        }
    }
}

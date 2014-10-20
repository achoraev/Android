package com.telerikacademy.androidcourse.examples;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;

import com.telerikacademy.androidcourse.R;

public class CanvasDrawing extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));
    }

    // Overriding the default view to get to the canvas and the onDraw() logic.
    private class CustomView extends View {

        private static final float OFFSET_STEP = 50;
        private float offsetX;
        private float offsetY;

        private Paint paint;
        private Path path;

        public CustomView(Context context) {
            super(context);

            this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            this.path = new Path();

            this.path.moveTo(400, 900);
            this.path.lineTo(800, 880);
            this.path.lineTo(900, 1100);
            this.path.lineTo(1000, 1200);
            this.path.lineTo(800, 1300);
            this.path.lineTo(600, 1400);

            this.path.close();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.save(Canvas.MATRIX_SAVE_FLAG);
            canvas.translate(this.offsetX, this.offsetY);

            canvas.drawColor(Color.BLACK);

            this.paint.setColor(Color.parseColor("#ff00ff"));
            this.paint.setStrokeWidth(getResources().getDimension(R.dimen.line_width));
            canvas.drawLine(100, 100, 400, 400, this.paint);

            this.paint.setColor(Color.parseColor("#00ff00"));
            this.paint.setStrokeWidth(2f);
            canvas.drawLine(250, 100, 550, 400, this.paint);

            this.paint.setStrokeWidth(getResources().getDimension(R.dimen.line_width));

            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(Color.BLUE);
            canvas.drawRect(150, 600, 300, 750, this.paint);

            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setColor(Color.RED);
            canvas.drawRect(450, 600, 600, 750, this.paint);

            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(Color.YELLOW);
            canvas.drawCircle(150, 900, 100, this.paint);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setColor(Color.RED);
            canvas.drawCircle(150, 900, 100, this.paint);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.small);
            canvas.drawBitmap(bitmap, 500, 100, this.paint);

            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(Color.MAGENTA);

            canvas.drawPath(this.path, this.paint);

            canvas.restore();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() != MotionEvent.ACTION_DOWN)
                return false;

            float eventX = event.getX();
            float eventY = event.getY();

            if (eventX < getWidth() / 2)
                offsetX += OFFSET_STEP;
            else
                offsetX -= OFFSET_STEP;

            if (eventY <= getHeight() / 2)
                offsetY += OFFSET_STEP;
            else
                offsetY -= OFFSET_STEP;

            invalidate();

            return true;
        }
    }
}

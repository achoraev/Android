package com.telerikacademy.androidcourse.examples.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.widget.AnalogClock;

import java.util.Calendar;
import java.util.Locale;

public class MuchBetterClock extends AnalogClock {

    private Paint paint;
    private Calendar calendar;
    private Rect bounds;
    private String value;
    private int centerX;
    private int positionY;

    public MuchBetterClock(Context context) {
        super(context);

        this.calendar = Calendar.getInstance(Locale.getDefault());
        this.bounds = new Rect();
        this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        this.paint.setColor(Color.CYAN);
        float textSize = getDimen(TypedValue.COMPLEX_UNIT_SP, 22);
        this.paint.setTextSize(textSize);

        setBackgroundColor(Color.BLACK);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        this.centerX = this.getLeft() + (this.getWidth() / 2);
        this.positionY = (int) (this.getBottom() - getDimen(TypedValue.COMPLEX_UNIT_DIP, 100));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        updateCalendar();
        updateValue();
        updateValuePosition();
        updateColor();

        canvas.drawText(this.value, this.centerX - (this.bounds.width() / 2), this.positionY, this.paint);

        invalidate();
    }

    private void updateColor() {
        int r = (int) ((this.calendar.get(Calendar.HOUR_OF_DAY) / 24f) * 255);
        int g = (int) ((this.calendar.get(Calendar.MINUTE) / 60f) * 255);
        int b = (int) ((this.calendar.get(Calendar.SECOND) / 60f) * 255);

        this.paint.setColor(Color.rgb(r, g, b));
    }

    private void updateValuePosition() {
        this.paint.getTextBounds(this.value, 0, this.value.length(), this.bounds);
    }

    private void updateValue() {
        Locale locale = Locale.getDefault();
        this.value = String.format("%s %s %s %02d:%02d:%02d", this.calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale),
                calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, locale),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));
    }

    private void updateCalendar() {
        this.calendar.setTimeInMillis(System.currentTimeMillis());
    }

    public float getDimen(int type, float dimen) {
        return TypedValue.applyDimension(type, dimen, getContext().getResources().getDisplayMetrics());
    }
}

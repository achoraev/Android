package com.telerikacademy.androidcourse.examples.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GameFigure extends GameObject {

    private final float offset;
    private final int centerX;
    private final int centerY;
    private boolean isLight;
    private boolean isKing;
    private int radius;

    private Paint figurePaint;

    public GameFigure(int x, int y, int size, boolean isKing, boolean isLight, int color) {
        super(x, y, size);

        this.offset = size * 0.15f;

        this.radius = (int) ((size / 2) - offset);

        this.isKing = isKing;
        this.isLight = isLight;
        this.figurePaint = new Paint();
        this.figurePaint.setColor(color);

        this.centerX = x + (size / 2);
        this.centerY = y + (size / 2);
    }

    public boolean isLight() {
        return isLight;
    }

    public void setLight(boolean isLight) {
        this.isLight = isLight;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean isKing) {
        this.isKing = isKing;
    }

    @Override
    public void render(Canvas canvas) {
        super.render(canvas);

        if (this.isKing) {
            drawKing(canvas);
        } else {
            drawPawn(canvas);
        }
    }

    private void drawPawn(Canvas canvas) {
        canvas.drawCircle(this.centerX, this.centerY,
                this.radius,
                this.figurePaint);
    }

    private void drawKing(Canvas canvas) {
        canvas.drawRect(getPositionX() + offset, getPositionY() + offset,
                getPositionX() + getSize() - offset,
                getPositionY() + getSize() - offset,
                this.figurePaint);
    }
}

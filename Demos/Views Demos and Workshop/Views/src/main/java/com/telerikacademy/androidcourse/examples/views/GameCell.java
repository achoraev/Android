package com.telerikacademy.androidcourse.examples.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GameCell extends GameObject {

    private Paint backgroundPaint;

    public GameCell(int x, int y, int size, int bgColor) {
        super(x, y, size);

        this.backgroundPaint = new Paint();
        this.backgroundPaint.setColor(bgColor);
    }

    @Override
    public void render(Canvas canvas) {
        super.render(canvas);

        canvas.drawRect(this.getPositionX(), this.getPositionY(),
                this.getPositionX() + this.getSize(),
                this.getPositionY() + this.getSize(),
                this.backgroundPaint);
    }
}

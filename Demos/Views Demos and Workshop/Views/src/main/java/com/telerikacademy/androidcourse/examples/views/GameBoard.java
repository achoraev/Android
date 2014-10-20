package com.telerikacademy.androidcourse.examples.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameBoard extends View {

    private static final int CELLS_COUNT = 5;

    private static final int LIGHT_COLOR = Color.parseColor("#FFFFFF");
    private static final int DARK_COLOR = Color.parseColor("#000000");
    private static final int CENTER_COLOR = Color.parseColor("#FF00FF");

    private static final int LIGHT_FIGURE_COLOR = Color.parseColor("#CCCCCC");
    private static final int DARK_FIGURE_COLOR = Color.parseColor("#333333");

    private int cellSize;
    private List<GameObject> cells;
    private List<GameObject> figures;

    private Paint gridPaint;

    public GameBoard(Context context) {
        super(context);

        this.cells = new ArrayList<GameObject>();
        this.gridPaint = new Paint();
        this.gridPaint.setColor(Color.parseColor("#333333"));
        this.gridPaint.setStrokeWidth(5);
        this.figures = new ArrayList<GameObject>();

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initGameCells();
        initGameFigures();
    }

    private void initGameFigures() {
        for (int i = 0, len = CELLS_COUNT; i < len; i++) {
            this.figures.add(new GameFigure(
                    i * cellSize, getTop(),
                    cellSize,
                    i == 2,
                    true,
                    LIGHT_FIGURE_COLOR
            ));

            this.figures.add(new GameFigure(
                    i * cellSize, getTop() + ((CELLS_COUNT - 1) * cellSize),
                    cellSize,
                    i == 2,
                    false,
                    DARK_FIGURE_COLOR
            ));
        }
    }

    private void initGameCells() {
        this.cellSize = Math.min(getWidth(), getHeight()) / CELLS_COUNT;

        int counter = 0;
        for (int row = 0; row < CELLS_COUNT; row++) {
            for (int col = 0; col < CELLS_COUNT; col++) {
                int currentColor = 0;
                if (counter == 12)
                    currentColor = CENTER_COLOR;
                else if (counter == 0 || counter == 4 || counter == 20 || counter == 24)
                    currentColor = LIGHT_COLOR;
                else if (counter % 2 == 0)
                    currentColor = DARK_COLOR;
                else
                    currentColor = LIGHT_COLOR;

                this.cells.add(new GameCell(col * cellSize, row * cellSize, cellSize,
                        currentColor));

                counter++;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (GameObject cell : this.cells)
            cell.render(canvas);

        drawGridLines(canvas);

        drawFigures(canvas);
    }

    private void drawFigures(Canvas canvas) {
        for (GameObject figure : this.figures)
            figure.render(canvas);
    }

    private void drawGridLines(Canvas canvas) {
        for (int row = 0, rowsCount = CELLS_COUNT + 1; row < rowsCount; row++) {
            canvas.drawLine(getLeft(), cellSize * row, cellSize * CELLS_COUNT, cellSize * row, this.gridPaint);
            canvas.drawLine(cellSize * row, getTop(), cellSize * row, cellSize * CELLS_COUNT, this.gridPaint);
        }
    }
}

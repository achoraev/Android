package com.telerikacademy.androidcourse.examples.views;


import android.graphics.Canvas;

public class GameObject {

    private int positionX;
    private int positionY;
    private int size;

    public GameObject(int x, int y, int size) {
        this.positionX = x;
        this.positionY = y;
        this.size = size;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void render(Canvas canvas) {

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

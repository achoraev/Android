package com.telerikacademy.androidcourse.examples;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.telerikacademy.androidcourse.R;
import com.telerikacademy.androidcourse.examples.views.GameBoard;

public class CustomViewsWorkshop extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameBoard(this));
    }
}

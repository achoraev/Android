package com.telerikacademy.androidcourse.examples;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.telerikacademy.androidcourse.R;
import com.telerikacademy.androidcourse.examples.views.MuchBetterClock;

public class ExtendingControls extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MuchBetterClock clock = new MuchBetterClock(this);

        setContentView(clock);
    }
}

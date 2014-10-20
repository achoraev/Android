package com.telerikacademy.androidcourse.behaviors;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.telerikacademy.androidcourse.behaviors.examples.Gestures;
import com.telerikacademy.androidcourse.behaviors.examples.MotionEvents;
import com.telerikacademy.androidcourse.behaviors.examples.ViewTouchHandling;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNavigationButtonClicked(v.getId());
            }
        };

        findViewById(R.id.view_touch_handling).setOnClickListener(listener);
        findViewById(R.id.motion_events).setOnClickListener(listener);
        findViewById(R.id.gestures).setOnClickListener(listener);
    }

    private void handleNavigationButtonClicked(int id) {
        Intent intent;

        if (id == R.id.view_touch_handling)
            intent = new Intent(this, ViewTouchHandling.class);
        else if (id == R.id.motion_events)
            intent = new Intent(this, MotionEvents.class);
        else if (id == R.id.gestures)
            intent = new Intent(this, Gestures.class);
        else
            return;

        startActivity(intent);
    }
}

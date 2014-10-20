package com.telerikacademy.androidcourse.examples;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.telerikacademy.androidcourse.R;

public class ViewLayoutAndTouch extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_layout_and_touch);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleViewClick(v.getLeft(), v.getTop(), v.getWidth(), v.getHeight());
            }
        };

        findViewById(R.id.firstView).setOnClickListener(listener);
        findViewById(R.id.secondView).setOnClickListener(listener);
    }

    private void handleViewClick(int left, int top, int width, int height) {
        Toast.makeText(this, "x: " + left + " y: " + top + " w: " + width + " h: " + height, Toast.LENGTH_LONG).show();
    }
}

package com.telerikacademy.androidcourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.telerikacademy.androidcourse.examples.CanvasDrawing;
import com.telerikacademy.androidcourse.examples.CustomViewsWorkshop;
import com.telerikacademy.androidcourse.examples.DefaultControls;
import com.telerikacademy.androidcourse.examples.ExtendingControls;
import com.telerikacademy.androidcourse.examples.ViewFromCode;
import com.telerikacademy.androidcourse.examples.ViewFromXml;
import com.telerikacademy.androidcourse.examples.ViewLayoutAndTouch;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClicked(v.getId());
            }
        };

        findViewById(R.id.viewFromXml).setOnClickListener(listener);
        findViewById(R.id.viewFromCode).setOnClickListener(listener);
        findViewById(R.id.layoutAndTouch).setOnClickListener(listener);
        findViewById(R.id.canvas_drawing).setOnClickListener(listener);
        findViewById(R.id.default_controls).setOnClickListener(listener);
        findViewById(R.id.extending_controls).setOnClickListener(listener);
        findViewById(R.id.custom_views_workshop).setOnClickListener(listener);
    }

    private void handleButtonClicked(int buttonId) {
        Intent intent;
        if (buttonId == R.id.viewFromXml)
            intent = new Intent(this, ViewFromXml.class);
        else if (buttonId == R.id.viewFromCode)
            intent = new Intent(this, ViewFromCode.class);
        else if (buttonId == R.id.layoutAndTouch)
            intent = new Intent(this, ViewLayoutAndTouch.class);
        else if (buttonId == R.id.canvas_drawing)
            intent = new Intent(this, CanvasDrawing.class);
        else if (buttonId == R.id.default_controls)
            intent = new Intent(this, DefaultControls.class);
        else if (buttonId == R.id.extending_controls)
            intent = new Intent(this, ExtendingControls.class);
        else if (buttonId == R.id.custom_views_workshop)
            intent = new Intent(this, CustomViewsWorkshop.class);
        else
            return;

        startActivity(intent);
    }
}

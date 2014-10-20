package com.telerikacademy.androidcourse.behaviors.examples;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.telerikacademy.androidcourse.behaviors.R;

import java.util.Random;

public class ViewTouchHandling extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_touch_handling);

        final Random random = new Random();
        final TextView view = (TextView) findViewById(R.id.touchView);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.rgb(
                        random.nextInt(255),
                        random.nextInt(255),
                        random.nextInt(255)
                ));
            }
        };

        View.OnTouchListener touchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float eventX = event.getX();
                float eventY = event.getY();

                String value;

                if (eventX < v.getWidth() / 2) {
                    if (eventY < v.getHeight() / 2) {
                        value = "first";
                    } else {
                        value = "third";
                    }
                } else {
                    if (eventY < v.getHeight() / 2) {
                        value = "second";
                    } else {
                        value = "fourth";
                    }
                }

                view.setText(value);

                return true;
            }
        };

        view.setOnClickListener(clickListener);
        view.setOnTouchListener(touchListener);
    }
}

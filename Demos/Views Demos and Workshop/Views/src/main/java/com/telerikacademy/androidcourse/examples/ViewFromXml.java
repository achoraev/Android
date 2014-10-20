package com.telerikacademy.androidcourse.examples;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.telerikacademy.androidcourse.R;

public class ViewFromXml extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_from_xml);

        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.container);

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.custom_view, viewGroup, false);
        viewGroup.addView(view);
    }
}

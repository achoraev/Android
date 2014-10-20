package com.telerikacademy.workingwithlocaldata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.telerikacademy.workingwithlocaldata.examples.contentprovider.ContentProviderActivity;
import com.telerikacademy.workingwithlocaldata.examples.dao.DAO;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.dao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DAO.class));
            }
        });

        findViewById(R.id.content_provider).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContentProviderActivity.class));
            }
        });
    }
}

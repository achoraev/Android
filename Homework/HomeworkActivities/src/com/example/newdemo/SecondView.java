package com.example.newdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondView extends Activity {

	public TextView textViewer;
	public String output;
	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_view);
		
		textViewer = (TextView) findViewById(R.id.text_view);
		
		output = getIntent().getStringExtra("input");
		
		textViewer.setText(output);		
	}	
}
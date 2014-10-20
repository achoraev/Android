package com.example.newdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	public Button button;
	public EditText textInput;	
	public String inputedText;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.btn);
		textInput = (EditText) findViewById(R.id.text_input);		
		
		final Intent intent = new Intent(this, SecondView.class);		
		
		button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				intent.putExtra("input", textInput.getText().toString());
				Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();
				startActivity(intent);
				//textViewer.setText(textInput.getText());				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

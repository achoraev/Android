package com.example.gpsdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener
{
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sensorManager.registerListener(this,
		        sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
		        SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sensorManager.unregisterListener(this);
	}
	
	private SensorManager sensorManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		Sensor proximitySensor = sensorManager
		        .getDefaultSensor(Sensor.TYPE_PROXIMITY);
		if (proximitySensor == null) {
			Toast.makeText(MainActivity.this, "No Proximity Sensor Found! ",
			        Toast.LENGTH_LONG).show();
		}
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
	
	@Override
    protected void onDestroy() {
	    // TODO Auto-generated method stub
	    super.onDestroy();
	    sensorManager = null;	    
    }

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
			if (event.values[0] == 0) {
				Toast.makeText(this,
				        "You are Near: " + String.valueOf(event.values[0]),
				        Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this,
				        "You are Far: " + String.valueOf(event.values[0]),
				        Toast.LENGTH_SHORT).show();
			}
			
		}
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
}

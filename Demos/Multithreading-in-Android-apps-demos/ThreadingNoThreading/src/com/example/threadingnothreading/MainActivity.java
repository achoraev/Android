package com.example.threadingnothreading;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity
{
	Bitmap mBitmap;
	ImageView mView;
	int mDelay = 5000;
	Activity activity = this;
	
	private final String TAG = MainActivity.class.getSimpleName(); 
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mView = (ImageView) findViewById(R.id.imageView1);
		
		final Button loadButton = (Button) findViewById(R.id.button1);
		final Button otherButton = (Button) findViewById(R.id.button2);
		loadButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				loadIcon();
				
			}
		});
		
		otherButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "I'm working", Toast.LENGTH_SHORT).show();				
			}
		});
		
	}
	
	protected void loadIcon() {
	    // TODO Auto-generated method stub
		try {
	        Thread.sleep(1000);
        } catch (InterruptedException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.android);
        mView.setImageBitmap(mBitmap);
//	    new Thread(new Runnable() {
//
//			@Override
//            public void run() {
//	            // TODO Auto-generated method stub
//	            try
//	            {
//	            	Thread.sleep(mDelay);
//	            } catch(InterruptedException ex) 
//	            {
//	            	Log.d(TAG,ex.toString());
//	            }
//	            mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.android);
//	            mView.setImageBitmap(mBitmap);
//	            	            
//            }
//	    	
//	    }).start();
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

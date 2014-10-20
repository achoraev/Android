package com.example.threadingasynctask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends Activity
{
	
	ImageView mImageView;
	ProgressBar mProgressBar;
	int mDelay = 500;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mImageView = (ImageView) findViewById(R.id.imageView1);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
		
		final Button button = (Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new LoadIconTask().execute(R.drawable.ic_launcher);
				
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
	
	class LoadIconTask extends AsyncTask<Integer, Integer, Bitmap>
	{		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			mProgressBar.setVisibility(View.VISIBLE);
		}
		
		@Override
		protected Bitmap doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			Bitmap tmp = BitmapFactory.decodeResource(getResources(),
			        R.drawable.ic_launcher);
			
			for (int i = 1; i < 11; i++) {
				sleep();
				publishProgress(i * 10);
			}
			
			return tmp;
		}
		
		private void sleep() {
			try {
				Thread.sleep(mDelay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			mProgressBar.setVisibility(ProgressBar.INVISIBLE);
			mImageView.setImageBitmap(result);
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			mProgressBar.setProgress(values[0]);
		}
		
	}
}

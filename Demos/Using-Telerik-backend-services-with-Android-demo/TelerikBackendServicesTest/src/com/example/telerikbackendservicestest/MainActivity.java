package com.example.telerikbackendservicestest;

import java.util.ArrayList;

import com.telerik.everlive.sdk.core.EverliveApp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MainActivity extends Activity
{
	
	ListView list;
	ArrayList<String> stringList;
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		unregisterReceiver(myReceiver);
		super.onStop();		
	}
	
	MyReceiver myReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		stringList = new ArrayList<String>();		
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stringList);
		list = (ListView)findViewById(R.id.listView1);
		list.setAdapter(adapter);		
		
		myReceiver = new MyReceiver();
		
		
		
		
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(DatabaseService.MY_ACTION);
		registerReceiver(myReceiver, intentFilter);
		
		Intent intent = new Intent(MainActivity.this, DatabaseService.class);
		startService(intent);
			
		
		
		
		
	}
	EverliveApp app;
	private void addItems() {
		
		app = new EverliveApp("F2gsRAKTLx5556Y5");
		app.workWith().authentication().login("telerik_test", "1234")
		        .executeSync();
		
		// create books
		for (int start = 0; start < 8; start++) {
			Books testBook = new Books();
			testBook.setTitle(String.valueOf(start) + ".Harry Potter");
			app.workWith().data(Books.class).create(testBook).executeAsync();
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
			
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class MyReceiver extends BroadcastReceiver
	{
		
		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			
			String datapassed = arg1.getStringExtra("DATAPASSED");						
			if(!stringList.contains(datapassed))
			{
				stringList.add(datapassed);
				
				adapter.notifyDataSetChanged();
				Toast.makeText(
				        MainActivity.this,
				        "Triggered by Service!\n" + "Data passed: "
				                + String.valueOf(datapassed), Toast.LENGTH_LONG)
				        .show();
			}			
			
			
			
		}
		
	}
}

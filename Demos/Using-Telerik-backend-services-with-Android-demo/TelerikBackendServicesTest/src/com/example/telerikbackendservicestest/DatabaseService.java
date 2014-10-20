package com.example.telerikbackendservicestest;

import java.util.ArrayList;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.result.RequestResult;

public class DatabaseService extends Service
{
	
	final static String MY_ACTION = "MY_ACTION";
	EverliveApp app;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		app = new EverliveApp("F2gsRAKTLx5556Y5");
		app.workWith().authentication().login("telerik_test", "1234")
		        .executeSync();
		
		
		
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub				
		
		
		Check test = new Check();
		test.start();
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	private class Check extends Thread
	{
		@Override
		public void run() {
			super.run();
			while (true) {
				try {
					Thread.sleep(100);
					Intent intent = new Intent();
					intent.setAction(MY_ACTION);
				
					
					RequestResult allItems = app.workWith().data(Books.class)
					        .getAll().executeSync();
					if (allItems.getSuccess()) {
						ArrayList boooks = (ArrayList) allItems.getValue();
						for (Object book : boooks) {
							Books test = (Books) book;
							intent.putExtra("DATAPASSED", test.getAuthor());
						}
						
					}
					
					// intent.putExtra("DATAPASSED", "123");
					
					sendBroadcast(intent);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}

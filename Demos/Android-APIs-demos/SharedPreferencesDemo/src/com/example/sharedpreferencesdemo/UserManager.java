package com.example.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class UserManager
{
	public static final String HASHTABLE_NAME = "TEST";
	private Context mContext;
	private String mUsername, mPassword;
	private boolean mIsLogged;
	private SharedPreferences mPrefs;
	private Editor editor;
	
	public UserManager(Context context)
	{
		this.mContext = context;
		mPrefs = this.mContext.getSharedPreferences(HASHTABLE_NAME,
		        Context.MODE_PRIVATE);
		editor = mPrefs.edit();
		mIsLogged = false;
	}
	
	public boolean isLogged() {
		if(mPrefs.getBoolean("REMEMBER", false)) {
			getCurrentUserData();
			if(!this.mUsername.equals("") && !this.mPassword.equals("")) {
				return true;
			}
		}
		return mIsLogged;
	}
	
	public void registerUser(String userName, String password) {
		editor.putString("UserName", userName);
		editor.putString("Passwords", password);
	}
	
	private void getCurrentUserData() {
		this.mUsername = mPrefs.getString("UserName", "");
		this.mPassword = mPrefs.getString("Passwords", "");
	}
	
	public void logIn(String userName, String password, boolean remember) {
		getCurrentUserData();
		if (mUsername.equals(userName) && !mUsername.equals("")) {
			if (mPassword.equals(password) && !mPassword.equals("")) {
				// User is logged in
				mIsLogged = true;
				if(remember) {
					this.editor.putBoolean("REMEMBER", remember);
					this.ApplyAllSettings();
				}
			}
		}
	}
	
	public boolean ApplyAllSettings() {
		return editor.commit();
	}
}

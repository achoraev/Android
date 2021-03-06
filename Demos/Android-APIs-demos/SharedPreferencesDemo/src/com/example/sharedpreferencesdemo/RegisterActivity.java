package com.example.sharedpreferencesdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements View.OnClickListener
{
	
	private EditText editUser, editPass;
	private Button btnRegister;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_layout);
		editUser = (EditText) findViewById(R.id.editText1);
		editPass = (EditText) findViewById(R.id.editText2);
		btnRegister = (Button) findViewById(R.id.btnRegister);
		btnRegister.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.btnRegister) {
			UserManager manager = new UserManager(this.getApplicationContext());
			manager.registerUser(editUser.getText().toString(), editPass.getText().toString());
			if(manager.ApplyAllSettings()) {
				Toast.makeText(this, "Register at 100%", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
}

package android.homeimageview;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	View imageTop, imageMiddle, imageBottom;
	
	LinearLayout layoutOfPopup;
	PopupWindow popupMessage;
	Button insidePopupButton;
	TextView popupText;
	
	public void onClick(View v) {
		if (v.getId() == R.id.imageView1) {	
			popupText.setText(v.getContentDescription());
			popupMessage.showAsDropDown(imageTop, 0, 0);
			//Toast.makeText(this, "Audi1", Toast.LENGTH_LONG).show();
		} else if (v.getId() == R.id.imageView2) {
			popupText.setText(v.getContentDescription());
			popupMessage.showAsDropDown(imageMiddle, 0, 0);
		} else if (v.getId() == R.id.imageView3) {
			popupText.setText(v.getContentDescription());
			popupMessage.showAsDropDown(imageBottom, 0, 0);
		} else {
			popupMessage.dismiss();
		}	
		
	}		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	    popupInit();
	    
		imageTop = findViewById(R.id.imageView1);
		imageMiddle = findViewById(R.id.imageView2);
		imageBottom = findViewById(R.id.imageView3);
		
		imageTop.setOnClickListener(this);
		imageMiddle.setOnClickListener(this);
		imageBottom.setOnClickListener(this);
	}
	
	public void init() {	    
	    popupText = new TextView(this);
	    insidePopupButton = new Button(this);
	    layoutOfPopup = new LinearLayout(this);
	    insidePopupButton.setText("OK");	    	   
	    popupText.setPadding(0, 0, 0, 20);
	    layoutOfPopup.setOrientation(1);
	    layoutOfPopup.addView(popupText);
	    layoutOfPopup.addView(insidePopupButton);
	}

	public void popupInit() {	    
	    insidePopupButton.setOnClickListener(this);
	    popupMessage = new PopupWindow(layoutOfPopup, LayoutParams.MATCH_PARENT,
	            LayoutParams.WRAP_CONTENT);
	    popupMessage.setContentView(layoutOfPopup);
	}

}

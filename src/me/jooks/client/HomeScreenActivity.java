package me.jooks.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class HomeScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
	}
	
	public void fblogin(View view) {
	    Intent intent = new Intent(this, FBLoginActivity.class);
	    startActivity(intent);
	}

}

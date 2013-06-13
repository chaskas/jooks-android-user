package me.jooks.client;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Sets the Splash Screen Layout
		setContentView(R.layout.activity_splash_screen);

		// Generates a Handler to launch the About Screen
		// after 2 seconds
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				// Starts the About Screen Activity
				startActivity(new Intent(SplashScreenActivity.this, FBLoginActivity.class));
			}
		}, 3000L);
	}

	public void onConfigurationChanged(Configuration newConfig) {
		// Manages auto rotation for the Splash Screen Layout
		super.onConfigurationChanged(newConfig);
		setContentView(R.layout.activity_splash_screen);
	}

}

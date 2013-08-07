package me.jooks.user.android;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class SplashScreenActivity extends FragmentActivity {
	
	private FBLoginFragment FBLoginFragment;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    if (savedInstanceState == null) {
	        // Add the fragment on initial activity setup
	    	FBLoginFragment = new FBLoginFragment();
	        getSupportFragmentManager()
	        .beginTransaction()
	        .add(android.R.id.content, FBLoginFragment)
	        .commit();
	    } else {
	        // Or set the fragment from restored state info
	    	FBLoginFragment = (FBLoginFragment) getSupportFragmentManager()
	        .findFragmentById(android.R.id.content);
	    }
	}

//	public void onCreate(Bundle savedInstanceState) {
//		
//		super.onCreate(savedInstanceState);
//
//		// Sets the Splash Screen Layout
//		setContentView(R.layout.activity_splash_screen);
//
//		// Generates a Handler to launch the About Screen
//		// after 2 seconds
//		final Handler handler = new Handler();
//		handler.postDelayed(new Runnable() {
//			public void run() {
//				// Starts the About Screen Activity
//				startActivity(new Intent(SplashScreenActivity.this, DashboardActivity.class));
//			}
//		}, 2000L);
//		
//
//	}
//
//	public void onConfigurationChanged(Configuration newConfig) {
//		// Manages auto rotation for the Splash Screen Layout
//		super.onConfigurationChanged(newConfig);
//		setContentView(R.layout.activity_splash_screen);
//	}

}

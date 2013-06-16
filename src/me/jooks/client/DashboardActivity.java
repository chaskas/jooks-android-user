package me.jooks.client;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;

public class DashboardActivity extends FragmentActivity implements ActionBar.TabListener {

	private static final int FBLOGIN = 0;
	private static final int PROFILE = 1;
	private static final int FRAGMENT_COUNT = PROFILE +1;

	private Fragment[] fragments = new Fragment[FRAGMENT_COUNT];
	
	private boolean isResumed = false;
	
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;
    ViewPager mViewPager;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    uiHelper = new UiLifecycleHelper(this, callback);
	    uiHelper.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.activity_dashboard);

//	    FragmentManager fm = getSupportFragmentManager();
//	    fragments[FBLOGIN] = fm.findFragmentById(R.id.FBLoginFragment);
//	    fragments[PROFILE] = fm.findFragmentById(R.id.ProfileFragment);
//	    
//	    android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
//	    for(int i = 0; i < fragments.length; i++) {
//	        transaction.hide(fragments[i]);
//	    }
//	    transaction.commit();
	    

        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        final ActionBar actionBar = getActionBar();

        actionBar.setHomeButtonEnabled(false);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });
        
        actionBar.addTab(actionBar.newTab().setText("Locales").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Amigos").setTabListener(this));
        
	}
	
//	private void showFragment(int fragmentIndex, boolean addToBackStack) {
//	    FragmentManager fm = getSupportFragmentManager();
//	    android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
//	    for (int i = 0; i < fragments.length; i++) {
//	        if (i == fragmentIndex) {
//	            transaction.show(fragments[i]);
//	        } else {
//	            transaction.hide(fragments[i]);
//	        }
//	    }
//	    if (addToBackStack) {
//	        transaction.addToBackStack(null);
//	    }
//	    transaction.commit();
//	}
	
	@Override
	public void onResume() {
	    super.onResume();
	    uiHelper.onResume();
	    isResumed = true;
	}

	@Override
	public void onPause() {
	    super.onPause();
	    uiHelper.onPause();
	    isResumed = false;
	}
	
	private void onSessionStateChange(Session session, SessionState state, Exception exception) {
	    // Only make changes if the activity is visible
	    if (isResumed) {
	        FragmentManager manager = getSupportFragmentManager();
	        // Get the number of entries in the back stack
	        int backStackSize = manager.getBackStackEntryCount();
	        // Clear the back stack
	        for (int i = 0; i < backStackSize; i++) {
	            manager.popBackStack();
	        }
	        if (state.isOpened()) {
	            // If the session state is open:
	            // Show the authenticated fragment
//	        	if(!actionBar.isShowing())actionBar.show();
//	            showFragment(PROFILE, false);
	        } else if (state.isClosed()) {
	            // If the session state is closed:
	            // Show the login fragment
//	        	if(!actionBar.isShowing())actionBar.hide();
//	            showFragment(FBLOGIN, false);
	        }
	    }
	}
	
	@Override
	protected void onResumeFragments() {
	    super.onResumeFragments();
	    Session session = Session.getActiveSession();

	    if (session != null && session.isOpened()) {
	        // if the session is already open,
	        // try to show the selection fragment
	        //showFragment(PROFILE, false);
	    } else {
	        // otherwise present the splash screen
	        // and ask the person to login.
	        //showFragment(FBLOGIN, false);
	        
	    }
	}
	
	private UiLifecycleHelper uiHelper;
	private Session.StatusCallback callback = 
	    new Session.StatusCallback() {
	    @Override
	    public void call(Session session, SessionState state, Exception exception) {
	        onSessionStateChange(session, state, exception);
	    }
	};
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onDestroy() {
	    super.onDestroy();
	    uiHelper.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    uiHelper.onSaveInstanceState(outState);
	}
	
	@Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new FBLoginFragment();
                    
                case 1:
                    return new ProfileFragment();

                default:

                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Section " + (position + 1);
        }
    }

}

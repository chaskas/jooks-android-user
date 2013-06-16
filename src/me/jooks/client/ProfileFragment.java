package me.jooks.client;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfileFragment extends Fragment  {
	
	//private FragmentTabHost mTabHost;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
//		mTabHost = new FragmentTabHost(getActivity());
//		
//		mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.pager);
//		
//        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"), FragmentStackSupport.CountingFragment.class, null);
//        mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator("Contacts"), LoaderCursorSupport.CursorLoaderListFragment.class, null);
//
//		return mTabHost;
		View view = inflater.inflate(R.layout.fragment_fblogin, container, false);
	    return view;

	}
	
//	@Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        mTabHost = null;
//    }

}

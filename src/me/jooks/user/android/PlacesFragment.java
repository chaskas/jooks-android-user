package me.jooks.user.android;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
import me.jooks.user.android.R;

public class PlacesFragment extends Fragment {

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_places, container, false);
		
		GridView gridview = (GridView) view.findViewById(R.id.places);
	    gridview.setAdapter(new ImageAdapter(view.getContext()));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });
		
	    return view;

	}
	
	@Override
    public void onConfigurationChanged(Configuration newConfig){
        
		GridView gridview = (GridView) getView().findViewById(R.id.places);
		
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//        
//        	GridView gridview = (GridView) getView().findViewById(R.id.places);
//        	gridview.setNumColumns(3);
//        	
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//        	GridView gridview = (GridView) getView().findViewById(R.id.places);
//        	gridview.setNumColumns(3);
//        }
        
        gridview.setNumColumns(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? 3 : 2);
        
        super.onConfigurationChanged(newConfig);
    }
	
}

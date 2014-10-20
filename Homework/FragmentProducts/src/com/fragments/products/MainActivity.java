package com.fragments.products;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;



public class MainActivity extends FragmentActivity
	implements ProductTitleFragment.OnTitleSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.list_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            ProductTitleFragment firstFragment = new ProductTitleFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

//            // Add the fragment to the 'fragment_container' FrameLayout
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.list_container, firstFragment).commit();
        }
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.product_fragment, container, false);
            return rootView;
        }
    }

	@Override
	public void onTitleSelected(int position) {
		// TODO Auto-generated method stub
		
	}
}

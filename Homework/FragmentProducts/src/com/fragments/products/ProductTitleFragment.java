package com.fragments.products;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProductTitleFragment extends ListFragment{
	OnTitleSelectedListener titleSelectedCallback;

    // The container Activity must implement this interface so the frag can deliver messages
    public interface OnTitleSelectedListener {
        /** Called by HeadlinesFragment when a list item is selected */
        public void onTitleSelected(int position);
    }
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		titleSelectedCallback.onTitleSelected(position);
	    getListView().setItemChecked(position, true);
	}

	@Override
	public void onAttach(Activity activity) {
		try {
			titleSelectedCallback = (OnTitleSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnTitleSelectedListener");
        }
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int layout = R.layout.activity_main;

        // Create an array adapter for the list view, using the Ipsum headlines array
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Data.getTitles()));
	}

	@Override
    public void onStart() {
        super.onStart();

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)
//        if (getFragmentManager().findFragmentById(R.id.GL_product_info_view) != null) {
//            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        }
    }


}

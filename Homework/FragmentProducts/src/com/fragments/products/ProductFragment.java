package com.fragments.products;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProductFragment extends Fragment{
	private final static String ARG_POSITION = "position";
    private int currentListPosition = -1;
    
	@Override
	public View onCreateView(
			LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.product_fragment, container, false);
		return view;
	}

	@Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        
        if (args != null) {
            // Set article based on argument passed in
        	updateProductView(args.getInt(ARG_POSITION));
        } else if (currentListPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
        	updateProductView(currentListPosition);
        }
    }
	

    public void updateProductView(int position) {
    	TextView category = (TextView) getActivity().findViewById(R.id.TV_product_category_value);
    	TextView name = (TextView) getActivity().findViewById(R.id.TV_product_name_value);
    	TextView price = (TextView) getActivity().findViewById(R.id.TV_product_price_value);
    	TextView quantity = (TextView) getActivity().findViewById(R.id.TV_product_quantity_value);
        currentListPosition = position;
        Product currentProduct = Data.getProducts()[position];
        category.setText(currentProduct.getCategory());
        name.setText(currentProduct.getName());
        price.setText(String.valueOf(currentProduct.getPrice()));
        quantity.setText(String.valueOf(currentProduct.getQuantity()));
    }
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(ARG_POSITION, currentListPosition);
	}

}

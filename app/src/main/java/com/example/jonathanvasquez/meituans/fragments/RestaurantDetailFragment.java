package com.example.jonathanvasquez.meituans.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jonathanvasquez.meituans.R;
import com.example.jonathanvasquez.meituans.models.Restaurant;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantDetailFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
        TextView textViewRating = (TextView) view.findViewById(R.id.textViewRating);
        TextView textViewPriceRange = (TextView) view.findViewById(R.id.textViewPriceRange);
        ImageView image = view.findViewById(R.id.imageViewRestaurant);

        Bundle bundle = getArguments();
        Restaurant restaurant;
        if (bundle != null) {
            restaurant = (Restaurant) bundle.getSerializable("selected");
            textViewName.setText(restaurant.getName());
            textViewRating.setText(getActivity().getString(R.string.rating) + restaurant.getRating());
            textViewPriceRange.setText(getActivity().getString(R.string.price_range)+ restaurant.getPriceRange());
            image.setImageResource(restaurant.getImageRes());
        }

        // Inflate the layout for this fragment
        return view;
    }

}

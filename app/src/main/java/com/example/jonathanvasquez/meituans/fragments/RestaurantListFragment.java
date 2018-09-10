package com.example.jonathanvasquez.meituans.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jonathanvasquez.meituans.R;
import com.example.jonathanvasquez.meituans.adapters.RestaurantListViewAdapter;
import com.example.jonathanvasquez.meituans.models.Restaurant;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);

        ListView restaurants = (ListView) view.findViewById(R.id.restaurantsListView);

        final List<Restaurant> mockData = new ArrayList<Restaurant>();
        mockData.add(new Restaurant("Panini's pizzeria", "15", "4.5", "25", R.drawable.food2));
        mockData.add(new Restaurant("Authentic Thai Cuisine", "10", "4.7", "45", R.drawable.food3));
        mockData.add(new Restaurant("Sam's bread", "6", "4.6", "30", R.drawable.food4));
        mockData.add(new Restaurant("Grandma's BBQ Chicken", "20", "4.8", "15", R.drawable.food6));

        final RestaurantListViewAdapter restaurantsAdapter = new RestaurantListViewAdapter(getActivity(), mockData);
        restaurants.setAdapter(restaurantsAdapter);

        restaurants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), mockData.get(position).getName(), Toast.LENGTH_SHORT).show();

                RestaurantDetailFragment restaurantDetailFragment = new RestaurantDetailFragment();

                Bundle bundle = new Bundle();
                Restaurant selectedRestaurant = mockData.get(position);
                bundle.putSerializable("selected", selectedRestaurant);

                restaurantDetailFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.hide(getActivity().getSupportFragmentManager().findFragmentById(R.id.container));
                fragmentTransaction.add(R.id.container, restaurantDetailFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}

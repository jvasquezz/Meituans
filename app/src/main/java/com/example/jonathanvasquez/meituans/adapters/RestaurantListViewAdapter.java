package com.example.jonathanvasquez.meituans.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jonathanvasquez.meituans.R;
import com.example.jonathanvasquez.meituans.models.Restaurant;

import java.util.List;

public class RestaurantListViewAdapter extends ArrayAdapter<Restaurant> {
    private List<Restaurant> values;
    private LayoutInflater inflater;
    private Context context;

    public RestaurantListViewAdapter(Context context, List<Restaurant> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_layout, parent, false);
        TextView textViewName = (TextView) rowView.findViewById(R.id.textViewName);
        TextView textViewRating = (TextView) rowView.findViewById(R.id.textViewRating);
        TextView textViewPriceRange = (TextView) rowView.findViewById(R.id.textViewPriceRange);

        Restaurant restaurant = this.values.get(position);

        textViewName.setText(restaurant.getName());
        textViewRating.setText(context.getString(R.string.rating) + restaurant.getRating());
        textViewPriceRange.setText(context.getString(R.string.price_range) + restaurant.getPriceRange());
        return rowView;
    }
}

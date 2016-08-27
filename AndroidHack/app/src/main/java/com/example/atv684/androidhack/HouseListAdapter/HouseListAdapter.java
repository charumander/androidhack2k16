package com.example.atv684.androidhack.HouseListAdapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.atv684.androidhack.R;
import com.example.atv684.androidhack.objects.House;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by atv684 on 8/27/16.
 */
public class HouseListAdapter implements ListAdapter {

    ArrayList<House> objects;

    Context context;

    public HouseListAdapter(Context context, ArrayList<House> houses){
        objects = houses;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return objects.get(position).getName().hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // First let's verify the convertView is not null
        if (convertView == null) {
            // This a new view we inflate the new layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.house_row_view, parent, false);
        }
        // Now we can fill the layout with the right values
        TextView houseName = (TextView) convertView.findViewById(R.id.name);
        TextView houseDescription = (TextView) convertView.findViewById(R.id.description);
        ImageView houseImage = (ImageView) convertView.findViewById(R.id.icon);
        houseName.setText(objects.get(position).getName());
        houseDescription.setText(objects.get(position).getDescription());

        if(objects.get(position).getHouseImages().size()>0) {
            Picasso.with(context).load(objects.get(position).getHouseImages().get(0)).into(houseImage);
        }

        return convertView;

    }

    @Override
    public int getItemViewType(int position) {
        return objects.get(position).getType().hashCode();
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}

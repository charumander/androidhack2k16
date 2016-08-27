package com.example.atv684.androidhack.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.atv684.androidhack.HouseActivity;
import com.example.atv684.androidhack.HouseListAdapter.HouseListAdapter;
import com.example.atv684.androidhack.MainApplication;
import com.example.atv684.androidhack.R;
import com.example.atv684.androidhack.objects.House;
import com.example.atv684.androidhack.objects.HouseTypePref;

import java.util.ArrayList;

/**
 * Created by atv684 on 8/27/16.
 */
public class MyHomesFragment extends ListFragment{
    public HouseListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.house_list_fragment, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();

        ArrayList<House> houses = new ArrayList<House>();

        houses = MainApplication.getApplication().getSwipedHouses();

        adapter = new HouseListAdapter(getContext(), houses);
        setListAdapter(adapter);


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        HouseActivity.showHouse(getContext(), (House)adapter.getItem(position));
    }
}





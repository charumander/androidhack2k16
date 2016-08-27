package com.example.atv684.androidhack.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.atv684.androidhack.HouseListAdapter.HouseListAdapter;
import com.example.atv684.androidhack.R;
import com.example.atv684.androidhack.objects.House;
import com.example.atv684.androidhack.objects.HouseTypePref;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by atv684 on 8/27/16.
 */
public class MyHomesFragment extends ListFragment{

    public ListView listView;

    public HouseListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.house_list_fragment, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ArrayList<House> houses = new ArrayList<House>();

        houses.add(new House("Name", "Description", "zip", 500000, null, 3, 2, HouseTypePref.Apartment.toString()));

        adapter = new HouseListAdapter(getContext(), houses);
        setListAdapter(adapter);
        //getListView().setOnItemClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO implement some logic
    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//    }
}





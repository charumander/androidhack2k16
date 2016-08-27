package com.example.atv684.androidhack;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.atv684.androidhack.helper.DataHelper;
import com.example.atv684.androidhack.objects.House;
import com.example.atv684.androidhack.objects.User;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, ValueEventListener {

    private ViewPager viewPager;

    private MainPagerAdapter mAdapter;

    private ActionBar actionBar;

    // Tab titles
    private String[] tabs = {"Find a house", "My Matches", "Profile"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO: Remove the below 2 lines also if no other data setup is needed

        DataHelper.fetchHouses(this);

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Search"));
        tabLayout.addTab(tabLayout.newTab().setText("My Matches"));
        tabLayout.addTab(tabLayout.newTab().setText("Profile"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Iterable<DataSnapshot> housesData = dataSnapshot.getChildren();
        List<House> houses = new ArrayList<>();
        for (DataSnapshot house: housesData) {
            House houseObject = new House();
            houseObject.setBeds(house.child("beds").getValue()!=null? (Long) house.child("beds").getValue(): 3);//Defaulting to 3
            houseObject.setBaths(house.child("baths").getValue()!=null? (Long) house.child("baths").getValue(): 2);//Defaulting to 2
            houseObject.setCity(house.child("city").getValue()!=null? (String) house.child("city").getValue(): "Wilmington");//Defaulting
            // to wilmington
            houseObject.setCost(house.child("cost").getValue()!=null? (Long) house.child("cost").getValue(): 50000l);
            houseObject.setDescription(house.child("description").getValue()!=null? (String) house.child("description").getValue():"" );
            houseObject.setName(house.child("name").getValue()!=null? (String) house.child("name").getValue():"" );
            houseObject.setType(house.child("type").getValue()!=null? (String) house.child("type").getValue():"" );
            houseObject.setZip(house.child("zip").getValue()!=null? (String) house.child("zip").getValue():"" );
            //houseObject.setHouseImages(house.child("houseImages").getChildren());
            houses.add(houseObject);
        }
        houses.size();
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
}

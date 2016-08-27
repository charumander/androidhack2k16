package com.example.atv684.androidhack.helper;


import com.example.atv684.androidhack.MainActivity;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

/**
 * Created by pyc393 on 8/27/16.
 */
public class DataHelper {

    public static void fetchHouses(MainActivity context) {
        Firebase.setAndroidContext(context);

        Firebase fireBaseRef = new Firebase("https://housr-df682.firebaseio.com/");

        if (context instanceof ValueEventListener) {
            fireBaseRef.child("houses").addValueEventListener(context);
        }
    }
}

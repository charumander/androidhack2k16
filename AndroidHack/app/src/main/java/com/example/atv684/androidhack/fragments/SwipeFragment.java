package com.example.atv684.androidhack.fragments;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;
import com.example.atv684.androidhack.HouseUtil;
import com.example.atv684.androidhack.MainApplication;
import com.example.atv684.androidhack.MainPagerAdapter;
import com.example.atv684.androidhack.R;
import com.example.atv684.androidhack.helper.DataHelper;
import com.example.atv684.androidhack.helper.ImageHelper;
import com.example.atv684.androidhack.objects.House;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by atv684 on 8/27/16.
 */
public class SwipeFragment extends Fragment implements ImageHelper.onBitMapReceivedListener{

    public int cardCount = 0;

    ArrayList<House> houses;

    private SimpleCardStackAdapter adapter;

    private int position = 0;

    CardModel.OnCardDimissedListener cardDimissedListener = new CardModel.OnCardDimissedListener() {
        @Override
        public void onLike() {

            CardModel model = (CardModel) mCardContainer.getAdapter().getItem(cardCount);

            House house = HouseUtil.getHouseByName(model.getTitle(), houses);

            cardCount++;

            if (HouseUtil.canAffordHouse(house)) {
                MainApplication.getApplication().setHouseStatus(house.getName(), true);
                MainApplication.getApplication().addSwipedHouse(house.getName(), house);

                showCongrats();
            }
            else{

                MainApplication.getApplication().setHouseStatus(house.getName(), false);
                MainApplication.getApplication().addSwipedHouse(house.getName(), house);
            }
        }

        @Override
        public void onDislike() {
            cardCount++;
        }
    };

    private void showCongrats() {
        String message = "Congratulations! our data shows that you can afford this home.";

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        builder.create().show();
    }

    private void showCantAfford(House house) {

        String message = "It seems like you can't afford this house. try managing your expenses and look for something more in your price range";
        if(HouseUtil.isCreditTooLow(house)){
            message = "Your credit is too low! Lenders will be relunctant to lend to you. Try building credit and trying again.";
        }

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        builder.create().show();

    }

    private CardContainer mCardContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.swipe_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCardContainer = (CardContainer) view.findViewById(R.id.cardContainer);

        waitForHouses();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        waitForHouses();
    }

    public void onGetHouses(ArrayList<House> houses) {

        if (isAdded()) {
            adapter = new SimpleCardStackAdapter(getContext());

            for (House h : houses) {

                CardModel cardModel = new CardModel(h.getName(), h.getDescription(), getResources().getDrawable(getRandomHouseDrawable()));
                cardModel.setOnCardDimissedListener(cardDimissedListener);
                if (h.getHouseImages() != null && h.getHouseImages().size() > 0) {
                    ImageHelper.loadImageFromUrl(getContext(), h.getHouseImages().get(0), this, position++);
                }

                adapter.add(cardModel);
            }

            mCardContainer.setAdapter(adapter);
        }
    }

    public void waitForHouses() {

        houses = (ArrayList) MainApplication.getApplication().getSearchResults();
        if (houses == null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    houses = (ArrayList) MainApplication.getApplication().getSearchResults();

                    if (houses != null) {
                        onGetHouses(houses);
                    } else {
                        waitForHouses();
                    }
                }
            }, 100);
        } else {
            onGetHouses(houses);
        }
    }

    @Override
    public void imageLoaded(Bitmap bitmap, int position) {
        CardModel cardModel = adapter.getCardModel(position);
        Drawable drawable = new BitmapDrawable(getResources(), bitmap);
        cardModel.setCardImageDrawable(drawable);
        adapter.notifyDataSetChanged();
    }

    public int getRandomHouseDrawable() {
        Random random = new Random();

        int id = random.nextInt(5);

        switch(id){
            case 0:
                return R.drawable.house1;
            case 1:
                return R.drawable.house2;
            case 2:
                return R.drawable.house3;
            case 3:
                return R.drawable.house4;
            case 4:
                return R.drawable.house5;
        }

        return R.drawable.house1;
    }
}

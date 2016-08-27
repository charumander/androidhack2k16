package com.example.atv684.androidhack;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.atv684.androidhack.objects.House;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HouseActivity extends AppCompatActivity {
    public static final String HOUSE_EXTRA = "HOUSE_EXTRA";

    private static final House MOCK_HOUSE = new House(
            "LazyPalms",
            "Luxurious palace on the beach",
            "19806",
            500000,
            Arrays.asList(
                    "http://placekitten.com/g/600/400",
                    "http://placekitten.com/g/400/300",
                    "http://placekitten.com/g/600/300"
            ),
            1,
            1,
            "Condo"
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        House house = null;
        if (getIntent().hasExtra(HOUSE_EXTRA)) {
            house = (House) getIntent().getSerializableExtra(HOUSE_EXTRA);
        }

        if (house == null) {
            if (BuildConfig.DEBUG) {
                house = MOCK_HOUSE;
            } else {
                finish();
                return;
            }
        }

        setContentView(R.layout.activity_house);

        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
        final CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        final HouseAdapter adapter = new HouseAdapter(getSupportFragmentManager(), house);

        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
    }


    private static class HouseAdapter extends FragmentStatePagerAdapter {
        private House house;

        public HouseAdapter(FragmentManager fm, final House house) {
            super(fm);
            this.house = house;
        }

        @Override
        public Fragment getItem(int position) {
            return ImageFragment.newInstance(house.getHouseImages().get(position));
        }

        @Override
        public int getCount() {
            final List<String> images = house.getHouseImages();
            return (images != null) ? images.size() : 0;
        }
    }

    public static class ImageFragment extends Fragment {
        private static final String IMAGE_EXTRA = "IMAGE_EXTRA";

        public static ImageFragment newInstance(String imageUrl) {
            final ImageFragment fragment = new ImageFragment();
            final Bundle arguments = new Bundle();
            arguments.putString(IMAGE_EXTRA, imageUrl);
            fragment.setArguments(arguments);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            if (container == null) {
                return null;
            }

            final Context context = container.getContext();
            final ImageView view = new ImageView(context);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            final String url = getArguments().getString(IMAGE_EXTRA, null);
            Picasso.with(context).load(url).into(view);

            return view;
        }
    }
}

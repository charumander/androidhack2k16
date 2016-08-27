package com.example.atv684.androidhack.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by pyc393 on 8/27/16.
 */
public class ImageHelper {

    public interface onBitMapReceivedListener {

        void imageLoaded(Bitmap bitmap, int position);
    }

    public static void loadImageFromUrl(final Context context, String url, final onBitMapReceivedListener bitMapReceivedListener, final int
        position) {
        Picasso.with(context)
            .load(url)
            .into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    bitMapReceivedListener.imageLoaded(bitmap , position);
                }

                @Override
                public void onBitmapFailed(Drawable errorDrawable) {

                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            });
    }
}

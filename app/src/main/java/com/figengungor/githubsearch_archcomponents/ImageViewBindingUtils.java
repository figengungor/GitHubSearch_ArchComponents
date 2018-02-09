package com.figengungor.githubsearch_archcomponents;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by figengungor on 17.10.2016.
 */
public class ImageViewBindingUtils {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }

}
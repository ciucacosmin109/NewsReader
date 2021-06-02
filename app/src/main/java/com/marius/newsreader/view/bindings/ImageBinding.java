package com.marius.newsreader.view.bindings;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

public class ImageBinding {

    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView imageView, @Nullable String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}

package com.marius.newsreader.common.view.bindings;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.marius.newsreader.R;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

public class ImageBinding {

    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView imageView, @Nullable String url) {
        RequestOptions options = new RequestOptions()
                .override(800, 400)
                .centerCrop()
                .placeholder(R.drawable.ic_outline_text_snippet_24_48)
                .error(R.drawable.ic_outline_text_snippet_24_48)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.LOW);

        Glide.with(imageView.getContext())
                .load(url)
                .apply(options)
                .into(imageView);
    }
}

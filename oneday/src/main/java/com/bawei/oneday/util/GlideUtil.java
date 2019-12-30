package com.bawei.oneday.util;

import android.widget.ImageView;

import com.bawei.oneday.R;
import com.bawei.oneday.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtil {
    public static void GlideInfo(String url, ImageView imageView) {
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .into(imageView);
    }
}

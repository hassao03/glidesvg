package com.carouselapp.glidesvg;

import android.app.Activity;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.RequestBuilder;

/**
 * Displays an SVG image loaded from an android raw resource.
 */
public class MainActivity extends Activity {
    private static final String TAG = "SVGActivity";

    private ImageView imageViewNet;
    private RequestBuilder<PictureDrawable> requestBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewNet = findViewById(R.id.svg_image_view);
        imageViewNet.setScaleType(ImageView.ScaleType.FIT_XY);
        requestBuilder =
                GlideApp.with(this)
                        .as(PictureDrawable.class)
                        .listener(new SvgSoftwareLayerSetter());

        loadNet();
    }

    private void loadNet() {
        String url = "https://static.files.bbci.co.uk/core/website/assets/static/sport/football/arsenal.d946e916defb25fc7decd5cf611b3ba3.svg";
        Uri uri = Uri.parse(url);
        requestBuilder.load(uri).into(imageViewNet);
    }
}

package com.denissamodurov.yandexphotoviewer.image_shower;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.denissamodurov.yandexphotoviewer.R;

public class ImageShowerActivity extends AppCompatActivity {
    private static final String BITMAP_IMAGE = "BITMAP_IMAGE";
    private Bitmap imageToShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_shower);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getDataFromIntent(getIntent());
    }

    private void getDataFromIntent(Intent intent) {
        if(intent.hasExtra(BITMAP_IMAGE)){
            imageToShow = intent.getParcelableExtra(BITMAP_IMAGE);
        }
    }

    public static Intent getIntent(Context context, Bitmap bitmap) {
        Intent intent = new Intent(context, ImageShowerActivity.class);
        intent.putExtra(BITMAP_IMAGE, bitmap);
        return intent;
    }
}

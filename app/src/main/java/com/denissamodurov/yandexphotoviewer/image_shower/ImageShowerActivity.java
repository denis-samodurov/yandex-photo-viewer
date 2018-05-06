package com.denissamodurov.yandexphotoviewer.image_shower;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.denissamodurov.yandexphotoviewer.R;

public class ImageShowerActivity extends AppCompatActivity {
    private static final String BITMAP_IMAGE = "BITMAP_IMAGE";

    private ImageView pictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_shower);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pictureView = findViewById(R.id.content_image_shower_picture);

        getDataFromIntent(getIntent());
    }

    private void getDataFromIntent(Intent intent) {
        if(intent.hasExtra(BITMAP_IMAGE)){
            Bitmap image = intent.getParcelableExtra(BITMAP_IMAGE);
            pictureView.setImageBitmap(image);
        }
    }

    public static Intent getIntent(Context context, Bitmap bitmap) {
        Intent intent = new Intent(context, ImageShowerActivity.class);
        intent.putExtra(BITMAP_IMAGE, bitmap);
        return intent;
    }
}

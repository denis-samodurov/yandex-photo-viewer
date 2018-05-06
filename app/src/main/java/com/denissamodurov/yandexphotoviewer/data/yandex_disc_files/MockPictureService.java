package com.denissamodurov.yandexphotoviewer.data.yandex_disc_files;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;

import com.denissamodurov.yandexphotoviewer.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by denissamodurov on 06/05/2018.
 */

public class MockPictureService implements PictureService {
    private final WeakReference<Context> contextRef;

    public MockPictureService(@NonNull Context contextRef){
        this.contextRef = new WeakReference<>(contextRef);
    }

    @Override
    public List<PictureModel> getAllPicture() {
        final Context context = contextRef.get();
        if(context == null){
            return null;
        }
        Bitmap bitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher_background);
        Bitmap bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_add_black_24dp);
        Bitmap bitmap3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher_foreground);

        List<PictureModel> pictureModels = new ArrayList<>();
        pictureModels.add(new PictureModel(bitmap1, new Date(1220227200L * 1000)));
        pictureModels.add(new PictureModel(bitmap2, new Date(System.currentTimeMillis())));
        pictureModels.add(new PictureModel(bitmap3, new Date(System.currentTimeMillis())));

        return pictureModels;
    }
}

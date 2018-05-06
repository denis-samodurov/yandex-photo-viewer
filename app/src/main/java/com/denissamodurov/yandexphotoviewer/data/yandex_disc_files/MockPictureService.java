package com.denissamodurov.yandexphotoviewer.data.yandex_disc_files;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.denissamodurov.yandexphotoviewer.R;
import com.denissamodurov.yandexphotoviewer.util.ImageUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

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
        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_launcher_background);
        Bitmap bitmap = ImageUtil.drawableToBitmap(drawable);

        List<PictureModel> pictureModels = new ArrayList<>();
        pictureModels.add(new PictureModel("First image", bitmap, "2014-12-13"));
        pictureModels.add(new PictureModel("Second image", bitmap, "2014-12-13"));
        pictureModels.add(new PictureModel("Third image", bitmap, "2014-12-13"));
        pictureModels.add(new PictureModel("Third image", bitmap, "2014-12-13"));
        pictureModels.add(new PictureModel("Third image", bitmap, "2014-12-13"));
        pictureModels.add(new PictureModel("Third image", bitmap, "2014-12-13"));
        pictureModels.add(new PictureModel("Third image", bitmap, "2014-12-13"));

        return pictureModels;
    }
}

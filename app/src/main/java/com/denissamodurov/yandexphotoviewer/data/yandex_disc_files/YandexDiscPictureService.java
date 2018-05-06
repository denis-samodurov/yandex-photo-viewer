package com.denissamodurov.yandexphotoviewer.data.yandex_disc_files;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class YandexDiscPictureService implements PictureService {
    private Context context;
    private Response response;
    private OkHttpClient client;

    public YandexDiscPictureService(@NonNull Context contextRef) {
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();
        WeakReference<Context> contextRef1 = new WeakReference<>(contextRef);
        context = contextRef1.get();
    }

    @Override
    public List<PictureModel> getAllPicture() {
        if(context == null){
            return null;
        }
        JSONArray fileItems = getFileItems();
        if(fileItems == null){
            return null;
        }

        return getPictureModels(fileItems);
    }

    private List<PictureModel> getPictureModels(JSONArray fileItems) {
        List<PictureModel> pictureModels = new ArrayList<>();

        for (int i = 0; i < fileItems.length(); i++) {
            try {
                JSONObject object = fileItems.getJSONObject(i);

                String title = object.getString("name");
                String date = object.getString("created").substring(0, 10);

                String fileUrl = object.getString("file");
                Bitmap image = Glide.
                        with(context).
                        asBitmap().
                        load(fileUrl).
                        into(200, 200).
                        get();

                pictureModels.add(new PictureModel(title, image, date));

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return pictureModels;
    }

    private JSONArray getFileItems(){
        Request request = new Request.Builder()
                .addHeader("Authorization", "OAuth AQAAAAAdB1_pAADLW2ZRUCVHM0O5hZ6P37ES05g")
                .addHeader("cache-control", "no-cache")
                .url("https://cloud-api.yandex.net:443/v1/disk/resources/last-uploaded?limit=5&media_type=image")
                .get()
                .build();

        try {
            response = client.newCall(request).execute();
            String jsonData = response.body().string();
            JSONObject bodyJson = new JSONObject(jsonData);
            return bodyJson.getJSONArray("items");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if(response != null){
                response.close();
            }
        }

        return null;
    }
}

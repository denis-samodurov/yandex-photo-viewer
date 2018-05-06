package com.denissamodurov.yandexphotoviewer.data.yandex_disc_files;

import android.graphics.Bitmap;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by denissamodurov on 06/05/2018.
 */

@Getter @Setter @AllArgsConstructor
public class PictureModel {
    private String title;
    private Bitmap picture;
    private Date date;
}

package com.denissamodurov.yandexphotoviewer.main_page.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.denissamodurov.yandexphotoviewer.R;

/**
 * Created by denissamodurov on 06/05/2018.
 */

public class PictureHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView date;
    public ImageView picture, overflow;

    public PictureHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.picture_card_title);
        date = itemView.findViewById(R.id.picture_card_date);
        picture = itemView.findViewById(R.id.picture_card_picture);
        overflow =  itemView.findViewById(R.id.picture_card_overflow);
    }
}

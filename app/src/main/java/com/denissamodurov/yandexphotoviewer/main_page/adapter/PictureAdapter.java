package com.denissamodurov.yandexphotoviewer.main_page.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.denissamodurov.yandexphotoviewer.R;
import com.denissamodurov.yandexphotoviewer.data.yandex_disc_files.PictureModel;
import com.denissamodurov.yandexphotoviewer.util.DateUtil;

import java.util.List;

import lombok.Setter;

public class PictureAdapter extends RecyclerView.Adapter<PictureHolder> {
    private Context mContext;
    @Setter
    private List<PictureModel> pictureList;

    public PictureAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public PictureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.picture_card, parent, false);

        return new PictureHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final PictureHolder holder, int position) {
        PictureModel pictureModel = pictureList.get(position);
        holder.title.setText(pictureModel.getTitle());
        holder.date.setText(DateUtil.dateFormetterForMainScreen(pictureModel.getDate()));
        holder.picture.setImageBitmap(pictureModel.getPicture());

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictureList == null ? 0 : pictureList.size();
    }

    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_picture, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_remove_picture:
                    Toast.makeText(mContext, "Remove picture", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}

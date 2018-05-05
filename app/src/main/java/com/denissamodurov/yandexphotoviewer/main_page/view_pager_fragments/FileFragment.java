package com.denissamodurov.yandexphotoviewer.main_page.view_pager_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denissamodurov.yandexphotoviewer.R;

/**
 * Created by denissamodurov on 05/05/2018.
 */

public class FileFragment extends Fragment {
    public FileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.file_fragment, container, false);
    }
}

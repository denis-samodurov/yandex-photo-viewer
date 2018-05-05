package com.denissamodurov.yandexphotoviewer.main_page.view_pager_fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denissamodurov.yandexphotoviewer.R;

public class StripFragment extends Fragment implements StripFragmentView{

    public StripFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.strip_fragment, container, false);
    }
}

interface StripFragmentView {

}
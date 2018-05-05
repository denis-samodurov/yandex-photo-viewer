package com.denissamodurov.yandexphotoviewer.main_page.view_pager_fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denissamodurov.yandexphotoviewer.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class StripFragment extends Fragment {

    public StripFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.strip_fragment, container, false);
    }
}

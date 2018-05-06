package com.denissamodurov.yandexphotoviewer.main_page.view_pager_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denissamodurov.yandexphotoviewer.R;

public class StripFragment extends Fragment implements StripFragmentView{
    private RecyclerView recyclerView;

    public StripFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflateView = inflater.inflate(R.layout.strip_fragment, container, false);
        setUpRecyclerView(inflateView);
        populateRecyclerView(inflateView);
        return inflateView;
    }

    private void setUpRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.strip_fragment_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void populateRecyclerView(View view) {
        //TODO setup adapter

    }
}

interface StripFragmentView {

}
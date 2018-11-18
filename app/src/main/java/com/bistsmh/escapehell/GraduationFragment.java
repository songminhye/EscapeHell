package com.bistsmh.escapehell;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class GraduationFragment extends Fragment{
    View myView;
    private List<String> mData;
    private ArrayAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.graduation_layout, container, false);

        //졸업요건 data준비
        // initData();
        //졸업요건 adapter준비
        //initAdapter();
        //졸업요건 listview에 adapter를 장착

        return myView;
    }}

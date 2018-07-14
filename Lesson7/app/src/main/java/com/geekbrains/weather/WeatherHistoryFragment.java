package com.geekbrains.weather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WeatherHistoryFragment extends BaseFragment {

    private static final String ARG_COUNTRY = "ARG_COUNTRY";
    private TextView textView;
    private String country;

    private ArrayList<String> timeList;
    private ArrayList<String> tempList;

    private RecyclerView tempRV;
    private RecyclerView timeRV;

    CreateActionFragment.OnHeadlineSelectedListener mCallback;


    public WeatherHistoryFragment() {
    }

    public static WeatherHistoryFragment newInstance(String country) {
        Bundle args = new Bundle();
        args.putString(ARG_COUNTRY, country);
        WeatherHistoryFragment fragment = new WeatherHistoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            country = getArguments().getString(ARG_COUNTRY);
        }
    }

    @Override
    protected void initLayout(View view, Bundle savedInstanceState) {
        textView = view.findViewById(R.id.tv_country);
        textView.setText(country);

        initTimeList();
        initTempList();

        tempRV = view.findViewById(R.id.WH_temp_list_view);
        tempRV.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        tempRV.setLayoutManager(linearLayoutManager);

        WHTempAdapter whTempAdapter = new WHTempAdapter(getContext(), tempList, mCallback);
        tempRV.setAdapter(whTempAdapter);



        timeRV = view.findViewById(R.id.WH_time_list_view);
        timeRV.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        timeRV.setLayoutManager(linearLayoutManager1);

        WHTimeAdapter whTimeAdapter = new WHTimeAdapter(getContext(), timeList, mCallback);
        timeRV.setAdapter(whTimeAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //обращаемся к layout который будет содержать наш фрагмент
        return inflater.inflate(R.layout.weather_history_fragment, container, false);
    }


    private void initTimeList() {
        timeList = new ArrayList<>();
        timeList.add(getString(R.string.time17_00));
        timeList.add(getString(R.string.time18_00));
        timeList.add(getString(R.string.time19_00));
    }

    private void initTempList() {
        tempList = new ArrayList<>();
        tempList.add(getString(R.string.pls18));
        tempList.add(getString(R.string.pls19));
        tempList.add(getString(R.string.pls17));
    }
}

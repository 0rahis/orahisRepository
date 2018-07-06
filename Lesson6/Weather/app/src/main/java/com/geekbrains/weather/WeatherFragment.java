package com.geekbrains.weather;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WeatherFragment extends BaseFragment implements CreateActionFragment.onEditListener {

    private static final String ARG_COUNTRY = "ARG_COUNTRY";
    private String country;
    private TextView textView;

    final static String contryKey = "COUNTRY_VARIABLE";

    private static final String TAG = "WeatherFragment";

    public WeatherFragment() {
    }

    public static WeatherFragment newInstance(String country) {
        Bundle args = new Bundle();
        args.putString(ARG_COUNTRY, country);

        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            country = getArguments().getString(ARG_COUNTRY);
        }
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.weather_layout, container, false);
    }

    @Override
    protected void initLayout(View view, Bundle savedInstanceState) {
        textView = view.findViewById(R.id.tv_country);

        if (country != null && country.length() > 0) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(country);
        } else {
            textView.setVisibility(View.GONE);
        }

    }

    @Override
    public void onEdited(String country) {
        this.country = country;
        if (country != null && country.length() > 0) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(country);
        } else {
            textView.setVisibility(View.GONE);
//            onSaveInstanceState();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}

package com.geekbrains.weather;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import es.dmoral.toasty.Toasty;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";
    private static final String TEXT = "TEXT";
    private static final String PLACE = "PLACE";
    private TextView textView;
    private TextView tvPlace;
    private TextView tvTemperature;
    private FloatingActionButton fab;
    private Boolean isPressed = false;
    private  int currentTime;

    private  Button btnPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main);
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск";
        } else {
            instanceState = "Повторный запуск";
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Toasty.success(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();

        textView = findViewById(R.id.tv);
        tvPlace = findViewById(R.id.tvPlace);
        tvTemperature = findViewById(R.id.tvTemperature);
        fab = findViewById(R.id.fab);
        this.currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        btnPlace = findViewById(R.id.btnPlace);

        if (getIntent().getExtras() != null) {
            String text = getIntent().getExtras().getString(TEXT);
            if (5 < currentTime && currentTime <= 10) {
                textView.setText("Доброе утро, " + text);
            } else if (10 < currentTime && currentTime <= 16) {
                textView.setText("Добрый день, " + text);
            } else  {
                textView.setText("Добрый вечер, " + text);
            }

            String place = getIntent().getExtras().getString(PLACE);
            tvPlace.setText(place);
        }

        if(!tvPlace.getText().equals("Moscow")){
            tvTemperature.setText("-10");
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPressed) {
                    isPressed = true;
                    startNewActivity();
                }
            }
        });

        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPressed) {
                    isPressed = true;
                    startPlaceChangeActivity();
                }
            }
        });

        Log.d(TAG, "onCreate");
    }

    private void startNewActivity() {
        Intent intent = new Intent(this, CreateActionActivity.class);
        startActivity(intent);
    }

    private void startPlaceChangeActivity() {
        Intent intent = new Intent(this, ChangePlaceActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isPressed = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}

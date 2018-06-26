package com.geekbrains.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class ChangePlaceActivity extends AppCompatActivity {

    private static final String PLACE = "PLACE";
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_place_activity);

        editText = findViewById(R.id.etPlace);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(this, WeatherActivity.class);
        intent.putExtra(PLACE, editText.getText().toString().trim());
        startActivity(intent);
        finish();
    }

}

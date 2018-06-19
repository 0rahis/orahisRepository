package com.example.orahis.helloworld;

import android.content.res.Resources;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity implements IGetStrings {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_hello);

        BuilderPhrase builderPhrase = new BuilderPhrase(this);
        textView.setText(builderPhrase.get());

    }


    @Override
    public String getMorning() {
        return getResources().getString(R.string.morning);
    }

    @Override
    public String getHello() {
        return getResources().getString(R.string.hello);
    }

    @Override
    public String getAfternoon() {
        return getResources().getString(R.string.afternoon);
    }
}

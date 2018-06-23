package com.example.orahis.helloworld;

import android.content.res.Resources;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.N)
public class WeatherActivity extends AppCompatActivity implements IGetStrings {

    TextView textView;
    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main);

//        textView = findViewById(R.id.tv_hello);
        //        BuilderPhrase builderPhrase = new BuilderPhrase(this);
//        textView.setText(builderPhrase.get());

        getSupportActionBar().setTitle(getResources().getString(R.string.country));



        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()",
                Toast.LENGTH_SHORT).show();

        Log.d(TAG, instanceState +" - onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        Toast.makeText(getApplicationContext(), "onStart",
        Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        Toast.makeText(getApplicationContext(), "onPause",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        Toast.makeText(getApplicationContext(), "onResume",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
        Toast.makeText(getApplicationContext(), "onRestart",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        Toast.makeText(getApplicationContext(), "onStop",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        Toast.makeText(getApplicationContext(), "onDestroy",
                Toast.LENGTH_SHORT).show();
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

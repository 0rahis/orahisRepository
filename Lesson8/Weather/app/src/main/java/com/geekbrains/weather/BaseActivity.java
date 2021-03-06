package com.geekbrains.weather;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity
        implements BaseView.View, BaseFragment.Callback, NavigationView.OnNavigationItemSelectedListener {

    //инициализация переменных
    private FloatingActionButton fab;
    private TextView textView;
    private static final String TEXT = "TEXT";
    private static String contry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            TextView tv = findViewById(R.id.tvUsername);
//            contry = savedInstanceState.getString("NAME");
            contry = savedInstanceState.getString("ARG_COUNTRY");
        }
        setContentView(R.layout.activity_base);

        initLayout();
    }


    private void initLayout() {
        //устанавливает тулбар
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //устанавливаем drawer (выездное меню)
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //анимация клавищи (три палочки сверху) выездного меня
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //инициализация навигации
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getSupportFragmentManager().findFragmentById(R.id.content_frame) instanceof WeatherFragment){
                    //запускаем CreateActionFragment
                    addFragment(new CreateActionFragment());
                } else if (getSupportFragmentManager().findFragmentById(R.id.content_frame) instanceof CreateActionFragment){
                    addFragment(new WeatherHistoryFragment());
                } else if (getSupportFragmentManager().findFragmentById(R.id.content_frame) instanceof WeatherHistoryFragment) {
                    startWeatherFragment(contry);
//                    ScrollingActivity scrollingActivity = new ScrollingActivity();
//                    startActivity(scrollingActivity);
                }

            }
        });


        //addFragment(new WeatherFragment());
        startWeatherFragment(contry);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            addFragment1(new CreateActionFragment());
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startWeatherHistoryFragment(contry);
                }
            });
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("ARG_COUNTRY", ((TextView) findViewById(R.id.tvUsername)).getText().toString());
        super.onSaveInstanceState(outState);
    }


    protected void addFragment(Fragment fragment) {
        //вызываем SupportFragmentManager и указываем в каком контейнере будет находиться наш фрагмент
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                //.addToBackStack("")
                .commit();
    }

    void addFragment1(Fragment fragment) {
        //вызываем SupportFragmentManager и указываем в каком контейнере будет находиться наш фрагмент
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame2, fragment)
                //.addToBackStack("")
                .commit();
    }


    private Fragment getCurrentFragment() {
        //получаем наименование фрагмента находящегося в контейнере в данных момент
        return getSupportFragmentManager().findFragmentById(R.id.content_frame);
    }

    @Override
    public void onBackPressed() {
        //закрываем drawer если он был открыт при нажатии на аппаратную клавишу назад
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(getCurrentFragment() instanceof WeatherHistoryFragment){
            startWeatherFragment(contry);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //работаем с навигацией
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        int id = item.getItemId();

        if (id == R.id.nav_settings) {
            // Handle the camera action
        } else if (id == R.id.nav_info) {
            // Handle the camera action
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public Boolean inNetworkAvailable() {
        return true;
    }

    @Override
    public void initDrawer(String username, Bitmap profileImage) {

    }

    @Override
    public void onFragmentAttached() {


    }

    @Override
    public void onFragmentDetached(String tag) {

    }


    public void startWeatherFragment(String country) {
        //запускаем WeatherFragment и передаем туда country
        addFragment(WeatherFragment.newInstance(country));
        //cntry = country;
    }

    public void startWeatherHistoryFragment(String country) {
        addFragment1(WeatherHistoryFragment.newInstance(country));
    }


    public Fragment getAnotherFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.content_frame);

    }
}

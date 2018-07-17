package com.geekbrains.weather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by shkryaba on 24/06/2018.
 */

public class CreateActionFragment extends BaseFragment {

    //объявление переменных
    private EditText editTextCountry;
    private RecyclerView recyclerView;
    OnHeadlineSelectedListener mCallback;
    private LinearLayout linearLayout;
    private ArrayList<String> cityList;
    private TextInputLayout textInputLayout;

//    private Button swapFragmetToWeatherHistoryBtn;

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(ArrayList<String> position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(), "onAttachAction", Toast.LENGTH_SHORT).show();

        try {
            mCallback = (OnHeadlineSelectedListener) getBaseActivity().getAnotherFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(getBaseActivity().getAnotherFragment().toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //обращаемся к layout который будет содержать наш фрагмент
        return inflater.inflate(R.layout.create_action_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void initLayout(View view, Bundle savedInstanceState) {
        initCountryList();

        recyclerView = view.findViewById(R.id.list_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        CustomAdapter customAdapter = new CustomAdapter(getContext(), cityList, mCallback);
        recyclerView.setAdapter(customAdapter);



        //инициализация edittext и листенер на ключи при взаимодействии с ним, когда мы нашимаем enter у нас опускается клавиатура и запускается WeatherFragment
        editTextCountry = (EditText) view.findViewById(R.id.et_country);

        editTextCountry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    if (charastersCheck()){
                        showError();
                    } else hideError();

                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    String country = editTextCountry.getText().toString().trim();
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(country);
                    mCallback.onArticleSelected(arrayList);
                    return true;
                }
                return false;
            }
        });

        textInputLayout = view.findViewById(R.id.text_input);

    }


    private void showError() {
        textInputLayout.setError("Error");
    }

    private void hideError() {
        textInputLayout.setError("");
    }

    private boolean charastersCheck() {
        if((editTextCountry.getText().toString().indexOf('=') != -1) ||
                (editTextCountry.getText().toString().indexOf('/') != -1) ||
                (editTextCountry.getText().toString().indexOf('+') != -1) ||
                (editTextCountry.getText().toString().indexOf('_') != -1) ||
                (editTextCountry.getText().toString().indexOf(')') != -1) ||
                (editTextCountry.getText().toString().indexOf('(') != -1) ||
                (editTextCountry.getText().toString().indexOf('*') != -1) ||
                (editTextCountry.getText().toString().indexOf('&') != -1) ||
                (editTextCountry.getText().toString().indexOf('^') != -1) ||
                (editTextCountry.getText().toString().indexOf('%') != -1) ||
                (editTextCountry.getText().toString().indexOf('$') != -1) ||
                (editTextCountry.getText().toString().indexOf('#') != -1) ||
                (editTextCountry.getText().toString().indexOf('@') != -1) ||
                (editTextCountry.getText().toString().indexOf('!') != -1) ||
                (editTextCountry.getText().toString().indexOf('"') != -1) ||
                (editTextCountry.getText().toString().indexOf('№') != -1) ||
                (editTextCountry.getText().toString().indexOf(';') != -1) ||
                (editTextCountry.getText().toString().indexOf(':') != -1) ||
                (editTextCountry.getText().toString().indexOf('?') != -1) ||
                (editTextCountry.getText().toString().indexOf('1') != -1) ||
                (editTextCountry.getText().toString().indexOf('2') != -1) ||
                (editTextCountry.getText().toString().indexOf('3') != -1) ||
                (editTextCountry.getText().toString().indexOf('4') != -1) ||
                (editTextCountry.getText().toString().indexOf('5') != -1) ||
                (editTextCountry.getText().toString().indexOf('6') != -1) ||
                (editTextCountry.getText().toString().indexOf('7') != -1) ||
                (editTextCountry.getText().toString().indexOf('8') != -1) ||
                (editTextCountry.getText().toString().indexOf('9') != -1) ||
                (editTextCountry.getText().toString().indexOf('0') != -1)) {
            return true;
        }
        return false;
    }


    private void initCountryList() {
        cityList = new ArrayList<>();
        cityList.add(getString(R.string.moscow));
        cityList.add(getString(R.string.st_peterburg));
        cityList.add(getString(R.string.kazan));
    }
}

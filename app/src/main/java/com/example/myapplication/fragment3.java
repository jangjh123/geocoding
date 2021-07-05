package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class fragment3 extends Fragment {

    private TextView currentMileage, afterMileage;
    private EditText money;
    private int money_for, c_mile, a_mile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);

        c_mile = 100000;

        money = view.findViewById(R.id.money);
        currentMileage = view.findViewById(R.id.currentMileage);
        afterMileage = view.findViewById(R.id.afterMileage);

        currentMileage.setText(c_mile+"");

        money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    money_for = Integer.parseInt(money.getText().toString());
                    a_mile = c_mile - money_for;
                    afterMileage.setText(a_mile+"");
                    if (money_for > c_mile) {
                        money.setText("");
                        afterMileage.setText("");
                        Toast.makeText(getActivity(), "현재 마일리지보다 큰 금액은 인출할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    afterMileage.setText("");
                }


            }
        });

        return view;
    }
}
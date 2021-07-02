package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class fragment12 extends Fragment {
    Animation fadeIn, fadeOut;
    private EditText editText;
    private Button button, button2;
    private TextView textView, textView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment12, container, false);

        editText = view.findViewById(R.id.editText);
        textView = view. findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);
        button = view.findViewById(R.id.button);
        textView2 = view.findViewById(R.id.textView2);
        button2 = view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeIn = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_in);
                fadeOut = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_out);

                textView.startAnimation(fadeIn);
                String money = convertHangul(editText.getText().toString());
                textView.setText(money + "");
            }
        });

        return view;
    }
    public String convertHangul(String money) {
        String[] han1 = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
        String[] han2 = {"", "십", "백", "천"};
        String[] han3 = {"", "만", "억", "조", "경"};

        StringBuffer result = new StringBuffer();
        int len = money.length(); // len == money 의 길이.
        for (int i = len - 1; i >= 0; i--) {
            result.append(han1[Integer.parseInt(money.substring(len - i - 1, len - i))]);
            if (Integer.parseInt(money.substring(len - i - 1, len - i)) > 0)
                result.append(han2[i % 4]);
            if (i % 4 == 0)
                result.append(han3[i / 4]);
        }

        return result.toString();
    }
}
package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonHozzaad;
    private Button buttonKivon;
    private TextView TextViewOut;
    private int szam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        TextViewOut.setText("0");
        TextViewOut.setTextColor(Color.BLUE);
        TextViewOut.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                TextViewOut.setText("0");
                TextViewOut.setTextColor(Color.BLUE);
                return false;
            }
        });
        TextViewOut.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (szam > 0) {
                    TextViewOut.setTextColor(Color.GREEN);
                }
                else if (szam < 0) {
                    TextViewOut.setTextColor(Color.RED);
                }

                else {
                    TextViewOut.setTextColor(Color.BLUE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        buttonKivon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                szam--;
                TextViewOut.setText(String.valueOf(szam));
            }
        });

        buttonHozzaad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                szam++;

                TextViewOut.setText(String.valueOf(szam));
            }
        });

    }
    private void init() {
        buttonHozzaad = findViewById(R.id.buttonHozzaad);
        buttonKivon = findViewById(R.id.buttonKivon);
        TextViewOut = findViewById(R.id.TextViewOut);
        szam = 0;

    }
}
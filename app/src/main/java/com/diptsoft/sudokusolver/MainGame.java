package com.diptsoft.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainGame extends AppCompatActivity {
    String game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
//        RelativeLayout main_layout=(RelativeLayout)findViewById(R.id.relativeLayout) ;
//        toast(String.valueOf(main_layout.getMeasuredHeight()));
//
//        Button b1=new Button(this);
//        b1.setText("Button");
//        main_layout.addView(b1);
    }
}
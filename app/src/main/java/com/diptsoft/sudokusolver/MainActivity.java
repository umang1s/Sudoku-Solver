package com.diptsoft.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.LinearLayout1);
//
//        LinearLayout L2 = new LinearLayout(this);
//        L2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        L2.setGravity(Gravity.CENTER);
//
//
//        TextView a1 = new TextView(this);
//        a1.setText("Dynamic layouts ftw!");
//        a1.setVisibility(View.VISIBLE);
//
//        Button b1 = new Button(this);
//        b1.setText("SUBMIT");
//
//        L2.addView(a1,(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,0.8f)));
//        L2.addView(b1,(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,0.8f)));
//
//        linearLayout.addView(L2);
    }

    void toast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    //ViewTreeObserver viewTreeObserver = fdfs.getViewTreeObserver();
//if (viewTreeObserver.isAlive()) {
//        viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                viewWidth = view.getWidth();
//                viewHeight = view.getHeight();
//            }
//        });
//    }

    public void solveYourOwn(View view){
        toast("Solve your own");
    }

    public void easyButtonClicked(View view){
        toast("Easy Button clicked");
    }
}
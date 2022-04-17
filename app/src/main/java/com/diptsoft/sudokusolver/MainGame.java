package com.diptsoft.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainGame extends AppCompatActivity {
    private Sudoku game,solution;
    private GridView gameGrid;
    private int[][] data;
    private boolean editable;
    private TextView timerText,avgText;
    private MaterialButton solutionButton;
    int timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game=(Sudoku) getIntent().getSerializableExtra("game");
        timer=0;
        editable=getIntent().getBooleanExtra("Editable",false);
        setContentView(R.layout.activity_main_game);
        timerText=(TextView)findViewById(R.id.timer);
        avgText=(TextView)findViewById(R.id.avg_time);
        solutionButton=(MaterialButton)findViewById(R.id.solution_button);
        if(game.getAvgTime()!=-1) avgText.setText(getStringTime(game.getAvgTime()));
        else avgText.setVisibility(View.INVISIBLE);
        if(editable) solutionButton.setVisibility(View.VISIBLE);
        if(editable) startTimer();
    }


    public void getSolutionButton(View view){
        if(editable){
            if(getSolution()){
                Intent intent=new Intent(this,MainGame.class);
                intent.putExtra("game",solution);
                intent.putExtra("Editable",false);
                startActivity(intent);
            }else toast("Invalid Sudoku");
        }

    }

    private void toast(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    private boolean getSolution(){
        solution=game;
        return true;
    }

    private String getStringTime(int val){
        String ret="";
        int hrs=val/3600;
        val%=3600;
        int mnt=val/60;
        val%=60;
        if(hrs>0){
            if(hrs<10) ret+="0";
            ret+=Integer.toString(hrs);
            ret+=":";
        }
        if(mnt<10) ret+="0";
        ret+=Integer.toString(mnt);
        ret+=":";
        if(val<10) ret+="0";
        ret+=Integer.toString(val);
        return ret;
    }

    private void startTimer(){
        if(timer==game.getAvgTime())timerText.setTextColor(Color.RED);
        timer++;
        timerText.setText(getStringTime(timer));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startTimer();
            }
        }, 990);
    }



}
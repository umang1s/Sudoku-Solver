package com.diptsoft.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainGame extends AppCompatActivity {
    private Sudoku game;
    private GridView gameGrid;
    private int[][] data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game=(Sudoku) getIntent().getSerializableExtra("game");
        setContentView(R.layout.activity_main_game);
        TextView textView=(TextView) findViewById(R.id.textview);
        textView.setText(Integer.toString(game.getID()));
        gameGrid=(GridView) findViewById(R.id.gameGrid);
        gameGrid.setAdapter(new SudokuGridButton(data,this));
    }


}
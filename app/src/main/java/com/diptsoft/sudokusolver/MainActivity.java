package com.diptsoft.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Level> levels;
    ArrayAdapter<Level> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readLevels();
        listView = (ListView) findViewById(R.id.listview);
        adapter=new LevelArrayAdapter(this,0,levels);
        listView.setAdapter(adapter);
    }

    void toast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
    public void solveYourOwn(View view){
        toast("Solve your own");
    }

    private void readLevels(){
        levels=new ArrayList<>();
        Level hard,medium,easy;
        //read hard sudoku
        hard=new Level("Hard");
        Sudoku tempSudoku=new Sudoku("first",54,-1,"f");
        for(int i=0; i<10; i++) hard.addSudoku(tempSudoku);

        //read medium sudoku
        medium=new Level("Medium");
        //read easy Sudoku
        easy=new Level("Easy");



        levels.add(easy);
        levels.add(medium);
        levels.add(hard);
    }
}
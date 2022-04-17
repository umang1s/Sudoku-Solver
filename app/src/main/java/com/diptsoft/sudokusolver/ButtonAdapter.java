package com.diptsoft.sudokusolver;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class ButtonAdapter extends BaseAdapter {

    private Context context;
    ArrayList<Sudoku> data;


    public ButtonAdapter(Context context, ArrayList<Sudoku> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Sudoku sudoku=data.get(i);
        Button button=new Button(context);
        button.setText(Integer.toString(i+1));
        button.setPadding(5,5,5,5);
        if(sudoku.getSolvedTime()!=-1) button.setTextColor(Color.YELLOW);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,MainGame.class);
                intent.putExtra("game",sudoku);
                intent.putExtra("Editable",true);
                context.startActivity(intent);
            }
        });
        return button;
    }
}

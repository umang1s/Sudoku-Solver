package com.diptsoft.sudokusolver;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class SudokuGridButton extends BaseAdapter {
    private int[][] data;

    public SudokuGridButton(int[][] data, Context context) {
        this.data = data;
        this.context = context;
    }

    private Context context;

    @Override
    public int getCount() {
        return 81;
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
//        Button button=new Button(context);
//        button.setText(Integer.toString(i));
//        return button;
        TextView textView=new TextView(context);
        textView.setText(Integer.toString(i));
        textView.setGravity(0);
        return textView;
    }
}

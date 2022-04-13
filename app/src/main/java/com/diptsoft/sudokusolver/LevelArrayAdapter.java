package com.diptsoft.sudokusolver;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class LevelArrayAdapter extends ArrayAdapter<Level> {
    private  Context context;
    private List<Level> data;
    public LevelArrayAdapter(@NonNull Context context, int resource, ArrayList<Level> objects) {
        super(context, resource,objects);
        this.context=context;
        this.data=objects;
    }
    public void levelButtonClicked(View view){

    }
    private String getImage(double stars,int poistion){
        double pos=(double) poistion;

        return "ic_baseline_star24";
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Level level=data.get(position);
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.level_button,null);
        ImageView star1,star2,star3,star4,star5;
        star1=view.findViewById(R.id.star1);
        star2=view.findViewById(R.id.star2);
        star3=view.findViewById(R.id.star3);
        star4=view.findViewById(R.id.star4);
        star5=view.findViewById(R.id.star5);
        star1.setImageResource(context.getResources().getIdentifier(getImage(level.getStars(),1),"drawable",context.getPackageName()));
        star2.setImageResource(context.getResources().getIdentifier(getImage(level.getStars(),2),"drawable",context.getPackageName()));
        star3.setImageResource(context.getResources().getIdentifier(getImage(level.getStars(),3),"drawable",context.getPackageName()));
        star4.setImageResource(context.getResources().getIdentifier(getImage(level.getStars(),4),"drawable",context.getPackageName()));
        star5.setImageResource(context.getResources().getIdentifier(getImage(level.getStars(),5),"drawable",context.getPackageName()));

        TextView textView=view.findViewById(R.id.levelText);
        textView.setText(level.getName());
        GridLayout gridLayout=view.findViewById(R.id.levelNumber);
        if(level.getVisibility()) gridLayout.setVisibility(View.VISIBLE);
        else gridLayout.setVisibility(View.INVISIBLE);

        return view;
    }
}

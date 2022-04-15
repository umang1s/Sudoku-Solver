package com.diptsoft.sudokusolver;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    private int getSource(int stars,int pos){
        int temp=2* pos;
        if(stars>=temp) return  R.drawable.ic_baseline_star_24;
        if(stars+1==temp) return R.drawable.ic_baseline_star_half_24;
        return R.drawable.ic_baseline_star_border_24;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Level level=data.get(position);
        int stars=level.getStars();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.level_button,null);
        ImageView star1,star2,star3,star4,star5;
        star1=view.findViewById(R.id.star1);
        star2=view.findViewById(R.id.star2);
        star3=view.findViewById(R.id.star3);
        star4=view.findViewById(R.id.star4);
        star5=view.findViewById(R.id.star5);
        star1.setBackgroundResource(getSource(stars,1));
        star2.setBackgroundResource(getSource(stars,2));
        star3.setBackgroundResource(getSource(stars,3));
        star4.setBackgroundResource(getSource(stars,4));
        star5.setBackgroundResource(getSource(stars,5));
        RelativeLayout rl=view.findViewById(R.id.levelMode);
        GridView gridView=view.findViewById(R.id.levelNumber);
        gridView.setAdapter(new ButtonAdapter(context,level.getLevels()));
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level.changeVisibility();
                if(level.getVisibility()) gridView.animate().alpha(1f).setDuration(50)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    gridView.setVisibility(View.VISIBLE);
                                }
                            });
                else gridView.animate().alpha(0f)
                            .setDuration(100)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    gridView.setVisibility(View.GONE);
                                }
                            });
            }
        });

        TextView textView=view.findViewById(R.id.levelText);
        textView.setText(level.getName());

        return view;
    }
}

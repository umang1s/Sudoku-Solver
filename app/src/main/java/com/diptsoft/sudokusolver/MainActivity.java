package com.diptsoft.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Level easyLevel,mediumLevel,hardLevel;
    private GridView easyGrid,mediumGrid,hardGrid;
    private TextView easyText,hardText,mediumText;
    private RelativeLayout easyButton,mediumButton,hardButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readLevels();
        easyGrid=(GridView)findViewById(R.id.easyGrid);
        mediumGrid=(GridView)findViewById(R.id.mediumGrid);
        hardGrid=(GridView)findViewById(R.id.hardGrid);

        easyGrid.setAdapter(new ButtonAdapter(this,easyLevel.getLevels()));
        mediumGrid.setAdapter(new ButtonAdapter(this,mediumLevel.getLevels()));
        hardGrid.setAdapter(new ButtonAdapter(this,hardLevel.getLevels()));

        easyButton=(RelativeLayout)findViewById(R.id.easyHeader);
        mediumButton=(RelativeLayout)findViewById(R.id.mediumHeader);
        hardButton=(RelativeLayout)findViewById(R.id.hardHeader);

        easyText=(TextView) findViewById(R.id.easyText);
        mediumText=(TextView) findViewById(R.id.mediumText);
        hardText=(TextView) findViewById(R.id.hardText);


//        //setting up easy buttons
        int easyStars=easyLevel.getStars();
        ImageView easyStar1,easyStar2,easyStar3,easyStar4,easyStar5;
        easyStar1=(ImageView)findViewById(R.id.easyStar1);
        easyStar2=(ImageView)findViewById(R.id.easyStar2);
        easyStar3=(ImageView)findViewById(R.id.easyStar3);
        easyStar4=(ImageView)findViewById(R.id.easyStar4);
        easyStar5=(ImageView)findViewById(R.id.easyStar5);
        easyStar1.setBackgroundResource(getSource(easyStars,1));
        easyStar2.setBackgroundResource(getSource(easyStars,2));
        easyStar3.setBackgroundResource(getSource(easyStars,3));
        easyStar4.setBackgroundResource(getSource(easyStars,4));
        easyStar5.setBackgroundResource(getSource(easyStars,5));
        easyText.setText(easyLevel.getName());
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                easyLevel.changeVisibility();
                if(easyLevel.getVisibility()){
                    if(mediumLevel.getVisibility()){
                        mediumLevel.changeVisibility();
                        mediumGrid.setVisibility(View.GONE);
                    }
                    if(hardLevel.getVisibility()){
                        hardLevel.changeVisibility();
                        hardGrid.setVisibility(View.GONE);
                    }
                    easyGrid.setVisibility(View.VISIBLE);
                }
                else easyGrid.setVisibility(View.GONE);
            }
        });





//        ///////medium button setup
        int mediumStars=mediumLevel.getStars();
        ImageView mediumStar1,mediumStar2,mediumStar3,mediumStar4,mediumStar5;
        mediumStar1=(ImageView)findViewById(R.id.mediumStar1);
        mediumStar2=(ImageView)findViewById(R.id.mediumStar2);
        mediumStar3=(ImageView)findViewById(R.id.mediumStar3);
        mediumStar4=(ImageView)findViewById(R.id.mediumStar4);
        mediumStar5=(ImageView)findViewById(R.id.mediumStar5);
        mediumStar1.setBackgroundResource(getSource(mediumStars,1));
        mediumStar2.setBackgroundResource(getSource(mediumStars,2));
        mediumStar3.setBackgroundResource(getSource(mediumStars,3));
        mediumStar4.setBackgroundResource(getSource(mediumStars,4));
        mediumStar5.setBackgroundResource(getSource(mediumStars,5));
        mediumText.setText(mediumLevel.getName());
        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediumLevel.changeVisibility();
                if(mediumLevel.getVisibility()){
                    if(easyLevel.getVisibility()){
                        easyLevel.changeVisibility();
                        easyGrid.setVisibility(View.GONE);
                    }
                    if(hardLevel.getVisibility()){
                        hardLevel.changeVisibility();
                        hardGrid.setVisibility(View.GONE);
                    }
                    mediumGrid.setVisibility(View.VISIBLE);

                }
                else mediumGrid.setVisibility(View.GONE);
            }
        });






        ////Setting up Hard Button
        int hardStars=hardLevel.getStars();
        ImageView hardStar1,hardStar2,hardStar3,hardStar4,hardStar5;
        hardStar1=(ImageView)findViewById(R.id.hardStar1);
        hardStar2=(ImageView)findViewById(R.id.hardStar2);
        hardStar3=(ImageView)findViewById(R.id.hardStar3);
        hardStar4=(ImageView)findViewById(R.id.hardStar4);
        hardStar5=(ImageView)findViewById(R.id.hardStar5);
        hardStar1.setBackgroundResource(getSource(hardStars,1));
        hardStar2.setBackgroundResource(getSource(hardStars,2));
        hardStar3.setBackgroundResource(getSource(hardStars,3));
        hardStar4.setBackgroundResource(getSource(hardStars,4));
        hardStar5.setBackgroundResource(getSource(hardStars,5));
        hardText.setText(hardLevel.getName());
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hardLevel.changeVisibility();
                if(hardLevel.getVisibility()){
                    if(easyLevel.getVisibility()){
                        easyLevel.changeVisibility();
                        easyGrid.setVisibility(View.GONE);
                    }
                    if(mediumLevel.getVisibility()){
                        mediumLevel.changeVisibility();
                        mediumGrid.setVisibility(View.GONE);
                    }
                    hardGrid.setVisibility(View.VISIBLE);
                }
                else hardGrid.setVisibility(View.GONE);
            }
        });

    }
    public void  launchEmptyGame(View view){
        Intent intent=new Intent(this,MainGame.class);
        Sudoku sudoku=new Sudoku(0,".................................................................................",-1,-1,"");
        intent.putExtra("game",sudoku);
        intent.putExtra("Editable",true);
        startActivity(intent);
    }

    void toast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    private void readLevels(){
        Games games=new Games();
        hardLevel=new Level("Hard",games.getHard());
        mediumLevel=new Level("Medium",games.getMedium());
        //read easy Sudoku
        easyLevel=new Level("Easy",games.getEasy());
        //check is data saved in database



        //read hard sudoku
    }

    private int getSource(int stars,int pos){
        int temp=2* pos;
        if(stars>=temp) return  R.drawable.ic_baseline_star_24;
        if(stars+1==temp) return R.drawable.ic_baseline_star_half_24;
        return R.drawable.ic_baseline_star_border_24;
    }
}
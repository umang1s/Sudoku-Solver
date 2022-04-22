package com.diptsoft.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainGame extends AppCompatActivity {
    private Sudoku game,solution;
    private boolean editable;
    private TextView timerText,avgText;
    private MaterialButton solutionButton;
    private ViewTreeObserver vto;
    int timer;
    GameGrid gameGrid;
    Solution solver;
    private boolean updating;
    private LinearLayout numpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game=(Sudoku) getIntent().getSerializableExtra("game");
        timer=0;
        updating=false;
        editable=getIntent().getBooleanExtra("Editable",false);
        solver=new Solution(game.getGame());
        setContentView(R.layout.activity_main_game);
        timerText=(TextView)findViewById(R.id.timer);
        avgText=(TextView)findViewById(R.id.avg_time);
        solutionButton=(MaterialButton)findViewById(R.id.solution_button);
        if(game.getAvgTime()!=-1) avgText.setText(getStringTime(game.getAvgTime()));
        else avgText.setVisibility(View.INVISIBLE);
        if(editable) solutionButton.setVisibility(View.VISIBLE);
        if(editable) startTimer();
        gameGrid=findViewById(R.id.game_grid);
        numpad=findViewById(R.id.num_pad);


         vto= gameGrid.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                gameGrid.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                gameGrid.setGame(solver.getGridValue(),solver.getBooleanValue());
            }
        });
        if(editable){
            gameGrid.setOnTouchListener((view, motionEvent) -> {
                if(!updating){
                    float x=motionEvent.getX(),y=motionEvent.getY();
                    int[] location=new int[2];
                    view.getLocationOnScreen(location);
                    float width=view.getWidth();
                    if(y<=view.getWidth()){
                        float side=width/9;
                        int X=(int) (x/side),Y= (int) (y/side);
                        if(solver.isEditable(Y,X)) {
                            int num=getNumber(Y,X);
                            if(num!=-1 && num!=solver.getValue(Y,X)){
                                gameGrid.update(X,Y,num);
                                solver.set(X,Y,num);
                            }
                        }
                    }
                }
                return false;
            });
        }



    }

    public int getNumber (int x,int y){
        updating=true;
        Dialog dialog=new Dialog(this);

        //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        LayoutInflater m_inflater = LayoutInflater.from(this);
        View m_view = m_inflater.inflate(R.layout.num_pad, null);
        //myPopLay = (LinearLayout) m_view.findViewById(R.id.myPopLay);
        dialog.setContentView(m_view);
        dialog.show();


        updating=false;
        return -1;
    }


    public void getSolutionButton(View view){
        if(editable){
            if(solver.solve()){
                Log.d("sol",solver.getSolution());
                solution=new Sudoku(game.getID(),solver.getSolution(),game.getAvgTime(),game.getSolvedTime(),game.getSubmittedSolution());
                solver.reset();
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
        timerText.setText(getStringTime(timer));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                timer++;
                startTimer();
            }
        }, 990);
    }

    public void numButtonClicked(View view){
        Log.d("Button Clicked",Integer.toString(view.getId()));
    }

}
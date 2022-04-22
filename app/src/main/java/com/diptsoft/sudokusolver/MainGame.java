package com.diptsoft.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
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
    private MaterialButton solutionButton,resetButton;
    private ViewTreeObserver vto;
    private AlertDialog dialog;
    private int buttonClickedX,buttonClickedY;
    int timer;
    GameGrid gameGrid;
    Solution solver;
    private LinearLayout numpad;
    private ArrayList<Integer> suggestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game=(Sudoku) getIntent().getSerializableExtra("game");
        timer=0;
        editable=getIntent().getBooleanExtra("Editable",false);
        solver=new Solution(game.getGame());
        setContentView(R.layout.activity_main_game);
        timerText=(TextView)findViewById(R.id.timer);
        avgText=(TextView)findViewById(R.id.avg_time);
        solutionButton=(MaterialButton)findViewById(R.id.solution_button);
        resetButton=findViewById(R.id.reset_button);
        if(game.getAvgTime()!=-1) avgText.setText(getStringTime(game.getAvgTime()));
        else avgText.setVisibility(View.INVISIBLE);
        if(editable){
            solutionButton.setVisibility(View.VISIBLE);
            startTimer();
            if(game.getAvgTime()==-1) resetButton.setVisibility(View.VISIBLE);
        }
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
                if(true){
                    float x=motionEvent.getX(),y=motionEvent.getY();
                    int[] location=new int[2];
                    view.getLocationOnScreen(location);
                    float width=view.getWidth();
                    if(y<=view.getWidth()){
                        float side=width/9;
                        int X=(int) (y/side),Y= (int) (x/side);
                        if(solver.isEditable(X,Y)) {
                            buttonClickedX=X;
                            buttonClickedY=Y;
                            suggestion=solver.getSuggetion(X,Y);
                            showNumPad();
                        }
                    }
                }
                return false;
            });
        }



    }

    public void showNumPad (){
        LayoutInflater m_inflater = LayoutInflater.from(this);
        View view = m_inflater.inflate(R.layout.num_pad, null);
        dialog=new AlertDialog.Builder(this).setView(view).create();
        dialog.show();
    }


    public void getSolutionButton(View view){
        if(editable){
            if(solver.solve()){
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
        int num=0;
        switch (view.getId()){
            case R.id.num_pad0: num=0; break;
            case R.id.num_pad1: num=1; break;
            case R.id.num_pad2: num=2; break;
            case R.id.num_pad3: num=3; break;
            case R.id.num_pad4: num=4; break;
            case R.id.num_pad5: num=5; break;
            case R.id.num_pad6: num=6; break;
            case R.id.num_pad7: num=7; break;
            case R.id.num_pad8: num=8; break;
            case R.id.num_pad9: num=9; break;
            default:break;
        }
        boolean found=false;
        if(num==0) found=true;
        else for(int i=0; i<suggestion.size() && !found; i++) if(suggestion.get(i)==num) found=true;


        if(found){
            dialog.dismiss();
            gameGrid.update(buttonClickedY,buttonClickedX,num);
            solver.set(buttonClickedX,buttonClickedY,num);
        }

    }

    public void resetGame(View view){
        solver.reset();
        gameGrid.reset();
    }

}
package com.diptsoft.sudokusolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameGrid extends View {
    private float width;
    private Canvas canvas;
    private int values[][];
    private  boolean editable[][];
    public GameGrid(Context context, AttributeSet attribute) {
        super(context,attribute);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void setGame(int g[][],boolean v[][]){
        this.values=new int[9][9];
        this.editable=new boolean[9][9];
        for(int i=0; i<9; i++) for(int j=0; j<9; j++){
            values[i][j]=g[i][j];
            editable[i][j]=v[i][j];
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint bg_color=new Paint();
        width=getWidth();
        this.canvas=canvas;
        bg_color.setColor(getResources().getColor(R.color.background_color));
        Paint line_paint = new Paint();
        line_paint.setColor(getResources().getColor(R.color.line_color));
        line_paint.setStrokeWidth(1);
        Paint border_paint=new Paint();
        border_paint.setColor(getResources().getColor(R.color.border_color));
        border_paint.setStrokeWidth(3);
        Paint text_color=new Paint();
        text_color.setColor(getResources().getColor(R.color.text_color));


        canvas.drawRect(0,  0, width, width, bg_color);
        float small_box=width/9;

        for(int i = 0; i < 9; i++) {
            float y=(i+1)*small_box;
            canvas.drawLine(0,  y,  width,  y, line_paint);
            canvas.drawLine(y,  0,  y,  width, line_paint);
        }
        for(int i = 0; i < 4; i++) {
            float y=i*3*small_box;
            if(i==3) y-=2;
            if(i==0) y+=2;
            canvas.drawLine(0,  y,  width,  y, border_paint);
            canvas.drawLine(y,  0,  y,  width, border_paint);
        }

        Paint foreground = new Paint(Paint.ANTI_ALIAS_FLAG);
        foreground.setStyle(Paint.Style.FILL);
        foreground.setTextSize(width/20);
        foreground.setTextAlign(Paint.Align.CENTER);
        float gap=small_box/2;
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++) {
                String val=Integer.toString(values[i][j]);
                if(values[i][j]==0) val="";
                if(editable[i][j]) foreground.setColor(getResources().getColor(R.color.text_color));
                else foreground.setColor(getResources().getColor(R.color.text_no_edit));
                canvas.drawText(val, i*small_box+gap, j*small_box+gap+20, foreground);
            }
    }

    public void update(int x,int y,int val){
        Log.d("Setting ","{ "+Integer.toString(x)+","+Integer.toString(y)+": "+Integer.toString(val)+"}");
        values[x][y]=val;
    }

    public boolean onTouchEvent(MotionEvent event) {
        invalidate();
        return false;
    }
}
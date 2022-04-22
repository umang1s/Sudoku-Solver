package com.diptsoft.sudokusolver;
import java.util.ArrayList;

public class Solution {
    private int[][] grid;
    private boolean[][] vis;
    private int counter;
    Solution(String game){
        grid=new int[9][9];
        vis=new boolean[9][9];

        for(int i=0; i<81; i++){
            char c=game.charAt(i);
            int val=c-'0';
            boolean v=false;
            if(c=='.'){
                val=0;
                v=true;
            }
            int x=i/9;
            int y=i%9;
            vis[x][y]=v;
            grid[x][y]=val;
        }
    }
    //0-80

    public boolean isEditable(int x,int y){
        return vis[x][y];
    }
    private int getRowCol(int i){
        if(i<3) return 0;
        if(i<6) return 3;
        return 6;
    }

    private boolean solving(int pos){
        if(counter>=100000000) return false;
        counter++;
        if(pos==81) return true;
        int x=pos/9,y=pos%9;
        if(isEditable(x,y)){
            ArrayList<Integer> ret=getSuggetion(x,y);
            for(int i: ret){
                grid[x][y]=i;
                if(solving(pos+1)) return true;
            }
            grid[x][y]=0;
            return false;
        }else return solving(pos+1);
    }


    //////////////////////    public methods...

    public boolean isSolved(){
        //check initial game validity
        for(int i=0; i<9; i++) for(int j=0; i<9; j++) if(grid[i][j]==0) return false;
        return true;
    }

    public ArrayList<Integer> getSuggetion(int x,int y){
        ArrayList<Integer> ret=new ArrayList<>();
        boolean visited[]=new boolean[10];
        for(int i=0; i<10; i++) visited[i]=false;
        for(int i=0; i<9; i++){
            visited[grid[i][y]]=true;
            visited[grid[x][i]]=true;
        }
        int a=getRowCol(x);
        int b=getRowCol(y);
        for(int i=0; i<3; i++) for(int j=0; j<3; j++) visited[grid[i+a][j+b]]=true;
        for(int i=1; i<10; i++) if(!visited[i]) ret.add(i);
        return ret;
    }

    public boolean solve(){
        counter=0;
        for(int i=0; i<9; i++) for(int j=0; j<9; j++){
            if(grid[i][j]!=0) vis[i][j]=false;
            else vis[i][j]=true;
        }
        return solving(0);
    }

    public void reset(){
        for(int i=0; i<9; i++) for(int j=0; j<9; j++) if(vis[i][j])grid[i][j]=0;
    }

    public void set(int x,int y,int value){
        if(isEditable(x,y)) grid[x][y]=value;
    }

    public String getSolution(){
        String ret="";
        for(int i=0; i<9; i++) for(int j=0; j<9; j++) ret+=Integer.toString(grid[i][j]);
        return ret;
    }


    public boolean[][] getBooleanValue(){return vis;}
    public int[][] getGridValue(){return grid;}
}

package com.diptsoft.sudokusolver;

import java.util.ArrayList;

public class Level {
    private String name;
    private ArrayList<Sudoku> levels;
    private int stars;
    private boolean visible;
    Level(String name,ArrayList<Sudoku> games){
        this.name=name;
        levels=games;
        calStars();
        visible=false;
    }


    private  void calStars(){
        stars=7;
    }


    public String getName() {
        return name;
    }

    public ArrayList<Sudoku> getLevels() {
        return levels;
    }

    public int getStars() {
        return stars;
    }
    public boolean getVisibility(){
        return visible;
    }
    public void changeVisibility(){
        visible=!visible;
    }
}

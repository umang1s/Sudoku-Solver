package com.diptsoft.sudokusolver;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private String name;
    private ArrayList<Sudoku> levels;
    private int stars;
    private boolean visible;
    Level(String name){
        this.name=name;
        levels=new ArrayList<>();
        calStars();
        visible=false;
    }

    public void addSudoku(Sudoku sudoku){
        levels.add(sudoku);
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

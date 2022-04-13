package com.diptsoft.sudokusolver;

import java.util.List;

public class Level {
    private String name;
    private List<Sudoku> levels;
    private double stars;
    private boolean visible;
    Level(String name,List<Sudoku> levels){
        this.name=name;
        this.levels=levels;
        calStars();
        visible=false;
    }

    private  void calStars(){
        stars=4.3;
    }


    public String getName() {
        return name;
    }

    public List<Sudoku> getLevels() {
        return levels;
    }

    public double getStars() {
        return stars;
    }
    public boolean getVisibility(){
        return visible;
    }
    public void changeVisibility(){
        visible=!visible;
    }
}

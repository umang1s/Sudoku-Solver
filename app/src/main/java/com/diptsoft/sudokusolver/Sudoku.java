package com.diptsoft.sudokusolver;

import java.io.Serializable;

public class Sudoku implements Serializable {
    private String game,submittedSolution;
    private int avgTime,solvedTime,ID;
    public Sudoku(int ID,String game,int avgTime,int solvedTime,String submittedSolution) {
        this.game = game;
        this.ID=ID;
        this.avgTime = avgTime;
        this.solvedTime = solvedTime;
        this.submittedSolution = submittedSolution;
    }

    public String getGame() {
        return game;
    }

    public String getSubmittedSolution() {
        return submittedSolution;
    }

    public int getAvgTime() {
        return avgTime;
    }

    public int getSolvedTime() {
        return solvedTime;
    }
    public int getID(){
        return ID;
    }
}

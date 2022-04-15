package com.diptsoft.sudokusolver;

public class Sudoku {
    private String game,submittedSolution;
    private int avgTime,solvedTime;
    public Sudoku(String game,int avgTime,int solvedTime,String submittedSolution) {
        this.game = game;
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
}

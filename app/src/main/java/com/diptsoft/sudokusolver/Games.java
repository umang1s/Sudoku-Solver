package com.diptsoft.sudokusolver;

import java.util.ArrayList;

public class Games {
    private ArrayList<Sudoku> easy,hard,medium;
    public ArrayList<Sudoku> getHard() {
        return hard;
    }

    public ArrayList<Sudoku> getMedium() {
        return medium;
    }
    ArrayList<Sudoku> getEasy(){
        return easy;
    }

    public  Games(){
        easy=new ArrayList<>();
        medium=new ArrayList<>();
        hard=new ArrayList<>();

        easy.add(new Sudoku(1001,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1002,"......... .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1003,"1........ ......... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1004,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1005,"......... .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1006,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1007,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1008,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1009,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1010,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1011,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1012,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1013,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1014,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1015,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));
        easy.add(new Sudoku(1016,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",300,-1,""));

        medium.add(new Sudoku(2001,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2002,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2003,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2004,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2005,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2006,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2007,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2008,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2009,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2010,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2011,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2012,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2013,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2014,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2015,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2016,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2017,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));
        medium.add(new Sudoku(2018,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",200,-1,""));

        hard.add(new Sudoku(3001,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3002,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3003,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3004,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3005,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3006,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3007,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3008,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3009,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3010,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3011,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3012,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3013,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3014,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3015,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3016,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3017,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3018,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3019,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
        hard.add(new Sudoku(3020,"1........ .2....... ......... .......3. ......... ......... ......... .5....... .......9.",100,-1,""));
    }
}

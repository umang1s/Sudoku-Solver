package com.diptsoft.sudokusolver;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private static final String DB_NAME = "sudoku";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "games";
    private static final String ID_COL = "id";
    private static final String LEVEL="level";
    private static final String GAME="game";
    private static final String AVG_TIME="avg_time";
    private static final String SOL_TIME="sol_time";
    private static final String SOL_GAME="sol_game";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

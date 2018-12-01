package com.tuna.anhtu.assignment.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tuna.anhtu.assignment.DAO.User_DAO;

public class Databasemanager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "bookstore";
    public static final int DATABASE_VERSION = 1;

    public Databasemanager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(User_DAO.SQL_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("Drop table if exists " + User_DAO.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

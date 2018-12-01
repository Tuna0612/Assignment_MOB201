package com.tuna.anhtu.assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.tuna.anhtu.assignment.database.Databasemanager;
import com.tuna.anhtu.assignment.model.User;

import java.util.ArrayList;
import java.util.List;

public class User_DAO {
    private SQLiteDatabase db;
    private Databasemanager databasemanager;
    public static final String TABLE_NAME = "User";
    public static final String SQL_USER = "CREATE TABLE User (name text primary key, birth text,  home text, phone text);";
    public static final String TAG = "UserDAO";

    public User_DAO(Context context) {
        databasemanager = new Databasemanager(context);
        db = databasemanager.getWritableDatabase();
    }

    public int inserUser(User user) {
        ContentValues values = new ContentValues();
        values.put("name", user.getmName());
        values.put("birth", user.getmDate());
        values.put("home", user.getmHome());
        values.put("phone", user.getmPhone());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    //update
    public int updateUser(User user) {
        ContentValues values = new ContentValues();
        values.put("name", user.getmName());
        values.put("birth", user.getmDate());
        values.put("home", user.getmHome());
        values.put("phone", user.getmPhone());
        int result = db.update(TABLE_NAME, values, "username=?", new String[]{user.getmName()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public List<User> getAllUser() {
        List<User> dsUser = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            User ee = new User();
            ee.setmName(c.getString(0));
            ee.setmDate(c.getString(1));
            ee.setmHome(c.getString(2));
            ee.setmPhone(c.getString(3));
            dsUser.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsUser;
    }

    //delete
    public int deleteUser(String username) {
        int result = db.delete(TABLE_NAME, "name=?", new String[]{username});
        if (result == 0)
            return -1;
        return 1;
    }

    public int updateUser(String editusername, String name, String date, String home,String phone) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("birth", date);
        values.put("home", home);
        values.put("phone", phone);
        int result = db.update(TABLE_NAME, values, "name=?", new
                String[]{editusername});
        if (result == 0) {
            return -1;
        }
        return 1;
    }
}

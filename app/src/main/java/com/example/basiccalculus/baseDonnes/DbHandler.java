package com.example.basiccalculus.baseDonnes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
public class DbHandler extends SQLiteOpenHelper {
    public static final String name = "BasicCal_DB";
    public static final String tableName = "user";
    public DbHandler(@Nullable Context context) {
        super(context, name, null, 1);
    }
    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {

        db.execSQL("CREATE TABLE user(id INTEGER primary key autoincrement, username TEXT not null, password TEXT not null, level INTEGER )");
    }
    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }
    /////////////////////////////////////////////////////////////////////////
    public Boolean AddUser(String u,String p, int lev){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
            val.put("username",u);
            val.put("password",p);
            val.put("level",lev);
        long i = db.insert(tableName,null,val);
        db.close();
        if(i>0) return true ;
        return false ;
    }
    /////////////////////////////////////////////////////////////////////////
    public Boolean existUsername(String u){
        String[] column = {"username"};
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = {u};
        String selection = " username=? ";
        Cursor c = db.query("user",column,selection,selectionArgs,null,null,null);
        int cursorC = c.getCount();
        c.close();
        if(cursorC>0)  { return true; }
        return false;
    }
    /////////////////////////////////////////////////////////////////////////
    public Boolean existPassword(String p)
    {
        String[] column = {"password"};
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = {p};
        String selection = " password=? ";
        Cursor c = db.query("user",column,selection,selectionArgs,null,null,null);
        int cursorC = c.getCount();
        c.close();
        if(cursorC>0)  { return true; }
        return false;
    }
    ////////////////////////////////////////////////////////////////////////
    public void setLevel(String u, String p){
        int lev = getLevel(u);
        lev++;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("username",u);
            values.put("password",p);
            values.put("level",lev);
        db.update(tableName,values,"username=?",new String[]{u});

    }
    //////////////////////////////////////////////////////////////
    public int getLevel(String u){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT level FROM user WHERE username=?",new String[]{u});
        if(c.moveToFirst()){
            int tmp = c.getInt(0);
            c.close();
            return tmp;
        }
        c.close();
        return -1;
    }
}

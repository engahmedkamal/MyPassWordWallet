package com.isfp.ahmed.mypasswordwallet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.isfp.ahmed.mypasswordwallet.model.User;

/**
 * Created by ahmed on 13/11/16.
 */

public class UsersDBhelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "popularmovie.db";

    public UsersDBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_TABLE_USERS = "CREATE TABLE " + UsersContract.USERS_TABLE.TABLE_NAME + "(" +
                UsersContract.USERS_TABLE._ID + " INTEGER PRIMARY KEY," +
                UsersContract.USERS_TABLE.COLUMN_USERNAME + " TEXT NOT NULL," +
                UsersContract.USERS_TABLE.COLUMN_PASSWORD + " TEXT NOT NULL," +
                UsersContract.USERS_TABLE.COLUMN_FIRSTNAME + " TEXT NOT NULL," +
                UsersContract.USERS_TABLE.COLUMN_LASTNAME + " TEXT NOT NULL" + ")";
        final String CREATE_TABLE_WALLET = "CREATE TABLE " + UsersContract.WALLET_TABLE.TABLE_NAME + "(" +
                UsersContract.WALLET_TABLE._ID + " INTEGER PRIMARY KEY," +
                UsersContract.WALLET_TABLE.COLUMN_WEBSITE + " TEXT NOT NULL," +
                UsersContract.WALLET_TABLE.COLUMN_USERNAME + " TEXT NOT NULL," +
                UsersContract.WALLET_TABLE.COLUMN_PASSWORD + " TEXT NOT NULL," +
                UsersContract.WALLET_TABLE.COLUMN_USERFORGEINKEY + " TEXT NOT NULL" +
                " FOREIGN KEY (" + UsersContract.WALLET_TABLE.COLUMN_USERFORGEINKEY + ") REFERENCES " +
                UsersContract.USERS_TABLE.TABLE_NAME + " (" + UsersContract.USERS_TABLE._ID + ") " + ")";

        db.execSQL(CREATE_TABLE_USERS);
//        db.execSQL(CREATE_TABLE_WALLET);
//
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("DROP TABLE IF EXISTS " + UsersContract.WALLET_TABLE.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + UsersContract.USERS_TABLE.TABLE_NAME);
        onCreate(db);
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, UsersContract.USERS_TABLE.TABLE_NAME);
        return numRows;
    }
    public Cursor getUser(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        String query="SELECT * FROM "+UsersContract.USERS_TABLE.TABLE_NAME+" WHERE "+
                UsersContract.USERS_TABLE.COLUMN_USERNAME+" =?";
        Cursor res =  db.rawQuery(query,new String[]{username});
        return res;
    }
    public boolean insertUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put(UsersContract.USERS_TABLE._ID,100);
        contentValues.put(UsersContract.USERS_TABLE.COLUMN_USERNAME,user.getUsername());
        contentValues.put(UsersContract.USERS_TABLE.COLUMN_PASSWORD,user.getPassWord());
        contentValues.put(UsersContract.USERS_TABLE.COLUMN_FIRSTNAME,user.getFirstname());
        contentValues.put(UsersContract.USERS_TABLE.COLUMN_LASTNAME,user.getLastname());
        db.insert(UsersContract.USERS_TABLE.TABLE_NAME,null,contentValues);
        return true;
    }
}

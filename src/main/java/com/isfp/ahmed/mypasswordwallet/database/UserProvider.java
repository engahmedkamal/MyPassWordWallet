package com.isfp.ahmed.mypasswordwallet.database;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by ahmed on 18/11/16.
 */

public class UserProvider extends ContentProvider {

    // The URI Matcher used by this content provider.
    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private static final SQLiteQueryBuilder sQueryBuilder;

    static {
        sQueryBuilder = new SQLiteQueryBuilder();
        sQueryBuilder.setTables(
                UsersContract.WALLET_TABLE.TABLE_NAME+ " INNER JOIN " +
                        UsersContract.USERS_TABLE.TABLE_NAME+
                        " ON "+UsersContract.WALLET_TABLE.TABLE_NAME+
                        "."+UsersContract.WALLET_TABLE.COLUMN_USERFORGEINKEY+
                        " = " +UsersContract.USERS_TABLE.TABLE_NAME+
                        "."+UsersContract.USERS_TABLE._ID);
    }

    static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority =UsersContract.CONTENT_AUTHORITY;
//        static final int USER
        return matcher;
    }


        @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}

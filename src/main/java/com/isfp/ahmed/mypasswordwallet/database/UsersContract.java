package com.isfp.ahmed.mypasswordwallet.database;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by ahmed on 12/11/16.
 */

public final class UsersContract {
    public static final String CONTENT_AUTHORITY = "com.isfp.ahmed.mypasswordwallet";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_USERS = "users";
    public static final String PATH_WALLET = "wallet";

    public static final class USERS_TABLE implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
        public static Uri buildMovieUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;

        public static final String COLUMN_USERNAME="username";
        public static final String COLUMN_PASSWORD="password";
        public static final String COLUMN_FIRSTNAME="firstname";
        public static final String COLUMN_LASTNAME="lastname";
        public static String getUserIDFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }

    public static final class WALLET_TABLE implements BaseColumns{
        public static final String TABLE_NAME = "wallet";
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
        public static Uri buildMovieUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        public static final String COLUMN_WEBSITE="website";
        public static final String COLUMN_USERNAME="username";
        public static final String COLUMN_PASSWORD="password";
        public static final String COLUMN_USERFORGEINKEY="username_id";
    }

}

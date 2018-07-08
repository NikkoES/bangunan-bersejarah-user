package com.bangunanbersejarah.masyarakat.bangunanbersejarah.db;

//konsep DDL dalam database

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "db_favorit";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE_NOTE = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_FAVORIT,
            DatabaseContract.NoteColumns._ID,
            DatabaseContract.NoteColumns.ID_BANGUNAN,
            DatabaseContract.NoteColumns.NAMA_BANGUNAN,
            DatabaseContract.NoteColumns.SEJARAH_BANGUNAN,
            DatabaseContract.NoteColumns.IMAGE_BANGUNAN,
            DatabaseContract.NoteColumns.TANGGAL,
            DatabaseContract.NoteColumns.ALAMAT_BANGUNAN
    );
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NOTE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_FAVORIT);
        onCreate(db);
    }
}

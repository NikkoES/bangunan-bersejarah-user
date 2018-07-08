package com.bangunanbersejarah.masyarakat.bangunanbersejarah.db;

//konsep DML dalam database

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.bangunanbersejarah.masyarakat.bangunanbersejarah.model.Bangunan;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.bangunanbersejarah.masyarakat.bangunanbersejarah.db.DatabaseContract.NoteColumns.ALAMAT_BANGUNAN;
import static com.bangunanbersejarah.masyarakat.bangunanbersejarah.db.DatabaseContract.NoteColumns.ID_BANGUNAN;
import static com.bangunanbersejarah.masyarakat.bangunanbersejarah.db.DatabaseContract.NoteColumns.IMAGE_BANGUNAN;
import static com.bangunanbersejarah.masyarakat.bangunanbersejarah.db.DatabaseContract.NoteColumns.NAMA_BANGUNAN;
import static com.bangunanbersejarah.masyarakat.bangunanbersejarah.db.DatabaseContract.NoteColumns.SEJARAH_BANGUNAN;
import static com.bangunanbersejarah.masyarakat.bangunanbersejarah.db.DatabaseContract.NoteColumns.TANGGAL;
import static com.bangunanbersejarah.masyarakat.bangunanbersejarah.db.DatabaseContract.TABLE_FAVORIT;

public class NoteHelper {
    private static String DATABASE_TABLE = TABLE_FAVORIT;
    private Context context;
    private DatabaseHelper dataBaseHelper;

    private SQLiteDatabase database;

    public NoteHelper(Context context){
        this.context = context;
    }

    public NoteHelper open() throws SQLException {
        dataBaseHelper = new DatabaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dataBaseHelper.close();
    }

    public ArrayList<Bangunan> query(){
        ArrayList<Bangunan> arrayList = new ArrayList<Bangunan>();
        Cursor cursor = database.query(DATABASE_TABLE,null,null,null,null,null,_ID +" DESC",null);
        cursor.moveToFirst();
        Bangunan bangunan;
        if (cursor.getCount()>0) {
            do {
                bangunan = new Bangunan();
                bangunan.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                bangunan.setIdBangunan(cursor.getString(cursor.getColumnIndexOrThrow(ID_BANGUNAN)));
                bangunan.setNamaBangunan(cursor.getString(cursor.getColumnIndexOrThrow(NAMA_BANGUNAN)));
                bangunan.setSejarahBangunan(cursor.getString(cursor.getColumnIndexOrThrow(SEJARAH_BANGUNAN)));
                bangunan.setImageBangunan(cursor.getString(cursor.getColumnIndexOrThrow(IMAGE_BANGUNAN)));
                bangunan.setTanggal(cursor.getString(cursor.getColumnIndexOrThrow(TANGGAL)));
                bangunan.setAlamatBangunan(cursor.getString(cursor.getColumnIndexOrThrow(ALAMAT_BANGUNAN)));

                arrayList.add(bangunan);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insert(Bangunan bangunan){
        ContentValues initialValues =  new ContentValues();
        initialValues.put(ID_BANGUNAN, bangunan.getIdBangunan());
        initialValues.put(NAMA_BANGUNAN, bangunan.getNamaBangunan());
        initialValues.put(SEJARAH_BANGUNAN, bangunan.getSejarahBangunan());
        initialValues.put(IMAGE_BANGUNAN, bangunan.getImageBangunan());
        initialValues.put(TANGGAL, bangunan.getTanggal());
        initialValues.put(ALAMAT_BANGUNAN, bangunan.getAlamatBangunan());
        return database.insert(DATABASE_TABLE, null, initialValues);
    }

    public int delete(int id){
        return database.delete(TABLE_FAVORIT, _ID + " = '"+id+"'", null);
    }
}

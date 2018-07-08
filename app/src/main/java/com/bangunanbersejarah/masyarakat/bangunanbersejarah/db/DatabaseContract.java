package com.bangunanbersejarah.masyarakat.bangunanbersejarah.db;

import android.provider.BaseColumns;

public class DatabaseContract {

    static String TABLE_FAVORIT = "favorit";

    static final class NoteColumns implements BaseColumns {

        static String ID_BANGUNAN = "id_bangunan";
        static String NAMA_BANGUNAN = "nama_bangunan";
        static String SEJARAH_BANGUNAN = "sejarah_bangunan";
        static String IMAGE_BANGUNAN = "image_bangunan";
        static String ALAMAT_BANGUNAN = "alamat_bangunan";
        static String TANGGAL = "tanggal";
    }

}

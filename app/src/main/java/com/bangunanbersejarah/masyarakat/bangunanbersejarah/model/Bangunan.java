package com.bangunanbersejarah.masyarakat.bangunanbersejarah.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikko Eka Saputra on 4/2/2018.
 */

public class Bangunan {

    int id;
    @SerializedName("id_bangunan")
    String idBangunan;
    @SerializedName("nama_bangunan")
    String namaBangunan;
    @SerializedName("sejarah_bangunan")
    String sejarahBangunan;
    @SerializedName("image_bangunan")
    String imageBangunan;
    @SerializedName("id_provinsi")
    String idProvinsi;
    @SerializedName("id_daerah")
    String idDaerah;
    @SerializedName("tanggal_pengajuan")
    String tanggal;
    @SerializedName("alamat_bangunan")
    String alamatBangunan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdBangunan(String idBangunan) {
        this.idBangunan = idBangunan;
    }

    public void setNamaBangunan(String namaBangunan) {
        this.namaBangunan = namaBangunan;
    }

    public void setSejarahBangunan(String sejarahBangunan) {
        this.sejarahBangunan = sejarahBangunan;
    }

    public void setImageBangunan(String imageBangunan) {
        this.imageBangunan = imageBangunan;
    }

    public void setIdProvinsi(String idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public void setIdDaerah(String idDaerah) {
        this.idDaerah = idDaerah;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setAlamatBangunan(String alamatBangunan) {
        this.alamatBangunan = alamatBangunan;
    }

    public String getIdBangunan() {
        return idBangunan;
    }

    public String getNamaBangunan() {
        return namaBangunan;
    }

    public String getSejarahBangunan() {
        return sejarahBangunan;
    }

    public String getImageBangunan() {
        return imageBangunan;
    }

    public String getIdProvinsi() {
        return idProvinsi;
    }

    public String getIdDaerah() {
        return idDaerah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getAlamatBangunan() {
        return alamatBangunan;
    }
}
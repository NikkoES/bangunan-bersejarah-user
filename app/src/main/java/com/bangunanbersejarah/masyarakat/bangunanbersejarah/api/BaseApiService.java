package com.bangunanbersejarah.masyarakat.bangunanbersejarah.api;

import com.bangunanbersejarah.masyarakat.bangunanbersejarah.model.BangunanResponse;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.model.DaerahResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Nikko Eka Saputra on 4/2/2018.
 */

public interface BaseApiService {

    //list semua bangunan berdasarkan provinsi
    @GET("bangunan/{id_provinsi}/{status}")
    Call<BangunanResponse> getAllListBangunan(@Path("id_provinsi") String idProvinsi, @Path("status") String status);

    //list semua daerah berdasarkan provinsi
    @GET("daerah/{id_provinsi}")
    Call<DaerahResponse> getListDaerah(@Path("id_provinsi") String idProvinsi);

    //list bangunan berdasarkan daerah dan provinsi
    @GET("bangunan/{id_provinsi}/{id_daerah}/{status}")
    Call<BangunanResponse> getListBangunan(@Path("id_provinsi") String idProvinsi, @Path("id_daerah") String idDaerah, @Path("status") String status);
}
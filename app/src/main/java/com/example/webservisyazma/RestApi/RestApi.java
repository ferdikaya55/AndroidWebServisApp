package com.example.webservisyazma.RestApi;

import com.example.webservisyazma.Models.Uye;
import com.example.webservisyazma.Models.UyeBilgileri;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {
    @FormUrlEncoded
    @POST("/girisyap.php")
    Call<Uye> addUser(@Field("username") String username, @Field("password") String password);

    @GET("/bilgigetir.php")
    Call<UyeBilgileri> bilgiGetir(@Query("uyeid") String id);
}

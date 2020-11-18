package com.example.webservisyazma.RestApi;

import com.example.webservisyazma.Models.Uye;
import com.example.webservisyazma.Models.UyeBilgileri;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {

        return ourInstance;
    }

    public Call<Uye> giris(String username, String password) {
        Call<Uye> a = getRestApi().addUser(username, password);
        return a;
    }

    public Call<UyeBilgileri> getir(String id) {
        Call<UyeBilgileri> b = getRestApi().bilgiGetir(id);
        return b;
    }
}
package com.example.webservisyazma;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.webservisyazma.Models.Uye;
import com.example.webservisyazma.Models.UyeBilgileri;
import com.example.webservisyazma.RestApi.BaseUrl;
import com.example.webservisyazma.RestApi.ManagerAll;
import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {
    String id;
    TextView uyeIsmi,uyeOkul,uyeYas,uyeMailAdres;
    ImageView uyeResim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initComponents();
        getID();
        sendRequestId();
    }
    public void initComponents(){
        uyeIsmi = findViewById(R.id.uyeIsmi);
        uyeOkul = findViewById(R.id.uyeOkul);
        uyeYas = findViewById(R.id.uyeYasi);
        uyeMailAdres = findViewById(R.id.uyeMailAdres);
        uyeResim = findViewById(R.id.uyeResim);
    }
    public void getID(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("idDeger");
    }
    public void sendRequestId(){
        Call<UyeBilgileri> request = ManagerAll.getInstance().getir(id);
        request.enqueue(new Callback<UyeBilgileri>() {
            @Override
            public void onResponse(Call<UyeBilgileri> call, Response<UyeBilgileri> response) {
                uyeIsmi.setText("Isminiz:"+response.body().getUyeismi());
                uyeMailAdres.setText("Mail Adresiniz:"+response.body().getUyemailadres());
                uyeOkul.setText("Okulunuz:"+response.body().getUyeokul());
                uyeYas.setText("Yaşınız:"+response.body().getUyeyasi());
                Log.i("resimmm",response.body().getUyeresim());
                Picasso.get().load("http://webservis.ferdikaya.net/resimler.jpg/"+response.body().getUyeresim()).into(uyeResim);
            }

            @Override
            public void onFailure(Call<UyeBilgileri> call, Throwable t) {

            }
        });

    }
}
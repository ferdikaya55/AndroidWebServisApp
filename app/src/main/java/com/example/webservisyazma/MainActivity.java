package com.example.webservisyazma;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.webservisyazma.Models.Uye;
import com.example.webservisyazma.RestApi.ManagerAll;

public class MainActivity extends AppCompatActivity {
    EditText userNameEdittext, passwordEdittext;
    Button girisYapButon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        sendRequest();
    }

    public void initComponents() {
        userNameEdittext = findViewById(R.id.userNameEdittext);
        passwordEdittext = findViewById(R.id.passwordEditText);
        girisYapButon = findViewById(R.id.girisYapButon);
    }

    public void sendRequest() {
        girisYapButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userNameEdittext.getText().toString();
                String password = passwordEdittext.getText().toString();
                Call<Uye> request = ManagerAll.getInstance().giris(username, password);
                request.enqueue(new Callback<Uye>() {
                    @Override
                    public void onResponse(Call<Uye> call, Response<Uye> response) {
                        if (response.isSuccessful()) {
                            String id = response.body().getId();
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            intent.putExtra("idDeger", id);
                            startActivity(intent);

                        }

                    }

                    @Override
                    public void onFailure(Call<Uye> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Bilgilerinizi Kontrol Ediniz", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
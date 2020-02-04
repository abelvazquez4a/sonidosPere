package com.example.mediaapppere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void video(View view) {
        Intent i = new Intent (this,Video.class);
        startActivity(i);
    }

    public void sonido(View view) {
        Intent i = new Intent (this,Sonido.class);
        startActivity(i);
    }
}

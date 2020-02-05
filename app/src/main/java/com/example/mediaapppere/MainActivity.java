package com.example.mediaapppere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable link;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("tot","raw",getPackageName()));
        mediaPlayer.start();
        ImageView gifLink = findViewById(R.id.imageView_linkrun);
        gifLink.setBackgroundResource(R.drawable.gifrun);
        link = (AnimationDrawable) gifLink.getBackground();
        link.start();
    }

    @Override
    protected void onStart() {

        super.onStart();


    }

    @Override
    protected void onResume(){
        if (!mediaPlayer.isPlaying()){
            mediaPlayer=MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("tot","raw",getPackageName()));
            mediaPlayer.start();
        }
        super.onResume();

    }


    public void video(View view) {
        mediaPlayer.stop();
        MediaPlayer door=MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("opendoor","raw",getPackageName()));
        door.start();
        Intent i = new Intent (this,Video.class);
        startActivity(i);
    }

    public void sonido(View view) {

        MediaPlayer selection=MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("selection","raw",getPackageName()));
        selection.start();
        Intent i = new Intent (this,Sonido.class);
        startActivity(i);
    }
}

package com.example.mediaapppere;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    VideoView visor1,visor2;
    MediaController mediaController1,mediaController2;
    Button buttonPlay1, buttonPlay2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        buttonPlay1 = findViewById(R.id.button_video1);
        buttonPlay2 = findViewById(R.id.button_video2);
        visor1 = (VideoView) findViewById(R.id.videoView);
        visor2 = (VideoView) findViewById(R.id.videoView2);
        Uri video1 = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.awakening);
        Uri video2 = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.oot);
        mediaController1 = new MediaController(this);
        mediaController2 = new MediaController(this);
        mediaController1.setAnchorView(findViewById(R.id.primerVideo));
        mediaController2.setAnchorView(findViewById(R.id.segundoVideo));
        visor1.setVideoURI(video1);
        visor1.setMediaController(mediaController1);
        visor2.setVideoURI(video2);
        visor2.setMediaController(mediaController2);
    }


    public void play1(View view) {
        buttonPlay1.setVisibility(View.INVISIBLE);
        visor1.setVisibility(View.VISIBLE);
        visor1.start();
        mediaController1.show();
    }

    public void play2(View view) {
        buttonPlay2.setVisibility(View.INVISIBLE);
        visor2.setVisibility(View.VISIBLE);
        visor2.start();
        mediaController2.show();
    }

}

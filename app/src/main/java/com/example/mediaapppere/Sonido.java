package com.example.mediaapppere;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;

public class Sonido extends Activity implements OnPreparedListener, MediaController.MediaPlayerControl{


    AnimationDrawable gifSword, gifLink, gifLinkAtaqueCircular;
    private static final String TAG = "AudioPlayer";
    private MediaPlayer mediaPlayer;
    private MediaController mediaController;
    private Handler handler = new Handler();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaController = new MediaController(this);
        mediaController.setMediaPlayer(this);
        mediaController.setAnchorView(findViewById(R.id.activitySonido));
        ImageView gifImageSword = findViewById(R.id.imageView_song);
        ImageView gifImageLink = findViewById(R.id.imageView_link);
        ImageView gifImageLinkAtaqueCircular = findViewById(R.id.imageView_ataqueCircular);
        gifImageLink.setBackgroundResource(R.drawable.giflink);
        gifImageSword.setBackgroundResource(R.drawable.gif);
        gifImageLinkAtaqueCircular.setBackgroundResource(R.drawable.giflinkataquecircular);
        gifSword = (AnimationDrawable) gifImageSword.getBackground();
        gifLink = (AnimationDrawable) gifImageLink.getBackground();
        gifLinkAtaqueCircular = (AnimationDrawable) gifImageLinkAtaqueCircular.getBackground();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaController.hide();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaController.hide();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mediaController.show();
        return false;
    }

    //--MediaPlayerControl methods----------------------------------------------------
    public void start() {
        mediaPlayer.start();
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    public void seekTo(int i) {
        mediaPlayer.seekTo(i);
    }

    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    public int getBufferPercentage() {
        return 0;
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return mediaPlayer.getAudioSessionId();
    }
    //--------------------------------------------------------------------------------

    public void onPrepared(MediaPlayer mediaPlayer) {
        Log.d(TAG, "onPrepared");
        mediaController.setMediaPlayer(this);
        mediaController.setAnchorView(findViewById(R.id.activitySonido));
        handler.post(new Runnable() {
            public void run() {
                mediaController.setEnabled(true);
                mediaController.show();
            }
        });
    }


    public void tono1(View view) {

        int i = ((int)(Math.random()*(3-1+1)+1));
            mediaPlayer.stop();
            if (gifSword.isRunning()){
                gifSword.setVisible(true,true);
                gifSword.stop();
            }
            gifLink.setVisible(true,true);
            gifLink.stop();
            gifLink.start();
            mediaPlayer=MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("attack"+i,"raw",getPackageName()));

            mediaPlayer.start();
            mediaController.show();
    }
    public void tono2(View view) {
        if (gifSword.isRunning()){
            gifSword.setVisible(true,true);
            gifSword.stop();
        }
        MediaPlayer swordfEffect = MediaPlayer.create(getApplicationContext(),getResources().getIdentifier("spineffect","raw",getPackageName()));
            mediaPlayer.stop();
            gifLinkAtaqueCircular.setVisible(true,true);
            gifLinkAtaqueCircular.stop();
            gifLinkAtaqueCircular.start();
            gifLinkAtaqueCircular.setVisible(true,true);
            mediaPlayer=MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("spin","raw",getPackageName()));
            mediaPlayer.start();
            swordfEffect.start();
            mediaController.show();
    }
    public void cancion(View view) {
            mediaPlayer.stop();
            gifSword.setVisible(true,true);
            gifSword.start();
            mediaPlayer=MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("zeldasong","raw",getPackageName()));
            mediaPlayer.start();

            mediaController.show();
    }
}
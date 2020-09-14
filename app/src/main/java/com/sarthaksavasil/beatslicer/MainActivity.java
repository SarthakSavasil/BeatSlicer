package com.sarthaksavasil.beatslicer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;

    public void pla(View view)
    {
        playing();
        view.setBackgroundResource(R.drawable.blues);
        changeback(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void playing() {

        Random random = new Random();

        int i = random.nextInt(7);
        if (i == 1) {
            player = MediaPlayer.create(this, R.raw.clap);
            player.start();
        }
        if (i == 2) {
            player = MediaPlayer.create(this, R.raw.openhat);
            player.start();
        }
        if (i == 3) {
            player = MediaPlayer.create(this, R.raw.kick);
            player.start();
        }
        if (i == 4) {
            player = MediaPlayer.create(this, R.raw.tom);
            player.start();
        }
        if (i == 5) {
            player = MediaPlayer.create(this, R.raw.snare);
            player.start();
        }
        if (i == 6) {
            player = MediaPlayer.create(this, R.raw.pia1);
            player.start();
        }
        if (i == 7) {
            player = MediaPlayer.create(this, R.raw.d);
            player.start();
        }
        if (i == 0) {
            player = MediaPlayer.create(this, R.raw.e);
            player.start();
        }
    }


    public void changeback(final View v){
        Handler handler = new Handler();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                v.setBackgroundResource(R.drawable.g);
            }
        }, 100);

    }
    @Override
    public void onBackPressed() {

        if (player.isPlaying())
        {
            player.stop();
            player.release();
        }
        Intent intent = new Intent(MainActivity.this, SelectActivity.class);
        startActivity(intent);
        finish();
    }

}
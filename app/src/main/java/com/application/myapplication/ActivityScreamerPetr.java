package com.application.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class ActivityScreamerPetr extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_activity_screamer_petr);
        mediaPlayer= MediaPlayer.create(this, R.raw.cena);



        mediaPlayer.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        mediaPlayer.stop();
    }
}

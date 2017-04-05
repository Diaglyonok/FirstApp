package com.application.myapplication;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity5 extends AppCompatActivity implements View.OnClickListener{

    MediaPlayer mediaPlayer;
    Button finish, restart;
    AudioManager am;

    Handler h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        h = new Handler();
        h.postDelayed(press, 19000);

        restart = (Button) findViewById(R.id.restart);
        restart.setVisibility(View.INVISIBLE);
        restart.setOnClickListener(this);

        am = (AudioManager) getSystemService(AUDIO_SERVICE);

        mediaPlayer= MediaPlayer.create(this, R.raw.rec_19s);
        mediaPlayer.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    Runnable press = new Runnable() {
        @Override
        public void run() {
            restart.setVisibility(View.VISIBLE);
        }
    };


    @Override
    public void onBackPressed() {
        Toast toast = Toast.makeText(this, R.string.neverBack, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.restart:
                Intent intent = getBaseContext().getPackageManager()
                    .getLaunchIntentForPackage(getBaseContext().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }
}


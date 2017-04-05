package com.application.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Activity4 extends AppCompatActivity implements View.OnClickListener {

    Button button, volume1, volume2,volume3,volume4;
    AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        button = (Button)findViewById(R.id.next3);
        button.setOnClickListener(this);

        volume1 = (Button)findViewById(R.id.volume1);
        volume1.setOnClickListener(this);
        volume2 = (Button)findViewById(R.id.volume2);
        volume2.setOnClickListener(this);
        volume3 = (Button)findViewById(R.id.volume3);
        volume3.setOnClickListener(this);
        volume4 = (Button)findViewById(R.id.volume4);
        volume4.setOnClickListener(this);

        am = (AudioManager) getSystemService(AUDIO_SERVICE);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                Toast.makeText(this, "Качелька громкости не работает) Только кнопки!",Toast.LENGTH_SHORT).show();
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this, "Качелька громкости не работает) Только кнопки!",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.volume1:
                am.setStreamVolume(AudioManager.STREAM_MUSIC, 30 ,0);
                break;
            case R.id.volume2:
                am.setStreamVolume(AudioManager.STREAM_MUSIC, 60 ,0);
                break;
            case R.id.volume3:
                am.setStreamVolume(AudioManager.STREAM_MUSIC, 15 ,0);
                break;
            case R.id.volume4:
                am.setStreamVolume(AudioManager.STREAM_MUSIC, 45 ,0);
                break;
            case R.id.next3:
                Intent intent = new Intent(this, Activity5.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Toast toast = Toast.makeText(this, R.string.neverBack, Toast.LENGTH_LONG);
        toast.show();
    }

}

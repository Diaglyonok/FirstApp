package com.application.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    TextView task2;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    ImageView imgPetr;
    Button next;
    int prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        task2 = (TextView)findViewById(R.id.task2);
        task2.setOnClickListener(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.fish);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        imgPetr = (ImageView) findViewById(R.id.imagePetr);
        imgPetr.setScaleX(0);
        imgPetr.setScaleY(0);

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar skb, int progress, boolean fromUser) {
        imgPetr.setScaleX(progress);
        imgPetr.setScaleY(progress);
        prog = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        imgPetr.setVisibility(View.VISIBLE);
        mediaPlayer.start();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (prog == seekBar.getMax()){
            seekBar.setVisibility(View.INVISIBLE);
            next.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.next:
                mediaPlayer.stop();
                Intent intent = new Intent(this, Activity3.class);
                startActivity(intent);
                break;
            case R.id.task2:
                Toast toast = Toast.makeText(this, R.string.advice, Toast.LENGTH_SHORT);
                toast.show();
        }

    }

    @Override
    public void onBackPressed() {

        Toast toast = Toast.makeText(this, R.string.neverBack, Toast.LENGTH_LONG);
        toast.show();
    }
}

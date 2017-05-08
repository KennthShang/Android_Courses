package com.example.user.lab6;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity{

    private Button playBtn, stopBtn, exitBtn;
    private MusicService musicService;
    ImageView infoOperatingIV;
    ObjectAnimator oaAnimator;
    SeekBar seekBar;
    TextView text1, text2 ,text3;
    Handler mHandler;
    Runnable mRunnable;
    SimpleDateFormat time = new SimpleDateFormat("mm:ss");


    private ServiceConnection sc = new ServiceConnection(){
        public void onServiceDisconnected(ComponentName name){
            musicService = null;
        }
        public void onServiceConnected(ComponentName name, IBinder service){
            musicService = ((MusicService.MyBinder)(service)).getService();
        }
    };
    private void findView(){
        playBtn = (Button) findViewById(R.id.PLAY);
        stopBtn = (Button) findViewById(R.id.STOP);
        exitBtn = (Button) findViewById(R.id.QUIT);
        infoOperatingIV = (ImageView) findViewById(R.id.Image);
        seekBar = (SeekBar) findViewById(R.id.Seekbar_music);
        text1 = (TextView) findViewById(R.id.current_time);
        text2 = (TextView) findViewById(R.id.hole_time);
        text3 = (TextView) findViewById(R.id.playing_statue);

    }
    private void bindButton(){

        playBtn.setOnClickListener(new View.OnClickListener(){
            int flag = 1;
            @Override
            public void onClick(View v){
                if(playBtn.getText().toString().equals("PLAY")){
                    text3.setText("Playing");
                    musicService.paly();

                    playBtn.setText("PAUSE");
                    if(flag == 1){
                        seekBar.setMax(musicService.getMusicDuration());
                        text2.setText(time.format(musicService.mp.getDuration()));
                        oaAnimator.start();
                        mHandler.post(mRunnable);
                        flag = 0;
                    }
                    else
                        oaAnimator.resume();

                }

                else{
                    musicService.pause();
                    playBtn.setText("PLAY");
                    text3.setText("Paused");
                    oaAnimator.pause();
                }

            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(musicService != null){
                    musicService.stop();
                    playBtn.setText("PLAY");
                    text3.setText("Stopped");
                    oaAnimator.start();
                    oaAnimator.pause();
                }

            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mHandler.removeCallbacks(mRunnable);
                musicService.stop();
                finish();
            }
        });
    }
    private void connection(){
        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, sc, Context.BIND_AUTO_CREATE);
    }
    private void setRotation(){
        oaAnimator = ObjectAnimator.ofFloat(infoOperatingIV, "rotation", 0, 360);
        oaAnimator.setDuration(7000);
        oaAnimator.setInterpolator(new LinearInterpolator());
        oaAnimator.setRepeatCount(ValueAnimator.INFINITE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connection();
        findView();
        bindButton();
        setRotation();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                    musicService.seekTo(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mHandler = new Handler();
        mRunnable = new Runnable(){
            @Override
            public void run(){
                seekBar.setProgress(musicService.getMusicCurrentPosition());
                text1.setText(time.format(musicService.getMusicCurrentPosition()));
                mHandler.postDelayed(mRunnable,1000);
            }
        };

    }





}

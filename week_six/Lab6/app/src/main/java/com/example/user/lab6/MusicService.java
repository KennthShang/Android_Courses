package com.example.user.lab6;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import java.util.concurrent.ExecutionException;

public class MusicService extends Service {
    public static MediaPlayer mp = new MediaPlayer();
    public MusicService() {
        try{
            mp.setDataSource("/data/K.Will-Melt.mp3");
            mp.prepare();
            mp.setLooping(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public final IBinder binder = new MyBinder();
    public class MyBinder extends Binder {
        MusicService getService(){
            return MusicService.this;
        }
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(mp != null){
            mp.stop();
            mp.release();
        }
    }

    public void paly(){
        mp.start();
    }
    public void stop(){
        if(mp != null){
            mp.stop();
            try{
                mp.prepare();
                mp.seekTo(0);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public void pause(){
        mp.pause();
    }

    public int getMusicCurrentPosition(){
        int rtn = 0;
        if (mp != null){
            rtn = mp.getCurrentPosition();
        }
        return rtn;
    }
    public void seekTo(int position){
        if (mp != null){
            mp.seekTo(position);
        }
    }

    public int getMusicDuration(){
        int rtn = 0;
        if (mp != null){
            rtn = mp.getDuration();
        }
        return rtn;
    }

}

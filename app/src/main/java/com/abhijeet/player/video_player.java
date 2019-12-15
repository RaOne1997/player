package com.abhijeet.player;


import android.media.MediaMetadata;
import android.media.MediaPlayer;
import android.os.Handler;


import android.os.Bundle;

import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class video_player extends AppCompatActivity /*implements  SurfaceHolder.Callback,MediaPlayer.OnPreparedListener*/{
VideoView videoView;
    /*String path;
    MediaPlayer mp;
    SurfaceView mpreview;
    SurfaceHolder holder;*/
  //int uiImmersiveOption;
    TextView dura;
SeekBar seekBar;
String str_videoUri;

Handler handler;
boolean is_play= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_video_player );
        init();


    }
    private void init(){

        videoView=findViewById( R.id.videoView );
dura=findViewById( R.id.duration );
        seekBar=findViewById( R.id.seekBar );
        str_videoUri=getIntent().getStringExtra( "video" );
        videoView.setVideoPath( str_videoUri );
        handler=new Handler(  );
        videoView.getKeepScreenOn();
        videoView.start();
        videoView.getResources();

       MediaController mediaController=new MediaController( this );
        videoView.setMediaController( mediaController );

        is_play=true;


//        imageView.setImageResource( R.drawable.ic_pause );
     //   updateseekpar();
    }



/* private  void init(){


      getWindow().setFormat( PixelFormat.UNKNOWN );
      mpreview=findViewById( R.id.videoView );
      holder=mpreview.getHolder();
      MediaController mediaController=new MediaController( this );
     // holder.setFixedSize( 800,480 );
      holder.setKeepScreenOn( true );
    //  holder.setSizeFromLayout();
      holder.addCallback(  video_player.this );


  }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mp=new MediaPlayer();
        mp.setDisplay( holder );

        str_videoUri=getIntent().getStringExtra( "video" );

        try {
            mp.setDataSource( str_videoUri );
            mp.prepare();
            mp.setOnPreparedListener( video_player.this );
            mp.setAudioStreamType( AudioManager.STREAM_MUSIC );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void onPause() {
        super.onPause();
        mp.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMP();
    }

    private void releaseMP() {
      if(mp!=null){
          mp.release();
          mp=null;

      }
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
     mp.start();
    }*/

 /* private void updateseekpar() {
        handler.postDelayed( updatetimeseekbar,100 );
    }
    public Runnable updatetimeseekbar= new Runnable() {
        @Override
        public void run() {
            seekBar.setProgress( videoView.getCurrentPosition() );
            seekBar.setMax( videoView.getDuration() );
            handler.postDelayed(this,100 );
            seekBar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    handler.removeCallbacks( updatetimeseekbar );

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    handler.removeCallbacks( updatetimeseekbar );
                    videoView.seekTo( seekBar.getProgress() );
                    updateseekpar();
                }
            } );
        }
    };*/


}

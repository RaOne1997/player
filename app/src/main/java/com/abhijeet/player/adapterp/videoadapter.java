package com.abhijeet.player.adapterp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abhijeet.player.R;
import com.abhijeet.player.model.videomodel;

import com.abhijeet.player.video_player;
import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;

public class videoadapter extends RecyclerView.Adapter<videoadapter.viewholder> {
    Activity activity;
  Context context;
    ArrayList<videomodel> arrayListvideo;

    public videoadapter(Context context, ArrayList<videomodel> viewholderArrayList,Activity activity) {
        this.context=context;
        this.arrayListvideo=viewholderArrayList;
        this.activity=activity;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from( parent.getContext() ).inflate( R.layout.video_item,parent,false );
        return new viewholder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder viewholder, final int Position) {
       Glide.with( context ).load( "file://" + arrayListvideo.get( Position ).getStr_thumb() ).centerCrop().skipMemoryCache( false ).into( viewholder.imageView );
//viewholder.duraction.setText( arrayListvideo.get( Position ).getDuration() );
        viewholder.textView.setText( arrayListvideo.get( Position ).getStr_name() );
    viewholder.cardView.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {



           Intent i=new Intent( context, video_player.class );

            i.putExtra( "video",arrayListvideo.get(Position  ).getStr_path() );
            activity.startActivity( i );

        }
    } );
    }

    @Override
    public int getItemCount() {
        return arrayListvideo.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder{

        ImageView imageView;
TextView textView,duraction;
        CardView cardView;
        public viewholder(@NonNull View itemView) {
            super( itemView );
textView=itemView.findViewById( R.id.videoname );
duraction=itemView.findViewById( R.id.duration );
            imageView=itemView.findViewById( R.id.video_themb );
          cardView=itemView.findViewById( R.id.mycard_view );
        }

    }



}

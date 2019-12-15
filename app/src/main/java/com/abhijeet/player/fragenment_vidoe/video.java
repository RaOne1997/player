package com.abhijeet.player.fragenment_vidoe;


import android.Manifest;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
;
import android.provider.MediaStore;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abhijeet.player.R;
import com.abhijeet.player.adapterp.videoadapter;
import com.abhijeet.player.model.videomodel;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


import java.util.ArrayList;
/**
 * A simple {@link Fragment} subclass.
 */
public class video extends Fragment {
    RecyclerView recyclerView;
    public static ArrayList<videomodel> videomodelArrayList;
    public video() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_video, container, false );
        recyclerView = view.findViewById( R.id.recyvle );
        videomodelArrayList = new ArrayList<>();


        runtimepermision();


        return view;
    }

    private void ini() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( getContext());
        recyclerView.setHasFixedSize( true );

        recyclerView.setLayoutManager( linearLayoutManager );

        fachfromgalary();
    }

    private void fachfromgalary() {

        Uri uri;
        Cursor cursor;
        int coli_int_data, columb_index_filder_name, thum;
        int columb_id;
        String absilutpathimage = null;
        uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] projecter = {
                MediaStore.Video.Media._ID,MediaStore.MediaColumns.DATA,
MediaStore.Video.Media.DURATION,
               MediaStore.Video.DEFAULT_SORT_ORDER,

                MediaStore.Video.Thumbnails.DATA};
        String orderby = MediaStore.Images.Media.DATE_TAKEN;
        String selection= MediaStore.Video.Media.DATA+"  like?";
        String []aray= new String[]{" %FolderName%"};
        cursor = getActivity().getContentResolver().query( uri, projecter, null, null, orderby + " DESC" );
        coli_int_data = cursor.getColumnIndexOrThrow( MediaStore.MediaColumns.DATA );

         columb_index_filder_name = cursor.getColumnIndexOrThrow( MediaStore.Video.Media.DISPLAY_NAME );
 // int dur=cursor.getBlob( ( MediaStore.Video.Media.DURATION ) );
        thum = cursor.getColumnIndexOrThrow( MediaStore.Video.Thumbnails.DATA );

        while (cursor.moveToNext()) {
            absilutpathimage = cursor.getString( coli_int_data );
            videomodel videomodel = new videomodel();
            videomodel.setBoolean_selected( false );
          videomodel.setStr_name( cursor.getString( columb_index_filder_name ) );

                    videomodel.setStr_path( absilutpathimage );
            videomodel.setStr_thumb( cursor.getString( thum ) );
            videomodelArrayList.add( videomodel );
        }

        videoadapter videoadapter = new videoadapter( getActivity().getApplicationContext(), videomodelArrayList,getActivity() );
        recyclerView.setAdapter( videoadapter );
    }

    private void runtimepermision() {
        Dexter.withActivity( getActivity() ).withPermission( Manifest.permission.READ_EXTERNAL_STORAGE ).withListener( new PermissionListener() {

            @Override
            public void onPermissionGranted(PermissionGrantedResponse response)
            {
                ini();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();
            }


        } ).check();
    }
}



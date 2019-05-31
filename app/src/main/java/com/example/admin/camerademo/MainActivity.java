package com.example.admin.camerademo;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

 public class MainActivity extends Activity {
     ImageView IMVW;
     ImageButton IMBTN;
     Button WALLBTN;
     Intent invokecam;
     final static int picbycamera = 10;
     Bitmap bitmp;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         IMVW = (ImageView) findViewById(R.id.iv);
         IMBTN = (ImageButton) findViewById(R.id.ib);
         WALLBTN = (Button) findViewById(R.id.b1);

        InputStream is = getResources().openRawResource(R.drawable.back);
         bitmp = BitmapFactory.decodeStream(is);
         //Image Button Start
         IMBTN.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View arg0) {
                 // TODO Auto-generated method stub
                 invokecam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 startActivityForResult(invokecam, picbycamera);

             }
         });
         //Image Button End

         //Set WALLPAPER Button Start
         WALLBTN.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View arg0) {
                 // TODO Auto-generated method stub
                 try {
                     getApplicationContext().setWallpaper(bitmp);
                 } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }

             }
         });
         //Set WALLPAPER Button End
     }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         // TODO Auto-generated method stub
         super.onActivityResult(requestCode, resultCode, data);
         if (resultCode == RESULT_OK) {
             Bundle extras = data.getExtras();
             bitmp = (Bitmap) extras.get("data");
             IMVW.setImageBitmap(bitmp);
         }
     }
     /**
      * A placeholder fragment containing a simple view.
      */
 }


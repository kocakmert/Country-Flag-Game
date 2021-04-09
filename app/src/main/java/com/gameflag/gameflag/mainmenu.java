package com.gameflag.gameflag;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;
public class mainmenu extends AppCompatActivity {
    private  Button play,bayrak_ulke,baskent,btn_sound;
    private MediaPlayer mp;
    private int lengt,yy,language_deger;
    private Sessionsounds sessionsounds;
    private Locale locale;
    private Configuration config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        sessionsounds=new Sessionsounds(this);
        yy= sessionsounds.checksound();
       //language_deger=sessionsounds.getLanguageDetail();
        //Toast.makeText(getApplicationContext(),String.valueOf(language_deger), Toast.LENGTH_SHORT).show();
        if(yy==0){
            mp = MediaPlayer.create(getApplicationContext(),R.raw.main_menu);
            mp.start();
            mp.setLooping(true);
        }
        else{
            mp=null;
        }
        play=findViewById(R.id.start);
        bayrak_ulke=findViewById(R.id.bayrak_ulke);
        baskent=findViewById(R.id.baskent);
        btn_sound=findViewById(R.id.btn_sound);
        play.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:{
                        Button view=(Button)v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_DOWN:{
                        Button view=(Button)v;
                        view.getBackground().setColorFilter(0xff040078, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL:{
                        Button view=(Button)v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
        bayrak_ulke.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:{
                        Button view=(Button)v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_DOWN:{
                        Button view=(Button)v;
                        view.getBackground().setColorFilter(0xff040078, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL:{
                        Button view=(Button)v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
        baskent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:{
                        Button view=(Button)v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_DOWN:{
                        Button view=(Button)v;
                        view.getBackground().setColorFilter(0xff040078, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL:{
                        Button view=(Button)v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
        btn_sound.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:{
                        Button view=(Button)v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_DOWN:{
                        Button view=(Button)v;
                        view.getBackground().setColorFilter(0xffffff, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL:{
                        Button view=(Button)v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yy==0){
                    mp.stop();
                    MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(),R.raw.button_click);
                    mp1.start();
                }
                else{
                }
                startActivity(new Intent(mainmenu.this,MainActivity.class));
            }
        });
        bayrak_ulke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yy==0){
                    mp.stop();
                    MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(),R.raw.button_click);
                    mp1.start();
                }
                else{
                }
                startActivity(new Intent(mainmenu.this,bayrakulkemain.class));
            }
        });
        baskent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yy==0){
                    mp.stop();
                    MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(),R.raw.button_click);
                    mp1.start();
                }
                else{
                }
                startActivity(new Intent(mainmenu.this,capitalmain.class));
            }
        });
        btn_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yy==0){
                    mp.stop();
                    MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(),R.raw.setting_click);
                    mp1.start();
                }
                else{
                }
                startActivity(new Intent(mainmenu.this,settingss.class));

            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode ==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            if(yy==0){
                mp.stop();
            }
            startActivity(intent);
            finish();System.exit(0);
        }
        else if(keyCode ==KeyEvent.KEYCODE_HOME){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            if(yy==0){
                mp.stop();
            }
            startActivity(intent);
            finish(); System.exit(0);
        }
        else if(keyCode ==KeyEvent.KEYCODE_MENU){
            if(yy==0){
                mp.stop();
            }
            finish(); System.exit(0);
        }
        else if(keyCode ==KeyEvent.KEYCODE_MUTE){
            if(yy==0){
                mp.stop();
            }
            finish(); System.exit(0);
        }
        else if(keyCode ==KeyEvent.KEYCODE_WINDOW){
           if(yy==0){
                mp.stop();
            }
            finish(); System.exit(0);
        }
        else if(keyCode ==KeyEvent.KEYCODE_WAKEUP){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            if(yy==0){
                mp.stop();
            }
            startActivity(intent);
            finish(); System.exit(0);
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(yy==0){
             mp.pause();
             lengt=mp.getCurrentPosition();
        }
        else{ }
    }
    @Override
    public void onResume(){
        super.onResume();
        if(yy==0){
            mp.seekTo(lengt);
            mp.start();
        }
        else{
        }
    }
}

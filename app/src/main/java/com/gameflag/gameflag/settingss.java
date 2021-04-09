package com.gameflag.gameflag;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Locale;

public class settingss extends AppCompatActivity {
    private Switch mSoundSwitch,vibSwitch;
    public SharedPreferences sharedPreferences,sharedVibrate;
    SharedPreferences.Editor editor,editor1;
    Sessionsounds sessionsounds;
    SessionVibrate sessionvibrate;
    private Button btn_back;
    private int sound,language_deger;
    private Vibrator vibrator;
    private CheckBox chx_turkish,chx_english;
    private Locale locale;
    private Configuration config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingss);
        btn_back=findViewById(R.id.btn_back);
        //Session işlemleri...
        sessionsounds=new Sessionsounds(this);
        sessionvibrate=new SessionVibrate(this);
        //Switch ayarlamaları...
        mSoundSwitch = (Switch) findViewById(R.id.soundSwitch);
        vibSwitch=(Switch)findViewById(R.id.vibrateSwitch);
        chx_turkish=(CheckBox)findViewById(R.id.turkish);
        chx_english=(CheckBox)findViewById(R.id.english);
        language_deger=sessionsounds.getLanguageDetail();
        //Toast.makeText(getApplicationContext(),String.valueOf(language_deger), Toast.LENGTH_SHORT).show();

        //Başlangıcta switchler aktif olması için....
        mSoundSwitch.setChecked(true);
        vibSwitch.setChecked(true);
        vibrator=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        mSoundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MediaPlayer media = MediaPlayer.create(getApplicationContext(),R.raw.soundon);
                    media.start();
                    sharedPreferences =  getPreferences(Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("sound", true);
                    editor.apply();
                    sessionsounds.createSessionon();
                    sound= sessionsounds.checksound();
                } else {
                    sharedPreferences =  getPreferences(Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("sound", false);
                    editor.apply();
                    sessionsounds.createSessionoff();
                    sound= sessionsounds.checksound();
                }
            }
        });
        vibSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    vibrator.vibrate(300);
                    sharedVibrate = getPreferences(Context.MODE_PRIVATE);
                    editor1=sharedVibrate.edit();
                    editor1.putBoolean("vib",true);
                    editor1.apply();
                    sessionvibrate.vibrateon();
                }
                else{
                    sharedVibrate =getPreferences(Context.MODE_PRIVATE);
                    editor1=sharedVibrate.edit();
                    editor1.putBoolean("vib",false);
                    editor1.apply();
                    sessionvibrate.vibrateoff();
                }
            }
        });
        if(language_deger ==1){
            chx_turkish.setChecked(true);
        }
        else{
            chx_english.setChecked(true);
        }
        chx_turkish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chx_turkish.isChecked()){
                    sessionsounds.settingLanguageSession(1);
                    language_deger=1;
                    chx_english.setChecked(false);
                    Locale locale = new Locale("tr");  //locale en yaptık. Artık değişkenler values-en paketinden alınacak
                    Locale.setDefault(locale);
                    config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                    finish();
                    Intent intent=new Intent(settingss.this,mainmenu.class);
                    startActivity(intent);
                }
            }
        });
        chx_english.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chx_english.isChecked()){
                    sessionsounds.settingLanguageSession(2);
                    chx_turkish.setChecked(false);
                    language_deger=2;
                    Locale locale = new Locale("en");  //locale en yaptık. Artık değişkenler values-en paketinden alınacak
                    Locale.setDefault(locale);
                    config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config,
                            getBaseContext().getResources().getDisplayMetrics());
                    finish();
                    Intent intent=new Intent(settingss.this,mainmenu.class);
                    startActivity(intent);
                }
            }
        });
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        sharedVibrate = getPreferences(Context.MODE_PRIVATE);
        boolean isChecked = sharedPreferences.getBoolean("sound", true);
        boolean isvibChecked= sharedVibrate.getBoolean("vib",true);
        mSoundSwitch.setChecked(isChecked);
        vibSwitch.setChecked(isvibChecked);
        btn_back.setOnTouchListener(new View.OnTouchListener() {
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
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound==0){
                    MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(),R.raw.setting_click);
                    mp1.start();
                }
                Intent intent=new Intent(settingss.this,mainmenu.class);
                finish();
                startActivity(intent);
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode ==KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent(settingss.this,mainmenu.class);
            startActivity(intent);
            //startActivity(new Intent(settingss.this,mainmenu.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}


package com.gameflag.gameflag;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;
public class loaderscreen extends AppCompatActivity {
    private Sessionsounds sessionsounds;
    private int language_deger;
    private Locale locale;
    private Configuration config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locale= Locale.getDefault();
        Locale.setDefault(locale);
        config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_loaderscreen);
        sessionsounds=new Sessionsounds(this);
        language_deger=sessionsounds.getLanguageDetail();
        if(String.valueOf(Locale.getDefault()).equals("tr_TR")){
            if(language_deger==2){
                sessionsounds.settingLanguageSession(2);
                Locale locale = new Locale("en");  //locale en yaptık. Artık değişkenler values-en paketinden alınacak
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
            }
            else{
                language_deger=1;
                sessionsounds.settingLanguageSession(1);
            }
        }
        else{
            language_deger=2;
            sessionsounds.settingLanguageSession(2);
            Locale locale = new Locale("");
            Locale.setDefault(locale);
            config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    startActivity(new Intent(loaderscreen.this,mainmenu.class));
                }
            }
        };
        timerThread.start();
    }
}
package com.gameflag.gameflag;

import android.content.Context;
import android.content.SharedPreferences;
public class SessionVibrate {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE=0;
    private static  final String PREF_SOUND="VIBRATE";
    private  static  final String SOUND="IS_LOGIN";
    public SessionVibrate(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences(PREF_SOUND,PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }
    public void vibrateon(){
        editor.putBoolean(SOUND,true);
        editor.apply();
    }
    public void vibrateoff(){
        editor.putBoolean(SOUND,false);
        editor.apply();
    }
    public  boolean isLogginxx(){
        return sharedPreferences.getBoolean(SOUND,true);
    } //DEĞERİ SORGULANIR DEĞer false değeri döndürür...
    public int checkvibrate(){
        int i=0;
        if(this.isLogginxx()){//true olduğunda çalışır...
            i=0;
        }
        else{
            i=1;
        }
        return i;
    }
}

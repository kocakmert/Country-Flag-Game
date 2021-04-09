package com.gameflag.gameflag;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
public class Sessionsounds {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE=0;
    private static  final String PREF_SOUND="SOUND";
    private  static  final String SOUND="IS_LOGIN";
    private static final String LANGUAGE="LANGUAGE";
    public Sessionsounds(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences(PREF_SOUND,PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }
    public void createSessionon(){
        editor.putBoolean(SOUND,true);
        editor.apply();
    }
    public void createSessionoff(){
        editor.putBoolean(SOUND,false);
        editor.apply();
    }
    public void settingLanguageSession(int language_deger){
        editor.putInt(LANGUAGE,language_deger);
        editor.apply();
    }
    public int getLanguageDetail(){
        int language =sharedPreferences.getInt(LANGUAGE,0);
        return language;
    }
    public  boolean isLogginx(){
        return sharedPreferences.getBoolean(SOUND,true);
    } //DEĞERİ SORGULANIR DEĞer false değeri döndürür...
    public int checksound(){
        int i=0;
        if(this.isLogginx()){//true olduğunda çalışır...
            i=0;
        }
        else{
            i=1;
        }
        return i;
    }
}

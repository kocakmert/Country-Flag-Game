package com.gameflag.gameflag;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE=0;
    private static  final String PREF_NAME="LOGIN";
    private  static  final String LOGIN="IS_LOGIN";
    public  static final String NAME="NAME";
    public  static final String SKOR="SKOR";
    public  static final String SKORBAYRAK="SKORBAYRAK";
    public  static final String SKORCAPITAL="CAPITAL";
    public SessionManager(Context context){
       // epicdia=new Dialog(context);
        this.context=context;
        sharedPreferences=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }
    public void createSession(String name,String skor){
        editor.putBoolean(LOGIN,true);
        editor.putString(NAME,name);
        editor.putString(SKOR,skor);
        editor.apply();
    }
    public void createSessionbayrak(String name,String skorbayrak){
        editor.putBoolean(LOGIN,true);
        editor.putString(NAME,name);
        editor.putString(SKORBAYRAK,skorbayrak);
        editor.apply();
    }
    public void createSessioncapital(String name,String skorcapital){
        editor.putBoolean(LOGIN,true);
        editor.putString(NAME,name);
        editor.putString(SKORCAPITAL,skorcapital);
        editor.apply();
    }
    public  boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN,false);
    }
    public  int  checkLogin(){
       int xxc=0;
        if(!this.isLoggin()){//true olduğunda çalışır...
           xxc=0;
        }
        else{
            xxc=1;
        }
        return xxc;
    }
    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user=new HashMap<>();
        user.put(NAME,sharedPreferences.getString(NAME,null));
        user.put(SKOR,sharedPreferences.getString(SKOR,null));
        return  user;
    }
    public HashMap<String,String> getBayrakulke(){
        HashMap<String,String> user=new HashMap<>();
        user.put(NAME,sharedPreferences.getString(NAME,null));
        user.put(SKORBAYRAK,sharedPreferences.getString(SKORBAYRAK,null));
        return  user;
    }
    public HashMap<String,String> getCapital(){
        HashMap<String,String> user=new HashMap<>();
        user.put(NAME,sharedPreferences.getString(NAME,null));
        user.put(SKORCAPITAL,sharedPreferences.getString(SKORCAPITAL,null));
        return  user;
    }
}

package com.gameflag.gameflag;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.InterstitialAd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
public class game_result extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    public ListView listView;
    private Dialog epicdia;
    private Button btn_kaydet,btn_save,home,restart;
    //private static String URL_NEW_SCORE="https://elitlig.com/kocak/new_score.php";
    private static String URL_NEW_SCORE="http://alpersahinoner.com/kocak/game/new_score.php";
    private static String URL_REGist="http://alpersahinoner.com/kocak/game/session_reg.php";
    private static String URL_RESULT="http://alpersahinoner.com/kocak/game/resultt.php";
    private TextView skor,user_name,title,message;
    private MediaPlayer btn_click;
    private SessionManager sessionManager;
    private Sessionsounds sessionsounds;
    public int durum,yy,sound,language_deger;
    public String  score;
    public useradapter adapter;
    final List<user> user = new ArrayList<user>();
    private EditText edtxt_name;
    private Locale locale;
    private Configuration config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);
        epicdia=new Dialog(this);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2217525225495117/1508267727");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        edtxt_name=findViewById(R.id.name1);
        btn_save=findViewById(R.id.btn_save);
        btn_save.setVisibility(View.INVISIBLE);
        edtxt_name.setVisibility(View.INVISIBLE);
        listView = (ListView)findViewById(R.id.listView1);
        adapter = new useradapter(this, user);
        sessionManager=new SessionManager(this);
        yy= sessionManager.checkLogin();
        home=findViewById(R.id.btn_home);
        restart=findViewById(R.id.btn_restart);
        user_name=findViewById(R.id.user_name);
        skor=findViewById(R.id.skor1);
        Intent intent=getIntent();
        score=intent.getStringExtra("ss1"); //oyun skoru...
        skor.setText(score);
        durum = Integer.parseInt(score);  //integer dönusum
        sessionsounds=new Sessionsounds(this);
        sound= sessionsounds.checksound();
        language_deger=sessionsounds.getLanguageDetail();
        if(language_deger == 1){
            locale = new Locale("tr");
            Locale.setDefault(locale);
            config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }
        else{
            locale = new Locale("en");
            Locale.setDefault(locale);
            config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }
        if(yy==1){
            user_name.setVisibility(View.VISIBLE);
            int i_skor = Integer.parseInt(score);  //integer dönusum
            HashMap<String,String> user=sessionManager.getUserDetail();
            String nw_skor=user.get(sessionManager.SKOR);
            final String mName=user.get(sessionManager.NAME);
            user_name.setText(mName);
            int in_skor=Integer.parseInt(nw_skor);  //integer dönusum
            int en_yeni_skor=i_skor+in_skor;
            final String gonder=String.valueOf(en_yeni_skor);
            sessionManager.createSession(mName,gonder);
            yeniskor(gonder,mName);
        }
        else{
            btn_save.setVisibility(View.VISIBLE);
            edtxt_name.setVisibility(View.VISIBLE);
            edtxt_name.setHint("Username");
            pop_up();
        }
        if(sound==0){
            if(durum<11){
                btn_click = MediaPlayer.create(getApplicationContext(),R.raw.kotu);

            }
            else if(durum>18){
                btn_click = MediaPlayer.create(getApplicationContext(),R.raw.mukemmel);

            }
            else{
                btn_click = MediaPlayer.create(getApplicationContext(),R.raw.iyi);
            }
            btn_click.start();
        }
        else{
            btn_click=null;
        }
        home.setOnTouchListener(new View.OnTouchListener() {
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
                        view.getBackground().setColorFilter(0xfffbf11e, PorterDuff.Mode.SRC_ATOP);
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
        restart.setOnTouchListener(new View.OnTouchListener() {
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
                        view.getBackground().setColorFilter(0xfffbf11e, PorterDuff.Mode.SRC_ATOP);
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
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound==0){
                    btn_click.stop();
                    MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(),R.raw.button_click);
                    mp1.start();
                }
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                startActivity(new Intent(game_result.this,mainmenu.class)); finish();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound==0){
                    btn_click.stop();
                    MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(),R.raw.button_click);
                    mp1.start();
                }
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                startActivity(new Intent(game_result.this,MainActivity.class)); finish();
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String deneme1=edtxt_name.getText().toString().trim();
                if(!deneme1.isEmpty()){
                    kayit(deneme1,"0",score);
                }
            }
        });
    }
    private void pop_up(){
        epicdia.setContentView(R.layout.pop_up1);
        btn_kaydet= epicdia.findViewById(R.id.btn_save);
        title= epicdia.findViewById(R.id.warning_titles);
        message= epicdia.findViewById(R.id.message_textxt);
        btn_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               epicdia.dismiss();
            }
        });
        epicdia.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicdia.show();
    }
    private void adapter(){
        adapter = new useradapter(this,user );
        listView.setAdapter(adapter);
    }
    private void kayit(final String name,final  String deger,final String ss){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_REGist,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            if(response.contains("0")){
                                edtxt_name.setCursorVisible(false);
                                edtxt_name.setFocusableInTouchMode(false);
                                edtxt_name.setFocusable(false);
                                edtxt_name.setVisibility(View.INVISIBLE);
                                sessionManager.createSession(name,ss);
                                sessionManager.createSessionbayrak(name,"0");
                                sessionManager.createSessioncapital(name,"0");
                                btn_save.setVisibility(View.INVISIBLE);
                                user_name.setText(name);
                                skorgetir("0");
                                Toast.makeText(game_result.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                                closeKeyBoard();}
                            else{
                                edtxt_name.setError("Başka Bir isim Giriniz...");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(game_result.this, "HATA!!"+e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                      kayit(name,deger,ss);
                        // Toast.makeText(game_result.this, "HATA!!"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("name",name);
                params.put("deger",deger);
                params.put("ss",ss);
                return params;
            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private  void skorgetir(final String  deger){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_RESULT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("read");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject ob=jsonArray.getJSONObject(i);
                                final String nname=ob.getString("name").trim();
                                final String n_skor=ob.getString("score").trim();
                                user.add(new user(nname, n_skor));
                                adapter();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(game_result.this, "Hata" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        skorgetir(deger);
                        //Toast.makeText(game_result.this, "İnternet Problemi" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String ,String> params=new HashMap<>();
                params.put("deger",deger);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void yeniskor(final String skor,final String name){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_NEW_SCORE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            if(response.contains("0")){
                                skorgetir("0");
                            }
                            else{
                                Toast.makeText(game_result.this, "İşlem Başarız Oldu :((", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(game_result.this, "HATA!!"+e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       yeniskor(skor,name);
                       //  Toast.makeText(game_result.this, "HATA!!"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("skor",skor);
                params.put("name",name);
                return params;
            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void closeKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(sound==0){
            btn_click.stop();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode ==KeyEvent.KEYCODE_BACK){
            if(sound==0){
                btn_click.stop();
            }
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}

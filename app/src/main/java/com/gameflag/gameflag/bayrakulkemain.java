package com.gameflag.gameflag;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
public class bayrakulkemain extends AppCompatActivity {
    private AdView mAdView;
    private String[] flags;
    private ImageView txt;
    private Vibrator zong;
    private ImageView cop1,cop2,cop3,cop4;
    private ImageView can1,can2,can3;
    public int value,btn_num,convert,skor,b,h,a,can,yy,intvibrate,ll,hh,language_deger;
    public String d_flag,country,country1,country2,country3,country4;
    private Button op_1,op_2,op_3,op_4;
    private TextView skor1,txt_oyuncuskor,zaman;
    private Sessionsounds sessionsounds;
    private SessionVibrate sessionVibrate;
    private CountDownTimer countDownTimer,d_bekletme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayrakulkemain);
        //   ...Ads...
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2217525225495117/1668243341");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        // Ads finished...
        txt=findViewById(R.id.flag_name);
        //session ayarlamaları...
        sessionsounds=new Sessionsounds(this);
        sessionVibrate= new SessionVibrate(this);
        yy= sessionsounds.checksound();
        intvibrate = sessionVibrate.checkvibrate();
        language_deger=sessionsounds.getLanguageDetail();
        if(language_deger == 1){
            flags= new String[]{"Almanya", "İspanya", "Portekiz", "Belçika", "Hollanda", "Lüksemburg", "Fransa", "Rusya",
                    "Türkiye", "Singapur", "Tunus", "Azerbaycan", "Arjantin", "Brezilya", "Uruguay", "Kolombiya",
                    "Japonya", "Çin", "Güney Kore", "Amerika Birleşik Devletleri", "Suudi Arabistan", "Birleşik Krallık", "Kanada", "Çin",
                    "İran", "Özbekistan", "Tajikistan", "Kazakistan", "Meksika", "İtalya", "Bulgaristan", "Macaristan",
                    "Hindistan", "Nijer", "Kuzey Kore", "İsrail", "Cezayir", "Türkmenistan", "Pakistan", "Maldivler",
                    "Danimarka", "İsveç", "İzlanda", "Norveç", "Tonga", "İngiltere", "Malta", "İsviçre",
                    "Finlandiya", "Gana", "Sri Lanka", "Afganistan", "Avusturya", "Letonya", "Endonezya", "Polonya",
                    "Tayland", "Tayvan", "Çekya", "Paraguay", "Jersey", "İskoçya", "Galler", "İrlanda",
                    "Suriye", "Mısır", "Yemen", "Irak", "Andora", "Venezuela", "Romanya", "Ekvador",
                    "Yunanistan", "Brunei", "Gürcistan", "Vatikan", "Kuzey Kıbrıs Türk Cumhuriyeti", "Güney Kıbrıs", "Man Adası", "Cebelitarık",
                    "Kuzey Makedonya", "Bosna Hersek", "Arnavutluk", "Kosova", "Hırvatistan", "Sırbistan", "Slovenya", "Slovakya",
                    "Ukrayna", "Belarus", "Litvanya", "Estonya", "San Marino", "Botsvana", "Ruanda", "Mikronezya",
                    "Sudan", "Kuveyt", "Birleşik Arap Emirlikleri", "Ürdün", "Lübnan", "Kiribati", "Karadağ", "Kırgızistan",
                    "Fas", "Tunus", "Türkiye", "Moğolistan", "Katar", "Bahreyn", "Nepal", "Senegal",
                    "Güney Afrika", "Tanzanya", "Filipinler", "Doğu Timor", "Papua Yeni Gine", "Angola", "Uganda", "Libya",
                    "Porto Riko", "Küba", "Malezya", "Kosta Rika", "Jamaika", "Nijerya", "Bangladeş", "Myanmar",
                    "Bolivya", "Zambiya", "Etiyopya", "Gabon", "Kamerun", "Benin", "Madagaskar", "Kenya",
                    "Mali", "Gine", "Çad", "Fildişi Sahili", "Avustralya", "Yeni Zelanda", "Turks and Caicos Adaları", "Fiji",
                    "Dominik Cumhuriyeti", "Panama", "Honduras", "Guetemala", "Hong Kong", "Peru", "Şili", "Laos",
                    "Burkina Faso", "Vietnam", "Somali", "Surinam", "Kongo", "Barbados", "Demokratik Kongo Cumhuriyeti", "Belize",
                    "Benin", "Umman", "Bahamalar", "Mauritius", "Faroe Adaları", "Grönland", "Lihtenştayn", "Aruba",
                    "Bermuda", "Fransız Polinezyası", "Liberya", "Samoa", "Burundi", "Dominika", "Cocos Adaları", "Saint Kitts ve Nevis",
                    "Togo", "Namibya", "Mozambik", "Orta Afrika Cumhuriyeti", "Marshall Adaları", "Lesotho", "Sierra Leone", "Solomon Adaları",
                    "Palau", "Saint Lucia", "Seyşeller", "Esvati̇ni̇", "Yeşil Burun Adaları", "Curacao", "Cayman Adaları", "Amerikan Samoası",
                    "Komorlar", "Eritrea", "Gambiya", "Ekvator Ginesi", "Trinidad and Tobago", "Antigua and Barbuda", "Kiribati", "Malavi"};
        }
        else{
            flags= new String[]{"Germany", "Spain", "Portugal", "Belgium", "Netherlands", "Luxembourg", "France", "Russia",
                    "Turkey", "Singapore", "Tunisia", "Azerbaijan", "Argentina", "Brazil", "Uruguay", "Colombia",
                    "Japan", "China", "South Korea", "United State America", "Saudi Arabia", "United Kingdom", "Canada", "China",
                    "Iran", "Uzbekistan", "Tajikistan", "Kazakhistan", "Mexico", "Italy", "Bulgaria", "Hungary",
                    "India", "Niger", "North Korea", "Israel", "Algeria", "Turkmenistan", "Pakistan", "Maldives",
                    "Denmark", "Sweden", "Iceland", "Norway", "Tonga", "England", "Malta", "Switzerland",
                    "Finland", "Ghana", "Sri Lanka", "Afghanistan", "Austria", "Latvia", "Indonesia", "Poland",
                    "Thailand", "Taiwan", "Czech", "Paraguay", "Jersey", "Scotland", "Wales", "Ireland",
                    "Syria", "Egypt", "Yemen", "Iraq", "Andorra", "Venezuela", "Romania", "Ecuador",
                    "Greece", "Brunei", "Georgia", "Vatican", "Turkish Republic of Northern Cyprus", "South Cyprus", "Isle of Man", "Gibraltar",
                    "North Macedonia", "Bosnia and Herzegovina", "Albania", "Kosovo", "Croatia", "Serbia", "Slovenia", "Slovakia",
                    "Ukraine", "Belarus", "Lithuania", "Estonia", "San Marino", "Botswana", "Rwanda", "Micronesia",
                    "Sudan", "Kwait", "United Arab Emirates", "Jordan", "Lebanon", "Kiribati", "Montenegro", "Kyrgyzstan",
                    "Morocco", "Tunisia", "Turkey", "Mongolia", "Qatar", "Bahrain", "Nepal", "Senegal",
                    "South Africa", "Tanzania", "Philippines", "East Timor", "Papua New Guinea", "Angola", "Uganda", "Libya",
                    "Puerto Rico", "Cuba", "Malaysia", "Costa Rica", "Jamaica", "Nigeria", "Bangladesh", "Myanmar",
                    "Bolivia", "Zambia", "Ethiopia", "Gabon", "Cameroon", "Benin", "Madagascar", "Kenya",
                    "Mali", "Guinea", "Chad", "Ivory Coast", "Australia", "New Zealand", "Turks and Caicos Islands", "Fiji",
                    "Dominican Republic", "Panama", "Honduras", "Guetemala", "Hong Kong", "Peru", "Chile", "Laos",
                    "Burkina Faso", "Vietnam", "Somalia", "Suriname", "Republic of the Congo", "Barbados", "Democratic Republic of Congo", "Belize",
                    "Benin", "Oman", "Bahamas", "Mauritius", "Faroe Islands", "Greenland", "Liechtenstein", "Aruba",
                    "Bermuda", "French Polynesia", "Liberia", "Samoa", "Burundi", "Dominica", "Cocos Islands", "Saint Kitts and Nevis",
                    "Togo", "Namibia", "Mozambique", "Central African Republic", "Marshall Islands", "Lesotho", "Sierra Leone", "Solomon Islands",
                    "Palau", "Saint Lucia", "Seychelles", "Swaziland", "Cape Verde Islands", "Curacao", "Cayman Islands", "American Samoa",
                    "Comoros", "Eritrea", "Gambia", "Equatorial Guinea", "Trinidad and Tobago", "Antigua and Barbuda", "Kiribati", "Malawi"};
        }
        //Toast.makeText(getApplicationContext(),String.valueOf(language_deger), Toast.LENGTH_SHORT).show();
        op_1=findViewById(R.id.op_1);
        op_2=findViewById(R.id.op_2);
        op_3=findViewById(R.id.op_3);
        op_4=findViewById(R.id.op_4);
        //tranperecy...
        op_1.getBackground().setAlpha(255);
        op_2.getBackground().setAlpha(255);
        op_3.getBackground().setAlpha(255);
        op_4.getBackground().setAlpha(255);
        //tıklama kontrolü...
        op_1.setClickable(false);
        op_2.setClickable(false);
        op_3.setClickable(false);
        op_4.setClickable(false);
        //dogru olduklarında correct sembol..
        cop1=findViewById(R.id.cop1);cop2=findViewById(R.id.cop2);cop3=findViewById(R.id.cop3);cop4=findViewById(R.id.cop4);
        cop1.setVisibility(View.INVISIBLE);
        cop2.setVisibility(View.INVISIBLE);
        cop3.setVisibility(View.INVISIBLE);
        cop4.setVisibility(View.INVISIBLE);
        //can değerleri...
        can1=findViewById(R.id.can1);
        can2=findViewById(R.id.can2);
        can3=findViewById(R.id.can3);
        skor1=findViewById(R.id.skor);
        can1.getBackground().setAlpha(255);
        can2.getBackground().setAlpha(255);
        can3.getBackground().setAlpha(255);
        txt_oyuncuskor=findViewById(R.id.oyuncu_skor);
        zong=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE) ;
        //ülke isminin çıktığı yer.
        skor=0  ; can=3;
        convert=0;ll=-2;hh=0;
        txt_oyuncuskor.setText(String.valueOf(skor));
        skor1.setText(String.valueOf(convert));
        questgenerator(); //gelecek sorunun belirlenmesi
       // txt.setText(country);
        zaman=findViewById(R.id.zaman);
        //Question time is finished....
        countDownTimer= new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                zaman.setText(String.valueOf(millisUntilFinished/1000));
            }
            @Override
            public void onFinish() {
                if(intvibrate == 0){
                    zong.vibrate(100);
                }
                countDownTimer.cancel();
                op_1.setClickable(false);op_2.setClickable(false);
                op_3.setClickable(false);op_4.setClickable(false);
                countDownTimer.start();
                questgenerator(); //gelecek sorunun belirlenmesi
               }
        }.start();
        op_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d_flag.contains(country) && btn_num==1){
                    if(yy==0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.correct);
                        mp.start();
                    }
                    cop1.setVisibility(View.VISIBLE);
                    op_1.getBackground().setAlpha(64); // 25% transparent
                    op_1.setClickable(false);
                    op_2.setClickable(false);
                    op_3.setClickable(false);
                    op_4.setClickable(false);
                    countDownTimer.cancel();
                    skor++; txt_oyuncuskor.setText(String.valueOf(skor)); //doğru bilindiğinde...
                    d_bekletme= new CountDownTimer(2500, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }
                        @Override
                        public void onFinish() {
                            countDownTimer.start();
                            questgenerator(); //gelecek sorunun belirlenmesi
                        }
                    }.start();
                }
                else{
                    if(intvibrate == 0){
                        zong.vibrate(250);}
                    if(can ==3){
                        op_1.getBackground().setAlpha(64); // 25% transparent
                        op_1.setClickable(false);
                        can1.getBackground().setAlpha(64);
                        can--; }
                    else if(can==2){
                        op_1.getBackground().setAlpha(64); // 25% transparent
                        op_1.setClickable(false);
                        can2.getBackground().setAlpha(64);
                        can--;
                    }
                    else if(can==1){
                        op_1.getBackground().setAlpha(64); // 25% transparent
                        op_1.setClickable(false);
                        can3.getBackground().setAlpha(64);
                        can--;}
                    else{
                        countDownTimer.cancel();
                        op_1.getBackground().setAlpha(64); // 25% transparent
                        op_1.setClickable(false);
                        op_2.setClickable(false);
                        op_3.setClickable(false);
                        op_4.setClickable(false);
                        if(btn_num==3){
                            op_3.getBackground().setAlpha(64); // 25% transparent
                            cop3.setVisibility(View.VISIBLE);}
                        else if(btn_num==2){
                            op_2.getBackground().setAlpha(64); // 25% transparent
                            cop2.setVisibility(View.VISIBLE);
                        }
                        else if(btn_num==4){
                            op_4.getBackground().setAlpha(64); // 25% transparent
                            cop4.setVisibility(View.VISIBLE);
                        }
                        d_bekletme= new CountDownTimer(2500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }
                            @Override
                            public void onFinish() {
                                countDownTimer.start();
                                questgenerator(); //gelecek sorunun belirlenmesi
                            }
                        }.start();
                    }
                }
            }});
        op_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d_flag.contains(country) &&btn_num==2){
                    if(yy==0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.correct);
                        mp.start();
                    }
                    cop2.setVisibility(View.VISIBLE);//correct symbol...
                    op_2.getBackground().setAlpha(64); // 25% transparent
                    op_1.setClickable(false);
                    op_2.setClickable(false);
                    op_3.setClickable(false);
                    op_4.setClickable(false);
                    countDownTimer.cancel();
                    skor++; txt_oyuncuskor.setText(String.valueOf(skor)); //doğru bilindiğinde
                    d_bekletme= new CountDownTimer(2500, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }
                        @Override
                        public void onFinish() {
                            countDownTimer.start();
                            questgenerator(); //gelecek sorunun belirlenmesi

                        }
                    }.start();
                }
                else{
                    if(intvibrate == 0){
                        zong.vibrate(250);
                    }
                    if(can ==3){
                        can1.getBackground().setAlpha(64);
                        op_2.setClickable(false);
                        op_2.getBackground().setAlpha(64);
                        can--;
                    }
                    else if(can==2){
                        can2.getBackground().setAlpha(64);
                        op_2.setClickable(false);
                        op_2.getBackground().setAlpha(64);
                        can--;
                    }
                    else if(can==1){
                        can3.getBackground().setAlpha(64);
                        op_2.setClickable(false);
                        op_2.getBackground().setAlpha(64);
                        can--;
                    }
                    else{
                        countDownTimer.cancel();
                        op_2.getBackground().setAlpha(64); // 25% transparent
                        op_1.setClickable(false);
                        op_2.setClickable(false);
                        op_3.setClickable(false);
                        op_4.setClickable(false);
                        if(btn_num==1){
                            op_1.getBackground().setAlpha(64); // 25% transparent
                            cop1.setVisibility(View.VISIBLE);
                        }
                        else if(btn_num==3){
                            op_3.getBackground().setAlpha(64); // 25% transparent
                            cop3.setVisibility(View.VISIBLE);
                        }
                        else if(btn_num==4){
                            op_4.getBackground().setAlpha(64); // 25% transparent
                            cop4.setVisibility(View.VISIBLE);
                        }
                        d_bekletme= new CountDownTimer(2000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }
                            @Override
                            public void onFinish() {
                                countDownTimer.start();
                                questgenerator(); //gelecek sorunun belirlenmesi
                            }
                        }.start();
                    }
                }
            }});
        op_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d_flag.contains(country) && btn_num==3){
                    if(yy==0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.correct);
                        mp.start();
                    }
                    cop3.setVisibility(View.VISIBLE);
                    op_3.getBackground().setAlpha(64); // 25% transparent
                    op_1.setClickable(false);
                    op_2.setClickable(false);
                    op_3.setClickable(false);
                    op_4.setClickable(false);
                    countDownTimer.cancel();
                    skor++; txt_oyuncuskor.setText(String.valueOf(skor)); //doğru bilindiğinde...
                    d_bekletme= new CountDownTimer(2500, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }
                        @Override
                        public void onFinish() {
                            countDownTimer.start();
                            questgenerator(); //gelecek sorunun belirlenmesi
                        }
                    }.start();
                }
                else{
                    if(intvibrate == 0){
                        zong.vibrate(250);
                    }
                    if(can ==3){
                        can1.getBackground().setAlpha(64);
                        op_3.setClickable(false);
                        op_3.getBackground().setAlpha(64);
                        can--;
                    }
                    else if(can==2){
                        can2.getBackground().setAlpha(64);
                        op_3.setClickable(false);
                        op_3.getBackground().setAlpha(64);
                        can--;
                    }
                    else if(can==1){
                        can3.getBackground().setAlpha(64);
                        op_3.setClickable(false);
                        op_3.getBackground().setAlpha(64);
                        can--;
                    }
                    else{
                        countDownTimer.cancel();
                        op_3.getBackground().setAlpha(64); // 25% transparent
                        op_1.setClickable(false);
                        op_2.setClickable(false);
                        op_3.setClickable(false);
                        op_4.setClickable(false);
                        if(btn_num==1){
                            op_1.getBackground().setAlpha(64); // 25% transparent
                            cop1.setVisibility(View.VISIBLE);
                        }
                        else if(btn_num==2){
                            op_2.getBackground().setAlpha(64); // 25% transparent
                            cop2.setVisibility(View.VISIBLE);
                        }
                        else if(btn_num==4){
                            op_4.getBackground().setAlpha(64); // 25% transparent
                            cop4.setVisibility(View.VISIBLE);
                        }
                        d_bekletme= new CountDownTimer(2500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }
                            @Override
                            public void onFinish() {
                                countDownTimer.start();
                                questgenerator(); //gelecek sorunun belirlenmesi
                            }
                        }.start();
                        }}}
        });
        op_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d_flag.contains(country) && btn_num==4){
                    if(yy==0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.correct);
                        mp.start();
                    }
                    cop4.setVisibility(View.VISIBLE);
                    op_4.getBackground().setAlpha(64); // 25% transparent
                    op_1.setClickable(false);
                    op_2.setClickable(false);
                    op_3.setClickable(false);
                    op_4.setClickable(false);
                    countDownTimer.cancel();
                    skor++; txt_oyuncuskor.setText(String.valueOf(skor)); //doğru bilindiğinde...
                    d_bekletme= new CountDownTimer(2500, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }
                        @Override
                        public void onFinish() {
                            countDownTimer.start();
                            questgenerator(); //gelecek sorunun belirlenmesi
                        }
                    }.start();
                }
                else{
                    if(intvibrate == 0){
                        zong.vibrate(250);
                    }
                    if(can ==3){
                        can1.getBackground().setAlpha(64);
                        op_4.setClickable(false);
                        op_4.getBackground().setAlpha(64);
                        can--;
                    }
                    else if(can==2){
                        can2.getBackground().setAlpha(64);
                        op_4.setClickable(false);
                        op_4.getBackground().setAlpha(64);
                        can--;
                    }
                    else if(can==1){
                        can3.getBackground().setAlpha(64);
                        op_4.setClickable(false);
                        op_4.getBackground().setAlpha(64);
                        can--;
                    }
                    else{
                        countDownTimer.cancel();
                        op_4.getBackground().setAlpha(64); // 25% transparent
                        op_1.setClickable(false);
                        op_2.setClickable(false);
                        op_3.setClickable(false);
                        op_4.setClickable(false);
                        if(btn_num==1){
                            op_1.getBackground().setAlpha(64); // 25% transparent
                            cop1.setVisibility(View.VISIBLE);
                        }
                        else if(btn_num==2){
                            op_2.getBackground().setAlpha(64); // 25% transparent
                            cop2.setVisibility(View.VISIBLE);
                        }
                        else if(btn_num==3){
                            op_3.getBackground().setAlpha(64); // 25% transparent
                            cop3.setVisibility(View.VISIBLE);
                        }
                        d_bekletme= new CountDownTimer(2500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }
                            @Override
                            public void onFinish() {
                                countDownTimer.start();
                                questgenerator(); //gelecek sorunun belirlenmesi
                            }
                        }.start();
                    }}
            }});}
    public void questgenerator(){
        if(convert == 25){
            countDownTimer.cancel();
            final String s_skor=String.valueOf(skor);
            final String sound=String.valueOf(yy);
            Intent intent1=new Intent(bayrakulkemain.this,gameresultbayrakulke.class);
            intent1.putExtra("ss1",s_skor);
            intent1.putExtra("soundvalue",sound);finish();
            startActivity(intent1);
        }
        ll=ll+2;hh=hh+2; //YENİ SORU ICIN..
        convert++; skor1.setText(String.valueOf(convert)); //game counter..
        txt.setImageResource(0);
        cop4.setVisibility(View.INVISIBLE);cop1.setVisibility(View.INVISIBLE);
        cop2.setVisibility(View.INVISIBLE);cop3.setVisibility(View.INVISIBLE);
        Random rnd=new Random();
        a=rnd.nextInt(hh-ll) + ll;//aynı elemanın gelmemesi için ilk elema son elaman dinamik olacak.... !!
        if(a==0){b=rnd.nextInt(4-0) + 0;h=0;}
        else if(a==1){ b=rnd.nextInt(8-4) + 4;h=1;}
        else if(a==2){ b=rnd.nextInt(12-8) + 8;h=2;}
        else if(a==3){b=rnd.nextInt(16-12) + 12;h=3;}
        else if(a==4){b=rnd.nextInt(20-16) + 16;h=4;}
        else if(a==5){b=rnd.nextInt(24-20) + 20;h=5;}
        else if(a==6){b=rnd.nextInt(28-24) + 24;h=6;}
        else if(a==7){b=rnd.nextInt(32-28) + 28;h=7;}
        else if(a==8){b=rnd.nextInt(36-32) + 32;h=8;}
        else if(a==9){b=rnd.nextInt(40-36) + 36;h=9;}
        else if(a==10){b=rnd.nextInt(44-40) + 40;h=10;}
        else if(a==11){b=rnd.nextInt(48-44) + 44;h=11;}
        else if(a==12){b=rnd.nextInt(52-48) + 48;h=12;}
        else if(a==13){b=rnd.nextInt(56-52) + 52;h=13;}
        else if(a==14){b=rnd.nextInt(60-56) + 56;h=14;}
        else if(a==15){b=rnd.nextInt(64-60) + 60;h=15;}
        else if(a==16){b=rnd.nextInt(68-64) + 64;h=16;}
        else if(a==17){b=rnd.nextInt(72-68) + 68;h=17;}
        else if(a==18){b=rnd.nextInt(76-72) + 72;h=18;}
        else if(a==19){b=rnd.nextInt(80-76) + 76;h=19;}
        else if(a==20){b=rnd.nextInt(84-80) + 80;h=20;}
        else if(a==21){b=rnd.nextInt(88-84) + 84;h=21;}
        else if(a==22){b=rnd.nextInt(92-88) + 88;h=22;}
        else if(a==23){b=rnd.nextInt(96-92) + 92;h=23;}
        else if(a==24){b=rnd.nextInt(100-96) + 96;h=24;}
        else if(a==25){b=rnd.nextInt(104-100) + 100;h=25;}
        else if(a==26){b=rnd.nextInt(108-104) + 104;h=26;}
        else if(a==27){b=rnd.nextInt(112-108) + 108;h=27;}
        else if(a==28){b=rnd.nextInt(116-112) + 112;h=28;}
        else if(a==29){b=rnd.nextInt(120-116) + 116;h=29;}
        else if(a==30){b=rnd.nextInt(124-120) + 120;h=30;}
        else if(a==31){b=rnd.nextInt(128-124) + 124;h=31;}
        else if(a==32){b=rnd.nextInt(132-128) + 128;h=32;}
        else if(a==33){b=rnd.nextInt(136-132) + 132;h=33;}
        else if(a==34){b=rnd.nextInt(140-136) + 136;h=34;}
        else if(a==35){b=rnd.nextInt(144-140) + 140;h=35;}
        else if(a==36){b=rnd.nextInt(148-144) + 144;h=36;}
        else if(a==37){b=rnd.nextInt(152-148) + 148;h=37;}
        else if(a==38){b=rnd.nextInt(156-152) + 152;h=38;}
        else if(a==39){b=rnd.nextInt(160-156) + 156;h=39;}
        else if(a==40){b=rnd.nextInt(164-160) + 160;h=40;}
        else if(a==41){b=rnd.nextInt(168-164) + 164;h=41;}
        else if(a==42){b=rnd.nextInt(172-168) + 168;h=42;}
        else if(a==43){b=rnd.nextInt(176-172) + 172;h=43;}
        else if(a==44){b=rnd.nextInt(180-176) + 176;h=44;}
        else if(a==45){b=rnd.nextInt(184-180) + 180;h=45;}
        else if(a==46){b=rnd.nextInt(188-184) + 184;h=46;}
        else if(a==47){b=rnd.nextInt(192-188) + 188;h=47;}
        else if(a==48){b=rnd.nextInt(196-192) + 192;h=48;}
        else if(a==49){b=rnd.nextInt(200-196) + 196;h=49;}
        country=flags[b];
        soru_getir();    //soru kullanıcıya gösterildi.
    }
    public void soru_getir(){
        Random rnd=new Random();
        int x=0;
        if(h==0){
            if(language_deger ==1){
                country1="Almanya";country2="İspanya";country3="Belçika";country4="Portekiz";
            }
            else{
                country1="Germany";country2="Spain";country3="Belgium";country4="Portugal";
            }
            List<Integer> num=new ArrayList<Integer>();
            HashMap<String,Integer> f =new HashMap<String,Integer>();
            f.put(country1,R.drawable.germany);f.put(country2,R.drawable.spain);
            f.put(country3,R.drawable.belgium);f.put(country4,R.drawable.portugal);
            for(Map.Entry<String, Integer> entry: f.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num.contains(c)){
                    c=rnd.nextInt(4-0) + 0;}
                num.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){
                        op_1.setText(key);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(key);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(key);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(key);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);
                    }
                   }}}
        else if(h==1){
            if(language_deger ==1){
                country1="Fransa";country2="Rusya";country3="Lüksemburg";country4="Hollanda";
            }
            else{
                country1="France";country2="Russia";country3="Luxembourg";country4="Netherlands";
            }
            List<Integer> num1=new ArrayList<Integer>();
            HashMap<String,Integer> f1 =new HashMap<String,Integer>();
            f1.put(country1,R.drawable.france);f1.put(country2,R.drawable.russia);
            f1.put(country3,R.drawable.luxembourg);f1.put(country4,R.drawable.netherlands);
            for(Map.Entry<String, Integer> entry: f1.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num1.contains(c)){
                    c=rnd.nextInt(4-0) + 0;
                }
                num1.add(c);
                if(!key.contains(country) ){
                        if(c==0){
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}
                    }
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){
                        op_1.setText(key);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }else if(c==1){
                        op_2.setText(key);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true); }
                    else if(c==2){
                        op_3.setText(key);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true); }
                    else if(c==3){
                        op_4.setText(key);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);
                    }}}}
        else if(h==2){
            if(language_deger ==1){
                country1="Türkiye";country2="Singapur";country3="Tunus";country4="Azerbaycan";
            }
            else{
                country1="Turkey";country2="Singapore";country3="Tunisia";country4="Azerbaijan";
            }
            List<Integer> num2=new ArrayList<Integer>();
            HashMap<String,Integer> f2 =new HashMap<String,Integer>();
            f2.put(country1,R.drawable.turkey);f2.put(country2,R.drawable.singapore);
            f2.put(country3,R.drawable.tunisia);f2.put(country4,R.drawable.azerbaijan);
            for(Map.Entry<String, Integer> entry: f2.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num2.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num2.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                }
                else{
                    // Toast.makeText(getApplicationContext(), "Resim Gelme", Toast.LENGTH_SHORT).show();
                    txt.setBackgroundResource(value);
                    if(c==0){
                        op_1.setText(key);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(key);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(key);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(key);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}}
        else if(h==3){
            if(language_deger ==1){
                country1="Arjantin";country2="Brezilya";country3="Uruguay";country4="Kolombiya";
            }
            else{
                country1="Argentina";country2="Brazil";country3="Uruguay";country4="Colombia";
            }
            List<Integer> num3=new ArrayList<Integer>();
            HashMap<String,Integer> f3 =new HashMap<String,Integer>();
            f3.put(country1,R.drawable.argentina);f3.put(country2,R.drawable.brazil);
            f3.put(country3,R.drawable.uruguay);f3.put(country4,R.drawable.colombia);
            for(Map.Entry<String, Integer> entry: f3.entrySet()){
                String key = entry.getKey();value = entry.getValue();
                int c=rnd.nextInt(4-0) + 0;
                while(num3.contains(c)){c=rnd.nextInt(4-0) + 0;}
                num3.add(c);
                if(!key.contains(country)){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        }
                        else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        }
                        else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        }
                        else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }
                    x++;}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==4){
            if(language_deger ==1){
                country1="Çin";country2="Amerika Birleşik Devletleri";country3="Japonya";country4="Güney Kore";
            }
            else{
                country1="China";country2="United State America";country3="Japan";country4="South Korea";
            }
            List<Integer> num4=new ArrayList<Integer>();
            HashMap<String,Integer> f4 =new HashMap<String,Integer>();
            f4.put(country1,R.drawable.china); f4.put(country2,R.drawable.abd);
            f4.put(country3,R.drawable.japan);f4.put(country4,R.drawable.southkorea);
            for(Map.Entry<String, Integer> entry: f4.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=rnd.nextInt(4-0) + 0;
                while(num4.contains(c)){c=rnd.nextInt(4-0) + 0;}
                num4.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if(c==0){op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }}
                    x++;}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}
            }
        }
        else if(h==5){
            if(language_deger ==1){
                country1="Suudi Arabistan";country2="Birleşik Krallık";country3="Kanada";country4="Çin";
            }
            else{
                country1="Saudi Arabia";country2="United Kingdom";country3="Canada";country4="China";
            }
            List<Integer> num5=new ArrayList<Integer>();
            HashMap<String,Integer> f5 =new HashMap<String,Integer>();
            f5.put(country1,R.drawable.saudiarabia);f5.put(country2,R.drawable.uk);
            f5.put(country3,R.drawable.canada);f5.put(country4,R.drawable.china);
            for(Map.Entry<String, Integer> entry: f5.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num5.contains(c)){c=rnd.nextInt(4-0) + 0;}
                num5.add(c);
                if(!key.contains(country) ){
                    if(x<3) {
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}
                    x++;}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }
                }}}
        else if(h==6){
            if(language_deger ==1){
                country1="İran";country2="Özbekistan";country3="Tajikistan";country4="Kazakistan";
            }
            else{
                country1="Iran";country2="Uzbekistan";country3="Tajikistan";country4="Kazakhistan";
            }
            List<Integer> num3=new ArrayList<Integer>();
            HashMap<String,Integer> f3 =new HashMap<String,Integer>();
            f3.put(country1,R.drawable.iran);f3.put(country2,R.drawable.uzbekistan);
            f3.put(country3,R.drawable.tajikistan);f3.put(country4,R.drawable.kazakhstan);
            for(Map.Entry<String, Integer> entry: f3.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num3.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num3.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }
                }
            }
        }
        else if(h==7){
            if(language_deger ==1){
                country1="Meksika";country2="İtalya";country3="Bulgaristan";country4="Macaristan";
            }
            else{
                country1="Mexico";country2="Italy";country3="Bulgaria";country4="Hungary";
            }
            List<Integer> num4=new ArrayList<Integer>();
            HashMap<String,Integer> f4 =new HashMap<String,Integer>();
            f4.put(country1,R.drawable.mexico);f4.put(country2,R.drawable.italy);
            f4.put(country3,R.drawable.bulgaria);f4.put(country4,R.drawable.hungary);
            for(Map.Entry<String, Integer> entry: f4.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num4.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num4.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==8){
            if(language_deger ==1){
                country1="Hindistan";country2="Nijer";country3="Kuzey Kore";country4="İsrail";
            }
            else{
                country1="India";country2="Niger";country3="North Korea";country4="Israel";
            }
            List<Integer> num5=new ArrayList<Integer>();
            HashMap<String,Integer> f5 =new HashMap<String,Integer>();
            f5.put(country1,R.drawable.india);f5.put(country2,R.drawable.niger);
            f5.put(country3,R.drawable.northkorea);f5.put(country4,R.drawable.israel);
            for(Map.Entry<String, Integer> entry: f5.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num5.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num5.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);  }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==9){
            if(language_deger ==1){
                country1="Cezayir";country2="Türkmenistan";country3="Pakistan";country4="Maldivler";
            }
            else{
                country1="Algeria";country2="Turkmenistan";country3="Pakistan";country4="Maldives";
            }
            List<Integer> num6=new ArrayList<Integer>();
            HashMap<String,Integer> f6 =new HashMap<String,Integer>();
            f6.put(country1,R.drawable.algeria);f6.put(country2,R.drawable.turkmenistan);
            f6.put(country3,R.drawable.pakistan);f6.put(country4,R.drawable.maldives);
            for(Map.Entry<String, Integer> entry: f6.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num6.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num6.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==10){
            if(language_deger ==1){
                country1="Danimarka";country2="İzlanda";country3="İsveç";country4="Norveç";
            }
            else{
                country1="Denmark";country2="Iceland";country3="Sweden";country4="Norway";
            }
            List<Integer> num7=new ArrayList<Integer>();
            HashMap<String,Integer> f7 =new HashMap<String,Integer>();
            f7.put(country1,R.drawable.denmark);f7.put(country2,R.drawable.iceland);
            f7.put(country3,R.drawable.sweden);f7.put(country4,R.drawable.norway);
            for(Map.Entry<String, Integer> entry: f7.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num7.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num7.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==11){
            if(language_deger ==1){
                country1="Tonga";country2="Malta";country3="İngiltere";country4="İsviçre";
            }
            else{
                country1="Tonga";country2="Malta";country3="England";country4="Switzerland";
            }
            List<Integer> num8=new ArrayList<Integer>();
            HashMap<String,Integer> f8 =new HashMap<String,Integer>();
            f8.put(country1,R.drawable.tonga);f8.put(country2,R.drawable.malta);
            f8.put(country3,R.drawable.england);f8.put(country4,R.drawable.switzerland);
            for(Map.Entry<String, Integer> entry: f8.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num8.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num8.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==12){
            if(language_deger ==1){
                country1="Finlandiya";country2="Sri Lanka";country3="Gana";country4="Afganistan";
            }
            else{
                country1="Finland";country2="Sri Lanka";country3="Ghana";country4="Afghanistan";
            }
            List<Integer> num9=new ArrayList<Integer>();
            HashMap<String,Integer> f9 =new HashMap<String,Integer>();
            f9.put(country1,R.drawable.finland);f9.put(country2,R.drawable.srilanka);
            f9.put(country3,R.drawable.ghana);f9.put(country4,R.drawable.afghanistan);
            for(Map.Entry<String, Integer> entry: f9.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num9.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num9.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1; op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==13){
            if(language_deger == 1){
                country1="Avusturya";country2="Endonezya";country3="Letonya";country4="Polonya";
            }
            else{
                country1="Austria";country2="Indonesia";country3="Latvia";country4="Poland";
            }
            List<Integer> num10=new ArrayList<Integer>();
            HashMap<String,Integer> f10 =new HashMap<String,Integer>();
            f10.put(country1,R.drawable.austria);f10.put(country2,R.drawable.indonesia);
            f10.put(country3,R.drawable.latvia);f10.put(country4,R.drawable.poland);
            for(Map.Entry<String, Integer> entry: f10.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num10.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num10.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);  }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==14){
            if(language_deger ==1){
                country1="Tayland";country2="Çekya";country3="Tayvan";country4="Paraguay";
            }
            else{
                country1="Thailand";country2="Czech";country3="Taiwan";country4="Paraguay";
            }
            List<Integer> num11=new ArrayList<Integer>();
            HashMap<String,Integer> f11 =new HashMap<String,Integer>();
            f11.put(country1,R.drawable.thailand);f11.put(country2,R.drawable.czech);
            f11.put(country3,R.drawable.taiwan);f11.put(country4,R.drawable.paraguay);
            for(Map.Entry<String, Integer> entry: f11.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num11.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num11.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==15){
            if(language_deger ==1){
                country1="Jersey";country2="Galler";country3="İskoçya";country4="İrlanda";
            }
            else{
                country1="Jersey";country2="Wales";country3="Scotland";country4="Ireland";
            }
            List<Integer> num12=new ArrayList<Integer>();
            HashMap<String,Integer> f12 =new HashMap<String,Integer>();
            f12.put(country1,R.drawable.jersey);f12.put(country2,R.drawable.wales);
            f12.put(country3,R.drawable.scotland);f12.put(country4,R.drawable.ireland);
            for(Map.Entry<String, Integer> entry: f12.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num12.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num12.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==16){
            if(language_deger ==1){
                country1="Suriye";country2="Yemen";country3="Mısır";country4="Irak";
            }
            else{
                country1="Syria";country2="Yemen";country3="Egypt";country4="Iraq";
            }
            List<Integer> num13=new ArrayList<Integer>();
            HashMap<String,Integer> f13 =new HashMap<String,Integer>();
            f13.put(country1,R.drawable.syria);f13.put(country2,R.drawable.yemen);
            f13.put(country3,R.drawable.egypt);f13.put(country4,R.drawable.iraq);
            for(Map.Entry<String, Integer> entry: f13.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num13.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num13.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==17){
            if(language_deger ==1){
                country1="Andora";country2="Romanya";country3="Venezuela";country4="Ekvador";
            }
            else{
                country1="Andorra";country2="Romania";country3="Venezuela";country4="Ecuador";
            }
            List<Integer> num14=new ArrayList<Integer>();
            HashMap<String,Integer> f14 =new HashMap<String,Integer>();
            f14.put(country1,R.drawable.andorra);f14.put(country2,R.drawable.romania);
            f14.put(country3,R.drawable.venezuela);f14.put(country4,R.drawable.ecuador);
            for(Map.Entry<String, Integer> entry: f14.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num14.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num14.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==18){
            if(language_deger ==1){
                country1="Yunanistan";country2="Gürcistan";country3="Brunei";country4="Vatikan";
            }
            else{
                country1="Greece";country2="Georgia";country3="Brunei";country4="Vatican";
            }
            List<Integer> num15=new ArrayList<Integer>();
            HashMap<String,Integer> f15 =new HashMap<String,Integer>();
            f15.put(country1,R.drawable.greece);f15.put(country2,R.drawable.georgia);
            f15.put(country3,R.drawable.brunei);f15.put(country4,R.drawable.vatican);
            for(Map.Entry<String, Integer> entry: f15.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num15.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num15.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);  }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==19){
            if(language_deger ==1){
                country1="Kuzey Kıbrıs Türk Cumhuriyeti";country2="Cebelitarık";country3="Güney Kıbrıs";country4="Man Adası";
            }
            else{
                country1="Turkish Republic of Northern Cyprus";country2="Gibraltar";country3="South Cyprus";country4="Isle of Man";
            }
            List<Integer> num16=new ArrayList<Integer>();
            HashMap<String,Integer> f16 =new HashMap<String,Integer>();
            f16.put(country1,R.drawable.northerncyprus);f16.put(country2,R.drawable.gibraltar);
            f16.put(country3,R.drawable.cyprus);f16.put(country4,R.drawable.isleofman);
            for(Map.Entry<String, Integer> entry: f16.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num16.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num16.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==20){
            if(language_deger ==1){
                country1="Kuzey Makedonya";country2="Arnavutluk";country3="Bosna Hersek";country4="Kosova";
            }
            else{
                country1="North Macedonia";country2="Albania";country3="Bosnia and Herzegovina";country4="Kosovo";
            }
            List<Integer> num17=new ArrayList<Integer>();
            HashMap<String,Integer> f17 =new HashMap<String,Integer>();
            f17.put(country1,R.drawable.macedonia);f17.put(country2,R.drawable.albania);
            f17.put(country3,R.drawable.bosnia);f17.put(country4,R.drawable.kosovo);
            for(Map.Entry<String, Integer> entry: f17.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num17.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num17.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==21){
            if(language_deger ==1){
                country1="Hırvatistan";country2="Slovenya";country3="Sırbistan";country4="Slovakya";
            }
            else{
                country1="Croatia";country2="Slovenia";country3="Serbia";country4="Slovakia";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,Integer> f18 =new HashMap<String,Integer>();
            f18.put(country1,R.drawable.croatia);f18.put(country2,R.drawable.slovenia);
            f18.put(country3,R.drawable.serbia);f18.put(country4,R.drawable.slovakia);
            for(Map.Entry<String, Integer> entry: f18.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==22){
            if(language_deger ==1){
                country1="Ukrayna";country2="Litvanya";country3="Belarus";country4="Estonya";
            }
            else{
                country1="Ukraine";country2="Lithuania";country3="Belarus";country4="Estonia";
            }
            List<Integer> num19=new ArrayList<Integer>();
            HashMap<String,Integer> f19 =new HashMap<String,Integer>();
            f19.put(country1,R.drawable.ukraine);f19.put(country2,R.drawable.lithuania);
            f19.put(country3,R.drawable.belarus);f19.put(country4,R.drawable.estonia);
            for(Map.Entry<String, Integer> entry: f19.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num19.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num19.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==23){
            if(language_deger ==1){
                country1="San Marino";country2="Ruanda";country3="Botsvana";country4="Mikronezya";
            }
            else{
                country1="San Marino";country2="Rwanda";country3="Botswana";country4="Micronesia";
            }
            List<Integer> num20=new ArrayList<Integer>();
            HashMap<String,Integer> f20 =new HashMap<String,Integer>();
            f20.put(country1,R.drawable.sanmarino);f20.put(country2,R.drawable.rwanda);
            f20.put(country3,R.drawable.botswana);f20.put(country4,R.drawable.micronesia);
            for(Map.Entry<String, Integer> entry: f20.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num20.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num20.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==24){
            if(language_deger ==1){
                country1="Kuveyt";country2="Birleşik Arap Emirlikleri";country3="Sudan";country4="Ürdün";
            }
            else{
                country1="Kwait";country2="United Arab Emirates";country3="Sudan";country4="Jordan";
            }
            List<Integer> num21=new ArrayList<Integer>();
            HashMap<String,Integer> f21 =new HashMap<String,Integer>();
            f21.put(country1,R.drawable.kwait);f21.put(country2,R.drawable.unitedarabemirates);
            f21.put(country3,R.drawable.sudan);f21.put(country4,R.drawable.jordan);
            for(Map.Entry<String, Integer> entry: f21.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num21.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num21.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==25){
            if(language_deger ==1){
                country1="Lübnan";country2="Karadağ";country3="Kiribati";country4="Kırgızistan";
            }
            else{
                country1="Lebanon";country2="Montenegro";country3="Kiribati";country4="Kyrgyzstan";
            }
            List<Integer> num22=new ArrayList<Integer>();
            HashMap<String,Integer> f22 =new HashMap<String,Integer>();
            f22.put(country1,R.drawable.lebanon);f22.put(country2,R.drawable.montenegro);
            f22.put(country3,R.drawable.kiribati);f22.put(country4,R.drawable.kyrgyzstan);
            for(Map.Entry<String, Integer> entry: f22.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num22.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num22.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==26){
            if(language_deger ==1){
                country1="Fas";country2="Türkiye";country3="Tunus";country4="Moğolistan";
            }
            else{
                country1="Morocco";country2="Turkey";country3="Tunisia";country4="Mongolia";
            }
            List<Integer> num26=new ArrayList<Integer>();
            HashMap<String,Integer> f26 =new HashMap<String,Integer>();
            f26.put(country1,R.drawable.morocco);f26.put(country2,R.drawable.turkey);
            f26.put(country3,R.drawable.tunisia);f26.put(country4,R.drawable.mongolia);
            for(Map.Entry<String, Integer> entry: f26.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num26.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num26.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==27){
            if(language_deger ==1){
                country1="Katar";country2="Nepal";country3="Bahreyn";country4="Senegal";
            }
            else{
                country1="Qatar";country2="Nepal";country3="Bahrain";country4="Senegal";
            }
            List<Integer> num24=new ArrayList<Integer>();
            HashMap<String,Integer> f24 =new HashMap<String,Integer>();
            f24.put(country1,R.drawable.qatar);f24.put(country2,R.drawable.nepal);
            f24.put(country3,R.drawable.bahrain);f24.put(country4,R.drawable.senegal);
            for(Map.Entry<String, Integer> entry: f24.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num24.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num24.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==28){
            if(language_deger ==1){
                country1="Güney Afrika";country2="Tanzanya";country3="Filipinler";country4="Doğu Timor";
            }
            else{
                country1="South Africa";country2="Tanzania";country3="Philippines";country4="East Timor";
            }
            List<Integer> num27=new ArrayList<Integer>();
            HashMap<String,Integer> f27 =new HashMap<String,Integer>();
            f27.put(country1,R.drawable.southafrica); f27.put(country2,R.drawable.tanzania);
            f27.put(country3,R.drawable.philippines);f27.put(country4,R.drawable.easttimor);
            for(Map.Entry<String, Integer> entry: f27.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num27.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num27.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==29){
            if(language_deger ==1){
                country1="Papua Yeni Gine";country2="Angola";country3="Uganda";country4="Libya";
            }
            else{
                country1="Papua New Guinea";country2="Angola";country3="Uganda";country4="Libya";
            }
            List<Integer> num29=new ArrayList<Integer>();
            HashMap<String,Integer> f29 =new HashMap<String,Integer>();
            f29.put(country1,R.drawable.papuanewguinea);f29.put(country2,R.drawable.angola);
            f29.put(country3,R.drawable.uganda);f29.put(country4,R.drawable.libya);
            for(Map.Entry<String, Integer> entry: f29.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num29.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num29.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==30){
            if(language_deger ==1){
                country1="Porto Riko";country2="Malezya";country3="Küba";country4="Kosta Rika";
            }
            else{
                country1="Puerto Rico";country2="Malaysia";country3="Cuba";country4="Costa Rica";
            }
            List<Integer> num30=new ArrayList<Integer>();
            HashMap<String,Integer> f30 =new HashMap<String,Integer>();
            f30.put(country1,R.drawable.puertorico);f30.put(country2,R.drawable.malasya);
            f30.put(country3,R.drawable.cuba);f30.put(country4,R.drawable.costarica);
            for(Map.Entry<String, Integer> entry: f30.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num30.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num30.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==31){
            if(language_deger ==1){
                country1="Jamaika";country2="Bangladeş";country3="Nijerya";country4="Myanmar";
            }
            else{
                country1="Jamaica";country2="Bangladesh";country3="Nigeria";country4="Myanmar";
            }
            List<Integer> num31=new ArrayList<Integer>();
            HashMap<String,Integer> f31 =new HashMap<String,Integer>();
            f31.put(country1,R.drawable.jamaica);f31.put(country2,R.drawable.bangladesh);
            f31.put(country3,R.drawable.nigeria);f31.put(country4,R.drawable.myanmar);
            for(Map.Entry<String, Integer> entry: f31.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num31.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num31.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true); }}}
        }
        else if(h==32){
            if(language_deger ==1){
                country1="Bolivya";country2="Etiyopya";country3="Zambiya";country4="Gabon";
            }
            else{
                country1="Bolivia";country2="Ethiopia";country3="Zambia";country4="Gabon";
            }
            List<Integer> num32=new ArrayList<Integer>();
            HashMap<String,Integer> f32 =new HashMap<String,Integer>();
            f32.put(country1,R.drawable.bolivia);f32.put(country2,R.drawable.ethiopia);
            f32.put(country3,R.drawable.zambia);f32.put(country4,R.drawable.gabon);
            for(Map.Entry<String, Integer> entry: f32.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num32.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num32.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        } }
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true); }
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==33){
            if(language_deger ==1){
                country1="Kamerun";country2="Benin";country3="Madagaskar";country4="Kenya";
            }
            else{
                country1="Cameroon";country2="Benin";country3="Madagascar";country4="Kenya";
            }
            List<Integer> num31=new ArrayList<Integer>();
            HashMap<String,Integer> f31 =new HashMap<String,Integer>();
            f31.put(country1,R.drawable.cameroon);f31.put(country2,R.drawable.benin);
            f31.put(country3,R.drawable.madagascar);f31.put(country4,R.drawable.kenya);
            for(Map.Entry<String, Integer> entry: f31.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num31.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num31.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                    }}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true); }
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true); }
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==34){
            if(language_deger ==1){
                country1="Mali";country2="Çad";country3="Gine";country4="Fildişi Sahili";
            }
            else{
                country1="Mali";country2="Chad";country3="Guinea";country4="Ivory Coast";
            }
            List<Integer> num31=new ArrayList<Integer>();
            HashMap<String,Integer> f31 =new HashMap<String,Integer>();
            f31.put(country1,R.drawable.mali);f31.put(country2,R.drawable.chad);
            f31.put(country3,R.drawable.guinea);f31.put(country4,R.drawable.ivorycoast);
            for(Map.Entry<String, Integer> entry: f31.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num31.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num31.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);
                        }
                }
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==35){
            if(language_deger ==1){
                country1="Avustralya";country2="Turks and Caicos Adaları";country3="Yeni Zelanda";country4="Fiji";
            }
            else{
                country1="Australia";country2="Turks and Caicos Islands";country3="New Zealand";country4="Fiji";
            }
            List<Integer> num32=new ArrayList<Integer>();
            HashMap<String,Integer> f32 =new HashMap<String,Integer>();
            f32.put(country1,R.drawable.australia);f32.put(country2,R.drawable.turksandcaicos);
            f32.put(country3,R.drawable.newzealand);f32.put(country4,R.drawable.fiji);
            for(Map.Entry<String, Integer> entry: f32.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num32.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num32.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==36){
            if(language_deger ==1){
                country1="Dominik Cumhuriyeti";country2="Honduras";country3="Panama";country4="Guetemala";
            }
            else{
                country1="Dominican Republic";country2="Honduras";country3="Panama";country4="Guetemala";
            }
            List<Integer> num33=new ArrayList<Integer>();
            HashMap<String,Integer> f33 =new HashMap<String,Integer>();
            f33.put(country1,R.drawable.dominican);f33.put(country2,R.drawable.honduras);
            f33.put(country3,R.drawable.panama);f33.put(country4,R.drawable.guatemala);
            for(Map.Entry<String, Integer> entry: f33.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num33.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num33.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==37){
            if(language_deger ==1){
                country1="Hong Kong";country2="Peru";country3="Şili";country4="Laos";
            }
            else{
                country1="Hong Kong";country2="Peru";country3="Chile";country4="Laos";
            }
            List<Integer> num34=new ArrayList<Integer>();
            HashMap<String,Integer> f34 =new HashMap<String,Integer>();
            f34.put(country1,R.drawable.hongkong);f34.put(country2,R.drawable.peru);
            f34.put(country3,R.drawable.chile);f34.put(country4,R.drawable.laos);
            for(Map.Entry<String, Integer> entry: f34.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num34.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num34.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==38){
            if(language_deger ==1){
                country1="Burkina Faso";country2="Vietnam";country3="Somali";country4="Surinam";
            }
            else{
                country1="Burkina Faso";country2="Vietnam";country3="Somalia";country4="Suriname";
            }
            List<Integer> num35=new ArrayList<Integer>();
            HashMap<String,Integer> f35 =new HashMap<String,Integer>();
            f35.put(country1,R.drawable.burkinafaso);f35.put(country2,R.drawable.vietnam);
            f35.put(country3,R.drawable.somalia);f35.put(country4,R.drawable.suriname);
            for(Map.Entry<String, Integer> entry: f35.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num35.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num35.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==39){
            if(language_deger ==1){
                country1="Kongo";country2="Barbados";country3="Demokratik Kongo Cumhuriyeti";country4="Belize";
            }
            else{
                country1="Republic of the Congo";country2="Barbados";country3="Democratic Republic of Congo";country4="Belize";
            }
            List<Integer> num36=new ArrayList<Integer>();
            HashMap<String,Integer> f36 =new HashMap<String,Integer>();
            f36.put(country1,R.drawable.republicofthecongo);f36.put(country2,R.drawable.barbados);
            f36.put(country3,R.drawable.democraticrepublicofcongo);f36.put(country4,R.drawable.belize);
            for(Map.Entry<String, Integer> entry: f36.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num36.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num36.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==40){
            if(language_deger ==1){
                country1="Benin";country2="Umman";country3="Bahamalar";country4="Mauritius";
            }
            else{
                country1="Benin";country2="Oman";country3="Bahamas";country4="Mauritius";
            }
            List<Integer> num37=new ArrayList<Integer>();
            HashMap<String,Integer> f37 =new HashMap<String,Integer>();
            f37.put(country1,R.drawable.benin);f37.put(country2,R.drawable.oman);
            f37.put(country3,R.drawable.bahamas);f37.put(country4,R.drawable.mauritius);
            for(Map.Entry<String, Integer> entry: f37.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num37.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num37.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==41){
            if(language_deger ==1){
                country1="Faroe Adaları";country2="Grönland";country3="Lihtenştayn";country4="Aruba";
            }
            else{
                country1="Faroe Islands";country2="Greenland";country3="Liechtenstein";country4="Aruba";
            }
            List<Integer> num38=new ArrayList<Integer>();
            HashMap<String,Integer> f38 =new HashMap<String,Integer>();
            f38.put(country1,R.drawable.faroeislands);f38.put(country2,R.drawable.greenland);
            f38.put(country3,R.drawable.liechtenstein);f38.put(country4,R.drawable.aruba);
            for(Map.Entry<String, Integer> entry: f38.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num38.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num38.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==42){
            if(language_deger ==1){
                country1="Bermuda";country2="Fransız Polinezyası";country3="Liberya";country4="Samoa";
            }
            else{
                country1="Bermuda";country2="French Polynesia";country3="Liberia";country4="Samoa";
            }
            List<Integer> num39=new ArrayList<Integer>();
            HashMap<String,Integer> f39 =new HashMap<String,Integer>();
            f39.put(country1,R.drawable.bermuda);f39.put(country2,R.drawable.frenchpolynesia);
            f39.put(country3,R.drawable.liberia);f39.put(country4,R.drawable.samoa);
            for(Map.Entry<String, Integer> entry: f39.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num39.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num39.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==43){
            if(language_deger ==1){
                country1="Burundi";country2="Dominika";country3="Cocos Adaları";country4="Saint Kitts ve Nevis";
            }
            else{
                country1="Burundi";country2="Dominica";country3="Cocos Islands";country4="Saint Kitts and Nevis";
            }
            List<Integer> num40=new ArrayList<Integer>();
            HashMap<String,Integer> f40 =new HashMap<String,Integer>();
            f40.put(country1,R.drawable.burundi);f40.put(country2,R.drawable.dominica);
            f40.put(country3,R.drawable.cocosisland);f40.put(country4,R.drawable.saintkittsandnevis);
            for(Map.Entry<String, Integer> entry: f40.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num40.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num40.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==44){
            if(language_deger ==1){
                country1="Togo";country2="Namibya";country3="Mozambik";country4="Orta Afrika Cumhuriyeti";
            }
            else{
                country1="Togo";country2="Namibia";country3="Mozambique";country4="Central African Republic";
            }
            List<Integer> num41=new ArrayList<Integer>();
            HashMap<String,Integer> f41 =new HashMap<String,Integer>();
            f41.put(country1,R.drawable.togo);f41.put(country2,R.drawable.namibia);
            f41.put(country3,R.drawable.mozambique);f41.put(country4,R.drawable.centralafricanrepublic);
            for(Map.Entry<String, Integer> entry: f41.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num41.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num41.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==45){
            if(language_deger ==1){
                country1="Marshall Adaları";country2="Lesotho";country3="Sierra Leone";country4="Solomon Adaları";
            }
            else{
                country1="Marshall Islands";country2="Lesotho";country3="Sierra Leone";country4="Solomon Islands";
            }
            List<Integer> num42=new ArrayList<Integer>();
            HashMap<String,Integer> f42 =new HashMap<String,Integer>();
            f42.put(country1,R.drawable.marshallisland);f42.put(country2,R.drawable.lesotho);
            f42.put(country3,R.drawable.sierraleone);f42.put(country4,R.drawable.solomonislands);
            for(Map.Entry<String, Integer> entry: f42.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num42.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num42.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==46){
            if(language_deger ==1){
                country1="Palau";country2="Saint Lucia";country3="Seyşeller";country4="Esvati̇ni̇";
            }
            else{
                country1="Palau";country2="Saint Lucia";country3="Seychelles";country4="Swaziland";
            }
            List<Integer> num43=new ArrayList<Integer>();
            HashMap<String,Integer> f43 =new HashMap<String,Integer>();
            f43.put(country1,R.drawable.palau);f43.put(country2,R.drawable.stlucia);
            f43.put(country3,R.drawable.seychelles);f43.put(country4,R.drawable.swaziland);
            for(Map.Entry<String, Integer> entry: f43.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num43.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num43.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==47){
            if(language_deger ==1){
                country1="Yeşil Burun Adaları";country2="Curacao";country3="Cayman Adaları";country4="Amerikan Samoası";
            }
            else{
                country1="Cape Verde Islands";country2="Curacao";country3="Cayman Islands";country4="American Samoa";
            }
            List<Integer> num44=new ArrayList<Integer>();
            HashMap<String,Integer> f44 =new HashMap<String,Integer>();
            f44.put(country1,R.drawable.yesilburun);f44.put(country2,R.drawable.curacao);
            f44.put(country3,R.drawable.caymanislands);f44.put(country4,R.drawable.americansamoa);
            for(Map.Entry<String, Integer> entry: f44.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num44.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num44.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==48){
            if(language_deger ==1){
                country1="Komorlar";country2="Eritrea";country3="Gambiya";country4="Ekvator Ginesi";
            }
            else{
                country1="Comoros";country2="Eritrea";country3="Gambia";country4="Equatorial Guinea";
            }
            List<Integer> num45=new ArrayList<Integer>();
            HashMap<String,Integer> f45 =new HashMap<String,Integer>();
            f45.put(country1,R.drawable.comoros);f45.put(country2,R.drawable.eritrea);
            f45.put(country3,R.drawable.gambia);f45.put(country4,R.drawable.equatorialguinea);
            for(Map.Entry<String, Integer> entry: f45.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num45.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num45.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==49){
            if(language_deger ==1){
                country1="Trinidad and Tobago";country2="Antigua and Barbuda";country3="Kiribati";country4="Malavi";
            }
            else{
                country1="Trinidad and Tobago";country2="Antigua and Barbuda";country3="Kiribati";country4="Malawi";
            }
            List<Integer> num46=new ArrayList<Integer>();
            HashMap<String,Integer> f46 =new HashMap<String,Integer>();
            f46.put(country1,R.drawable.trinidadandtobago);f46.put(country2,R.drawable.antiguaandbarbuda);
            f46.put(country3,R.drawable.kiribati);f46.put(country4,R.drawable.malawi);
            for(Map.Entry<String, Integer> entry: f46.entrySet()){
                String key = entry.getKey();
                value = entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num46.contains(c)){c=rnd.nextInt(4-0) + 0; }
                num46.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(key);op_1.setClickable(true);
                        } else if (c == 1) {
                            op_2.setText(key);op_2.setClickable(true);
                        } else if (c == 2) {
                            op_3.setText(key);op_3.setClickable(true);
                        } else if (c == 3) {
                            op_4.setText(key);op_4.setClickable(true);}}}
                else{
                    txt.setBackgroundResource(value);
                    if(c==0){op_1.setText(key);d_flag=key;btn_num=1;op_1.setClickable(true);}
                    else if(c==1){op_2.setText(key);d_flag=key;btn_num=2;op_2.setClickable(true);}
                    else if(c==2){op_3.setText(key);d_flag=key;btn_num=3;op_3.setClickable(true);}
                    else if(c==3){op_4.setText(key);d_flag=key;btn_num=4;op_4.setClickable(true);}}}
        }
        op_1.getBackground().setAlpha(255);
        op_2.getBackground().setAlpha(255);
        op_3.getBackground().setAlpha(255);
        op_4.getBackground().setAlpha(255);
        }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode ==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME); finish();
            startActivity(intent);
           System.exit(0);
        }
        else if(keyCode ==KeyEvent.KEYCODE_HOME){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME); finish();
            startActivity(intent);
            System.exit(0);
        }
        return super.onKeyDown(keyCode, event);}}
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
public class capitalmain extends AppCompatActivity {
    private AdView mAdView;
    String[] flag={"Germany","Spain","Portugal","Belgium","Netherlands","Luxembourg","France","Russia",
            "Turkey","Singapore","Tunisia","Azerbaijan","Argentina","Brazil","Uruguay","Colombia",
            "Japan","China","South Korea","United State America","Saudi Arabia","United Kingdom","Canada","China",
            "Iran","Uzbekistan","Tajikistan","Kazakhistan","Mexico","Italy","Bulgaria","Hungary",
            "India","Niger","North Korea","Israel", "Algeria","Turkmenistan","Pakistan","Maldives",
            "Denmark","Sweden","Iceland","Norway","Tonga","England","Malta","Switzerland",
            "Finland","Ghana","Poland","Afghanistan","Austria","Latvia","Indonesia","Poland",
            "Thailand","Taiwan","Czech","Paraguay", "Jersey","Scotland","Wales","Ireland",
            "Syria","Egypt","Yemen","Iraq","Andorra","Venezuela","Romania","Ecuador",
            "Greece","Armenia","Georgia","Vatican","Turkish Republic of Northern Cyprus","Israel","Isle of Man","Gibraltar",
            "Ukraine","Belarus","Lithuania","Estonia", "Madagascar","Benin","United Arab Emirates","Jordan",
            "Lebanon","Kiribati","Montenegro","Kyrgyzstan","Morocco","Tunisia","Turkey","Mongolia",
            "Qatar","Bahrain","Nepal","Senegal", "South Africa","Tanzania","Philippines","East Timor",
            "Papua New Guinea","Angola","Uganda","Libya", "Puerto Rico","Cuba","Malaysia","Costa Rica",
            "Jamaica","Nigeria","Bangladesh","Myanmar","Bolivia","Zambia","Ethiopia","Gabon",
            "Cameroon","Benin","Ethiopia","Kenya","Mali","Guinea","Chad","Ivory Coast"};
    String[] flag_Turkce={"Almanya","İspanya","Portekiz","Belçika","Hollanda","Lüksemburg","Fransa","Rusya",
            "Türkiye","Singapur","Tunus","Azerbaycan","Arjantin","Brezilya","Uruguay","Kolombiya",
            "Japonya","Çin","Güney Kore","Amerika Birleşik Devletleri","Suudi Arabistan","Birleşik Krallık","Kanada","Çin",
            "İran","Özbekistan","Tajikistan","Kazakistan","Meksika","İtalya","Bulgaristan","Macaristan",
            "Hindistan","Nijer","Kuzey Kore","İsrail", "Cezayir","Türkmenistan","Pakistan","Maldivler",
            "Danimarka","İsveç","İzlanda","Norveç","Tonga","İngiltere","Malta","İsviçre",
            "Finlandiya","Gana","Polonya","Afganistan","Avusturya","Letonya","Endonezya","Polonya",
            "Tayland","Tayvan","Çekya","Paraguay","Jersey","İskoçya","Galler","İrlanda",
            "Suriye","Mısır","Yemen","Irak","Andora","Venezuela","Romanya","Ekvador",
            "Yunanistan","Ermenistan","Gürcistan","Vatikan","Kuzey Kıbrıs Türk Cumhuriyeti","İsrail","Man Adası","Cebelitarık",
            "Ukrayna","Belarus","Litvanya","Estonya","Madagaskar","Benin","Birleşik Arap Emirlikleri","Ürdün",
            "Lübnan","Kiribati","Karadağ","Kırgızistan","Fas","Tunus","Türkiye","Moğolistan",
            "Katar","Bahreyn","Nepal","Senegal", "Güney Afrika","Tanzanya","Filipinler","Doğu Timor",
            "Papua Yeni Gine","Angola","Uganda","Libya","Porto Riko","Küba","Malezya","Kosta Rika",
            "Jamaika","Nijerya","Bangladeş","Myanmar","Bolivya","Zambiya","Etiyopya","Gabon",
            "Kamerun","Benin","Etiyopya","Kenya","Mali","Gine","Çad","Fildişi Sahili"};
    private TextView txt;Vibrator zong;
    private ImageView cop1,cop2,cop3,cop4;
    private ImageView can1,can2,can3;
    private int btn_num,convert,skor,b,h,a,can,yy,intvibrate,ll,hh,language_deger;
    private String d_flag,country,sayac,country1,country2,country3,country4,capital1,capital2,capital3,capital4;
    private Button op_1,op_2,op_3,op_4;
    private TextView skor1,txt_oyuncuskor,isim1,isim2,isim3,isim4,zaman;
    private CountDownTimer countDownTimer,d_bekletme;
    private Sessionsounds sessionsounds;
    private SessionVibrate sessionVibrate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitalmain);
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
        sessionsounds=new Sessionsounds(this);
        sessionVibrate= new SessionVibrate(this);
        yy= sessionsounds.checksound();
        intvibrate = sessionVibrate.checkvibrate();
        language_deger=sessionsounds.getLanguageDetail();
        op_1=findViewById(R.id.op_1);
        op_2=findViewById(R.id.op_2);
        op_3=findViewById(R.id.op_3);
        op_4=findViewById(R.id.op_4);
        //doğru ulke gösterim....
        isim1=findViewById(R.id.isim1);
        isim2=findViewById(R.id.isim2);
        isim3=findViewById(R.id.isim3);
        isim4=findViewById(R.id.isim4);
        isim1.setVisibility(View.INVISIBLE); isim2.setVisibility(View.INVISIBLE); isim3.setVisibility(View.INVISIBLE); isim4.setVisibility(View.INVISIBLE);
        //tranperecy...
        op_1.getBackground().setAlpha(255);op_2.getBackground().setAlpha(255);
        op_3.getBackground().setAlpha(255);op_4.getBackground().setAlpha(255);
        //tıklama kontrolü...
        op_1.setClickable(false);op_2.setClickable(false);
        op_3.setClickable(false);op_4.setClickable(false);
        //dogru olduklarında correct sembol..
        cop1=findViewById(R.id.cop1);cop2=findViewById(R.id.cop2);cop3=findViewById(R.id.cop3);cop4=findViewById(R.id.cop4);
        cop1.setVisibility(View.INVISIBLE);cop2.setVisibility(View.INVISIBLE);
        cop3.setVisibility(View.INVISIBLE);cop4.setVisibility(View.INVISIBLE);
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
        skor=1; can=3;
        skor1.setText(String.valueOf(skor));
        convert=0;ll=-2;hh=0;
        txt_oyuncuskor.setText(String.valueOf(convert));
        questgenerator(); //gelecek sorunun belirlenmesi
        zaman=findViewById(R.id.zaman);
        //Zaman işlemleri...
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
        //soru kullanıcıya gösterildi.
        soru_getir();
        op_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d_flag.contains(country) &&btn_num==1){
                    if(yy==0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.correct);
                        mp.start();
                    }
                    cop1.setVisibility(View.VISIBLE);
                    countDownTimer.cancel();
                    op_1.getBackground().setAlpha(64); // 25% transparent
                    op_1.setClickable(false);
                    op_2.setClickable(false);
                    op_3.setClickable(false);
                    op_4.setClickable(false);
                    convert++; //doğru bilindiğinde
                    txt_oyuncuskor.setText(String.valueOf(convert));
                    d_bekletme= new CountDownTimer(2500, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }
                        @Override
                        public void onFinish() {
                            d_bekletme.cancel();
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
                        op_1.getBackground().setAlpha(64); // 25% transparent
                        op_1.setClickable(false);
                        can1.getBackground().setAlpha(64);
                        can--; isim1.setVisibility(View.VISIBLE);}
                    else if(can==2){
                        op_1.getBackground().setAlpha(64); // 25% transparent
                        op_1.setClickable(false);
                        can2.getBackground().setAlpha(64);
                        can--;isim1.setVisibility(View.VISIBLE);
                    }
                    else if(can==1){
                        op_1.getBackground().setAlpha(64); // 25% transparent
                        op_1.setClickable(false);
                        can3.getBackground().setAlpha(64);
                        can--;isim1.setVisibility(View.VISIBLE);
                    }
                    else{
                        countDownTimer.cancel();
                        op_1.setClickable(false);op_2.setClickable(false);
                        op_3.setClickable(false);op_4.setClickable(false);
                        op_1.getBackground().setAlpha(64); // 25% transparent
                        isim1.setVisibility(View.VISIBLE);
                        d_bekletme= new CountDownTimer(2500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }
                            @Override
                            public void onFinish() {
                                d_bekletme.cancel();
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
                    cop2.setVisibility(View.VISIBLE);
                    op_2.getBackground().setAlpha(64); // 25% transparent
                    op_1.setClickable(false);
                    op_2.setClickable(false);
                    op_3.setClickable(false);
                    op_4.setClickable(false);countDownTimer.cancel();
                    convert++; //doğru bilindiğinde
                    txt_oyuncuskor.setText(String.valueOf(convert));
                    d_bekletme= new CountDownTimer(2500, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }
                        @Override
                        public void onFinish() {
                            d_bekletme.cancel();
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
                        can--;isim2.setVisibility(View.VISIBLE);
                    }
                    else if(can==2){
                        can2.getBackground().setAlpha(64);
                        op_2.setClickable(false);
                        op_2.getBackground().setAlpha(64);
                        can--;isim2.setVisibility(View.VISIBLE);
                    }
                    else if(can==1){
                        can3.getBackground().setAlpha(64);
                        op_2.setClickable(false);
                        op_2.getBackground().setAlpha(64);
                        can--;isim2.setVisibility(View.VISIBLE);
                    }
                    else{
                        countDownTimer.cancel();
                        op_1.setClickable(false);op_2.setClickable(false);
                        op_3.setClickable(false);op_4.setClickable(false);
                        op_2.getBackground().setAlpha(64); // 25% transparent
                        isim2.setVisibility(View.VISIBLE);
                        d_bekletme= new CountDownTimer(2500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }
                            @Override
                            public void onFinish() {
                                d_bekletme.cancel();
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
                if(d_flag.contains(country)&&btn_num==3 ){
                    if(yy==0){
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.correct);
                        mp.start();
                    }
                    cop3.setVisibility(View.VISIBLE);
                    op_3.getBackground().setAlpha(64); // 25% transparent
                    op_1.setClickable(false);
                    op_2.setClickable(false);
                    op_3.setClickable(false);
                    op_4.setClickable(false); countDownTimer.cancel();
                    convert++; //doğru bilindiğinde
                    txt_oyuncuskor.setText(String.valueOf(convert));
                    d_bekletme= new CountDownTimer(2500, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }
                        @Override
                        public void onFinish() {
                            d_bekletme.cancel();
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
                        can--;isim3.setVisibility(View.VISIBLE);
                    }
                    else if(can==2){
                        can2.getBackground().setAlpha(64);
                        op_3.setClickable(false);
                        op_3.getBackground().setAlpha(64);
                        can--;isim3.setVisibility(View.VISIBLE);
                    }
                    else if(can==1){
                        can3.getBackground().setAlpha(64);
                        op_3.setClickable(false);
                        op_3.getBackground().setAlpha(64);
                        can--;isim3.setVisibility(View.VISIBLE);
                    }
                    else{
                        countDownTimer.cancel();
                        op_1.setClickable(false);op_2.setClickable(false);
                        op_3.setClickable(false);op_4.setClickable(false);
                        op_3.getBackground().setAlpha(64); // 25% transparent
                       isim3.setVisibility(View.VISIBLE);
                        d_bekletme= new CountDownTimer(2500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }
                            @Override
                            public void onFinish() {
                                d_bekletme.cancel();
                                countDownTimer.start();
                                questgenerator(); //gelecek sorunun belirlenmesi
                            }
                        }.start();}}}
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
                    op_4.setClickable(false); countDownTimer.cancel();
                    convert++; //doğru bilindiğinde
                    txt_oyuncuskor.setText(String.valueOf(convert));
                    d_bekletme= new CountDownTimer(2500, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }
                        @Override
                        public void onFinish() {
                            d_bekletme.cancel();
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
                        can--;isim4.setVisibility(View.VISIBLE);
                    }
                    else if(can==2){
                        can2.getBackground().setAlpha(64);
                        op_4.setClickable(false);
                        op_4.getBackground().setAlpha(64);
                        can--;isim4.setVisibility(View.VISIBLE);
                    }
                    else if(can==1){
                        can3.getBackground().setAlpha(64);
                        op_4.setClickable(false);
                        op_4.getBackground().setAlpha(64);
                        can--;isim4.setVisibility(View.VISIBLE);
                    }
                    else{
                        countDownTimer.cancel();
                        op_1.setClickable(false);op_2.setClickable(false);
                        op_3.setClickable(false);op_4.setClickable(false);
                        op_4.getBackground().setAlpha(64); // 25% transparent
                        isim4.setVisibility(View.VISIBLE);
                        d_bekletme= new CountDownTimer(2500, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }
                            @Override
                            public void onFinish() {
                                d_bekletme.cancel();
                                countDownTimer.start();
                                questgenerator(); //gelecek sorunun belirlenmesi
                            }
                        }.start();
                    }}
            }});}
    public void questgenerator(){
        cop1.setVisibility(View.INVISIBLE);
        cop2.setVisibility(View.INVISIBLE);
        cop3.setVisibility(View.INVISIBLE);
        cop4.setVisibility(View.INVISIBLE);
        isim1.setText("");isim2.setText("");
        isim3.setText("");isim4.setText(""); //  reset....
        isim1.setVisibility(View.INVISIBLE);isim2.setVisibility(View.INVISIBLE);
        isim3.setVisibility(View.INVISIBLE);isim4.setVisibility(View.INVISIBLE);
        if(skor==17){
            countDownTimer.cancel();
            final String s_skor=String.valueOf(convert);
            final String sound=String.valueOf(yy);
            Intent intent1=new Intent(capitalmain.this,gameresultcapital.class);
            intent1.putExtra("ss1",s_skor);
            intent1.putExtra("soundvalue",sound);finish();
            startActivity(intent1);
        }skor++; //game counter
        skor1.setText(String.valueOf(skor-1));
        ll=ll+2;
        hh=hh+2;
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
        if(language_deger == 1){
            country =flag_Turkce[b];
        }
        else{
            country=flag[b];
        }
        txt.setText(country);
        soru_getir();    //soru kullanıcıya gösterildi.
    }
    public void soru_getir(){
        Random rnd=new Random();
        int x=0;
        if(h==0){
            if(language_deger ==1){
                country1="Almanya";country2="İspanya";country3="Belçika";country4="Portekiz";
                capital1="Berlin";capital2="Madrid";capital3="Brüksel";capital4="Lizbon";
            }
            else{
                country1="Germany";country2="Spain";country3="Belgium";country4="Portugal";
                capital1="Berlin";capital2="Madrid";capital3="Brussels";capital4="Lisbon";
            }
            List<Integer> num=new ArrayList<Integer>();
            HashMap<String,String> f =new HashMap<String,String>();
            f.put(country1,capital1);f.put(country2,capital2);
            f.put(country3,capital3);f.put(country4,capital4);
            for(Map.Entry<String, String> entry: f.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num.contains(c)){
                    c=rnd.nextInt(4-0) + 0;
                }
                num.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);
                    }}}}
        else if(h==1){
            if(language_deger ==1){
                country1="Fransa";country2="Rusya";country3="Lüksemburg";country4="Hollanda";
                capital1="Paris";capital2="Moskova";capital3="Lüksemburg";capital4="Amsterdam";
            }
            else{
                country1="France";country2="Russia";country3="Luxembourg";country4="Netherlands";
                capital1="Paris";capital2="Moscow";capital3="Luxembourg";capital4="Amsterdam";
            }
            List<Integer> num1=new ArrayList<Integer>();
            HashMap<String,String> f1 =new HashMap<String,String>();
            f1.put(country1,capital1);
            f1.put(country2,capital2);
            f1.put(country3,capital3);
            f1.put(country4,capital4);
            for(Map.Entry<String, String> entry: f1.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num1.contains(c)){
                    c=rnd.nextInt(4-0) + 0;
                }
                num1.add(c);
                if(!key.contains(country) ){
                    if(x<3)
                        if(c==0){
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);}
                    x++;}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);}
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);}
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);
                    }}}}
        else if(h==2){
            if(language_deger ==1){
                country1="Türkiye";country2="Singapur";country3="Tunus";country4="Azerbaycan";
                capital1="Ankara";capital2="Singapur";capital3="Tunus";capital4="Bakü";
            }
            else{
                country1="Turkey";country2="Singapore";country3="Tunisia";country4="Azerbaijan";
                capital1="Ankara";capital2="Singapore";capital3="Tunisia";capital4="Baku";
            }
            List<Integer> num3=new ArrayList<Integer>();
            HashMap<String,String> f3 =new HashMap<String,String>();
            f3.put(country1,capital1);
            f3.put(country2,capital2);
            f3.put(country3,capital3);
            f3.put(country4,capital4);
            for(Map.Entry<String, String> entry: f3.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num3.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num3.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}}

        else if(h==3){
            if(language_deger ==1){
                country1="Arjantin";country2="Brezilya";country3="Uruguay";country4="Kolombiya";
                capital1="Buenos Aires";capital2="Brasília";capital3="Montevideo";capital4="Bogota";
            }
            else{
                country1="Argentina";country2="Brazil";country3="Uruguay";country4="Colombia";
                capital1="Buenos Aires";capital2="Brasília";capital3="Montevideo";capital4="Bogota";
            }
            List<Integer> num3=new ArrayList<Integer>();
            HashMap<String,String> f =new HashMap<String,String>();
            f.put(country1,capital1);
            f.put(country2,capital2);
            f.put(country3,capital3);
            f.put(country4,capital4);
            for(Map.Entry<String, String> entry: f.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num3.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num3.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==4){
            if(language_deger ==1){
                country1="Çin";country2="Amerika Birleşik Devletleri";country3="Japonya";country4="Güney Kore";
                capital1="Pekin";capital2="Washington";capital3="Tokyo";capital4="Seul";
            }
            else{
                country1="China";country2="United State America";country3="Japan";country4="South Korea";
                capital1="Beijing";capital2="Washington";capital3="Tokyo";capital4="Seoul";
            }
            List<Integer> num1=new ArrayList<Integer>();
            HashMap<String,String> f1 =new HashMap<String,String>();
            f1.put(country1,capital1);f1.put(country2,capital2);
            f1.put(country3,capital3);f1.put(country4,capital4);
            for(Map.Entry<String, String> entry: f1.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num1.contains(c)){c=rnd.nextInt(4-0) + 0;}
                num1.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }
                }
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}
            }
        }
        else if(h==5){
            if(language_deger ==1){
                country1="Suudi Arabistan";country2="Birleşik Krallık";country3="Kanada";country4="Çin";
                capital1="Riyad";capital2="Londra";capital3="Ottava";capital4="Pekin";
            }
            else{
                country1="Saudi Arabia";country2="United Kingdom";country3="Canada";country4="China";
                capital1="Riyadh";capital2="Londra";capital3="Ottawa";capital4="Beijing";
            }
            List<Integer> num5=new ArrayList<Integer>();
            HashMap<String,String> f5 =new HashMap<String,String>();
            f5.put(country1,capital1);f5.put(country2,capital2);
            f5.put(country3,capital3);f5.put(country4,capital4);
            for(Map.Entry<String, String> entry: f5.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num5.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num5.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}}
        else if(h==6){
            if(language_deger ==1){
                country1="İran";country2="Özbekistan";country3="Tajikistan";country4="Kazakistan";
                capital1="Tahran";capital2="Taşkent";capital3="Duşanbe";capital4="Astana";
            }
            else{
                country1="Iran";country2="Uzbekistan";country3="Tajikistan";country4="Kazakhistan";
                capital1="Tehran";capital2="Tashkent";capital3="Dushanbe";capital4="Astana";
            }
            List<Integer> num3=new ArrayList<Integer>();
            HashMap<String,String> f3 =new HashMap<String,String>();
            f3.put(country1,capital1);f3.put(country2,capital2);
            f3.put(country3,capital3);f3.put(country4,capital4);
            for(Map.Entry<String, String> entry: f3.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num3.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num3.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}
            }
        }
        else if(h==7){
            if(language_deger ==1){
                country1="Meksika";country2="İtalya";country3="Bulgaristan";country4="Macaristan";
                capital1="Mexico";capital2="Roma";capital3="Sofya";capital4="Budapeşte";
            }
            else{
                country1="Mexico";country2="Italy";country3="Bulgaria";country4="Hungary";
                capital1="Mexico";capital2="Roma";capital3="Sofia";capital4="Budapest";
            }
            List<Integer> num7=new ArrayList<Integer>();
            HashMap<String,String> f4 =new HashMap<String,String>();
            f4.put(country1,capital1);f4.put(country2,capital2);
            f4.put(country3,capital3);f4.put(country4,capital4);
            for(Map.Entry<String,String> entry: f4.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num7.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num7.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==8){
            if(language_deger ==1){
                country1="Hindistan";country2="Nijer";country3="Kuzey Kore";country4="İsrail";
                capital1="Yeni Delhi";capital2="Niamey";capital3="Pyongyang";capital4="Tel Aviv";
            }
            else{
                country1="India";country2="Niger";country3="North Korea";country4="Israel";
                capital1="New Delhi";capital2="Niamey";capital3="Pyongyang";capital4="Tel Aviv";
            }
            List<Integer> num8=new ArrayList<Integer>();
            HashMap<String,String> f5 =new HashMap<String,String>();
            f5.put(country1,capital1);f5.put(country2,capital2);
            f5.put(country3,capital3);f5.put(country4,capital4);
            for(Map.Entry<String, String> entry: f5.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num8.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num8.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==9){
            if(language_deger ==1){
                country1="Armavutluk";country2="Türkmenistan";country3="Pakistan";country4="Maldivler";
                capital1="Algeria";capital2="Aşkabat";capital3="İslamabat";capital4="Male";
            }
            else{
                country1="Algeria";country2="Turkmenistan";country3="Pakistan";country4="Maldives";
                capital1="Algeria";capital2="Ashgabat";capital3="Islamabad";capital4="Male";
            }
            List<Integer> num9=new ArrayList<Integer>();
            HashMap<String,String> f6 =new HashMap<String,String>();
            f6.put(country1,capital1);f6.put(country2,capital2);
            f6.put(country3,capital3);f6.put(country4,capital4);
            for(Map.Entry<String,String> entry: f6.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num9.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num9.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==10){
            if(language_deger ==1){
                country1="Danimarka";country2="İzlanda";country3="İsveç";country4="Norveç";
                capital1="Kopenhag";capital2="Reykjavik";capital3="Stokholm";capital4="Oslo";
            }
            else{
                country1="Denmark";country2="Iceland";country3="Sweden";country4="Norway";
                capital1="Copenhagen";capital2="Reykjavik";capital3="Stockholm";capital4="Oslo";
            }
            List<Integer> num10=new ArrayList<Integer>();
            HashMap<String,String> f7 =new HashMap<String,String>();
            f7.put(country1,capital1);f7.put(country2,capital2);
            f7.put(country3,capital3);f7.put(country4,capital4);
            for(Map.Entry<String,String> entry: f7.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num10.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num10.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==11){
            if(language_deger ==1){
                country1="Tonga";country2="Malta";country3="İngiltere";country4="İsviçre";
                capital1="Nuku'alofa";capital2="Malta";capital3="Londra";capital4="Bern";
            }
            else{
                country1="Tonga";country2="Malta";country3="England";country4="Switzerland";
                capital1="Nuku'alofa";capital2="Malta";capital3="Londra";capital4="Bern";
            }
            List<Integer> num11=new ArrayList<Integer>();
            HashMap<String,String> f8 =new HashMap<String,String>();
            f8.put(country1,capital1);f8.put(country2,capital2);
            f8.put(country3,capital3);f8.put(country4,capital4);
            for(Map.Entry<String, String> entry: f8.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num11.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num11.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==12){
            if(language_deger ==1){
                country1="Finlandiya";country2="Polonya";country3="Gana";country4="Afganistan";
                capital1="Helsinki";capital2="Varşova";capital3="Akra";capital4="Kabil";
            }
            else{
                country1="Finland";country2="Poland";country3="Ghana";country4="Afghanistan";
                capital1="Helsinki";capital2="Warsaw";capital3="Accra";capital4="Kabil";
            }
            List<Integer> num12=new ArrayList<Integer>();
            HashMap<String,String> f9 =new HashMap<String,String>();
            f9.put(country1,capital1);f9.put(country2,capital2);
            f9.put(country3,capital3);f9.put(country4,capital4);
            for(Map.Entry<String, String> entry: f9.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num12.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num12.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==13){
            if(language_deger ==1){
                country1="Avusturya";country2="Endonezya";country3="Letonya";country4="Polonya";
                capital1="Viyana";capital2="Cakarta";capital3="Riga";capital4="Varşova";
            }
            else{
                country1="Austria";country2="Indonesia";country3="Latvia";country4="Poland";
                capital1="Vienna";capital2="Jakarta";capital3="Riga";capital4="Warsaw";
            }
            List<Integer> num13=new ArrayList<Integer>();
            HashMap<String,String> f10 =new HashMap<String,String>();
            f10.put(country1,capital1);f10.put(country2,capital2);
            f10.put(country3,capital3);f10.put(country4,capital4);
            for(Map.Entry<String, String> entry: f10.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num13.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num13.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==14){
            if(language_deger ==1){
                country1="Tayland";country2="Çekya";country3="Tayvan";country4="Paraguay";
                capital1="Bangkok";capital2="Prag";capital3="Taipei";capital4="Asuncion";
            }
            else{
                country1="Thailand";country2="Czech";country3="Taiwan";country4="Paraguay";
                capital1="Bangkok";capital2="Prague";capital3="Taipei";capital4="Asuncion";
            }
            List<Integer> num14=new ArrayList<Integer>();
            HashMap<String,String> f11 =new HashMap<String,String>();
            f11.put(country1,capital1);f11.put(country2,capital2);
            f11.put(country3,capital3);f11.put(country4,capital4);
            for(Map.Entry<String, String> entry: f11.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num14.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num14.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==15){
            if(language_deger ==1){
                country1="Jersey";country2="Galler";country3="İskoçya";country4="İrlanda";
                capital1="Saint Helier";capital2="Cardiff";capital3="Edinburgh";capital4="Dublin";
            }
            else{
                country1="Jersey";country2="Wales";country3="Scotland";country4="Ireland";
                capital1="Saint Helier";capital2="Cardiff";capital3="Edinburgh";capital4="Dublin";
            }
            List<Integer> num15=new ArrayList<Integer>();
            HashMap<String,String> f12 =new HashMap<String,String>();
            f12.put(country1,capital1);f12.put(country2,capital2);
            f12.put(country3,capital3);f12.put(country4,capital4);
            for(Map.Entry<String, String> entry: f12.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num15.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num15.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==16){
            if(language_deger ==1){
                country1="Suriye";country2="Yemen";country3="Mısır";country4="Irak";
                capital1="Şam";capital2="Sana";capital3="Kahire";capital4="Bağdat";
            }
            else{
                country1="Syria";country2="Yemen";country3="Egypt";country4="Iraq";
                capital1="Sam";capital2="Sana";capital3="Cairo";capital4="Baghdad";
            }
            List<Integer> num16=new ArrayList<Integer>();
            HashMap<String,String> f13 =new HashMap<String,String>();
            f13.put(country1,capital1);f13.put(country2,capital2);
            f13.put(country3,capital3);f13.put(country4,capital4);
            for(Map.Entry<String, String> entry: f13.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num16.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num16.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==17){
            if(language_deger ==1){
                country1="Andora";country2="Romanya";country3="Venezuela";country4="Ekvador";
                capital1="Andorra la Vella";capital2="Bükreş";capital3="Karakas";capital4="Kito";
            }
            else{
                country1="Andorra";country2="Romania";country3="Venezuela";country4="Ecuador";
                capital1="Andorra la Vella";capital2="Bucharest";capital3="Karakas";capital4="Kito";
            }
            List<Integer> num17=new ArrayList<Integer>();
            HashMap<String,String> f14 =new HashMap<String,String>();
            f14.put(country1,capital1);f14.put(country2,capital2);
            f14.put(country3,capital3);f14.put(country4,capital4);
            for(Map.Entry<String, String> entry: f14.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num17.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num17.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==18){
            if(language_deger ==1){
                country1="Yunanistan";country2="Gürcistan";country3="Ermenistan";country4="Vatikan";
                capital1="Atina";capital2="Tiflis";capital3="Yerevan";capital4="Vatikan";
            }
            else{
                country1="Greece";country2="Georgia";country3="Armenia";country4="Vatican";
                capital1="Atina";capital2="Tbilisi";capital3="Yerevan";capital4="Vatican";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==19){
            if(language_deger ==1){
                country1="Kuzey Kıbrıs Türk Cumhuriyeti";country2="İsrail";country3="Man Adası";country4="Cebelitarık";
                capital1="Lefkoşa";capital2="Tel Aviv";capital3="Douglas";capital4="Gibraltar";
            }
            else{
                country1="Turkish Republic of Northern Cyprus";country2="Israel";country3="Isle of Man";country4="Gibraltar";
                capital1="Lefkoşa";capital2="Tel Aviv";capital3="Douglas";capital4="Gibraltar";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==20){
            if(language_deger ==1){
                country1="Ukrayna";country2="Belarus";country3="Litvanya";country4="Estonya";
                capital1="Kiev";capital2="Minsk";capital3="Vilnius";capital4="Tallin";
            }
            else{
                country1="Ukraine";country2="Belarus";country3="Lithuania";country4="Estonia";
                capital1="Kiev";capital2="Minsk";capital3="Vilnius";capital4="Tallin";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==21){
            if(language_deger ==1){
                country1="Madagaskar";country2="Benin";country3="Birleşik Arap Emirlikleri";country4="Ürdün";
                capital1="Antananarivo";capital2="Porto-Novo";capital3="Abu Dabi";capital4="Amman";
            }
            else{
                country1="Madagascar";country2="Benin";country3="United Arab Emirates";country4="Jordan";
                capital1="Antananarivo";capital2="Porto-Novo";capital3="Abu Dhabi";capital4="Amman";
            }
            List<Integer> num21=new ArrayList<Integer>();
            HashMap<String,String> f21 =new HashMap<String,String>();
            f21.put(country1,capital1);f21.put(country2,capital2);
            f21.put(country3,capital3);f21.put(country4,capital4);
            for(Map.Entry<String, String> entry: f21.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num21.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num21.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==22){
            if(language_deger ==1){
                country1="Lübnan";country2="Kiribati";country3="Karadağ";country4="Kırgızistan";
                capital1="Beyrut";capital2="Tarawa";capital3="Podgoritsa";capital4="Bişkek";
            }
            else{
                country1="Lebanon";country2="Kiribati";country3="Montenegro";country4="Kyrgyzstan";
                capital1="Beirut";capital2="Tarawa";capital3="Podgoritsa";capital4="Biškek";
            }
            List<Integer> num22=new ArrayList<Integer>();
            HashMap<String,String> f22 =new HashMap<String,String>();
            f22.put(country1,capital1);f22.put(country2,capital2);
            f22.put(country3,capital3);f22.put(country4,capital4);
            for(Map.Entry<String, String> entry: f22.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num22.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num22.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key); }}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==23){
            if(language_deger ==1){
                country1="Fas";country2="Türkiye";country3="Tunus";country4="Moğolistan";
                capital1="Rabat";capital2="Ankara";capital3="Tunus";capital4="Ulanbator";
            }
            else{
                country1="Morocco";country2="Turkey";country3="Tunisia";country4="Mongolia";
                capital1="Rabat";capital2="Ankara";capital3="Tunisia";capital4="Ulanbator";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==24){
            if(language_deger ==1){
                country1="Katar";country2="Bahreyn";country3="Nepal";country4="Senegal";
                capital1="Doha";capital2="Manama";capital3="Katmandu";capital4="Dakar";
            }
            else{
                country1="Qatar";country2="Bahrain";country3="Nepal";country4="Senegal";
                capital1="Doha";capital2="Manama";capital3="Katmandu";capital4="Dakar";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==25){
            if(language_deger ==1){
                country1="Güney Afrika";country2="Tanzanya";country3="Filipinler";country4="Doğu Timor";
                capital1="Cape Town";capital2="Dodoma";capital3="Manila";capital4="Dili";
            }
            else{
                country1="South Africa";country2="Tanzania";country3="Philippines";country4="East Timor";
                capital1="Cape Town";capital2="Dodoma";capital3="Manila";capital4="Dili";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==26){
            if(language_deger ==1){
                country1="Papua Yeni Gine";country2="Angola";country3="Uganda";country4="Libya";
                capital1="Port Moresby";capital2="Luanda";capital3="Kampala";capital4="Trablus";
            }
            else{
                country1="Papua New Guinea";country2="Angola";country3="Uganda";country4="Libya";
                capital1="Port Moresby";capital2="Luanda";capital3="Kampala";capital4="Tripoli";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==27){
            if(language_deger ==1){
                country1="Porto Riko";country2="Küba";country3="Malezya";country4="Kosta Rika";
                capital1="San Juan";capital2="Havana";capital3="Kuala Lumpur";capital4="San Hose";
            }
            else{
                country1="Puerto Rico";country2="Cuba";country3="Malaysia";country4="Costa Rica";
                capital1="San Juan";capital2="Havana";capital3="Kuala Lumpur";capital4="San Hose";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==28){
            if(language_deger ==1){
                country1="Jamaika";country2="Nijerya";country3="Bangladeş";country4="Myanmar";
                capital1="Kingston";capital2="Abuja";capital3="Dakka";capital4="Nepido";
            }
            else{
                country1="Jamaica";country2="Nigeria";country3="Bangladesh";country4="Myanmar";
                capital1="Kingston";capital2="Abuja";capital3="Dakka";capital4="Nepido";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==29){
            if(language_deger ==1){
                country1="Bolivya";country2="Zambiya";country3="Etiyopya";country4="Gabon";
                capital1="Sucre";capital2="Lusaka";capital3="Addis Ababa";capital4="Librevil";
            }
            else{
                country1="Bolivia";country2="Zambia";country3="Ethiopia";country4="Gabon";
                capital1="Sucre";capital2="Lusaka";capital3="Addis Ababa";capital4="Librevil";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==30){
            if(language_deger ==1){
                country1="Kamerun";country2="Benin";country3="Etiyopya";country4="Kenya";
                capital1="Yaunde";capital2="Porto-Novo";capital3="Addis Ababa";capital4="Nairobi";
            }
            else{
                country1="Cameroon";country2="Benin";country3="Ethiopia";country4="Kenya";
                capital1="Yaunde";capital2="Porto-Novo";capital3="Addis Ababa";capital4="Nairobi";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
        }
        else if(h==31){
            if(language_deger ==1){
                country1="Mali";country2="Gine";country3="Çad";country4="Fildişi Sahili";
                capital1="Bamako";capital2="Konakri";capital3="Encemine";capital4="Yamusukro";
            }
            else{
                country1="Mali";country2="Guinea";country3="Chad";country4="Ivory Coast";
                capital1="Bamako";capital2="Konakri";capital3="Encemine";capital4="Yamusukro";
            }
            List<Integer> num18=new ArrayList<Integer>();
            HashMap<String,String> f18 =new HashMap<String,String>();
            f18.put(country1,capital1);f18.put(country2,capital2);
            f18.put(country3,capital3);f18.put(country4,capital4);
            for(Map.Entry<String, String> entry: f18.entrySet()){
                String key = entry.getKey();
                String value=entry.getValue();
                int c=0;
                c=rnd.nextInt(4-0) + 0;
                while(num18.contains(c)){ c=rnd.nextInt(4-0) + 0;}
                num18.add(c);
                if(!key.contains(country) ){
                    if(x<3){
                        if (c == 0) {
                            op_1.setText(value);op_1.setClickable(true);isim1.setText(key);
                        } else if (c == 1) {
                            op_2.setText(value);op_2.setClickable(true);isim2.setText(key);
                        } else if (c == 2) {
                            op_3.setText(value);op_3.setClickable(true);isim3.setText(key);
                        } else if (c == 3) {
                            op_4.setText(value);op_4.setClickable(true);isim4.setText(key);
                        }}}
                else{
                    if(c==0){
                        op_1.setText(value);
                        d_flag=key;
                        btn_num=1;op_1.setClickable(true);
                    }
                    else if(c==1){
                        op_2.setText(value);
                        d_flag=key;
                        btn_num=2;op_2.setClickable(true);
                    }
                    else if(c==2){
                        op_3.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=3;op_3.setClickable(true);
                    }
                    else if(c==3){
                        op_4.setText(value);
                        //dogru=key;
                        d_flag=key;
                        btn_num=4;op_4.setClickable(true);}}}
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
        return super.onKeyDown(keyCode, event);}
}

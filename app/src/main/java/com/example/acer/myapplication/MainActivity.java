package com.example.acer.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.acer.myapplication.Adapters.newsAdapter;
import com.example.acer.myapplication.Models.NewsListItem;
import com.example.acer.myapplication.Models.Response;
import com.example.acer.myapplication.RestApi.ManagerAll;
import com.onesignal.OneSignal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<NewsListItem> list;
    newsAdapter adp;
    Button btn;
    Button btnn;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        init();
        request();
        btnaboutus();
        btnnewslist();
        checkFirstRun();
    }
    public void init(){
        btn=findViewById(R.id.aboutus);
        listView=findViewById(R.id.list_item);
        btnn=findViewById(R.id.btnnews);
    }
    public void request(){
        Call<Response> service= ManagerAll.getInstance().responseItem();
        service.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful()){
                    //bütün verileri getiriyor.
                    //response.body().toString() : reponse ve error değerleri ile beraber listeyi getiriyor.
                    Log.i("cevap",response.body().getResponse().getNewsList().toString());
                    list=response.body().getResponse().getNewsList();
                    adp=new newsAdapter(list,getApplicationContext(),MainActivity.this);
                    listView.setAdapter(adp);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
    public void btnaboutus(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(gecisYap);
            }
        });
    }
    public void btnnewslist(){
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap=new Intent(MainActivity.this,MainActivity.class);
                startActivity(gecisYap);
            }
        });
    }
    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun){
            // Place your dialog code here to display the dialog
            //Toast.makeText(MainActivity.this, "Hoşgeldiniz", Toast.LENGTH_SHORT).show();
            progress=new ProgressDialog(this);
            progress.setTitle("VVV NEWS");
            progress.setMessage("Welcome");
            progress.setCancelable(false);
            progress.show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(5000);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    progress.cancel();
                }
            }).start();
            //new AlertDialog.Builder(this).setTitle("First Run").setMessage("This only pops up once").setNeutralButton("OK", null).show();
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
    }

}

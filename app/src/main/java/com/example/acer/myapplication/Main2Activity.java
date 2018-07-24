package com.example.acer.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.myapplication.Models.News;
import com.example.acer.myapplication.Models.Post;
import com.example.acer.myapplication.Models.Response;
import com.example.acer.myapplication.RestApi.ManagerAll;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;

public class Main2Activity extends AppCompatActivity {

    String ıd;
    TextView idt,titlet,subtitlet,writert,descriptiont;
    ImageView imaget;
    News list;
    Button btn;
    Button btnnewslists;
    Button btnnewsreturn;
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        takeparameter();
        request();
        responsewebservice();
        btnaboutus();
        btnlist();
        btnnewsback();
    }



    public void init(){
        btn=findViewById(R.id.aboutusnew);
        idt=findViewById(R.id.newid);
        titlet=findViewById(R.id.newtitle);
        subtitlet=findViewById(R.id.newsubtitle);
        writert=findViewById(R.id.newwriter);
        descriptiont=findViewById(R.id.newdescription);
        imaget=findViewById(R.id.newimage);
        btnnewslists=findViewById(R.id.btnnews2);
        btnnewsreturn=findViewById(R.id.btnnews1);
    }
    public void takeparameter(){
        Bundle bundle=getIntent().getExtras();
        ıd=bundle.getString("id");
    }
    public void setlistitem(News list){
        //Integer index=Integer.parseInt(ıd);
        //index=index-1;
        idt.setText(""+list.getId());
        titlet.setText(""+list.getTitle());
        subtitlet.setText(""+list.getSubTitle());
        writert.setText(""+list.getWriter());
        descriptiont.setText(""+list.getDescription());
        Picasso.get().load(""+list.getImage()).into(imaget);
    }
    public void request() {
        Call<Response> call = ManagerAll.getInstance().newsResponse(ıd);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    list = response.body().getResponse().getNews();
                    Log.i("cevapp", response.body().getResponse().toString());
                    setlistitem(list);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
    public void responsewebservice(){
        Call<Post> call= ManagerAll.getInstance().readResponse(ıd);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, retrofit2.Response<Post> response) {
                if(response.isSuccessful()){
                    post=response.body();
                    Log.i("hazır",post.toString());
                    //web servisin okundu bilgisini getiriyor.
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
    public void btnaboutus(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(gecisYap);
            }
        });
    }
    public void btnlist(){
        btnnewslists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(gecisYap);
            }
        });
    }
    public void btnnewsback(){
        btnnewsreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(gecisYap);
            }
        });
    }

}

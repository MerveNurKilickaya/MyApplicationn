package com.example.acer.myapplication.RestApi;

import com.example.acer.myapplication.Models.Post;
import com.example.acer.myapplication.Models.Response;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourgetInstance=new ManagerAll();
    public static synchronized ManagerAll getInstance(){
        return ourgetInstance;
    }
    public Call<Response> responseItem(){
        Call<Response> x=getRestApiClient().newsItem();
        return x;
    }
    public Call<Response> newsResponse(String id){
        Call<Response> x=getRestApiClient().newsCall(id);
        return x;
    }
    public Call<Post> readResponse(String id){
        Call<Post> x=getRestApiClient().postJson(id);
        return x;
    }
}

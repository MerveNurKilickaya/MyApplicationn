package com.example.acer.myapplication.RestApi;

import com.example.acer.myapplication.Models.Post;
import com.example.acer.myapplication.Models.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {
    @GET("/getAllNews")
    Call<Response> newsItem();
    @GET("/getNewsDetail")
    Call<Response> newsCall(@Query("id") String id);
    @POST("/saveReadDetail")
    Call<Post> postJson(@Body String id);
}

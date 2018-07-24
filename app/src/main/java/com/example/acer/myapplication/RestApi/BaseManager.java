package com.example.acer.myapplication.RestApi;

public class BaseManager {
    protected RestApi getRestApiClient(){
        RestApiClient restApiClient=new RestApiClient(BaseUrl.url);
        return restApiClient.getRestApi();
    }
}

package com.example.acer.myapplication.Models;

import java.util.List;

public class Response {
    private Response response;
    private boolean error;
    private List<NewsListItem> newsList;
    private News news;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public void setResponse(Response response){
        this.response = response;
    }

    public Response getResponse(){
        return response;
    }

    public void setError(boolean error){
        this.error = error;
    }

    public boolean isError(){
        return error;
    }

    public void setNewsList(List<NewsListItem> newsList){
        this.newsList = newsList;
    }

    public List<NewsListItem> getNewsList(){
        return newsList;
    }

    @Override
    public String toString() {
        return "Response{" +
                "response=" + response +
                ", error=" + error +
                ", newsList=" + newsList +
                ", news=" + news +
                '}';
    }
}

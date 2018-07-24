package com.example.acer.myapplication.Models;

public class NewsListItem {
    private String image;
    private String subTitle;
    private int id;
    private String writer;
    private String title;

    public void setImage(String image){
        this.image = image;
    }

    public String getImage(){
        return image;
    }

    public void setSubTitle(String subTitle){
        this.subTitle = subTitle;
    }

    public String getSubTitle(){
        return subTitle;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setWriter(String writer){
        this.writer = writer;
    }

    public String getWriter(){
        return writer;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString(){
        return
                "NewsListItem{" +
                        "image = '" + image + '\'' +
                        ",sub-title = '" + subTitle + '\'' +
                        ",id = '" + id + '\'' +
                        ",writer = '" + writer + '\'' +
                        ",title = '" + title + '\'' +
                        "}";
    }
}

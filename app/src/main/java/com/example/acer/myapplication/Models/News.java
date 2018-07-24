package com.example.acer.myapplication.Models;

public class News {
    private String image;
    private String subTitle;
    private String description;
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

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
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
                "News{" +
                        "image = '" + image + '\'' +
                        ",sub-title = '" + subTitle + '\'' +
                        ",description = '" + description + '\'' +
                        ",id = '" + id + '\'' +
                        ",writer = '" + writer + '\'' +
                        ",title = '" + title + '\'' +
                        "}";
    }
}

package com.example.acer.myapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("response")
    @Expose
    private String response;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Post{" +
                "error=" + error +
                ", response='" + response + '\'' +
                '}';
    }
}

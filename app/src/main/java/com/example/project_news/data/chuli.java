package com.example.project_news.data;

import android.util.Log;

import com.example.project_news.HtmlService;
import com.google.gson.Gson;

public class chuli {
    public String url;
    String json;
    Gson gson;
     public chuli(String url)
    {
        this.url = url;

    }
    public Toutiao get() {
        HtmlService h1=new HtmlService();
        try {
            json=h1.run(url);
            Log.d("load", "json:"+json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        gson=new Gson();
        Toutiao toutiao = gson.fromJson(json, Toutiao.class);
        return toutiao;
    }
}

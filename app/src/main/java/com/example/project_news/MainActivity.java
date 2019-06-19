package com.example.project_news;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project_news.data.Toutiao;
import com.example.project_news.data.Data;
import com.example.project_news.data.Result;
import com.example.project_news.data.chuli;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "load";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //接口用法：load(getApplicationContext());onPostExecute（）里对数据进行处理
        load(getApplicationContext());
        TextView tv07 = findViewById(R.id.tv07);

    }

    private void load(final Context ctx) {
        AsyncTask task = new AsyncTask<Object, Integer, Toutiao>() {

            @Override
            protected Toutiao doInBackground(Object... strings) {
                String url = "http://v.juhe.cn/toutiao/index?type=&key=75756ba35bafd5604b356192a213dc9d";
                Toutiao c = new chuli(url).get();
                return c;

            }

            @Override
            protected void onPostExecute(final Toutiao toutiao) {
//               对数据进行处理
                setting(toutiao,1);
            }
        };
        task.execute();
    }

    public void setting(final Toutiao toutiao,int i) {
        List<Data> da = toutiao.getResult().getData();
        TextView tvm = findViewById(R.id.tvmain);
        TextView tv07 = findViewById(R.id.tv07);
        TextView tv08 = findViewById(R.id.tv08);
        TextView tv09 = findViewById(R.id.tv09);

        ImageView ig1 = findViewById(R.id.vimg3);
        ImageView ig2 = findViewById(R.id.vimg4);
        ImageView ig3 = findViewById(R.id.vimg5);
        ImageView iv = findViewById(R.id.iv);

        tvm.setText(da.get(i).getTitle());
        tv07.setText(da.get(i+1).getTitle());
        tv08.setText(da.get(i+2).getTitle());
        tv09.setText(da.get(i+3).getTitle());

        loadpic(da.get(i).getThumbnail_pic_s(), iv);
        loadpic(da.get(i+1).getThumbnail_pic_s(), ig1);
        loadpic(da.get(i+2).getThumbnail_pic_s(), ig2);
        loadpic(da.get(i+3).getThumbnail_pic_s(), ig3);
        dianji(tv07, da, i+1);
        dianji(tv08, da, i+2);
        dianji(tv09, da, i+3);
        dianji(iv, da, i+4);
    }

    public void loadpic(String url, ImageView ig) {
        Glide.with(getApplicationContext())
                .load(url)
                .into(ig);
    }

    public void dianji(ImageView imageView, final List<Data> dt, final int i) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,Web.class);
                it.putExtra("URL",dt.get(i).getUrl());
                startActivity(it);
            }
        });
    }

    public void dianji(TextView textView, final List<Data> dt, final int i) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,Web.class);
                it.putExtra("URL",dt.get(i).getUrl());
                startActivity(it);
            }
        });
    }
}
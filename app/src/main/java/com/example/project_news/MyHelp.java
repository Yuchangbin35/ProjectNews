package com.example.project_news;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelp extends SQLiteOpenHelper {

    public MyHelp(Context context, String name) {
        super(context, name,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table AdvisoryEntry(cid INTEGER PRIMARY KEY AUTOINCREMENT,title String,sequnce text)");
        //咨询条目表
        db.execSQL("create Table CommentsAndResponses(cid INTEGER PRIMARY KEY AUTOINCREMENT,nid INTERGER" +
                ",pitime String,rear String,content String,supportcount String,opposecount text)");
        //评论和回复表
        db.execSQL("create Table DetailsOfInformation(nid INTEGER PRIMARY KEY AUTOINCREMENT,cid INTERGER," +
                "title String,body String,source String,pitime String,imgsrc text,summary String,sequnce INTEGER)");
        //资讯详情表
        db.execSQL("create Table USER(uid INTEGER PRIMARY KEY AUTOINCREMENT,name String,password String)");
        //用户表
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}


package com.example.project_news;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TEST {

    public MyHelp helper;
    TEST(MyHelp helper)
    {
        this.helper=helper;
    }

    public void  insert(String first,String two)
    {
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",first);
        values.put("price",two);
        long id=db.insert("information",null,values);
        db.close();
    }
    public int update(String name,String price)
    {
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("price",price);
        int num=db.update("information",values,"name=?",new String[]{name});
        db.close();
        return num;
    }
    public int delete(long id)
    {
        SQLiteDatabase db=helper.getWritableDatabase();
        int num=db.delete("information","_id=?",new String[]{id+""});
        db.close();
        return num;
    }
    public boolean find(long id)
    {
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor=db.query("information",null,"_id=?",new String[]{id+""},null,null
                ,null);
        boolean result=cursor.moveToNext();
        db.close();
        return result;
    }
    public void  exec(String SQL)
    {
        SQLiteDatabase db=helper.getWritableDatabase();
        db.execSQL(SQL);
        db.close();
    }
}

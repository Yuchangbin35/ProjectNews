package com.example.project_news;
import android.util.Log;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HtmlService {
    private static final String TAG = "load";
    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        String r = null;
        try (Response response = client.newCall(request).execute()) {
            Log.d(TAG, "fangwen"+ response.code());
            r= response.body().string();
        } catch (Exception e) {
            Log.d(TAG, "fangwen: ", e);
        }
        return r;
    }
}
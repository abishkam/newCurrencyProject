package com.example.currencyproject.api;

import java.io.*;
import okhttp3.*;

public class ApiPatterns {

    public static Response allQueries(String query) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(query)
                .addHeader("apikey", "5nYNCaY75mdDo9967eVi2rv17GppBOls")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }


}

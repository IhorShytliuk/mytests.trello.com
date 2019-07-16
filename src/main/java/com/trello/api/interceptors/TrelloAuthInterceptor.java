package com.trello.api.interceptors;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TrelloAuthInterceptor implements Interceptor {

    private static final String KEY = "c4102127db63f72679639fc62ef6b65b";
    private static final String TOKEN = "ce193a784402dc4e0134ea78eeed023e46fbbcb9755400a85107fdcac2191580";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("key", KEY)
                .addQueryParameter("token", TOKEN)
                .build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();

//        System.out.println("Cookies: " + request.headers("Set-Cookie"));
        System.out.println("Url: " + request.url());
        System.out.println("Body: " + request.body());

        return chain.proceed(request);
    }
}
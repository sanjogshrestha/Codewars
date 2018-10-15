package com.sanjogstha.codewars.remote;

import com.sanjogstha.codewars.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api ourInstance;
    private static Retrofit retrofit;
    private NetworkApiService apiService;
    private static String API_KEY = "as5-tkZsC_diXqAV9wda";

    private Api() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG
                ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient.Builder okHttpClient=  new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES);
        okHttpClient.interceptors().add(loggingInterceptor);

        okHttpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request;
            request = original.newBuilder()
                    .header("Authorization", API_KEY)
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        }).addInterceptor(loggingInterceptor);

        OkHttpClient client = okHttpClient.build();
        Retrofit.Builder adapterBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl(ApiConstant.BASE_URL);
        retrofit = adapterBuilder.build();
        this.apiService = retrofit.create(NetworkApiService.class);
    }

    public static Retrofit retrofit() {
        if (retrofit == null) {
            ourInstance = new Api();
            return retrofit;
        }
        return retrofit;
    }

    public static NetworkApiService getService() {
        ourInstance = new Api();
        return ourInstance.apiService;
    }
}

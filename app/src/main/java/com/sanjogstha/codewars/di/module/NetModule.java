package com.sanjogstha.codewars.di.module;

import com.sanjogstha.codewars.BuildConfig;
import com.sanjogstha.codewars.remote.Api;
import com.sanjogstha.codewars.remote.NetworkApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Module
public class NetModule {
    @Provides
    OkHttpClient provideHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG
                ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.MINUTES)
                .readTimeout(3, TimeUnit.MINUTES)
                .writeTimeout(3, TimeUnit.MINUTES);

        okHttpClient.interceptors().add(logging);
        return okHttpClient.build();
    }

    @Provides
    Retrofit getRetrofit() {
        return Api.retrofit();
    }

    @Provides
    NetworkApiService providesNetworkService(Retrofit retrofit) {
        return retrofit.create(NetworkApiService.class);
    }
}

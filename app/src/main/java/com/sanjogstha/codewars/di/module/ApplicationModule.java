package com.sanjogstha.codewars.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

/*
 * Created by sanjogstha on 2/13/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }
}

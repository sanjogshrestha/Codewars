package com.sanjogstha.codewars;

import android.app.Application;

import com.sanjogstha.codewars.database.CodewarsDatabase;
import com.sanjogstha.codewars.di.ApplicationComponent;
import com.sanjogstha.codewars.di.DaggerApplicationComponent;
import com.sanjogstha.codewars.di.module.ApplicationModule;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class CodewarsApp extends Application {
    private CodewarsDatabase database;
    private ApplicationComponent mApplicationComponent;
    private ApplicationModule mModule;
    private static CodewarsApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(getApplicationModule()).build();

        mApplicationComponent.inject(this);
        mInstance = this;
        database = CodewarsDatabase.getInstance(this);
    }

    public static CodewarsApp getmInstance() {
        return mInstance;
    }

    public ApplicationModule getApplicationModule() {
        if (mModule == null) {
            mModule = new ApplicationModule(this);
        }
        return mModule;
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public CodewarsDatabase getCodewarsDatabase() {
        return database;
    }
}

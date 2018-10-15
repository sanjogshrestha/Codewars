package com.sanjogstha.codewars.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.sanjogstha.codewars.di.ActivityContext;
import com.sanjogstha.codewars.utils.AppSchedulerProvider;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/*
 * Created by sanjogstha on 2/13/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Singleton
@Module(includes = ApplicationModule.class)
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() { return mActivity; }

    @Provides
    @ActivityContext
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @ActivityContext
    LinearLayoutManager provideLinearLayoutManager(Activity activity) {
        return new LinearLayoutManager(activity);
    }
}

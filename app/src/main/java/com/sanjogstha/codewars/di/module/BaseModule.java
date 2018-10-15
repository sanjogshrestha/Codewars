package com.sanjogstha.codewars.di.module;

import com.sanjogstha.codewars.di.PerActivity;
import com.sanjogstha.codewars.ui.base.BasePresenter;
import com.sanjogstha.codewars.ui.base.MvpPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sanjogstha on 8/1/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Module(includes = ActivityModule.class)
public class BaseModule {
    @Provides
    @PerActivity
    MvpPresenter provideMvpPresenter(BasePresenter presenter) {
        return presenter;
    }
}

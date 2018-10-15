package com.sanjogstha.codewars.di;

import com.sanjogstha.codewars.CodewarsApp;
import com.sanjogstha.codewars.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(CodewarsApp app);
}

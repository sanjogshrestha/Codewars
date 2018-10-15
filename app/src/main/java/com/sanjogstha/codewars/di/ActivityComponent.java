package com.sanjogstha.codewars.di;

import com.sanjogstha.codewars.di.module.ActivityModule;
import com.sanjogstha.codewars.di.module.BaseModule;
import com.sanjogstha.codewars.di.module.ChallengesModule;
import com.sanjogstha.codewars.di.module.DetailModule;
import com.sanjogstha.codewars.di.module.UserModule;
import com.sanjogstha.codewars.ui.challenge.AuthoredFragment;
import com.sanjogstha.codewars.ui.challenge.ChallengeActivity;
import com.sanjogstha.codewars.ui.challenge.CompletedFragment;
import com.sanjogstha.codewars.ui.detail.DetailActivity;
import com.sanjogstha.codewars.ui.user.UserActivity;

import dagger.Component;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {
        ActivityModule.class,
        BaseModule.class,
        UserModule.class,
        ChallengesModule.class,
        DetailModule.class})
public interface ActivityComponent {
    void inject(UserActivity activity);
    void inject(ChallengeActivity challengeActivity);
    void inject(DetailActivity detailActivity);
    void inject(CompletedFragment fragment);
    void inject(AuthoredFragment fragment);
}


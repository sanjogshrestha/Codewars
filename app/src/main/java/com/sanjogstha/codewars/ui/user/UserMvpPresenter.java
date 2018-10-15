package com.sanjogstha.codewars.ui.user;

import com.sanjogstha.codewars.di.PerActivity;
import com.sanjogstha.codewars.ui.base.MvpPresenter;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
@PerActivity
public interface UserMvpPresenter extends MvpPresenter<UserView> {
    void getUser(String username, UserActivity userActivity);
    void getRecentUser();
}

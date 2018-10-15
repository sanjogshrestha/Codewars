package com.sanjogstha.codewars.ui.challenge;

import com.sanjogstha.codewars.di.PerActivity;
import com.sanjogstha.codewars.ui.base.MvpPresenter;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
@PerActivity
public interface ChallengeMvpPresenter extends MvpPresenter<ChallengeView> {
    void fetchAuthoredChallenges(String username);
    void fetchCompletedChallenges(String username);
}

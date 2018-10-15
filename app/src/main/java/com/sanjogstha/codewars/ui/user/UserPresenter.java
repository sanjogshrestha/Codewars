package com.sanjogstha.codewars.ui.user;

import com.sanjogstha.codewars.di.PerActivity;
import com.sanjogstha.codewars.domain.interactor.user.UserDBUseCase;
import com.sanjogstha.codewars.domain.interactor.user.UserOfflineUseCase;
import com.sanjogstha.codewars.domain.interactor.user.UserUseCase;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;
import com.sanjogstha.codewars.ui.base.BasePresenter;
import com.sanjogstha.codewars.utils.NetworkUtils;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
@PerActivity
public class UserPresenter extends BasePresenter<UserView> implements UserMvpPresenter{
    @Inject UserUseCase userUseCase;
    @Inject UserOfflineUseCase offlineUseCase;
    @Inject UserDBUseCase userDBUseCase;
    @Inject
    public UserPresenter(SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(UserView mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void getUser(String username, UserActivity userActivity) {
        if(NetworkUtils.isNetworkConnected(userActivity))
            userUseCase.execute(performFetch(), username);
        else
            offlineUseCase.execute(performFetch(), username);
    }

    @Override
    public void getRecentUser() {
        userDBUseCase.execute(performRecentFetch(), null);
    }

    private DisposableObserver<List<UserResponseDTO>> performRecentFetch() {
        return new DisposableObserver<List<UserResponseDTO>>() {
            @Override
            public void onNext(List<UserResponseDTO> userResponseDTO) {
                if(getMvpView() != null)
                    getMvpView().onFetchSuccess(userResponseDTO);
            }

            @Override
            public void onError(Throwable e) {
                if(getMvpView() != null)
                    getMvpView().onFetchFail(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {}
        };
    }

    private DisposableObserver<UserResponseDTO> performFetch() {
        return new DisposableObserver<UserResponseDTO>() {
            @Override
            public void onNext(UserResponseDTO userResponseDTO) {
                if(getMvpView() != null)
                    getMvpView().onFetchSuccess(userResponseDTO);
            }

            @Override
            public void onError(Throwable e) {
                if(getMvpView() != null)
                    getMvpView().onFetchFail(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {}
        };
    }
}

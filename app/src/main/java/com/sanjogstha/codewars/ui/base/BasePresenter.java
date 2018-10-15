package com.sanjogstha.codewars.ui.base;

/*
 * Created by sanjogstha on 2/13/18.
 * sanjogshrestha.nepal@gmail.com
 */

import com.sanjogstha.codewars.utils.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private static final String TAG = "BasePresenter";
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;
    private V mMvpView;
    protected final Void NO_INPUT = null;

    @Inject
    public BasePresenter(SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }
}

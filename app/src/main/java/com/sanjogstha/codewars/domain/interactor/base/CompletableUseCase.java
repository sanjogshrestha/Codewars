package com.sanjogstha.codewars.domain.interactor.base;

import com.sanjogstha.codewars.ui.base.MvpPresenter;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;

/**
 * Represents a {@link Completable} action called by the {@link MvpPresenter}
 *
 * @param <Params> any input needed to execute the stream
 */
public abstract class CompletableUseCase<Params> extends UseCase<Completable, DisposableCompletableObserver, Params>{

    public CompletableUseCase(SchedulerProvider schedulerProvider,
                              CompositeDisposable disposables) {
        super(schedulerProvider, disposables);
    }

    @Override
    public void execute(DisposableCompletableObserver disposableCompletableObserver, Params params) {
        Completable completable = this.buildUseCase(params)
                .subscribeOn(subscribeScheduler())
                .observeOn(observeScheduler());
        addDisposable(completable.subscribeWith(disposableCompletableObserver));
    }
}

package com.sanjogstha.codewars.domain.interactor.base;

import com.sanjogstha.codewars.ui.base.MvpPresenter;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Represents a {@link Single} action called by the {@link MvpPresenter}
 *
 * @param <T>      the type of the stream
 * @param <Params> any input needed to execute the stream
 */
public abstract class SingleUseCase<T, Params> extends UseCase<Single<T>, DisposableSingleObserver<T>, Params> {

    public SingleUseCase(SchedulerProvider schedulerProvider,
                         CompositeDisposable disposables) {
        super(schedulerProvider, disposables);
    }

    @Override
    public void execute(DisposableSingleObserver<T> observer, Params params) {
        Single<T> single = this.buildUseCase(params)
                .subscribeOn(subscribeScheduler())
                .observeOn(observeScheduler());
        addDisposable(single.subscribeWith(observer));
    }
}

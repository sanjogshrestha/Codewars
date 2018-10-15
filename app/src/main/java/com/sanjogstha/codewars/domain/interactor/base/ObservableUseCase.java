package com.sanjogstha.codewars.domain.interactor.base;

import com.sanjogstha.codewars.ui.base.MvpPresenter;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Represents a {@link Observable} action called by the {@link MvpPresenter}
 *
 * @param <T>      the type of the stream
 * @param <Params> any input needed to execute the stream
 */
public abstract class ObservableUseCase<T, Params> extends UseCase<Observable<T>, DisposableObserver<T>, Params> {

    public ObservableUseCase(SchedulerProvider schedulerProvider,
                             CompositeDisposable disposables) {
        super(schedulerProvider, disposables);
    }

    @Override
    public void execute(DisposableObserver<T> observer, Params params) {
        Observable<T> observable = this.buildUseCase(params)
                .subscribeOn(subscribeScheduler())
                .observeOn(observeScheduler());
        addDisposable(observable.subscribeWith(observer));
    }

}

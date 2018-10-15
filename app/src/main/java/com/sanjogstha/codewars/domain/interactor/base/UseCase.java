package com.sanjogstha.codewars.domain.interactor.base;

import com.sanjogstha.codewars.domain.base.Repository;
import com.sanjogstha.codewars.ui.base.MvpPresenter;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Consists of a <b>particular use-case</b> scenario for the application.
 * <p>
 * A use-case only performs a function {@link #buildUseCase(Object)}.
 * It can access multiple {@link Repository}(s) to fulfill the function.
 * <p>
 * UseCase(s) will be accessed from the {@link MvpPresenter} to perform
 * specific tasks. Hence, a presenter be composed of multiple use-cases
 *
 * @param <Stream>   the return type for {@link #buildUseCase(Object)}
 * @param <Observer> the stream type which can be {@link Completable}, {@link Observable},
 *                   or {@link Single}
 * @param <Params>   any input required for {@link #buildUseCase(Object)}
 * @see CompletableUseCase
 * @see SingleUseCase
 * @see ObservableUseCase
 */
public abstract class UseCase<Stream, Observer, Params> {

    protected final SchedulerProvider schedulerProvider;
    protected final CompositeDisposable disposables;
    protected final Void FINISH_OPERATION = null;

    UseCase(SchedulerProvider schedulerProvider, CompositeDisposable disposables) {
        this.schedulerProvider = schedulerProvider;
        this.disposables = disposables;
    }

    /**
     * Logic to build required use-case
     *
     * @param params input required to build the use-case
     * @return stream of the use-case
     */
    abstract public Stream buildUseCase(Params params);

    /**
     * Define your stream subscription scheduler ~ defaults to {@link SchedulerProvider#io()}
     * Override this method to add custom implementation
     *
     * @return required {@link Scheduler} for stream subscription
     */
    protected Scheduler subscribeScheduler() {
        return schedulerProvider.io();
    }


    /**
     * Define your stream consumption scheduler ~ defaults to {@link SchedulerProvider#ui()}
     * Override this method to add custom implementation
     *
     * @return required {@link Disposable} for stream observation
     */
    protected Scheduler observeScheduler() {
        return schedulerProvider.ui();
    }

    /**
     * Called by the {@link MvpPresenter} to execute the stream
     * as defined in {@link #buildUseCase(Object)}
     *
     * @param observer the {@link Disposable} for stream consumption
     * @param params   the input that gets passed onto {@link #buildUseCase(Object)}
     */
    public abstract void execute(Observer observer, Params params);

    void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    /**
     * Called by the {@link MvpPresenter} to dispose the stream
     */
    public void disposeAll() {
        disposables.dispose();
    }
}

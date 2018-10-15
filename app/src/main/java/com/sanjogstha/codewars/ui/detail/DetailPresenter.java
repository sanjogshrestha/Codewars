package com.sanjogstha.codewars.ui.detail;

import com.sanjogstha.codewars.di.PerActivity;
import com.sanjogstha.codewars.domain.interactor.detail.DetailOfflineUseCase;
import com.sanjogstha.codewars.domain.interactor.detail.DetailUseCase;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;
import com.sanjogstha.codewars.ui.base.BasePresenter;
import com.sanjogstha.codewars.utils.NetworkUtils;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */

@PerActivity
public class DetailPresenter extends BasePresenter<DetailView> implements DetailMvpPresenter {
    @Inject DetailUseCase detailUseCase;
    @Inject DetailOfflineUseCase detailOfflineUseCase;

    @Inject
    public DetailPresenter(SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(DetailView mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void getDetail(String slug, DetailActivity detailActivity) {
        if(NetworkUtils.isNetworkConnected(detailActivity))
            detailUseCase.execute(fetchDetail(), slug);
        else
            detailOfflineUseCase.execute(fetchDetail(), slug);
    }

    private DisposableObserver<ChallengeDetailDTO> fetchDetail() {
        return new DisposableObserver<ChallengeDetailDTO>() {
            @Override
            public void onNext(ChallengeDetailDTO dto) {
                if(getMvpView() != null)
                    getMvpView().fetchSuccess(dto);
            }

            @Override
            public void onError(Throwable e) {
                if(getMvpView() != null) {
                    if (e.getLocalizedMessage().equalsIgnoreCase("Callable returned null")){
                        getMvpView().fetchFail("Try Again");
                    }
                    else
                        getMvpView().fetchFail(e.getLocalizedMessage());
                }

            }

            @Override
            public void onComplete() {}
        };
    }
}

package com.sanjogstha.codewars.ui.challenge;

import com.sanjogstha.codewars.domain.interactor.challenges.AuthoredChallengeUseCase;
import com.sanjogstha.codewars.domain.interactor.challenges.CompletedChallengeUseCase;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDTO;
import com.sanjogstha.codewars.ui.base.BasePresenter;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class ChallengePresenter extends BasePresenter<ChallengeView> implements ChallengeMvpPresenter {
    @Inject AuthoredChallengeUseCase authoredChallengeUseCase;
    @Inject CompletedChallengeUseCase completedChallengeUseCase;

    @Inject
    public ChallengePresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(schedulerProvider, compositeDisposable);
    }

    @Override
    public void fetchAuthoredChallenges(String username) {
        authoredChallengeUseCase.execute(performAuthoredFetch(), username);
    }

    private DisposableObserver<AuthoredChallengesDTO> performAuthoredFetch() {
        return new DisposableObserver<AuthoredChallengesDTO>() {
            @Override
            public void onNext(AuthoredChallengesDTO authoredChallengesDTO) {
                if(getMvpView() != null)
                    getMvpView().onAuthoredListFetchSuccess(authoredChallengesDTO.getData());
            }

            @Override
            public void onError(Throwable e) {
                if(getMvpView() != null)
                    getMvpView().onAuthorizedFetchFail(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {}
        };
    }

    private DisposableObserver<CompletedChallengeDTO> performCompletedFetch() {
        return new DisposableObserver<CompletedChallengeDTO>() {
            @Override
            public void onNext(CompletedChallengeDTO completedChallengeDTO) {
                if(getMvpView() != null)
                    getMvpView().onCompletedListFetchSuccess(completedChallengeDTO.getData());
            }

            @Override
            public void onError(Throwable e) {
                if(getMvpView() != null)
                    getMvpView().onCompletedFetchFail(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {}
        };
    }
    @Override
    public void fetchCompletedChallenges(String username) {
        completedChallengeUseCase.execute(performCompletedFetch(), username);
    }
}

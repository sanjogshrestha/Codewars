package com.sanjogstha.codewars.domain.interactor.detail;

import com.sanjogstha.codewars.domain.DetailRepository;
import com.sanjogstha.codewars.domain.interactor.base.ObservableUseCase;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class DetailOfflineUseCase extends ObservableUseCase<ChallengeDetailDTO, String> {
    private final DetailRepository repository;

    @Inject
    public DetailOfflineUseCase(SchedulerProvider schedulerProvider,
                                CompositeDisposable disposables,
                                DetailRepository repository) {
        super(schedulerProvider, disposables);
        this.repository = repository;
    }

    @Override
    public Observable<ChallengeDetailDTO> buildUseCase(final String slug) {
        return repository.getDetailChallengesFromFB(slug);
    }
}

package com.sanjogstha.codewars.domain.interactor.challenges;

import com.sanjogstha.codewars.domain.ChallengesRepository;
import com.sanjogstha.codewars.domain.interactor.base.ObservableUseCase;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDTO;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by sanjogstha on 10/12/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class AuthoredChallengeUseCase extends ObservableUseCase<AuthoredChallengesDTO, String> {
    private final ChallengesRepository repository;

    @Inject
    public AuthoredChallengeUseCase(SchedulerProvider schedulerProvider,
                                    CompositeDisposable disposables,
                                    ChallengesRepository repository) {
        super(schedulerProvider, disposables);
        this.repository = repository;
    }

    @Override
    public Observable<AuthoredChallengesDTO> buildUseCase(final String username) {
        return repository.getAuthoredChallenges(username);
    }
}

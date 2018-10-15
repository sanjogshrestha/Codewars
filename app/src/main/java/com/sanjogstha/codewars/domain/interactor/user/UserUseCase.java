package com.sanjogstha.codewars.domain.interactor.user;

import com.sanjogstha.codewars.domain.UserRepository;
import com.sanjogstha.codewars.domain.interactor.base.ObservableUseCase;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;
import com.sanjogstha.codewars.utils.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class UserUseCase extends ObservableUseCase<UserResponseDTO, String> {
    private final UserRepository repository;

    @Inject
    public UserUseCase(SchedulerProvider schedulerProvider,
                                  CompositeDisposable disposables,
                                  UserRepository repository) {
        super(schedulerProvider, disposables);
        this.repository = repository;
    }

    @Override
    public Observable<UserResponseDTO> buildUseCase(final String username) {
        return repository.getUser(username);
    }
}

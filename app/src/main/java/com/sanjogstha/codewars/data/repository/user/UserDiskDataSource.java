package com.sanjogstha.codewars.data.repository.user;

import com.sanjogstha.codewars.disk.UserDisk;
import com.sanjogstha.codewars.domain.source.UserDataSource;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class UserDiskDataSource implements UserDataSource {
    private final UserDisk userDisk;

    @Inject
    public UserDiskDataSource(UserDisk userDisk) {
        this.userDisk = userDisk;
    }

    @Override
    public Observable<UserResponseDTO> getUser(String username) {
        return Observable.fromCallable(() -> userDisk.getUser(username));
    }

    @Override
    public Observable<List<UserResponseDTO>> getUserList() {
        return Observable.fromCallable(() -> userDisk.getUserList());
    }

    @Override
    public Completable saveUser(UserResponseDTO userResponseDTO) {
        return Completable.fromAction(() -> userDisk.saveUser(userResponseDTO));
    }

    @Override
    public int getDataSourceType() {
        return DATA_SOURCE_DISK;
    }
}

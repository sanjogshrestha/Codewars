package com.sanjogstha.codewars.data.repository.user;

import com.sanjogstha.codewars.domain.source.UserDataSource;
import com.sanjogstha.codewars.remote.NetworkService;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class UserNetworkDataSource implements UserDataSource {
    private final NetworkService networkService;

    @Inject
    public UserNetworkDataSource(NetworkService networkService) {
        this.networkService = networkService;
    }

    @Override
    public Observable<UserResponseDTO> getUser(String username) {
        return networkService.getUserInfo(username)
                .map(userResponseDTO -> userResponseDTO);
    }

    @Override
    public Observable<List<UserResponseDTO>> getUserList() {
        return null;
    }

    @Override
    public Completable saveUser(UserResponseDTO userResponseDTO) {
        // no op here just return complete
        return Completable.error(new Exception("No Op"));
    }

    @Override
    public int getDataSourceType() {
        return UserDiskDataSource.DATA_SOURCE_NETWORK;
    }
}

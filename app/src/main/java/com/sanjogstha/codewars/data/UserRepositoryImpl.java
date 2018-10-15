package com.sanjogstha.codewars.data;

import com.sanjogstha.codewars.data.source.user.UserDataSourceFactory;
import com.sanjogstha.codewars.domain.UserRepository;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class UserRepositoryImpl implements UserRepository {
    private final UserDataSourceFactory dataSourceFactory;

    @Inject
    public UserRepositoryImpl(UserDataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    @Override
    public Observable<UserResponseDTO> getUser(String username) {
        /*if(CodewarsApp.getmInstance().getCodewarsDatabase().getUserDao().count() == 0) {
            return dataSourceFactory
                    .getNetworkSource()
                    .getUser(username)
                    .doOnNext(userResponseDTO ->
                            dataSourceFactory
                                    .getDiskSource()
                                    .saveUser(userResponseDTO)
                                    .subscribe())
                    .map(userResponseDTO -> userResponseDTO);
        }*/
        return Observable.concatArray(getUserFromAPI(username), getUserFromDb(username));
    }

    @Override
    public Observable<UserResponseDTO> getUserFromDb(String username) {
        return dataSourceFactory.getDiskSource().getUser(username)
                .map(userResponseDTO -> userResponseDTO);
    }

    @Override
    public Observable<UserResponseDTO> getUserFromAPI(String username) {
        return dataSourceFactory
                .getNetworkSource()
                .getUser(username)
                .doOnNext(userResponseDTO ->
                        dataSourceFactory
                                .getDiskSource()
                                .saveUser(userResponseDTO)
                                .subscribe())
                .map(userResponseDTO -> userResponseDTO);
    }

    @Override
    public Observable<List<UserResponseDTO>> getRecentUser() {
        return dataSourceFactory.getDiskSource().getUserList()
                .map(userResponseDTOList -> userResponseDTOList);
    }
}

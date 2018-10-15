package com.sanjogstha.codewars.domain.source;

import com.sanjogstha.codewars.domain.base.DataSource;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface UserDataSource extends DataSource {
    Observable<UserResponseDTO> getUser(String username);
    Observable<List<UserResponseDTO>> getUserList();
    Completable saveUser(UserResponseDTO userResponseDTO);
}

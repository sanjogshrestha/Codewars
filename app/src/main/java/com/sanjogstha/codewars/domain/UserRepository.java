package com.sanjogstha.codewars.domain;

import com.sanjogstha.codewars.domain.base.Repository;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface UserRepository extends Repository {
    Observable<UserResponseDTO> getUser(String username);
    Observable<UserResponseDTO> getUserFromDb(String username);
    Observable<UserResponseDTO> getUserFromAPI(String username);
    Observable<List<UserResponseDTO>> getRecentUser();
}

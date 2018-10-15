package com.sanjogstha.codewars.ui.user;

import com.sanjogstha.codewars.remote.model.UserResponseDTO;
import com.sanjogstha.codewars.ui.base.MvpView;

import java.util.List;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface UserView extends MvpView {
    void onFetchSuccess(UserResponseDTO userResponseDTO);
    void onFetchSuccess(List<UserResponseDTO> userResponseDTOList);
    void onFetchFail(String msg);
}

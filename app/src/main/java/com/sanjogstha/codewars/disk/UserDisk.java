package com.sanjogstha.codewars.disk;

import com.sanjogstha.codewars.disk.base.StatefulDisk;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;

import java.util.List;

/**
 * Created by sanjogstha on 10/12/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface UserDisk extends StatefulDisk<Integer> {
    UserResponseDTO getUser(String username);
    List<UserResponseDTO> getUserList();
    void saveUser(UserResponseDTO userResponseDTO);
}

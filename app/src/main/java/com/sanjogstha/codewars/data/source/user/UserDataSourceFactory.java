package com.sanjogstha.codewars.data.source.user;

import com.sanjogstha.codewars.data.repository.user.UserDiskDataSource;
import com.sanjogstha.codewars.data.repository.user.UserNetworkDataSource;
import com.sanjogstha.codewars.data.source.DataSourceFactory;
import com.sanjogstha.codewars.disk.UserDisk;
import com.sanjogstha.codewars.domain.source.UserDataSource;

import javax.inject.Inject;

import static com.sanjogstha.codewars.disk.DataState.DATA_AVAILABLE;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class UserDataSourceFactory extends DataSourceFactory<UserDataSource,
        UserDiskDataSource, UserNetworkDataSource, Integer> {
    private final UserNetworkDataSource networkDataSource;
    private final UserDiskDataSource diskDataSource;
    private final UserDisk userDisk;

    @Inject
    public UserDataSourceFactory(UserNetworkDataSource networkDataSource,
                                 UserDiskDataSource diskDataSource,
                                 UserDisk userDisk) {
        this.networkDataSource = networkDataSource;
        this.diskDataSource = diskDataSource;
        this.userDisk = userDisk;
    }

    @Override
    public UserDataSource get(Integer integer) {
        if (userDisk.getState(integer) == DATA_AVAILABLE) return diskDataSource;
        return networkDataSource;
    }

    @Override
    public UserDiskDataSource getDiskSource() {
        return diskDataSource;
    }

    @Override
    public UserNetworkDataSource getNetworkSource() {
        return networkDataSource;
    }
}

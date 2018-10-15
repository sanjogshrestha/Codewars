package com.sanjogstha.codewars.data.source.detail;

import com.sanjogstha.codewars.data.repository.detail.DetailDiskDataSource;
import com.sanjogstha.codewars.data.repository.detail.DetailNetworkDataSource;
import com.sanjogstha.codewars.data.source.DataSourceFactory;
import com.sanjogstha.codewars.disk.DetailDisk;
import com.sanjogstha.codewars.domain.source.DetailDataSource;

import javax.inject.Inject;

import static com.sanjogstha.codewars.disk.DataState.DATA_AVAILABLE;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class DetailDataSourceFactory extends DataSourceFactory<DetailDataSource,
        DetailDiskDataSource, DetailNetworkDataSource, Integer> {
    private final DetailNetworkDataSource networkDataSource;
    private final DetailDiskDataSource diskDataSource;
    private final DetailDisk detailDisk;

    @Inject
    public DetailDataSourceFactory(DetailNetworkDataSource networkDataSource,
                                 DetailDiskDataSource diskDataSource,
                                 DetailDisk detailDisk) {
        this.networkDataSource = networkDataSource;
        this.diskDataSource = diskDataSource;
        this.detailDisk = detailDisk;
    }

    @Override
    public DetailDataSource get(Integer integer) {
        if (detailDisk.getState(integer) == DATA_AVAILABLE) return diskDataSource;
        return networkDataSource;
    }

    @Override
    public DetailDiskDataSource getDiskSource() {
        return diskDataSource;
    }

    @Override
    public DetailNetworkDataSource getNetworkSource() {
        return networkDataSource;
    }
}

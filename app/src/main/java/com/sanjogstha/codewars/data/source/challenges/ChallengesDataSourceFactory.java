package com.sanjogstha.codewars.data.source.challenges;

import com.sanjogstha.codewars.data.repository.challenges.ChallengesDiskDataSource;
import com.sanjogstha.codewars.data.repository.challenges.ChallengesNetworkDataSource;
import com.sanjogstha.codewars.data.source.DataSourceFactory;
import com.sanjogstha.codewars.disk.ChallengesDisk;
import com.sanjogstha.codewars.domain.source.ChallengesDataSource;

import javax.inject.Inject;

import static com.sanjogstha.codewars.disk.DataState.DATA_AVAILABLE;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class ChallengesDataSourceFactory extends DataSourceFactory<ChallengesDataSource,
        ChallengesDiskDataSource, ChallengesNetworkDataSource, Integer> {
    private final ChallengesNetworkDataSource networkDataSource;
    private final ChallengesDiskDataSource diskDataSource;
    private final ChallengesDisk disk;

    @Inject
    public ChallengesDataSourceFactory(ChallengesNetworkDataSource networkDataSource,
                                       ChallengesDiskDataSource diskDataSource,
                                        ChallengesDisk disk) {
        this.networkDataSource = networkDataSource;
        this.diskDataSource = diskDataSource;
        this.disk = disk;
    }

    @Override
    public ChallengesDataSource get(Integer integer) {
        if (disk.getState(integer) == DATA_AVAILABLE) return diskDataSource;
        return networkDataSource;
    }

    @Override
    public ChallengesDiskDataSource getDiskSource() {
        return diskDataSource;
    }

    @Override
    public ChallengesNetworkDataSource getNetworkSource() {
        return networkDataSource;
    }
}

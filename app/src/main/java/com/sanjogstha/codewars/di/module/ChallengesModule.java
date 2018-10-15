package com.sanjogstha.codewars.di.module;

import com.sanjogstha.codewars.data.ChallengesRepositoryImpl;
import com.sanjogstha.codewars.data.repository.challenges.ChallengesDiskDataSource;
import com.sanjogstha.codewars.data.repository.challenges.ChallengesNetworkDataSource;
import com.sanjogstha.codewars.data.source.challenges.ChallengesDataSourceFactory;
import com.sanjogstha.codewars.di.PerActivity;
import com.sanjogstha.codewars.disk.ChallengesDisk;
import com.sanjogstha.codewars.disk.impl.ChallengesDiskImpl;
import com.sanjogstha.codewars.domain.ChallengesRepository;
import com.sanjogstha.codewars.remote.NetworkService;
import com.sanjogstha.codewars.ui.challenge.ChallengeMvpPresenter;
import com.sanjogstha.codewars.ui.challenge.ChallengePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Module(includes = ActivityModule.class)
public class ChallengesModule {
    @Provides
    @PerActivity
    ChallengeMvpPresenter providePresenter(ChallengePresenter presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ChallengesRepository provideRepository(ChallengesDataSourceFactory factory) {
        return new ChallengesRepositoryImpl(factory);
    }

    @Provides
    ChallengesDisk provideDisk() {
        return new ChallengesDiskImpl();
    }

    @Provides
    ChallengesDiskDataSource provideDiskDataSource(ChallengesDisk disk) {
        return new ChallengesDiskDataSource(disk);
    }

    @Provides
    ChallengesNetworkDataSource provideNetworkDataSource(NetworkService service) {
        return new ChallengesNetworkDataSource(service);
    }

    @Provides
    ChallengesDataSourceFactory provideDataSourceFactory(
            ChallengesDiskDataSource diskDataSource,
            ChallengesNetworkDataSource networkDataSource,
            ChallengesDisk restaurantDisk) {
        return new ChallengesDataSourceFactory(networkDataSource, diskDataSource, restaurantDisk);
    }
}
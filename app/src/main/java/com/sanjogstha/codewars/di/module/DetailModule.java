package com.sanjogstha.codewars.di.module;

import com.sanjogstha.codewars.data.DetailRepositoryImpl;
import com.sanjogstha.codewars.data.repository.detail.DetailDiskDataSource;
import com.sanjogstha.codewars.data.repository.detail.DetailNetworkDataSource;
import com.sanjogstha.codewars.data.source.detail.DetailDataSourceFactory;
import com.sanjogstha.codewars.di.PerActivity;
import com.sanjogstha.codewars.disk.DetailDisk;
import com.sanjogstha.codewars.disk.impl.DetailDiskImpl;
import com.sanjogstha.codewars.domain.DetailRepository;
import com.sanjogstha.codewars.remote.NetworkService;
import com.sanjogstha.codewars.ui.detail.DetailMvpPresenter;
import com.sanjogstha.codewars.ui.detail.DetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Module(includes = ActivityModule.class)
public class DetailModule {
    @Provides
    @PerActivity
    DetailMvpPresenter providePresenter(DetailPresenter presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    DetailRepository provideRepository(DetailDataSourceFactory factory) {
        return new DetailRepositoryImpl(factory);
    }

    @Provides
    DetailDisk provideDisk() {
        return new DetailDiskImpl();
    }

    @Provides
    DetailDiskDataSource provideDiskDataSource(DetailDisk detailDisk) {
        return new DetailDiskDataSource(detailDisk);
    }

    @Provides
    DetailNetworkDataSource provideNetworkDataSource(NetworkService service) {
        return new DetailNetworkDataSource(service);
    }

    @Provides
    DetailDataSourceFactory provideDataSourceFactory(
            DetailDiskDataSource diskDataSource,
            DetailNetworkDataSource networkDataSource,
            DetailDisk restaurantDisk) {
        return new DetailDataSourceFactory(networkDataSource, diskDataSource, restaurantDisk);
    }
}

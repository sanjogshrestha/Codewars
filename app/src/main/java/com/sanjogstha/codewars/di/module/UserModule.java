package com.sanjogstha.codewars.di.module;

import com.sanjogstha.codewars.data.UserRepositoryImpl;
import com.sanjogstha.codewars.data.repository.user.UserDiskDataSource;
import com.sanjogstha.codewars.data.repository.user.UserNetworkDataSource;
import com.sanjogstha.codewars.data.source.user.UserDataSourceFactory;
import com.sanjogstha.codewars.di.PerActivity;
import com.sanjogstha.codewars.disk.UserDisk;
import com.sanjogstha.codewars.disk.impl.UserDiskImpl;
import com.sanjogstha.codewars.domain.UserRepository;
import com.sanjogstha.codewars.remote.NetworkService;
import com.sanjogstha.codewars.ui.user.UserMvpPresenter;
import com.sanjogstha.codewars.ui.user.UserPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sanjogstha on 10/12/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Module(includes = ActivityModule.class)
public class UserModule {
    @Provides
    @PerActivity
    UserMvpPresenter providePresenter(UserPresenter presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    UserRepository provideRepository(UserDataSourceFactory factory) {
        return new UserRepositoryImpl(factory);
    }

    @Provides
    UserDisk provideRestaurantDisk() {
        return new UserDiskImpl();
    }

    @Provides
    UserDiskDataSource provideDiskDataSource(UserDisk restaurantDisk) {
        return new UserDiskDataSource(restaurantDisk);
    }

    @Provides
    UserNetworkDataSource provideNetworkDataSource(NetworkService service) {
        return new UserNetworkDataSource(service);
    }

    @Provides
    UserDataSourceFactory provideDataSourceFactory(
            UserDiskDataSource diskDataSource,
            UserNetworkDataSource networkDataSource,
            UserDisk restaurantDisk) {
        return new UserDataSourceFactory(networkDataSource, diskDataSource, restaurantDisk);
    }
}

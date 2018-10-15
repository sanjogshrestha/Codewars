package com.sanjogstha.codewars.data.repository.detail;

import com.sanjogstha.codewars.data.repository.user.UserDiskDataSource;
import com.sanjogstha.codewars.domain.source.DetailDataSource;
import com.sanjogstha.codewars.remote.NetworkService;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class DetailNetworkDataSource implements DetailDataSource {
    private final NetworkService networkService;

    @Inject
    public DetailNetworkDataSource(NetworkService networkService) {
        this.networkService = networkService;
    }

    @Override
    public int getDataSourceType() {
        return UserDiskDataSource.DATA_SOURCE_NETWORK;
    }

    @Override
    public Observable<ChallengeDetailDTO> getDetail(String slug) {
        return networkService.getChallengeDetail(slug).map(dto -> dto);
    }

    @Override
    public Completable saveUser(ChallengeDetailDTO dto) {
        return Completable.error(new Exception("No Op"));
    }
}

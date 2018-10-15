package com.sanjogstha.codewars.data;

import com.sanjogstha.codewars.data.source.detail.DetailDataSourceFactory;
import com.sanjogstha.codewars.domain.DetailRepository;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class DetailRepositoryImpl implements DetailRepository {
    private final DetailDataSourceFactory dataSourceFactory;

    @Inject
    public DetailRepositoryImpl(DetailDataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    @Override
    public Observable<ChallengeDetailDTO> getDetailChallenges(String slug) {
        return getDetailChallengesFromAPI(slug);
    }

    @Override
    public Observable<ChallengeDetailDTO> getDetailChallengesFromAPI(String slug) {
        return dataSourceFactory
                .getNetworkSource()
                .getDetail(slug)
                .doOnNext(dto -> dataSourceFactory
                        .getDiskSource()
                        .saveUser(dto)
                        .subscribe())
                .map(dto -> dto);
    }

    @Override
    public Observable<ChallengeDetailDTO> getDetailChallengesFromFB(String slug) {
        return dataSourceFactory.getDiskSource()
                .getDetail(slug)
                .map(dto -> dto);
    }
}

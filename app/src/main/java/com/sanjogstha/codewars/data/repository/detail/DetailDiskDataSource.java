package com.sanjogstha.codewars.data.repository.detail;

import com.sanjogstha.codewars.disk.DetailDisk;
import com.sanjogstha.codewars.domain.source.DetailDataSource;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class DetailDiskDataSource implements DetailDataSource {
    private final DetailDisk disk;

    @Inject
    public DetailDiskDataSource(DetailDisk disk) {
        this.disk = disk;
    }

    @Override
    public int getDataSourceType() {
        return DATA_SOURCE_DISK;
    }

    @Override
    public Observable<ChallengeDetailDTO> getDetail(String slug) {
        return Observable.fromCallable(() -> disk.getDetailChallenges(slug));
    }

    @Override
    public Completable saveUser(ChallengeDetailDTO dto) {
        return Completable.fromAction(() -> disk.saveDetail(dto));
    }
}

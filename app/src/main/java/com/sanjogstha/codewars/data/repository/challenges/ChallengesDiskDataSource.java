package com.sanjogstha.codewars.data.repository.challenges;

import com.sanjogstha.codewars.disk.ChallengesDisk;
import com.sanjogstha.codewars.domain.source.ChallengesDataSource;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDTO;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDataDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDataDTO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class ChallengesDiskDataSource implements ChallengesDataSource {
    private final ChallengesDisk disk;

    @Inject
    public ChallengesDiskDataSource(ChallengesDisk disk) {
        this.disk = disk;
    }

    @Override
    public int getDataSourceType() {
        return DATA_SOURCE_DISK;
    }

    @Override
    public Observable<List<AuthoredChallengesDataDTO>> getAuthoredChallenges(String username) {
        return Observable.fromCallable(() -> disk.getAuthoredChallenges(username));
    }

    @Override
    public Completable saveAuthoredChallenges(AuthoredChallengesDTO authoredChallengesDTO, String username) {
        return Completable.fromAction(() -> disk.saveAuthoredChallenges(authoredChallengesDTO, username));
    }

    @Override
    public Observable<List<CompletedChallengeDataDTO>> getCompletedChallenges(String username) {
        return Observable.fromCallable(() -> disk.getCompletedChallenges(username));
    }

    @Override
    public Completable saveCompletedChallenges(CompletedChallengeDTO completedChallengeDTO, String username) {
        return Completable.fromAction(() -> disk.saveCompletedChallenges(completedChallengeDTO, username));
    }
}

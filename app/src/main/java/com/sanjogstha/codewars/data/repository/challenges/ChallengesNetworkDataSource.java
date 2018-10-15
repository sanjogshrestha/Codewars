package com.sanjogstha.codewars.data.repository.challenges;

import com.sanjogstha.codewars.data.repository.user.UserDiskDataSource;
import com.sanjogstha.codewars.domain.source.ChallengesDataSource;
import com.sanjogstha.codewars.remote.NetworkService;
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
public class ChallengesNetworkDataSource implements ChallengesDataSource {
    private final NetworkService networkService;

    @Inject
    public ChallengesNetworkDataSource(NetworkService networkService) {
        this.networkService = networkService;
    }

    @Override
    public int getDataSourceType() {
        return UserDiskDataSource.DATA_SOURCE_NETWORK;
    }

    @Override
    public Observable<List<AuthoredChallengesDataDTO>> getAuthoredChallenges(String username) {
        return networkService.getUserAuthoredChallenges(username)
                .map(AuthoredChallengesDTO::getData);
    }

    @Override
    public Completable saveAuthoredChallenges(AuthoredChallengesDTO authoredChallengesDTO, String username) {
        return Completable.error(new Exception("No Op"));
    }

    @Override
    public Observable<List<CompletedChallengeDataDTO>> getCompletedChallenges(String username) {
        return networkService.getUserCompletedChallenges(username)
                .map(CompletedChallengeDTO::getData);
    }

    @Override
    public Completable saveCompletedChallenges(CompletedChallengeDTO completedChallengeDTO, String username) {
        return Completable.error(new Exception("No Op"));
    }
}
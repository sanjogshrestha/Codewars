package com.sanjogstha.codewars.data;

import com.sanjogstha.codewars.data.source.challenges.ChallengesDataSourceFactory;
import com.sanjogstha.codewars.domain.ChallengesRepository;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDTO;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class ChallengesRepositoryImpl implements ChallengesRepository {
    private final ChallengesDataSourceFactory dataSourceFactory;

    @Inject
    public ChallengesRepositoryImpl(ChallengesDataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    @Override
    public Observable<AuthoredChallengesDTO> getAuthoredChallengesFromAPI(String username) {
        return dataSourceFactory.getNetworkSource().getAuthoredChallenges(username)
                .doOnNext(authoredChallengesDataDTOS -> {
                    AuthoredChallengesDTO authoredChallengesDTO = new AuthoredChallengesDTO();
                    authoredChallengesDTO.setData(authoredChallengesDataDTOS);
                    dataSourceFactory
                            .getDiskSource()
                            .saveAuthoredChallenges(authoredChallengesDTO, username)
                            .subscribe();
                })
                .map(authoredChallengesDataDTOS -> {
                    AuthoredChallengesDTO authoredChallengesDTO = new AuthoredChallengesDTO();
                    authoredChallengesDTO.setData(authoredChallengesDataDTOS);
                    return authoredChallengesDTO;
        });
    }

    @Override
    public Observable<AuthoredChallengesDTO> getAuthoredChallengesFromDB(String username) {
        return dataSourceFactory.getDiskSource().getAuthoredChallenges(username)
                .map(authoredChallengesDataDTOS -> {
                    AuthoredChallengesDTO authoredChallengesDTO = new AuthoredChallengesDTO();
                    authoredChallengesDTO.setData(authoredChallengesDataDTOS);
                    return authoredChallengesDTO;
        });
    }

    @Override
    public Observable<CompletedChallengeDTO> getCompletedChallengesFromAPI(String username) {
        return dataSourceFactory.getNetworkSource().getCompletedChallenges(username)
                .doOnNext(completedChallengeDataDTOS -> {
                    CompletedChallengeDTO completedChallengeDTO = new CompletedChallengeDTO();
                    completedChallengeDTO.setData(completedChallengeDataDTOS);
                    dataSourceFactory
                            .getDiskSource()
                            .saveCompletedChallenges(completedChallengeDTO, username)
                            .subscribe();
                })
                .map(completedChallengesDataDTOS -> {
                    CompletedChallengeDTO completedChallengeDTO = new CompletedChallengeDTO();
                    completedChallengeDTO.setData(completedChallengesDataDTOS);
                    return completedChallengeDTO;
                });
    }

    @Override
    public Observable<CompletedChallengeDTO> getCompletedChallengesFromDB(String username) {
        return dataSourceFactory.getDiskSource().getCompletedChallenges(username)
                .map(completedChallengeDataDTOS -> {
                    CompletedChallengeDTO completedChallengeDTO = new CompletedChallengeDTO();
                    completedChallengeDTO.setData(completedChallengeDataDTOS);
                    return completedChallengeDTO;
        });
    }

    @Override
    public Observable<AuthoredChallengesDTO> getAuthoredChallenges(String username) {
        return getAuthoredChallengesFromAPI(username);
    }

    @Override
    public Observable<CompletedChallengeDTO> getCompletedChallenges(String username) {
        return getCompletedChallengesFromAPI(username);
    }
}

package com.sanjogstha.codewars.domain;

import com.sanjogstha.codewars.domain.base.Repository;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDTO;

import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface ChallengesRepository extends Repository {
    Observable<AuthoredChallengesDTO> getAuthoredChallengesFromAPI(String username);
    Observable<AuthoredChallengesDTO> getAuthoredChallengesFromDB(String username);
    Observable<CompletedChallengeDTO> getCompletedChallengesFromAPI(String username);
    Observable<CompletedChallengeDTO> getCompletedChallengesFromDB(String username);
    Observable<AuthoredChallengesDTO> getAuthoredChallenges(String username);
    Observable<CompletedChallengeDTO> getCompletedChallenges(String username);

}

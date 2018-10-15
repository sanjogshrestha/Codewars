package com.sanjogstha.codewars.domain.source;

import com.sanjogstha.codewars.domain.base.DataSource;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDTO;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDataDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDataDTO;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface ChallengesDataSource extends DataSource {
    Observable<List<AuthoredChallengesDataDTO>> getAuthoredChallenges(String username);
    Completable saveAuthoredChallenges(AuthoredChallengesDTO authoredChallengesDTO, String username);
    Observable<List<CompletedChallengeDataDTO>> getCompletedChallenges(String username);
    Completable saveCompletedChallenges(CompletedChallengeDTO completedChallengeDTO, String username);
}

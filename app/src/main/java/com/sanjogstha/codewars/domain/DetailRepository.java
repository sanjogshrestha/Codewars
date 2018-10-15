package com.sanjogstha.codewars.domain;

import com.sanjogstha.codewars.domain.base.Repository;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;

import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface DetailRepository extends Repository {
    Observable<ChallengeDetailDTO> getDetailChallenges(String slug);
    Observable<ChallengeDetailDTO> getDetailChallengesFromAPI(String slug);
    Observable<ChallengeDetailDTO> getDetailChallengesFromFB(String slug);
}

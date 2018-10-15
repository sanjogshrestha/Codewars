package com.sanjogstha.codewars.remote;

import com.sanjogstha.codewars.remote.model.AuthoredChallengesDTO;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDTO;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class NetworkService {
    private NetworkApiService mService;

    @Inject
    public NetworkService() {
        mService = Api.getService();
    }

    public Observable<UserResponseDTO> getUserInfo(String username) {
        return mService.getUserInfo(username);
    }

    public Observable<CompletedChallengeDTO> getUserCompletedChallenges(String username) {
        return mService.getUserCompletedChallenges(username);
    }

    public Observable<AuthoredChallengesDTO> getUserAuthoredChallenges(String username) {
        return mService.getUserAuthoredChallenges(username);
    }

    public Observable<ChallengeDetailDTO> getChallengeDetail(String slug) {
        return mService.getChallengeDetail(slug);
    }
}

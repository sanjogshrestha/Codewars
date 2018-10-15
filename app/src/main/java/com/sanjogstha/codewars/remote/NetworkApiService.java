package com.sanjogstha.codewars.remote;

import com.sanjogstha.codewars.remote.model.AuthoredChallengesDTO;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDTO;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sanjogstha on 10/14/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface NetworkApiService {
    @GET(ApiConstant.GET_USER_INFO_URL)
    Observable<UserResponseDTO> getUserInfo(@Path("username") String username);

    @GET(ApiConstant.COMPLETED_CHALLENGE_URL)
    Observable<CompletedChallengeDTO> getUserCompletedChallenges(@Path("username") String username);

    @GET(ApiConstant.AUTHORED_CHALLENGE_URL)
    Observable<AuthoredChallengesDTO> getUserAuthoredChallenges(@Path("username") String username);

    @GET(ApiConstant.CHALLENGE_INFO_URL)
    Observable<ChallengeDetailDTO> getChallengeDetail(@Path("slug") String slug);
}

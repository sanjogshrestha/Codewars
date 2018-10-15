package com.sanjogstha.codewars.ui.challenge;

import com.sanjogstha.codewars.remote.model.AuthoredChallengesDataDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDataDTO;
import com.sanjogstha.codewars.ui.base.MvpView;

import java.util.List;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface ChallengeView extends MvpView {
    void onAuthoredListFetchSuccess(List<AuthoredChallengesDataDTO> dataDTOList);
    void onCompletedListFetchSuccess(List<CompletedChallengeDataDTO> dataDTOList);
    void onCompletedFetchFail(String message);
    void onAuthorizedFetchFail(String message);
}

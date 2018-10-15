package com.sanjogstha.codewars.ui.detail;

import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;
import com.sanjogstha.codewars.ui.base.MvpView;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface DetailView extends MvpView {
    void fetchSuccess(ChallengeDetailDTO dto);
    void fetchFail(String message);
}

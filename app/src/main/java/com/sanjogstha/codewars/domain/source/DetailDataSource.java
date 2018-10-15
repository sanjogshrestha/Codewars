package com.sanjogstha.codewars.domain.source;

import com.sanjogstha.codewars.domain.base.DataSource;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface DetailDataSource extends DataSource {
    Observable<ChallengeDetailDTO> getDetail(String slug);
    Completable saveUser(ChallengeDetailDTO dto);
}

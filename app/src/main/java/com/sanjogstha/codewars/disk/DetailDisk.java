package com.sanjogstha.codewars.disk;

import com.sanjogstha.codewars.disk.base.StatefulDisk;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface DetailDisk extends StatefulDisk<Integer> {
    ChallengeDetailDTO getDetailChallenges(String slug);
    void saveDetail(ChallengeDetailDTO dto);
}
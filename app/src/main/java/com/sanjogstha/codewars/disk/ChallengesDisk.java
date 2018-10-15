package com.sanjogstha.codewars.disk;

import com.sanjogstha.codewars.disk.base.StatefulDisk;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDTO;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDataDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDataDTO;

import java.util.List;

/**
 * Created by sanjogstha on 10/12/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface ChallengesDisk extends StatefulDisk<Integer> {
    List<AuthoredChallengesDataDTO> getAuthoredChallenges(String username);
    void saveAuthoredChallenges(AuthoredChallengesDTO authoredChallengesDTO, String username);
    List<CompletedChallengeDataDTO> getCompletedChallenges(String username);
    void saveCompletedChallenges(CompletedChallengeDTO completedChallengeDTO, String username);
}

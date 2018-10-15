package com.sanjogstha.codewars.disk.impl;

import com.sanjogstha.codewars.CodewarsApp;
import com.sanjogstha.codewars.database.dao.UserDao;
import com.sanjogstha.codewars.database.tables.UserTable;
import com.sanjogstha.codewars.disk.DataState;
import com.sanjogstha.codewars.disk.UserDisk;
import com.sanjogstha.codewars.remote.model.CodeChallengesDTO;
import com.sanjogstha.codewars.remote.model.OverallDTO;
import com.sanjogstha.codewars.remote.model.RanksDTO;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by sanjogstha on 10/12/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class UserDiskImpl implements UserDisk {
    @Inject
    public UserDiskImpl() {}

    @Override
    public UserResponseDTO getUser(String username) {
        UserTable user = CodewarsApp.getmInstance().getCodewarsDatabase()
                .getUserDao().getUserByUsername(username);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(user.getName());
        userResponseDTO.setClan(user.getClan());
        userResponseDTO.setHonor(user.getHonor());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setLeaderboardPosition(user.getLeaderboardPosition());
        CodeChallengesDTO codeChallengesDTO = new CodeChallengesDTO();
        codeChallengesDTO.setTotalAuthored(user.getTotalAuthored());
        codeChallengesDTO.setTotalCompleted(user.getTotalAuthored());
        userResponseDTO.setCodeChallenges(codeChallengesDTO);
        RanksDTO ranksDTO = new RanksDTO();
        OverallDTO overallDTO = new OverallDTO();
        overallDTO.setRank(user.getRank());
        ranksDTO.setOverall(overallDTO);
        userResponseDTO.setRanks(ranksDTO);
        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> getUserList() {
        List<UserTable> userTableSingle = CodewarsApp.getmInstance().getCodewarsDatabase()
                .getUserDao().getUsersOrderedByLeaderboard();
        ArrayList<UserResponseDTO> userResponseDTOArrayList = new ArrayList<>();
        for (UserTable user : userTableSingle) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setName(user.getName());
            userResponseDTO.setClan(user.getClan());
            userResponseDTO.setHonor(user.getHonor());
            userResponseDTO.setUsername(user.getUsername());
            userResponseDTO.setLeaderboardPosition(user.getLeaderboardPosition());
            CodeChallengesDTO codeChallengesDTO = new CodeChallengesDTO();
            codeChallengesDTO.setTotalAuthored(user.getTotalAuthored());
            codeChallengesDTO.setTotalCompleted(user.getTotalAuthored());
            userResponseDTO.setCodeChallenges(codeChallengesDTO);
            RanksDTO ranksDTO = new RanksDTO();
            OverallDTO overallDTO = new OverallDTO();
            overallDTO.setRank(user.getRank());
            ranksDTO.setOverall(overallDTO);
            userResponseDTO.setRanks(ranksDTO);
            userResponseDTOArrayList.add(userResponseDTO);
        }

        return userResponseDTOArrayList;
    }

    @Override
    public void saveUser(UserResponseDTO userResponseDTO) {
        UserDao userDao = CodewarsApp.getmInstance().getCodewarsDatabase().getUserDao();
        UserTable userTable = new UserTable();
        userTable.setName(userResponseDTO.getName());
        userTable.setClan(userResponseDTO.getClan());
        userTable.setUsername(userResponseDTO.getUsername());
        userTable.setHonor(userResponseDTO.getHonor());
        CodeChallengesDTO codeChallenges = userResponseDTO.getCodeChallenges();
        RanksDTO ranks = userResponseDTO.getRanks();
        userTable.setRank(ranks.getOverall().getRank());
        userTable.setTotalAuthored(codeChallenges.getTotalAuthored());
        userTable.setTotalCompleted(codeChallenges.getTotalCompleted());
        userTable.setLeaderboardPosition(userResponseDTO.getLeaderboardPosition());
        userDao.insertUser(userTable);
    }

    @Override
    public int getState(Integer input) {
        return DataState.DATA_AVAILABLE;
    }
}

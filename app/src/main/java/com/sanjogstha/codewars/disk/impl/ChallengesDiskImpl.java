package com.sanjogstha.codewars.disk.impl;

import android.support.annotation.NonNull;

import com.sanjogstha.codewars.CodewarsApp;
import com.sanjogstha.codewars.database.dao.AuthoredDao;
import com.sanjogstha.codewars.database.dao.CompletedDao;
import com.sanjogstha.codewars.database.tables.AuthoredTable;
import com.sanjogstha.codewars.database.tables.CompletedTable;
import com.sanjogstha.codewars.disk.ChallengesDisk;
import com.sanjogstha.codewars.disk.DataState;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDTO;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDataDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDataDTO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class ChallengesDiskImpl implements ChallengesDisk {
    @Inject
    public ChallengesDiskImpl() {}

    @Override
    public List<AuthoredChallengesDataDTO> getAuthoredChallenges(String username) {
        return getAuthoredListFromTable(username);
    }

    @NonNull
    public static List<AuthoredChallengesDataDTO> getAuthoredListFromTable(String username) {
        List<AuthoredTable> tableList = CodewarsApp.getmInstance().getCodewarsDatabase()
                .getAuthoredDao().getAuthoredChallenges(username);
        List<AuthoredChallengesDataDTO> authoredChallengesDTOS = new ArrayList<>();
        for (AuthoredTable table : tableList) {
            AuthoredChallengesDataDTO dataDTO = new AuthoredChallengesDataDTO();
            dataDTO.setDescription(table.getDescription());
            dataDTO.setId(table.getId());
            dataDTO.setLanguages(table.getLanguages());
            dataDTO.setName(table.getName());
            dataDTO.setRankName(table.getRankName());
            dataDTO.setRank(table.getRank());
            dataDTO.setTags(table.getTags());
            authoredChallengesDTOS.add(dataDTO);
        }
        return authoredChallengesDTOS;
    }

    @Override
    public void saveAuthoredChallenges(AuthoredChallengesDTO authoredChallengesDTO, String username) {
        AuthoredDao dao = CodewarsApp.getmInstance().getCodewarsDatabase()
                .getAuthoredDao();
        List<AuthoredChallengesDataDTO> dataDTOList = authoredChallengesDTO.getData();
        List<AuthoredTable> authoredTables = new ArrayList<>();
        for (AuthoredChallengesDataDTO dataDTO : dataDTOList) {
            AuthoredTable table = new AuthoredTable();
            table.setUsername(username);
            table.setDescription(dataDTO.getDescription());
            table.setId(dataDTO.getId());
            table.setLanguages(dataDTO.getLanguages());
            table.setName(dataDTO.getName());
            table.setRankName(dataDTO.getRankName());
            table.setRank(dataDTO.getRank());
            table.setTags(dataDTO.getTags());
            authoredTables.add(table);
        }
        dao.insert(authoredTables);
    }

    @Override
    public List<CompletedChallengeDataDTO> getCompletedChallenges(String username) {
        return getCompletedListFromTable(username);
    }

    @NonNull
    public static List<CompletedChallengeDataDTO> getCompletedListFromTable(String username) {
        List<CompletedTable> tableList = CodewarsApp.getmInstance().getCodewarsDatabase()
                .getCompletedDao().getCompletedChallenges(username);
        List<CompletedChallengeDataDTO> completedChallengeDataDTOS = new ArrayList<>();
        for (CompletedTable table : tableList) {
            CompletedChallengeDataDTO dataDTO = new CompletedChallengeDataDTO();
            dataDTO.setCompletedAt(table.getCompletedAt());
            dataDTO.setId(table.getId());
            dataDTO.setName(table.getName());
            dataDTO.setCompletedLanguages(table.getCompletedLanguages());
            dataDTO.setSlug(table.getSlug());
            completedChallengeDataDTOS.add(dataDTO);
        }
        return completedChallengeDataDTOS;
    }

    @Override
    public void saveCompletedChallenges(CompletedChallengeDTO completedChallengeDTO, String username) {
        List<CompletedTable> completedTables = new ArrayList<>();
        CompletedDao completedDao = CodewarsApp.getmInstance().getCodewarsDatabase().getCompletedDao();
        for (CompletedChallengeDataDTO dataDTO : completedChallengeDTO.getData()) {
            CompletedTable table = new CompletedTable();
            table.setCompletedAt(dataDTO.getCompletedAt());
            table.setId(dataDTO.getId());
            table.setName(dataDTO.getName());
            table.setUsername(username);
            table.setCompletedLanguages(dataDTO.getCompletedLanguages());
            table.setSlug(dataDTO.getSlug());
            completedTables.add(table);
        }
        completedDao.insert(completedTables);
    }

    @Override
    public int getState(Integer input) {
        return DataState.DATA_AVAILABLE;
    }
}

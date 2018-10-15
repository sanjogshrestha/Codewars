package com.sanjogstha.codewars.disk.impl;

import com.sanjogstha.codewars.CodewarsApp;
import com.sanjogstha.codewars.database.dao.DetailDao;
import com.sanjogstha.codewars.database.tables.DetailTable;
import com.sanjogstha.codewars.disk.DataState;
import com.sanjogstha.codewars.disk.DetailDisk;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;

import javax.inject.Inject;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class DetailDiskImpl implements DetailDisk {
    @Inject
    public DetailDiskImpl() {}

    @Override
    public ChallengeDetailDTO getDetailChallenges(String slug) {
        DetailDao detailDao = CodewarsApp.getmInstance().getCodewarsDatabase().getDetailDao();
        DetailTable detailBySlug = detailDao.getDetailBySlug(slug);
        if(detailBySlug == null) return null;
        ChallengeDetailDTO detailDTO = new ChallengeDetailDTO();
        detailDTO.setApprovedAt(detailBySlug.getApprovedAt());
        ChallengeDetailDTO.ApprovedBy approvedBy = new ChallengeDetailDTO().getApprovedBy();
        approvedBy.setUsername(detailBySlug.getApprovedBy());
        detailDTO.setApprovedBy(approvedBy);
        detailDTO.setCategory(detailBySlug.getCategory());
        detailDTO.setCreatedAt(detailBySlug.getCreatedAt());
        ChallengeDetailDTO.CreatedBy createdBy = new ChallengeDetailDTO().getCreatedBy();
        createdBy.setUsername(detailBySlug.getCreatedBy());
        detailDTO.setCreatedBy(createdBy);
        detailDTO.setLanguages(detailBySlug.getLanguages());
        detailDTO.setTags(detailBySlug.getTags());
        detailDTO.setId(detailBySlug.getId());
        detailDTO.setDescription(detailBySlug.getDescription());
        detailDTO.setName(detailBySlug.getName());
        detailDTO.setSlug(detailBySlug.getSlug());
        return detailDTO;
    }

    @Override
    public void saveDetail(ChallengeDetailDTO dto) {
        DetailDao detailDao = CodewarsApp.getmInstance().getCodewarsDatabase().getDetailDao();
        DetailTable detailTable = new DetailTable();
        detailTable.setApprovedAt(dto.getApprovedAt());
        try{
            detailTable.setApprovedBy(dto.getApprovedBy().getUsername());
        }catch (NullPointerException e){
            detailTable.setApprovedBy(null);
        }
        detailTable.setCategory(dto.getCategory());
        detailTable.setCreatedAt(dto.getCreatedAt());
        try{
            detailTable.setCreatedBy(dto.getCreatedBy().getUsername());
        }catch (NullPointerException e){
            detailTable.setCreatedBy(null);
        }
        detailTable.setLanguages(dto.getLanguages());
        detailTable.setTags(dto.getTags());
        detailTable.setId(dto.getId());
        detailTable.setDescription(dto.getDescription());
        detailTable.setName(dto.getName());
        detailTable.setSlug(dto.getSlug());
        detailDao.insertDetail(detailTable);
    }

    @Override
    public int getState(Integer input) {
        return DataState.DATA_AVAILABLE;
    }
}

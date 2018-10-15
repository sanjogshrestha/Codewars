package com.sanjogstha.codewars.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sanjogstha.codewars.database.DbConstant;
import com.sanjogstha.codewars.database.tables.CompletedTable;

import java.util.List;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Dao
public interface CompletedDao {
    @Query("SELECT * FROM " + DbConstant.COMPLETED_TABLE + " WHERE username = :username")
    List<CompletedTable> getCompletedChallenges(String username);

    @Query("SELECT * FROM " + DbConstant.COMPLETED_TABLE)
    List<CompletedTable> getCompletedChallenges();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<CompletedTable> completedTableList);
}

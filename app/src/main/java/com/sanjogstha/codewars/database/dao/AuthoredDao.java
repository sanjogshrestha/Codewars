package com.sanjogstha.codewars.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sanjogstha.codewars.database.DbConstant;
import com.sanjogstha.codewars.database.tables.AuthoredTable;

import java.util.List;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Dao
public interface AuthoredDao {
    @Query("SELECT * FROM " + DbConstant.AUTHORED_TABLE + " WHERE username = :username")
    List<AuthoredTable> getAuthoredChallenges(String username);

    @Query("SELECT * FROM " + DbConstant.AUTHORED_TABLE)
    List<AuthoredTable> getAuthoredChallenges();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<AuthoredTable> authoredTableList);
}

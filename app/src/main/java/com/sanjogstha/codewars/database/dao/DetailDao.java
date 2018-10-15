package com.sanjogstha.codewars.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sanjogstha.codewars.database.DbConstant;
import com.sanjogstha.codewars.database.tables.DetailTable;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Dao
public interface DetailDao {
    @Query("SELECT * FROM " + DbConstant.DETAIL_TABLE + " WHERE id = :slug")
    DetailTable getDetailBySlug(String slug);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDetail(DetailTable table);

    /**
     * Counts the number of data in the table.
     *
     * @return The number of data.
     */
    @Query("SELECT COUNT(*) FROM  " + DbConstant.DETAIL_TABLE)
    int count();
}

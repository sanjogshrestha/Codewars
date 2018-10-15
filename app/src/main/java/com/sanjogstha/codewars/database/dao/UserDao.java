package com.sanjogstha.codewars.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sanjogstha.codewars.database.DbConstant;
import com.sanjogstha.codewars.database.tables.UserTable;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM " + DbConstant.USER_TABLE)
    Single<UserTable> getUsers();

    @Query("SELECT * FROM " + DbConstant.USER_TABLE + " ORDER BY leaderboardPosition ASC")
    List<UserTable> getUsersOrderedByLeaderboard();

    @Query("SELECT * FROM " + DbConstant.USER_TABLE + " WHERE username = :username")
    UserTable getUserByUsername(String username);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserTable userTable);

    /**
     * Counts the number of data in the table.
     *
     * @return The number of data.
     */
    @Query("SELECT COUNT(*) FROM  " + DbConstant.USER_TABLE)
    int count();
}

package com.sanjogstha.codewars.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.sanjogstha.codewars.database.dao.AuthoredDao;
import com.sanjogstha.codewars.database.dao.CompletedDao;
import com.sanjogstha.codewars.database.dao.DetailDao;
import com.sanjogstha.codewars.database.dao.UserDao;
import com.sanjogstha.codewars.database.tables.AuthoredTable;
import com.sanjogstha.codewars.database.tables.CompletedTable;
import com.sanjogstha.codewars.database.tables.DetailTable;
import com.sanjogstha.codewars.database.tables.UserTable;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */

@Database(entities = {
        AuthoredTable.class,
        UserTable.class,
        CompletedTable.class,
        DetailTable.class},
        version = DbConstant.DB_VERSION,
        exportSchema = false)
public abstract class CodewarsDatabase extends RoomDatabase {
    private static final String DB_NAME = DbConstant.DB_NAME;
    private static volatile CodewarsDatabase instance;

    public static synchronized CodewarsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static CodewarsDatabase create(final Context context) {
        return Room.databaseBuilder(context, CodewarsDatabase.class, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    public abstract AuthoredDao getAuthoredDao();
    public abstract CompletedDao getCompletedDao();
    public abstract UserDao getUserDao();
    public abstract DetailDao getDetailDao();
}

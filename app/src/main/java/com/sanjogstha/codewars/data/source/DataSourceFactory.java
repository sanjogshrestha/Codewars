package com.sanjogstha.codewars.data.source;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.LruCache;

import com.sanjogstha.codewars.domain.base.DataSource;
import com.sanjogstha.codewars.domain.base.Repository;

import okhttp3.Request;

/**
 * Organize {@link DataSource} implementations into
 *
 * @param <Source>  the corresponding {@link DataSource} for this factory
 * @param <Disk>    {@link SharedPreferences}, {@link SQLiteDatabase},
 *                  or any {@link LruCache} implementations
 * @param <Network> any type of network {@link Request} implementation
 * @param <Params>  parameter needed to be passed to the factory to help it
 *                  determine between {@link Disk} and {@link Network} data source
 *
 */
public abstract class DataSourceFactory<
        Source extends DataSource,
        Disk,
        Network,
        Params> {

    /**
     * There will be times where a {@link DataSource} will not
     * have a {@code <Disk>} or {@code <Network>} implementation.
     * <p>
     * For times like these use {@code NONE}
     */
    protected static Void NONE = null;

    /**
     * accessed by the {@link Repository}
     *
     * @return returns the appropriate {@link DataSource}
     * {@code Disk} or {@code Network} as decided by the factory
     */
    public abstract Source get(Params input);

    /**
     * {@link SharedPreferences}, {@link SQLiteDatabase} or any {@link LruCache} implementations
     * for a {@link DataSource}
     *
     * @return local storage implementations for a {@link DataSource}
     */
    public abstract Disk getDiskSource();

    /**
     * any type of network {@link Request} implementation for a {@link DataSource}
     *
     * @return remote storage implementations for a {@link DataSource}
     */
    public abstract Network getNetworkSource();

}

package com.sanjogstha.codewars.domain.base;

import android.support.annotation.IntDef;

import com.sanjogstha.codewars.data.source.DataSourceFactory;

/**
 * Represents a DataSource.
 * Added for documentation purposes.
 * <p>
 * A DataSource defines all the actions that require a
 * disk implementation {@link DataSourceFactory#getDiskSource()}, or
 * a network implementation {@link DataSourceFactory#getNetworkSource()}
 * <p>
 * For more info:
 *
 */
public interface DataSource {

    /**
     * Metadata for data source information. Can be used for evaluation by the repository,
     * use-case or the data source factory to act accordingly.
     * if an entity is to be cached or not.
     *
     * @return type of data source
     */
    @DataSourceType int getDataSourceType();

    int DATA_SOURCE_NETWORK = 0;
    int DATA_SOURCE_DISK = 1;

    @IntDef({DATA_SOURCE_NETWORK, DATA_SOURCE_DISK})
    @interface DataSourceType {
    }

}

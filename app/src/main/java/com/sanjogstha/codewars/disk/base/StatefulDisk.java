package com.sanjogstha.codewars.disk.base;

import com.sanjogstha.codewars.disk.DataState;

/**
 * Represents {@code Disk} implementations where an entity is to be saved
 *
 * @param <Params> parameter needed while determining state of an entity.
 */
public interface StatefulDisk<Params> {

    /**
     * Check if a disk entity is
     * {@link DataState#DATA_EMPTY},
     * {@link DataState#DATA_AVAILABLE},
     * {@link DataState#DATA_STALE}
     * to verify if the entity is to be requested
     *
     * @return indicator for data state
     */
    @DataState
    int getState(Params input);
}

package com.sanjogstha.codewars.disk;

import android.support.annotation.IntDef;

import static com.sanjogstha.codewars.disk.DataState.DATA_AVAILABLE;
import static com.sanjogstha.codewars.disk.DataState.DATA_EMPTY;
import static com.sanjogstha.codewars.disk.DataState.DATA_STALE;

/**
 * Represents data state for disk implementations
 */
@IntDef({DATA_EMPTY, DATA_AVAILABLE, DATA_STALE})
public @interface DataState {
    int DATA_EMPTY = 0;
    int DATA_AVAILABLE = 1;
    int DATA_STALE = 2;
}

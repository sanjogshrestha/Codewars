package com.sanjogstha.codewars.disk;

import android.support.annotation.IntDef;

import static com.sanjogstha.codewars.disk.DataSourceState.DATABASE;
import static com.sanjogstha.codewars.disk.DataSourceState.NETWORK;

@IntDef({DATABASE, NETWORK})
public @interface DataSourceState {
    int NETWORK = 0;
    int DATABASE = 1;
}

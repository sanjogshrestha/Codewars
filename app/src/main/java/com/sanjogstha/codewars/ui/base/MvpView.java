package com.sanjogstha.codewars.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public interface MvpView {
    /**
     * Request to show custom message
     *
     * @see BaseActivity#showMessage(String)
     */
    void showMessage(String message);

    /**
     * Request to show message from string resources
     *
     * @see BaseActivity#showMessage(int)
     */
    void showMessage(@StringRes int resId);
}

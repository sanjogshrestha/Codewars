package com.sanjogstha.codewars.ui.detail;

import com.sanjogstha.codewars.di.PerActivity;
import com.sanjogstha.codewars.ui.base.MvpPresenter;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
@PerActivity
public interface DetailMvpPresenter extends MvpPresenter<DetailView> {
    void getDetail(String slug, DetailActivity detailActivity);
}

package com.sanjogstha.codewars.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sanjogstha.codewars.CodewarsApp;
import com.sanjogstha.codewars.R;
import com.sanjogstha.codewars.di.ActivityComponent;
import com.sanjogstha.codewars.di.DaggerActivityComponent;
import com.sanjogstha.codewars.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.Unbinder;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity implements MvpView{
    private ActivityComponent mActivityComponent;
    private Unbinder mUnBinder;
    @Inject BasePresenter<MvpView> mPresenter;
    private Snackbar snackbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationModule(((CodewarsApp) getApplication()).getApplicationModule())
                .applicationComponent(((CodewarsApp) getApplication()).getComponent())
                .build();
    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        if(mPresenter != null)
            mPresenter.onDetach();
        super.onDestroy();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    private void hideSnackBar(){
        if(snackbar!=null){
            snackbar.dismiss();
        }
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    private void showSnackBar(String message) {
        if (message == null) {
            message = getString(R.string.some_error);
        }
        snackbar= Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_INDEFINITE);
        View rootView = snackbar.getView();
        TextView textView = rootView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        snackbar.setAction("CLOSE", v -> snackbar.dismiss());
        snackbar.show();
    }

    @Override
    public void showMessage(String message) {
        showSnackBar(message);
    }

    @Override
    public void showMessage(int resId) {
        showSnackBar(getString(resId));
    }
}

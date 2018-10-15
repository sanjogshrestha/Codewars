package com.sanjogstha.codewars.ui.challenge;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.sanjogstha.codewars.R;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDataDTO;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDataDTO;
import com.sanjogstha.codewars.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class ChallengeActivity extends BaseActivity implements ChallengeView{
    @Inject ChallengePresenter mPresenter;
    @BindView(R.id.design_bottom_sheet) BottomNavigationView navigationMenuView;
    @BindView(R.id.progess) ProgressBar mProgressBar;
    private AuthoredFragment authoredFragment;
    private CompletedFragment completedFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        String userName = getIntent().getStringExtra("USER_NAME");
        mPresenter.fetchAuthoredChallenges(userName);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpBottomNavigation(userName);
    }

    private void setUpBottomNavigation(String userName) {
        authoredFragment = AuthoredFragment.newInstance(userName);
        completedFragment = CompletedFragment.newInstance(userName);
        navigationMenuView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.action_authored:
                    try{
                        getSupportFragmentManager().beginTransaction().remove(completedFragment).commit();
                    }catch (Throwable ignored){}
                    mProgressBar.setVisibility(View.VISIBLE);
                    mPresenter.fetchAuthoredChallenges(userName);
                    break;

                case R.id.action_completed:
                    try{
                        getSupportFragmentManager().beginTransaction().remove(authoredFragment).commit();
                    }catch (Throwable ignored){}
                    mProgressBar.setVisibility(View.VISIBLE);
                    mPresenter.fetchCompletedChallenges(userName);
                    break;
            }
            return true;
        });
    }

    private void addFragment(Fragment fragment) {
        mProgressBar.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAuthoredListFetchSuccess(List<AuthoredChallengesDataDTO> dataDTOList) {
        addFragment(authoredFragment);
    }

    @Override
    public void onCompletedListFetchSuccess(List<CompletedChallengeDataDTO> dataDTOList) {
        addFragment(completedFragment);
    }

    @Override
    public void onCompletedFetchFail(String message) {
        addFragment(completedFragment);
    }

    @Override
    public void onAuthorizedFetchFail(String message) {
        addFragment(authoredFragment);
    }
}

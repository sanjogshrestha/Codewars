package com.sanjogstha.codewars.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sanjogstha.codewars.R;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;
import com.sanjogstha.codewars.ui.base.BaseActivity;
import com.sanjogstha.codewars.ui.challenge.ChallengeActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class UserActivity extends BaseActivity implements UserView, OnSearchItemClickListener{
    @BindView(R.id.searchInputEt) EditText mSearchEditText;
    @BindView(R.id.searchIv) ImageView mSearchImageView;
    @BindView(R.id.memberNameTv) TextView mNameTextView;
    @BindView(R.id.memberRankTv) TextView mRankTextView;
    @BindView(R.id.memberLeaderboardTv) TextView mLeaderBoardTextView;
    @BindView(R.id.noSearchesLabelTv) TextView noSearchesLabelTv;
    @BindView(R.id.recentSearchesRv) RecyclerView mRecentRecycletView;
    @BindView(R.id.searchPb) ProgressBar searchPb;
    @Inject UserPresenter mPresenter;
    private UserAdapter userAdapter;
    private ArrayList<UserResponseDTO>  userResponseDTOS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        mSearchImageView.setOnClickListener(view ->{
            findViewById(R.id.memberSearchedCv).setVisibility(View.GONE);
            searchPb.setVisibility(View.VISIBLE);
            mPresenter.getUser(mSearchEditText.getText().toString(), this); });

        mPresenter.getRecentUser();
        userResponseDTOS = new ArrayList<>();

        mRecentRecycletView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this, userResponseDTOS, this);
        mRecentRecycletView.setAdapter(userAdapter);
        findViewById(R.id.memberSearchedCv).setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onFetchSuccess(UserResponseDTO userResponseDTO) {
        findViewById(R.id.memberSearchedCv).setVisibility(View.VISIBLE);
        searchPb.setVisibility(View.GONE);
        String name = userResponseDTO.getName();
        mNameTextView.setText((TextUtils.isEmpty(name) || name.equalsIgnoreCase("null")) ? userResponseDTO.getUsername() : name);
        mRankTextView.setText(String.valueOf(userResponseDTO.getRanks().getOverall().getRank()));
        mLeaderBoardTextView.setText(String.valueOf(userResponseDTO.getLeaderboardPosition()));
        findViewById(R.id.memberSearchedCv).setOnClickListener(view -> onItemClicked(userResponseDTO.getUsername()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getRecentUser();
    }

    @Override
    public void onFetchSuccess(List<UserResponseDTO> userResponseDTOList) {
        userResponseDTOS = new ArrayList<>();
        if(userResponseDTOList.size() == 0){
            noSearchesLabelTv.setVisibility(View.VISIBLE);
            return;
        }
        userResponseDTOS.addAll(userResponseDTOList);
        userAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchFail(String msg) {
        showMessage(msg);
        searchPb.setVisibility(View.GONE);
    }

    @Override
    public void onItemClicked(String username) {
        startActivity(new Intent(this, ChallengeActivity.class)
                .putExtra("USER_NAME", username));
    }
}

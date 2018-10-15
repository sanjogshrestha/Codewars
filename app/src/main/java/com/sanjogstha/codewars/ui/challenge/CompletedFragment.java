package com.sanjogstha.codewars.ui.challenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sanjogstha.codewars.R;
import com.sanjogstha.codewars.disk.impl.ChallengesDiskImpl;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDataDTO;
import com.sanjogstha.codewars.ui.detail.DetailActivity;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class CompletedFragment extends Fragment implements ChallengeClickCallBack{
    private static String username;
    @BindView(R.id.completedChallengesRv) RecyclerView mRecyclerView;
    @BindView(R.id.completedChallengesPb) ProgressBar mProgressBar;
    @BindView(R.id.noCompletedChallengesTv) TextView mNoCompletedChallengesTV;
    CompletedAdapter completedAdapter;

    public static CompletedFragment newInstance(String username) {
        CompletedFragment fragment = new CompletedFragment();
        Bundle args = new Bundle();
        args.putString("USER_NAME", username);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getArguments() != null) {
            username = this.getArguments().getString("USER_NAME");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mRecyclerView.setVisibility(View.GONE);
        List<CompletedChallengeDataDTO> completedListFromTable = ChallengesDiskImpl
                .getCompletedListFromTable(username);
        if(completedListFromTable.size() == 0){
            mProgressBar.setVisibility(View.GONE);
            mNoCompletedChallengesTV.setVisibility(View.VISIBLE);
            return;
        }
        mRecyclerView.setVisibility(View.VISIBLE);
        mNoCompletedChallengesTV.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);
        completedAdapter = new CompletedAdapter(getContext(), completedListFromTable, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(completedAdapter);
        completedAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_completed_challenges, container, false);
    }

    @Override
    public void onItemClicked(String id) {
        Objects.requireNonNull(getActivity()).startActivity(new Intent(getContext(), DetailActivity.class)
                .putExtra("ID", id));
    }
}

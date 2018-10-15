package com.sanjogstha.codewars.ui.user;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sanjogstha.codewars.R;
import com.sanjogstha.codewars.remote.model.UserResponseDTO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final Context context;
    private List<UserResponseDTO> searchResults;
    private final OnSearchItemClickListener listener;
    private LayoutInflater mInflater;

    public UserAdapter(Context context, List<UserResponseDTO> searchResults,
                       OnSearchItemClickListener listener) {
        this.context = context;
        this.searchResults = searchResults;
        this.listener = listener;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.member_item_view, viewGroup, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        final UserResponseDTO userResponseDTO = searchResults.get(holder.getAdapterPosition());
        viewHolder.bindData(userResponseDTO);
    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.memberNameTv) TextView mNameTextView;
        @BindView(R.id.memberRankTv) TextView mRankTextView;
        @BindView(R.id.memberLeaderboardTv) TextView mLeaderBoardTextView;
        @BindView(R.id.parentLayout) LinearLayout mParentLayout;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(final UserResponseDTO userResponseDTO) {
            String name = userResponseDTO.getName();
            mNameTextView.setText((TextUtils.isEmpty(name) || name.equalsIgnoreCase("null")) ? userResponseDTO.getUsername() : name);
            mRankTextView.setText(String.valueOf(userResponseDTO.getRanks().getOverall().getRank()));
            mLeaderBoardTextView.setText(String.valueOf(userResponseDTO.getLeaderboardPosition()));
            mParentLayout.setOnClickListener(view -> listener.onItemClicked(userResponseDTO.getUsername()));
        }
    }
}

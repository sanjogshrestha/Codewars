package com.sanjogstha.codewars.ui.challenge;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanjogstha.codewars.R;
import com.sanjogstha.codewars.remote.model.CompletedChallengeDataDTO;
import com.sanjogstha.codewars.utils.DateUtils;
import com.sanjogstha.codewars.utils.ViewUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class CompletedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final Context context;
    private List<CompletedChallengeDataDTO> completedChallengeDataDTOS;
    private LayoutInflater mInflater;
    private CompletedFragment fragment;

    public CompletedAdapter(Context context, List<CompletedChallengeDataDTO> completedChallengeDataDTOS,
                            CompletedFragment fragment) {
        this.context = context;
        this.completedChallengeDataDTOS = completedChallengeDataDTOS;
        this.mInflater = LayoutInflater.from(context);
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.completed_challenge_item_view, viewGroup, false);
        return new CompletedAdapter.ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        final CompletedAdapter.ViewHolder viewHolder = (CompletedAdapter.ViewHolder) holder;
        final CompletedChallengeDataDTO completedChallengeDataDTO = completedChallengeDataDTOS.get(holder.getAdapterPosition());
        viewHolder.bindData(completedChallengeDataDTO, fragment);
    }

    @Override
    public int getItemCount() {
        return completedChallengeDataDTOS.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.challengeNameTv) TextView mNameTextView;
        @BindView(R.id.challengeSlugTv) TextView challengeSlugTv;
        @BindView(R.id.challengeCompletedAtTv) TextView challengeCompletedAtTv;
        @BindView(R.id.challengeLanguagesTv) TextView challengeLanguagesTv;
        @BindView(R.id.challengeCardView) CardView mChallengeCardView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(final CompletedChallengeDataDTO completedChallengeDataDTO,
                      CompletedFragment fragment) {
            mNameTextView.setText(completedChallengeDataDTO.getName());
            challengeSlugTv.setText(completedChallengeDataDTO.getSlug());
            challengeCompletedAtTv.setText(DateUtils.toDisplayDate(completedChallengeDataDTO.getCompletedAt()));
            String message = ViewUtils.join(completedChallengeDataDTO.getCompletedLanguages());
            challengeLanguagesTv.setText(message);
            mChallengeCardView.setOnClickListener(view ->
                    fragment.onItemClicked(completedChallengeDataDTO.getId()));
        }
    }
}

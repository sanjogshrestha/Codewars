package com.sanjogstha.codewars.ui.challenge;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanjogstha.codewars.R;
import com.sanjogstha.codewars.remote.model.AuthoredChallengesDataDTO;
import com.sanjogstha.codewars.utils.ViewUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class AuthoredAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final Context context;
    private List<AuthoredChallengesDataDTO> dataDTOS;
    private LayoutInflater mInflater;
    private ChallengeClickCallBack callBack;

    AuthoredAdapter(Context context, List<AuthoredChallengesDataDTO> dataDTOS,
                    ChallengeClickCallBack callBack) {
        this.context = context;
        this.dataDTOS = dataDTOS;
        this.mInflater = LayoutInflater.from(context);
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.authored_challenge_item_view, viewGroup, false);
        return new AuthoredAdapter.ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        final AuthoredAdapter.ViewHolder viewHolder = (AuthoredAdapter.ViewHolder) holder;
        final AuthoredChallengesDataDTO dataDTO = dataDTOS.get(holder.getAdapterPosition());
        viewHolder.bindData(dataDTO, callBack);
    }

    @Override
    public int getItemCount() {
        return dataDTOS.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.challengeNameTv) TextView mNameTextView;
        @BindView(R.id.challengeTagsTv) TextView challengeTagsTv;
        @BindView(R.id.challengeDescriptionTv) TextView challengeDescriptionTv;
        @BindView(R.id.challengeLanguagesTv) TextView challengeLanguagesTv;
        @BindView(R.id.challengeCardView) CardView mChallengeCardView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(final AuthoredChallengesDataDTO dto, ChallengeClickCallBack callBack) {
            mNameTextView.setText(dto.getName());
            challengeTagsTv.setText(ViewUtils.join(dto.getTags()));
            challengeDescriptionTv.setText(dto.getDescription());
            challengeLanguagesTv.setText(ViewUtils.join(dto.getLanguages()));
            Linkify.addLinks(challengeDescriptionTv, Linkify.ALL);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                challengeDescriptionTv.setText(Html.fromHtml(dto.getDescription(), Html.FROM_HTML_MODE_COMPACT));
            } else {
                challengeDescriptionTv.setText(Html.fromHtml(dto.getDescription()));
            }
            mChallengeCardView.setOnClickListener(view -> {
                callBack.onItemClicked(dto.getId());
            });
        }
    }
}

package com.sanjogstha.codewars.ui.detail;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sanjogstha.codewars.R;
import com.sanjogstha.codewars.remote.model.ChallengeDetailDTO;
import com.sanjogstha.codewars.ui.base.BaseActivity;
import com.sanjogstha.codewars.utils.DateUtils;
import com.sanjogstha.codewars.utils.ViewUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class DetailActivity extends BaseActivity implements DetailView {
    @Inject DetailPresenter mPresenter;
    @BindView(R.id.descriptionTextView) TextView mDescriptionTextView;
    @BindView(R.id.createdAtTextView) TextView mCreatedAtTextView;
    @BindView(R.id.createdByTextView) TextView mCreatedByTextView;
    @BindView(R.id.authoredByTextView) TextView mAuthoredByTextView;
    @BindView(R.id.languageTextView) TextView mLanguageByTextView;
    @BindView(R.id.progressLayout) LinearLayout mProgressLayout;
    @BindView(R.id.emptyLayout) LinearLayout mEmptyLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        String id = getIntent().getStringExtra("ID");
        if(id == null) {
            finish();
            return;
        }
        mProgressLayout.setVisibility(View.VISIBLE);
        mPresenter.getDetail(id, this);

        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    public void fetchSuccess(ChallengeDetailDTO dto) {
        mProgressLayout.setVisibility(View.GONE);
        mEmptyLayout.setVisibility(View.GONE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mDescriptionTextView.setText(Html.fromHtml(dto.getDescription(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            mDescriptionTextView.setText(Html.fromHtml(dto.getDescription()));
        }
        mCreatedAtTextView.setText(DateUtils.toDisplayDate(dto.getCreatedAt()));
        try{
            mCreatedByTextView.setText(dto.getCreatedBy().getUsername());
        }catch (NullPointerException e){
            mCreatedByTextView.setText("N/A");
        }
        try{
            mAuthoredByTextView.setText(dto.getApprovedBy().getUsername());
        }catch (NullPointerException e){
            mAuthoredByTextView.setText("N/A");
        }
        mLanguageByTextView.setText(ViewUtils.join(dto.getLanguages()));
    }

    @Override
    public void fetchFail(String message) {
        mProgressLayout.setVisibility(View.GONE);
        mEmptyLayout.setVisibility(View.VISIBLE);
    }
}

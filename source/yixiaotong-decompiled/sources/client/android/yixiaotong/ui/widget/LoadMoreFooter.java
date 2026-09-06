package client.android.yixiaotong.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LoadMoreFooter extends LinearLayout implements View.OnClickListener {
    private boolean isLoading;
    private boolean isUserBar;
    private LinearLayout mLlLoadMore;
    private TextView mLoadMoreView;
    private OnClickLoadMoreListener mOnClickLoadMoreListener;
    private ProgressBar mProgressBar;

    public interface OnClickLoadMoreListener {
        void onClick();
    }

    public void setOnClickLoadMoreListener(OnClickLoadMoreListener onClickLoadMoreListener) {
        this.mOnClickLoadMoreListener = onClickLoadMoreListener;
    }

    public void setUseProgressBar(boolean z) {
        this.isUserBar = z;
    }

    public LoadMoreFooter(Context context) {
        super(context);
        this.isUserBar = false;
        init();
    }

    public LoadMoreFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.isUserBar = false;
        init();
    }

    public LoadMoreFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isUserBar = false;
        init();
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.item_load_more_footer, this);
        this.mLoadMoreView = (TextView) findViewById(R.id.loadmore);
        this.mLlLoadMore = (LinearLayout) findViewById(R.id.ll_load_more);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        setOnClickListener(this);
    }

    public void setLoadComplete() {
        this.isLoading = false;
        this.mLoadMoreView.setVisibility(0);
        this.mLoadMoreView.setText(getResources().getString(R.string.loadmore));
        this.mProgressBar.setVisibility(8);
    }

    public void setBackGround() {
        this.mLlLoadMore.setBackgroundColor(-2105377);
    }

    public void setGone() {
        setOnClickListener(null);
        this.mLoadMoreView.setVisibility(8);
        this.mLlLoadMore.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setNoMoreData() {
        setOnClickListener(null);
        this.mLoadMoreView.setVisibility(0);
        this.isLoading = false;
        this.mLoadMoreView.setText(getResources().getString(R.string.nomoredata));
        this.mProgressBar.setVisibility(8);
    }

    public void setNoMoreData(String str) {
        setOnClickListener(null);
        this.mLoadMoreView.setVisibility(0);
        this.isLoading = false;
        this.mLoadMoreView.setText(str);
        this.mProgressBar.setVisibility(8);
    }

    public void reset() {
        setOnClickListener(this);
        setLoadComplete();
    }

    public void resetForFail() {
        setOnClickListener(this);
        this.isLoading = false;
        this.mLoadMoreView.setVisibility(0);
        this.mLoadMoreView.setText(getResources().getString(R.string.loadfail));
        this.mProgressBar.setVisibility(8);
    }

    public void loadMoreData() {
        if (!this.isLoading) {
            this.mLoadMoreView.setText(getResources().getString(R.string.loading3));
            if (this.isUserBar) {
                this.mProgressBar.setVisibility(0);
            } else {
                this.mProgressBar.setVisibility(8);
            }
        }
        this.isLoading = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.isLoading) {
            this.mLoadMoreView.setText(getResources().getString(R.string.loading3));
            if (this.isUserBar) {
                this.mProgressBar.setVisibility(0);
            } else {
                this.mProgressBar.setVisibility(8);
            }
            OnClickLoadMoreListener onClickLoadMoreListener = this.mOnClickLoadMoreListener;
            if (onClickLoadMoreListener != null) {
                onClickLoadMoreListener.onClick();
            }
        }
        this.isLoading = true;
    }
}

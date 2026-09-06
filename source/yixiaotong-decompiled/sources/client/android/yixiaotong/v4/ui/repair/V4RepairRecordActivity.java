package client.android.yixiaotong.v4.ui.repair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4RepairRecordBean;
import client.android.yixiaotong.v4.http.bean.V4RepairRecordDetailBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4RepairRecordActivity extends BaseActivity {
    private RecordsAdapter mApdater;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private RelativeLayout mRelAdd;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvDelect;
    private TextView mTvErrorTip;
    private TextView mTvFinish;
    private TextView mTvUnfinish;
    private View mVLineLeft;
    private View mVLineRefunding;
    private View mVLineRight;
    private boolean mIsEnable = true;
    private final List<V4RepairRecordDetailBean> mRecordListBeans = new ArrayList();
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private int mCurrentPage = 1;
    private State mState = State.unfinish;
    private int mStateIndex = 0;

    private enum State {
        unfinish,
        finish,
        delect
    }

    static {
        StubApp.interface11(11016);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4RepairRecordActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvUnfinish = (TextView) findViewById(R.id.tv_unfinishtext);
        this.mVLineLeft = findViewById(R.id.v_lineleft);
        this.mTvFinish = (TextView) findViewById(R.id.tv_finishtext);
        this.mVLineRight = findViewById(R.id.v_lineright);
        this.mTvDelect = (TextView) findViewById(R.id.tv_deletetext);
        this.mVLineRefunding = findViewById(R.id.v_linedelect);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mRelAdd = (RelativeLayout) findViewById(R.id.rel_add);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.doorlock_repair));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        getData(true);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4RepairRecordActivity.this.mMultiStateView.setViewState(3);
                V4RepairRecordActivity.this.getData(false);
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4RepairRecordActivity.this.mRecordListBeans.clear();
                V4RepairRecordActivity.this.mApdater.notifyDataSetChanged();
                V4RepairRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                V4RepairRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                V4RepairRecordActivity.this.getData(true);
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                V4RepairRecordActivity.this.getData(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getData(boolean z) {
        if (z) {
            this.mCurrentPage = 1;
            this.mTotalCount = 0;
        }
        if (this.mState == State.unfinish) {
            this.mStateIndex = 0;
        } else if (this.mState == State.finish) {
            this.mStateIndex = 1;
        } else if (this.mState == State.delect) {
            this.mStateIndex = 2;
        }
        getRecord();
    }

    private void initView() {
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    V4RepairRecordActivity.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    V4RepairRecordActivity.this.mSwipeRefreshLayout.setEnabled(false);
                }
                if (!V4RepairRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= V4RepairRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                V4RepairRecordActivity.this.mCurrentPage++;
                V4RepairRecordActivity.this.mTotalCount = i3;
                V4RepairRecordActivity.this.getData(false);
                V4RepairRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
    }

    private void initTitleView() {
        if (this.mState == State.unfinish) {
            this.mTvUnfinish.setTextSize(15.0f);
            this.mTvUnfinish.setTextColor(getResources().getColor(R.color.ff242933));
            this.mVLineLeft.setVisibility(0);
            this.mTvFinish.setTextSize(14.0f);
            this.mTvFinish.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineRight.setVisibility(4);
            this.mTvDelect.setTextSize(14.0f);
            this.mTvDelect.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineRefunding.setVisibility(4);
            return;
        }
        if (this.mState == State.finish) {
            this.mTvUnfinish.setTextSize(14.0f);
            this.mTvUnfinish.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineLeft.setVisibility(4);
            this.mTvFinish.setTextSize(15.0f);
            this.mTvFinish.setTextColor(getResources().getColor(R.color.ff242933));
            this.mVLineRight.setVisibility(0);
            this.mTvDelect.setTextSize(14.0f);
            this.mTvDelect.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineRefunding.setVisibility(4);
            return;
        }
        if (this.mState == State.delect) {
            this.mTvUnfinish.setTextSize(14.0f);
            this.mTvUnfinish.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineLeft.setVisibility(4);
            this.mTvFinish.setTextSize(14.0f);
            this.mTvFinish.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineRight.setVisibility(4);
            this.mTvDelect.setTextSize(15.0f);
            this.mTvDelect.setTextColor(getResources().getColor(R.color.ff242933));
            this.mVLineRefunding.setVisibility(0);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.rel_unfinish).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m538x64689c83(view);
            }
        });
        findViewById(R.id.rel_finish).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m539x57f820c4(view);
            }
        });
        findViewById(R.id.rel_delete).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m540x4b87a505(view);
            }
        });
        findViewById(R.id.rel_add).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m541x3f172946(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-repair-V4RepairRecordActivity, reason: not valid java name */
    /* synthetic */ void m538x64689c83(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mState = State.unfinish;
        initTitleView();
        getData(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-repair-V4RepairRecordActivity, reason: not valid java name */
    /* synthetic */ void m539x57f820c4(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mState = State.finish;
        initTitleView();
        getData(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-repair-V4RepairRecordActivity, reason: not valid java name */
    /* synthetic */ void m540x4b87a505(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mState = State.delect;
        initTitleView();
        getData(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v4-ui-repair-V4RepairRecordActivity, reason: not valid java name */
    /* synthetic */ void m541x3f172946(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4AddRepairActivity.launch(getActivity());
    }

    private void getRecord() {
        V4BusinessControllers.getInstance().getRepairList(getLoginAccount(), this.mStateIndex, 10, this.mCurrentPage, new Listener<V4RepairRecordBean>() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4RepairRecordActivity.this.mHasMoreData = false;
                if (V4RepairRecordActivity.this.mCurrentPage == 1) {
                    V4RepairRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    V4RepairRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    V4RepairRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                V4RepairRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4RepairRecordBean v4RepairRecordBean, Object... objArr) {
                if (V4RepairRecordActivity.this.mIsEnable) {
                    V4RepairRecordActivity.this.mMultiStateView.setViewState(0);
                    V4RepairRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (v4RepairRecordBean == null || v4RepairRecordBean.records == null) {
                        V4RepairRecordActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    if (V4RepairRecordActivity.this.mCurrentPage == 1) {
                        V4RepairRecordActivity.this.mRecordListBeans.clear();
                    }
                    V4RepairRecordActivity.this.mRecordListBeans.addAll(v4RepairRecordBean.records);
                    V4RepairRecordActivity.this.mApdater.notifyDataSetChanged();
                    if (v4RepairRecordBean.pages > v4RepairRecordBean.current) {
                        V4RepairRecordActivity.this.mHasMoreData = true;
                        V4RepairRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        V4RepairRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        V4RepairRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (v4RepairRecordBean.records.size() == 0) {
                        V4RepairRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4RepairRecordActivity.this.mIsEnable) {
                    if (V4RepairRecordActivity.this.mCurrentPage == 1) {
                        V4RepairRecordActivity.this.mMultiStateView.setViewState(1);
                        V4RepairRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        V4RepairRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    V4RepairRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    V4RepairRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }

    private class RecordsAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private RecordsAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return V4RepairRecordActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public V4RepairRecordDetailBean getItem(int i) {
            return (V4RepairRecordDetailBean) V4RepairRecordActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4RepairRecordActivity.this.getContext()).inflate(R.layout.v4_layout_repair_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final V4RepairRecordDetailBean item = getItem(i);
            viewHolder.tv_content.setText(item.repairContent);
            viewHolder.tv_time.setText("发起时间：" + item.createTime);
            viewHolder.btn_todetail.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity.RecordsAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    V4RepairDetailActivity.launch(V4RepairRecordActivity.this.getActivity(), item);
                }
            });
            return view;
        }

        class ViewHolder {
            public Button btn_todetail;
            public TextView tv_content;
            public TextView tv_time;

            public ViewHolder(View view) {
                this.tv_content = (TextView) view.findViewById(R.id.tv_content);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.btn_todetail = (Button) view.findViewById(R.id.btn_todetail);
            }
        }
    }
}

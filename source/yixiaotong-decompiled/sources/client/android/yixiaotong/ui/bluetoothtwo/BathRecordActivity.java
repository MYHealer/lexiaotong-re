package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.RecordBean;
import client.android.yixiaotong.controller.bean.RecordListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathRecordActivity extends BaseActivity {
    private BathRecordAdapter mApdater;
    private LayoutInflater mInflater;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitlebar;
    TextView mTvErrorTip;
    private int mTypeId;
    private final List<RecordBean> mRecordListBeans = new ArrayList();
    private final int mPageSize = 200;
    private int mStart = 0;
    private String mNextMonth = "0";
    private boolean mIsEnable = true;
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;

    static {
        StubApp.interface11(6488);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$608(BathRecordActivity bathRecordActivity) {
        int i = bathRecordActivity.mStart;
        bathRecordActivity.mStart = i + 1;
        return i;
    }

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    public static void launch(Activity activity, int i) {
        Intent intent = new Intent(activity, (Class<?>) BathRecordActivity.class);
        intent.putExtra("typeId", i);
        activity.startActivity(intent);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    private void initTitleBar() {
        this.mTitlebar.setTitleView("消费记录");
        this.mTitlebar.setLeftViewIsBack();
        this.mTitlebar.setLeftViewOnClickBack(this);
    }

    private void initView() {
        initFooterView();
        BathRecordAdapter bathRecordAdapter = new BathRecordAdapter();
        this.mApdater = bathRecordAdapter;
        this.mLvRecord.setAdapter((ListAdapter) bathRecordAdapter);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathRecordActivity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!BathRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= BathRecordActivity.this.mTotalCount) {
                    return;
                }
                BathRecordActivity.this.mTotalCount = i3;
                BathRecordActivity.this.initData();
                BathRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        getRecordList();
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathRecordActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BathRecordActivity.this.mMultiStateView.setViewState(3);
                BathRecordActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathRecordActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                BathRecordActivity.this.mStart = 0;
                BathRecordActivity.this.mNextMonth = "0";
                BathRecordActivity.this.mTotalCount = 0;
                BathRecordActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathRecordActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                BathRecordActivity.this.initData();
            }
        });
    }

    private void getRecordList() {
        BusinessControllers.getInstance().getRecordList(getLoginAccount(), this.mTypeId, this.mNextMonth, 0, 200, new Listener<RecordListBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BathRecordActivity.this.mHasMoreData = false;
                if (BathRecordActivity.this.mStart != 0 || BathRecordActivity.this.mSwipeRefreshLayout == null) {
                    BathRecordActivity.this.mLoadMoreFootView.loadMoreData();
                } else {
                    BathRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RecordListBean recordListBean, Object... objArr) {
                if (!BathRecordActivity.this.mIsEnable || BathRecordActivity.this.mSwipeRefreshLayout == null || BathRecordActivity.this.mMultiStateView == null || BathRecordActivity.this.mLoadMoreFootView == null) {
                    return;
                }
                BathRecordActivity.this.mMultiStateView.setViewState(0);
                BathRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                if (recordListBean != null) {
                    if (BathRecordActivity.this.mStart == 0) {
                        BathRecordActivity.this.mRecordListBeans.clear();
                        BathRecordActivity.this.mRecordListBeans.addAll(recordListBean.getSortList());
                    } else {
                        BathRecordActivity.this.mRecordListBeans.addAll(recordListBean.getSortList());
                    }
                    BathRecordActivity.this.mApdater.notifyDataSetChanged();
                    if (!"-1".equals(recordListBean.NextMonth)) {
                        BathRecordActivity.this.mHasMoreData = true;
                        BathRecordActivity.this.mNextMonth = recordListBean.NextMonth;
                        BathRecordActivity.access$608(BathRecordActivity.this);
                        BathRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        BathRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        BathRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (recordListBean.Total == 0) {
                        BathRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathRecordActivity.this.mIsEnable) {
                    if (BathRecordActivity.this.mMultiStateView != null && BathRecordActivity.this.mSwipeRefreshLayout != null) {
                        if (BathRecordActivity.this.mStart == 0) {
                            BathRecordActivity.this.mMultiStateView.setViewState(1);
                            BathRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                        } else {
                            BathRecordActivity.this.mLoadMoreFootView.resetForFail();
                        }
                        BathRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    }
                    SystemErrorTip.getInstance().showTipDialog(BathRecordActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    private class BathRecordAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private BathRecordAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return BathRecordActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public RecordBean getItem(int i) {
            return (RecordBean) BathRecordActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(BathRecordActivity.this.getContext()).inflate(R.layout.wash_record_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (i == 0) {
                viewHolder.line.setVisibility(4);
            } else {
                viewHolder.line.setVisibility(0);
            }
            final RecordBean item = getItem(i);
            viewHolder.datetime.setText(TimeUtils.formatDateTime(item.ConsumeTime));
            viewHolder.money.setText(x.A + item.ConsumeAmount);
            if (BathRecordActivity.this.mTypeId == 1) {
                viewHolder.chongzhistate.setText("洗澡-已完成");
            } else {
                viewHolder.chongzhistate.setText("用餐-已完成");
            }
            viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathRecordActivity.BathRecordAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (BathRecordActivity.this.mTypeId == 1) {
                        BathRecordDetailActivity.launch(BathRecordActivity.this.getActivity(), item.ConsumeAmount + "", TimeUtils.formatDateTime(item.ConsumeTime), item.IsOnline + "", item.OffLineTimes);
                    } else {
                        BathRecordDetailActivity.launch(BathRecordActivity.this.getActivity(), item.ConsumeAmount + "", TimeUtils.formatDateTime(item.ConsumeTime), 5);
                    }
                }
            });
            return view;
        }

        class ViewHolder {
            public TextView chongzhistate;
            public TextView datetime;
            public RelativeLayout lin;
            public View line;
            public TextView money;

            public ViewHolder(View view) {
                this.line = view.findViewById(R.id.line1);
                this.datetime = (TextView) view.findViewById(R.id.tv_datetime);
                this.money = (TextView) view.findViewById(R.id.tv_money);
                this.chongzhistate = (TextView) view.findViewById(R.id.tv_chongzhistate);
                this.lin = (RelativeLayout) view.findViewById(R.id.lin);
            }
        }
    }
}

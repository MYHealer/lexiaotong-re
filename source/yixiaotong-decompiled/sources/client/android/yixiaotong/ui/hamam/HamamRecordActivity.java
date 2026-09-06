package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.Context;
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
import client.android.yixiaotong.controller.bean.hamam.HamamRecordBean;
import client.android.yixiaotong.controller.bean.hamam.HamamRecordListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamRecordActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    private HamamRecordsAdapter mApdater;
    private LayoutInflater mInflater;
    private LoadMoreFooter mLoadMoreFootView;
    ListView mLvRecord;
    MultiStateView mMultiStateView;
    PullRefreshLayout mSwipeRefreshLayout;
    TitleBar mTitleBar;
    TextView mTvErrorTip;
    private WalletModel mWalletModel;
    private final List<HamamRecordBean> mRecordListBeans = new ArrayList();
    private int mStart = 1;
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(AVMDLDataLoader.KeyIsNetSchedulerBlockDurationMs);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$408(HamamRecordActivity hamamRecordActivity) {
        int i = hamamRecordActivity.mStart;
        hamamRecordActivity.mStart = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HamamRecordActivity.class).putExtra("extra_wallet", walletModel));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
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
        this.mTitleBar.setTitleView("浴室消费记录");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        initFooterView();
        HamamRecordsAdapter hamamRecordsAdapter = new HamamRecordsAdapter(this.mInflater, this.mRecordListBeans);
        this.mApdater = hamamRecordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) hamamRecordsAdapter);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.ui.hamam.HamamRecordActivity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!HamamRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= HamamRecordActivity.this.mTotalCount) {
                    return;
                }
                HamamRecordActivity.this.mTotalCount = i3;
                HamamRecordActivity.this.initData();
                HamamRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
        this.mLvRecord.setFooterDividersEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        getRecordList();
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamRecordActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HamamRecordActivity.this.mMultiStateView.setViewState(3);
                HamamRecordActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.hamam.HamamRecordActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                HamamRecordActivity.this.mStart = 1;
                HamamRecordActivity.this.mTotalCount = 0;
                HamamRecordActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.hamam.HamamRecordActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                HamamRecordActivity.this.initData();
            }
        });
    }

    private void getRecordList() {
        BusinessControllers.getInstance().getHamamRecordList(getLoginAccount(), this.mStart, new Listener<HamamRecordListBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                HamamRecordActivity.this.mHasMoreData = false;
                if (HamamRecordActivity.this.mStart != 1 || HamamRecordActivity.this.mSwipeRefreshLayout == null) {
                    HamamRecordActivity.this.mLoadMoreFootView.loadMoreData();
                } else {
                    HamamRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, HamamRecordListBean hamamRecordListBean, Object... objArr) {
                if (!HamamRecordActivity.this.mIsEnable || HamamRecordActivity.this.mSwipeRefreshLayout == null || HamamRecordActivity.this.mMultiStateView == null || HamamRecordActivity.this.mLoadMoreFootView == null) {
                    return;
                }
                HamamRecordActivity.this.mMultiStateView.setViewState(0);
                HamamRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                if (hamamRecordListBean != null) {
                    if (HamamRecordActivity.this.mStart == 1) {
                        HamamRecordActivity.this.mRecordListBeans.clear();
                        HamamRecordActivity.this.mRecordListBeans.addAll(hamamRecordListBean.Records);
                    } else {
                        HamamRecordActivity.this.mRecordListBeans.addAll(hamamRecordListBean.Records);
                    }
                    HamamRecordActivity.this.mApdater.notifyDataSetChanged();
                    if (hamamRecordListBean.totalPage > hamamRecordListBean.currentPage) {
                        HamamRecordActivity.this.mHasMoreData = true;
                        HamamRecordActivity.access$408(HamamRecordActivity.this);
                        HamamRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        HamamRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        HamamRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (hamamRecordListBean.totalRecord == 0) {
                        HamamRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamRecordActivity.this.mIsEnable) {
                    if (HamamRecordActivity.this.mMultiStateView != null && HamamRecordActivity.this.mSwipeRefreshLayout != null) {
                        if (HamamRecordActivity.this.mStart != 1) {
                            HamamRecordActivity.this.mLoadMoreFootView.resetForFail();
                        } else {
                            HamamRecordActivity.this.mMultiStateView.setViewState(1);
                            HamamRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                        }
                        HamamRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    }
                    SystemErrorTip.getInstance().showTipDialog(HamamRecordActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    class HamamRecordsAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<HamamRecordBean> mRecordListBeans;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public HamamRecordsAdapter(LayoutInflater layoutInflater, List<HamamRecordBean> list) {
            this.mRecordListBeans = list;
            this.mInflater = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public HamamRecordBean getItem(int i) {
            return this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view != null) {
                viewHolder = (ViewHolder) view.getTag();
            } else {
                view = this.mInflater.inflate(R.layout.wash_record_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            }
            final HamamRecordBean hamamRecordBean = this.mRecordListBeans.get(i);
            if (i == 0) {
                viewHolder.line.setVisibility(4);
            } else {
                viewHolder.line.setVisibility(0);
            }
            if (StringUtils.isNotEmpty(hamamRecordBean.pay)) {
                viewHolder.money.setText(x.A + DecimalUtil.twoDecimal(DecimalUtil.divide(hamamRecordBean.pay + "", "100")));
            }
            final String strTwoDecimal = DecimalUtil.twoDecimal(DecimalUtil.divide(hamamRecordBean.i42 + "", AdnConfig.b.hnadsa));
            if (hamamRecordBean.sysflag == 1) {
                viewHolder.chongzhistate.setText("公共浴室-未结算");
                if (StringUtils.isNotEmpty(hamamRecordBean.posDatetime)) {
                    viewHolder.datetime.setText(TimeUtils.formatDateTime(Long.parseLong(hamamRecordBean.posDatetime)));
                }
            } else if (hamamRecordBean.sysflag == 2) {
                viewHolder.chongzhistate.setText("公共浴室-已结算");
                if (StringUtils.isNotEmpty(hamamRecordBean.payDatetime)) {
                    viewHolder.datetime.setText(TimeUtils.formatDateTime(Long.parseLong(hamamRecordBean.payDatetime)));
                }
            } else {
                viewHolder.chongzhistate.setText("公共浴室-未知");
            }
            viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamRecordActivity.HamamRecordsAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    HamamRecordDetailActivity.launch(HamamRecordActivity.this.getActivity(), viewHolder.money.getText().toString(), viewHolder.datetime.getText().toString(), hamamRecordBean.orderid, strTwoDecimal, hamamRecordBean.sysflag);
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

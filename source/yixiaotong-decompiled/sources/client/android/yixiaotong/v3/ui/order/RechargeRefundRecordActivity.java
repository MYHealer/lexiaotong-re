package client.android.yixiaotong.v3.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.bean.order.BuyClubCardDetailBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCradRecordBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RechargeRefundRecordActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private RecordsAdapter mApdater;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private TextView mTvRecharge;
    private TextView mTvRefund;
    private View mVLineLeft;
    private View mVLineRight;
    private boolean mIsEnable = true;
    private final List<Object> mRecordListBeans = new ArrayList();
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private int mCurrentPage = 1;
    private boolean mIsRechargeOrder = true;

    static {
        StubApp.interface11(10092);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RechargeRefundRecordActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvRecharge = (TextView) findViewById(R.id.tv_rechargetext);
        this.mVLineLeft = findViewById(R.id.v_lineleft);
        this.mTvRefund = (TextView) findViewById(R.id.tv_refundtext);
        this.mVLineRight = findViewById(R.id.v_lineright);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.rechargerefundorder));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.RechargeRefundRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RechargeRefundRecordActivity.this.mMultiStateView.setViewState(3);
                if (RechargeRefundRecordActivity.this.mIsRechargeOrder) {
                    RechargeRefundRecordActivity.this.getRechargeRecord();
                } else {
                    RechargeRefundRecordActivity.this.getRefundRecord();
                }
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.order.RechargeRefundRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RechargeRefundRecordActivity.this.mRecordListBeans.clear();
                RechargeRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                RechargeRefundRecordActivity.this.getInitRecord();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.order.RechargeRefundRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                if (RechargeRefundRecordActivity.this.mIsRechargeOrder) {
                    RechargeRefundRecordActivity.this.getRechargeRecord();
                } else {
                    RechargeRefundRecordActivity.this.getRefundRecord();
                }
            }
        });
    }

    private void initView() {
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.order.RechargeRefundRecordActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!RechargeRefundRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= RechargeRefundRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                RechargeRefundRecordActivity.this.mCurrentPage++;
                RechargeRefundRecordActivity.this.mTotalCount = i3;
                if (RechargeRefundRecordActivity.this.mIsRechargeOrder) {
                    RechargeRefundRecordActivity.this.getRechargeRecord();
                } else {
                    RechargeRefundRecordActivity.this.getRefundRecord();
                }
                RechargeRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
    }

    private void initTitleView() {
        if (this.mIsRechargeOrder) {
            this.mTvRecharge.setTextSize(15.0f);
            this.mTvRecharge.setTextColor(getResources().getColor(R.color.ff242933));
            this.mVLineLeft.setVisibility(0);
            this.mTvRefund.setTextSize(14.0f);
            this.mTvRefund.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineRight.setVisibility(4);
            return;
        }
        this.mTvRecharge.setTextSize(14.0f);
        this.mTvRecharge.setTextColor(getResources().getColor(R.color.ffa1a6b3));
        this.mVLineLeft.setVisibility(4);
        this.mTvRefund.setTextSize(15.0f);
        this.mTvRefund.setTextColor(getResources().getColor(R.color.ff242933));
        this.mVLineRight.setVisibility(0);
    }

    private void initClickListeners() {
        findViewById(R.id.rel_recharge).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.RechargeRefundRecordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m393x7c3c6c45(view);
            }
        });
        findViewById(R.id.rel_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.RechargeRefundRecordActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m394x18aa68a4(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-order-RechargeRefundRecordActivity, reason: not valid java name */
    /* synthetic */ void m393x7c3c6c45(View view) {
        updateRecordDisplay(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-order-RechargeRefundRecordActivity, reason: not valid java name */
    /* synthetic */ void m394x18aa68a4(View view) {
        updateRecordDisplay(false);
    }

    private void updateRecordDisplay(boolean z) {
        this.mIsRechargeOrder = z;
        initTitleView();
        getInitRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInitRecord() {
        this.mCurrentPage = 1;
        this.mTotalCount = 0;
        if (this.mIsRechargeOrder) {
            getRechargeRecord();
        } else {
            getRefundRecord();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRechargeRecord() {
        V3BusinessControllers.getInstance().getWalletOrderList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", 5, this.mCurrentPage, new Listener<BuyClubCradRecordBean>() { // from class: client.android.yixiaotong.v3.ui.order.RechargeRefundRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                RechargeRefundRecordActivity.this.mHasMoreData = false;
                if (RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                    RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    RechargeRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                RechargeRefundRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BuyClubCradRecordBean buyClubCradRecordBean, Object... objArr) {
                if (RechargeRefundRecordActivity.this.mIsEnable && RechargeRefundRecordActivity.this.mIsRechargeOrder) {
                    RechargeRefundRecordActivity.this.mMultiStateView.setViewState(0);
                    RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (buyClubCradRecordBean == null || buyClubCradRecordBean.records == null) {
                        RechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    if (RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                        RechargeRefundRecordActivity.this.mRecordListBeans.clear();
                    }
                    RechargeRefundRecordActivity.this.mRecordListBeans.addAll(buyClubCradRecordBean.records);
                    RechargeRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                    if (buyClubCradRecordBean.totalPage > buyClubCradRecordBean.currentPage) {
                        RechargeRefundRecordActivity.this.mHasMoreData = true;
                        RechargeRefundRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        RechargeRefundRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (buyClubCradRecordBean.records.size() == 0) {
                        RechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RechargeRefundRecordActivity.this.mIsEnable) {
                    if (RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                        RechargeRefundRecordActivity.this.mMultiStateView.setViewState(1);
                        RechargeRefundRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(RechargeRefundRecordActivity.this.getContext()));
                    } else {
                        RechargeRefundRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    RechargeRefundRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRefundRecord() {
        V3BusinessControllers.getInstance().getWalletRefundOrderList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", 5, this.mCurrentPage, 1, new Listener<BuyClubCradRecordBean>() { // from class: client.android.yixiaotong.v3.ui.order.RechargeRefundRecordActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                RechargeRefundRecordActivity.this.mHasMoreData = false;
                if (RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                    RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    RechargeRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                RechargeRefundRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BuyClubCradRecordBean buyClubCradRecordBean, Object... objArr) {
                if (!RechargeRefundRecordActivity.this.mIsEnable || RechargeRefundRecordActivity.this.mIsRechargeOrder) {
                    return;
                }
                RechargeRefundRecordActivity.this.mMultiStateView.setViewState(0);
                RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                if (buyClubCradRecordBean == null || buyClubCradRecordBean.records == null) {
                    RechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                    return;
                }
                if (RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                    RechargeRefundRecordActivity.this.mRecordListBeans.clear();
                }
                RechargeRefundRecordActivity.this.mRecordListBeans.addAll(buyClubCradRecordBean.records);
                RechargeRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                if (buyClubCradRecordBean.totalPage > buyClubCradRecordBean.currentPage) {
                    RechargeRefundRecordActivity.this.mHasMoreData = true;
                    RechargeRefundRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                    RechargeRefundRecordActivity.this.mLoadMoreFootView.reset();
                } else {
                    RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                }
                if (buyClubCradRecordBean.records.size() == 0) {
                    RechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RechargeRefundRecordActivity.this.mIsEnable) {
                    if (RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                        RechargeRefundRecordActivity.this.mMultiStateView.setViewState(1);
                        RechargeRefundRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(RechargeRefundRecordActivity.this.getContext()));
                    } else {
                        RechargeRefundRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    RechargeRefundRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mIsRechargeOrder) {
        } else {
            WalletRefundDetailActivity.launch(getActivity(), (BuyClubCardDetailBean) this.mApdater.getItem(i));
        }
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
            return RechargeRefundRecordActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return RechargeRefundRecordActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(RechargeRefundRecordActivity.this.getContext()).inflate(R.layout.layout_rechargerefund_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            BuyClubCardDetailBean buyClubCardDetailBean = (BuyClubCardDetailBean) getItem(i);
            if (RechargeRefundRecordActivity.this.mIsRechargeOrder) {
                viewHolder.tv_title.setText(RechargeRefundRecordActivity.this.getString(R.string.rechargecenter2));
                viewHolder.tv_money.setTextColor(RechargeRefundRecordActivity.this.getResources().getColor(R.color.ff6f32fd));
                viewHolder.tv_time.setText(buyClubCardDetailBean.payDateTime);
            } else {
                viewHolder.tv_title.setText(RechargeRefundRecordActivity.this.getString(R.string.walletrefund));
                viewHolder.tv_money.setTextColor(RechargeRefundRecordActivity.this.getResources().getColor(R.color.ff242933));
                viewHolder.tv_time.setText(buyClubCardDetailBean.createDateTime);
            }
            viewHolder.tv_money.setText("¥ " + DecimalUtil.divide(buyClubCardDetailBean.price + "", "100"));
            return view;
        }

        class ViewHolder {
            public TextView tv_money;
            public TextView tv_state;
            public TextView tv_time;
            public TextView tv_title;

            public ViewHolder(View view) {
                this.tv_title = (TextView) view.findViewById(R.id.tv_title);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.tv_state = (TextView) view.findViewById(R.id.tv_state);
            }
        }
    }
}

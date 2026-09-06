package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ElecRechargeRecordBean;
import client.android.yixiaotong.v4.http.bean.V4ElecRechargeRecordDetailBean;
import client.android.yixiaotong.v4.http.bean.V4RefundDetailBean;
import client.android.yixiaotong.v4.http.bean.V4RefundRecordBean;
import client.android.yixiaotong.v4.ui.adapter.V4RechargeRecordAdapter;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ElecMeterRechargeRecordActivity extends BaseActivity {
    private static final String TAG = "V4ElecMeterRechargeRecordActivity";
    private String mDeviceNo;
    private LoadMoreFooter mLoadMoreFootView;
    ListView mLvRecord;
    MultiStateView mMultiStateView;
    private int mProductId;
    PullRefreshLayout mPullRefreshLayout;
    private V4RechargeRecordAdapter mRechargeRecordAdapter;
    TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private TextView mTvRecharge;
    private TextView mTvRefund;
    private TextView mTvRefunding;
    private View mVLineLeft;
    private View mVLineRefunding;
    private View mVLineRight;
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private boolean mIsEnable = true;
    private int mSelectIndex = 0;
    private int mPageIndex = 1;
    public State mState = State.recharge;
    private List<V4RefundDetailBean> mElecRechargeRecordBeans = new ArrayList();

    public enum State {
        recharge,
        refund,
        refunding
    }

    static {
        StubApp.interface11(10773);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ElecMeterRechargeRecordActivity.class).putExtra(AmmeterWalletDetailActivity.EXTRA_DEVICENO, str).putExtra("productid", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvRecharge = (TextView) findViewById(R.id.tv_rechargetext);
        this.mVLineLeft = findViewById(R.id.v_lineleft);
        this.mTvRefund = (TextView) findViewById(R.id.tv_refundtext);
        this.mVLineRight = findViewById(R.id.v_lineright);
        this.mTvRefunding = (TextView) findViewById(R.id.tv_refundingtext);
        this.mVLineRefunding = findViewById(R.id.v_linerefunding);
        this.mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.pullrefreshlayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setTitleView(getString(R.string.rechargerefundorder));
    }

    private void initTitleView() {
        if (this.mState == State.recharge) {
            this.mTvRecharge.setTextSize(15.0f);
            this.mTvRecharge.setTextColor(getResources().getColor(R.color.ff242933));
            this.mVLineLeft.setVisibility(0);
            this.mTvRefund.setTextSize(14.0f);
            this.mTvRefund.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineRight.setVisibility(4);
            this.mTvRefunding.setTextSize(14.0f);
            this.mTvRefunding.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineRefunding.setVisibility(4);
            return;
        }
        if (this.mState == State.refund) {
            this.mTvRecharge.setTextSize(14.0f);
            this.mTvRecharge.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineLeft.setVisibility(4);
            this.mTvRefund.setTextSize(15.0f);
            this.mTvRefund.setTextColor(getResources().getColor(R.color.ff242933));
            this.mVLineRight.setVisibility(0);
            this.mTvRefunding.setTextSize(14.0f);
            this.mTvRefunding.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineRefunding.setVisibility(4);
            return;
        }
        if (this.mState == State.refunding) {
            this.mTvRecharge.setTextSize(14.0f);
            this.mTvRecharge.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineLeft.setVisibility(4);
            this.mTvRefund.setTextSize(14.0f);
            this.mTvRefund.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mVLineRight.setVisibility(4);
            this.mTvRefunding.setTextSize(15.0f);
            this.mTvRefunding.setTextColor(getResources().getColor(R.color.ff242933));
            this.mVLineRefunding.setVisibility(0);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.rel_recharge).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m490xff3d14ec(view);
            }
        });
        findViewById(R.id.rel_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m491x61982bcb(view);
            }
        });
        findViewById(R.id.rel_refunding).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m492xc3f342aa(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-app-electricitymeter-V4ElecMeterRechargeRecordActivity, reason: not valid java name */
    /* synthetic */ void m490xff3d14ec(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mState = State.recharge;
        initTitleView();
        getData(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-app-electricitymeter-V4ElecMeterRechargeRecordActivity, reason: not valid java name */
    /* synthetic */ void m491x61982bcb(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mState = State.refund;
        initTitleView();
        getData(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-app-electricitymeter-V4ElecMeterRechargeRecordActivity, reason: not valid java name */
    /* synthetic */ void m492xc3f342aa(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mState = State.refunding;
        initTitleView();
        getData(true);
    }

    private void initView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(3);
                V4ElecMeterRechargeRecordActivity.this.getData(false);
            }
        });
        this.mPullRefreshLayout.setRefreshing(false);
        this.mPullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4ElecMeterRechargeRecordActivity.this.mPageIndex = 1;
                V4ElecMeterRechargeRecordActivity.this.mTotalCount = 0;
                V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.clear();
                V4ElecMeterRechargeRecordActivity.this.mRechargeRecordAdapter.notifyDataSetChanged();
                V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(true);
                V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                V4ElecMeterRechargeRecordActivity.this.getData(true);
            }
        });
        V4RechargeRecordAdapter v4RechargeRecordAdapter = new V4RechargeRecordAdapter(getActivity(), this.mProductId, new V4RechargeRecordAdapter.OnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity.3
            @Override // client.android.yixiaotong.v4.ui.adapter.V4RechargeRecordAdapter.OnItemClickListener
            public void onItemClick(int i) {
                if (i < V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.size()) {
                    V4ElecMeterRechargeRecordActivity.this.mSelectIndex = i;
                    if (V4ElecMeterRechargeRecordActivity.this.mState == State.recharge) {
                        V4RefundDetailBean v4RefundDetailBean = (V4RefundDetailBean) V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.get(V4ElecMeterRechargeRecordActivity.this.mSelectIndex);
                        V4ElecRechargeRecordDetailBean v4ElecRechargeRecordDetailBean = new V4ElecRechargeRecordDetailBean();
                        v4ElecRechargeRecordDetailBean.createTime = v4RefundDetailBean.createTime;
                        v4ElecRechargeRecordDetailBean.amount = v4RefundDetailBean.amount;
                        v4ElecRechargeRecordDetailBean.statusName = v4RefundDetailBean.statusName;
                        v4ElecRechargeRecordDetailBean.address = v4RefundDetailBean.address;
                        v4ElecRechargeRecordDetailBean.mac = v4RefundDetailBean.mac;
                        v4ElecRechargeRecordDetailBean.orderId = v4RefundDetailBean.orderId;
                        v4ElecRechargeRecordDetailBean.payMentName = v4RefundDetailBean.payMentName;
                        v4ElecRechargeRecordDetailBean.rechargeId = v4RefundDetailBean.rechargeId;
                        V4ElecMeterRecordDetailActivity.launch(V4ElecMeterRechargeRecordActivity.this.getActivity(), v4ElecRechargeRecordDetailBean);
                        return;
                    }
                    if (V4ElecMeterRechargeRecordActivity.this.mState == State.refund || V4ElecMeterRechargeRecordActivity.this.mState == State.refunding) {
                        V4ElecMeterRecordDetailActivity.launchRefund(V4ElecMeterRechargeRecordActivity.this.getActivity(), (V4RefundDetailBean) V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.get(V4ElecMeterRechargeRecordActivity.this.mSelectIndex));
                    }
                }
            }
        });
        this.mRechargeRecordAdapter = v4RechargeRecordAdapter;
        this.mLvRecord.setAdapter((ListAdapter) v4RechargeRecordAdapter);
        this.mLvRecord.setOnItemClickListener(this.mRechargeRecordAdapter);
        this.mRechargeRecordAdapter.setData(this.mElecRechargeRecordBeans, this.mState);
        this.mRechargeRecordAdapter.notifyDataSetChanged();
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setEnabled(true);
                } else {
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setEnabled(false);
                }
                if (!V4ElecMeterRechargeRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= V4ElecMeterRechargeRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                V4ElecMeterRechargeRecordActivity.this.mPageIndex++;
                V4ElecMeterRechargeRecordActivity.this.mTotalCount = i3;
                V4ElecMeterRechargeRecordActivity.this.getData(false);
                V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity.5
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                V4ElecMeterRechargeRecordActivity.this.getData(false);
            }
        });
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

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getData(boolean z) {
        if (z) {
            this.mPageIndex = 1;
            this.mTotalCount = 0;
        }
        if (this.mState == State.recharge) {
            getRecord();
        } else if (this.mState == State.refund) {
            getRefundRecord();
        } else if (this.mState == State.refunding) {
            getRefundingRecord();
        }
    }

    private void getRefundRecord() {
        V4BusinessControllers.getInstance().getRefundList(getLoginAccount(), 2, this.mProductId, new Listener<V4RefundRecordBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4ElecMeterRechargeRecordActivity.this.mHasMoreData = false;
                if (V4ElecMeterRechargeRecordActivity.this.mPageIndex != 1) {
                    V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.loadMoreData();
                } else {
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(true);
                    V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                }
                V4ElecMeterRechargeRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4RefundRecordBean v4RefundRecordBean, Object... objArr) {
                if (V4ElecMeterRechargeRecordActivity.this.mIsEnable && V4ElecMeterRechargeRecordActivity.this.mState == State.refund) {
                    V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(0);
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                    if (v4RefundRecordBean != null && v4RefundRecordBean.records != null) {
                        if (V4ElecMeterRechargeRecordActivity.this.mPageIndex == 1) {
                            V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.clear();
                        }
                        V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.addAll(v4RefundRecordBean.records);
                        V4ElecMeterRechargeRecordActivity.this.mRechargeRecordAdapter.setData(V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans, V4ElecMeterRechargeRecordActivity.this.mState);
                        V4ElecMeterRechargeRecordActivity.this.mRechargeRecordAdapter.notifyDataSetChanged();
                        if (v4RefundRecordBean.pages > v4RefundRecordBean.current) {
                            V4ElecMeterRechargeRecordActivity.this.mHasMoreData = true;
                            V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                            V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.reset();
                        } else {
                            V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        }
                        if (v4RefundRecordBean.records.size() == 0) {
                            V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(2);
                            return;
                        }
                        return;
                    }
                    V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4ElecMeterRechargeRecordActivity.this.mIsEnable) {
                    if (V4ElecMeterRechargeRecordActivity.this.mPageIndex != 1) {
                        V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.resetForFail();
                    } else {
                        V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(1);
                        V4ElecMeterRechargeRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")");
                    }
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                    V4ElecMeterRechargeRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getRefundingRecord() {
        V4BusinessControllers.getInstance().getWaitRefundList(getLoginAccount(), 2, this.mProductId, new Listener<V4RefundDetailBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4ElecMeterRechargeRecordActivity.this.mHasMoreData = false;
                if (V4ElecMeterRechargeRecordActivity.this.mPageIndex != 1) {
                    V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.loadMoreData();
                } else {
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(true);
                    V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                }
                V4ElecMeterRechargeRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4RefundDetailBean v4RefundDetailBean, Object... objArr) {
                if (V4ElecMeterRechargeRecordActivity.this.mIsEnable && V4ElecMeterRechargeRecordActivity.this.mState == State.refunding) {
                    V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(0);
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                    if (v4RefundDetailBean != null) {
                        if (V4ElecMeterRechargeRecordActivity.this.mPageIndex == 1) {
                            V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.clear();
                        }
                        V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.add(v4RefundDetailBean);
                        V4ElecMeterRechargeRecordActivity.this.mRechargeRecordAdapter.setData(V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans, V4ElecMeterRechargeRecordActivity.this.mState);
                        V4ElecMeterRechargeRecordActivity.this.mRechargeRecordAdapter.notifyDataSetChanged();
                        V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        return;
                    }
                    V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4ElecMeterRechargeRecordActivity.this.mIsEnable) {
                    if (V4ElecMeterRechargeRecordActivity.this.mPageIndex != 1) {
                        V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.resetForFail();
                    } else {
                        V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(1);
                        V4ElecMeterRechargeRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")");
                    }
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                    V4ElecMeterRechargeRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getRecord() {
        V4BusinessControllers.getInstance().getElecMeterRechargeRecord(getLoginAccount(), this.mPageIndex, this.mDeviceNo, new Listener<V4ElecRechargeRecordBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                V4ElecMeterRechargeRecordActivity.this.mHasMoreData = false;
                if (V4ElecMeterRechargeRecordActivity.this.mPageIndex != 1) {
                    V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.loadMoreData();
                } else {
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(true);
                    V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                }
                V4ElecMeterRechargeRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ElecRechargeRecordBean v4ElecRechargeRecordBean, Object... objArr) {
                super.onComplete(controller, v4ElecRechargeRecordBean, objArr);
                if (V4ElecMeterRechargeRecordActivity.this.mIsEnable) {
                    V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(0);
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                    LogUtil.e(V4ElecMeterRechargeRecordActivity.TAG, "getMetersTrend:" + v4ElecRechargeRecordBean.records.size());
                    if (V4ElecMeterRechargeRecordActivity.this.mPageIndex == 1) {
                        V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.clear();
                    }
                    for (V4ElecRechargeRecordDetailBean v4ElecRechargeRecordDetailBean : v4ElecRechargeRecordBean.records) {
                        V4RefundDetailBean v4RefundDetailBean = new V4RefundDetailBean();
                        v4RefundDetailBean.createTime = v4ElecRechargeRecordDetailBean.createTime;
                        v4RefundDetailBean.amount = v4ElecRechargeRecordDetailBean.amount;
                        v4RefundDetailBean.statusName = v4ElecRechargeRecordDetailBean.statusName;
                        v4RefundDetailBean.address = v4ElecRechargeRecordDetailBean.address;
                        v4RefundDetailBean.mac = v4ElecRechargeRecordDetailBean.mac;
                        v4RefundDetailBean.orderId = v4ElecRechargeRecordDetailBean.orderId;
                        v4RefundDetailBean.payMentName = v4ElecRechargeRecordDetailBean.payMentName;
                        v4RefundDetailBean.rechargeId = v4ElecRechargeRecordDetailBean.rechargeId;
                        V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.add(v4RefundDetailBean);
                    }
                    V4ElecMeterRechargeRecordActivity.this.mRechargeRecordAdapter.setData(V4ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans, V4ElecMeterRechargeRecordActivity.this.mState);
                    V4ElecMeterRechargeRecordActivity.this.mRechargeRecordAdapter.notifyDataSetChanged();
                    if (v4ElecRechargeRecordBean.pages > v4ElecRechargeRecordBean.current) {
                        V4ElecMeterRechargeRecordActivity.this.mHasMoreData = true;
                        V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (v4ElecRechargeRecordBean.records.size() == 0) {
                        V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4ElecMeterRechargeRecordActivity.this.mIsEnable) {
                    if (V4ElecMeterRechargeRecordActivity.this.mPageIndex != 1) {
                        V4ElecMeterRechargeRecordActivity.this.mLoadMoreFootView.resetForFail();
                    } else {
                        V4ElecMeterRechargeRecordActivity.this.mMultiStateView.setViewState(1);
                        V4ElecMeterRechargeRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    }
                    V4ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                    V4ElecMeterRechargeRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }
}

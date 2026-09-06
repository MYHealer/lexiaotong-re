package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

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
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCardDetailBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCradRecordBean;
import client.android.yixiaotong.v3.bean.order.CouponBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PrepaymentRecordActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "PrepaymentRecordActivity";
    private RecordsAdapter mApdater;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    protected PrepaymentDeviceInfoBean mPrepaymentDeviceInfoBean;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvButie;
    private TextView mTvErrorTip;
    private TextView mTvRecharge;
    private TextView mTvRefund;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private View mVLineBuTie;
    private View mVLineRechange;
    private View mVLineRefund;
    private boolean mIsEnable = true;
    private final List<Object> mRecordListBeans = new ArrayList();
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private int mCurrentPage = 1;
    private int mState = 1;
    private boolean mIsFromErrorOrDetail = false;
    private boolean mIsLoading = false;

    static {
        StubApp.interface11(9410);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, TypeInfoBaseInfoBean typeInfoBaseInfoBean, PrepaymentDeviceInfoBean prepaymentDeviceInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) PrepaymentRecordActivity.class).putExtra("typeinfobean", typeInfoBaseInfoBean).putExtra("deviceinfo", prepaymentDeviceInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvRecharge = (TextView) findViewById(R.id.tv_rechargetext);
        this.mVLineRechange = findViewById(R.id.v_linerechange);
        this.mTvButie = (TextView) findViewById(R.id.tv_butietext);
        this.mVLineBuTie = findViewById(R.id.v_linebutie);
        this.mTvRefund = (TextView) findViewById(R.id.tv_refundtext);
        this.mVLineRefund = findViewById(R.id.v_linerefund);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.order));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BluetoothControlUtil.getInstance().disconnect();
        if (this.mIsFromErrorOrDetail) {
            return;
        }
        getInitRecord();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        this.mIsLoading = false;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrepaymentRecordActivity.this.mMultiStateView.setViewState(3);
                PrepaymentRecordActivity.this.getRecord();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                PrepaymentRecordActivity.this.mRecordListBeans.clear();
                PrepaymentRecordActivity.this.mApdater.notifyDataSetChanged();
                PrepaymentRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                PrepaymentRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                PrepaymentRecordActivity.this.getInitRecord();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                PrepaymentRecordActivity.this.getRecord();
            }
        });
    }

    private void initView() {
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRecordActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    PrepaymentRecordActivity.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    PrepaymentRecordActivity.this.mSwipeRefreshLayout.setEnabled(false);
                }
                LogUtil.e(PrepaymentRecordActivity.TAG, "onScroll:" + PrepaymentRecordActivity.this.mHasMoreData + PPSLabelView.Code + i + PPSLabelView.Code + i2 + PPSLabelView.Code + i3 + "  " + PrepaymentRecordActivity.this.mTotalCount + "  " + i2);
                if (!PrepaymentRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= PrepaymentRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                PrepaymentRecordActivity.this.mCurrentPage++;
                PrepaymentRecordActivity.this.mTotalCount = i3;
                PrepaymentRecordActivity.this.getRecord();
                PrepaymentRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
    }

    private void initTitleView() {
        int i = this.mState;
        if (i == 1) {
            this.mTvRecharge.setTextColor(getResources().getColor(R.color.ff0289fe));
            this.mVLineRechange.setVisibility(0);
            this.mTvButie.setTextColor(getResources().getColor(R.color.ff3d3d3d));
            this.mVLineBuTie.setVisibility(4);
            this.mTvRefund.setTextColor(getResources().getColor(R.color.ff3d3d3d));
            this.mVLineRefund.setVisibility(4);
            return;
        }
        if (i == 2) {
            this.mTvRecharge.setTextColor(getResources().getColor(R.color.ff3d3d3d));
            this.mVLineRechange.setVisibility(4);
            this.mTvButie.setTextColor(getResources().getColor(R.color.ff0289fe));
            this.mVLineBuTie.setVisibility(0);
            this.mTvRefund.setTextColor(getResources().getColor(R.color.ff3d3d3d));
            this.mVLineRefund.setVisibility(4);
            return;
        }
        if (i == 3) {
            this.mTvRecharge.setTextColor(getResources().getColor(R.color.ff3d3d3d));
            this.mVLineRechange.setVisibility(4);
            this.mTvButie.setTextColor(getResources().getColor(R.color.ff3d3d3d));
            this.mVLineBuTie.setVisibility(4);
            this.mTvRefund.setTextColor(getResources().getColor(R.color.ff0289fe));
            this.mVLineRefund.setVisibility(0);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.rel_recharge).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRecordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m285x800d2503(view);
            }
        });
        findViewById(R.id.rel_butie).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRecordActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m286x5e008ae2(view);
            }
        });
        findViewById(R.id.rel_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRecordActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m287x3bf3f0c1(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentRecordActivity, reason: not valid java name */
    /* synthetic */ void m285x800d2503(View view) {
        if (shouldHandleClick()) {
            this.mState = 1;
            handleStateChange();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentRecordActivity, reason: not valid java name */
    /* synthetic */ void m286x5e008ae2(View view) {
        if (shouldHandleClick()) {
            this.mState = 2;
            handleStateChange();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentRecordActivity, reason: not valid java name */
    /* synthetic */ void m287x3bf3f0c1(View view) {
        if (shouldHandleClick()) {
            this.mState = 3;
            handleStateChange();
        }
    }

    private boolean shouldHandleClick() {
        return (ClickUtil.isFastDoubleClick() || this.mIsLoading) ? false : true;
    }

    private void handleStateChange() {
        initTitleView();
        getInitRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInitRecord() {
        this.mIsFromErrorOrDetail = false;
        this.mCurrentPage = 1;
        this.mTotalCount = 0;
        this.mIsLoading = true;
        int i = this.mState;
        if (i == 1) {
            getRechargeRecord();
        } else if (i == 2) {
            getRedPackageRecord();
        } else if (i == 3) {
            getRefundRecord();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecord() {
        this.mIsFromErrorOrDetail = false;
        this.mIsLoading = true;
        int i = this.mState;
        if (i == 1) {
            getRechargeRecord();
        } else if (i == 2) {
            getRedPackageRecord();
        } else if (i == 3) {
            getRefundRecord();
        }
    }

    private void getRechargeRecord() {
        V3BusinessControllers.getInstance().getPrepaymentRechargeOrderList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mPrepaymentDeviceInfoBean.machineId, this.mCurrentPage, new Listener<BuyClubCradRecordBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                PrepaymentRecordActivity.this.mHasMoreData = false;
                if (PrepaymentRecordActivity.this.mCurrentPage == 1) {
                    PrepaymentRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    PrepaymentRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    PrepaymentRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                PrepaymentRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BuyClubCradRecordBean buyClubCradRecordBean, Object... objArr) {
                if (PrepaymentRecordActivity.this.mIsEnable && PrepaymentRecordActivity.this.mState == 1) {
                    PrepaymentRecordActivity.this.mIsLoading = false;
                    PrepaymentRecordActivity.this.mMultiStateView.setViewState(0);
                    PrepaymentRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (buyClubCradRecordBean == null || buyClubCradRecordBean.records == null) {
                        PrepaymentRecordActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    if (PrepaymentRecordActivity.this.mCurrentPage == 1) {
                        PrepaymentRecordActivity.this.mRecordListBeans.clear();
                    }
                    PrepaymentRecordActivity.this.mRecordListBeans.addAll(buyClubCradRecordBean.records);
                    PrepaymentRecordActivity.this.mApdater.notifyDataSetChanged();
                    if (buyClubCradRecordBean.totalPage > buyClubCradRecordBean.currentPage) {
                        PrepaymentRecordActivity.this.mHasMoreData = true;
                        PrepaymentRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        PrepaymentRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        PrepaymentRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (buyClubCradRecordBean.records.size() == 0) {
                        PrepaymentRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentRecordActivity.this.mIsEnable && PrepaymentRecordActivity.this.mState == 1) {
                    if (PrepaymentRecordActivity.this.mCurrentPage == 1) {
                        PrepaymentRecordActivity.this.mMultiStateView.setViewState(1);
                        PrepaymentRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(PrepaymentRecordActivity.this.getContext()));
                    } else {
                        PrepaymentRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    PrepaymentRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    PrepaymentRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getRedPackageRecord() {
        V3BusinessControllers.getInstance().getCouponList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, 3, 5, 21, 2, this.mPrepaymentDeviceInfoBean.machineId, UserInfoUtilControl.getInstance().getStudentId(), new Listener<List<CouponBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRecordActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                PrepaymentRecordActivity.this.mHasMoreData = false;
                PrepaymentRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                PrepaymentRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                PrepaymentRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<CouponBean> list, Object... objArr) {
                if (PrepaymentRecordActivity.this.mIsEnable && PrepaymentRecordActivity.this.mState == 2) {
                    PrepaymentRecordActivity.this.mIsLoading = false;
                    PrepaymentRecordActivity.this.mMultiStateView.setViewState(0);
                    PrepaymentRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list != null) {
                        PrepaymentRecordActivity.this.mRecordListBeans.clear();
                        PrepaymentRecordActivity.this.mRecordListBeans.addAll(list);
                        PrepaymentRecordActivity.this.mApdater.notifyDataSetChanged();
                        PrepaymentRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        if (list.size() == 0) {
                            PrepaymentRecordActivity.this.mMultiStateView.setViewState(2);
                            return;
                        }
                        return;
                    }
                    PrepaymentRecordActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentRecordActivity.this.mIsEnable && PrepaymentRecordActivity.this.mState == 2) {
                    PrepaymentRecordActivity.this.mMultiStateView.setViewState(1);
                    PrepaymentRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(PrepaymentRecordActivity.this.getContext()));
                    PrepaymentRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    PrepaymentRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getRefundRecord() {
        V3BusinessControllers.getInstance().getPrepaymentRefundOrderList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mPrepaymentDeviceInfoBean.machineId, this.mCurrentPage, new Listener<BuyClubCradRecordBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRecordActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                PrepaymentRecordActivity.this.mHasMoreData = false;
                if (PrepaymentRecordActivity.this.mCurrentPage == 1) {
                    PrepaymentRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    PrepaymentRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    PrepaymentRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                PrepaymentRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BuyClubCradRecordBean buyClubCradRecordBean, Object... objArr) {
                if (PrepaymentRecordActivity.this.mIsEnable && PrepaymentRecordActivity.this.mState == 3) {
                    PrepaymentRecordActivity.this.mIsLoading = false;
                    PrepaymentRecordActivity.this.mMultiStateView.setViewState(0);
                    PrepaymentRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (buyClubCradRecordBean == null || buyClubCradRecordBean.records == null) {
                        PrepaymentRecordActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    if (PrepaymentRecordActivity.this.mCurrentPage == 1) {
                        PrepaymentRecordActivity.this.mRecordListBeans.clear();
                    }
                    PrepaymentRecordActivity.this.mRecordListBeans.addAll(buyClubCradRecordBean.records);
                    PrepaymentRecordActivity.this.mApdater.notifyDataSetChanged();
                    if (buyClubCradRecordBean.totalPage > buyClubCradRecordBean.currentPage) {
                        PrepaymentRecordActivity.this.mHasMoreData = true;
                        PrepaymentRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        PrepaymentRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        PrepaymentRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (buyClubCradRecordBean.records.size() == 0) {
                        PrepaymentRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentRecordActivity.this.mIsEnable && PrepaymentRecordActivity.this.mState == 3) {
                    if (PrepaymentRecordActivity.this.mCurrentPage == 1) {
                        PrepaymentRecordActivity.this.mMultiStateView.setViewState(1);
                        PrepaymentRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(PrepaymentRecordActivity.this.getContext()));
                    } else {
                        PrepaymentRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    PrepaymentRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    PrepaymentRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        this.mIsLoading = false;
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            this.mIsFromErrorOrDetail = true;
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mIsFromErrorOrDetail = true;
        int i2 = this.mState;
        if (i2 != 1) {
            if (i2 == 3) {
                RefundRecordDetailActivity.launch(getActivity(), (BuyClubCardDetailBean) this.mApdater.getItem(i), this.mTypeInfoBaseInfoBean, this.mPrepaymentDeviceInfoBean);
                return;
            }
            return;
        }
        BuyClubCardDetailBean buyClubCardDetailBean = (BuyClubCardDetailBean) this.mApdater.getItem(i);
        if (buyClubCardDetailBean.statusFlag == 1 || buyClubCardDetailBean.statusFlag == 5 || buyClubCardDetailBean.statusFlag == 4) {
            RecordDetailActivity.launch(getActivity(), buyClubCardDetailBean, this.mTypeInfoBaseInfoBean, this.mPrepaymentDeviceInfoBean);
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
            return PrepaymentRecordActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return PrepaymentRecordActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(PrepaymentRecordActivity.this.getContext()).inflate(R.layout.item_prepayment_record_layout, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (!PrepaymentRecordActivity.this.mIsLoading) {
                if (PrepaymentRecordActivity.this.mState == 2) {
                    CouponBean couponBean = (CouponBean) getItem(i);
                    viewHolder.tv_title.setText("补贴");
                    viewHolder.tv_state.setVisibility(4);
                    viewHolder.tv_time.setText(couponBean.createDatetime);
                    viewHolder.tv_money.setText("¥ " + DecimalUtil.divide(couponBean.money + "", "100"));
                } else {
                    BuyClubCardDetailBean buyClubCardDetailBean = (BuyClubCardDetailBean) getItem(i);
                    viewHolder.tv_state.setVisibility(0);
                    if (PrepaymentRecordActivity.this.mState != 1) {
                        if (PrepaymentRecordActivity.this.mState == 3) {
                            viewHolder.tv_title.setText("退款");
                            viewHolder.tv_time.setText(buyClubCardDetailBean.createDateTime);
                            viewHolder.tv_state.setVisibility(0);
                            if (buyClubCardDetailBean.statusFlag == 1) {
                                viewHolder.tv_state.setText("审核中");
                            } else if (buyClubCardDetailBean.statusFlag == 2 || buyClubCardDetailBean.statusFlag == 6 || buyClubCardDetailBean.statusFlag == 3) {
                                viewHolder.tv_state.setText("处理中");
                            } else if (buyClubCardDetailBean.statusFlag == 4 || buyClubCardDetailBean.statusFlag == 5) {
                                viewHolder.tv_state.setText("退款成功");
                            } else {
                                viewHolder.tv_state.setVisibility(4);
                            }
                        }
                    } else {
                        viewHolder.tv_title.setText("水表充值");
                        if (StringUtils.isNotEmpty(buyClubCardDetailBean.payDateTime)) {
                            viewHolder.tv_time.setText(buyClubCardDetailBean.payDateTime);
                        } else {
                            viewHolder.tv_time.setText(buyClubCardDetailBean.createDateTime);
                        }
                        viewHolder.tv_state.setVisibility(0);
                        if (buyClubCardDetailBean.statusFlag == 0) {
                            viewHolder.tv_state.setText("未支付");
                        } else if (buyClubCardDetailBean.statusFlag == 2) {
                            viewHolder.tv_state.setText("充值失败");
                        } else if (buyClubCardDetailBean.statusFlag == 3) {
                            viewHolder.tv_state.setText("订单取消");
                        } else if (buyClubCardDetailBean.statusFlag == 1) {
                            viewHolder.tv_state.setText("处理中");
                        } else if (buyClubCardDetailBean.statusFlag == 4) {
                            viewHolder.tv_state.setText("充值成功");
                        } else {
                            viewHolder.tv_state.setVisibility(4);
                        }
                    }
                    viewHolder.tv_money.setText("¥ " + DecimalUtil.divide(buyClubCardDetailBean.price + "", "100"));
                }
            }
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

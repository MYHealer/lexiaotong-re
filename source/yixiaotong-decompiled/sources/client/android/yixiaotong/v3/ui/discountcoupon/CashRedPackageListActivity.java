package client.android.yixiaotong.v3.ui.discountcoupon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.card.CreateOrderBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.order.CouponBean;
import client.android.yixiaotong.v3.bean.wallet.CashRedPackageBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.CashRedPackageDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.CashRedPackageRefundRecordActivity;
import client.android.yixiaotong.v3.ui.wallet.RefundV3Activity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CashRedPackageListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "CashRedPackageListActivity";
    private RecordsAdapter mApdater;
    private InvestorInfoBean mInvestorInfoBean;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private final List<CouponBean> mRecordListBeans = new ArrayList();
    public int mState = 0;
    private boolean mIsEnable = true;
    private int mTotalMoney = 0;
    private String mOrderId = "";
    private boolean mIsNeedLoadRedPackageMoney = false;

    static {
        StubApp.interface11(9914);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) CashRedPackageListActivity.class).putExtra(AmmeterWalletDetailActivity.EXTRA_ORDERID, str).putExtra("status", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("红包");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.tv_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m369x72d83a74(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-discountcoupon-CashRedPackageListActivity, reason: not valid java name */
    /* synthetic */ void m369x72d83a74(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        CashRedPackageDialog.getInstance().showDialog(getActivity(), new CashRedPackageDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity.1
            @Override // client.android.yixiaotong.v3.ui.dialog.CashRedPackageDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.CashRedPackageDialog.Listener
            public void onConfirm1() {
                CashRedPackageListActivity.this.handleRefundAction();
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.CashRedPackageDialog.Listener
            public void onConfirm2() {
                CashRedPackageRefundRecordActivity.launch(CashRedPackageListActivity.this.getActivity());
            }
        }, this.mState == 0 ? "申请退款" : "撤销退款");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRefundAction() {
        int i = this.mState;
        if (i != 0) {
            if (i == 1) {
                TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity.3
                    @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                    public void onCancle() {
                    }

                    @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                    public void onConfirm() {
                        CashRedPackageListActivity.this.cancelRefund();
                    }
                }, "提示", "是否撤销退款?", "取消", "撤销退款");
            }
        } else {
            getTotalMoney();
            String.format(getResources().getString(R.string.refundcashredpackage_tip), DecimalUtil.divide(this.mTotalMoney + "", "100"));
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity.2
                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    CashRedPackageListActivity.this.mIsNeedLoadRedPackageMoney = true;
                    RefundV3Activity.launch(CashRedPackageListActivity.this.getActivity(), "-1", CashRedPackageListActivity.this.mTotalMoney, CashRedPackageListActivity.this.mTotalMoney, 7);
                }
            }, "提示", "是否确认申请退款？", "#ff0289fe", "取消", "确认");
        }
    }

    private void getTotalMoney() {
        this.mTotalMoney = 0;
        if (this.mRecordListBeans != null) {
            for (int i = 0; i < this.mRecordListBeans.size(); i++) {
                this.mTotalMoney += this.mRecordListBeans.get(i).balance;
            }
        }
    }

    private void initView() {
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    CashRedPackageListActivity.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    CashRedPackageListActivity.this.mSwipeRefreshLayout.setEnabled(false);
                }
            }
        });
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CashRedPackageListActivity.this.mMultiStateView.setViewState(3);
                CashRedPackageListActivity.this.getRecords();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity.6
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                CashRedPackageListActivity.this.mRecordListBeans.clear();
                CashRedPackageListActivity.this.mApdater.notifyDataSetChanged();
                CashRedPackageListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                CashRedPackageListActivity.this.mLoadMoreFootView.setNoMoreData("");
                CashRedPackageListActivity.this.getRecords();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity.7
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                CashRedPackageListActivity.this.getRecords();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (this.mIsNeedLoadRedPackageMoney) {
            this.mIsNeedLoadRedPackageMoney = false;
            getMoneyCouponAmount();
        } else {
            getRecords();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        LogUtil.e(TAG, "onItemClick:" + i);
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        CashRedPackageDetailActivity.launch(getActivity(), this.mApdater.getItem(i), this.mState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRefund() {
        V3BusinessControllers.getInstance().postRevokeRefundOrders(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, -1, this.mOrderId, new Listener<CreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(CashRedPackageListActivity.this.getActivity(), "正在取消退款中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CreateOrderBean createOrderBean, Object... objArr) {
                super.onComplete(controller, createOrderBean, objArr);
                if (CashRedPackageListActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(CashRedPackageListActivity.this.getContext(), "取消成功");
                    CashRedPackageListActivity.this.mState = 0;
                    CashRedPackageListActivity.this.mOrderId = null;
                    CashRedPackageListActivity.this.mApdater.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CashRedPackageListActivity.this.mIsEnable) {
                    CashRedPackageListActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getMoneyCouponAmount() {
        V3BusinessControllers.getInstance().getMoneyCouponAmountV2(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, new Listener<CashRedPackageBean>() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(CashRedPackageListActivity.this.getActivity(), "获取现金红包信息", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CashRedPackageBean cashRedPackageBean, Object... objArr) {
                if (CashRedPackageListActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (cashRedPackageBean != null) {
                        if (cashRedPackageBean.refundStatus == 1) {
                            CashRedPackageListActivity.this.mState = 1;
                            CashRedPackageListActivity.this.mOrderId = cashRedPackageBean.orderId;
                        } else {
                            CashRedPackageListActivity.this.mState = 0;
                            CashRedPackageListActivity.this.mOrderId = "";
                        }
                        CashRedPackageListActivity.this.getRecords();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CashRedPackageListActivity.this.mIsEnable) {
                    CashRedPackageListActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecords() {
        V3BusinessControllers.getInstance().getCouponList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, 0, 5, 2, 1, "", UserInfoUtilControl.getInstance().getStudentId(), new Listener<List<CouponBean>>() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                CashRedPackageListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                CashRedPackageListActivity.this.mLoadMoreFootView.setNoMoreData("");
                CashRedPackageListActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<CouponBean> list, Object... objArr) {
                if (CashRedPackageListActivity.this.mIsEnable) {
                    CashRedPackageListActivity.this.mMultiStateView.setViewState(0);
                    CashRedPackageListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list != null) {
                        CashRedPackageListActivity.this.mRecordListBeans.clear();
                        CashRedPackageListActivity.this.mRecordListBeans.addAll(list);
                        CashRedPackageListActivity.this.mApdater.notifyDataSetChanged();
                        if (list.size() == 0) {
                            CashRedPackageListActivity.this.mMultiStateView.setViewState(2);
                            return;
                        }
                        return;
                    }
                    CashRedPackageListActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CashRedPackageListActivity.this.mIsEnable) {
                    CashRedPackageListActivity.this.mMultiStateView.setViewState(1);
                    CashRedPackageListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    CashRedPackageListActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
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
            return CashRedPackageListActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public CouponBean getItem(int i) {
            return (CouponBean) CashRedPackageListActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(CashRedPackageListActivity.this.getContext()).inflate(R.layout.layout_item_prepayment_repackage, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (CashRedPackageListActivity.this.mState == 1) {
                viewHolder.rel_yhq.setBackgroundResource(R.mipmap.hb_refundind);
            } else {
                viewHolder.rel_yhq.setBackgroundResource(R.mipmap.hb);
            }
            CouponBean item = getItem(i);
            viewHolder.tv_money.setText(DecimalUtil.divide(item.balance + "", "100"));
            viewHolder.tv_time.setText(item.startDate + " 至 " + item.endDate);
            viewHolder.tv_servername.setText(item.couponName);
            return view;
        }

        class ViewHolder {
            private LinearLayout rel_yhq;
            public TextView tv_money;
            public TextView tv_servername;
            public TextView tv_time;

            public ViewHolder(View view) {
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.tv_servername = (TextView) view.findViewById(R.id.tv_servername);
                this.rel_yhq = (LinearLayout) view.findViewById(R.id.rel_yhq);
            }
        }
    }
}

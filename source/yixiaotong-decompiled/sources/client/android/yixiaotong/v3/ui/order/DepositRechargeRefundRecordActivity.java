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
import client.android.yixiaotong.v3.bean.order.DepositRechargeRecordBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DepositRechargeRefundRecordActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "DepositRechargeRefundRecord";
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
    private boolean mIsRechargeOrder = true;
    private int mCurrentPage = 1;
    private int mTotalCount = 0;

    static {
        StubApp.interface11(10033);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DepositRechargeRefundRecordActivity.class));
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
        this.mTitleBar.setTitleView(getString(R.string.depositrefund));
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
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.DepositRechargeRefundRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DepositRechargeRefundRecordActivity.this.mMultiStateView.setViewState(3);
                if (DepositRechargeRefundRecordActivity.this.mIsRechargeOrder) {
                    DepositRechargeRefundRecordActivity.this.getRechargeRecord();
                } else {
                    DepositRechargeRefundRecordActivity.this.getRefundRecord();
                }
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.order.DepositRechargeRefundRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                DepositRechargeRefundRecordActivity.this.mRecordListBeans.clear();
                DepositRechargeRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                LogUtil.e(DepositRechargeRefundRecordActivity.TAG, "------111--------");
                DepositRechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                DepositRechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                DepositRechargeRefundRecordActivity.this.getInitRecord();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.order.DepositRechargeRefundRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                if (DepositRechargeRefundRecordActivity.this.mIsRechargeOrder) {
                    DepositRechargeRefundRecordActivity.this.getRechargeRecord();
                } else {
                    DepositRechargeRefundRecordActivity.this.getRefundRecord();
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
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.order.DepositRechargeRefundRecordActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!DepositRechargeRefundRecordActivity.this.mIsRechargeOrder || !DepositRechargeRefundRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= DepositRechargeRefundRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                DepositRechargeRefundRecordActivity.this.mCurrentPage++;
                DepositRechargeRefundRecordActivity.this.mTotalCount = i3;
                if (DepositRechargeRefundRecordActivity.this.mIsRechargeOrder) {
                    DepositRechargeRefundRecordActivity.this.getRechargeRecord();
                } else {
                    DepositRechargeRefundRecordActivity.this.getRefundRecord();
                }
                DepositRechargeRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
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
        findViewById(R.id.rel_recharge).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.DepositRechargeRefundRecordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m384x1d7f4177(view);
            }
        });
        findViewById(R.id.rel_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.DepositRechargeRefundRecordActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m385x512d6c38(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-order-DepositRechargeRefundRecordActivity, reason: not valid java name */
    /* synthetic */ void m384x1d7f4177(View view) {
        refreshRecordList(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-order-DepositRechargeRefundRecordActivity, reason: not valid java name */
    /* synthetic */ void m385x512d6c38(View view) {
        refreshRecordList(false);
    }

    private void refreshRecordList(boolean z) {
        this.mIsRechargeOrder = z;
        this.mRecordListBeans.clear();
        this.mApdater.notifyDataSetChanged();
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
        int investorInfosIndex = InvestorInfoUtil.getInstance().getInvestorInfosIndex();
        if (InvestorInfoUtil.getInstance().getInvestorInfosV3() != null && InvestorInfoUtil.getInstance().getInvestorInfosV3().size() > 0) {
            V3BusinessControllers.getInstance().getDepositOrderList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", InvestorInfoUtil.getInstance().getInvestorInfosV3().get(investorInfosIndex).investorInfo.investorId, new Listener<DepositRechargeRecordBean>() { // from class: client.android.yixiaotong.v3.ui.order.DepositRechargeRefundRecordActivity.5
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    DepositRechargeRefundRecordActivity.this.mHasMoreData = false;
                    DepositRechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    DepositRechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                    DepositRechargeRefundRecordActivity.this.mMultiStateView.getView(3);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, DepositRechargeRecordBean depositRechargeRecordBean, Object... objArr) {
                    if (DepositRechargeRefundRecordActivity.this.mIsEnable && DepositRechargeRefundRecordActivity.this.mIsRechargeOrder) {
                        DepositRechargeRefundRecordActivity.this.mMultiStateView.setViewState(0);
                        DepositRechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        if (depositRechargeRecordBean != null) {
                            DepositRechargeRefundRecordActivity.this.mRecordListBeans.clear();
                            DepositRechargeRefundRecordActivity.this.mRecordListBeans.add(depositRechargeRecordBean);
                            DepositRechargeRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                            LogUtil.e(DepositRechargeRefundRecordActivity.TAG, "------222--------");
                            DepositRechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                            return;
                        }
                        DepositRechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (DepositRechargeRefundRecordActivity.this.mIsEnable) {
                        DepositRechargeRefundRecordActivity.this.mMultiStateView.setViewState(1);
                        DepositRechargeRefundRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(DepositRechargeRefundRecordActivity.this.getContext()));
                        DepositRechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        DepositRechargeRefundRecordActivity.this.onError(clientException);
                    }
                }
            });
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRefundRecord() {
        V3BusinessControllers.getInstance().getDepositRefundOrderList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", 5, this.mCurrentPage, new Listener<BuyClubCradRecordBean>() { // from class: client.android.yixiaotong.v3.ui.order.DepositRechargeRefundRecordActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                DepositRechargeRefundRecordActivity.this.mHasMoreData = false;
                if (DepositRechargeRefundRecordActivity.this.mCurrentPage == 1) {
                    DepositRechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    DepositRechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    DepositRechargeRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                DepositRechargeRefundRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BuyClubCradRecordBean buyClubCradRecordBean, Object... objArr) {
                if (!DepositRechargeRefundRecordActivity.this.mIsEnable || DepositRechargeRefundRecordActivity.this.mIsRechargeOrder) {
                    return;
                }
                DepositRechargeRefundRecordActivity.this.mMultiStateView.setViewState(0);
                DepositRechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                if (buyClubCradRecordBean == null || buyClubCradRecordBean.records == null) {
                    DepositRechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                    return;
                }
                if (DepositRechargeRefundRecordActivity.this.mCurrentPage == 1) {
                    DepositRechargeRefundRecordActivity.this.mRecordListBeans.clear();
                }
                DepositRechargeRefundRecordActivity.this.mRecordListBeans.addAll(buyClubCradRecordBean.records);
                LogUtil.e(DepositRechargeRefundRecordActivity.TAG, "------333--------");
                DepositRechargeRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                if (buyClubCradRecordBean.totalPage > buyClubCradRecordBean.currentPage) {
                    DepositRechargeRefundRecordActivity.this.mHasMoreData = true;
                    DepositRechargeRefundRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                    DepositRechargeRefundRecordActivity.this.mLoadMoreFootView.reset();
                } else {
                    DepositRechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                }
                if (buyClubCradRecordBean.records.size() == 0) {
                    DepositRechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DepositRechargeRefundRecordActivity.this.mIsEnable) {
                    if (DepositRechargeRefundRecordActivity.this.mCurrentPage == 1) {
                        DepositRechargeRefundRecordActivity.this.mMultiStateView.setViewState(1);
                        DepositRechargeRefundRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(DepositRechargeRefundRecordActivity.this.getContext()));
                    } else {
                        DepositRechargeRefundRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    DepositRechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    DepositRechargeRefundRecordActivity.this.onError(clientException);
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
            DepositRefundDetailActivity.launch(getActivity(), (BuyClubCardDetailBean) this.mApdater.getItem(i));
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
            return DepositRechargeRefundRecordActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return DepositRechargeRefundRecordActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DepositRechargeRefundRecordActivity.this.getContext()).inflate(R.layout.layout_rechargerefund_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (DepositRechargeRefundRecordActivity.this.mIsRechargeOrder) {
                DepositRechargeRecordBean depositRechargeRecordBean = (DepositRechargeRecordBean) getItem(i);
                viewHolder.tv_title.setText(DepositRechargeRefundRecordActivity.this.getString(R.string.depositpayment));
                viewHolder.tv_money.setTextColor(DepositRechargeRefundRecordActivity.this.getResources().getColor(R.color.ff6f32fd));
                viewHolder.tv_time.setText(depositRechargeRecordBean.payDateTime);
                viewHolder.tv_money.setText("¥ " + DecimalUtil.divide(depositRechargeRecordBean.price + "", "100"));
            } else {
                BuyClubCardDetailBean buyClubCardDetailBean = (BuyClubCardDetailBean) getItem(i);
                if (buyClubCardDetailBean.statusFlag == 1) {
                    viewHolder.tv_title.setText(DepositRechargeRefundRecordActivity.this.getString(R.string.studentapply2));
                } else if (buyClubCardDetailBean.statusFlag == 2) {
                    viewHolder.tv_title.setText(DepositRechargeRefundRecordActivity.this.getString(R.string.revokeapplication2));
                } else if (buyClubCardDetailBean.statusFlag == 3) {
                    viewHolder.tv_title.setText(DepositRechargeRefundRecordActivity.this.getString(R.string.refusaltorefund2));
                } else if (buyClubCardDetailBean.statusFlag == 4) {
                    viewHolder.tv_title.setText(DepositRechargeRefundRecordActivity.this.getString(R.string.platformrefund2));
                } else if (buyClubCardDetailBean.statusFlag == 5) {
                    viewHolder.tv_title.setText(DepositRechargeRefundRecordActivity.this.getString(R.string.merchantmanualrefund2));
                } else {
                    viewHolder.tv_title.setText(DepositRechargeRefundRecordActivity.this.getString(R.string.refundofdeposit));
                }
                viewHolder.tv_money.setTextColor(DepositRechargeRefundRecordActivity.this.getResources().getColor(R.color.ff242933));
                viewHolder.tv_time.setText(buyClubCardDetailBean.createDateTime);
                viewHolder.tv_money.setText("¥ " + DecimalUtil.divide(buyClubCardDetailBean.price + "", "100"));
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

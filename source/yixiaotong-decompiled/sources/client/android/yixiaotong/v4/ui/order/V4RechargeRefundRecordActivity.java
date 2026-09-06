package client.android.yixiaotong.v4.ui.order;

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
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4RechargeRecordListBean;
import client.android.yixiaotong.v4.http.bean.V4RefundDetailBean;
import client.android.yixiaotong.v4.http.bean.V4RefundRecordBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4RechargeRefundRecordActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private RecordsAdapter mApdater;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private TextView mTvRecharge;
    private TextView mTvRefund;
    private TextView mTvRefunding;
    private View mVLineLeft;
    private View mVLineRefunding;
    private View mVLineRight;
    private boolean mIsEnable = true;
    private final List<Object> mRecordListBeans = new ArrayList();
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private int mCurrentPage = 1;
    private State mState = State.recharge;

    private enum State {
        recharge,
        refund,
        refunding
    }

    static {
        StubApp.interface11(10990);
    }

    private String getContent(int i) {
        if (i == 0) {
            return "(待审核)";
        }
        if (i == 1) {
            return "(已退款)";
        }
        if (i == 2) {
            return "(审核不通过)";
        }
        return i == 3 ? "(退款中)" : "";
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4RechargeRefundRecordActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvRecharge = (TextView) findViewById(R.id.tv_rechargetext);
        this.mVLineLeft = findViewById(R.id.v_lineleft);
        this.mTvRefund = (TextView) findViewById(R.id.tv_refundtext);
        this.mVLineRight = findViewById(R.id.v_lineright);
        this.mTvRefunding = (TextView) findViewById(R.id.tv_refundingtext);
        this.mVLineRefunding = findViewById(R.id.v_linerefunding);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.rechargerefundorder));
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
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(3);
                V4RechargeRefundRecordActivity.this.getData(false);
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4RechargeRefundRecordActivity.this.mRecordListBeans.clear();
                V4RechargeRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                V4RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                V4RechargeRefundRecordActivity.this.getData(true);
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                V4RechargeRefundRecordActivity.this.getData(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getData(boolean z) {
        if (z) {
            this.mCurrentPage = 1;
            this.mTotalCount = 0;
        }
        if (this.mState == State.recharge) {
            getRechargeRecord();
        } else if (this.mState == State.refund) {
            getRefundRecord();
        } else if (this.mState == State.refunding) {
            getRefundingRecord();
        }
    }

    private void initView() {
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setEnabled(false);
                }
                if (!V4RechargeRefundRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= V4RechargeRefundRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                V4RechargeRefundRecordActivity.this.mCurrentPage++;
                V4RechargeRefundRecordActivity.this.mTotalCount = i3;
                V4RechargeRefundRecordActivity.this.getData(false);
                V4RechargeRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
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
        findViewById(R.id.rel_recharge).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m533xb60b0f64(view);
            }
        });
        findViewById(R.id.rel_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m534xeeeb7003(view);
            }
        });
        findViewById(R.id.rel_refunding).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m535x27cbd0a2(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-order-V4RechargeRefundRecordActivity, reason: not valid java name */
    /* synthetic */ void m533xb60b0f64(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mState = State.recharge;
        initTitleView();
        getData(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-order-V4RechargeRefundRecordActivity, reason: not valid java name */
    /* synthetic */ void m534xeeeb7003(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mState = State.refund;
        initTitleView();
        getData(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-order-V4RechargeRefundRecordActivity, reason: not valid java name */
    /* synthetic */ void m535x27cbd0a2(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mState = State.refunding;
        initTitleView();
        getData(true);
    }

    private void getRechargeRecord() {
        V4BusinessControllers.getInstance().getRechargeRecord(getLoginAccount(), new Listener<V4RechargeRecordListBean>() { // from class: client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4RechargeRefundRecordActivity.this.mHasMoreData = false;
                if (V4RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    V4RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    V4RechargeRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                V4RechargeRefundRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4RechargeRecordListBean v4RechargeRecordListBean, Object... objArr) {
                if (V4RechargeRefundRecordActivity.this.mIsEnable && V4RechargeRefundRecordActivity.this.mState == State.recharge) {
                    V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(0);
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (v4RechargeRecordListBean == null || v4RechargeRecordListBean.records == null) {
                        V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    if (V4RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                        V4RechargeRefundRecordActivity.this.mRecordListBeans.clear();
                    }
                    V4RechargeRefundRecordActivity.this.mRecordListBeans.addAll(v4RechargeRecordListBean.records);
                    V4RechargeRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                    if (v4RechargeRecordListBean.pages > v4RechargeRecordListBean.current) {
                        V4RechargeRefundRecordActivity.this.mHasMoreData = true;
                        V4RechargeRefundRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        V4RechargeRefundRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        V4RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (v4RechargeRecordListBean.records.size() == 0) {
                        V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4RechargeRefundRecordActivity.this.mIsEnable) {
                    if (V4RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                        V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(1);
                        V4RechargeRefundRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(V4RechargeRefundRecordActivity.this.getContext()));
                    } else {
                        V4RechargeRefundRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    V4RechargeRefundRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getRefundRecord() {
        V4BusinessControllers.getInstance().getRefundList(getLoginAccount(), 1, 0, new Listener<V4RefundRecordBean>() { // from class: client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4RechargeRefundRecordActivity.this.mHasMoreData = false;
                if (V4RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    V4RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    V4RechargeRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                V4RechargeRefundRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4RefundRecordBean v4RefundRecordBean, Object... objArr) {
                if (V4RechargeRefundRecordActivity.this.mIsEnable && V4RechargeRefundRecordActivity.this.mState == State.refund) {
                    V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(0);
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (v4RefundRecordBean == null || v4RefundRecordBean.records == null) {
                        V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    if (V4RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                        V4RechargeRefundRecordActivity.this.mRecordListBeans.clear();
                    }
                    V4RechargeRefundRecordActivity.this.mRecordListBeans.addAll(v4RefundRecordBean.records);
                    V4RechargeRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                    if (v4RefundRecordBean.pages > v4RefundRecordBean.current) {
                        V4RechargeRefundRecordActivity.this.mHasMoreData = true;
                        V4RechargeRefundRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        V4RechargeRefundRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        V4RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (v4RefundRecordBean.records.size() == 0) {
                        V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4RechargeRefundRecordActivity.this.mIsEnable) {
                    if (V4RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                        V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(1);
                        V4RechargeRefundRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")");
                    } else {
                        V4RechargeRefundRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    V4RechargeRefundRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getRefundingRecord() {
        V4BusinessControllers.getInstance().getWaitRefundList(getLoginAccount(), 1, 0, new Listener<V4RefundDetailBean>() { // from class: client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4RechargeRefundRecordActivity.this.mHasMoreData = false;
                if (V4RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    V4RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    V4RechargeRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                V4RechargeRefundRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4RefundDetailBean v4RefundDetailBean, Object... objArr) {
                if (V4RechargeRefundRecordActivity.this.mIsEnable && V4RechargeRefundRecordActivity.this.mState == State.refunding) {
                    V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(0);
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (v4RefundDetailBean != null) {
                        if (V4RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                            V4RechargeRefundRecordActivity.this.mRecordListBeans.clear();
                        }
                        V4RechargeRefundRecordActivity.this.mRecordListBeans.add(v4RefundDetailBean);
                        V4RechargeRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                        V4RechargeRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        return;
                    }
                    V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4RechargeRefundRecordActivity.this.mIsEnable) {
                    if (V4RechargeRefundRecordActivity.this.mCurrentPage == 1) {
                        V4RechargeRefundRecordActivity.this.mMultiStateView.setViewState(1);
                        V4RechargeRefundRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")");
                    } else {
                        V4RechargeRefundRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    V4RechargeRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    V4RechargeRefundRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mState == State.refund || this.mState == State.refunding) {
            V4WalletRefundDetailActivity.launch(getActivity(), (V4RefundDetailBean) this.mApdater.getItem(i), 1);
        } else if (this.mState == State.recharge) {
            V4WalletRechargeDetailActivity.launch(getActivity(), (V4RefundDetailBean) this.mApdater.getItem(i));
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
            return V4RechargeRefundRecordActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return V4RechargeRefundRecordActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4RechargeRefundRecordActivity.this.getContext()).inflate(R.layout.layout_rechargerefund_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (V4RechargeRefundRecordActivity.this.mState == State.recharge) {
                V4RefundDetailBean v4RefundDetailBean = (V4RefundDetailBean) getItem(i);
                viewHolder.tv_title.setText(V4RechargeRefundRecordActivity.this.getString(R.string.rechargecenter2));
                viewHolder.tv_money.setTextColor(V4RechargeRefundRecordActivity.this.getResources().getColor(R.color.ff6f32fd));
                viewHolder.tv_time.setText(v4RefundDetailBean.createTime);
                viewHolder.tv_money.setText("¥ " + DecimalUtil.addV2(v4RefundDetailBean.price, v4RefundDetailBean.giftAmount));
            } else {
                V4RefundDetailBean v4RefundDetailBean2 = (V4RefundDetailBean) getItem(i);
                viewHolder.tv_title.setText(V4RechargeRefundRecordActivity.this.getString(R.string.walletrefund) + v4RefundDetailBean2.statusName);
                viewHolder.tv_money.setTextColor(V4RechargeRefundRecordActivity.this.getResources().getColor(R.color.ff242933));
                viewHolder.tv_time.setText(v4RefundDetailBean2.submitTime);
                viewHolder.tv_money.setText("¥ " + v4RefundDetailBean2.amount);
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

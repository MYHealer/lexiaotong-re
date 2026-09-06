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
import android.widget.ImageView;
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
public class CashRedPackageRefundRecordActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private RecordsAdapter mApdater;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private boolean mIsEnable = true;
    private final List<Object> mRecordListBeans = new ArrayList();
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private int mCurrentPage = 1;

    static {
        StubApp.interface11(9998);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) CashRedPackageRefundRecordActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("退款记录");
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
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.CashRedPackageRefundRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CashRedPackageRefundRecordActivity.this.mMultiStateView.setViewState(3);
                CashRedPackageRefundRecordActivity.this.getRefundRecord();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.order.CashRedPackageRefundRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                CashRedPackageRefundRecordActivity.this.mRecordListBeans.clear();
                CashRedPackageRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                CashRedPackageRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                CashRedPackageRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                CashRedPackageRefundRecordActivity.this.getInitRecord();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.order.CashRedPackageRefundRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                CashRedPackageRefundRecordActivity.this.getRefundRecord();
            }
        });
    }

    private void initView() {
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.order.CashRedPackageRefundRecordActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!CashRedPackageRefundRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= CashRedPackageRefundRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                CashRedPackageRefundRecordActivity.this.mCurrentPage++;
                CashRedPackageRefundRecordActivity.this.mTotalCount = i3;
                CashRedPackageRefundRecordActivity.this.getRefundRecord();
                CashRedPackageRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInitRecord() {
        this.mCurrentPage = 1;
        this.mTotalCount = 0;
        getRefundRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRefundRecord() {
        V3BusinessControllers.getInstance().getWalletRefundOrderList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", 5, this.mCurrentPage, 3, new Listener<BuyClubCradRecordBean>() { // from class: client.android.yixiaotong.v3.ui.order.CashRedPackageRefundRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                CashRedPackageRefundRecordActivity.this.mHasMoreData = false;
                if (CashRedPackageRefundRecordActivity.this.mCurrentPage == 1) {
                    CashRedPackageRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    CashRedPackageRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    CashRedPackageRefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                CashRedPackageRefundRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BuyClubCradRecordBean buyClubCradRecordBean, Object... objArr) {
                if (CashRedPackageRefundRecordActivity.this.mIsEnable) {
                    CashRedPackageRefundRecordActivity.this.mMultiStateView.setViewState(0);
                    CashRedPackageRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (buyClubCradRecordBean == null || buyClubCradRecordBean.records == null) {
                        CashRedPackageRefundRecordActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    if (CashRedPackageRefundRecordActivity.this.mCurrentPage == 1) {
                        CashRedPackageRefundRecordActivity.this.mRecordListBeans.clear();
                    }
                    CashRedPackageRefundRecordActivity.this.mRecordListBeans.addAll(buyClubCradRecordBean.records);
                    CashRedPackageRefundRecordActivity.this.mApdater.notifyDataSetChanged();
                    if (buyClubCradRecordBean.totalPage > buyClubCradRecordBean.currentPage) {
                        CashRedPackageRefundRecordActivity.this.mHasMoreData = true;
                        CashRedPackageRefundRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        CashRedPackageRefundRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        CashRedPackageRefundRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (buyClubCradRecordBean.records.size() == 0) {
                        CashRedPackageRefundRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CashRedPackageRefundRecordActivity.this.mIsEnable) {
                    if (CashRedPackageRefundRecordActivity.this.mCurrentPage == 1) {
                        CashRedPackageRefundRecordActivity.this.mMultiStateView.setViewState(1);
                        CashRedPackageRefundRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(CashRedPackageRefundRecordActivity.this.getContext()));
                    } else {
                        CashRedPackageRefundRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    CashRedPackageRefundRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    CashRedPackageRefundRecordActivity.this.onError(clientException);
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
        WalletRefundDetailActivity.launch(getActivity(), (BuyClubCardDetailBean) this.mApdater.getItem(i));
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
            return CashRedPackageRefundRecordActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return CashRedPackageRefundRecordActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(CashRedPackageRefundRecordActivity.this.getContext()).inflate(R.layout.layout_rechargerefund_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            BuyClubCardDetailBean buyClubCardDetailBean = (BuyClubCardDetailBean) getItem(i);
            viewHolder.tv_title.setText("现金红包退款");
            viewHolder.tv_money.setTextColor(CashRedPackageRefundRecordActivity.this.getResources().getColor(R.color.ff242933));
            viewHolder.tv_time.setText(buyClubCardDetailBean.createDateTime);
            viewHolder.tv_money.setText("¥ " + DecimalUtil.divide(buyClubCardDetailBean.price + "", "100"));
            viewHolder.tv_state.setTextColor(CashRedPackageRefundRecordActivity.this.getResources().getColor(R.color.ffed3930));
            viewHolder.tv_state.setText("");
            if (buyClubCardDetailBean.status == 1) {
                viewHolder.tv_state.setText("申请中");
            } else if (buyClubCardDetailBean.status == 2) {
                viewHolder.tv_state.setTextColor(CashRedPackageRefundRecordActivity.this.getResources().getColor(R.color.ffa1a6b3));
                viewHolder.tv_state.setText("已撤销");
            } else if (buyClubCardDetailBean.status == 3) {
                viewHolder.tv_state.setText("退款失败");
            } else if (buyClubCardDetailBean.status == 4) {
                viewHolder.tv_state.setTextColor(CashRedPackageRefundRecordActivity.this.getResources().getColor(R.color.ffa1a6b3));
                viewHolder.tv_state.setText("退款成功");
            } else if (buyClubCardDetailBean.status == 5) {
                viewHolder.tv_state.setText("退款中");
            }
            viewHolder.iv_time.setVisibility(8);
            return view;
        }

        class ViewHolder {
            public ImageView iv_time;
            public TextView tv_money;
            public TextView tv_state;
            public TextView tv_time;
            public TextView tv_title;

            public ViewHolder(View view) {
                this.tv_title = (TextView) view.findViewById(R.id.tv_title);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.iv_time = (ImageView) view.findViewById(R.id.iv_time);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.tv_state = (TextView) view.findViewById(R.id.tv_state);
            }
        }
    }
}

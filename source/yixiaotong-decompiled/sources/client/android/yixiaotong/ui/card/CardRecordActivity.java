package client.android.yixiaotong.ui.card;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SoundWaveCardRecordBean;
import client.android.yixiaotong.controller.bean.SoundWaveCardRecordListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CardRecordActivity extends BaseActivity {
    public static final String EXTRA_MACHINEID = "extra_machineid";
    public static final String EXTRA_STATE = "extra_state";
    public static final String EXTRA_WALLET = "extra_wallet";
    private CardRecordAdapter mCardRecordAdapter;
    private ListView mCardRecordList;
    private LoadMoreFooter mLoadMoreFootView;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    TextView mTvErrorTip;
    private int mTypeId;
    private WalletModel mWalletModel;
    private int mStartIndex = 0;
    private final int mPageSize = 10;
    private String status = "";
    private String machineid = "";
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private boolean mIsEnable = false;
    private List<SoundWaveCardRecordBean> mCardRecords = new ArrayList();

    static {
        StubApp.interface11(6623);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$608(CardRecordActivity cardRecordActivity) {
        int i = cardRecordActivity.mStartIndex;
        cardRecordActivity.mStartIndex = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) CardRecordActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_state", str);
        intent.putExtra("extra_machineid", str2);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mCardRecordList = (ListView) findViewById(R.id.lv_cardrecord);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.card.CardRecordActivity$1, reason: invalid class name */
    class AnonymousClass1 implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        AnonymousClass1() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (!CardRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= CardRecordActivity.this.mTotalCount) {
                return;
            }
            CardRecordActivity.this.mTotalCount = i3;
            CardRecordActivity.this.initData();
            CardRecordActivity.this.mLoadMoreFootView.loadMoreData();
        }
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
        this.mTitleBar.setTitleView("卡片充值账单");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mCardRecordList.addFooterView(loadMoreFooter);
        this.mCardRecordList.setFooterDividersEnabled(false);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.card.CardRecordActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CardRecordActivity.this.mMultiStateView.setViewState(3);
                CardRecordActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.card.CardRecordActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                CardRecordActivity.this.mStartIndex = 0;
                CardRecordActivity.this.mTotalCount = 0;
                CardRecordActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.card.CardRecordActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                CardRecordActivity.this.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        getRecordList();
    }

    private void getRecordList() {
        BusinessControllers.getInstance().getCardRecordList(getLoginAccount(), this.mTypeId, this.mStartIndex, this.status, this.machineid, new Listener<SoundWaveCardRecordListBean>() { // from class: client.android.yixiaotong.ui.card.CardRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                CardRecordActivity.this.mHasMoreData = false;
                CardRecordActivity.this.mMultiStateView.getView(3);
                if (CardRecordActivity.this.mStartIndex == 0) {
                    CardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                } else {
                    CardRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SoundWaveCardRecordListBean soundWaveCardRecordListBean, Object... objArr) {
                super.onComplete(controller, soundWaveCardRecordListBean, objArr);
                if (CardRecordActivity.this.mIsEnable) {
                    CardRecordActivity.this.mMultiStateView.setViewState(0);
                    CardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (soundWaveCardRecordListBean != null) {
                        if (CardRecordActivity.this.mStartIndex == 0) {
                            CardRecordActivity.this.mCardRecords.clear();
                            CardRecordActivity.this.mCardRecords.addAll(soundWaveCardRecordListBean.getSortList());
                        } else {
                            CardRecordActivity.this.mCardRecords.addAll(soundWaveCardRecordListBean.getSortList());
                        }
                        CardRecordActivity.this.mCardRecordAdapter.notifyDataSetChanged();
                        if (soundWaveCardRecordListBean.pageCount - 1 > soundWaveCardRecordListBean.pageIndex) {
                            CardRecordActivity.this.mHasMoreData = true;
                            CardRecordActivity.access$608(CardRecordActivity.this);
                            CardRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                            CardRecordActivity.this.mLoadMoreFootView.reset();
                        } else {
                            CardRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        }
                        if (soundWaveCardRecordListBean.count == 0) {
                            CardRecordActivity.this.mMultiStateView.setViewState(2);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (CardRecordActivity.this.mIsEnable) {
                    if (CardRecordActivity.this.mStartIndex == 0) {
                        CardRecordActivity.this.mMultiStateView.setViewState(1);
                        CardRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        CardRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    CardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    SystemErrorTip.getInstance().showTipDialog(CardRecordActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    private class CardRecordAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private CardRecordAdapter() {
        }

        /* synthetic */ CardRecordAdapter(CardRecordActivity cardRecordActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return CardRecordActivity.this.mCardRecords.size();
        }

        @Override // android.widget.Adapter
        public SoundWaveCardRecordBean getItem(int i) {
            return (SoundWaveCardRecordBean) CardRecordActivity.this.mCardRecords.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(CardRecordActivity.this.getContext()).inflate(R.layout.wash_record_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final SoundWaveCardRecordBean item = getItem(i);
            if (StringUtils.isNotEmpty(item.payDate) && StringUtils.isNotEmpty(item.payTime) && StringUtils.isNotEmpty(item.payMoney) && StringUtils.isNotEmpty(item.orderid)) {
                viewHolder.datetime.setText(item.payDate + PPSLabelView.Code + item.payTime);
                final String strTwoDecimal = DecimalUtil.twoDecimal(DecimalUtil.divide(item.payMoney, "100"));
                viewHolder.money.setText(x.A + strTwoDecimal);
                viewHolder.tvchongzhi.setText("充值金额");
                if (i == 0) {
                    viewHolder.line.setVisibility(4);
                } else {
                    viewHolder.line.setVisibility(0);
                }
                if (item.sysflag == 1) {
                    viewHolder.chongzhistate.setText("卡片充值-未激活");
                } else if (item.sysflag == 2) {
                    viewHolder.chongzhistate.setText("卡片充值-待充值");
                } else {
                    viewHolder.chongzhistate.setText("卡片充值-已完成");
                }
                viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.card.CardRecordActivity.CardRecordAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (viewHolder.chongzhistate.getText().toString().contains("已完成")) {
                            CardRecordDetailActivity.launch(CardRecordActivity.this.getActivity(), strTwoDecimal, item.payDate + PPSLabelView.Code + item.payTime, item.orderid);
                            return;
                        }
                        if (AppUtils.isUserHuaWeiScan()) {
                            ScanQrcodeOrBarcodeActivity.launch(CardRecordActivity.this.getActivity(), CardRecordActivity.this.mWalletModel, item.orderid + "," + strTwoDecimal, 2);
                        } else {
                            ZxingScanActivity.launch(CardRecordActivity.this.getActivity(), CardRecordActivity.this.mWalletModel, item.orderid + "," + strTwoDecimal, 2);
                        }
                        CardRecordActivity.this.getActivity().finish();
                    }
                });
            }
            return view;
        }

        class ViewHolder {
            public TextView chongzhistate;
            public TextView datetime;
            public RelativeLayout lin;
            public View line;
            public TextView money;
            public TextView tvchongzhi;

            public ViewHolder(View view) {
                this.line = view.findViewById(R.id.line1);
                this.datetime = (TextView) view.findViewById(R.id.tv_datetime);
                this.money = (TextView) view.findViewById(R.id.tv_money);
                this.chongzhistate = (TextView) view.findViewById(R.id.tv_chongzhistate);
                this.tvchongzhi = (TextView) view.findViewById(R.id.tv_xiaofei);
                this.lin = (RelativeLayout) view.findViewById(R.id.lin);
            }
        }
    }
}

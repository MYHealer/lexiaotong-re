package client.android.yixiaotong.ui.sellcard;

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
public class SellCardRecordActivity extends BaseActivity {
    public static final String EXTRA_MACHINEID = "extra_machineid";
    public static final String EXTRA_STATE = "extra_state";
    public static final String EXTRA_WALLET = "extra_wallet";
    private CardRecordAdapter mCardRecordAdapter;
    ListView mCardRecordList;
    private LoadMoreFooter mLoadMoreFootView;
    MultiStateView mMultiStateView;
    PullRefreshLayout mSwipeRefreshLayout;
    TitleBar mTitleBar;
    TextView mTvErrorTip;
    private int mTypeId;
    private WalletModel mWalletModel;
    private int mStartIndex = 0;
    private final int mPageSize = 10;
    private String status = "";
    private String machineid = "";
    private int mTotalCount = 0;
    private boolean mIsEnable = true;
    private List<SoundWaveCardRecordBean> mCardRecords = new ArrayList();
    private boolean mHasMoreData = false;

    static {
        StubApp.interface11(7622);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$508(SellCardRecordActivity sellCardRecordActivity) {
        int i = sellCardRecordActivity.mStartIndex;
        sellCardRecordActivity.mStartIndex = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) SellCardRecordActivity.class);
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

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.sellcard.SellCardRecordActivity$1, reason: invalid class name */
    class AnonymousClass1 implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        AnonymousClass1() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (!SellCardRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= SellCardRecordActivity.this.mTotalCount) {
                return;
            }
            SellCardRecordActivity.this.mTotalCount = i3;
            SellCardRecordActivity.this.initData();
            SellCardRecordActivity.this.mLoadMoreFootView.loadMoreData();
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("售卡记录");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
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

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mCardRecordList.addFooterView(loadMoreFooter);
        this.mCardRecordList.setFooterDividersEnabled(false);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardRecordActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SellCardRecordActivity.this.mMultiStateView.setViewState(3);
                SellCardRecordActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardRecordActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                SellCardRecordActivity.this.mStartIndex = 0;
                SellCardRecordActivity.this.mTotalCount = 0;
                SellCardRecordActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardRecordActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                SellCardRecordActivity.this.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        getRecordList();
    }

    private void getRecordList() {
        BusinessControllers.getInstance().getCardSalesList(getLoginAccount(), this.mTypeId, this.mStartIndex, this.status, this.machineid, new Listener<SoundWaveCardRecordListBean>() { // from class: client.android.yixiaotong.ui.sellcard.SellCardRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                SellCardRecordActivity.this.mHasMoreData = false;
                if (SellCardRecordActivity.this.mStartIndex != 0) {
                    SellCardRecordActivity.this.mLoadMoreFootView.loadMoreData();
                } else {
                    SellCardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SoundWaveCardRecordListBean soundWaveCardRecordListBean, Object... objArr) {
                super.onComplete(controller, soundWaveCardRecordListBean, objArr);
                if (SellCardRecordActivity.this.mIsEnable) {
                    SellCardRecordActivity.this.mMultiStateView.setViewState(0);
                    SellCardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (soundWaveCardRecordListBean != null) {
                        if (SellCardRecordActivity.this.mStartIndex == 0) {
                            SellCardRecordActivity.this.mCardRecords.clear();
                            SellCardRecordActivity.this.mCardRecords.addAll(soundWaveCardRecordListBean.getSortList());
                        } else {
                            SellCardRecordActivity.this.mCardRecords.addAll(soundWaveCardRecordListBean.getSortList());
                        }
                        SellCardRecordActivity.this.mCardRecordAdapter.notifyDataSetChanged();
                        if (soundWaveCardRecordListBean.pageCount - 1 > soundWaveCardRecordListBean.pageIndex) {
                            SellCardRecordActivity.this.mHasMoreData = true;
                            SellCardRecordActivity.access$508(SellCardRecordActivity.this);
                            SellCardRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                            SellCardRecordActivity.this.mLoadMoreFootView.reset();
                        } else {
                            SellCardRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        }
                        if (soundWaveCardRecordListBean.count == 0) {
                            SellCardRecordActivity.this.mMultiStateView.setViewState(2);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (SellCardRecordActivity.this.mIsEnable) {
                    if (SellCardRecordActivity.this.mStartIndex != 0) {
                        SellCardRecordActivity.this.mLoadMoreFootView.resetForFail();
                    } else {
                        SellCardRecordActivity.this.mMultiStateView.setViewState(1);
                        SellCardRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    }
                    SellCardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    SystemErrorTip.getInstance().showTipDialog(SellCardRecordActivity.this.getActivity(), clientException.getDetail());
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

        /* synthetic */ CardRecordAdapter(SellCardRecordActivity sellCardRecordActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SellCardRecordActivity.this.mCardRecords.size();
        }

        @Override // android.widget.Adapter
        public SoundWaveCardRecordBean getItem(int i) {
            return (SoundWaveCardRecordBean) SellCardRecordActivity.this.mCardRecords.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(SellCardRecordActivity.this.getContext()).inflate(R.layout.wash_record_list_item, (ViewGroup) null);
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
            final SoundWaveCardRecordBean item = getItem(i);
            viewHolder.chongzhistate.setText("售卡-未知");
            if (StringUtils.isNotEmpty(item.realPay) && StringUtils.isNotEmpty(item.orderid)) {
                viewHolder.datetime.setText(item.payDate + PPSLabelView.Code + item.payTime);
                viewHolder.money.setText(x.A + DecimalUtil.twoDecimal(DecimalUtil.divide(item.realPay, "100")));
                if (item.sysflag == 0) {
                    viewHolder.chongzhistate.setText("售卡-未支付");
                } else if (item.sysflag == 1) {
                    viewHolder.chongzhistate.setText("售卡-未激活");
                } else if (item.sysflag == 2) {
                    viewHolder.chongzhistate.setText("售卡-待校验");
                } else {
                    viewHolder.chongzhistate.setText("售卡-已完成");
                }
            }
            viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardRecordActivity.CardRecordAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!viewHolder.chongzhistate.getText().toString().equals("售卡-已完成") && !viewHolder.chongzhistate.getText().equals("售卡-未支付")) {
                        if (AppUtils.isUserHuaWeiScan()) {
                            ScanQrcodeOrBarcodeActivity.launch(SellCardRecordActivity.this.getActivity(), SellCardRecordActivity.this.mWalletModel, item.orderid + "," + item.realPay, 9);
                        } else {
                            ZxingScanActivity.launch(SellCardRecordActivity.this.getActivity(), SellCardRecordActivity.this.mWalletModel, item.orderid + "," + item.realPay, 9);
                        }
                        SellCardRecordActivity.this.getActivity().finish();
                        return;
                    }
                    if (viewHolder.chongzhistate.getText().toString().equals("售卡-已完成") || viewHolder.chongzhistate.getText().toString().equals("售卡-未支付")) {
                        SellCardRecordDetailActivity.launch(SellCardRecordActivity.this.getActivity(), DecimalUtil.twoDecimal(DecimalUtil.divide(item.realPay, "100")), item.payDate + PPSLabelView.Code + item.payTime, item.orderid, item.sysflag);
                    }
                }
            });
            viewHolder.lin.setOnLongClickListener(new View.OnLongClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardRecordActivity.CardRecordAdapter.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    SellCardRecordDetailActivity.launch(SellCardRecordActivity.this.getActivity(), DecimalUtil.twoDecimal(DecimalUtil.divide(item.realPay, "100")), item.payDate + PPSLabelView.Code + item.payTime, item.orderid, item.sysflag);
                    return false;
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

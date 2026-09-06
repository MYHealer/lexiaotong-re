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
import android.widget.RelativeLayout;
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
import client.android.yixiaotong.v3.bean.card.BuyClubCardBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.card.BuyCardDetailActivity;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BuyCardListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private int mIndex;
    private List<InvestorInfosBean> mInfosBeanList;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvCard;
    private MultiStateView mMultiStateView;
    private RecordsAdapter mRecordsAdapter;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private boolean mIsEnable = true;
    private List<BuyClubCardBean> mClubCardBeans = new ArrayList();
    private int mSelectIndex = 0;

    static {
        StubApp.interface11(9975);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, TypeInfoBaseInfoBean typeInfoBaseInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BuyCardListActivity.class).putExtra("bean", typeInfoBaseInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mLvCard = (ListView) findViewById(R.id.lv_card);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.buydiscard));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mRecordsAdapter = recordsAdapter;
        this.mLvCard.setAdapter((ListAdapter) recordsAdapter);
        this.mLvCard.setOnItemClickListener(this);
        this.mLvCard.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyCardListActivity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    BuyCardListActivity.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    BuyCardListActivity.this.mSwipeRefreshLayout.setEnabled(false);
                }
            }
        });
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

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvCard.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyCardListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyCardListActivity.this.mMultiStateView.setViewState(3);
                BuyCardListActivity.this.getClubCard();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyCardListActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                BuyCardListActivity.this.mClubCardBeans.clear();
                BuyCardListActivity.this.mRecordsAdapter.notifyDataSetChanged();
                BuyCardListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                BuyCardListActivity.this.mLoadMoreFootView.setNoMoreData("");
                BuyCardListActivity.this.getClubCard();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyCardListActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                BuyCardListActivity.this.getClubCard();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getClubCard() {
        V3BusinessControllers.getInstance().getClubCardListByInvestorid(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", InvestorInfoUtil.getInstance().getInvestorInfosV3().get(InvestorInfoUtil.getInstance().getInvestorInfosIndex()).investorInfo.investorId, new Listener<List<BuyClubCardBean>>() { // from class: client.android.yixiaotong.v3.ui.order.BuyCardListActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BuyCardListActivity.this.mClubCardBeans.clear();
                BuyCardListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                BuyCardListActivity.this.mLoadMoreFootView.setNoMoreData("");
                BuyCardListActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<BuyClubCardBean> list, Object... objArr) {
                super.onComplete(controller, list, objArr);
                if (BuyCardListActivity.this.mIsEnable) {
                    BuyCardListActivity.this.mMultiStateView.setViewState(0);
                    BuyCardListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list == null || list.size() <= 0) {
                        BuyCardListActivity.this.mMultiStateView.setViewState(2);
                        BuyCardListActivity.this.mClubCardBeans.clear();
                    } else {
                        BuyCardListActivity.this.mLoadMoreFootView.setVisibility(0);
                        BuyCardListActivity.this.mLoadMoreFootView.setNoMoreData();
                        BuyCardListActivity.this.mClubCardBeans = list;
                    }
                    BuyCardListActivity.this.mRecordsAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (BuyCardListActivity.this.mIsEnable) {
                    BuyCardListActivity.this.mMultiStateView.setViewState(1);
                    BuyCardListActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(BuyCardListActivity.this.getContext()));
                    BuyCardListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    BuyCardListActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyCardListActivity.6
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BuyCardListActivity.this.finish();
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BuyCardDetailActivity.launch(getActivity(), this.mRecordsAdapter.getItem(i), this.mTypeInfoBaseInfoBean);
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
            return BuyCardListActivity.this.mClubCardBeans.size();
        }

        @Override // android.widget.Adapter
        public BuyClubCardBean getItem(int i) {
            return (BuyClubCardBean) BuyCardListActivity.this.mClubCardBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(BuyCardListActivity.this.getContext()).inflate(R.layout.layout_item_buyclubcard, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            BuyClubCardBean item = getItem(i);
            viewHolder.tv_name.setText(item.cardName);
            viewHolder.tv_servername.setText(((InvestorInfosBean) BuyCardListActivity.this.mInfosBeanList.get(BuyCardListActivity.this.mIndex)).investorInfo.providerJson.providerName);
            String string = "";
            viewHolder.tv_money.setText(DecimalUtil.divide(item.howmuchMoney + "", "100"));
            if (item.cardGroup == 1) {
                string = BuyCardListActivity.this.getString(R.string.weeklycard);
                viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg2);
            } else if (item.cardGroup == 2) {
                string = BuyCardListActivity.this.getString(R.string.monthlycard);
                viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg3);
            } else if (item.cardGroup == 3) {
                string = BuyCardListActivity.this.getString(R.string.seasoncard);
                viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg4);
            } else if (item.cardGroup == 4) {
                string = BuyCardListActivity.this.getString(R.string.yearcard);
                viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg5);
            }
            if (item.statusFlag == 2) {
                viewHolder.tv_noactivate.setVisibility(0);
                viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg6);
            }
            if (item.discountValue != 100) {
                if (item.discountValue == 0) {
                    viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg1);
                    string = BuyCardListActivity.this.getString(R.string.free) + PPSLabelView.Code + string;
                } else {
                    string = (item.discountValue / 10.0f) + BuyCardListActivity.this.getString(R.string.discount2) + PPSLabelView.Code + string;
                }
            }
            viewHolder.tv_day.setText(string);
            return view;
        }

        class ViewHolder {
            public RelativeLayout rel_bg;
            public TextView tv_day;
            public TextView tv_money;
            public TextView tv_name;
            public TextView tv_noactivate;
            public TextView tv_servername;

            public ViewHolder(View view) {
                this.rel_bg = (RelativeLayout) view.findViewById(R.id.rel_bg);
                this.tv_noactivate = (TextView) view.findViewById(R.id.tv_noactivate);
                this.tv_name = (TextView) view.findViewById(R.id.tv_name);
                this.tv_servername = (TextView) view.findViewById(R.id.tv_servername);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_day = (TextView) view.findViewById(R.id.tv_day);
            }
        }
    }
}

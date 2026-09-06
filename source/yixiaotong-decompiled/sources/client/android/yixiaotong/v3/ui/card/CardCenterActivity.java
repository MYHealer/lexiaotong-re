package client.android.yixiaotong.v3.ui.card;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.v3.bean.card.ClubCardBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.BuyCardListActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CardCenterActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "CardCenterActivity";
    private AppTitleAdapter mAppTitleApdater;
    private CardAdapter mCardAdapter;
    private InvestorInfoBean mInvestorInfoBean;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvCard;
    private MultiStateView mMultiStateView;
    private RecyclerView mRvAppTitle;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private int mTypeId;
    private boolean mIsEnable = true;
    private List<TypeInfoBean> mAppDatas = new ArrayList();
    private int mSelectAppIndex = 0;
    private List<ClubCardBean> mCardDatas = new ArrayList();

    public interface OnItemClickListener {
        void OnItemClick(View view, TypeInfoBean typeInfoBean);
    }

    static {
        StubApp.interface11(9647);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) CardCenterActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRvAppTitle = (RecyclerView) findViewById(R.id.rv_app);
        this.mLvCard = (ListView) findViewById(R.id.lv_card);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.mycardbag));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        initFooterView();
        this.mRvAppTitle.setLayoutManager(new LinearLayoutManager(this, 0, false));
        AppTitleAdapter appTitleAdapter = new AppTitleAdapter();
        this.mAppTitleApdater = appTitleAdapter;
        this.mRvAppTitle.setAdapter(appTitleAdapter);
        this.mAppTitleApdater.setOnItemClickListener(new OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.card.CardCenterActivity.1
            @Override // client.android.yixiaotong.v3.ui.card.CardCenterActivity.OnItemClickListener
            public void OnItemClick(View view, TypeInfoBean typeInfoBean) {
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: client.android.yixiaotong.v3.ui.card.CardCenterActivity.2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                return 1;
            }
        });
        this.mRvAppTitle.setLayoutManager(gridLayoutManager);
        CardAdapter cardAdapter = new CardAdapter();
        this.mCardAdapter = cardAdapter;
        this.mLvCard.setAdapter((ListAdapter) cardAdapter);
        this.mLvCard.setOnItemClickListener(this);
        this.mLvCard.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.card.CardCenterActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    CardCenterActivity.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    CardCenterActivity.this.mSwipeRefreshLayout.setEnabled(false);
                }
            }
        });
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvCard.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.CardCenterActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CardCenterActivity.this.mMultiStateView.setViewState(3);
                CardCenterActivity.this.getCardInfo();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.card.CardCenterActivity.5
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                CardCenterActivity.this.mCardDatas.clear();
                CardCenterActivity.this.mCardAdapter.notifyDataSetChanged();
                CardCenterActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                CardCenterActivity.this.mLoadMoreFootView.setNoMoreData("");
                CardCenterActivity.this.getCardInfo();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.card.CardCenterActivity.6
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                CardCenterActivity.this.getCardInfo();
            }
        });
    }

    private void initData() {
        int investorInfosIndex = InvestorInfoUtil.getInstance().getInvestorInfosIndex();
        if (InvestorInfoUtil.getInstance().getInvestorInfosV3() != null && InvestorInfoUtil.getInstance().getInvestorInfosV3().size() > 0 && InvestorInfoUtil.getInstance().getInvestorInfosV3().get(investorInfosIndex) != null) {
            this.mInvestorInfoBean = InvestorInfoUtil.getInstance().getInvestorInfosV3().get(investorInfosIndex).investorInfo;
            this.mAppDatas.clear();
            if (this.mInvestorInfoBean != null) {
                for (int i = 0; i < this.mInvestorInfoBean.planInfo.size(); i++) {
                    for (int i2 = 0; i2 < this.mInvestorInfoBean.planInfo.get(i).typeInfo.size(); i2++) {
                        this.mAppDatas.add(this.mInvestorInfoBean.planInfo.get(i).typeInfo.get(i2));
                    }
                }
            }
        }
        List<TypeInfoBean> list = this.mAppDatas;
        if (list != null && list.size() > 0) {
            this.mTypeId = this.mAppDatas.get(0).base.typeId;
        }
        this.mAppTitleApdater.notifyDataSetChanged();
    }

    private void initClickListeners() {
        findViewById(R.id.iv_buycard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.CardCenterActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyCardListActivity.launch(CardCenterActivity.this.getActivity(), ((TypeInfoBean) CardCenterActivity.this.mAppDatas.get(CardCenterActivity.this.mSelectAppIndex)).base);
            }
        });
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        CardDetailActivity.launch(getActivity(), this.mCardAdapter.getItem(i), this.mAppDatas.get(this.mSelectAppIndex));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        getCardInfo();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCardInfo() {
        List<TypeInfoBean> list = this.mAppDatas;
        if (list != null && list.size() > 0 && this.mAppDatas.get(this.mSelectAppIndex).base != null) {
            this.mTypeId = this.mAppDatas.get(this.mSelectAppIndex).base.typeId;
            V3BusinessControllers.getInstance().getClubCardList(getLoginAccount(), this.mTypeId, 0, new Listener<List<ClubCardBean>>() { // from class: client.android.yixiaotong.v3.ui.card.CardCenterActivity.8
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    CardCenterActivity.this.mCardDatas.clear();
                    CardCenterActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    CardCenterActivity.this.mLoadMoreFootView.setNoMoreData("");
                    CardCenterActivity.this.mMultiStateView.getView(3);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, List<ClubCardBean> list2, Object... objArr) {
                    super.onComplete(controller, list2, objArr);
                    if (CardCenterActivity.this.mIsEnable) {
                        CardCenterActivity.this.mMultiStateView.setViewState(0);
                        CardCenterActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        if (list2 == null || list2.size() <= 0) {
                            CardCenterActivity.this.mMultiStateView.setViewState(2);
                            CardCenterActivity.this.mCardDatas.clear();
                        } else {
                            CardCenterActivity.this.mLoadMoreFootView.setVisibility(0);
                            CardCenterActivity.this.mLoadMoreFootView.setNoMoreData();
                            for (int i = 0; i < list2.size(); i++) {
                                CardCenterActivity.this.mCardDatas.add(list2.get(i));
                            }
                        }
                        CardCenterActivity.this.mCardAdapter.notifyDataSetChanged();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (CardCenterActivity.this.mIsEnable) {
                        CardCenterActivity.this.mMultiStateView.setViewState(1);
                        CardCenterActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(CardCenterActivity.this.getContext()));
                        CardCenterActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        CardCenterActivity.this.onError(clientException);
                    }
                }
            });
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.card.CardCenterActivity.9
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    public class AppTitleAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private OnItemClickListener onItemClickListener;

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        public AppTitleAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(CardCenterActivity.this.getContext()).inflate(R.layout.layout_item_apptitle, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
            TypeInfoBean typeInfoBean = (TypeInfoBean) CardCenterActivity.this.mAppDatas.get(i);
            myViewHolder.tv_appname.setText(LanguageUtils.getAppName(CardCenterActivity.this.getActivity(), typeInfoBean.base.typeId, typeInfoBean.base.appName));
            LogUtil.e(CardCenterActivity.TAG, "onBindViewHolder:" + i + "  " + CardCenterActivity.this.mSelectAppIndex + (i == CardCenterActivity.this.mSelectAppIndex));
            if (i == CardCenterActivity.this.mSelectAppIndex) {
                myViewHolder.v_line.setVisibility(0);
            } else {
                myViewHolder.v_line.setVisibility(4);
            }
            myViewHolder.tv_appname.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.CardCenterActivity.AppTitleAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AppTitleAdapter.this.onItemClickListener != null) {
                        AppTitleAdapter.this.onItemClickListener.OnItemClick(view, (TypeInfoBean) CardCenterActivity.this.mAppDatas.get(i));
                        LogUtil.e(CardCenterActivity.TAG, i + "  " + CardCenterActivity.this.mSelectAppIndex);
                        if (i != CardCenterActivity.this.mSelectAppIndex) {
                            CardCenterActivity.this.mSelectAppIndex = i;
                            CardCenterActivity.this.getCardInfo();
                        }
                        CardCenterActivity.this.mAppTitleApdater.notifyDataSetChanged();
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CardCenterActivity.this.mAppDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_appname;
            public View v_line;

            public MyViewHolder(View view) {
                super(view);
                this.tv_appname = (TextView) view.findViewById(R.id.tv_appname);
                this.v_line = view.findViewById(R.id.v_line);
            }
        }
    }

    private class CardAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private CardAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return CardCenterActivity.this.mCardDatas.size();
        }

        @Override // android.widget.Adapter
        public ClubCardBean getItem(int i) {
            return (ClubCardBean) CardCenterActivity.this.mCardDatas.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            View viewInflate;
            String string;
            if (view == null) {
                viewInflate = LayoutInflater.from(CardCenterActivity.this.getContext()).inflate(R.layout.layout_item_clubcard, (ViewGroup) null);
                viewHolder = new ViewHolder(viewInflate);
                viewInflate.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
                viewInflate = view;
            }
            ClubCardBean item = getItem(i);
            if (item.cardGroup == 1) {
                string = CardCenterActivity.this.getString(R.string.weeklycard);
            } else if (item.cardGroup == 2) {
                string = CardCenterActivity.this.getString(R.string.monthlycard);
            } else if (item.cardGroup == 3) {
                string = CardCenterActivity.this.getString(R.string.seasoncard);
            } else {
                string = item.cardGroup == 4 ? CardCenterActivity.this.getString(R.string.yearcard) : "";
            }
            if (item.discountValue != 100) {
                if (item.discountValue == 0) {
                    string = CardCenterActivity.this.getString(R.string.free) + PPSLabelView.Code + string;
                } else {
                    string = (item.discountValue / 10.0f) + CardCenterActivity.this.getString(R.string.discount2) + PPSLabelView.Code + string;
                }
            }
            viewHolder.tv_tian.setVisibility(0);
            viewHolder.tv_tian2.setVisibility(0);
            viewHolder.tv_name.setText(LanguageUtils.getAppName(CardCenterActivity.this.getActivity(), ((TypeInfoBean) CardCenterActivity.this.mAppDatas.get(CardCenterActivity.this.mSelectAppIndex)).base.typeId, ((TypeInfoBean) CardCenterActivity.this.mAppDatas.get(CardCenterActivity.this.mSelectAppIndex)).base.appName) + string);
            viewHolder.tv_servername.setText(item.providerName);
            if (item.statusFlag == 0) {
                viewHolder.tv_noactivate.setText(CardCenterActivity.this.getString(R.string.buying));
            } else if (item.statusFlag == 1) {
                viewHolder.tv_noactivate.setText(CardCenterActivity.this.getString(R.string.active));
            } else if (item.statusFlag == 2) {
                viewHolder.tv_noactivate.setText(CardCenterActivity.this.getString(R.string.notactive));
            } else if (item.statusFlag == 3) {
                viewHolder.tv_noactivate.setText(CardCenterActivity.this.getString(R.string.refunding2));
            } else if (item.statusFlag == 4) {
                viewHolder.tv_noactivate.setText(CardCenterActivity.this.getString(R.string.cardreturned));
            } else {
                viewHolder.tv_noactivate.setVisibility(4);
            }
            if (item.statusFlag == 2) {
                viewHolder.tv_tian.setVisibility(4);
                viewHolder.tv_tian2.setVisibility(4);
                viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg6);
            } else if (item.discountValue != 0) {
                if (item.cardGroup != 1) {
                    if (item.cardGroup != 2) {
                        if (item.cardGroup != 3) {
                            if (item.cardGroup == 4) {
                                viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg5);
                            }
                        } else {
                            viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg4);
                        }
                    } else {
                        viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg3);
                    }
                } else {
                    viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg2);
                }
            } else {
                viewHolder.rel_bg.setBackgroundResource(R.mipmap.bg1);
            }
            LogUtil.e(CardCenterActivity.TAG, item.useEntTime + "  " + item.statusFlag + "  " + viewHolder.tv_day.getText().toString());
            viewHolder.tv_day.setText("");
            if (StringUtils.isNotEmpty(item.useEntTime)) {
                long jStrTimeToSec = TimeUtils.strTimeToSec(item.useEntTime);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jStrTimeToSec != 0) {
                    long j = jStrTimeToSec - jCurrentTimeMillis;
                    LogUtil.e(CardCenterActivity.TAG, jCurrentTimeMillis + "  " + jStrTimeToSec + "  " + j);
                    long j2 = (((j / 60) / 60) / 24) / 1000;
                    LogUtil.e(CardCenterActivity.TAG, jCurrentTimeMillis + "  " + jStrTimeToSec + "  " + j + "  " + j2);
                    if (jCurrentTimeMillis > jStrTimeToSec) {
                        viewHolder.tv_day.setText("0");
                    } else {
                        viewHolder.tv_day.setText((j2 + 1) + "");
                    }
                }
            } else if (item.statusFlag != 2) {
                viewHolder.tv_day.setText("0");
            }
            return viewInflate;
        }

        class ViewHolder {
            private RelativeLayout rel_bg;
            public TextView tv_day;
            public TextView tv_name;
            public TextView tv_noactivate;
            public TextView tv_servername;
            public TextView tv_state;
            public TextView tv_tian;
            public TextView tv_tian2;

            public ViewHolder(View view) {
                this.tv_tian = (TextView) view.findViewById(R.id.tv_tian);
                this.tv_tian2 = (TextView) view.findViewById(R.id.tv_tian2);
                this.tv_name = (TextView) view.findViewById(R.id.tv_name);
                this.tv_servername = (TextView) view.findViewById(R.id.tv_servername);
                this.tv_day = (TextView) view.findViewById(R.id.tv_day);
                this.tv_noactivate = (TextView) view.findViewById(R.id.tv_noactivate);
                this.rel_bg = (RelativeLayout) view.findViewById(R.id.rel_bg);
                this.tv_state = (TextView) view.findViewById(R.id.tv_state);
            }
        }
    }
}

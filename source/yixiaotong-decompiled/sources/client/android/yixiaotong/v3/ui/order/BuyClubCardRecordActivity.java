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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCardDetailBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCradRecordBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
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
public class BuyClubCardRecordActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "BuyClubCardRecordActivity";
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
    private List<TypeInfoBean> mAppDatas = new ArrayList();
    private int mSelectAppIndex = 0;
    private List<BuyClubCardDetailBean> mCardDatas = new ArrayList();
    private boolean mIsEnable = true;
    private int mSelectDateIndex = 0;
    private int mCurrentPage = 1;
    private int mTotalCount = 0;
    private boolean mHasMoreData = false;

    public interface OnItemClickListener {
        void OnItemClick(View view, TypeInfoBean typeInfoBean);
    }

    static {
        StubApp.interface11(9990);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BuyClubCardRecordActivity.class));
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
        this.mTitleBar.setTitleView(getString(R.string.cardsrecords));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvCard.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyClubCardRecordActivity.this.mMultiStateView.setViewState(3);
                BuyClubCardRecordActivity.this.getCardInfo();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                BuyClubCardRecordActivity.this.mCurrentPage = 1;
                BuyClubCardRecordActivity.this.mTotalCount = 0;
                BuyClubCardRecordActivity.this.mCardDatas.clear();
                BuyClubCardRecordActivity.this.mCardAdapter.notifyDataSetChanged();
                BuyClubCardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                BuyClubCardRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                BuyClubCardRecordActivity.this.getCardInfo();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                BuyClubCardRecordActivity.this.getCardInfo();
            }
        });
    }

    private void initView() {
        initFooterView();
        this.mRvAppTitle.setLayoutManager(new LinearLayoutManager(this, 0, false));
        AppTitleAdapter appTitleAdapter = new AppTitleAdapter();
        this.mAppTitleApdater = appTitleAdapter;
        this.mRvAppTitle.setAdapter(appTitleAdapter);
        this.mAppTitleApdater.setOnItemClickListener(new OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity.4
            @Override // client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity.OnItemClickListener
            public void OnItemClick(View view, TypeInfoBean typeInfoBean) {
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity.5
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
        this.mLvCard.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity.6
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!BuyClubCardRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= BuyClubCardRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                BuyClubCardRecordActivity.this.mCurrentPage++;
                BuyClubCardRecordActivity.this.mTotalCount = i3;
                BuyClubCardRecordActivity.this.getCardInfo();
                BuyClubCardRecordActivity.this.mLoadMoreFootView.loadMoreData();
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
        getCardInfo();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        ClubCardDetailActivity.launch(getActivity(), this.mCardAdapter.getItem(i));
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
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCardInfo() {
        List<TypeInfoBean> list = this.mAppDatas;
        if (list != null && list.size() > 0 && this.mAppDatas.get(this.mSelectAppIndex).base != null) {
            this.mTypeId = this.mAppDatas.get(this.mSelectAppIndex).base.typeId;
            V3BusinessControllers.getInstance().getClubCardOrderList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mTypeId, 5, this.mCurrentPage, new Listener<BuyClubCradRecordBean>() { // from class: client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity.7
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    BuyClubCardRecordActivity.this.mHasMoreData = false;
                    if (BuyClubCardRecordActivity.this.mCurrentPage == 1) {
                        BuyClubCardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                        BuyClubCardRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                    } else {
                        BuyClubCardRecordActivity.this.mLoadMoreFootView.loadMoreData();
                    }
                    BuyClubCardRecordActivity.this.mMultiStateView.getView(3);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, BuyClubCradRecordBean buyClubCradRecordBean, Object... objArr) {
                    super.onComplete(controller, buyClubCradRecordBean, objArr);
                    if (BuyClubCardRecordActivity.this.mIsEnable) {
                        BuyClubCardRecordActivity.this.mMultiStateView.setViewState(0);
                        BuyClubCardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        if (buyClubCradRecordBean == null || buyClubCradRecordBean.records == null) {
                            BuyClubCardRecordActivity.this.mMultiStateView.setViewState(2);
                            return;
                        }
                        if (BuyClubCardRecordActivity.this.mCurrentPage == 1) {
                            BuyClubCardRecordActivity.this.mCardDatas.clear();
                        }
                        BuyClubCardRecordActivity.this.mCardDatas = buyClubCradRecordBean.records;
                        BuyClubCardRecordActivity.this.mCardAdapter.notifyDataSetChanged();
                        if (buyClubCradRecordBean.totalPage > buyClubCradRecordBean.currentPage) {
                            BuyClubCardRecordActivity.this.mHasMoreData = true;
                            BuyClubCardRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                            BuyClubCardRecordActivity.this.mLoadMoreFootView.reset();
                        } else {
                            BuyClubCardRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        }
                        if (buyClubCradRecordBean.records.size() == 0) {
                            BuyClubCardRecordActivity.this.mMultiStateView.setViewState(2);
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (BuyClubCardRecordActivity.this.mIsEnable) {
                        if (BuyClubCardRecordActivity.this.mCurrentPage == 1) {
                            BuyClubCardRecordActivity.this.mMultiStateView.setViewState(1);
                            BuyClubCardRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(BuyClubCardRecordActivity.this.getContext()));
                        } else {
                            BuyClubCardRecordActivity.this.mLoadMoreFootView.resetForFail();
                        }
                        BuyClubCardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        BuyClubCardRecordActivity.this.onError(clientException);
                    }
                }
            });
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity.8
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
            return new MyViewHolder(LayoutInflater.from(BuyClubCardRecordActivity.this.getContext()).inflate(R.layout.layout_item_apptitle, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
            TypeInfoBean typeInfoBean = (TypeInfoBean) BuyClubCardRecordActivity.this.mAppDatas.get(i);
            myViewHolder.tv_appname.setText(LanguageUtils.getAppName(BuyClubCardRecordActivity.this.getActivity(), typeInfoBean.base.typeId, typeInfoBean.base.appName));
            LogUtil.e(BuyClubCardRecordActivity.TAG, "onBindViewHolder:" + i + "  " + BuyClubCardRecordActivity.this.mSelectAppIndex + (i == BuyClubCardRecordActivity.this.mSelectAppIndex));
            if (i == BuyClubCardRecordActivity.this.mSelectAppIndex) {
                myViewHolder.v_line.setVisibility(0);
            } else {
                myViewHolder.v_line.setVisibility(4);
            }
            myViewHolder.tv_appname.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity.AppTitleAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AppTitleAdapter.this.onItemClickListener != null) {
                        AppTitleAdapter.this.onItemClickListener.OnItemClick(view, (TypeInfoBean) BuyClubCardRecordActivity.this.mAppDatas.get(i));
                        LogUtil.e(BuyClubCardRecordActivity.TAG, i + "  " + BuyClubCardRecordActivity.this.mSelectAppIndex);
                        if (i != BuyClubCardRecordActivity.this.mSelectAppIndex) {
                            BuyClubCardRecordActivity.this.mSelectAppIndex = i;
                            BuyClubCardRecordActivity.this.mCardDatas.clear();
                            BuyClubCardRecordActivity.this.mCardAdapter.notifyDataSetChanged();
                            BuyClubCardRecordActivity.this.mTotalCount = 0;
                            BuyClubCardRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                            BuyClubCardRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                            BuyClubCardRecordActivity.this.mCurrentPage = 1;
                            BuyClubCardRecordActivity.this.getCardInfo();
                        }
                        BuyClubCardRecordActivity.this.mAppTitleApdater.notifyDataSetChanged();
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return BuyClubCardRecordActivity.this.mAppDatas.size();
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
            return BuyClubCardRecordActivity.this.mCardDatas.size();
        }

        @Override // android.widget.Adapter
        public BuyClubCardDetailBean getItem(int i) {
            return (BuyClubCardDetailBean) BuyClubCardRecordActivity.this.mCardDatas.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            String string;
            if (view == null) {
                view = LayoutInflater.from(BuyClubCardRecordActivity.this.getContext()).inflate(R.layout.layout_item_buyclubcard_record, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            BuyClubCardDetailBean item = getItem(i);
            if (item.cardGroup == 1) {
                string = BuyClubCardRecordActivity.this.getString(R.string.weeklycard);
            } else if (item.cardGroup == 2) {
                string = BuyClubCardRecordActivity.this.getString(R.string.monthlycard);
            } else if (item.cardGroup == 3) {
                string = BuyClubCardRecordActivity.this.getString(R.string.seasoncard);
            } else {
                string = item.cardGroup == 4 ? BuyClubCardRecordActivity.this.getString(R.string.yearcard) : "";
            }
            if (item.discountValue != 100) {
                if (item.discountValue == 0) {
                    string = BuyClubCardRecordActivity.this.getString(R.string.free) + PPSLabelView.Code + string;
                } else {
                    string = (item.discountValue / 10.0f) + BuyClubCardRecordActivity.this.getString(R.string.discount2) + PPSLabelView.Code + string;
                }
            }
            viewHolder.tv_name.setText(LanguageUtils.getAppName(BuyClubCardRecordActivity.this.getActivity(), ((TypeInfoBean) BuyClubCardRecordActivity.this.mAppDatas.get(BuyClubCardRecordActivity.this.mSelectAppIndex)).base.typeId, ((TypeInfoBean) BuyClubCardRecordActivity.this.mAppDatas.get(BuyClubCardRecordActivity.this.mSelectAppIndex)).base.appName) + string);
            viewHolder.tv_servername.setText(item.providerName);
            viewHolder.tv_time.setText(item.payDateTime);
            if (item.payCode == 1) {
                viewHolder.tv_state.setText(BuyClubCardRecordActivity.this.getString(R.string.payed));
            } else {
                viewHolder.tv_state.setText(BuyClubCardRecordActivity.this.getString(R.string.nopay));
            }
            viewHolder.tv_money.setText(DecimalUtil.divide(item.price + "", "100"));
            return view;
        }

        class ViewHolder {
            public TextView tv_money;
            public TextView tv_name;
            public TextView tv_servername;
            public TextView tv_state;
            public TextView tv_time;

            public ViewHolder(View view) {
                this.tv_name = (TextView) view.findViewById(R.id.tv_name);
                this.tv_servername = (TextView) view.findViewById(R.id.tv_servername);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.tv_state = (TextView) view.findViewById(R.id.tv_state);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
            }
        }
    }
}

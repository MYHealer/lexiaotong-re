package client.android.yixiaotong.v4.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.adapter.MyPopWindow;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4BathRecordBean;
import client.android.yixiaotong.v4.http.bean.V4BathRecordListBean;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.util.V4LanguageUtils;
import client.android.yixiaotong.v4.util.homeinfo.V4TypeIDSetUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectInfoBean;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ConsumeRecordActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "V4ConsumeRecordActivity";
    private RecordsAdapter mApdater;
    private ImageView mIvPayStateDrop;
    private ImageView mIvTimeDrop;
    private ImageView mIvTypeDrop;
    private LinearLayout mLinTitle;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private RelativeLayout mRelPay;
    private RelativeLayout mRelPayState;
    private RelativeLayout mRelType;
    private RelativeLayout mRelWarningError;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private View mTopView;
    private TextView mTvAppName;
    private TextView mTvErrorTip;
    private TextView mTvHejiText;
    private TextView mTvPayState;
    private TextView mTvTime;
    private TextView mTvTotalMoney;
    private View mVPopBg;
    private MyPopWindow myPopWindow;
    private RotateAnimation rotate;
    private boolean mIsEnable = true;
    private final List<Object> mRecordListBeans = new ArrayList();
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private List<V4HomeInfoBean> mAppDatas = new ArrayList();
    private List<String> mTypeList = new ArrayList();
    private List<String> mDateList = new ArrayList();
    private List<String> mPayStateList = new ArrayList();
    private int mTypeId = 0;
    private int mSelectTypeIndex = 0;
    private int mSelectDateIndex = 0;
    private int mSelectPayStateIndex = 1;
    private int mCurrentPage = 1;
    private boolean mIsNeedLoadOrder = true;
    private PayState mPayState = PayState.pay;

    private enum PayState {
        pay,
        nopay,
        refund
    }

    static {
        StubApp.interface11(10961);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError50XTip() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i) {
        activity.startActivity(new Intent(activity, (Class<?>) V4ConsumeRecordActivity.class).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
    }

    public static void launch(Activity activity, int i, boolean z) {
        activity.startActivity(new Intent(activity, (Class<?>) V4ConsumeRecordActivity.class).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i).putExtra("nopay", z));
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelWarningError = (RelativeLayout) findViewById(R.id.rel_warningerror);
        this.mLinTitle = (LinearLayout) findViewById(R.id.lin_title);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mRelType = (RelativeLayout) findViewById(R.id.rel_type);
        this.mRelPayState = (RelativeLayout) findViewById(R.id.rel_paystate);
        this.mTvAppName = (TextView) findViewById(R.id.tv_appname);
        this.mIvTypeDrop = (ImageView) findViewById(R.id.iv_typedrop);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mIvTimeDrop = (ImageView) findViewById(R.id.iv_timedrop);
        this.mTvPayState = (TextView) findViewById(R.id.tv_paystate);
        this.mIvPayStateDrop = (ImageView) findViewById(R.id.iv_paydrop);
        this.mTopView = findViewById(R.id.v_line);
        this.mVPopBg = findViewById(R.id.v_popbg);
        this.mRelPay = (RelativeLayout) findViewById(R.id.rel_pay);
        this.mTvHejiText = (TextView) findViewById(R.id.tv_totaltext);
        this.mTvTotalMoney = (TextView) findViewById(R.id.tv_totalmoney);
        this.mTvHejiText.setVisibility(4);
        this.mTvTotalMoney.setVisibility(4);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.deviceorder));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.rel_type).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m527xfe8bf337(view);
            }
        });
        findViewById(R.id.rel_time).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m528xf21b7778(view);
            }
        });
        findViewById(R.id.rel_paystate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m529xe5aafbb9(view);
            }
        });
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m530xd93a7ffa(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-order-V4ConsumeRecordActivity, reason: not valid java name */
    /* synthetic */ void m527xfe8bf337(View view) {
        selectType();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-order-V4ConsumeRecordActivity, reason: not valid java name */
    /* synthetic */ void m528xf21b7778(View view) {
        selectTime();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-order-V4ConsumeRecordActivity, reason: not valid java name */
    /* synthetic */ void m529xe5aafbb9(View view) {
        selectPayState();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v4-ui-order-V4ConsumeRecordActivity, reason: not valid java name */
    /* synthetic */ void m530xd93a7ffa(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4NoPayOrderActivity.launch(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LogUtil.e(TAG, "onResume  " + this.mIsNeedLoadOrder + "  " + this.mPayState + "  " + this.mIsEnable);
        showError50XTip();
        if (this.mIsEnable && this.mIsNeedLoadOrder) {
            this.mIsNeedLoadOrder = false;
            getRecord();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogUtil.e(TAG, "onPause  " + this.mIsNeedLoadOrder + "  " + this.mPayState);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4ConsumeRecordActivity.this.mMultiStateView.setViewState(3);
                V4ConsumeRecordActivity.this.getRecord();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4ConsumeRecordActivity.this.mCurrentPage = 1;
                V4ConsumeRecordActivity.this.mTotalCount = 0;
                V4ConsumeRecordActivity.this.mRecordListBeans.clear();
                V4ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                V4ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                V4ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                V4ConsumeRecordActivity.this.getRecord();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                V4ConsumeRecordActivity.this.getRecord();
            }
        });
    }

    private void initView() {
        if (this.mTypeId != 0) {
            this.mTvAppName.setTextColor(getColor(R.color.ffa1a6b3));
            this.mIvTypeDrop.setVisibility(4);
        }
        if (this.mPayState == PayState.nopay) {
            this.mLinTitle.setVisibility(8);
            this.mTopView.setVisibility(8);
        }
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    V4ConsumeRecordActivity.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    V4ConsumeRecordActivity.this.mSwipeRefreshLayout.setEnabled(false);
                }
                if (!V4ConsumeRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= V4ConsumeRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                V4ConsumeRecordActivity.this.mCurrentPage++;
                V4ConsumeRecordActivity.this.mTotalCount = i3;
                V4ConsumeRecordActivity.this.getRecord();
                V4ConsumeRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
    }

    private void initData() {
        this.mIsEnable = true;
        LogUtil.e("V4OrderFragment", "-----");
        this.mSelectTypeIndex = 0;
        this.mSelectDateIndex = 0;
        this.mSelectPayStateIndex = 1;
        this.mCurrentPage = 1;
        this.mPayState = PayState.pay;
        this.mAppDatas.clear();
        this.mTypeList.clear();
        this.mDateList.clear();
        this.mPayStateList.clear();
        this.mRecordListBeans.clear();
        this.mRelPay.setVisibility(8);
        V4ProjectInfoBean projectInfoV4 = V4ProjectConfigInfoUtil.getInstance().getProjectInfoV4();
        if (projectInfoV4 != null && projectInfoV4.productTypeToArray != null) {
            for (int i = 0; i < projectInfoV4.productTypeToArray.size(); i++) {
                V4HomeInfoBean v4HomeInfoBean = new V4HomeInfoBean();
                v4HomeInfoBean.appName = V4TypeIDSetUtil.getAppName(getActivity(), projectInfoV4.productTypeToArray.get(i).intValue());
                v4HomeInfoBean.productId = projectInfoV4.productTypeToArray.get(i).intValue();
                this.mAppDatas.add(v4HomeInfoBean);
            }
        }
        if (this.mAppDatas.size() > 0) {
            for (int i2 = 0; i2 < this.mAppDatas.size(); i2++) {
                if (this.mTypeId != 0) {
                    if (this.mAppDatas.get(i2).productId == this.mTypeId) {
                        this.mTypeList.add(V4LanguageUtils.getAppName(getActivity(), this.mAppDatas.get(i2).productId, this.mAppDatas.get(i2).appName));
                        this.mTypeId = this.mAppDatas.get(i2).productId;
                    }
                } else {
                    this.mTypeList.add(V4LanguageUtils.getAppName(getActivity(), this.mAppDatas.get(i2).productId, this.mAppDatas.get(i2).appName));
                }
            }
            if (this.mTypeId == 0) {
                this.mTypeId = this.mAppDatas.get(0).productId;
            }
            if (this.mTypeList.size() > 0) {
                this.mTvAppName.setText(this.mTypeList.get(0));
            }
        }
        this.mDateList.add(getResources().getString(R.string.nearlyservendays));
        this.mDateList.add(getResources().getString(R.string.nearlyfifteendays));
        this.mDateList.add(getResources().getString(R.string.nearlyamonth));
        this.mDateList.add(getResources().getString(R.string.nearlythreemonth));
        this.mTvTime.setText(this.mDateList.get(0));
        this.mPayStateList.add(getResources().getString(R.string.payed));
        this.mPayStateList.add(getResources().getString(R.string.weizhifu));
        this.mTvPayState.setText(this.mPayStateList.get(0));
    }

    private void selectType() {
        LogUtil.e(TAG, this.mAppDatas.size() + "  " + this.mTypeList.size());
        if (this.mAppDatas.size() == this.mTypeList.size()) {
            initAnim(0.0f, 180.0f);
            this.mIvTypeDrop.startAnimation(this.rotate);
            backgroudAlpha();
            this.myPopWindow.showPop(this.mTopView, this.mSelectTypeIndex, this.mTypeList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity.5
                @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                public void onShow(int i) {
                    V4ConsumeRecordActivity.this.mTvAppName.setText(V4LanguageUtils.getAppName(V4ConsumeRecordActivity.this.getActivity(), ((V4HomeInfoBean) V4ConsumeRecordActivity.this.mAppDatas.get(i)).productId, ((V4HomeInfoBean) V4ConsumeRecordActivity.this.mAppDatas.get(i)).appName));
                    LogUtil.e(V4ConsumeRecordActivity.TAG, "onShow:" + V4ConsumeRecordActivity.this.mSelectTypeIndex + "  " + i + PPSLabelView.Code + ((V4HomeInfoBean) V4ConsumeRecordActivity.this.mAppDatas.get(i)).appName);
                    if (V4ConsumeRecordActivity.this.mSelectTypeIndex != i) {
                        V4ConsumeRecordActivity v4ConsumeRecordActivity = V4ConsumeRecordActivity.this;
                        v4ConsumeRecordActivity.mTypeId = ((V4HomeInfoBean) v4ConsumeRecordActivity.mAppDatas.get(i)).productId;
                        V4ConsumeRecordActivity.this.mRecordListBeans.clear();
                        V4ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                        V4ConsumeRecordActivity.this.mTotalCount = 0;
                        V4ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                        V4ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                        V4ConsumeRecordActivity.this.mCurrentPage = 1;
                        V4ConsumeRecordActivity.this.getRecord();
                    }
                    V4ConsumeRecordActivity.this.mSelectTypeIndex = i;
                }

                @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                public void onDiss() {
                    V4ConsumeRecordActivity.this.mVPopBg.setVisibility(8);
                    V4ConsumeRecordActivity.this.initAnim(180.0f, 360.0f);
                    V4ConsumeRecordActivity.this.mIvTypeDrop.startAnimation(V4ConsumeRecordActivity.this.rotate);
                }
            });
        }
    }

    private void selectTime() {
        initAnim(0.0f, 180.0f);
        this.mIvTimeDrop.startAnimation(this.rotate);
        backgroudAlpha();
        this.myPopWindow.showPop(this.mTopView, this.mSelectDateIndex, this.mDateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity.6
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                V4ConsumeRecordActivity.this.mTvTime.setText((CharSequence) V4ConsumeRecordActivity.this.mDateList.get(i));
                if (V4ConsumeRecordActivity.this.mSelectDateIndex != i) {
                    V4ConsumeRecordActivity.this.mRecordListBeans.clear();
                    V4ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                    V4ConsumeRecordActivity.this.mTotalCount = 0;
                    V4ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    V4ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                    V4ConsumeRecordActivity.this.mCurrentPage = 1;
                    V4ConsumeRecordActivity.this.mSelectDateIndex = i;
                    V4ConsumeRecordActivity.this.getRecord();
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                V4ConsumeRecordActivity.this.mVPopBg.setVisibility(8);
                V4ConsumeRecordActivity.this.initAnim(180.0f, 360.0f);
                V4ConsumeRecordActivity.this.mIvTimeDrop.startAnimation(V4ConsumeRecordActivity.this.rotate);
            }
        });
    }

    private void selectPayState() {
        if (this.mPayStateList.size() > 2) {
            this.mPayStateList.remove(2);
            this.mSelectPayStateIndex = 1;
        }
        initAnim(0.0f, 180.0f);
        this.mIvPayStateDrop.startAnimation(this.rotate);
        backgroudAlpha();
        this.myPopWindow.showPop(this.mTopView, this.mSelectPayStateIndex == 1 ? 0 : 1, this.mPayStateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity.7
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                V4ConsumeRecordActivity.this.mTvPayState.setText((CharSequence) V4ConsumeRecordActivity.this.mPayStateList.get(i));
                int i2 = i == 1 ? 0 : 1;
                if (V4ConsumeRecordActivity.this.mSelectPayStateIndex != i2) {
                    V4ConsumeRecordActivity.this.mRecordListBeans.clear();
                    V4ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                    V4ConsumeRecordActivity.this.mTotalCount = 0;
                    V4ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    V4ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                    V4ConsumeRecordActivity.this.mCurrentPage = 1;
                    if (i2 == 1) {
                        V4ConsumeRecordActivity.this.mPayState = PayState.pay;
                        V4ConsumeRecordActivity.this.mRelPay.setVisibility(8);
                    } else {
                        V4ConsumeRecordActivity.this.mPayState = PayState.nopay;
                    }
                    V4ConsumeRecordActivity.this.mSelectPayStateIndex = i2;
                    V4ConsumeRecordActivity.this.getRecord();
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                V4ConsumeRecordActivity.this.mVPopBg.setVisibility(8);
                V4ConsumeRecordActivity.this.initAnim(180.0f, 360.0f);
                V4ConsumeRecordActivity.this.mIvPayStateDrop.startAnimation(V4ConsumeRecordActivity.this.rotate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecord() {
        V4BusinessControllers.getInstance().getConsumeRecord(getLoginAccount(), this.mSelectDateIndex, this.mCurrentPage, this.mTypeId, this.mSelectPayStateIndex, new Listener<V4BathRecordListBean>() { // from class: client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4ConsumeRecordActivity.this.mHasMoreData = false;
                if (V4ConsumeRecordActivity.this.mCurrentPage == 1) {
                    V4ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    V4ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    V4ConsumeRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                V4ConsumeRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4BathRecordListBean v4BathRecordListBean, Object... objArr) {
                if (V4ConsumeRecordActivity.this.mIsEnable) {
                    V4ConsumeRecordActivity.this.showError50XTip();
                    V4ConsumeRecordActivity.this.mMultiStateView.setViewState(0);
                    V4ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (v4BathRecordListBean.records != null) {
                        if (V4ConsumeRecordActivity.this.mCurrentPage == 1) {
                            V4ConsumeRecordActivity.this.mRecordListBeans.clear();
                        }
                        for (int i = 0; i < v4BathRecordListBean.records.size(); i++) {
                            V4ConsumeRecordActivity.this.mRecordListBeans.add(v4BathRecordListBean.records.get(i));
                        }
                        V4ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                        if (v4BathRecordListBean.pages > v4BathRecordListBean.current) {
                            V4ConsumeRecordActivity.this.mHasMoreData = true;
                            V4ConsumeRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                            V4ConsumeRecordActivity.this.mLoadMoreFootView.reset();
                        } else {
                            V4ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        }
                        if (V4ConsumeRecordActivity.this.mRecordListBeans.size() == 0) {
                            V4ConsumeRecordActivity.this.mMultiStateView.setViewState(2);
                            return;
                        } else {
                            if (V4ConsumeRecordActivity.this.mPayState != PayState.nopay || V4ConsumeRecordActivity.this.mRecordListBeans.size() <= 0) {
                                return;
                            }
                            V4ConsumeRecordActivity.this.mRelPay.setVisibility(0);
                            return;
                        }
                    }
                    V4ConsumeRecordActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4ConsumeRecordActivity.this.mIsEnable) {
                    if (V4ConsumeRecordActivity.this.mCurrentPage == 1) {
                        V4ConsumeRecordActivity.this.mMultiStateView.setViewState(1);
                        V4ConsumeRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")");
                    } else {
                        V4ConsumeRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    V4ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    V4ConsumeRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        showError50XTip();
        if (clientException.isNeedExitAppV4(clientException.getCode())) {
            AccountManager.getInstance().clearLoginAccount();
            LoginActivity.launch(getActivity());
            ActivitiesHelper.getInstance().closeAll();
            return;
        }
        SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4BathOrderDetailActivity.launch(getActivity(), (V4BathRecordBean) this.mApdater.getItem(i));
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
            return V4ConsumeRecordActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return V4ConsumeRecordActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4ConsumeRecordActivity.this.getContext()).inflate(R.layout.layout_orderrecord_item_v3, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.tv_type.setText(V4ConsumeRecordActivity.this.mTvAppName.getText().toString());
            viewHolder.tv_orderstate.setVisibility(8);
            V4BathRecordBean v4BathRecordBean = (V4BathRecordBean) getItem(i);
            viewHolder.tv_orderid.setText(V4ConsumeRecordActivity.this.getResources().getString(R.string.orderno1) + v4BathRecordBean.consumeOrderId);
            viewHolder.tv_money.setText("¥" + v4BathRecordBean.consume);
            viewHolder.tv_time.setText(v4BathRecordBean.useTime);
            viewHolder.tv_state.setText(v4BathRecordBean.payName);
            viewHolder.tv_state.setTextColor(V4ConsumeRecordActivity.this.getResources().getColor(R.color.ffa1a6b3));
            return view;
        }

        class ViewHolder {
            public TextView tv_money;
            public TextView tv_orderid;
            public TextView tv_orderstate;
            public TextView tv_state;
            public TextView tv_time;
            public TextView tv_type;

            public ViewHolder(View view) {
                this.tv_orderid = (TextView) view.findViewById(R.id.tv_orderid);
                this.tv_type = (TextView) view.findViewById(R.id.tv_type);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.tv_state = (TextView) view.findViewById(R.id.tv_state);
                this.tv_orderstate = (TextView) view.findViewById(R.id.tv_orderstate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAnim(float f, float f2) {
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
        this.rotate = rotateAnimation;
        rotateAnimation.setDuration(500L);
        this.rotate.setFillAfter(true);
    }

    private void backgroudAlpha() {
        this.mVPopBg.setVisibility(0);
    }
}

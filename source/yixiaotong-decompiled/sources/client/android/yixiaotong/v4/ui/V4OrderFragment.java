package client.android.yixiaotong.v4.ui;

import android.app.Activity;
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
import client.android.yixiaotong.BaseXFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.MyPopWindow;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4BathRecordBean;
import client.android.yixiaotong.v4.http.bean.V4BathRecordListBean;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.ui.order.V4BathOrderDetailActivity;
import client.android.yixiaotong.v4.ui.order.V4NoPayOrderActivity;
import client.android.yixiaotong.v4.util.V4LanguageUtils;
import client.android.yixiaotong.v4.util.homeinfo.V4TypeIDSetUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectInfoBean;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4OrderFragment extends BaseXFragment implements AdapterView.OnItemClickListener {
    private static final String TAG = "V4OrderFragment";
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
    private int mProductId = 0;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showError50XTip() {
    }

    public static V4OrderFragment newInstance() {
        return new V4OrderFragment();
    }

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.titleBar);
        this.mRelWarningError = (RelativeLayout) view.findViewById(R.id.rel_warningerror);
        this.mLinTitle = (LinearLayout) view.findViewById(R.id.lin_title);
        this.mLvRecord = (ListView) view.findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) view.findViewById(R.id.multiStateView);
        this.mRelType = (RelativeLayout) view.findViewById(R.id.rel_type);
        this.mRelPayState = (RelativeLayout) view.findViewById(R.id.rel_paystate);
        this.mTvAppName = (TextView) view.findViewById(R.id.tv_appname);
        this.mIvTypeDrop = (ImageView) view.findViewById(R.id.iv_typedrop);
        this.mTvTime = (TextView) view.findViewById(R.id.tv_time);
        this.mIvTimeDrop = (ImageView) view.findViewById(R.id.iv_timedrop);
        this.mTvPayState = (TextView) view.findViewById(R.id.tv_paystate);
        this.mIvPayStateDrop = (ImageView) view.findViewById(R.id.iv_paydrop);
        this.mTopView = view.findViewById(R.id.v_line);
        this.mVPopBg = view.findViewById(R.id.v_popbg);
        this.mRelPay = (RelativeLayout) view.findViewById(R.id.rel_pay);
        this.mTvHejiText = (TextView) view.findViewById(R.id.tv_totaltext);
        this.mTvTotalMoney = (TextView) view.findViewById(R.id.tv_totalmoney);
        this.mTvHejiText.setVisibility(4);
        this.mTvTotalMoney.setVisibility(4);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_order, viewGroup, false);
        initViewNew(viewInflate);
        initClickListeners(viewInflate);
        initTitleBar();
        initData();
        this.myPopWindow = new MyPopWindow(getContext());
        initView();
        initListener();
        EventBus.getDefault().register(this);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.deviceorder));
    }

    private void initClickListeners(View view) {
        view.findViewById(R.id.rel_type).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m458xf08262d8(view2);
            }
        });
        view.findViewById(R.id.rel_time).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m459xf00bfcd9(view2);
            }
        });
        view.findViewById(R.id.rel_paystate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m460xef9596da(view2);
            }
        });
        view.findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m461xef1f30db(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-V4OrderFragment, reason: not valid java name */
    /* synthetic */ void m458xf08262d8(View view) {
        selectType();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-V4OrderFragment, reason: not valid java name */
    /* synthetic */ void m459xf00bfcd9(View view) {
        selectTime();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-V4OrderFragment, reason: not valid java name */
    /* synthetic */ void m460xef9596da(View view) {
        selectPayState();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v4-ui-V4OrderFragment, reason: not valid java name */
    /* synthetic */ void m461xef1f30db(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4NoPayOrderActivity.launch(getActivity());
    }

    public void onEventMainThread(UIVisableBean uIVisableBean) {
        LogUtil.e(TAG, "onEventMainThread:UIVisableBean" + uIVisableBean.index);
        if (uIVisableBean.index != 3) {
            this.mIsEnable = false;
        } else {
            this.mIsEnable = true;
        }
    }

    @Override // client.android.yixiaotong.BaseXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.e(TAG, "onResume  " + this.mIsNeedLoadOrder + "  " + this.mPayState + "  " + this.mIsEnable);
        showError50XTip();
        if (this.mIsEnable && this.mIsNeedLoadOrder) {
            this.mIsNeedLoadOrder = false;
            getRecord();
        }
    }

    @Override // client.android.yixiaotong.BaseXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LogUtil.e(TAG, "onPause  " + this.mIsNeedLoadOrder + "  " + this.mPayState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4OrderFragment.this.mMultiStateView.setViewState(3);
                V4OrderFragment.this.getRecord();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4OrderFragment.this.mCurrentPage = 1;
                V4OrderFragment.this.mTotalCount = 0;
                V4OrderFragment.this.mRecordListBeans.clear();
                V4OrderFragment.this.mApdater.notifyDataSetChanged();
                V4OrderFragment.this.mSwipeRefreshLayout.setRefreshing(true);
                V4OrderFragment.this.mLoadMoreFootView.setNoMoreData("");
                V4OrderFragment.this.getRecord();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                V4OrderFragment.this.getRecord();
            }
        });
    }

    private void initView() {
        if (this.mPayState == PayState.nopay) {
            this.mLinTitle.setVisibility(8);
        }
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    V4OrderFragment.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    V4OrderFragment.this.mSwipeRefreshLayout.setEnabled(false);
                }
                if (!V4OrderFragment.this.mHasMoreData || i + i2 < i3 || i3 <= V4OrderFragment.this.mTotalCount || i2 <= 1) {
                    return;
                }
                V4OrderFragment.this.mCurrentPage++;
                V4OrderFragment.this.mTotalCount = i3;
                V4OrderFragment.this.getRecord();
                V4OrderFragment.this.mLoadMoreFootView.loadMoreData();
            }
        });
    }

    private void initData() {
        this.mIsEnable = true;
        LogUtil.e("V4OrderFragment", "-----");
        this.mProductId = 0;
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
                if (this.mProductId != 0) {
                    if (this.mAppDatas.get(i2).productId == this.mProductId) {
                        this.mTypeList.add(V4LanguageUtils.getAppName(getActivity(), this.mAppDatas.get(i2).productId, this.mAppDatas.get(i2).appName));
                        this.mProductId = this.mAppDatas.get(i2).productId;
                    }
                } else {
                    this.mTypeList.add(V4LanguageUtils.getAppName(getActivity(), this.mAppDatas.get(i2).productId, this.mAppDatas.get(i2).appName));
                }
            }
            if (this.mProductId == 0) {
                this.mProductId = this.mAppDatas.get(0).productId;
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
            this.myPopWindow.showPop(this.mTopView, this.mSelectTypeIndex, this.mTypeList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment.5
                @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                public void onShow(int i) {
                    V4OrderFragment.this.mTvAppName.setText(V4LanguageUtils.getAppName(V4OrderFragment.this.getActivity(), ((V4HomeInfoBean) V4OrderFragment.this.mAppDatas.get(i)).productId, ((V4HomeInfoBean) V4OrderFragment.this.mAppDatas.get(i)).appName));
                    LogUtil.e(V4OrderFragment.TAG, "onShow:" + V4OrderFragment.this.mSelectTypeIndex + "  " + i + PPSLabelView.Code + ((V4HomeInfoBean) V4OrderFragment.this.mAppDatas.get(i)).appName);
                    if (V4OrderFragment.this.mSelectTypeIndex != i) {
                        V4OrderFragment v4OrderFragment = V4OrderFragment.this;
                        v4OrderFragment.mProductId = ((V4HomeInfoBean) v4OrderFragment.mAppDatas.get(i)).productId;
                        V4OrderFragment.this.mRecordListBeans.clear();
                        V4OrderFragment.this.mApdater.notifyDataSetChanged();
                        V4OrderFragment.this.mTotalCount = 0;
                        V4OrderFragment.this.mSwipeRefreshLayout.setRefreshing(true);
                        V4OrderFragment.this.mLoadMoreFootView.setNoMoreData("");
                        V4OrderFragment.this.mCurrentPage = 1;
                        V4OrderFragment.this.getRecord();
                    }
                    V4OrderFragment.this.mSelectTypeIndex = i;
                }

                @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                public void onDiss() {
                    V4OrderFragment.this.mVPopBg.setVisibility(8);
                    V4OrderFragment.this.initAnim(180.0f, 360.0f);
                    V4OrderFragment.this.mIvTypeDrop.startAnimation(V4OrderFragment.this.rotate);
                }
            });
        }
    }

    private void selectTime() {
        initAnim(0.0f, 180.0f);
        this.mIvTimeDrop.startAnimation(this.rotate);
        backgroudAlpha();
        this.myPopWindow.showPop(this.mTopView, this.mSelectDateIndex, this.mDateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment.6
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                V4OrderFragment.this.mTvTime.setText((CharSequence) V4OrderFragment.this.mDateList.get(i));
                if (V4OrderFragment.this.mSelectDateIndex != i) {
                    V4OrderFragment.this.mRecordListBeans.clear();
                    V4OrderFragment.this.mApdater.notifyDataSetChanged();
                    V4OrderFragment.this.mTotalCount = 0;
                    V4OrderFragment.this.mSwipeRefreshLayout.setRefreshing(true);
                    V4OrderFragment.this.mLoadMoreFootView.setNoMoreData("");
                    V4OrderFragment.this.mCurrentPage = 1;
                    V4OrderFragment.this.mSelectDateIndex = i;
                    V4OrderFragment.this.getRecord();
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                V4OrderFragment.this.mVPopBg.setVisibility(8);
                V4OrderFragment.this.initAnim(180.0f, 360.0f);
                V4OrderFragment.this.mIvTimeDrop.startAnimation(V4OrderFragment.this.rotate);
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
        this.myPopWindow.showPop(this.mTopView, this.mSelectPayStateIndex == 1 ? 0 : 1, this.mPayStateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment.7
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                V4OrderFragment.this.mTvPayState.setText((CharSequence) V4OrderFragment.this.mPayStateList.get(i));
                int i2 = i == 1 ? 0 : 1;
                if (V4OrderFragment.this.mSelectPayStateIndex != i2) {
                    V4OrderFragment.this.mRecordListBeans.clear();
                    V4OrderFragment.this.mApdater.notifyDataSetChanged();
                    V4OrderFragment.this.mTotalCount = 0;
                    V4OrderFragment.this.mSwipeRefreshLayout.setRefreshing(true);
                    V4OrderFragment.this.mLoadMoreFootView.setNoMoreData("");
                    V4OrderFragment.this.mCurrentPage = 1;
                    if (i2 == 1) {
                        V4OrderFragment.this.mPayState = PayState.pay;
                        V4OrderFragment.this.mRelPay.setVisibility(8);
                    } else {
                        V4OrderFragment.this.mPayState = PayState.nopay;
                    }
                    V4OrderFragment.this.mSelectPayStateIndex = i2;
                    V4OrderFragment.this.getRecord();
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                V4OrderFragment.this.mVPopBg.setVisibility(8);
                V4OrderFragment.this.initAnim(180.0f, 360.0f);
                V4OrderFragment.this.mIvPayStateDrop.startAnimation(V4OrderFragment.this.rotate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecord() {
        LogUtil.e(TAG, "getRecord:" + this.mSelectTypeIndex + PPSLabelView.Code + this.mAppDatas.get(this.mSelectTypeIndex).productId);
        V4BusinessControllers.getInstance().getConsumeRecord(getLoginAccount(), this.mSelectDateIndex, this.mCurrentPage, this.mProductId, this.mSelectPayStateIndex, new Listener<V4BathRecordListBean>() { // from class: client.android.yixiaotong.v4.ui.V4OrderFragment.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4OrderFragment.this.mHasMoreData = false;
                if (V4OrderFragment.this.mCurrentPage == 1) {
                    V4OrderFragment.this.mSwipeRefreshLayout.setRefreshing(true);
                    V4OrderFragment.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    V4OrderFragment.this.mLoadMoreFootView.loadMoreData();
                }
                V4OrderFragment.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4BathRecordListBean v4BathRecordListBean, Object... objArr) {
                LogUtil.e(V4OrderFragment.TAG, "getRecord:onComplete" + V4OrderFragment.this.mIsEnable);
                if (V4OrderFragment.this.mIsEnable) {
                    V4OrderFragment.this.showError50XTip();
                    V4OrderFragment.this.mMultiStateView.setViewState(0);
                    V4OrderFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (v4BathRecordListBean.records != null) {
                        if (V4OrderFragment.this.mCurrentPage == 1) {
                            V4OrderFragment.this.mRecordListBeans.clear();
                        }
                        V4OrderFragment.this.mRecordListBeans.addAll(v4BathRecordListBean.records);
                        V4OrderFragment.this.mApdater.notifyDataSetChanged();
                        if (v4BathRecordListBean.pages > v4BathRecordListBean.current) {
                            V4OrderFragment.this.mHasMoreData = true;
                            V4OrderFragment.this.mLoadMoreFootView.setVisibility(0);
                            V4OrderFragment.this.mLoadMoreFootView.reset();
                        } else {
                            V4OrderFragment.this.mLoadMoreFootView.setNoMoreData();
                        }
                        if (V4OrderFragment.this.mRecordListBeans.size() == 0) {
                            V4OrderFragment.this.mMultiStateView.setViewState(2);
                            return;
                        } else {
                            if (V4OrderFragment.this.mPayState != PayState.nopay || V4OrderFragment.this.mRecordListBeans.size() <= 0) {
                                return;
                            }
                            V4OrderFragment.this.mRelPay.setVisibility(0);
                            return;
                        }
                    }
                    V4OrderFragment.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4OrderFragment.this.mIsEnable) {
                    if (V4OrderFragment.this.mCurrentPage == 1) {
                        V4OrderFragment.this.mMultiStateView.setViewState(1);
                        V4OrderFragment.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")");
                    } else {
                        V4OrderFragment.this.mLoadMoreFootView.resetForFail();
                    }
                    V4OrderFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                    V4OrderFragment.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        showError50XTip();
        if (clientException.isNeedExitAppV4(clientException.getCode())) {
            AccountManager.getInstance().clearLoginAccount();
            LoginActivity.launch((Activity) getActivity());
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
            return V4OrderFragment.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return V4OrderFragment.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4OrderFragment.this.getContext()).inflate(R.layout.layout_orderrecord_item_v3, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.tv_type.setText(V4OrderFragment.this.mTvAppName.getText().toString());
            viewHolder.tv_orderstate.setVisibility(8);
            V4BathRecordBean v4BathRecordBean = (V4BathRecordBean) getItem(i);
            viewHolder.tv_orderid.setText(V4OrderFragment.this.getResources().getString(R.string.orderno1) + v4BathRecordBean.consumeOrderId);
            viewHolder.tv_money.setText("¥" + v4BathRecordBean.consume);
            viewHolder.tv_time.setText(v4BathRecordBean.useTime);
            viewHolder.tv_state.setText(v4BathRecordBean.payName);
            viewHolder.tv_state.setTextColor(V4OrderFragment.this.getResources().getColor(R.color.ffa1a6b3));
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

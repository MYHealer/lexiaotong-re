package client.android.yixiaotong.v3.ui.order;

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
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.adapter.MyPopWindow;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.drawmoney.DMOrderDetailBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMOrderRecordBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.PayPaymentBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.ZlPaymentJson;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderListBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderResultBean;
import client.android.yixiaotong.v3.bean.order.OrderDetailBean;
import client.android.yixiaotong.v3.bean.order.OrderRecordBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMOrderDetailActivity;
import client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.ui.wallet.controlutil.V3WalletControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.gnete.upbc.cashier.GnetePayConfig;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ConsumeRecordActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "ConsumeRecordActivity";
    private RecordsAdapter mApdater;
    private InvestorInfoBean mInvestorInfoBean;
    private ImageView mIvPayStateDrop;
    private ImageView mIvTimeDrop;
    private ImageView mIvTypeDrop;
    private LinearLayout mLinTitle;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private int mOrderPayFlag;
    private int mOrderPayFlagType;
    private int mOrderPayPaymentFlag;
    private int mPayPaymentFlag;
    private RelativeLayout mRelPay;
    private RelativeLayout mRelPayState;
    private RelativeLayout mRelType;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private View mTopView;
    private int mTotalMoney;
    private TextView mTvAppName;
    private TextView mTvErrorTip;
    private TextView mTvPayState;
    private TextView mTvTime;
    private TextView mTvTotalMoney;
    private View mVPopBg;
    private ZlPaymentJson mZlPaymentJson;
    private MyPopWindow myPopWindow;
    private RotateAnimation rotate;
    private List<PayPaymentBean> mPayPaymentBeanList = new ArrayList();
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private int mSelectWay = 0;
    private List<NoPayOrderBean> mNoPayRecordListBeans = new ArrayList();
    private boolean mIsEnable = true;
    private final List<Object> mRecordListBeans = new ArrayList();
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private List<TypeInfoBean> mAppDatas = new ArrayList();
    private List<String> mTypeList = new ArrayList();
    private List<String> mDateList = new ArrayList();
    private List<String> mPayStateList = new ArrayList();
    private int mTypeId = 0;
    private int mSelectTypeIndex = 0;
    private int mSelectDateIndex = 0;
    private int mSelectPayStateIndex = 0;
    private int mCurrentPage = 1;
    private boolean mIsNeedLoadOrder = true;
    private boolean mHasUnPayMergeOrder = false;
    private int mTypeIdTemp = 0;
    private int mOrderType = 0;
    private PayState mPayState = PayState.pay;
    private boolean mIsFinish = false;
    private boolean mIsError = false;

    private enum PayState {
        pay,
        nopay,
        refund
    }

    static {
        StubApp.interface11(10022);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ConsumeRecordActivity.class).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
        }
    }

    public static void launch(Activity activity, int i, boolean z) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ConsumeRecordActivity.class).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i).putExtra("isnopay", z));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
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
        this.mTvTotalMoney = (TextView) findViewById(R.id.tv_totalmoney);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.deviceorder));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.rel_type).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m380xd27ce176(view);
            }
        });
        findViewById(R.id.rel_time).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m381x8cf281f7(view);
            }
        });
        findViewById(R.id.rel_paystate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m382x47682278(view);
            }
        });
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m383x1ddc2f9(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-order-ConsumeRecordActivity, reason: not valid java name */
    /* synthetic */ void m380xd27ce176(View view) {
        selectType();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-order-ConsumeRecordActivity, reason: not valid java name */
    /* synthetic */ void m381x8cf281f7(View view) {
        selectTime();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-order-ConsumeRecordActivity, reason: not valid java name */
    /* synthetic */ void m382x47682278(View view) {
        selectPayState();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-order-ConsumeRecordActivity, reason: not valid java name */
    /* synthetic */ void m383x1ddc2f9(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        handlePayment();
    }

    private void handlePayment() {
        if (InvestorInfoUtilControl.getInstance().getPlanFlag(this.mTypeId) == 1) {
            this.mHasUnPayMergeOrder = false;
            payOrders();
        } else {
            OrderPayWayActivity.launch(getActivity(), this.mTypeId, this.mTotalMoney, this.mNoPayRecordListBeans);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        LogUtil.e(TAG, "onResume  " + this.mIsNeedLoadOrder + PPSLabelView.Code + this.mPayState + "  " + this.mTypeId);
        if (this.mIsError) {
            return;
        }
        if (this.mPayState == PayState.nopay) {
            getNoPayRecord();
        } else {
            getRecord();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConsumeRecordActivity.this.mMultiStateView.setViewState(3);
                if (ConsumeRecordActivity.this.mPayState == PayState.nopay) {
                    ConsumeRecordActivity.this.getNoPayRecord();
                } else {
                    ConsumeRecordActivity.this.getRecord();
                }
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                ConsumeRecordActivity.this.mCurrentPage = 1;
                ConsumeRecordActivity.this.mTotalCount = 0;
                ConsumeRecordActivity.this.mRecordListBeans.clear();
                ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                if (ConsumeRecordActivity.this.mPayState == PayState.nopay) {
                    ConsumeRecordActivity.this.getNoPayRecord();
                } else {
                    ConsumeRecordActivity.this.getRecord();
                }
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                if (ConsumeRecordActivity.this.mPayState == PayState.nopay) {
                    ConsumeRecordActivity.this.getNoPayRecord();
                } else {
                    ConsumeRecordActivity.this.getRecord();
                }
            }
        });
    }

    private void initView() {
        if (this.mTypeIdTemp != 0) {
            this.mRelType.setVisibility(8);
            if (this.mTypeIdTemp == 20) {
                this.mRelPayState.setVisibility(8);
            }
        }
        if (this.mPayState == PayState.nopay) {
            this.mTvPayState.setText("未支付");
        }
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setEnabled(false);
                }
                if (!ConsumeRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= ConsumeRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                ConsumeRecordActivity.this.mCurrentPage++;
                ConsumeRecordActivity.this.mTotalCount = i3;
                if (ConsumeRecordActivity.this.mPayState == PayState.nopay) {
                    ConsumeRecordActivity.this.getNoPayRecord();
                } else {
                    ConsumeRecordActivity.this.getRecord();
                }
                ConsumeRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
    }

    private void initData() {
        this.mInvestorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
        this.mSelectTypeIndex = 0;
        this.mSelectDateIndex = 0;
        this.mSelectPayStateIndex = 0;
        this.mCurrentPage = 1;
        this.mPayState = PayState.pay;
        this.mOrderType = 0;
        this.mAppDatas.clear();
        this.mTypeList.clear();
        this.mDateList.clear();
        this.mPayStateList.clear();
        if (this.mInvestorInfoBean != null) {
            List<TypeInfoBean> typeInfoBeans = InvestorInfoUtilControl.getInstance().getTypeInfoBeans();
            this.mAppDatas = typeInfoBeans;
            if (typeInfoBeans.size() > 0) {
                for (int i = 0; i < this.mAppDatas.size(); i++) {
                    if (this.mTypeId != 0) {
                        if (this.mAppDatas.get(i).base.typeId == this.mTypeId) {
                            this.mTypeList.add(LanguageUtils.getAppName(getActivity(), this.mAppDatas.get(i).base.typeId, this.mAppDatas.get(i).base.appName));
                            this.mTypeId = this.mAppDatas.get(i).base.typeId;
                        }
                    } else {
                        this.mTypeList.add(LanguageUtils.getAppName(getActivity(), this.mAppDatas.get(i).base.typeId, this.mAppDatas.get(i).base.appName));
                    }
                }
                if (this.mTypeId == 0) {
                    this.mTypeId = this.mAppDatas.get(0).base.typeId;
                }
                if (this.mTypeList.size() > 0) {
                    this.mTvAppName.setText(this.mTypeList.get(0));
                }
                getPayment(0);
            }
            this.mDateList.add(getResources().getString(R.string.nearlyservendays));
            this.mDateList.add(getResources().getString(R.string.nearlyfifteendays));
            this.mDateList.add(getResources().getString(R.string.nearlyamonth));
            this.mDateList.add(getResources().getString(R.string.nearlythreemonth));
            this.mDateList.add(getResources().getString(R.string.all));
            this.mTvTime.setText(this.mDateList.get(0));
            this.mPayStateList.add(getResources().getString(R.string.payed));
            this.mPayStateList.add(getResources().getString(R.string.weizhifu));
            this.mTvPayState.setText(this.mPayStateList.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPayment(int i) {
        this.mPayPaymentFlag = InvestorInfoUtilControl.getInstance().getPayPaymentFlag(this.mAppDatas.get(i).base.typeId);
        this.mZlPaymentJson = this.mAppDatas.get(i).zlPaymentJson;
        this.mPayFlagTypeList.clear();
        this.mPayPaymentBeanList.clear();
        if (this.mZlPaymentJson != null) {
            for (int i2 = 0; i2 < this.mZlPaymentJson.payPaymentList.size(); i2++) {
                LogUtil.e(TAG, "getPayment:" + i2 + "  " + this.mZlPaymentJson.payPaymentList.get(i2).payFlag + "  " + this.mZlPaymentJson.payPaymentList.get(i2).payFlagType);
                if (this.mZlPaymentJson.payPaymentList.get(i2).payFlag == 1) {
                    this.mPayFlagTypeList.add(Integer.valueOf(this.mZlPaymentJson.payPaymentList.get(i2).payFlagType));
                    this.mPayPaymentBeanList.add(this.mZlPaymentJson.payPaymentList.get(i2));
                }
            }
        }
    }

    private void selectType() {
        if (this.mAppDatas.size() == this.mTypeList.size()) {
            initAnim(0.0f, 180.0f);
            this.mIvTypeDrop.startAnimation(this.rotate);
            backgroudAlpha();
            this.myPopWindow.showPop(this.mTopView, this.mSelectTypeIndex, this.mTypeList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.5
                @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                public void onShow(int i) {
                    ConsumeRecordActivity.this.mTvAppName.setText(LanguageUtils.getAppName(ConsumeRecordActivity.this.getActivity(), ((TypeInfoBean) ConsumeRecordActivity.this.mAppDatas.get(i)).base.typeId, ((TypeInfoBean) ConsumeRecordActivity.this.mAppDatas.get(i)).base.appName));
                    LogUtil.e(ConsumeRecordActivity.TAG, "onShow:" + ConsumeRecordActivity.this.mSelectTypeIndex + "  " + i + PPSLabelView.Code + ((TypeInfoBean) ConsumeRecordActivity.this.mAppDatas.get(i)).base.appName);
                    if (ConsumeRecordActivity.this.mSelectTypeIndex != i) {
                        ConsumeRecordActivity consumeRecordActivity = ConsumeRecordActivity.this;
                        consumeRecordActivity.mTypeId = ((TypeInfoBean) consumeRecordActivity.mAppDatas.get(i)).base.typeId;
                        if (ConsumeRecordActivity.this.mTypeId != 20 && ConsumeRecordActivity.this.mPayState == PayState.refund) {
                            ConsumeRecordActivity.this.mTvPayState.setText((CharSequence) ConsumeRecordActivity.this.mPayStateList.get(0));
                            ConsumeRecordActivity.this.mPayState = PayState.pay;
                            ConsumeRecordActivity.this.mRelPay.setVisibility(8);
                        }
                        ConsumeRecordActivity.this.mRecordListBeans.clear();
                        ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                        ConsumeRecordActivity.this.mTotalCount = 0;
                        ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                        ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                        ConsumeRecordActivity.this.mCurrentPage = 1;
                        ConsumeRecordActivity.this.getPayment(i);
                        if (ConsumeRecordActivity.this.mPayState == PayState.nopay) {
                            ConsumeRecordActivity.this.getNoPayRecord();
                        } else {
                            ConsumeRecordActivity.this.getRecord();
                        }
                    }
                    ConsumeRecordActivity.this.mSelectTypeIndex = i;
                }

                @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                public void onDiss() {
                    ConsumeRecordActivity.this.mVPopBg.setVisibility(8);
                    ConsumeRecordActivity.this.initAnim(180.0f, 360.0f);
                    ConsumeRecordActivity.this.mIvTypeDrop.startAnimation(ConsumeRecordActivity.this.rotate);
                }
            });
        }
    }

    private void selectTime() {
        initAnim(0.0f, 180.0f);
        this.mIvTimeDrop.startAnimation(this.rotate);
        backgroudAlpha();
        this.myPopWindow.showPop(this.mTopView, this.mSelectDateIndex, this.mDateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.6
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                ConsumeRecordActivity.this.mTvTime.setText((CharSequence) ConsumeRecordActivity.this.mDateList.get(i));
                if (ConsumeRecordActivity.this.mSelectDateIndex != i) {
                    ConsumeRecordActivity.this.mRecordListBeans.clear();
                    ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                    ConsumeRecordActivity.this.mTotalCount = 0;
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                    ConsumeRecordActivity.this.mCurrentPage = 1;
                    ConsumeRecordActivity.this.mSelectDateIndex = i;
                    if (ConsumeRecordActivity.this.mPayState == PayState.nopay) {
                        ConsumeRecordActivity.this.getNoPayRecord();
                    } else {
                        ConsumeRecordActivity.this.getRecord();
                    }
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                ConsumeRecordActivity.this.mVPopBg.setVisibility(8);
                ConsumeRecordActivity.this.initAnim(180.0f, 360.0f);
                ConsumeRecordActivity.this.mIvTimeDrop.startAnimation(ConsumeRecordActivity.this.rotate);
            }
        });
    }

    private void selectPayState() {
        if (this.mTypeId == 20) {
            if (this.mAppDatas.get(this.mSelectTypeIndex).extendJson != null && this.mAppDatas.get(this.mSelectTypeIndex).extendJson.type == 1) {
                if (this.mPayStateList.size() <= 2) {
                    this.mPayStateList.add(getResources().getString(R.string.refund));
                }
            } else if (this.mPayStateList.size() > 2) {
                this.mPayStateList.remove(2);
                this.mSelectPayStateIndex = 0;
            }
        } else if (this.mPayStateList.size() > 2) {
            this.mPayStateList.remove(2);
            this.mSelectPayStateIndex = 0;
        }
        initAnim(0.0f, 180.0f);
        this.mIvPayStateDrop.startAnimation(this.rotate);
        backgroudAlpha();
        this.myPopWindow.showPop(this.mTopView, this.mSelectPayStateIndex, this.mPayStateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.7
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                ConsumeRecordActivity.this.mTvPayState.setText((CharSequence) ConsumeRecordActivity.this.mPayStateList.get(i));
                if (ConsumeRecordActivity.this.mSelectPayStateIndex != i) {
                    ConsumeRecordActivity.this.mRecordListBeans.clear();
                    ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                    ConsumeRecordActivity.this.mTotalCount = 0;
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                    ConsumeRecordActivity.this.mCurrentPage = 1;
                    if (i == 2) {
                        ConsumeRecordActivity.this.mOrderType = 1;
                        ConsumeRecordActivity.this.mPayState = PayState.refund;
                        ConsumeRecordActivity.this.getRecord();
                    } else if (i == 1) {
                        ConsumeRecordActivity.this.mPayState = PayState.nopay;
                        ConsumeRecordActivity.this.getNoPayRecord();
                    } else {
                        ConsumeRecordActivity.this.mOrderType = 0;
                        ConsumeRecordActivity.this.mPayState = PayState.pay;
                        ConsumeRecordActivity.this.mRelPay.setVisibility(8);
                        ConsumeRecordActivity.this.getRecord();
                    }
                }
                ConsumeRecordActivity.this.mSelectPayStateIndex = i;
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                ConsumeRecordActivity.this.mVPopBg.setVisibility(8);
                ConsumeRecordActivity.this.initAnim(180.0f, 360.0f);
                ConsumeRecordActivity.this.mIvPayStateDrop.startAnimation(ConsumeRecordActivity.this.rotate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x00bd  */
    public void getRecord() {
        String str;
        String str2;
        int i;
        String str3;
        if (this.mTypeId == 20) {
            getDMRecord();
            return;
        }
        String str4 = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "";
        int i2 = this.mSelectDateIndex + 1;
        if (this.mTypeId == 18) {
            String typeIdMachineId = LocalDataUtil.getTypeIdMachineId(getActivity(), 18);
            if (StringUtils.isNotEmpty(typeIdMachineId)) {
                if (typeIdMachineId.split(";").length >= 1) {
                    LogUtil.e(TAG, typeIdMachineId.split(";")[0] + "  " + typeIdMachineId.split(";")[1] + "  " + typeIdMachineId.split(";")[2]);
                    str3 = typeIdMachineId.split(";")[0];
                } else {
                    str3 = null;
                }
                if (typeIdMachineId.split(";").length >= 5) {
                    String str5 = typeIdMachineId.split(";")[3];
                    i = Integer.parseInt(typeIdMachineId.split(";")[4]);
                    str = str3;
                    str2 = str5;
                } else {
                    str = str3;
                    str2 = null;
                }
            } else {
                str = null;
                str2 = null;
            }
            i = -1;
        } else {
            str = null;
            str2 = null;
            i = -1;
        }
        V3BusinessControllers.getInstance().getOrderList(getLoginAccount(), str4, this.mTypeId, i2, this.mCurrentPage, str, str2, i, new Listener<OrderRecordBean>() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                ConsumeRecordActivity.this.mIsError = false;
                ConsumeRecordActivity.this.mHasMoreData = false;
                if (ConsumeRecordActivity.this.mCurrentPage == 1) {
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    ConsumeRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                ConsumeRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, OrderRecordBean orderRecordBean, Object... objArr) {
                if (ConsumeRecordActivity.this.mIsEnable && ConsumeRecordActivity.this.mPayState == PayState.pay) {
                    ConsumeRecordActivity.this.mMultiStateView.setViewState(0);
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (orderRecordBean == null || orderRecordBean.records == null) {
                        ConsumeRecordActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    if (ConsumeRecordActivity.this.mCurrentPage == 1) {
                        ConsumeRecordActivity.this.mRecordListBeans.clear();
                    }
                    for (int i3 = 0; i3 < orderRecordBean.records.size(); i3++) {
                        if (orderRecordBean.records.get(i3).payCode == 1) {
                            ConsumeRecordActivity.this.mRecordListBeans.add(orderRecordBean.records.get(i3));
                        }
                    }
                    ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                    if (orderRecordBean.totalPage > orderRecordBean.currentPage) {
                        ConsumeRecordActivity.this.mHasMoreData = true;
                        ConsumeRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                        ConsumeRecordActivity.this.mLoadMoreFootView.reset();
                    } else {
                        ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                    }
                    if (ConsumeRecordActivity.this.mRecordListBeans.size() == 0) {
                        ConsumeRecordActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ConsumeRecordActivity.this.mIsEnable) {
                    if (ConsumeRecordActivity.this.mCurrentPage == 1) {
                        ConsumeRecordActivity.this.mMultiStateView.setViewState(1);
                        ConsumeRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(ConsumeRecordActivity.this.getContext()));
                    } else {
                        ConsumeRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    ConsumeRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getDMRecord() {
        V3BusinessControllers.getInstance().getOrderIntegration(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, this.mTypeId, this.mSelectDateIndex + 1, this.mCurrentPage, this.mOrderType, new Listener<DMOrderRecordBean>() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                ConsumeRecordActivity.this.mIsError = false;
                ConsumeRecordActivity.this.mHasMoreData = false;
                if (ConsumeRecordActivity.this.mCurrentPage == 1) {
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    ConsumeRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                ConsumeRecordActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DMOrderRecordBean dMOrderRecordBean, Object... objArr) {
                if (!ConsumeRecordActivity.this.mIsEnable || ConsumeRecordActivity.this.mPayState == PayState.nopay) {
                    return;
                }
                ConsumeRecordActivity.this.mMultiStateView.setViewState(0);
                ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                if (dMOrderRecordBean == null || dMOrderRecordBean.records == null) {
                    ConsumeRecordActivity.this.mMultiStateView.setViewState(2);
                    return;
                }
                if (ConsumeRecordActivity.this.mCurrentPage == 1) {
                    ConsumeRecordActivity.this.mRecordListBeans.clear();
                }
                for (int i = 0; i < dMOrderRecordBean.records.size(); i++) {
                    ConsumeRecordActivity.this.mRecordListBeans.add(dMOrderRecordBean.records.get(i));
                }
                ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                if (dMOrderRecordBean.totalPage > dMOrderRecordBean.currentPage) {
                    ConsumeRecordActivity.this.mHasMoreData = true;
                    ConsumeRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                    ConsumeRecordActivity.this.mLoadMoreFootView.reset();
                } else {
                    ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                }
                if (ConsumeRecordActivity.this.mRecordListBeans.size() == 0) {
                    ConsumeRecordActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ConsumeRecordActivity.this.mIsEnable) {
                    if (ConsumeRecordActivity.this.mCurrentPage == 1) {
                        ConsumeRecordActivity.this.mMultiStateView.setViewState(1);
                        ConsumeRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(ConsumeRecordActivity.this.getContext()));
                    } else {
                        ConsumeRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    ConsumeRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x00b8  */
    public void getNoPayRecord() {
        String str;
        String str2;
        int i;
        String str3;
        String str4 = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "";
        String str5 = UserInfoUtil.getInstance().getLoginAccountV3().studentId;
        if (this.mTypeId == 18) {
            String typeIdMachineId = LocalDataUtil.getTypeIdMachineId(getActivity(), 18);
            if (StringUtils.isNotEmpty(typeIdMachineId)) {
                if (typeIdMachineId.split(";").length >= 1) {
                    LogUtil.e(TAG, typeIdMachineId.split(";")[0] + "  " + typeIdMachineId.split(";")[1] + "  " + typeIdMachineId.split(";")[2]);
                    str3 = typeIdMachineId.split(";")[0];
                } else {
                    str3 = null;
                }
                if (typeIdMachineId.split(";").length >= 5) {
                    String str6 = typeIdMachineId.split(";")[3];
                    i = Integer.parseInt(typeIdMachineId.split(";")[4]);
                    str2 = str6;
                } else {
                    str2 = null;
                    i = -1;
                }
                str = str3;
            } else {
                str = null;
                str2 = null;
                i = -1;
            }
        } else {
            str = null;
            str2 = null;
            i = -1;
        }
        V3BusinessControllers.getInstance().getNoPayOrders(getLoginAccount(), str4, this.mTypeId, this.mInvestorInfoBean.investorId, str5, str, str2, i, new Listener<NoPayOrderListBean>() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                ConsumeRecordActivity.this.mIsError = false;
                ConsumeRecordActivity.this.mHasMoreData = false;
                ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                ConsumeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                ConsumeRecordActivity.this.mMultiStateView.getView(3);
                ConsumeRecordActivity.this.mRelPay.setVisibility(8);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, NoPayOrderListBean noPayOrderListBean, Object... objArr) {
                if (ConsumeRecordActivity.this.mIsEnable && ConsumeRecordActivity.this.mPayState == PayState.nopay) {
                    ConsumeRecordActivity.this.mMultiStateView.setViewState(0);
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (noPayOrderListBean != null) {
                        ConsumeRecordActivity.this.mRecordListBeans.clear();
                        ConsumeRecordActivity.this.mRecordListBeans.addAll(noPayOrderListBean.orderList);
                        ConsumeRecordActivity.this.initNoPayData(noPayOrderListBean.orderList);
                        ConsumeRecordActivity.this.mApdater.notifyDataSetChanged();
                        if (noPayOrderListBean.orderList.size() == 0) {
                            ConsumeRecordActivity.this.mMultiStateView.setViewState(2);
                            if (ConsumeRecordActivity.this.mIsFinish) {
                                ConsumeRecordActivity.this.getActivity().finish();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ConsumeRecordActivity.this.mMultiStateView.setViewState(2);
                    if (ConsumeRecordActivity.this.mIsFinish) {
                        ConsumeRecordActivity.this.getActivity().finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ConsumeRecordActivity.this.mIsEnable) {
                    if (ConsumeRecordActivity.this.mCurrentPage == 1) {
                        ConsumeRecordActivity.this.mMultiStateView.setViewState(1);
                        ConsumeRecordActivity.this.mTvErrorTip.setText(clientException.getDetail() + "(" + clientException.getCode() + ")\nTraceId:" + LocalDataUtil.getTraceID(ConsumeRecordActivity.this.getContext()));
                    } else {
                        ConsumeRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    ConsumeRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    ConsumeRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNoPayData(List<NoPayOrderBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mRelPay.setVisibility(0);
        this.mNoPayRecordListBeans.clear();
        if (list.size() > 0) {
            this.mNoPayRecordListBeans.addAll(list);
        }
        this.mTotalMoney = 0;
        for (int i = 0; i < this.mNoPayRecordListBeans.size(); i++) {
            this.mTotalMoney = this.mNoPayRecordListBeans.get(i).price + this.mTotalMoney;
        }
        this.mTvTotalMoney.setText("¥" + DecimalUtil.divide(this.mTotalMoney + "", "100"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x00ee  */
    public void payOrders() {
        int i;
        int i2;
        String str;
        String str2;
        int i3;
        String str3;
        String str4 = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "";
        if (this.mZlPaymentJson == null) {
            ToastUtils.show(getContext(), "未配置单笔支付方案");
            return;
        }
        int i4 = this.mPayPaymentFlag;
        if (this.mPayPaymentBeanList.size() > 0) {
            i = this.mPayPaymentBeanList.get(this.mSelectWay).payFlag;
            i2 = this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType;
        } else {
            i = 0;
            i2 = 0;
        }
        if (this.mHasUnPayMergeOrder) {
            i4 = this.mOrderPayPaymentFlag;
            i = this.mOrderPayFlag;
            i2 = this.mOrderPayFlagType;
        }
        int i5 = i4;
        int i6 = i;
        int i7 = i2;
        if (this.mTypeId == 18) {
            String typeIdMachineId = LocalDataUtil.getTypeIdMachineId(getActivity(), 18);
            if (StringUtils.isNotEmpty(typeIdMachineId)) {
                if (typeIdMachineId.split(";").length >= 1) {
                    LogUtil.e(TAG, typeIdMachineId.split(";")[0] + "  " + typeIdMachineId.split(";")[1] + "  " + typeIdMachineId.split(";")[2]);
                    str3 = typeIdMachineId.split(";")[0];
                } else {
                    str3 = null;
                }
                if (typeIdMachineId.split(";").length >= 5) {
                    String str5 = typeIdMachineId.split(";")[3];
                    i3 = Integer.parseInt(typeIdMachineId.split(";")[4]);
                    str = str3;
                    str2 = str5;
                } else {
                    str = str3;
                    str2 = null;
                }
            } else {
                str = null;
                str2 = null;
            }
            i3 = -1;
        } else {
            str = null;
            str2 = null;
            i3 = -1;
        }
        V3BusinessControllers.getInstance().postPayOrders(getLoginAccount(), str4, this.mInvestorInfoBean.investorId, i5, i6, i7, this.mNoPayRecordListBeans, str, str2, i3, new Listener<NoPayOrderResultBean>() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                ConsumeRecordActivity.this.mIsError = false;
                BaseMaterialDialog.showMaterialDialog(ConsumeRecordActivity.this.getActivity(), "请求支付中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, final NoPayOrderResultBean noPayOrderResultBean, Object... objArr) {
                if (ConsumeRecordActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (noPayOrderResultBean == null) {
                        ToastUtils.show(ConsumeRecordActivity.this.getContext(), "数据异常");
                        return;
                    }
                    LogUtil.e(ConsumeRecordActivity.TAG, "statusFlag:" + noPayOrderResultBean.statusFlag);
                    if (noPayOrderResultBean.statusFlag == 2) {
                        ToastUtils.show(ConsumeRecordActivity.this.getContext(), "钱包支付成功！");
                        ConsumeRecordActivity.this.getNoPayRecord();
                        return;
                    }
                    if (noPayOrderResultBean.statusFlag == 0) {
                        ToastUtils.show(ConsumeRecordActivity.this.getContext(), "支付成功！");
                        ConsumeRecordActivity.this.getNoPayRecord();
                        return;
                    }
                    ConsumeRecordActivity.this.mIsNeedLoadOrder = false;
                    if (noPayOrderResultBean.hasUnPayMergeOrder) {
                        if (ConsumeRecordActivity.this.mHasUnPayMergeOrder) {
                            SystemErrorTip.getInstance().showTipDialog(ConsumeRecordActivity.this.getActivity(), noPayOrderResultBean.msg);
                            return;
                        } else {
                            OrderDetailDialog.getInstance().showDialog(ConsumeRecordActivity.this.getActivity(), new OrderDetailDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.11.1
                                @Override // client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog.Listener
                                public void onConfirm() {
                                    ConsumeRecordActivity.this.mHasUnPayMergeOrder = true;
                                    ConsumeRecordActivity.this.mNoPayRecordListBeans.clear();
                                    ConsumeRecordActivity.this.mNoPayRecordListBeans.addAll(noPayOrderResultBean.orderInfo);
                                    ConsumeRecordActivity.this.mOrderPayPaymentFlag = noPayOrderResultBean.paymentFlag;
                                    ConsumeRecordActivity.this.mOrderPayFlag = noPayOrderResultBean.payFlag;
                                    ConsumeRecordActivity.this.mOrderPayFlagType = noPayOrderResultBean.payFlagType;
                                    ConsumeRecordActivity.this.payOrders();
                                }

                                @Override // client.android.yixiaotong.v3.ui.dialog.OrderDetailDialog.Listener
                                public void onCancle() {
                                    ConsumeRecordActivity.this.cancelOrder();
                                }
                            }, noPayOrderResultBean.totalPrice, noPayOrderResultBean.mergeOrderId, noPayOrderResultBean.createTime);
                            return;
                        }
                    }
                    ConsumeRecordActivity.this.pay(noPayOrderResultBean);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ConsumeRecordActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ConsumeRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pay(NoPayOrderResultBean noPayOrderResultBean) {
        String str = "";
        if (noPayOrderResultBean.payInfo != null && (StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.tradeNo) || StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.orderString))) {
            if (noPayOrderResultBean.payInfo.mode == 0) {
                str = noPayOrderResultBean.payInfo.orderString;
            } else if (noPayOrderResultBean.payInfo.mode == 1) {
                str = noPayOrderResultBean.payInfo.tradeNo;
            }
            AliPayUtils.pay(getActivity(), str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.12
                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void paySuccess() {
                    ConsumeRecordActivity.this.mIsNeedLoadOrder = true;
                    ToastUtils.show(ConsumeRecordActivity.this.getContext(), "支付成功");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payWaitting() {
                    ToastUtils.show(ConsumeRecordActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payFail() {
                    ToastUtils.show(ConsumeRecordActivity.this.getContext(), "支付失败");
                }
            });
            return;
        }
        if (noPayOrderResultBean.payInfo != null && StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.appid)) {
            this.mIsNeedLoadOrder = true;
            WxPayUtils.pay(getActivity(), noPayOrderResultBean.payInfo.appid, noPayOrderResultBean.payInfo.partnerid, noPayOrderResultBean.payInfo.prepayid, noPayOrderResultBean.payInfo.noncestr, noPayOrderResultBean.payInfo.timestamp, noPayOrderResultBean.payInfo.sign);
            return;
        }
        if (noPayOrderResultBean.payInfo != null && noPayOrderResultBean.payInfo.msgBody != null) {
            if (noPayOrderResultBean.payInfo.msgBody.retCode.equals("00000")) {
                GnetePayConfig.builder().createWXAPI(getActivity(), "wxd9320c1760b6d01f");
                this.mIsNeedLoadOrder = true;
                V3WalletControlUtil.getInstance().sendPayRequest(noPayOrderResultBean.payInfo.msgBody.chnlUrl, 0, this.mTypeId);
                return;
            }
            SystemErrorTip.getInstance().showTipDialog(getActivity(), noPayOrderResultBean.payInfo.msgBody.retMsg);
            return;
        }
        List<PayPaymentBean> list = this.mPayPaymentBeanList;
        if (list != null && list.size() > 0 && this.mPayPaymentBeanList.get(this.mSelectWay) != null) {
            if (noPayOrderResultBean.payInfo != null) {
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 1) {
                    this.mIsNeedLoadOrder = true;
                    WxPayUtils.pay(getActivity(), noPayOrderResultBean.payInfo.appid, noPayOrderResultBean.payInfo.partnerid, noPayOrderResultBean.payInfo.prepayid, noPayOrderResultBean.payInfo.noncestr, noPayOrderResultBean.payInfo.timestamp, noPayOrderResultBean.payInfo.sign);
                    return;
                }
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 2) {
                    if (noPayOrderResultBean.payInfo.mode == 0) {
                        str = noPayOrderResultBean.payInfo.orderString;
                    } else if (noPayOrderResultBean.payInfo.mode == 1) {
                        str = noPayOrderResultBean.payInfo.tradeNo;
                    }
                    AliPayUtils.pay(getActivity(), str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.13
                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void paySuccess() {
                            ConsumeRecordActivity.this.mIsNeedLoadOrder = true;
                            ToastUtils.show(ConsumeRecordActivity.this.getContext(), "支付成功");
                        }

                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void payWaitting() {
                            ToastUtils.show(ConsumeRecordActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                        }

                        @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                        public void payFail() {
                            ToastUtils.show(ConsumeRecordActivity.this.getContext(), "支付失败");
                        }
                    });
                    return;
                }
                if (this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType == 3) {
                    if (noPayOrderResultBean.payInfo.msgBody.retCode.equals("00000")) {
                        GnetePayConfig.builder().createWXAPI(getActivity(), "wxd9320c1760b6d01f");
                        this.mIsNeedLoadOrder = true;
                        V3WalletControlUtil.getInstance().sendPayRequest(noPayOrderResultBean.payInfo.msgBody.chnlUrl, 0, this.mTypeId);
                        return;
                    } else if (noPayOrderResultBean.payInfo != null && noPayOrderResultBean.payInfo.msgBody != null) {
                        SystemErrorTip.getInstance().showTipDialog(getActivity(), noPayOrderResultBean.payInfo.msgBody.retMsg);
                        return;
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(getActivity(), "数据异常");
                        return;
                    }
                }
                return;
            }
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "数据异常");
            return;
        }
        ToastUtils.show(getContext(), "支付成功！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelOrder() {
        V3BusinessControllers.getInstance().postCancelPayOrders(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, new Listener<NoPayOrderResultBean>() { // from class: client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity.14
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                ConsumeRecordActivity.this.mIsError = false;
                BaseMaterialDialog.showMaterialDialog(ConsumeRecordActivity.this.getActivity(), "正在取消订单", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, NoPayOrderResultBean noPayOrderResultBean, Object... objArr) {
                if (ConsumeRecordActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(ConsumeRecordActivity.this.getContext(), "取消成功，请尝试再次支付");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ConsumeRecordActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ConsumeRecordActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            this.mIsError = true;
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mTypeId == 20) {
            DMOrderDetailBean dMOrderDetailBean = (DMOrderDetailBean) this.mApdater.getItem(i);
            if (dMOrderDetailBean.statusFlag == 2 && this.mPayState != PayState.refund) {
                LocalDataUtil.saveUnFinshOrderId(getContext(), dMOrderDetailBean.orderId + "," + dMOrderDetailBean.chargeMoney + "," + dMOrderDetailBean.machineId);
                if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeActivity.launch(getActivity(), 8);
                    return;
                } else {
                    ZxingScanV3Activity.launch(getActivity(), 8);
                    return;
                }
            }
            if (this.mPayState == PayState.refund) {
                DMOrderDetailActivity.launch(getActivity(), dMOrderDetailBean, 1);
                return;
            } else {
                DMOrderDetailActivity.launch(getActivity(), dMOrderDetailBean, 0);
                return;
            }
        }
        this.mIsError = true;
        if (this.mPayState == PayState.nopay) {
            OrderDetailActivity.launch(getActivity(), (NoPayOrderBean) this.mApdater.getItem(i), this.mTypeId);
        } else {
            OrderDetailActivity.launch(getActivity(), (OrderDetailBean) this.mApdater.getItem(i), this.mTypeId);
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
            return ConsumeRecordActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ConsumeRecordActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(ConsumeRecordActivity.this.getContext()).inflate(R.layout.layout_orderrecord_item_v3, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.tv_type.setText(ConsumeRecordActivity.this.mTvAppName.getText().toString());
            if (ConsumeRecordActivity.this.mTypeId == 18 && ConsumeRecordActivity.this.mPayState == PayState.pay) {
                viewHolder.tv_money.setVisibility(4);
            } else {
                viewHolder.tv_money.setVisibility(0);
            }
            if (ConsumeRecordActivity.this.mPayState != PayState.nopay) {
                if (ConsumeRecordActivity.this.mTypeId == 20) {
                    DMOrderDetailBean dMOrderDetailBean = (DMOrderDetailBean) getItem(i);
                    viewHolder.tv_orderid.setText(ConsumeRecordActivity.this.getResources().getString(R.string.orderno) + dMOrderDetailBean.orderId);
                    if (ConsumeRecordActivity.this.mPayState == PayState.refund) {
                        viewHolder.tv_money.setText("¥" + DecimalUtil.divide(dMOrderDetailBean.chargeMoney + "", "100"));
                        if (StringUtils.isNotEmpty(dMOrderDetailBean.payDateTime)) {
                            viewHolder.tv_time.setText(dMOrderDetailBean.payDateTime);
                        } else {
                            viewHolder.tv_time.setText(dMOrderDetailBean.createDateTime);
                        }
                        if (dMOrderDetailBean.statusFlag == 2) {
                            viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.orderrefundsuccessful));
                            viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.ffa1a6b3));
                        } else if (dMOrderDetailBean.statusFlag == 1) {
                            viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.createorder));
                            viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 3) {
                            viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.orderrefundfailed));
                            viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.fff3382a));
                        }
                    } else {
                        viewHolder.tv_money.setText("¥" + DecimalUtil.divide(dMOrderDetailBean.chargeMoney + "", "100"));
                        if (StringUtils.isNotEmpty(dMOrderDetailBean.payDateTime)) {
                            viewHolder.tv_time.setText(dMOrderDetailBean.payDateTime);
                        } else {
                            viewHolder.tv_time.setText(dMOrderDetailBean.createDateTime);
                        }
                        if (dMOrderDetailBean.statusFlag == 3) {
                            viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.orderhasbeenrecharged));
                            viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.ffa1a6b3));
                        } else if (dMOrderDetailBean.statusFlag == 1) {
                            viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.createorder));
                            viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 2) {
                            viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.orderpaid));
                            viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 4) {
                            viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.orderrechangefailed));
                            viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 5) {
                            viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.ordercancelled));
                            viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 6) {
                            viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.orderlocked));
                            viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 7) {
                            viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.orderrefund));
                            viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.fff3382a));
                        }
                    }
                } else {
                    viewHolder.tv_orderstate.setVisibility(8);
                    OrderDetailBean orderDetailBean = (OrderDetailBean) getItem(i);
                    viewHolder.tv_orderid.setText(ConsumeRecordActivity.this.getResources().getString(R.string.orderno) + orderDetailBean.orderId);
                    viewHolder.tv_money.setText("¥" + DecimalUtil.divide(orderDetailBean.posPrice + "", "100"));
                    viewHolder.tv_time.setText(orderDetailBean.posDateTime);
                    if (orderDetailBean.payCode == 1) {
                        viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.payed));
                        viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.ffa1a6b3));
                    } else {
                        viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.nopay));
                        viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.fff3382a));
                    }
                    if (ConsumeRecordActivity.this.mTypeId == 9 && StringUtils.isNotEmpty(orderDetailBean.orderType) && orderDetailBean.orderType.equals("100") && StringUtils.isNotEmpty(orderDetailBean.complete) && orderDetailBean.complete.equals("4")) {
                        viewHolder.tv_orderstate.setVisibility(0);
                    }
                }
            } else {
                NoPayOrderBean noPayOrderBean = (NoPayOrderBean) getItem(i);
                viewHolder.tv_orderid.setText(ConsumeRecordActivity.this.getResources().getString(R.string.orderno) + noPayOrderBean.orderId);
                viewHolder.tv_money.setText("¥" + DecimalUtil.divide(noPayOrderBean.price + "", "100"));
                viewHolder.tv_time.setText(noPayOrderBean.posDateTime);
                viewHolder.tv_state.setText(ConsumeRecordActivity.this.getResources().getString(R.string.nopay));
                viewHolder.tv_state.setTextColor(ConsumeRecordActivity.this.getResources().getColor(R.color.fff3382a));
            }
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

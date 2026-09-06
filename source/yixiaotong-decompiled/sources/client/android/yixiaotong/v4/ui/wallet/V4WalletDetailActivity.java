package client.android.yixiaotong.v4.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4PayConfigBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeListBean;
import client.android.yixiaotong.v4.http.bean.V4ServerListBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.ui.order.V4NoPayOrderActivity;
import client.android.yixiaotong.v4.ui.order.V4RechargeRefundRecordActivity;
import client.android.yixiaotong.v4.util.enumconfig.EnumPayFlag;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4WalletDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "V4WalletDetailActivity";
    private EditText mEtInputMoney;
    private LinearLayout mLinDefined;
    private LinearLayout mLinOrherMoney;
    private WrapGridView mListView;
    private WrapListView mLvRechargeWay;
    private RechargeMoneyAdapter mRechargeMoneyAdapter;
    private RechargeWayAdapter mRechargeWayAdapter;
    private RelativeLayout mRelNoPay;
    private RelativeLayout mRelRefund;
    private ScrollView mScrollView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvBalance;
    private TextView mTvMoney;
    private TextView mTvRefundState;
    private TextView mTvRefundTime;
    private TextView mTvServerPhone;
    private TextView mTvServerTime;
    private TextView mTvTip;
    private V4UserInfoBean mWalletInfoBean;
    private List<String> mSetMoneyList = new ArrayList();
    private List<String> mGiveMoneyList = new ArrayList();
    private List<String> mGiveIdList = new ArrayList();
    private int mSelectMoneyIndex = 0;
    private List<Integer> mRechargeWayList = new ArrayList();
    private int mSelectWay = 0;
    private boolean mIsEnable = true;
    private boolean mIsNeedLoadUserInfo = false;
    private boolean mIsHasNoPayOrder = false;

    static {
        StubApp.interface11(11143);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4WalletDetailActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelNoPay = (RelativeLayout) findViewById(R.id.rel_nopay);
        this.mLvRechargeWay = (WrapListView) findViewById(R.id.listview);
        this.mListView = (WrapGridView) findViewById(R.id.lv_chongzhi);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mScrollView = (ScrollView) findViewById(R.id.scrollview);
        this.mLinDefined = (LinearLayout) findViewById(R.id.lin_defined);
        this.mLinOrherMoney = (LinearLayout) findViewById(R.id.lin_othermoney);
        this.mEtInputMoney = (EditText) findViewById(R.id.et_inputmoney);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvBalance = (TextView) findViewById(R.id.tv_balance);
        this.mRelRefund = (RelativeLayout) findViewById(R.id.rel_refund);
        this.mTvServerPhone = (TextView) findViewById(R.id.tv_serverphone);
        this.mTvServerTime = (TextView) findViewById(R.id.tv_servertime);
        this.mTvRefundTime = (TextView) findViewById(R.id.tv_refundtip);
        this.mTvTip = (TextView) findViewById(R.id.tv_tip);
        this.mTvRefundState = (TextView) findViewById(R.id.tv_applyrefundtext);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.rechargecenter));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.rel_nopay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                V4WalletDetailActivity.this.mIsNeedLoadUserInfo = true;
                V4NoPayOrderActivity.launch(V4WalletDetailActivity.this.getActivity());
            }
        });
        findViewById(R.id.rel_wallet2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m566x77b3e203(view);
            }
        });
        findViewById(R.id.lin_defined).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m567x6b436644(view);
            }
        });
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m568x5ed2ea85(view);
            }
        });
        findViewById(R.id.rel_rechargerecord).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m569x52626ec6(view);
            }
        });
        findViewById(R.id.rel_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m570x45f1f307(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-wallet-V4WalletDetailActivity, reason: not valid java name */
    /* synthetic */ void m566x77b3e203(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4BalanceDetailActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-wallet-V4WalletDetailActivity, reason: not valid java name */
    /* synthetic */ void m567x6b436644(View view) {
        this.mLinDefined.setVisibility(8);
        this.mLinOrherMoney.setVisibility(0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-wallet-V4WalletDetailActivity, reason: not valid java name */
    /* synthetic */ void m568x5ed2ea85(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        recharge();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v4-ui-wallet-V4WalletDetailActivity, reason: not valid java name */
    /* synthetic */ void m569x52626ec6(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4RechargeRefundRecordActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v4-ui-wallet-V4WalletDetailActivity, reason: not valid java name */
    /* synthetic */ void m570x45f1f307(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4ProjectConfigInfoUtil.getInstance().checkRefundTimeRange();
        final String str = this.mWalletInfoBean.balance;
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.2
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                V4SubmitRefundActivity.launch(V4WalletDetailActivity.this.getActivity(), -1, str);
            }
        }, "提示", "预退钱包余额" + str + "元申请退款后，红包、优惠券将失效，不能继续使用,赠送钱包和补贴红包不支持退款", "#ff6f32fd", "取消", "继续退款");
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        LogUtil.e(TAG, "onResume:");
        if (this.mIsNeedLoadUserInfo) {
            getUserBalance();
        }
        selectHasNoPay();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        this.mTvBalance.setText(this.mWalletInfoBean.totalBalance);
        this.mRechargeMoneyAdapter = new RechargeMoneyAdapter();
        this.mListView.setOnItemClickListener(this);
        this.mListView.setAdapter((ListAdapter) this.mRechargeMoneyAdapter);
        this.mRechargeMoneyAdapter.notifyDataSetChanged();
        this.mRechargeWayList.clear();
        V4ProjectInfoBean projectInfoV4 = V4ProjectConfigInfoUtil.getInstance().getProjectInfoV4();
        if (projectInfoV4 == null) {
            LogUtil.e(TAG, "支付配置为空");
            return;
        }
        V4PayConfigBean v4PayConfigBean = projectInfoV4.projectPayConfigDTO;
        LogUtil.e(TAG, "支卡通：" + projectInfoV4.aliCartoonSign);
        if (v4PayConfigBean != null && v4PayConfigBean.payChannel == 1 && v4PayConfigBean.projectPayMentToArray != null && v4PayConfigBean.projectPayMentToArray.size() > 0) {
            for (int i = 0; i < v4PayConfigBean.projectPayMentToArray.size(); i++) {
                if (v4PayConfigBean.projectPayMentToArray.get(i).intValue() == EnumPayFlag.WEIXIN.getValue()) {
                    this.mRechargeWayList.add(Integer.valueOf(EnumPayFlag.WEIXIN.getValue()));
                } else if (v4PayConfigBean.projectPayMentToArray.get(i).intValue() == EnumPayFlag.ZFB.getValue()) {
                    this.mRechargeWayList.add(Integer.valueOf(EnumPayFlag.ZFB.getValue()));
                }
            }
        }
        this.mRechargeWayAdapter = new RechargeWayAdapter();
        this.mLvRechargeWay.setOnItemClickListener(this);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mRechargeWayAdapter);
        this.mRechargeWayAdapter.notifyDataSetChanged();
        this.mEtInputMoney.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isEmpty(editable.toString())) {
                    if (V4WalletDetailActivity.this.mTvMoney.getText().toString().length() == 1 && V4WalletDetailActivity.this.mSelectMoneyIndex == -1) {
                        V4WalletDetailActivity.this.mTvMoney.setText("");
                        return;
                    }
                    return;
                }
                V4WalletDetailActivity.this.mTvMoney.setText(editable.toString());
                V4WalletDetailActivity.this.mSelectMoneyIndex = -1;
                V4WalletDetailActivity.this.mRechargeMoneyAdapter.notifyDataSetChanged();
            }
        });
        final int[] iArr = {0};
        this.mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                V4WalletDetailActivity v4WalletDetailActivity = V4WalletDetailActivity.this;
                v4WalletDetailActivity.doScrollEvent(v4WalletDetailActivity.mScrollView, iArr, V4WalletDetailActivity.this.mEtInputMoney);
            }
        });
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.5
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4WalletDetailActivity.this.getRechargeList();
                V4WalletDetailActivity.this.getUserBalance();
                V4WalletDetailActivity.this.selectHasNoPay();
            }
        });
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        LogUtil.e(TAG, adapterView.getAdapter().toString());
        if (adapterView.getAdapter().toString().contains("RechargeMoneyAdapter")) {
            this.mSelectMoneyIndex = i;
            this.mRechargeMoneyAdapter.notifyDataSetChanged();
        } else if (adapterView.getAdapter().toString().contains("RechargeWayAdapter")) {
            this.mSelectWay = i;
            this.mRechargeWayAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRechargeList() {
        V4BusinessControllers.getInstance().getRechargeAmountList(getLoginAccount(), 1, new Listener<List<V4RechargeListBean>>() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4WalletDetailActivity.this.getActivity(), "加载数据.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<V4RechargeListBean> list, Object... objArr) {
                super.onComplete(controller, list, objArr);
                if (V4WalletDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4WalletDetailActivity.this.mLinOrherMoney.setVisibility(8);
                    V4WalletDetailActivity.this.mLinDefined.setVisibility(0);
                    V4WalletDetailActivity.this.mSetMoneyList.clear();
                    V4WalletDetailActivity.this.mGiveMoneyList.clear();
                    if (list == null || list.size() <= 0) {
                        V4WalletDetailActivity.this.mSetMoneyList.add(BaseWrapper.ENTER_ID_SYSTEM_HELPER);
                        V4WalletDetailActivity.this.mSetMoneyList.add("50");
                        V4WalletDetailActivity.this.mSetMoneyList.add("100");
                        V4WalletDetailActivity.this.mSetMoneyList.add("200");
                    } else {
                        Collections.sort(list, new Comparator<V4RechargeListBean>() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.6.1
                            @Override // java.util.Comparator
                            public int compare(V4RechargeListBean v4RechargeListBean, V4RechargeListBean v4RechargeListBean2) {
                                return v4RechargeListBean.amount.compareTo(v4RechargeListBean2.amount);
                            }
                        });
                        for (V4RechargeListBean v4RechargeListBean : list) {
                            V4WalletDetailActivity.this.mSetMoneyList.add(v4RechargeListBean.amount);
                            if (v4RechargeListBean.useGive) {
                                V4WalletDetailActivity.this.mGiveMoneyList.add(v4RechargeListBean.giveAmount);
                            } else {
                                V4WalletDetailActivity.this.mGiveMoneyList.add("0");
                            }
                            V4WalletDetailActivity.this.mGiveIdList.add(v4RechargeListBean.id);
                        }
                    }
                    V4WalletDetailActivity.this.mRechargeMoneyAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4WalletDetailActivity.this.mIsEnable) {
                    V4WalletDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    private void recharge() {
        String str;
        String str2;
        int i;
        List<Integer> list = this.mRechargeWayList;
        if (list == null) {
            ToastUtils.show(getActivity(), "请选择支付方式");
            return;
        }
        if (list.size() == 0) {
            ToastUtils.show(getActivity(), "请选择支付方式");
            return;
        }
        String string = this.mTvMoney.getText().toString();
        final int iIntValue = this.mRechargeWayList.get(this.mSelectWay).intValue();
        LogUtil.e(TAG, "recharge:mSelectMoneyIndex:" + this.mSelectMoneyIndex);
        List<String> list2 = this.mGiveIdList;
        if (list2 == null || list2.size() <= 0 || (i = this.mSelectMoneyIndex) < 0) {
            str = string;
            str2 = "";
        } else {
            str2 = this.mGiveIdList.get(i);
            str = "";
        }
        V4BusinessControllers.getInstance().postUserRecharge(getLoginAccount(), str, iIntValue, str2, new Listener<V4RechargeBean>() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4WalletDetailActivity.this.getActivity(), "下单中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4RechargeBean v4RechargeBean, Object... objArr) {
                if (V4WalletDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (v4RechargeBean != null) {
                        if (iIntValue == EnumPayFlag.WEIXIN.getValue()) {
                            V4WalletDetailActivity.this.mIsNeedLoadUserInfo = true;
                            WxPayUtils.pay(V4WalletDetailActivity.this.getActivity(), v4RechargeBean.appId, v4RechargeBean.partnerId, v4RechargeBean.prepayId, v4RechargeBean.nonceStr, v4RechargeBean.timeStamp, v4RechargeBean.sign);
                        } else {
                            if (iIntValue != EnumPayFlag.ZFB.getValue()) {
                                ToastUtils.show(V4WalletDetailActivity.this.getContext(), "下单失败");
                                return;
                            }
                            String str3 = v4RechargeBean.tradeNo;
                            LogUtil.e(V4WalletDetailActivity.TAG, "paymsg:" + str3);
                            AliPayUtils.pay(V4WalletDetailActivity.this.getActivity(), str3, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.7.1
                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void paySuccess() {
                                    ToastUtils.show(V4WalletDetailActivity.this.getContext(), "支付成功");
                                    V4WalletDetailActivity.this.mIsNeedLoadUserInfo = true;
                                    V4WalletDetailActivity.this.getUserBalance();
                                }

                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void payWaitting() {
                                    ToastUtils.show(V4WalletDetailActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                                }

                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void payFail() {
                                    ToastUtils.show(V4WalletDetailActivity.this.getContext(), "支付失败");
                                }
                            });
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4WalletDetailActivity.this.mIsEnable) {
                    V4WalletDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUserBalance() {
        final double dDoubleValue = new BigDecimal(this.mWalletInfoBean.totalBalance).doubleValue();
        V4BusinessControllers.getInstance().getServerList(getLoginAccount(), new Listener<V4ServerListBean>() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4WalletDetailActivity.this.getActivity(), "正在获取钱包信息..", false);
                V4WalletDetailActivity.this.mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ServerListBean v4ServerListBean, Object... objArr) {
                if (V4WalletDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4WalletDetailActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    V4WalletDetailActivity.this.mWalletInfoBean = V4UserInfoUtil.getInstance().getLoginAccountV4();
                    V4WalletDetailActivity.this.mTvBalance.setText(V4WalletDetailActivity.this.mWalletInfoBean.totalBalance);
                    double dDoubleValue2 = new BigDecimal(V4WalletDetailActivity.this.mWalletInfoBean.totalBalance).doubleValue();
                    LogUtil.e(V4WalletDetailActivity.TAG, dDoubleValue2 + PPSLabelView.Code + dDoubleValue + PPSLabelView.Code + V4WalletDetailActivity.this.mIsNeedLoadUserInfo);
                    if (dDoubleValue2 > dDoubleValue && V4WalletDetailActivity.this.mIsNeedLoadUserInfo) {
                        V4WalletDetailActivity.this.mIsNeedLoadUserInfo = false;
                        if (V4WalletDetailActivity.this.mIsHasNoPayOrder) {
                            TwoButtonDialog.getInstance().showDialog(V4WalletDetailActivity.this.getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.8.1
                                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                                public void onCancle() {
                                }

                                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                                public void onConfirm() {
                                    V4WalletDetailActivity.this.mIsNeedLoadUserInfo = true;
                                    V4NoPayOrderActivity.launch(V4WalletDetailActivity.this.getActivity());
                                }
                            }, "提示", "您有未支付订单，为确保正常使用，请先支付", "取消", "前往支付");
                        } else {
                            V4PaySuccessActivity.launch(V4WalletDetailActivity.this.getActivity());
                        }
                    }
                    V4WalletDetailActivity.this.mIsNeedLoadUserInfo = false;
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4WalletDetailActivity.this.mIsEnable) {
                    V4WalletDetailActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    V4WalletDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectHasNoPay() {
        this.mRelNoPay.setVisibility(8);
        this.mIsHasNoPayOrder = false;
        V4ProjectInfoBean projectInfoV4 = V4ProjectConfigInfoUtil.getInstance().getProjectInfoV4();
        if (projectInfoV4 == null) {
            LogUtil.e(TAG, "支付配置为空");
            return;
        }
        V4PayConfigBean v4PayConfigBean = projectInfoV4.projectPayConfigDTO;
        if (v4PayConfigBean == null) {
            return;
        }
        LogUtil.e(TAG, "支付配置为空111");
        if (v4PayConfigBean.settleUnpayOrder.intValue() != 0) {
            return;
        }
        LogUtil.e(TAG, "支付配置为空2222");
        V4BusinessControllers.getInstance().selectIsHasNoPay(getLoginAccount(), new Listener<Boolean>() { // from class: client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Boolean bool, Object... objArr) {
                super.onComplete(controller, bool, objArr);
                if (V4WalletDetailActivity.this.mIsEnable && bool.booleanValue()) {
                    V4WalletDetailActivity.this.mRelNoPay.setVisibility(0);
                    V4WalletDetailActivity.this.mIsHasNoPayOrder = true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }

    class RechargeMoneyAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        RechargeMoneyAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return V4WalletDetailActivity.this.mSetMoneyList.size();
        }

        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (String) V4WalletDetailActivity.this.mSetMoneyList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4WalletDetailActivity.this.getContext()).inflate(R.layout.layout_money_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            String item = getItem(i);
            viewHolder.tv_money.setText(V4WalletDetailActivity.this.getString(R.string.recharge2) + item + V4WalletDetailActivity.this.getString(R.string.yuan));
            if (V4WalletDetailActivity.this.mGiveMoneyList != null && V4WalletDetailActivity.this.mGiveMoneyList.size() > 0) {
                viewHolder.tv_song.setVisibility(0);
                viewHolder.tv_song.setText(V4WalletDetailActivity.this.getString(R.string.give) + ((String) V4WalletDetailActivity.this.mGiveMoneyList.get(i)) + V4WalletDetailActivity.this.getString(R.string.yuan));
            } else {
                viewHolder.tv_song.setVisibility(8);
                int i2 = (int) (V4WalletDetailActivity.this.getResources().getDisplayMetrics().density * 12.0f);
                viewHolder.tv_money.setPadding(0, i2, 0, i2);
            }
            if (V4WalletDetailActivity.this.mSelectMoneyIndex == i) {
                viewHolder.mRel.setBackground(V4WalletDetailActivity.this.getResources().getDrawable(R.drawable.shape_6f32fd_round_background));
                viewHolder.tv_money.setTextColor(V4WalletDetailActivity.this.getResources().getColor(R.color.white));
                viewHolder.tv_song.setTextColor(V4WalletDetailActivity.this.getResources().getColor(R.color.white));
                V4WalletDetailActivity.this.mTvMoney.setText(item);
                V4WalletDetailActivity.this.mEtInputMoney.setText("");
            } else {
                viewHolder.mRel.setBackground(V4WalletDetailActivity.this.getResources().getDrawable(R.drawable.shape_a1a6b3_background));
                viewHolder.tv_money.setTextColor(V4WalletDetailActivity.this.getResources().getColor(R.color.ff242933));
                viewHolder.tv_song.setTextColor(V4WalletDetailActivity.this.getResources().getColor(R.color.fff13628));
            }
            return view;
        }

        class ViewHolder {
            public RelativeLayout mRel;
            public TextView tv_money;
            public TextView tv_song;

            public ViewHolder(View view) {
                this.mRel = (RelativeLayout) view.findViewById(R.id.rel_bg);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_song = (TextView) view.findViewById(R.id.tv_song);
            }
        }
    }

    class RechargeWayAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        RechargeWayAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return V4WalletDetailActivity.this.mRechargeWayList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) V4WalletDetailActivity.this.mRechargeWayList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4WalletDetailActivity.this.getContext()).inflate(R.layout.layout_rechargeway_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.img2.setImageResource(R.mipmap.wxz);
            if (iIntValue == EnumPayFlag.WEIXIN.getValue()) {
                viewHolder.img.setImageResource(R.mipmap.wx);
                viewHolder.tv_name.setText(V4WalletDetailActivity.this.getString(R.string.wechatpay));
            } else if (iIntValue == EnumPayFlag.ZFB.getValue()) {
                viewHolder.img.setImageResource(R.mipmap.zfb);
                viewHolder.tv_name.setText(V4WalletDetailActivity.this.getString(R.string.alipaymeny));
            }
            if (V4WalletDetailActivity.this.mSelectWay == i) {
                viewHolder.img2.setImageResource(R.mipmap.xz1);
            }
            return view;
        }

        class ViewHolder {
            public ImageView img;
            public ImageView img2;
            public TextView tv_name;

            public ViewHolder(View view) {
                this.img = (ImageView) view.findViewById(R.id.img1);
                this.tv_name = (TextView) view.findViewById(R.id.textali);
                this.img2 = (ImageView) view.findViewById(R.id.img_select_ali);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        super.onActivityResult(i, i2, intent);
        if (intent == null || intent.getExtras() == null) {
            LogUtil.e(TAG, "云闪付支付结果为空");
            return;
        }
        String string = intent.getExtras().getString("pay_result");
        if ("success".equalsIgnoreCase(string)) {
            str = "支付成功";
            ToastUtils.show(getContext(), "支付成功");
        } else if ("fail".equalsIgnoreCase(string)) {
            str = "支付失败";
        } else {
            str = Constant.CASH_LOAD_CANCEL.equalsIgnoreCase(string) ? "支付取消" : "";
        }
        LogUtil.e(TAG, "云闪付支付结果".concat(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doScrollEvent(ScrollView scrollView, int[] iArr, EditText... editTextArr) {
        Rect rect = new Rect();
        scrollView.getWindowVisibleDisplayFrame(rect);
        int height = scrollView.getHeight() - rect.bottom;
        int scrollY = scrollView.getScrollY();
        for (EditText editText : editTextArr) {
            if (editText.isFocused()) {
                if (height > 100) {
                    int[] iArr2 = new int[2];
                    iArr[0] = scrollY;
                    editText.getLocationInWindow(iArr2);
                    int height2 = editText.getHeight();
                    if (iArr2[1] + height2 > rect.bottom) {
                        scrollView.scrollBy(0, (iArr2[1] + height2) - rect.bottom);
                        return;
                    }
                    return;
                }
                int i = iArr[0];
                if (i != scrollY) {
                    scrollView.scrollTo(0, i);
                }
                iArr[0] = scrollView.getScrollY();
                return;
            }
        }
    }
}

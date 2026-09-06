package client.android.yixiaotong.v3.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
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
import client.android.yixiaotong.icbcPay.ICBCPayUtils;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.card.CreateOrderBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.PlanJsonBean;
import client.android.yixiaotong.v3.bean.login.RechargeGiftProgram;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayModelParameterBean;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayResultCardBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog;
import client.android.yixiaotong.v3.ui.dialog.PayServerTipDialog;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.RechargeRefundRecordActivity;
import client.android.yixiaotong.v3.ui.wallet.controlutil.V3WalletControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.example.caller.BankABCCaller;
import com.gnete.upbc.cashier.GnetePayConfig;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WalletDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "WalletDetailActivity";
    private AdvControlUtil.AdvListener mAdvListener;
    private EditText mEtInputMoney;
    private InvestorInfoBean mInvestorInfoBean;
    private LinearLayout mLinDefined;
    private LinearLayout mLinOrherMoney;
    private WrapGridView mListView;
    private WrapListView mLvRechargeWay;
    private NativeUtil mNativeUtil;
    private PlanJsonBean mPlanJsonBean;
    private RechargeGiftProgram mRechargeGiftProgram;
    private RechargeRecordAdapter mRechargeRecordAdapter;
    private RechargeWayAdapter mRechargeWayAdapter;
    private RelativeLayout mRelPaySuccess;
    private RelativeLayout mRelRefund;
    private ScrollView mScrollView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TextView mTvBalance;
    private TextView mTvCashRedPacket;
    private TextView mTvMoney;
    private TextView mTvPayContent;
    private TextView mTvRefundState;
    private TextView mTvRefundTime;
    private TextView mTvServerPhone;
    private TextView mTvServerTime;
    private TextView mTvTip;
    private WalletInfoBean mWalletInfoBean;
    private RelativeLayout rlContainer;
    private List<Integer> mSetMoneyList = new ArrayList();
    private int mSelectMoneyIndex = 0;
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private int mSelectWay = 0;
    private boolean mIsEnable = true;
    private long mGiveId = -1;
    private int mOrderCount = 1;
    private int mCashWallet = 0;
    private int mICBCIndex = 1;
    private boolean mIsFirstLoad = true;
    private boolean mIsPaySuccess = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.12
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(WalletDetailActivity.TAG, "onPermissionGranted:" + i + "");
            if (i == 4 && ((Integer) WalletDetailActivity.this.mPayFlagTypeList.get(WalletDetailActivity.this.mSelectWay)).intValue() == 12) {
                ICBCPayWayDialog.getInstance().showDialog(WalletDetailActivity.this.getActivity(), new ICBCPayWayDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.12.1
                    @Override // client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.Listener
                    public void onPay(int i2) {
                        WalletDetailActivity.this.mICBCIndex = i2;
                        if (WalletDetailActivity.this.checkOrder()) {
                            WalletDetailActivity.this.recharge();
                        }
                    }
                }, WalletDetailActivity.this.mTvMoney.getText().toString());
            }
        }
    };
    private int mAdvCurrentMoney = 0;
    private boolean mIsPay = false;

    static {
        StubApp.interface11(10322);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    static /* synthetic */ int access$1008(WalletDetailActivity walletDetailActivity) {
        int i = walletDetailActivity.mOrderCount;
        walletDetailActivity.mOrderCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletInfoBean walletInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) WalletDetailActivity.class).putExtra("bean", walletInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
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
        this.mTvCashRedPacket = (TextView) findViewById(R.id.tv_cashredpacket);
        this.mRelPaySuccess = (RelativeLayout) findViewById(R.id.rel_endsuccess);
        this.rlContainer = (RelativeLayout) findViewById(R.id.rlContainer);
        this.mTvPayContent = (TextView) findViewById(R.id.tv_content);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.rechargecenter));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClick(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WalletDetailActivity.this.mIsPaySuccess) {
                    WalletDetailActivity.this.mTitleBar.setTitleView(WalletDetailActivity.this.getString(R.string.rechargecenter));
                    WalletDetailActivity.this.mRelPaySuccess.setVisibility(8);
                    WalletDetailActivity.this.mIsPaySuccess = false;
                    return;
                }
                WalletDetailActivity.this.finish();
            }
        });
    }

    private void initClickListeners() {
        findViewById(R.id.lin_defined).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m434xe0cbfd86(view);
            }
        });
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m435x9b419e07(view);
            }
        });
        findViewById(R.id.rel_rechargerecord).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m436x55b73e88(view);
            }
        });
        findViewById(R.id.rel_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m437x102cdf09(view);
            }
        });
        findViewById(R.id.btn_tolauhch).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m438xcaa27f8a(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-wallet-WalletDetailActivity, reason: not valid java name */
    /* synthetic */ void m434xe0cbfd86(View view) {
        toggleAmountInput();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-wallet-WalletDetailActivity, reason: not valid java name */
    /* synthetic */ void m435x9b419e07(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        handlePayment();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-wallet-WalletDetailActivity, reason: not valid java name */
    /* synthetic */ void m436x55b73e88(View view) {
        RechargeRefundRecordActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-wallet-WalletDetailActivity, reason: not valid java name */
    /* synthetic */ void m437x102cdf09(View view) {
        if (checkRefund()) {
            handleRefundAction();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-wallet-WalletDetailActivity, reason: not valid java name */
    /* synthetic */ void m438xcaa27f8a(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        launchRecordActivity();
    }

    private void toggleAmountInput() {
        this.mLinDefined.setVisibility(8);
        this.mLinOrherMoney.setVisibility(0);
    }

    private void handlePayment() {
        if (checkOrder()) {
            if (this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 12) {
                ToastUtils.show(getActivity(), "请选择支付方式");
            } else {
                recharge();
            }
        }
    }

    private void handleRefundAction() {
        if (this.mWalletInfoBean.statusFlag == 3) {
            showCancelRefundDialog();
        } else {
            showRefundConfirmationDialog();
        }
    }

    private void showCancelRefundDialog() {
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.2
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                WalletDetailActivity.this.cancelRefund();
            }
        }, "提示", "确定要取消退款吗", "#ff6f32fd", "不了", "确定");
    }

    private void showRefundConfirmationDialog() {
        String strDivide = DecimalUtil.divide(this.mWalletInfoBean.money + "", "100");
        String strDivide2 = DecimalUtil.divide(this.mCashWallet + "", "100");
        final int i = this.mCashWallet + this.mWalletInfoBean.money;
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.3
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                LocalDataUtil.saveIsNeedGetWalletInfo(WalletDetailActivity.this.getContext(), true);
                RefundV3Activity.launch(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mWalletInfoBean.id + "", WalletDetailActivity.this.mWalletInfoBean.money, i, 1);
            }
        }, "提示", String.format(getResources().getString(R.string.refundwallet_tip), strDivide, strDivide2, DecimalUtil.divide(i + "", "100")), "#ff6f32fd", "取消", "继续退款");
    }

    private void launchRecordActivity() {
        RechargeRefundRecordActivity.launch(getActivity());
        this.mIsPaySuccess = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recharge() {
        final int i;
        String strMultiply = DecimalUtil.multiply(this.mTvMoney.getText().toString(), "100");
        if (strMultiply.contains(".")) {
            i = Integer.parseInt(strMultiply.split("\\.")[0]);
        } else {
            i = Integer.parseInt(strMultiply);
        }
        if (InvestorInfoUtil.getInstance().getInvestorInfosV3().size() >= 2) {
            PayServerTipDialog.getInstance().showDialog(getActivity(), new PayServerTipDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.4
                @Override // client.android.yixiaotong.v3.ui.dialog.PayServerTipDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.PayServerTipDialog.Listener
                public void onConfirm() {
                    if (((Integer) WalletDetailActivity.this.mPayFlagTypeList.get(WalletDetailActivity.this.mSelectWay)).intValue() == 7) {
                        AuthLoginActivity.launch(WalletDetailActivity.this.getActivity(), i);
                    } else {
                        WalletDetailActivity.this.mOrderCount = 1;
                        WalletDetailActivity.this.getOrder(null);
                    }
                }
            }, this.mInvestorInfoBean.providerJson.providerName, this.mInvestorInfoBean.providerJson.description);
        } else if (this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 7) {
            AuthLoginActivity.launch(getActivity(), i);
        } else {
            this.mOrderCount = 1;
            getOrder(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkOrder() {
        int i;
        if (StringUtils.isEmpty(this.mTvMoney.getText().toString())) {
            ToastUtils.show(getContext(), getString(R.string.selectrechargeamounts));
            return false;
        }
        if (this.mWalletInfoBean.statusFlag == 2) {
            ToastUtils.show(getContext(), getString(R.string.appstop));
            return false;
        }
        String strMultiply = DecimalUtil.multiply(this.mTvMoney.getText().toString(), "100");
        if (strMultiply.contains(".")) {
            i = Integer.parseInt(strMultiply.split("\\.")[0]);
        } else {
            i = Integer.parseInt(strMultiply);
        }
        if (this.mWalletInfoBean.statusFlag == 0 && StringUtils.isNotEmpty(this.mPlanJsonBean.firstSetMoney) && Integer.parseInt(this.mPlanJsonBean.firstSetMoney) > i) {
            ToastUtils.show(getContext(), getString(R.string.firstrechargemoney) + DecimalUtil.divide(this.mPlanJsonBean.firstSetMoney, "100") + getString(R.string.yuan));
            return false;
        }
        if (StringUtils.isNotEmpty(this.mPlanJsonBean.minimumSetMoney) && Integer.parseInt(this.mPlanJsonBean.minimumSetMoney) > i) {
            ToastUtils.show(getContext(), getString(R.string.lowrechargemoney) + DecimalUtil.divide(this.mPlanJsonBean.minimumSetMoney, "100") + getString(R.string.yuan));
            return false;
        }
        LogUtil.e(TAG, this.mPlanJsonBean.maxMoney + "  " + i + "  " + this.mWalletInfoBean.money);
        if (StringUtils.isNotEmpty(this.mPlanJsonBean.maxMoney) && Integer.parseInt(this.mPlanJsonBean.maxMoney) < i + this.mWalletInfoBean.money) {
            ToastUtils.show(getContext(), getString(R.string.maxwalletmoney) + DecimalUtil.divide(this.mPlanJsonBean.maxMoney, "100") + getString(R.string.yuan));
            return false;
        }
        List<Integer> list = this.mPayFlagTypeList;
        if (list == null || list.size() <= 0) {
            ToastUtils.show(getContext(), "暂未开通充值支付方式");
            return false;
        }
        if (this.mPayFlagTypeList.get(this.mSelectWay).intValue() != 24 || BankABCCaller.isBankABCAvaiable(getActivity())) {
            return true;
        }
        ToastUtils.show(getActivity(), "没安装农行掌银，或已安装农行掌银版本不支持");
        return true;
    }

    private boolean checkRefund() {
        if (this.mPlanJsonBean.refundMoneyFlag != 1) {
            ToastUtils.show(getContext(), "暂未开通线上退款，退款请联系服务商");
            return false;
        }
        if (System.currentTimeMillis() > TimeUtils.strYMDeToSec(this.mPlanJsonBean.refundMoneyStopDate) + TimeUtils.getOneDayMillis() || System.currentTimeMillis() < TimeUtils.strYMDeToSec(this.mPlanJsonBean.refundMoneyStartDate)) {
            ToastUtils.show(getContext(), "退款时段为：" + this.mPlanJsonBean.refundMoneyStartDate + " - " + this.mPlanJsonBean.refundMoneyStopDate);
            return false;
        }
        if ((this.mPlanJsonBean.autoTransferRefundPayFlagTypeList != null && this.mPlanJsonBean.autoTransferRefundPayFlagTypeList.size() > 0) || ((this.mPlanJsonBean.manualRefundPayFlagTypeList != null && this.mPlanJsonBean.manualRefundPayFlagTypeList.size() > 0) || (this.mPlanJsonBean.originalRouteRefundPayFlagTypeList != null && this.mPlanJsonBean.originalRouteRefundPayFlagTypeList.size() > 0))) {
            return true;
        }
        ToastUtils.show(getContext(), "暂未开通线上退款，退款请联系服务商。");
        return false;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        LogUtil.e(TAG, "onResume:");
        if (!this.mIsFirstLoad) {
            getWalletInfo(false);
        }
        this.mIsFirstLoad = false;
        if (!this.mIsPaySuccess) {
            this.mRelPaySuccess.setVisibility(8);
            this.mTitleBar.setTitleView(getString(R.string.rechargecenter));
        }
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        AdvControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        AdvControlUtil.getInstance().onDestroy(getActivity());
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
    }

    private void initData() {
        this.mLinOrherMoney.setVisibility(8);
        this.mLinDefined.setVisibility(8);
        InvestorInfoBean investorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
        this.mInvestorInfoBean = investorInfoBean;
        if (investorInfoBean != null) {
            this.mPlanJsonBean = InvestorInfoUtilControl.getInstance().getPlanJson(1);
            this.mRechargeGiftProgram = InvestorInfoUtilControl.getInstance().getRechargeGiftProgram(1, "1");
            PlanJsonBean planJsonBean = this.mPlanJsonBean;
            if (planJsonBean != null) {
                if (planJsonBean.setMoneyFlag == 2 && this.mPlanJsonBean.setMoneyList != null && this.mPlanJsonBean.setMoneyList.size() > 0) {
                    this.mSetMoneyList = this.mPlanJsonBean.setMoneyList;
                } else {
                    this.mSetMoneyList.add(2000);
                    this.mSetMoneyList.add(5000);
                    this.mSetMoneyList.add(10000);
                    this.mSetMoneyList.add(20000);
                }
                if (this.mPlanJsonBean.payFlagTypeList != null && this.mPlanJsonBean.payFlagTypeList.size() > 0) {
                    for (int i = 0; i < this.mPlanJsonBean.payFlagTypeList.size(); i++) {
                        if (this.mPlanJsonBean.payFlagTypeList.get(i).intValue() == 1 || this.mPlanJsonBean.payFlagTypeList.get(i).intValue() == 2 || this.mPlanJsonBean.payFlagTypeList.get(i).intValue() == 7 || this.mPlanJsonBean.payFlagTypeList.get(i).intValue() == 3 || this.mPlanJsonBean.payFlagTypeList.get(i).intValue() == 12 || this.mPlanJsonBean.payFlagTypeList.get(i).intValue() == 31 || this.mPlanJsonBean.payFlagTypeList.get(i).intValue() == 24) {
                            this.mPayFlagTypeList.add(this.mPlanJsonBean.payFlagTypeList.get(i));
                        }
                    }
                }
                if (StringUtils.isEmpty(this.mPlanJsonBean.minimumSetMoney) || (StringUtils.isNotEmpty(this.mPlanJsonBean.minimumSetMoney) && this.mPlanJsonBean.minimumSetMoney.equals("0"))) {
                    this.mLinDefined.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        finish();
    }

    private void initView() {
        this.mAdvCurrentMoney = this.mWalletInfoBean.money;
        String str = "";
        this.mTvBalance.setText(DecimalUtil.divide(this.mWalletInfoBean.money + "", "100"));
        WalletInfoBean walletInfoBean = this.mWalletInfoBean;
        if (walletInfoBean != null && walletInfoBean.statusFlag == 3) {
            this.mTvRefundState.setText(getString(R.string.cancelrefund));
        }
        if (this.mRechargeGiftProgram != null) {
            this.mTvTip.setText("温馨提示：充值赠送时间为：" + this.mRechargeGiftProgram.startDateTime + x.A + this.mRechargeGiftProgram.endDateTime + getContent(0));
        }
        this.mTvServerPhone.setText(this.mInvestorInfoBean.providerJson.phone);
        Collections.sort(this.mInvestorInfoBean.providerJson.workTimeList);
        for (int i = 0; i < this.mInvestorInfoBean.providerJson.workTimeList.size(); i++) {
            if (i == this.mInvestorInfoBean.providerJson.workTimeList.size() - 1) {
                str = this.mInvestorInfoBean.providerJson.workTimeList.get(i).startTime + "~" + this.mInvestorInfoBean.providerJson.workTimeList.get(i).stopTime;
            } else {
                str = this.mInvestorInfoBean.providerJson.workTimeList.get(i).startTime + "~" + this.mInvestorInfoBean.providerJson.workTimeList.get(i).stopTime + IOUtils.LINE_SEPARATOR_UNIX;
            }
        }
        this.mTvServerTime.setText(str);
        this.mRechargeRecordAdapter = new RechargeRecordAdapter();
        this.mListView.setOnItemClickListener(this);
        this.mListView.setAdapter((ListAdapter) this.mRechargeRecordAdapter);
        this.mRechargeRecordAdapter.notifyDataSetChanged();
        this.mRechargeWayAdapter = new RechargeWayAdapter();
        this.mLvRechargeWay.setOnItemClickListener(this);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mRechargeWayAdapter);
        this.mRechargeWayAdapter.notifyDataSetChanged();
        this.mEtInputMoney.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isEmpty(editable.toString())) {
                    if (WalletDetailActivity.this.mTvMoney.getText().toString().length() == 1 && WalletDetailActivity.this.mSelectMoneyIndex == -1) {
                        WalletDetailActivity.this.mTvMoney.setText("");
                        return;
                    }
                    return;
                }
                WalletDetailActivity.this.mTvMoney.setText(editable.toString());
                WalletDetailActivity.this.mSelectMoneyIndex = -1;
                WalletDetailActivity.this.mRechargeRecordAdapter.notifyDataSetChanged();
            }
        });
        final int[] iArr = {0};
        this.mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                WalletDetailActivity walletDetailActivity = WalletDetailActivity.this;
                walletDetailActivity.doScrollEvent(walletDetailActivity.mScrollView, iArr, WalletDetailActivity.this.mEtInputMoney);
            }
        });
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.7
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                WalletDetailActivity.this.getWalletInfo(true);
            }
        });
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

    private String getContent(int i) {
        RechargeGiftProgram rechargeGiftProgram = this.mRechargeGiftProgram;
        if (rechargeGiftProgram == null || rechargeGiftProgram.giftJson == null || this.mRechargeGiftProgram.giftJson.size() <= 0) {
            return "";
        }
        this.mGiveId = Long.parseLong(this.mRechargeGiftProgram.id);
        if (this.mRechargeGiftProgram.giftJson.get(i).preferentialType == 1) {
            return "，赠送金额以折扣券形式发放，请到优惠券里面查看";
        }
        if (this.mRechargeGiftProgram.giftJson.get(i).preferentialType == 2) {
            return "，赠送金额以折现券形式发放，请到优惠券里面查看";
        }
        return this.mRechargeGiftProgram.giftJson.get(i).preferentialType == 3 ? "，赠送金额以红包形式发放，请到红包里面查看" : "";
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        LogUtil.e(TAG, adapterView.getAdapter().toString());
        if (adapterView.getAdapter().toString().contains("RechargeRecordAdapter")) {
            this.mSelectMoneyIndex = i;
            this.mRechargeRecordAdapter.notifyDataSetChanged();
        } else if (adapterView.getAdapter().toString().contains("RechargeWayAdapter")) {
            this.mSelectWay = i;
            this.mRechargeWayAdapter.notifyDataSetChanged();
            if (this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 12) {
                PermissionUtil.requestPerssion(getActivity(), 4, this.permissionGrant);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOrder(YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean) {
        int i;
        String str = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "";
        long j = this.mWalletInfoBean.id;
        String strMultiply = DecimalUtil.multiply(this.mTvMoney.getText().toString(), "100");
        if (strMultiply.contains(".")) {
            i = Integer.parseInt(strMultiply.split("\\.")[0]);
        } else {
            i = Integer.parseInt(strMultiply);
        }
        int i2 = i;
        final int iIntValue = this.mPayFlagTypeList.get(this.mSelectWay).intValue();
        if (iIntValue == 12) {
            yiKaTongPayModelParameterBean = new YiKaTongPayModelParameterBean();
            yiKaTongPayModelParameterBean.channelType = this.mICBCIndex;
        }
        V3BusinessControllers.getInstance().postCreateOrders(getLoginAccount(), str, this.mInvestorInfoBean.investorId, 1, j, this.mGiveId, i2, iIntValue, yiKaTongPayModelParameterBean, new Listener<CreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(WalletDetailActivity.this.getActivity(), "下单中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CreateOrderBean createOrderBean, Object... objArr) {
                String str2;
                String str3;
                if (WalletDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    WalletDetailActivity.this.mIsPay = true;
                    if (createOrderBean != null) {
                        LocalDataUtil.saveIsNeedGetWalletInfo(WalletDetailActivity.this.getContext(), true);
                        if (iIntValue == 1 && createOrderBean.payInfo != null) {
                            WxPayUtils.pay(WalletDetailActivity.this.getActivity(), createOrderBean.payInfo.appid, createOrderBean.payInfo.partnerid, createOrderBean.payInfo.prepayid, createOrderBean.payInfo.noncestr, createOrderBean.payInfo.timestamp, createOrderBean.payInfo.sign);
                            return;
                        }
                        if (iIntValue == 2 && createOrderBean.payInfo != null) {
                            if (createOrderBean.payInfo.mode == 0) {
                                str3 = createOrderBean.payInfo.orderString;
                            } else {
                                str3 = createOrderBean.payInfo.mode == 1 ? createOrderBean.payInfo.tradeNo : "";
                            }
                            LogUtil.e(WalletDetailActivity.TAG, "paymsg:" + str3);
                            AliPayUtils.pay(WalletDetailActivity.this.getActivity(), str3, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.8.1
                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void paySuccess() {
                                    ToastUtils.show(WalletDetailActivity.this.getContext(), "支付成功");
                                    WalletDetailActivity.this.getWalletInfo(false);
                                }

                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void payWaitting() {
                                    ToastUtils.show(WalletDetailActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                                }

                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void payFail() {
                                    ToastUtils.show(WalletDetailActivity.this.getContext(), "支付失败");
                                }
                            });
                            return;
                        }
                        int i3 = iIntValue;
                        if (i3 == 7) {
                            ToastUtils.show(WalletDetailActivity.this.getContext(), "支付成功");
                            WalletDetailActivity.this.getWalletInfo(false);
                            return;
                        }
                        if (i3 == 3) {
                            if (createOrderBean == null || createOrderBean.payInfo == null || createOrderBean.payInfo.msgBody == null) {
                                ToastUtils.show(WalletDetailActivity.this.getContext(), "银联下单失败");
                                return;
                            } else if (createOrderBean.payInfo.msgBody.retCode.equals("00000")) {
                                GnetePayConfig.builder().createWXAPI(WalletDetailActivity.this.getActivity(), "wxd9320c1760b6d01f");
                                V3WalletControlUtil.getInstance().sendPayRequest(createOrderBean.payInfo.msgBody.chnlUrl, 1, 0);
                                return;
                            } else {
                                SystemErrorTip.getInstance().showTipDialog(WalletDetailActivity.this.getActivity(), createOrderBean.payInfo.msgBody.retMsg);
                                return;
                            }
                        }
                        if (i3 == 12 && createOrderBean.payInfo != null) {
                            LogUtil.e(WalletDetailActivity.TAG, "订单id：" + createOrderBean.orderId);
                            ICBCPayUtils.payAll(WalletDetailActivity.this.mICBCIndex, createOrderBean.payInfo.appId, WalletDetailActivity.this.getActivity(), ICBCPayUtils.getUnionPayReq(createOrderBean.payInfo.appId, createOrderBean.payInfo.msgId, createOrderBean.payInfo.format, createOrderBean.payInfo.charset, createOrderBean.payInfo.encryptType, createOrderBean.payInfo.signType, createOrderBean.payInfo.merSignMsg, createOrderBean.payInfo.timestamp, createOrderBean.payInfo.ca, createOrderBean.payInfo.tranData, createOrderBean.payInfo.encryptKey), new ICBCPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.8.2
                                @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                public void paySuccess() {
                                    ToastUtils.show(WalletDetailActivity.this.getContext(), "支付成功");
                                    WalletDetailActivity.this.getWalletInfo(false);
                                }

                                @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                public void payWaitting() {
                                    ToastUtils.show(WalletDetailActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                                }

                                @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                public void payFail() {
                                    ToastUtils.show(WalletDetailActivity.this.getContext(), "支付失败");
                                }
                            });
                            return;
                        }
                        if (iIntValue != 31 || createOrderBean.payInfo == null) {
                            if (iIntValue != 24) {
                                ToastUtils.show(WalletDetailActivity.this.getContext(), "下单失败");
                                return;
                            }
                            String packageName = WalletDetailActivity.this.getPackageName();
                            LogUtil.e(WalletDetailActivity.TAG, "开始调起农行支付：" + packageName + "  " + createOrderBean.payInfo.token);
                            BankABCCaller.startBankABC(WalletDetailActivity.this.getActivity(), packageName, "client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity", "pay", createOrderBean.payInfo.token);
                            return;
                        }
                        if (StringUtils.isNotEmpty(createOrderBean.payInfo.pay_url)) {
                            if (!AppUtils.checkAliPayInstalled(WalletDetailActivity.this.getActivity())) {
                                ToastUtils.show(WalletDetailActivity.this.getContext(), "需要下载安装支付宝APP后才能进行支付");
                                return;
                            }
                            try {
                                str2 = "alipays://platformapi/startapp?appId=20000067&url=" + URLEncoder.encode(createOrderBean.payInfo.pay_url, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                str2 = null;
                            }
                            WalletDetailActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                            return;
                        }
                        ToastUtils.show(WalletDetailActivity.this.getContext(), "中国银行聚合支付下单失败");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (WalletDetailActivity.this.mIsEnable) {
                    if (clientException.getCode() != -46 || WalletDetailActivity.this.mOrderCount != 1) {
                        WalletDetailActivity.this.onError(clientException);
                    } else {
                        WalletDetailActivity.access$1008(WalletDetailActivity.this);
                        WalletDetailActivity.this.getOrder(null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getWalletInfo(boolean z) {
        if (LocalDataUtil.getIsNeedGetWalletInfo(getContext()) || z) {
            V3BusinessControllers.getInstance().postGetWalletInfoByInvestorid(getLoginAccount(), this.mInvestorInfoBean.investorId, new Listener<WalletInfoBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.9
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(WalletDetailActivity.this.getActivity(), "正在获取钱包信息..", false);
                    WalletDetailActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, WalletInfoBean walletInfoBean, Object... objArr) {
                    if (WalletDetailActivity.this.mIsEnable) {
                        WalletDetailActivity.this.getAdv(walletInfoBean.money);
                        BaseMaterialDialog.dissmisMaterialDialog();
                        WalletDetailActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        WalletDetailActivity.this.mWalletInfoBean = walletInfoBean;
                        WalletDetailActivity.this.mTvBalance.setText(DecimalUtil.divide(WalletDetailActivity.this.mWalletInfoBean.money + "", "100"));
                        if (WalletDetailActivity.this.mWalletInfoBean.statusFlag == 3) {
                            WalletDetailActivity.this.mTvRefundState.setText(WalletDetailActivity.this.getString(R.string.cancelrefund));
                        } else {
                            WalletDetailActivity.this.mTvRefundState.setText(WalletDetailActivity.this.getString(R.string.applyrefund));
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (WalletDetailActivity.this.mIsEnable) {
                        WalletDetailActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        WalletDetailActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRefund() {
        V3BusinessControllers.getInstance().postRevokeRefundOrders(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, 1, null, new Listener<CreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(WalletDetailActivity.this.getActivity(), "正在取消退款中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CreateOrderBean createOrderBean, Object... objArr) {
                super.onComplete(controller, createOrderBean, objArr);
                if (WalletDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(WalletDetailActivity.this.getContext(), "取消成功");
                    LocalDataUtil.saveIsNeedGetWalletInfo(WalletDetailActivity.this.getContext(), true);
                    WalletDetailActivity.this.getWalletInfo(false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (WalletDetailActivity.this.mIsEnable) {
                    WalletDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getMoneyCouponAmount() {
        V3BusinessControllers.getInstance().getMoneyCouponAmount(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, new Listener<String>() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                if (WalletDetailActivity.this.mIsEnable && StringUtils.isNotEmpty(str)) {
                    WalletDetailActivity.this.mCashWallet = Integer.parseInt(str);
                    WalletDetailActivity.this.mTvCashRedPacket.setText(DecimalUtil.divide(str, "100") + WalletDetailActivity.this.getString(R.string.yuan));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    class RechargeRecordAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        RechargeRecordAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return WalletDetailActivity.this.mSetMoneyList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) WalletDetailActivity.this.mSetMoneyList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(WalletDetailActivity.this.getContext()).inflate(R.layout.layout_money_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.tv_money.setText(WalletDetailActivity.this.getString(R.string.recharge2) + DecimalUtil.divide(iIntValue + "", "100") + WalletDetailActivity.this.getString(R.string.yuan));
            if (WalletDetailActivity.this.mRechargeGiftProgram != null && WalletDetailActivity.this.mRechargeGiftProgram.giftJson != null && WalletDetailActivity.this.mRechargeGiftProgram.giftJson.size() > 0) {
                viewHolder.tv_song.setVisibility(4);
                boolean z = true;
                for (int i2 = 0; i2 < WalletDetailActivity.this.mRechargeGiftProgram.giftJson.size(); i2++) {
                    if (iIntValue == WalletDetailActivity.this.mRechargeGiftProgram.giftJson.get(i2).rechargeAmount) {
                        viewHolder.tv_song.setVisibility(0);
                        viewHolder.tv_song.setText(WalletDetailActivity.this.getString(R.string.give) + DecimalUtil.divide(WalletDetailActivity.this.mRechargeGiftProgram.giftJson.get(i2).preferentialAmount + "", "100") + WalletDetailActivity.this.getString(R.string.yuan));
                        z = false;
                    }
                }
                if (z) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    viewHolder.tv_money.setLayoutParams(layoutParams);
                }
            } else {
                viewHolder.tv_song.setVisibility(8);
                int i3 = (int) (WalletDetailActivity.this.getResources().getDisplayMetrics().density * 12.0f);
                viewHolder.tv_money.setPadding(0, i3, 0, i3);
            }
            if (WalletDetailActivity.this.mSelectMoneyIndex == i) {
                viewHolder.mRel.setBackground(WalletDetailActivity.this.getResources().getDrawable(R.drawable.shape_6f32fd_round_background));
                viewHolder.tv_money.setTextColor(WalletDetailActivity.this.getResources().getColor(R.color.white));
                viewHolder.tv_song.setTextColor(WalletDetailActivity.this.getResources().getColor(R.color.white));
                WalletDetailActivity.this.mTvMoney.setText(DecimalUtil.divide(iIntValue + "", "100"));
                WalletDetailActivity.this.mEtInputMoney.setText("");
            } else {
                viewHolder.mRel.setBackground(WalletDetailActivity.this.getResources().getDrawable(R.drawable.shape_a1a6b3_background));
                viewHolder.tv_money.setTextColor(WalletDetailActivity.this.getResources().getColor(R.color.ff242933));
                viewHolder.tv_song.setTextColor(WalletDetailActivity.this.getResources().getColor(R.color.fff13628));
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
            return WalletDetailActivity.this.mPayFlagTypeList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) WalletDetailActivity.this.mPayFlagTypeList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(WalletDetailActivity.this.getContext()).inflate(R.layout.layout_rechargeway_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.img2.setImageResource(R.mipmap.wxz);
            if (iIntValue == 1) {
                viewHolder.img.setImageResource(R.mipmap.wx);
                viewHolder.tv_name.setText(WalletDetailActivity.this.getString(R.string.wechatpay));
            } else if (iIntValue == 2) {
                viewHolder.img.setImageResource(R.mipmap.zfb);
                viewHolder.tv_name.setText(WalletDetailActivity.this.getString(R.string.alipaymeny));
            } else if (iIntValue == 7) {
                viewHolder.img.setImageResource(R.mipmap.xzx);
                viewHolder.tv_name.setText(WalletDetailActivity.this.getString(R.string.xiaoyuanyikatong));
            } else if (iIntValue == 3) {
                viewHolder.img.setImageResource(R.mipmap.yl);
                viewHolder.tv_name.setText(WalletDetailActivity.this.getString(R.string.unionpayment));
            } else if (iIntValue == 31) {
                viewHolder.img.setImageResource(R.mipmap.refund_zgyh);
                viewHolder.tv_name.setText(WalletDetailActivity.this.getString(R.string.zgyhjhzf));
            } else if (iIntValue == 24) {
                viewHolder.img.setImageResource(R.mipmap.l_chongzhi_abc);
                viewHolder.tv_name.setText(WalletDetailActivity.this.getString(R.string.nyyh));
            }
            if (WalletDetailActivity.this.mSelectWay == i) {
                viewHolder.img2.setImageResource(R.mipmap.xz1);
            }
            if (iIntValue == 12) {
                viewHolder.img.setImageResource(R.mipmap.icbc);
                viewHolder.tv_name.setText(WalletDetailActivity.this.getString(R.string.icbcjhzf));
                viewHolder.img2.setImageResource(R.mipmap.next);
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
        if (i == 1) {
            if (intent != null) {
                List<YiKaTongPayResultCardBean> list = (List) intent.getSerializableExtra("card");
                YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean = new YiKaTongPayModelParameterBean();
                yiKaTongPayModelParameterBean.card = list;
                this.mOrderCount = 1;
                getOrder(yiKaTongPayModelParameterBean);
                return;
            }
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            LogUtil.e(TAG, "云闪付支付结果为空");
            return;
        }
        String string = intent.getExtras().getString("pay_result");
        if ("success".equalsIgnoreCase(string)) {
            str = "支付成功";
            ToastUtils.show(getContext(), "支付成功");
            getWalletInfo(false);
        } else if ("fail".equalsIgnoreCase(string)) {
            str = "支付失败";
        } else {
            str = Constant.CASH_LOAD_CANCEL.equalsIgnoreCase(string) ? "支付取消" : "";
        }
        LogUtil.e(TAG, "云闪付支付结果".concat(str));
    }

    private void showPaySuccess() {
        this.mTvPayContent.setText(getString(R.string.paysuccess));
        this.mRelPaySuccess.setVisibility(0);
        this.mIsPaySuccess = true;
        this.mTitleBar.setTitleView(getString(R.string.payresult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAdv(int i) {
        LogUtil.e(TAG, "getAdv:" + this.mIsPay + PPSLabelView.Code + i + PPSLabelView.Code + this.mAdvCurrentMoney);
        if (i - this.mAdvCurrentMoney <= 0) {
            this.mAdvCurrentMoney = i;
            this.mIsPay = false;
            return;
        }
        showPaySuccess();
        this.mAdvCurrentMoney = i;
        this.mIsPay = false;
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity.13
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i2) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i2, int i3, int i4, int i5, int i6) {
                LogUtil.e(WalletDetailActivity.TAG, "getAdv:" + i6);
                if (i6 == 1) {
                    WalletDetailActivity.this.mNativeUtil.initNative(WalletDetailActivity.this.getActivity(), WalletDetailActivity.this.mAdvListener, 1);
                    WalletDetailActivity.this.mNativeUtil.onNative(WalletDetailActivity.this.rlContainer);
                }
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, -1, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}

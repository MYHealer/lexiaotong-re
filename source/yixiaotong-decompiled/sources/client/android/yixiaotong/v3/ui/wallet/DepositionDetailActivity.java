package client.android.yixiaotong.v3.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
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
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.card.CreateOrderBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.PlanInfoBean;
import client.android.yixiaotong.v3.bean.login.PlanJsonBean;
import client.android.yixiaotong.v3.bean.wallet.DepositionBean;
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
import client.android.yixiaotong.v3.ui.order.DepositRechargeRefundRecordActivity;
import client.android.yixiaotong.v3.ui.wallet.controlutil.V3WalletControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.gnete.upbc.cashier.GnetePayConfig;
import com.stub.StubApp;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DepositionDetailActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "DepositionDetailActivity";
    private AdvControlUtil.AdvListener mAdvListener;
    private Button mBtnPay;
    private DepositionBean mDepositionBean;
    private InvestorInfoBean mInvestorInfoBean;
    private LinearLayout mLinPayWay;
    private WrapListView mLvRechargeWay;
    private NativeUtil mNativeUtil;
    private PlanJsonBean mPlanJsonBean;
    private RechargeWayAdapter mRechargeWayAdapter;
    private String mRefundDepositTime;
    private RelativeLayout mRelPaySuccess;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TextView mTvCashRedPacket;
    private TextView mTvMoney;
    private TextView mTvPayContent;
    private TextView mTvTip;
    private RelativeLayout rlContainer;
    private boolean mIsEnable = true;
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private int mSelectWay = 0;
    private boolean mIsNeedLoadDeposition = true;
    private int mCashWallet = 0;
    private int mICBCIndex = 1;
    private boolean mIsPaySuccess = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.10
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(DepositionDetailActivity.TAG, "onPermissionGranted:" + i + "");
            if (i == 4 && ((Integer) DepositionDetailActivity.this.mPayFlagTypeList.get(DepositionDetailActivity.this.mSelectWay)).intValue() == 12) {
                ICBCPayWayDialog.getInstance().showDialog(DepositionDetailActivity.this.getActivity(), new ICBCPayWayDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.10.1
                    @Override // client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.Listener
                    public void onPay(int i2) {
                        DepositionDetailActivity.this.mICBCIndex = i2;
                        if (DepositionDetailActivity.this.checkOrder()) {
                            DepositionDetailActivity.this.pay();
                        }
                    }
                }, DecimalUtil.divide(DepositionDetailActivity.this.mPlanJsonBean.depositMoney + "", "100"));
            }
        }
    };
    private boolean mIsPay = false;

    static {
        StubApp.interface11(10262);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DepositionDetailActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvTip = (TextView) findViewById(R.id.tv_tip);
        this.mBtnPay = (Button) findViewById(R.id.btn_pay);
        this.mLvRechargeWay = (WrapListView) findViewById(R.id.listview);
        this.mLinPayWay = (LinearLayout) findViewById(R.id.lin_payway);
        this.mTvCashRedPacket = (TextView) findViewById(R.id.tv_cashredpacket);
        this.mRelPaySuccess = (RelativeLayout) findViewById(R.id.rel_endsuccess);
        this.rlContainer = (RelativeLayout) findViewById(R.id.rlContainer);
        this.mTvPayContent = (TextView) findViewById(R.id.tv_content);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.mydeposit2));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftViewOnClick(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DepositionDetailActivity.this.mIsPaySuccess) {
                    DepositionDetailActivity.this.mTitleBar.setTitleView(DepositionDetailActivity.this.getString(R.string.mydeposit2));
                    DepositionDetailActivity.this.mRelPaySuccess.setVisibility(8);
                    DepositionDetailActivity.this.mIsPaySuccess = false;
                    return;
                }
                DepositionDetailActivity.this.finish();
            }
        });
    }

    private void initClickListeners() {
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m423xf93395f7(view);
            }
        });
        findViewById(R.id.btn_record).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m424x46f30df8(view);
            }
        });
        findViewById(R.id.btn_tolauhch).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m425x94b285f9(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-wallet-DepositionDetailActivity, reason: not valid java name */
    /* synthetic */ void m423xf93395f7(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        handlePayAction();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-wallet-DepositionDetailActivity, reason: not valid java name */
    /* synthetic */ void m424x46f30df8(View view) {
        DepositRechargeRefundRecordActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-wallet-DepositionDetailActivity, reason: not valid java name */
    /* synthetic */ void m425x94b285f9(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        DepositRechargeRefundRecordActivity.launch(getActivity());
        this.mIsPaySuccess = false;
    }

    private void handlePayAction() {
        int i = this.mDepositionBean.statusFlag;
        if (i != -1 && i != 0) {
            if (i == 1) {
                handleRefundFlow();
                return;
            } else if (i == 3) {
                showCancelRefundDialog();
                return;
            } else if (i != 4) {
                return;
            }
        }
        handlePaymentFlow();
    }

    private void handleRefundFlow() {
        if (checkRefund()) {
            String strDivide = DecimalUtil.divide(this.mDepositionBean.money + "", "100");
            String strDivide2 = DecimalUtil.divide(this.mCashWallet + "", "100");
            final int i = this.mCashWallet + this.mDepositionBean.money;
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.2
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    DepositionDetailActivity.this.mIsNeedLoadDeposition = true;
                    RefundV3Activity.launch(DepositionDetailActivity.this.getActivity(), DepositionDetailActivity.this.mDepositionBean.id + "", DepositionDetailActivity.this.mDepositionBean.money, i, 2);
                }
            }, "提示", String.format(getResources().getString(R.string.refunddeposition_tip), strDivide, strDivide2, DecimalUtil.divide(i + "", "100")), "#ff6f32fd", "取消", "继续退押");
        }
    }

    private void handlePaymentFlow() {
        if (checkOrder()) {
            if (this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 12) {
                ToastUtils.show(getActivity(), "请选择支付方式");
            } else {
                pay();
            }
        }
    }

    private void showCancelRefundDialog() {
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.3
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                DepositionDetailActivity.this.cancelRefund();
            }
        }, "提示", "确定要取消退押吗", "#ff6f32fd", "不了", "确定");
    }

    private boolean checkRefund() {
        if (this.mPlanJsonBean.refundMoneyFlag != 1) {
            ToastUtils.show(getContext(), "暂未开通线上退押，退款请联系服务商");
            return false;
        }
        if (System.currentTimeMillis() > TimeUtils.strYMDeToSec(this.mPlanJsonBean.refundMoneyStopDate) + TimeUtils.getOneDayMillis() || System.currentTimeMillis() < TimeUtils.strYMDeToSec(this.mPlanJsonBean.refundMoneyStartDate)) {
            ToastUtils.show(getContext(), "退押时段为：" + this.mPlanJsonBean.refundMoneyStartDate + " - " + this.mPlanJsonBean.refundMoneyStopDate);
            return false;
        }
        if ((this.mPlanJsonBean.autoTransferRefundPayFlagTypeList != null && this.mPlanJsonBean.autoTransferRefundPayFlagTypeList.size() > 0) || ((this.mPlanJsonBean.manualRefundPayFlagTypeList != null && this.mPlanJsonBean.manualRefundPayFlagTypeList.size() > 0) || (this.mPlanJsonBean.originalRouteRefundPayFlagTypeList != null && this.mPlanJsonBean.originalRouteRefundPayFlagTypeList.size() > 0))) {
            return true;
        }
        ToastUtils.show(getContext(), "暂未开通线上退押，退款请联系服务商。");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.mTvTip.setText(getString(R.string.deposittip));
        if (StringUtils.isNotEmpty(this.mPlanJsonBean.refundMoneyStartDate) && StringUtils.isNotEmpty(this.mPlanJsonBean.refundMoneyStopDate)) {
            this.mRefundDepositTime = this.mPlanJsonBean.refundMoneyStartDate + "至" + this.mPlanJsonBean.refundMoneyStopDate;
        }
        this.mTvMoney.setText("");
        this.mBtnPay.setText("");
        this.mBtnPay.setEnabled(true);
        if (this.mDepositionBean.statusFlag == 1) {
            this.mLinPayWay.setVisibility(8);
            this.mTvMoney.setText(DecimalUtil.divide(this.mDepositionBean.money + "", "100"));
            this.mBtnPay.setText(getString(R.string.refundofdeposit));
            LocalDataUtil.savePaySuccess(getActivity(), 0);
            getAdv();
        } else if (this.mDepositionBean.statusFlag == 2) {
            this.mBtnPay.setEnabled(false);
        } else if (this.mDepositionBean.statusFlag == 3) {
            this.mTvMoney.setText(DecimalUtil.divide(this.mDepositionBean.money + "", "100"));
            this.mBtnPay.setText(getString(R.string.beingrefunded));
        } else {
            this.mLinPayWay.setVisibility(0);
            this.mTvMoney.setText("0");
            this.mBtnPay.setText(getString(R.string.paydeposit) + DecimalUtil.divide(this.mPlanJsonBean.depositMoney + "", "100") + getString(R.string.yuan));
            LogUtil.e(TAG, "按钮状态:" + LocalDataUtil.getPaySuccessResult(getActivity()));
            if (LocalDataUtil.getPaySuccessResult(getActivity()) == 1) {
                this.mBtnPay.setEnabled(false);
                this.mBtnPay.setBackgroundResource(R.drawable.shape_btn_gray);
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        LocalDataUtil.savePaySuccess(DepositionDetailActivity.this.getActivity(), 0);
                        if (DepositionDetailActivity.this.mIsEnable) {
                            DepositionDetailActivity.this.mBtnPay.setEnabled(true);
                            DepositionDetailActivity.this.mBtnPay.setBackgroundResource(R.drawable.shape_49cb71_round_background);
                            DepositionDetailActivity.this.getData();
                        }
                    }
                }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            }
        }
        this.mRechargeWayAdapter = new RechargeWayAdapter();
        this.mLvRechargeWay.setOnItemClickListener(this);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mRechargeWayAdapter);
        this.mRechargeWayAdapter.notifyDataSetChanged();
    }

    private void initData() {
        List<PlanInfoBean> list;
        InvestorInfoBean investorInfoBean = InvestorInfoUtil.getInstance().getInvestorInfosV3().get(InvestorInfoUtil.getInstance().getInvestorInfosIndex()).investorInfo;
        this.mInvestorInfoBean = investorInfoBean;
        if (investorInfoBean == null || (list = investorInfoBean.planInfo) == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).base.planFlag == 2) {
                PlanJsonBean planJsonBean = list.get(i).planJson;
                this.mPlanJsonBean = planJsonBean;
                if (planJsonBean != null) {
                    if (planJsonBean.payFlagTypeList != null && this.mPlanJsonBean.payFlagTypeList.size() > 0) {
                        for (int i2 = 0; i2 < this.mPlanJsonBean.payFlagTypeList.size(); i2++) {
                            if (this.mPlanJsonBean.payFlagTypeList.get(i2).intValue() == 1 || this.mPlanJsonBean.payFlagTypeList.get(i2).intValue() == 2 || this.mPlanJsonBean.payFlagTypeList.get(i2).intValue() == 7 || this.mPlanJsonBean.payFlagTypeList.get(i2).intValue() == 3 || this.mPlanJsonBean.payFlagTypeList.get(i2).intValue() == 12 || this.mPlanJsonBean.payFlagTypeList.get(i2).intValue() == 31) {
                                LogUtil.e(TAG, "mPayFlagTypeList:" + this.mPlanJsonBean.payFlagTypeList.get(i2));
                                this.mPayFlagTypeList.add(this.mPlanJsonBean.payFlagTypeList.get(i2));
                            }
                        }
                    }
                } else {
                    ToastUtils.show(getContext(), "未配置支付通道");
                    finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pay() {
        if (InvestorInfoUtil.getInstance().getInvestorInfosV3().size() >= 2) {
            PayServerTipDialog.getInstance().showDialog(getActivity(), new PayServerTipDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.5
                @Override // client.android.yixiaotong.v3.ui.dialog.PayServerTipDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.PayServerTipDialog.Listener
                public void onConfirm() {
                    if (((Integer) DepositionDetailActivity.this.mPayFlagTypeList.get(DepositionDetailActivity.this.mSelectWay)).intValue() == 7) {
                        AuthLoginActivity.launch(DepositionDetailActivity.this.getActivity());
                    } else {
                        DepositionDetailActivity.this.getOrder(null);
                    }
                }
            }, this.mInvestorInfoBean.providerJson.providerName, this.mInvestorInfoBean.providerJson.description);
        } else if (this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 7) {
            AuthLoginActivity.launch(getActivity());
        } else {
            getOrder(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkOrder() {
        List<Integer> list = this.mPayFlagTypeList;
        if (list != null && list.size() > 0) {
            return true;
        }
        ToastUtils.show(getContext(), "暂未开通交押金的支付方式，交押请联系服务商");
        return false;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        DepositionBean depositionBean;
        super.onResume();
        this.mIsEnable = true;
        String str = TAG;
        LogUtil.e(str, "onResume:" + LocalDataUtil.getPaySuccessResult(getActivity()));
        if (LocalDataUtil.getPaySuccessResult(getActivity()) != 1 && (depositionBean = this.mDepositionBean) != null && depositionBean.statusFlag != 2) {
            LogUtil.e(str, "恢复按钮状态");
            this.mBtnPay.setEnabled(true);
            this.mBtnPay.setBackgroundResource(R.drawable.shape_49cb71_round_background);
        }
        if (this.mIsNeedLoadDeposition) {
            getData();
        }
        if (!this.mIsPaySuccess) {
            this.mRelPaySuccess.setVisibility(8);
            this.mTitleBar.setTitleView(getString(R.string.mydeposit2));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void getData() {
        V3BusinessControllers.getInstance().getDepositInfoByInvestorid(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, new Listener<DepositionBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DepositionDetailActivity.this.getActivity(), "正在获取数据中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DepositionBean depositionBean, Object... objArr) {
                super.onComplete(controller, depositionBean, objArr);
                if (DepositionDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    DepositionDetailActivity.this.mIsNeedLoadDeposition = false;
                    if (depositionBean != null) {
                        DepositionDetailActivity.this.mDepositionBean = depositionBean;
                        DepositionDetailActivity.this.initView();
                    } else {
                        ToastUtils.show(DepositionDetailActivity.this.getContext(), "获取数据出错");
                        DepositionDetailActivity.this.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (DepositionDetailActivity.this.mIsEnable) {
                    DepositionDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOrder(YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean) {
        String str = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "";
        long j = this.mDepositionBean.id;
        int i = this.mPlanJsonBean.depositMoney;
        final int iIntValue = this.mPayFlagTypeList.get(this.mSelectWay).intValue();
        if (iIntValue == 12) {
            yiKaTongPayModelParameterBean = new YiKaTongPayModelParameterBean();
            yiKaTongPayModelParameterBean.channelType = this.mICBCIndex;
        }
        V3BusinessControllers.getInstance().postCreateOrders(getLoginAccount(), str, this.mInvestorInfoBean.investorId, 2, j, -1L, i, iIntValue, yiKaTongPayModelParameterBean, new Listener<CreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DepositionDetailActivity.this.getActivity(), "下单中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CreateOrderBean createOrderBean, Object... objArr) {
                String str2;
                String str3;
                if (DepositionDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (createOrderBean != null) {
                        DepositionDetailActivity.this.mIsPay = true;
                        LocalDataUtil.saveIsNeedGetWalletInfo(DepositionDetailActivity.this.getContext(), true);
                        LocalDataUtil.savePaySuccess(DepositionDetailActivity.this.getActivity(), 0);
                        if (iIntValue == 1 && createOrderBean.payInfo != null) {
                            DepositionDetailActivity.this.mIsNeedLoadDeposition = true;
                            WxPayUtils.pay(DepositionDetailActivity.this.getActivity(), createOrderBean.payInfo.appid, createOrderBean.payInfo.partnerid, createOrderBean.payInfo.prepayid, createOrderBean.payInfo.noncestr, createOrderBean.payInfo.timestamp, createOrderBean.payInfo.sign);
                            return;
                        }
                        if (iIntValue == 2 && createOrderBean.payInfo != null) {
                            if (createOrderBean.payInfo.mode == 0) {
                                str3 = createOrderBean.payInfo.orderString;
                            } else {
                                str3 = createOrderBean.payInfo.mode == 1 ? createOrderBean.payInfo.tradeNo : "";
                            }
                            LogUtil.e(DepositionDetailActivity.TAG, "支付失败:" + LocalDataUtil.getPaySuccessResult(DepositionDetailActivity.this.getActivity()));
                            AliPayUtils.pay(DepositionDetailActivity.this.getActivity(), str3, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.7.1
                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void paySuccess() {
                                    ToastUtils.show(DepositionDetailActivity.this.getContext(), "支付成功");
                                    LocalDataUtil.savePaySuccess(DepositionDetailActivity.this.getActivity(), 1);
                                    DepositionDetailActivity.this.getData();
                                }

                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void payWaitting() {
                                    ToastUtils.show(DepositionDetailActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                                }

                                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                                public void payFail() {
                                    ToastUtils.show(DepositionDetailActivity.this.getContext(), "支付失败");
                                }
                            });
                            return;
                        }
                        int i2 = iIntValue;
                        if (i2 == 7) {
                            ToastUtils.show(DepositionDetailActivity.this.getContext(), "支付成功");
                            DepositionDetailActivity.this.getData();
                            return;
                        }
                        if (i2 == 3) {
                            if (createOrderBean == null || createOrderBean.payInfo == null || createOrderBean.payInfo.msgBody == null) {
                                ToastUtils.show(DepositionDetailActivity.this.getContext(), "银联下单失败");
                                return;
                            } else {
                                if (createOrderBean.payInfo.msgBody.retCode.equals("00000")) {
                                    GnetePayConfig.builder().createWXAPI(DepositionDetailActivity.this.getActivity(), "wxd9320c1760b6d01f");
                                    DepositionDetailActivity.this.mIsNeedLoadDeposition = true;
                                    V3WalletControlUtil.getInstance().sendPayRequest(createOrderBean.payInfo.msgBody.chnlUrl, 2, 0);
                                    return;
                                }
                                SystemErrorTip.getInstance().showTipDialog(DepositionDetailActivity.this.getActivity(), createOrderBean.payInfo.msgBody.retMsg);
                                return;
                            }
                        }
                        if (i2 == 12 && createOrderBean.payInfo != null) {
                            ICBCPayUtils.payAll(DepositionDetailActivity.this.mICBCIndex, createOrderBean.payInfo.appId, DepositionDetailActivity.this.getActivity(), ICBCPayUtils.getUnionPayReq(createOrderBean.payInfo.appId, createOrderBean.payInfo.msgId, createOrderBean.payInfo.format, createOrderBean.payInfo.charset, createOrderBean.payInfo.encryptType, createOrderBean.payInfo.signType, createOrderBean.payInfo.merSignMsg, createOrderBean.payInfo.timestamp, createOrderBean.payInfo.ca, createOrderBean.payInfo.tranData, createOrderBean.payInfo.encryptKey), new ICBCPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.7.2
                                @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                public void paySuccess() {
                                    ToastUtils.show(DepositionDetailActivity.this.getContext(), "支付成功");
                                    DepositionDetailActivity.this.getData();
                                }

                                @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                public void payWaitting() {
                                    ToastUtils.show(DepositionDetailActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                                }

                                @Override // client.android.yixiaotong.icbcPay.ICBCPayUtils.OnPayListener
                                public void payFail() {
                                    ToastUtils.show(DepositionDetailActivity.this.getContext(), "支付失败");
                                }
                            });
                            return;
                        }
                        if (iIntValue != 31 || createOrderBean.payInfo == null) {
                            ToastUtils.show(DepositionDetailActivity.this.getContext(), "下单失败");
                            return;
                        }
                        if (StringUtils.isNotEmpty(createOrderBean.payInfo.pay_url)) {
                            if (!AppUtils.checkAliPayInstalled(DepositionDetailActivity.this.getActivity())) {
                                ToastUtils.show(DepositionDetailActivity.this.getContext(), "需要下载安装支付宝APP后才能进行支付");
                                return;
                            }
                            try {
                                str2 = "alipays://platformapi/startapp?appId=20000067&url=" + URLEncoder.encode(createOrderBean.payInfo.pay_url, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                str2 = null;
                            }
                            DepositionDetailActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                            return;
                        }
                        ToastUtils.show(DepositionDetailActivity.this.getContext(), "中国银行聚合支付下单失败");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DepositionDetailActivity.this.mIsEnable) {
                    DepositionDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRefund() {
        V3BusinessControllers.getInstance().postRevokeRefundOrders(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, 2, null, new Listener<CreateOrderBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DepositionDetailActivity.this.getActivity(), "正在取消退款中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, CreateOrderBean createOrderBean, Object... objArr) {
                super.onComplete(controller, createOrderBean, objArr);
                if (DepositionDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(DepositionDetailActivity.this.getContext(), "取消成功");
                    DepositionDetailActivity.this.getData();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DepositionDetailActivity.this.mIsEnable) {
                    DepositionDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getMoneyCouponAmount() {
        V3BusinessControllers.getInstance().getMoneyCouponAmount(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mInvestorInfoBean.investorId, new Listener<String>() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                if (DepositionDetailActivity.this.mIsEnable && StringUtils.isNotEmpty(str)) {
                    DepositionDetailActivity.this.mCashWallet = Integer.parseInt(str);
                    DepositionDetailActivity.this.mTvCashRedPacket.setText(DecimalUtil.divide(str, "100") + "元");
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
            finish();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mSelectWay = i;
        this.mRechargeWayAdapter.notifyDataSetChanged();
        if (this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 12) {
            PermissionUtil.requestPerssion(getActivity(), 4, this.permissionGrant);
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
            return DepositionDetailActivity.this.mPayFlagTypeList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) DepositionDetailActivity.this.mPayFlagTypeList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DepositionDetailActivity.this.getContext()).inflate(R.layout.layout_rechargeway_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.img2.setImageResource(R.mipmap.wxz);
            if (iIntValue == 1) {
                viewHolder.img.setImageResource(R.mipmap.wx);
                viewHolder.tv_name.setText(DepositionDetailActivity.this.getString(R.string.wechatpay));
            } else if (iIntValue == 2) {
                viewHolder.img.setImageResource(R.mipmap.zfb);
                viewHolder.tv_name.setText(DepositionDetailActivity.this.getString(R.string.alipaymeny));
            } else if (iIntValue == 7) {
                viewHolder.img.setImageResource(R.mipmap.xzx);
                viewHolder.tv_name.setText(DepositionDetailActivity.this.getString(R.string.xiaoyuanyikatong));
            } else if (iIntValue == 3) {
                viewHolder.img.setImageResource(R.mipmap.yl);
                viewHolder.tv_name.setText(DepositionDetailActivity.this.getString(R.string.unionpayment));
            } else if (iIntValue == 31) {
                viewHolder.img.setImageResource(R.mipmap.refund_zgyh);
                viewHolder.tv_name.setText(DepositionDetailActivity.this.getString(R.string.zgyhjhzf));
            }
            if (DepositionDetailActivity.this.mSelectWay == i) {
                viewHolder.img2.setImageResource(R.mipmap.xz1);
            }
            if (iIntValue == 12) {
                viewHolder.img.setImageResource(R.mipmap.icbc);
                viewHolder.tv_name.setText(DepositionDetailActivity.this.getString(R.string.icbcjhzf));
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
        super.onActivityResult(i, i2, intent);
        if (i != 1 || intent == null) {
            return;
        }
        List<YiKaTongPayResultCardBean> list = (List) intent.getSerializableExtra("card");
        YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean = new YiKaTongPayModelParameterBean();
        yiKaTongPayModelParameterBean.card = list;
        getOrder(yiKaTongPayModelParameterBean);
    }

    private void showPaySuccess() {
        this.mTvPayContent.setText(getString(R.string.paysuccess));
        this.mRelPaySuccess.setVisibility(0);
        this.mIsPaySuccess = true;
        this.mTitleBar.setTitleView(getString(R.string.payresult));
    }

    private void getAdv() {
        LogUtil.e(TAG, "getAdv:" + this.mIsPay);
        if (this.mIsPay) {
            showPaySuccess();
            this.mIsPay = false;
            this.mNativeUtil = new NativeUtil();
            this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity.11
                @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
                public void onAdClosed(Common.AdvType advType) {
                }

                @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
                public void onAdShow(String str, Common.AdvType advType) {
                }

                @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
                public void onRenderSuccess(View view, int i) {
                }

                @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
                public void isOpen(int i, int i2, int i3, int i4, int i5) {
                    LogUtil.e(DepositionDetailActivity.TAG, "getAdv:" + i5);
                    if (i5 == 1) {
                        DepositionDetailActivity.this.mNativeUtil.initNative(DepositionDetailActivity.this.getActivity(), DepositionDetailActivity.this.mAdvListener, 1);
                        DepositionDetailActivity.this.mNativeUtil.onNative(DepositionDetailActivity.this.rlContainer);
                    }
                }
            };
            AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, -1, true, "");
            AdvControlUtil.getInstance().initAdvInfo();
        }
    }
}

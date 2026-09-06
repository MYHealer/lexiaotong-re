package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.PlanInfoBean;
import client.android.yixiaotong.v3.bean.login.PlanJsonBean;
import client.android.yixiaotong.v3.bean.login.RechargeGiftProgram;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentWalletBean;
import client.android.yixiaotong.v3.bean.prepayment.SupervisorBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.AppPlanFlagUtil;
import client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.PrepaymentControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentWalletControlUtil;
import client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PrepaymentWalletActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "PrepaymentWalletActivity";
    private FlowState mFlowState;
    ImageView mImgEye;
    ImageView mImgUpdateBalance;
    private InvestorInfoBean mInvestorInfoBean;
    WrapGridView mListView;
    WrapListView mLvRechargeWay;
    private PlanJsonBean mPlanJsonBean;
    private PrepaymentDeviceInfoBean mPrepaymentDeviceInfoBean;
    private PrepaymentWalletBean mPrepaymentWalletBean;
    private PrepaymentWalletControlUtil mPrepaymentWalletControlUtil;
    private RechargeGiftProgram mRechargeGiftProgram;
    private RechargeRecordAdapter mRechargeRecordAdapter;
    private RechargeWayAdapter mRechargeWayAdapter;
    RelativeLayout mRelUpdateBalance;
    private SupervisorBean mSupervisorBean;
    PullRefreshLayout mSwipeRefreshLayout;
    TitleBar mTitleBar;
    TextView mTvBalance;
    TextView mTvDeviceAddress;
    TextView mTvDeviceStatu;
    TextView mTvMachineId;
    TextView mTvMoney;
    TextView mTvSupervisor;
    TextView mTvUpdateBalance;
    TextView mTvUpdateBalanceText;
    private TypeInfoBean mTypeInfoBean;
    private boolean mIsEyeOpen = true;
    private String mBalance = "0";
    private boolean mIsEnable = true;
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private List<Integer> mSetMoneyList = new ArrayList();
    private int mSelectWay = 0;
    private int mSelectMoneyIndex = 0;
    private String mGiveId = "-1";
    private int mIndex = 0;
    private int mMoneyStr = 0;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity.6
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 1) {
                return;
            }
            PrepaymentWalletActivity prepaymentWalletActivity = PrepaymentWalletActivity.this;
            prepaymentWalletActivity.checkIsOpenBluetooth(prepaymentWalletActivity.mMoneyStr, PrepaymentWalletActivity.this.mIndex);
        }
    };

    public enum FlowState {
        none,
        collect
    }

    static {
        StubApp.interface11(9441);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, TypeInfoBean typeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) PrepaymentWalletActivity.class).putExtra("bean", typeInfoBean));
        }
    }

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) PrepaymentWalletActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mImgEye = (ImageView) findViewById(R.id.img_eye);
        this.mTvBalance = (TextView) findViewById(R.id.tv_balance);
        this.mRelUpdateBalance = (RelativeLayout) findViewById(R.id.rel_updatebalance);
        this.mImgUpdateBalance = (ImageView) findViewById(R.id.img_tip);
        this.mTvUpdateBalanceText = (TextView) findViewById(R.id.tv_updatebalancetext);
        this.mTvUpdateBalance = (TextView) findViewById(R.id.tv_updatebalance);
        this.mTvMachineId = (TextView) findViewById(R.id.tv_deviceinfono);
        this.mTvDeviceAddress = (TextView) findViewById(R.id.tv_deviceaddress);
        this.mTvDeviceStatu = (TextView) findViewById(R.id.tv_devicestatue);
        this.mLvRechargeWay = (WrapListView) findViewById(R.id.listview);
        this.mListView = (WrapGridView) findViewById(R.id.lv_chongzhi);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvSupervisor = (TextView) findViewById(R.id.tv_name);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBean.base.typeId, this.mTypeInfoBean.base.appName));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mRechargeRecordAdapter = new RechargeRecordAdapter();
        this.mListView.setOnItemClickListener(this);
        this.mListView.setAdapter((ListAdapter) this.mRechargeRecordAdapter);
        this.mRechargeRecordAdapter.notifyDataSetChanged();
        this.mRechargeWayAdapter = new RechargeWayAdapter();
        this.mLvRechargeWay.setOnItemClickListener(this);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mRechargeWayAdapter);
        this.mRechargeWayAdapter.notifyDataSetChanged();
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity.1
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                PrepaymentWalletActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                if (PrepaymentWalletActivity.this.mPrepaymentWalletControlUtil != null) {
                    PrepaymentWalletActivity.this.mPrepaymentWalletControlUtil.getWalletInfo(true);
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        PrepaymentWalletControlUtil prepaymentWalletControlUtil = this.mPrepaymentWalletControlUtil;
        if (prepaymentWalletControlUtil != null) {
            prepaymentWalletControlUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        PrepaymentWalletControlUtil prepaymentWalletControlUtil = this.mPrepaymentWalletControlUtil;
        if (prepaymentWalletControlUtil != null) {
            prepaymentWalletControlUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BluetoothControlUtil.getInstance().disconnect();
    }

    private void initClickListeners() {
        findViewById(R.id.img_eye).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m291x9272e4ab(view);
            }
        });
        findViewById(R.id.tv_balance).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m292x70664a8a(view);
            }
        });
        findViewById(R.id.tv_record).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m293x4e59b069(view);
            }
        });
        findViewById(R.id.tv_updatebalance).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m294x2c4d1648(view);
            }
        });
        findViewById(R.id.tv_changedevice).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m295xa407c27(view);
            }
        });
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m296xe833e206(view);
            }
        });
        findViewById(R.id.tv_name).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m297xc62747e5(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentWalletActivity, reason: not valid java name */
    /* synthetic */ void m291x9272e4ab(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        initEyeView(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentWalletActivity, reason: not valid java name */
    /* synthetic */ void m292x70664a8a(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        BalanceDetailActivity.launch(getActivity(), this.mTypeInfoBean, this.mPrepaymentWalletBean, this.mPrepaymentDeviceInfoBean);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentWalletActivity, reason: not valid java name */
    /* synthetic */ void m293x4e59b069(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        PrepaymentRecordActivity.launch(getActivity(), this.mTypeInfoBean.base, this.mPrepaymentDeviceInfoBean);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentWalletActivity, reason: not valid java name */
    /* synthetic */ void m294x2c4d1648(View view) {
        if (ClickUtil.isFastDoubleClick() || this.mPrepaymentWalletControlUtil == null) {
            return;
        }
        this.mIndex = 2;
        PermissionUtil.requestPerssion(getActivity(), 1, this.permissionGrant);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentWalletActivity, reason: not valid java name */
    /* synthetic */ void m295xa407c27(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        LocalDataUtil.saveTypeIdMachineId(getActivity(), 18, "");
        SelecetDeviceActivity.launch(getActivity(), this.mTypeInfoBean);
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentWalletActivity, reason: not valid java name */
    /* synthetic */ void m296xe833e206(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mPayFlagTypeList.size() > 0 && this.mPayFlagTypeList.get(this.mSelectWay).intValue() == 12) {
            ToastUtils.show(getActivity(), "请选择支付方式");
        } else {
            pay();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$6$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentWalletActivity, reason: not valid java name */
    /* synthetic */ void m297xc62747e5(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mSupervisorBean == null) {
            SetSupervisorActivity.launch(getActivity(), this.mTvMachineId.getText().toString());
        } else {
            SupervisorInfoActivity.launch(getActivity(), this.mSupervisorBean, this.mTvMachineId.getText().toString(), this.mPrepaymentWalletBean, this.mTypeInfoBean.base, this.mPrepaymentDeviceInfoBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pay() {
        int i;
        if (this.mFlowState == FlowState.collect) {
            ToastUtils.show(getActivity(), "正在更新余额请稍后再试");
            return;
        }
        if (this.mTypeInfoBean.base.statusFlag == 1) {
            BluetoothControlUtil.getInstance().disconnect();
            if (StringUtils.isNotEmpty(this.mTvMoney.getText().toString())) {
                String strMultiply = DecimalUtil.multiply(this.mTvMoney.getText().toString(), "100");
                if (strMultiply.contains(".")) {
                    i = Integer.parseInt(strMultiply.split("\\.")[0]);
                } else {
                    i = Integer.parseInt(strMultiply);
                }
                PrepaymentWalletBean prepaymentWalletBean = this.mPrepaymentWalletBean;
                if (prepaymentWalletBean != null && prepaymentWalletBean.status == 1) {
                    if (isCheckOrder(i)) {
                        this.mIndex = 1;
                        this.mMoneyStr = i;
                        PermissionUtil.requestPerssion(getActivity(), 1, this.permissionGrant);
                        return;
                    }
                    return;
                }
                showDialog("钱包不可用", false);
                return;
            }
            ToastUtils.show(getContext(), "请输入领款金额");
            return;
        }
        showDialog("应用已停用", false);
    }

    private boolean isCheckOrder(int i) {
        PlanJsonBean planJsonBean;
        PrepaymentWalletBean prepaymentWalletBean = this.mPrepaymentWalletBean;
        if (prepaymentWalletBean != null && this.mPlanJsonBean != null && prepaymentWalletBean.appendMoney == 0 && StringUtils.isNotEmpty(this.mPlanJsonBean.firstSetMoney) && Integer.parseInt(this.mPlanJsonBean.firstSetMoney) > i) {
            ToastUtils.show(getContext(), "首次充值金额：" + DecimalUtil.divide(this.mPlanJsonBean.firstSetMoney, "100") + "元");
            return false;
        }
        PlanJsonBean planJsonBean2 = this.mPlanJsonBean;
        if (planJsonBean2 != null && StringUtils.isNotEmpty(planJsonBean2.minimumSetMoney) && Integer.parseInt(this.mPlanJsonBean.minimumSetMoney) > i) {
            ToastUtils.show(getContext(), "最低充值金额：" + DecimalUtil.divide(this.mPlanJsonBean.minimumSetMoney, "100") + "元");
            return false;
        }
        if (this.mPrepaymentWalletBean != null && (planJsonBean = this.mPlanJsonBean) != null && StringUtils.isNotEmpty(planJsonBean.maxMoney) && Integer.parseInt(this.mPlanJsonBean.maxMoney) < i + this.mPrepaymentWalletBean.money + this.mPrepaymentWalletBean.cashRedPackage + this.mPrepaymentWalletBean.redPackage) {
            ToastUtils.show(getContext(), "钱包最大限额：" + DecimalUtil.divide(this.mPlanJsonBean.maxMoney, "100") + "元");
            return false;
        }
        List<Integer> list = this.mPayFlagTypeList;
        if (list != null && list.size() > 0) {
            return true;
        }
        ToastUtils.show(getContext(), "暂未开通充值支付方式，请联系服务商");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initUpdateBalanceView(boolean z) {
        if (z) {
            this.mRelUpdateBalance.setBackgroundResource(R.drawable.shape_ffe0edfe_background8);
            this.mImgUpdateBalance.setImageResource(R.mipmap.prepaymenttip_blue);
            this.mTvUpdateBalanceText.setText(R.string.usingbalancetip);
            this.mTvUpdateBalanceText.setTextColor(getResources().getColor(R.color.ff008AFF));
            this.mTvUpdateBalance.setVisibility(8);
            return;
        }
        this.mRelUpdateBalance.setBackgroundResource(R.drawable.shape_ffedd6_background8);
        this.mImgUpdateBalance.setImageResource(R.mipmap.prepaymenttip_yellow);
        this.mTvUpdateBalanceText.setText(R.string.usebalancetip);
        this.mTvUpdateBalanceText.setTextColor(getResources().getColor(R.color.ffff9200));
        this.mTvUpdateBalance.setVisibility(0);
    }

    private void initData() {
        List<PlanInfoBean> list;
        PrepaymentWalletControlUtil prepaymentWalletControlUtil = new PrepaymentWalletControlUtil();
        this.mPrepaymentWalletControlUtil = prepaymentWalletControlUtil;
        prepaymentWalletControlUtil.init(getActivity(), getLoginAccount(), this.mTypeInfoBean.base, 18, this.mTitleBar.getTitleViewContent(), 1);
        this.mPrepaymentWalletControlUtil.setErrorListener(new ErrorControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity.2
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener
            public void onFail(ClientException clientException) {
            }
        });
        this.mPrepaymentWalletControlUtil.setListener(new PrepaymentControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity.3
            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.PrepaymentControlListener
            public void onDeviceInfo(PrepaymentDeviceInfoBean prepaymentDeviceInfoBean) {
                if (prepaymentDeviceInfoBean != null) {
                    PrepaymentWalletActivity.this.mPrepaymentDeviceInfoBean = prepaymentDeviceInfoBean;
                    PrepaymentWalletActivity.this.mTvMachineId.setText(prepaymentDeviceInfoBean.machineId);
                    PrepaymentWalletActivity.this.mTvDeviceAddress.setText(prepaymentDeviceInfoBean.addressMsg);
                    if (prepaymentDeviceInfoBean.valveStatus == 0) {
                        PrepaymentWalletActivity.this.mTvDeviceStatu.setText("开");
                    } else if (prepaymentDeviceInfoBean.valveStatus == 1) {
                        PrepaymentWalletActivity.this.mTvDeviceStatu.setText("关");
                    } else {
                        PrepaymentWalletActivity.this.mTvDeviceStatu.setText("未知");
                    }
                }
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.PrepaymentControlListener
            public void onWalletInfo(PrepaymentWalletBean prepaymentWalletBean) {
                PrepaymentWalletActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                if (prepaymentWalletBean != null) {
                    LogUtil.e(PrepaymentWalletActivity.TAG, "onWalletInfo:" + prepaymentWalletBean.money + PPSLabelView.Code + prepaymentWalletBean.cashRedPackage + PPSLabelView.Code + prepaymentWalletBean.redPackage);
                    int i = prepaymentWalletBean.money + prepaymentWalletBean.cashRedPackage + prepaymentWalletBean.redPackage;
                    PrepaymentWalletActivity.this.mPrepaymentWalletBean = prepaymentWalletBean;
                    PrepaymentWalletActivity.this.mBalance = DecimalUtil.twoDecimal(DecimalUtil.divide(i + "", "100"));
                    PrepaymentWalletActivity.this.mTvBalance.setText(PrepaymentWalletActivity.this.mBalance);
                    PrepaymentWalletActivity.this.initEyeView(false);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.PrepaymentControlListener
            public void onCollectEnd(boolean z) {
                PrepaymentWalletActivity.this.initUpdateBalanceView(false);
                PrepaymentWalletActivity.this.mFlowState = FlowState.none;
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.PrepaymentControlListener
            public void onSupervisorInfo(SupervisorBean supervisorBean) {
                PrepaymentWalletActivity.this.mSupervisorBean = supervisorBean;
                if (supervisorBean != null && StringUtils.isNotEmpty(supervisorBean.studentName)) {
                    PrepaymentWalletActivity.this.mTvSupervisor.setText("**" + supervisorBean.studentName.substring(supervisorBean.studentName.length() - 1));
                } else {
                    PrepaymentWalletActivity.this.mTvSupervisor.setText("");
                }
            }
        });
        this.mPrepaymentWalletControlUtil.getDeviceInfo();
        int investorInfosIndex = InvestorInfoUtil.getInstance().getInvestorInfosIndex();
        List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
        if (investorInfosV3 != null && investorInfosV3.size() > 0) {
            InvestorInfoBean investorInfoBean = investorInfosV3.get(investorInfosIndex).investorInfo;
            this.mInvestorInfoBean = investorInfoBean;
            if (investorInfoBean == null || (list = investorInfoBean.planInfo) == null || list.size() <= 0) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).base.planFlag == AppPlanFlagUtil.PLAN_PREPAYMENT) {
                    this.mPlanJsonBean = list.get(i).planJson;
                    RechargeGiftProgram rechargeGiftProgram = InvestorInfoUtilControl.getInstance().getRechargeGiftProgram(list.get(i).rechargeGiftProgram);
                    this.mRechargeGiftProgram = rechargeGiftProgram;
                    if (rechargeGiftProgram != null && rechargeGiftProgram.giftJson != null && this.mRechargeGiftProgram.giftJson.size() > 0) {
                        this.mGiveId = this.mRechargeGiftProgram.id;
                    }
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
                            for (int i2 = 0; i2 < this.mPlanJsonBean.payFlagTypeList.size(); i2++) {
                                if (this.mPlanJsonBean.payFlagTypeList.get(i2).intValue() == 1 || this.mPlanJsonBean.payFlagTypeList.get(i2).intValue() == 2) {
                                    this.mPayFlagTypeList.add(this.mPlanJsonBean.payFlagTypeList.get(i2));
                                }
                            }
                        }
                    }
                }
            }
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEyeView(boolean z) {
        this.mTvBalance.setText(this.mBalance);
        if (z) {
            this.mIsEyeOpen = !this.mIsEyeOpen;
        }
        if (this.mIsEyeOpen) {
            this.mImgEye.setImageResource(R.mipmap.eye_open_white);
            return;
        }
        this.mImgEye.setImageResource(R.mipmap.eye_close_white);
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotEmpty(this.mTvBalance.getText().toString())) {
            for (int i = 0; i < this.mTvBalance.getText().toString().length(); i++) {
                sb.append("*");
            }
        }
        this.mTvBalance.setText(sb.toString());
    }

    public void checkIsOpenBluetooth(int i, int i2) {
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
            return;
        }
        if (i2 == 1) {
            PrepaymentWalletControlUtil prepaymentWalletControlUtil = this.mPrepaymentWalletControlUtil;
            if (prepaymentWalletControlUtil != null) {
                prepaymentWalletControlUtil.getOrder(true, i, this.mPayFlagTypeList.get(this.mSelectWay).intValue(), this.mGiveId, this.mInvestorInfoBean);
                return;
            }
            return;
        }
        if (i2 == 2) {
            this.mFlowState = FlowState.collect;
            BluetoothControlUtil.getInstance().disconnect();
            initUpdateBalanceView(true);
            this.mPrepaymentWalletControlUtil.onStartCollect();
        }
    }

    private void showDialog(String str, final boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity.4
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                if (z) {
                    PrepaymentWalletActivity.this.finish();
                }
            }
        }, str);
    }

    private void onError(ClientException clientException, boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            showDialog(clientException.getDetail(), z);
            return;
        }
        V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        if (z) {
            finish();
        }
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
                ICBCPayWayDialog.getInstance().showDialog(getActivity(), new ICBCPayWayDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity.5
                    @Override // client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.Listener
                    public void onPay(int i2) {
                        PrepaymentWalletActivity.this.mPrepaymentWalletControlUtil.setICBCIndex(i2);
                        PrepaymentWalletActivity.this.pay();
                    }
                }, DecimalUtil.divide(this.mPlanJsonBean.depositMoney + "", "100"));
            }
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
            return PrepaymentWalletActivity.this.mSetMoneyList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) PrepaymentWalletActivity.this.mSetMoneyList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(PrepaymentWalletActivity.this.getContext()).inflate(R.layout.item_prepayment_money_layout, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.tv_money.setText(DecimalUtil.divide(iIntValue + "", "100") + "元");
            if (PrepaymentWalletActivity.this.mRechargeGiftProgram != null && PrepaymentWalletActivity.this.mRechargeGiftProgram.giftJson != null && PrepaymentWalletActivity.this.mRechargeGiftProgram.giftJson.size() > 0) {
                LogUtil.e(PrepaymentWalletActivity.TAG, "有赠送");
                viewHolder.tv_song.setVisibility(4);
                boolean z = true;
                for (int i2 = 0; i2 < PrepaymentWalletActivity.this.mRechargeGiftProgram.giftJson.size(); i2++) {
                    if (iIntValue >= PrepaymentWalletActivity.this.mRechargeGiftProgram.giftJson.get(i2).rechargeAmount) {
                        viewHolder.tv_song.setVisibility(0);
                        viewHolder.tv_song.setText("送" + DecimalUtil.divide(PrepaymentWalletActivity.this.mRechargeGiftProgram.giftJson.get(i2).preferentialAmount + "", "100") + "元");
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
                int i3 = (int) (PrepaymentWalletActivity.this.getResources().getDisplayMetrics().density * 15.0f);
                viewHolder.tv_money.setPadding(0, i3, 0, i3);
            }
            if (PrepaymentWalletActivity.this.mSelectMoneyIndex == i) {
                viewHolder.mRel.setBackground(PrepaymentWalletActivity.this.getResources().getDrawable(R.drawable.shape_ff0289fe_background8));
                viewHolder.tv_money.setTextColor(PrepaymentWalletActivity.this.getResources().getColor(R.color.ff0289fe));
                PrepaymentWalletActivity.this.mTvMoney.setText(DecimalUtil.divide(iIntValue + "", "100"));
            } else {
                viewHolder.mRel.setBackground(PrepaymentWalletActivity.this.getResources().getDrawable(R.drawable.shape_ffe5e7e9_background8));
                viewHolder.tv_money.setTextColor(PrepaymentWalletActivity.this.getResources().getColor(R.color.ff171a1d));
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
            return PrepaymentWalletActivity.this.mPayFlagTypeList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) PrepaymentWalletActivity.this.mPayFlagTypeList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(PrepaymentWalletActivity.this.getContext()).inflate(R.layout.item_prepayment_rechargeway_layout, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.img2.setImageResource(R.mipmap.selected_white_big);
            if (iIntValue == 1) {
                viewHolder.img.setImageResource(R.mipmap.weixin_icon);
                viewHolder.tv_name.setText(PrepaymentWalletActivity.this.getString(R.string.wechatpay));
            } else if (iIntValue == 2) {
                viewHolder.img.setImageResource(R.mipmap.zhifubao_icon);
                viewHolder.tv_name.setText(PrepaymentWalletActivity.this.getString(R.string.alipaymeny));
            } else if (iIntValue == 7) {
                viewHolder.img.setImageResource(R.mipmap.xzx);
                viewHolder.tv_name.setText(PrepaymentWalletActivity.this.getString(R.string.xiaoyuanyikatong));
            } else if (iIntValue == 3) {
                viewHolder.img.setImageResource(R.mipmap.yl);
                viewHolder.tv_name.setText(PrepaymentWalletActivity.this.getString(R.string.unionpayment));
            }
            if (PrepaymentWalletActivity.this.mSelectWay == i) {
                viewHolder.img2.setImageResource(R.mipmap.selected_blue_big);
            }
            if (iIntValue == 12) {
                viewHolder.img.setImageResource(R.mipmap.icbc);
                viewHolder.tv_name.setText(PrepaymentWalletActivity.this.getString(R.string.icbcjhzf));
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
}

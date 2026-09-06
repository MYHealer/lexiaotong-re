package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.PlanInfoBean;
import client.android.yixiaotong.v3.bean.login.PlanJsonBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentWalletBean;
import client.android.yixiaotong.v3.bean.prepayment.RefundBean;
import client.android.yixiaotong.v3.bean.prepayment.SupervisorBean;
import client.android.yixiaotong.v3.comman.AppPlanFlagUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.SupervisorInfoControlUtil;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SupervisorInfoActivity extends BaseActivity {
    private static final String TAG;
    private Button mBtnCancel;
    private Button mBtnChange;
    private InvestorInfoBean mInvestorInfoBean;
    private String mMachineId;
    private PlanJsonBean mPlanJsonBean;
    private PrepaymentDeviceInfoBean mPrepaymentDeviceInfoBean;
    private PrepaymentWalletBean mPrepaymentWalletBean;
    private SupervisorBean mSupervisorBean;
    private SupervisorInfoControlUtil mSupervisorInfoControlUtil;
    private TitleBar mTitleBar;
    private TextView mTvName;
    private TextView mTvPhone;
    private TextView mTvRefund;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private boolean mIsEnable = true;
    private String mRefundId = "";
    private boolean mIsEnableRefund = false;

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static {
        StubApp.interface11(9493);
        TAG = "SelecetDeviceActivity";
    }

    public static void launch(Activity activity, SupervisorBean supervisorBean, String str, PrepaymentWalletBean prepaymentWalletBean, TypeInfoBaseInfoBean typeInfoBaseInfoBean, PrepaymentDeviceInfoBean prepaymentDeviceInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SupervisorInfoActivity.class).putExtra("bean", supervisorBean).putExtra("machineid", str).putExtra("walletbean", prepaymentWalletBean).putExtra("typeinfobean", typeInfoBaseInfoBean).putExtra("deviceinfo", prepaymentDeviceInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvName = (TextView) findViewById(R.id.tv_name);
        this.mTvPhone = (TextView) findViewById(R.id.tv_phone);
        this.mBtnChange = (Button) findViewById(R.id.btn_change);
        this.mBtnCancel = (Button) findViewById(R.id.btn_cancel);
        this.mTvRefund = (TextView) findViewById(R.id.tv_refund);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("舍长");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        this.mSupervisorInfoControlUtil.onResume();
        findHasRefundId();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mSupervisorInfoControlUtil.onPause();
    }

    private void initData() {
        List<PlanInfoBean> list;
        int investorInfosIndex = InvestorInfoUtil.getInstance().getInvestorInfosIndex();
        if (InvestorInfoUtil.getInstance().getInvestorInfosV3() != null && InvestorInfoUtil.getInstance().getInvestorInfosV3().size() > 0) {
            InvestorInfoBean investorInfoBean = InvestorInfoUtil.getInstance().getInvestorInfosV3().get(investorInfosIndex).investorInfo;
            this.mInvestorInfoBean = investorInfoBean;
            if (investorInfoBean != null && (list = investorInfoBean.planInfo) != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).base.planFlag == AppPlanFlagUtil.PLAN_PREPAYMENT) {
                        this.mPlanJsonBean = list.get(i).planJson;
                    }
                }
            }
            this.mSupervisorInfoControlUtil.init(getActivity(), getLoginAccount(), this.mTitleBar.getTitleViewContent(), this.mTypeInfoBaseInfoBean, this.mPrepaymentDeviceInfoBean, this.mPrepaymentWalletBean);
            return;
        }
        finish();
    }

    private void initView() {
        if (StringUtils.isNotEmpty(this.mSupervisorBean.studentName)) {
            this.mTvName.setText("**" + this.mSupervisorBean.studentName.substring(this.mSupervisorBean.studentName.length() - 1));
        }
        if (StringUtils.isNotEmpty(this.mSupervisorBean.studentMobile) && this.mSupervisorBean.studentMobile.length() > 5) {
            this.mTvPhone.setText(this.mSupervisorBean.studentMobile.substring(0, 3) + "******" + this.mSupervisorBean.studentMobile.substring(this.mSupervisorBean.studentMobile.length() - 2));
        }
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        if (loginAccountV3 != null) {
            LogUtil.e(TAG, loginAccountV3.studentId + PPSLabelView.Code + this.mSupervisorBean.studentId);
            if (loginAccountV3.studentId.equals(this.mSupervisorBean.studentId)) {
                this.mTvName.setText(this.mSupervisorBean.studentName);
                this.mTvPhone.setText(this.mSupervisorBean.studentMobile);
                this.mBtnChange.setVisibility(0);
                this.mBtnCancel.setVisibility(0);
                this.mIsEnableRefund = true;
            }
        }
    }

    private void initClickListeners() {
        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SupervisorInfoActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m308x2c01c705(view);
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SupervisorInfoActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m309x450318a4(view);
            }
        });
        findViewById(R.id.tv_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SupervisorInfoActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m310x5e046a43(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SupervisorInfoActivity, reason: not valid java name */
    /* synthetic */ void m308x2c01c705(View view) {
        if (ClickUtil.isFastDoubleClick200()) {
            return;
        }
        SetSupervisorActivity.launch(getActivity(), this.mMachineId);
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SupervisorInfoActivity, reason: not valid java name */
    /* synthetic */ void m309x450318a4(View view) {
        if (ClickUtil.isFastDoubleClick200()) {
            return;
        }
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SupervisorInfoActivity.1
            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                SupervisorInfoActivity.this.unBindSupervisor();
            }
        }, "提示", "是否卸任舍长身份？", "否", "是");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SupervisorInfoActivity, reason: not valid java name */
    /* synthetic */ void m310x5e046a43(View view) {
        if (ClickUtil.isFastDoubleClick200() || !checkRefund()) {
            return;
        }
        if (StringUtils.isNotEmpty(this.mRefundId)) {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SupervisorInfoActivity.2
                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    SupervisorInfoActivity.this.cancelRefund();
                }
            }, "提示", "确定要取消退款吗", "#ff0289fe", "不了", "确定");
        } else {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SupervisorInfoActivity.3
                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    SupervisorInfoActivity.this.mSupervisorInfoControlUtil.startCollect();
                }
            }, "提示", "请在设备前采集数据，数据采集成功后将清空水量才可申请退款", "#ff0289fe", "取消", "采集数据");
        }
    }

    private boolean checkRefund() {
        if (this.mPlanJsonBean.refundMoneyFlag != 1) {
            ToastUtils.show(getContext(), "暂未开通线上退款，退款请联系服务商");
            return false;
        }
        if (System.currentTimeMillis() > TimeUtils.strYMDeToSec(this.mPlanJsonBean.refundMoneyStopDate) + TimeUtils.getOneDayMillis() || System.currentTimeMillis() < TimeUtils.strYMDeToSec(this.mPlanJsonBean.refundMoneyStartDate)) {
            ToastUtils.show(getContext(), "暂未开通线上退款，退款请联系服务商.");
            return false;
        }
        if ((this.mPlanJsonBean.autoTransferRefundPayFlagTypeList != null && this.mPlanJsonBean.autoTransferRefundPayFlagTypeList.size() > 0) || ((this.mPlanJsonBean.manualRefundPayFlagTypeList != null && this.mPlanJsonBean.manualRefundPayFlagTypeList.size() > 0) || (this.mPlanJsonBean.originalRouteRefundPayFlagTypeList != null && this.mPlanJsonBean.originalRouteRefundPayFlagTypeList.size() > 0))) {
            return true;
        }
        ToastUtils.show(getContext(), "暂未开通线上退款，退款请联系服务商。");
        return false;
    }

    private void findHasRefundId() {
        if (this.mIsEnableRefund) {
            V3BusinessControllers.getInstance().findRefundOrderForPrepayment(getLoginAccount(), this.mPrepaymentDeviceInfoBean.machineId, this.mInvestorInfoBean.investorId, UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", new Listener<RefundBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SupervisorInfoActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, RefundBean refundBean, Object... objArr) {
                    if (SupervisorInfoActivity.this.mIsEnable) {
                        if (refundBean != null) {
                            SupervisorInfoActivity.this.mRefundId = refundBean.id;
                        }
                        if (StringUtils.isNotEmpty(SupervisorInfoActivity.this.mRefundId)) {
                            SupervisorInfoActivity.this.mTvRefund.setText("取消退款");
                        } else {
                            SupervisorInfoActivity.this.mTvRefund.setText("申请退款");
                        }
                        SupervisorInfoActivity.this.mTvRefund.setVisibility(0);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRefund() {
        V3BusinessControllers.getInstance().cancelRefundOrderPrepayment(getLoginAccount(), this.mPrepaymentDeviceInfoBean.machineId, this.mInvestorInfoBean.investorId, UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", new Listener<RefundBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SupervisorInfoActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SupervisorInfoActivity.this.getActivity(), "正在取消退款中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RefundBean refundBean, Object... objArr) {
                super.onComplete(controller, refundBean, objArr);
                if (SupervisorInfoActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(SupervisorInfoActivity.this.getContext(), "取消成功");
                    LocalDataUtil.saveIsNeedGetPrepaymentWalletInfo(SupervisorInfoActivity.this.getContext(), true);
                    SupervisorInfoActivity.this.mTvRefund.setText("申请退款");
                    SupervisorInfoActivity.this.mRefundId = "";
                    if (refundBean == null || !StringUtils.isNotEmpty(refundBean.id)) {
                        ToastUtils.show(SupervisorInfoActivity.this.getContext(), "下发水量失败");
                    } else {
                        SupervisorInfoActivity.this.mSupervisorInfoControlUtil.startSetWater(refundBean.id);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SupervisorInfoActivity.this.mIsEnable) {
                    SupervisorInfoActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unBindSupervisor() {
        V3BusinessControllers.getInstance().pastSupervisor(getLoginAccount(), this.mSupervisorBean.studentId, this.mMachineId, this.mSupervisorBean.studentName, this.mSupervisorBean.studentMobile, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SupervisorInfoActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SupervisorInfoActivity.this.getActivity(), "正在处理..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (SupervisorInfoActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(SupervisorInfoActivity.this.getActivity(), "卸任成功");
                    LocalDataUtil.saveIsNeedGetPrepaymentSupervisorInfo(SupervisorInfoActivity.this.getActivity(), true);
                    SupervisorInfoActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SupervisorInfoActivity.this.mIsEnable) {
                    SupervisorInfoActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SupervisorInfoActivity.7
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(getActivity()) + ")");
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }
}

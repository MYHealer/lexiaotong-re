package client.android.yixiaotong.v3.ui.control;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GDevice;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterInfoBean;
import client.android.yixiaotong.v3.bean.login.CreditAmountRuleBean;
import client.android.yixiaotong.v3.bean.login.JumpApp;
import client.android.yixiaotong.v3.bean.login.JumpAppBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentRedPackageAmountBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentWalletBean;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.comman.AppPlanFlagUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.BindRoomActivity;
import client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity;
import client.android.yixiaotong.v3.ui.error.ErrorControlUtil;
import client.android.yixiaotong.v3.ui.jump.JunpWebActivity;
import client.android.yixiaotong.v3.ui.register.ChangeLoginPswActivity;
import client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ApplicationControlUtil {
    private static final String TAG = "ApplicationControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private boolean mIsEnable;
    private boolean mIsLoaded;
    private String mMachineId;
    private OnListener mOnListener;

    public interface OnListener {
        void onError();
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
        this.mIsLoaded = false;
    }

    public void setListener(OnListener onListener) {
        this.mOnListener = onListener;
    }

    private ApplicationControlUtil() {
        this.mIsEnable = true;
        this.mIsLoaded = false;
    }

    private static final class SingleHolder {
        public static final ApplicationControlUtil Instance = new ApplicationControlUtil();

        private SingleHolder() {
        }
    }

    public static ApplicationControlUtil getInstance() {
        return SingleHolder.Instance;
    }

    public void setMinimumWarningAmount(Activity activity, Account account) {
        if (!this.mIsEnable || activity == null || LocalDataUtil.getAlarmSwitch(activity)) {
            return;
        }
        this.mAccount = account;
        this.mActivity = activity;
        if (StringUtils.isNotEmpty(LocalDataUtil.getTypeIdMachineId(activity, 18))) {
            String typeIdMachineId = LocalDataUtil.getTypeIdMachineId(this.mActivity, 18);
            if (!StringUtils.isNotEmpty(typeIdMachineId) || typeIdMachineId.split(";").length < 3) {
                return;
            }
            LogUtil.e(TAG, typeIdMachineId.split(";")[0] + "  " + typeIdMachineId.split(";")[1] + "  " + typeIdMachineId.split(";")[2]);
            this.mMachineId = typeIdMachineId.split(";")[0];
            getWalletInfo();
        }
    }

    private void getWalletInfo() {
        if (InvestorInfoUtilControl.getInstance().isUseAndroid(18).isUse) {
            TypeInfoBean typeInfoBean = InvestorInfoUtilControl.getInstance().getTypeInfoBean(AppPlanFlagUtil.PLAN_PREPAYMENT, 18);
            if (typeInfoBean == null || typeInfoBean.base == null || typeInfoBean.base.statusFlag == 1) {
                V3BusinessControllers.getInstance().getPrepaymentWallet(this.mAccount, this.mMachineId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorId(), new Listener<PrepaymentWalletBean>() { // from class: client.android.yixiaotong.v3.ui.control.ApplicationControlUtil.1
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, PrepaymentWalletBean prepaymentWalletBean, Object... objArr) {
                        if (!ApplicationControlUtil.this.mIsEnable || prepaymentWalletBean == null) {
                            return;
                        }
                        ApplicationControlUtil.this.getRedPackageAmount(prepaymentWalletBean);
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        boolean unused = ApplicationControlUtil.this.mIsEnable;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRedPackageAmount(final PrepaymentWalletBean prepaymentWalletBean) {
        V3BusinessControllers.getInstance().getPrepaymentRedPackageAmount(this.mAccount, this.mMachineId, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorId(), new Listener<PrepaymentRedPackageAmountBean>() { // from class: client.android.yixiaotong.v3.ui.control.ApplicationControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PrepaymentRedPackageAmountBean prepaymentRedPackageAmountBean, Object... objArr) {
                CreditAmountRuleBean creditAmountRule;
                if (!ApplicationControlUtil.this.mIsEnable || prepaymentRedPackageAmountBean == null || (creditAmountRule = InvestorInfoUtilControl.getInstance().getCreditAmountRule(18)) == null || creditAmountRule.minimumWarningAmount == null) {
                    return;
                }
                int i = prepaymentWalletBean.money + prepaymentRedPackageAmountBean.isRefund + prepaymentRedPackageAmountBean.noRefund;
                LogUtil.e(ApplicationControlUtil.TAG, "报警金额：" + creditAmountRule.minimumWarningAmount + " 实际金额:" + i);
                if (creditAmountRule.minimumWarningAmount.intValue() > i) {
                    TwoButtonDialog.getInstance().showDialog(ApplicationControlUtil.this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.control.ApplicationControlUtil.2.1
                        @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                        public void onCancle() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                        public void onConfirm() {
                            PrepaymentWalletActivity.launch(ApplicationControlUtil.this.mActivity, InvestorInfoUtilControl.getInstance().getTypeInfoBean(InvestorInfoUtilControl.getInstance().getPlanFlag(18), 18));
                        }
                    }, "提示", ApplicationControlUtil.this.mActivity.getResources().getString(R.string.balancewarningtip), "取消", "前往充值");
                }
            }
        });
    }

    public void jumpApp(Activity activity, String str) {
        List<JumpApp> list;
        String strEncode;
        Activity activity2 = this.mActivity;
        if (activity2 == null || LocalDataUtil.getAlarmSwitch(activity2)) {
            return;
        }
        LogUtil.d(TAG, "jumpapp");
        List<JumpAppBean> jumpApp = InvestorInfoUtilControl.getInstance().getJumpApp();
        for (int i = 0; i < jumpApp.size(); i++) {
            if (jumpApp.get(i).name.equals(str) && (list = jumpApp.get(i).jumpApp) != null && list.size() > 0) {
                LogUtil.d(TAG, list.get(0).jumpType + "  " + list.get(0).webUrl + "  " + list.get(0).appId);
                if (list.get(0).jumpType == 0) {
                    JunpWebActivity.launch(activity, list.get(0).webUrl);
                } else if (list.get(0).jumpType == 1) {
                    if (AppUtils.isWeixinAvilible(this.mActivity)) {
                        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(activity, "wxd9320c1760b6d01f");
                        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                        req.userName = InvestorInfoUtilControl.getInstance().getJumpApp().get(i).jumpApp.get(0).extData;
                        String str2 = InvestorInfoUtilControl.getInstance().getJumpApp().get(i).jumpApp.get(0).path;
                        if (StringUtils.isNotEmpty(str2)) {
                            req.path = str2;
                        }
                        req.miniprogramType = 0;
                        iwxapiCreateWXAPI.sendReq(req);
                    } else {
                        ToastUtils.show(activity, "未安装微信APP");
                    }
                } else if (list.get(0).jumpType == 2) {
                    LogUtil.e(TAG, "跳转支付宝");
                    if (AppUtils.checkAliPayInstalled(this.mActivity)) {
                        String str3 = list.get(0).appId;
                        String str4 = InvestorInfoUtilControl.getInstance().getJumpApp().get(i).jumpApp.get(0).path;
                        String str5 = InvestorInfoUtilControl.getInstance().getJumpApp().get(i).jumpApp.get(0).extData;
                        StringBuffer stringBuffer = new StringBuffer("alipays://platformapi/startapp?appId=");
                        stringBuffer.append(str3).append("&page=");
                        stringBuffer.append(str4);
                        LogUtil.e(TAG, str3 + "  " + str4);
                        if (StringUtils.isNotEmpty(str5)) {
                            try {
                                strEncode = URLEncoder.encode(str5, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                strEncode = null;
                            }
                        } else {
                            strEncode = null;
                        }
                        if (StringUtils.isNotEmpty(strEncode)) {
                            LogUtil.e(TAG, str3 + "  " + str4 + "  " + strEncode);
                            stringBuffer.append("&query=");
                            stringBuffer.append(strEncode);
                        }
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString())));
                    } else {
                        ToastUtils.show(activity, "未安装支付宝APP");
                    }
                } else if (list.get(0).jumpType == 3) {
                    String str6 = list.get(0).appId;
                    if (AppUtils.isInstallAppAvilible(activity, str6)) {
                        String str7 = list.get(0).extData;
                        Intent intent = new Intent("android.intent.action.MAIN");
                        intent.addCategory("android.intent.category.LAUNCHER");
                        intent.setComponent(new ComponentName(str6, str7));
                        activity.startActivity(intent);
                    } else {
                        ToastUtils.show(activity, "未安装相应APP");
                    }
                }
            }
        }
    }

    public void isNeedChangePsw(Account account, Activity activity) {
        if (activity == null || LocalDataUtil.getAlarmSwitch(activity)) {
            return;
        }
        this.mAccount = account;
        this.mActivity = activity;
        if (LocalDataUtil.getIsNeedChangePsw(activity)) {
            client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.getInstance().showDialog(this.mActivity, new client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.control.ApplicationControlUtil.3
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    ChangeLoginPswActivity.launch(ApplicationControlUtil.this.mActivity);
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                    LogUtil.e(ApplicationControlUtil.TAG, "使用原密码");
                    ApplicationControlUtil.this.delayedPsw();
                }
            }, "提示", "为了您的账户安全，建议定期更换密码", "使用原密码", "前往修改");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delayedPsw() {
        V3BusinessControllers.getInstance().getDelayedPassword(this.mAccount, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.control.ApplicationControlUtil.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ApplicationControlUtil.this.mActivity, "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (ApplicationControlUtil.this.mIsEnable) {
                    LocalDataUtil.saveIsNeedChangePsw(ApplicationControlUtil.this.mActivity, false);
                    BaseMaterialDialog.dissmisMaterialDialog();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ApplicationControlUtil.this.mIsEnable) {
                    ApplicationControlUtil.this.onError(clientException);
                }
            }
        });
    }

    public void getElecMeterBindInfo() {
        V3BusinessControllers.getInstance().getUserInfoElecMeter(this.mAccount, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorId(), UserInfoUtilControl.getInstance().getStudentId(), 1, new Listener<BindElecMeterInfoBean>() { // from class: client.android.yixiaotong.v3.ui.control.ApplicationControlUtil.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(ApplicationControlUtil.this.mActivity, "获取电表信息.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BindElecMeterInfoBean bindElecMeterInfoBean, Object... objArr) {
                super.onComplete(controller, bindElecMeterInfoBean, objArr);
                if (ApplicationControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (!StringUtils.isNotEmpty(bindElecMeterInfoBean.roomAddress) || !StringUtils.isNotEmpty(bindElecMeterInfoBean.factoryNo) || !StringUtils.isNotEmpty(bindElecMeterInfoBean.thirdPartyUserNumber)) {
                        BindRoomActivity.launch(ApplicationControlUtil.this.mActivity, 0);
                    } else {
                        ElecMeterControlActivity.launch(ApplicationControlUtil.this.mActivity, bindElecMeterInfoBean);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ApplicationControlUtil.this.mIsEnable) {
                    ErrorControlUtil.getInstance().onError(ApplicationControlUtil.this.mAccount, clientException, ApplicationControlUtil.this.mActivity, false, "首页");
                }
            }
        });
    }

    public void getWalletBalance() {
        Activity activity = this.mActivity;
        if (activity == null || LocalDataUtil.getAlarmSwitch(activity)) {
            return;
        }
        String loadWalletDate = LocalDataUtil.getLoadWalletDate(this.mActivity);
        boolean desktopToMainPage = LocalDataUtil.getDesktopToMainPage(this.mActivity);
        boolean firstLogin = LocalDataUtil.getFirstLogin(this.mActivity);
        LogUtil.e(TAG, "getWalletBalance1:" + desktopToMainPage + PPSLabelView.Code + firstLogin + PPSLabelView.Code + this.mIsEnable + PPSLabelView.Code + this.mIsLoaded);
        if ((desktopToMainPage || firstLogin) && !this.mIsLoaded && this.mIsEnable && InvestorInfoUtilControl.getInstance().isEnablePlanFlag(1)) {
            if (StringUtils.isNotEmpty(loadWalletDate) && TimeUtils.formatTime(System.currentTimeMillis()).equals(loadWalletDate)) {
                return;
            }
            LogUtil.e(TAG, "getWalletBalance2:");
            LocalDataUtil.saveDesktopToMainPage(this.mActivity, false);
            V3BusinessControllers.getInstance().postGetWalletInfoByInvestoridV2(this.mAccount, InvestorInfoUtilControl.getInstance().getInvestorId(), new Listener<WalletInfoBean>() { // from class: client.android.yixiaotong.v3.ui.control.ApplicationControlUtil.6
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, WalletInfoBean walletInfoBean, Object... objArr) {
                    if (ApplicationControlUtil.this.mIsEnable) {
                        ApplicationControlUtil.this.mIsLoaded = true;
                        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
                        if (schoolId.equals("80612") || schoolId.equals("80798")) {
                            if ((walletInfoBean.statusFlag == 0 || walletInfoBean.statusFlag == 1) && walletInfoBean.money < 100) {
                                ApplicationControlUtil.this.showRechargeDialog("1", walletInfoBean);
                                return;
                            }
                            return;
                        }
                        if ((walletInfoBean.statusFlag == 0 || walletInfoBean.statusFlag == 1) && walletInfoBean.money < 1000) {
                            ApplicationControlUtil.this.showRechargeDialog("10", walletInfoBean);
                        }
                    }
                }
            });
        }
    }

    private void showDialog(String str) {
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (this.mIsEnable) {
            OnListener onListener = this.mOnListener;
            if (onListener != null) {
                onListener.onError();
            }
            ErrorControlUtil.getInstance().onHideError(this.mAccount, clientException, this.mActivity, false, 1, "首页");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRechargeDialog(String str, final WalletInfoBean walletInfoBean) {
        client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.getInstance().showDialogRachargeTip(this.mActivity, new client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.control.ApplicationControlUtil.7
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                WalletDetailActivity.launch(ApplicationControlUtil.this.mActivity, walletInfoBean);
            }
        }, "提示", "您的钱包余额已低于" + str + "元，请尽快充值，以免影响使用", "再等等", "去充值");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadOrder() {
        String[] strArrSplit;
        String[] strArrSplit2;
        String bLEUseRecord = LocalDataUtil.getBLEUseRecord(this.mActivity);
        LogUtil.e(TAG, "uploadOrder:" + bLEUseRecord);
        if (StringUtils.isEmpty(bLEUseRecord) || (strArrSplit = bLEUseRecord.split(";")) == null || strArrSplit.length < 1 || (strArrSplit2 = strArrSplit[0].split(",")) == null || strArrSplit2.length < 4) {
            return;
        }
        int i = Integer.parseInt(strArrSplit2[0]);
        String str = strArrSplit2[1];
        String str2 = strArrSplit2[2];
        final NBOr4GDevice nBOr4GDevice = new NBOr4GDevice();
        nBOr4GDevice.machineData = strArrSplit2[3];
        V3BusinessControllers.getInstance().postHandleData(this.mAccount, i, str, str2, nBOr4GDevice, 0, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.control.ApplicationControlUtil.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (ApplicationControlUtil.this.mIsEnable) {
                    LocalDataUtil.clearBLEUseRecord(ApplicationControlUtil.this.mActivity, nBOr4GDevice.machineData);
                    ApplicationControlUtil.this.uploadOrder();
                }
            }
        });
    }
}

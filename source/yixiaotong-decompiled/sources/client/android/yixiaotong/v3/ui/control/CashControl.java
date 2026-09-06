package client.android.yixiaotong.v3.ui.control;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.login.HostUrlBean;
import client.android.yixiaotong.v3.bean.pay.SelectAllBean;
import client.android.yixiaotong.v3.bean.pay.SignBean;
import client.android.yixiaotong.v3.bean.pay.SignInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CashControl {
    private static final String TAG = "CashControl";
    private Account mAccount;
    private Activity mActivity;
    private CashListener mCashListener;
    private int mCloudsaleSign;
    private boolean mIsEnable;
    private boolean mIsLoading;
    private String mPostInvestorId;
    private String mPostSchoolId;
    private ZKTCashListener mZKTCashListener;

    public interface CashListener {
        void onSchoolAndInvestor(String str);
    }

    public interface ZKTCashListener {
        void onSign(int i);
    }

    public void init(Account account, Activity activity) {
        this.mAccount = account;
        this.mActivity = activity;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void setListener(CashListener cashListener) {
        this.mCashListener = cashListener;
    }

    public void setZKTListener(ZKTCashListener zKTCashListener) {
        this.mZKTCashListener = zKTCashListener;
    }

    private CashControl() {
        this.mIsEnable = true;
        this.mCloudsaleSign = -1;
        this.mIsLoading = false;
    }

    private static final class SingleHolder {
        public static final CashControl Instance = new CashControl();

        private SingleHolder() {
        }
    }

    public static CashControl getInstance() {
        return SingleHolder.Instance;
    }

    public void setRedisCash() {
        Activity activity = this.mActivity;
        if (activity == null || LocalDataUtil.getAlarmSwitch(activity)) {
            return;
        }
        String studentId = UserInfoUtilControl.getInstance().getStudentId();
        final String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        final String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        if (!StringUtils.isNotEmpty(studentId) || this.mIsLoading) {
            return;
        }
        if (StringUtils.isNotEmpty(this.mPostInvestorId) && StringUtils.isNotEmpty(this.mPostSchoolId) && investorId.equals(this.mPostInvestorId) && schoolId.equals(this.mPostSchoolId)) {
            return;
        }
        V3BusinessControllers.getInstance().postRedisCach(this.mAccount, studentId, schoolId + "," + investorId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.control.CashControl.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                CashControl.this.mIsLoading = true;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                CashControl.this.mIsLoading = false;
                CashControl.this.mPostInvestorId = investorId;
                CashControl.this.mPostSchoolId = schoolId;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                CashControl.this.mIsLoading = false;
            }
        });
    }

    public void getRedisCash() {
        Activity activity = this.mActivity;
        if (activity == null || LocalDataUtil.getAlarmSwitch(activity)) {
            return;
        }
        String studentId = UserInfoUtilControl.getInstance().getStudentId();
        if (StringUtils.isNotEmpty(studentId)) {
            V3BusinessControllers.getInstance().getRedisCach(this.mAccount, studentId, new Listener<String>() { // from class: client.android.yixiaotong.v3.ui.control.CashControl.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, String str, Object... objArr) {
                    if (CashControl.this.mIsEnable && StringUtils.isNotEmpty(str) && str.contains(",") && CashControl.this.mCashListener != null) {
                        CashControl.this.mCashListener.onSchoolAndInvestor(str);
                    }
                }
            });
        }
    }

    public void exitapp() {
        Activity activity = this.mActivity;
        if (activity == null || LocalDataUtil.getAlarmSwitch(activity)) {
            return;
        }
        V3BusinessControllers.getInstance().getUserLogout(this.mAccount, new Listener<String>() { // from class: client.android.yixiaotong.v3.ui.control.CashControl.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(CashControl.this.mActivity, "正在退出APP", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                if (CashControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(CashControl.this.mActivity);
                    CashControl.this.mActivity.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CashControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(CashControl.this.mActivity);
                    CashControl.this.mActivity.finish();
                }
            }
        });
    }

    public void getHostUrl() {
        Activity activity = this.mActivity;
        if (activity == null || LocalDataUtil.getAlarmSwitch(activity)) {
            return;
        }
        final String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        final String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        final String str = "102";
        long requestTime = LocalDataUtil.getRequestTime(BaseApplication.app, schoolId, investorId);
        LogUtil.e(TAG, "加载时间:" + requestTime + PPSLabelView.Code + schoolId + PPSLabelView.Code + investorId);
        if (System.currentTimeMillis() / 1000 <= requestTime) {
            return;
        }
        V3BusinessControllers.getInstance().getHostUrlBySchoolIdAndInvestorId(this.mAccount, schoolId, investorId, "102", new Listener<List<HostUrlBean>>() { // from class: client.android.yixiaotong.v3.ui.control.CashControl.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<HostUrlBean> list, Object... objArr) {
                if (!CashControl.this.mIsEnable || list == null || list.size() <= 0) {
                    return;
                }
                for (HostUrlBean hostUrlBean : list) {
                    if (hostUrlBean != null && StringUtils.isNotEmpty(hostUrlBean.hostUrl) && hostUrlBean.code.equals(str)) {
                        LogUtil.e(CashControl.TAG, "getHostUrl:" + hostUrlBean.hostUrl);
                        LocalDataUtil.saveUrl(BaseApplication.app, hostUrlBean.hostUrl);
                        if (StringUtils.isNotEmpty(hostUrlBean.delayExpire)) {
                            long j = Long.parseLong(hostUrlBean.delayExpire);
                            if (j > 0) {
                                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                                LogUtil.e(CashControl.TAG, j + "  " + jCurrentTimeMillis);
                                LocalDataUtil.saveUrlRequestTime(BaseApplication.app, schoolId, investorId, j + jCurrentTimeMillis);
                            } else {
                                LocalDataUtil.saveUrlRequestTime(BaseApplication.app, schoolId, investorId, 0L);
                            }
                        }
                    }
                }
            }
        });
    }

    public void isNeedSignZKT() {
        Activity activity = this.mActivity;
        if (activity == null || LocalDataUtil.getAlarmSwitch(activity)) {
            return;
        }
        this.mCloudsaleSign = InvestorInfoUtilControl.getInstance().getCloudsaleSign();
        LogUtil.e(TAG, "isNeedSignZKT:" + this.mCloudsaleSign + "  " + LocalDataUtil.getIsNeedTipSignZKT(this.mActivity));
        int i = this.mCloudsaleSign;
        if (i == 1) {
            paySelectAll(2, true, true);
            return;
        }
        if (i == 3) {
            if (LocalDataUtil.getIsNeedTipSignZKT(this.mActivity)) {
                LocalDataUtil.saveIsNeedTipSignZKT(this.mActivity);
                paySelectAll(2, true, false);
            } else if (LocalDataUtil.getIsNeedTipSignZKT(this.mActivity, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorId())) {
                paySelectAll(2, true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showZKTDialog() {
        String string;
        if (this.mCloudsaleSign == 1) {
            string = this.mActivity.getResources().getString(R.string.sign_zkt_content);
        } else {
            string = this.mActivity.getResources().getString(R.string.sign_zkt_content3);
        }
        TwoButtonDialog.getInstance().showDialog(this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.control.CashControl.5
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                if (AppUtils.checkAliPayInstalled(CashControl.this.mActivity)) {
                    LocalDataUtil.saveIsNeedLoadZKT(CashControl.this.mActivity, true);
                    CashControl.getInstance().toZFBSmall(CashControl.this.mActivity);
                } else {
                    ToastUtils.show(CashControl.this.mActivity, "你的手机未安装支付宝，无法签约");
                    CashControl.this.showZKTDialog();
                }
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
                if (CashControl.this.mCloudsaleSign != 1) {
                    LocalDataUtil.saveIsNeedTipSignZKT(CashControl.this.mActivity, false);
                    LocalDataUtil.saveIsNeedTipSignZKT(CashControl.this.mActivity, false, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorId());
                } else {
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(CashControl.this.mActivity);
                    CashControl.this.mActivity.finish();
                }
            }
        }, "提示", string, R.color.ff242933, this.mCloudsaleSign == 1 ? "退出" : "取消", "去签约");
    }

    public void paySelectAll(final int i, final boolean z, final boolean z2) {
        V3BusinessControllers.getInstance().paySelectAll(this.mAccount, UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorId(), UserInfoUtilControl.getInstance().getStudentId(), i, new Listener<List<SelectAllBean>>() { // from class: client.android.yixiaotong.v3.ui.control.CashControl.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<SelectAllBean> list, Object... objArr) {
                if (CashControl.this.mIsEnable) {
                    LogUtil.e(CashControl.TAG, CashControl.this.mIsEnable + "  " + (list != null) + "  " + i);
                    if (list == null || list.size() <= 0 || !StringUtils.isNotEmpty(list.get(0).config_json)) {
                        if (z) {
                            CashControl.this.showZKTDialog();
                            return;
                        } else {
                            if (CashControl.this.mZKTCashListener != null) {
                                CashControl.this.mZKTCashListener.onSign(0);
                                return;
                            }
                            return;
                        }
                    }
                    LogUtil.e(CashControl.TAG, CashControl.this.mIsEnable + "  " + list.size() + StringUtils.isNotEmpty(list.get(0).config_json));
                    try {
                        SignInfoBean signInfoBean = (SignInfoBean) GsonUtils.getInstance().parse(SignInfoBean.class, list.get(0).config_json);
                        if (StringUtils.isNotEmpty(signInfoBean.userId)) {
                            if (!z) {
                                if (CashControl.this.mZKTCashListener != null) {
                                    CashControl.this.mZKTCashListener.onSign(i);
                                }
                            } else {
                                CashControl.this.getSignState(signInfoBean.userId);
                            }
                        }
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CashControl.this.mIsEnable && z2) {
                    CashControl.this.onError(clientException);
                }
            }
        });
    }

    public void getSignState(String str) {
        V3BusinessControllers.getInstance().getPayResult(this.mAccount, 2, str, new Listener<SignBean>() { // from class: client.android.yixiaotong.v3.ui.control.CashControl.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SignBean signBean, Object... objArr) {
                if (CashControl.this.mIsEnable) {
                    if (signBean == null || !signBean.code.equalsIgnoreCase("10000")) {
                        CashControl.this.showZKTDialog();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CashControl.this.mIsEnable) {
                    CashControl.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(this.mActivity, "首页", clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    public void toZFBSmall(Context context) {
        try {
            StringBuffer stringBuffer = new StringBuffer("alipays://platformapi/startapp?appId=2021002121631750&page=pages/home/index&query=");
            StringBuilder sb = new StringBuilder("account=");
            UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
            sb.append(loginAccountV3.studentMobile).append("&studentId=");
            sb.append(loginAccountV3.studentId).append("&token=");
            sb.append(LocalDataUtil.getLastTokenInfo(context)).append("&url=");
            sb.append(LocalDataUtil.getUrl(context));
            stringBuffer.append(URLEncoder.encode(sb.toString(), "UTF-8"));
            LogUtil.e(TAG, "跳转小程序token：" + loginAccountV3.studentMobile + "  " + loginAccountV3.studentId + "  " + LocalDataUtil.getLastTokenInfo(context));
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString())));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

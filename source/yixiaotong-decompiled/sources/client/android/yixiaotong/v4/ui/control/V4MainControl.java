package client.android.yixiaotong.v4.ui.control;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.pay.SignInfoBean;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.http.bean.V4ProjectConfigBean;
import client.android.yixiaotong.v4.http.bean.V4SelectAllBean;
import client.android.yixiaotong.v4.http.bean.V4SignBean;
import client.android.yixiaotong.v4.http.bean.V4UserInfoDetailBean;
import client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity;
import client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity;
import client.android.yixiaotong.v4.ui.app.electricitymeter.V4SelecetDeviceActivity;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.V4LocalDataUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4MainControl {
    private static final String TAG = "V4MainControl";
    private int mCloudsaleSign;
    private boolean mIsEnable;
    private OnListener mOnListener;
    private ZKTCashListener mZKTCashListener;

    public interface OnListener {
        void onError(ClientException clientException);

        void onHome();

        void onProjectConfig();
    }

    public interface ZKTCashListener {
        void onSign(int i);
    }

    public void setListener(OnListener onListener) {
        this.mOnListener = onListener;
    }

    public void setZKTListener(ZKTCashListener zKTCashListener) {
        this.mZKTCashListener = zKTCashListener;
    }

    private V4MainControl() {
        this.mIsEnable = true;
    }

    private static final class SingleHolder {
        public static final V4MainControl Instance = new V4MainControl();

        private SingleHolder() {
        }
    }

    public static V4MainControl getInstance() {
        return SingleHolder.Instance;
    }

    public void onResume() {
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    public void onPause() {
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
    }

    public void getUserInfo(final Activity activity, final Account account) {
        V4BusinessControllers.getInstance().getUserInfo(account, new Listener<V4UserInfoDetailBean>() { // from class: client.android.yixiaotong.v4.ui.control.V4MainControl.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(activity, "获取用户信息", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4UserInfoDetailBean v4UserInfoDetailBean, Object... objArr) {
                super.onComplete(controller, v4UserInfoDetailBean, objArr);
                if (V4MainControl.this.mIsEnable) {
                    V4MainControl.this.getCustomerPersonInfo(activity, account);
                    V4MainControl.this.getHomeInfo(activity, account);
                    V4MainControl.this.getProjectConfig(activity, account);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4MainControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (V4MainControl.this.mOnListener != null) {
                        V4MainControl.this.mOnListener.onError(clientException);
                    }
                    V4MainControl.this.onErrorShouYe(activity, clientException);
                }
            }
        });
    }

    public void getCustomerPersonInfo(Activity activity, Account account) {
        V4BusinessControllers.getInstance().getCustomerPersonInfo(account, new Listener<V4UserInfoDetailBean>() { // from class: client.android.yixiaotong.v4.ui.control.V4MainControl.2
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getProjectConfig(final Activity activity, Account account) {
        V4BusinessControllers.getInstance().getProjectConfig(account, new Listener<V4ProjectConfigBean>() { // from class: client.android.yixiaotong.v4.ui.control.V4MainControl.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ProjectConfigBean v4ProjectConfigBean, Object... objArr) {
                if (!V4MainControl.this.mIsEnable || V4MainControl.this.mOnListener == null) {
                    return;
                }
                V4MainControl.this.mOnListener.onProjectConfig();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4MainControl.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().postErrorLog(activity, clientException.getDetail());
                }
            }
        });
    }

    public void getHomeInfo(final Activity activity, final Account account) {
        V4BusinessControllers.getInstance().getHomeInfo(account, new Listener<V4HomeInfoBean>() { // from class: client.android.yixiaotong.v4.ui.control.V4MainControl.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("加载数据...");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4HomeInfoBean v4HomeInfoBean, Object... objArr) {
                if (V4MainControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4HomeInfoUtil.getInstance().saveHomeInfoV4(v4HomeInfoBean);
                    if (V4MainControl.this.mOnListener != null) {
                        V4MainControl.this.mOnListener.onHome();
                    }
                    V4MainControl.this.postOfflineLog(activity, account);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4MainControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (V4MainControl.this.mOnListener != null) {
                        V4MainControl.this.mOnListener.onError(clientException);
                    }
                    V4MainControl.this.onErrorShouYe(activity, clientException);
                }
            }
        });
    }

    public void selectElecMeterInfo(final Activity activity, Account account, final int i) {
        V4BusinessControllers.getInstance().getElecMeterInfo(account, i, new Listener<V4ElecMeterInfoBean>() { // from class: client.android.yixiaotong.v4.ui.control.V4MainControl.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(activity, "加载设备信息.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ElecMeterInfoBean v4ElecMeterInfoBean, Object... objArr) {
                super.onComplete(controller, v4ElecMeterInfoBean, objArr);
                if (V4MainControl.this.mIsEnable) {
                    if (v4ElecMeterInfoBean == null) {
                        V4SelecetDeviceActivity.launch(activity, i);
                        return;
                    }
                    int i2 = i;
                    if (i2 == 17) {
                        V4ElecMeterAnalysisActivity.launch(activity, v4ElecMeterInfoBean.mac, i);
                    } else {
                        V4ElecMeterControlActivity.launch(activity, v4ElecMeterInfoBean, i2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4MainControl.this.mIsEnable) {
                    if (clientException.getCode() == 10) {
                        V4SelecetDeviceActivity.launch(activity, i);
                    } else {
                        V4ErrorControlUtil.getInstance().showDialog(clientException, activity, false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOfflineLog(final Activity activity, Account account) {
        final String offlineMac = V4LocalDataUtil.getOfflineMac(activity);
        LogUtil.e(TAG, "postOfflineLog mac:" + offlineMac);
        if (StringUtils.isEmpty(offlineMac)) {
            return;
        }
        String offlineLog = V4LocalDataUtil.getOfflineLog(activity, offlineMac);
        LogUtil.e(TAG, "postOfflineLog:" + offlineLog);
        if (StringUtils.isEmpty(offlineLog)) {
            V4LocalDataUtil.delectOfflineMac(activity, offlineMac);
        }
        V4BusinessControllers.getInstance().postAppMonitorReport(account, V4LocalDataUtil.getOfflineMac(activity), offlineLog, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.control.V4MainControl.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                super.onComplete(controller, successBean, objArr);
                V4LocalDataUtil.saveOfflineLog(activity, offlineMac, "");
            }
        });
    }

    public void isNeedSignZKT(Activity activity, Account account) {
        this.mCloudsaleSign = V4ProjectConfigInfoUtil.getInstance().getProjectInfoV4().aliCartoonSign.intValue();
        LogUtil.e(TAG, "isNeedSignZKT:" + this.mCloudsaleSign + "  ");
        int i = this.mCloudsaleSign;
        if (i == 1) {
            paySelectAll(account, activity, 2, true, true);
        } else if (i == 2) {
            paySelectAll(account, activity, 2, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showZKTDialog(final Activity activity) {
        String string;
        if (this.mCloudsaleSign == 1) {
            string = activity.getResources().getString(R.string.sign_zkt_content);
        } else {
            string = activity.getResources().getString(R.string.sign_zkt_content3);
        }
        TwoButtonDialog.getInstance().showDialog(activity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.control.V4MainControl.7
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                if (AppUtils.checkAliPayInstalled(activity)) {
                    if (V4MainControl.this.mCloudsaleSign == 1) {
                        V4LocalDataUtil.saveIsNeedLoadZKT(activity, true);
                    }
                    V4MainControl.this.toZFBSmall(activity);
                } else {
                    ToastUtils.show(activity, "你的手机未安装支付宝，无法签约");
                    V4MainControl.this.showZKTDialog(activity);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
                if (V4MainControl.this.mCloudsaleSign == 1) {
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(activity);
                    activity.finish();
                }
            }
        }, "提示", string, R.color.ff242933, this.mCloudsaleSign == 1 ? "退出" : "取消", "去签约");
    }

    public void paySelectAll(final Account account, final Activity activity, final int i, final boolean z, final boolean z2) {
        V4BusinessControllers.getInstance().selectAll(account, new Listener<List<V4SelectAllBean>>() { // from class: client.android.yixiaotong.v4.ui.control.V4MainControl.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<V4SelectAllBean> list, Object... objArr) {
                if (V4MainControl.this.mIsEnable) {
                    LogUtil.e(V4MainControl.TAG, V4MainControl.this.mIsEnable + "  " + (list != null) + "  " + i);
                    if (list == null || list.size() <= 0 || !StringUtils.isNotEmpty(list.get(0).configJson)) {
                        if (z) {
                            V4MainControl.this.showZKTDialog(activity);
                            return;
                        } else {
                            if (V4MainControl.this.mZKTCashListener != null) {
                                V4MainControl.this.mZKTCashListener.onSign(0);
                                return;
                            }
                            return;
                        }
                    }
                    LogUtil.e(V4MainControl.TAG, V4MainControl.this.mIsEnable + "  " + list.size());
                    try {
                        SignInfoBean signInfoBean = (SignInfoBean) GsonUtils.getInstance().parse(SignInfoBean.class, list.get(0).configJson);
                        if (StringUtils.isNotEmpty(signInfoBean.userId)) {
                            if (!z) {
                                if (V4MainControl.this.mZKTCashListener != null) {
                                    V4MainControl.this.mZKTCashListener.onSign(i);
                                }
                            } else {
                                V4MainControl.this.getSignState(account, activity, signInfoBean.userId);
                            }
                        }
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4MainControl.this.mIsEnable && z2) {
                    V4MainControl.this.onError(activity, clientException);
                }
            }
        });
    }

    public void getSignState(Account account, final Activity activity, String str) {
        V4BusinessControllers.getInstance().getSignAContractResult(account, str, new Listener<V4SignBean>() { // from class: client.android.yixiaotong.v4.ui.control.V4MainControl.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4SignBean v4SignBean, Object... objArr) {
                if (V4MainControl.this.mIsEnable) {
                    if (v4SignBean == null || !v4SignBean.code.equalsIgnoreCase("10000")) {
                        V4MainControl.this.showZKTDialog(activity);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4MainControl.this.mIsEnable) {
                    V4MainControl.this.onError(activity, clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Activity activity, ClientException clientException) {
        if (clientException.getCode() == 403) {
            ToastUtils.show(activity, "请重新登录");
            AccountManager.getInstance().clearLoginAccount();
            LoginActivity.launch(activity);
            activity.finish();
            return;
        }
        V4ErrorControlUtil.getInstance().showDialog(clientException, activity, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onErrorShouYe(Activity activity, ClientException clientException) {
        if (clientException.getCode() == 403) {
            ToastUtils.show(activity, "请重新登录");
            AccountManager.getInstance().clearLoginAccount();
            LoginActivity.launch(activity);
            activity.finish();
        }
    }

    public void toZFBSmall(Context context) {
        try {
            StringBuffer stringBuffer = new StringBuffer("alipays://platformapi/startapp?appId=2021002121631750&page=pages/home/index&query=");
            StringBuilder sb = new StringBuilder("schoolName=");
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            sb.append(loginAccountV4.customerName).append("&schoolVersion=4&token=");
            sb.append(loginAccountV4.token);
            stringBuffer.append(URLEncoder.encode(sb.toString(), "UTF-8"));
            LogUtil.e(TAG, "跳转小程序token：" + loginAccountV4.customerName + "  " + loginAccountV4.token);
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString())));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

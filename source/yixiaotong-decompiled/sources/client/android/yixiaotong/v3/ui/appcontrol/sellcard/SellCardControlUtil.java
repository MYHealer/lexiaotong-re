package client.android.yixiaotong.v3.ui.appcontrol.sellcard;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bean.appointment.AppointmentBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetOrderBean;
import client.android.yixiaotong.v3.bean.login.PayPaymentBean;
import client.android.yixiaotong.v3.bean.sellcard.DeductionRuleBean;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.payutil.PayWayControlUtil;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SellCardControlUtil {
    private static final String TAG = "SellCardControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private String mAuthData;
    private BluetoothDevice mBluetoothDevice;
    private ConnectState mConnectState;
    private String mDeviceVer;
    private FlowState mFlowState;
    private int mICBCIndex;
    private String mInvestorId;
    private boolean mIsEnable;
    private OnListener mOnListener;
    private List<PayPaymentBean> mPayPaymentBeanList;
    private String mSchoolId;
    private int mSelectWay;
    private String mTitleContent;
    private UserInfo mUserInfo;

    private enum ConnectState {
        none,
        connecting,
        connectfail,
        connected,
        senddataend
    }

    private enum FlowState {
        none,
        startauth,
        authend,
        authfail
    }

    public interface OnListener {
        void onAuth();

        void onError(int i);

        void onGetCardPrice(int i);

        void onGetWalletInfo(WalletInfoBean walletInfoBean);

        void onIsHasDevice(boolean z);
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void setListener(OnListener onListener) {
        this.mOnListener = onListener;
    }

    public void setPayPaymentBean(List<PayPaymentBean> list) {
        this.mPayPaymentBeanList = list;
    }

    private SellCardControlUtil() {
        this.mIsEnable = true;
        this.mDeviceVer = "00,08";
        this.mPayPaymentBeanList = new ArrayList();
        this.mICBCIndex = 1;
        this.mFlowState = FlowState.none;
        this.mConnectState = ConnectState.none;
    }

    private static final class SingleHolder {
        private static final SellCardControlUtil INSTANCE = new SellCardControlUtil();

        private SingleHolder() {
        }
    }

    public static SellCardControlUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void init(Activity activity, Account account, String str) {
        this.mActivity = activity;
        this.mAccount = account;
        this.mTitleContent = str;
        this.mSchoolId = UserInfoUtilControl.getInstance().getSchoolId();
        this.mInvestorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        this.mUserInfo = UserInfoUtil.getInstance().getLoginAccountV3();
    }

    public void onResume() {
        this.mIsEnable = true;
        LogUtil.e(TAG, "onResume");
    }

    public void getCardPrice(final int i) {
        V3BusinessControllers.getInstance().selectDeductionRule(this.mAccount, this.mSchoolId, 9, this.mInvestorId, this.mDeviceVer, new Listener<DeductionRuleBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SellCardControlUtil.this.mActivity, "正在获取卡片工本费.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeductionRuleBean deductionRuleBean, Object... objArr) {
                if (SellCardControlUtil.this.mIsEnable) {
                    if (i == 1) {
                        SellCardControlUtil.this.getWalletInfo();
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                    }
                    if (deductionRuleBean != null && deductionRuleBean.rule != null) {
                        if (StringUtils.isNotEmpty(deductionRuleBean.rule.byteinfo)) {
                            int i2 = Integer.parseInt(deductionRuleBean.rule.byteinfo, 16);
                            if (SellCardControlUtil.this.mOnListener != null) {
                                SellCardControlUtil.this.mOnListener.onGetCardPrice(i2);
                                return;
                            }
                            return;
                        }
                        SellCardControlUtil.this.showDialog(false, false, false, "未配置卡片工本费");
                        return;
                    }
                    SellCardControlUtil.this.showDialog(false, false, false, "未配置卡片工本费");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardControlUtil.this.mIsEnable) {
                    SellCardControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    public void getWalletInfo() {
        V3BusinessControllers.getInstance().postGetWalletInfoByInvestorid(this.mAccount, this.mInvestorId, new Listener<WalletInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在获取钱包信息..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WalletInfoBean walletInfoBean, Object... objArr) {
                if (SellCardControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (walletInfoBean != null) {
                        if (SellCardControlUtil.this.mOnListener != null) {
                            SellCardControlUtil.this.mOnListener.onGetWalletInfo(walletInfoBean);
                            return;
                        }
                        return;
                    }
                    SellCardControlUtil.this.showDialog(false, false, false, "获取钱包数据异常");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardControlUtil.this.mIsEnable) {
                    SellCardControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    public void isHasSellCardDevice() {
        V3BusinessControllers.getInstance().getIsHasSellCardDevice(this.mAccount, this.mInvestorId, this.mSchoolId, 9, this.mDeviceVer, new Listener<Integer>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SellCardControlUtil.this.mActivity, "查看是否有可用设备..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Integer num, Object... objArr) {
                if (SellCardControlUtil.this.mIsEnable) {
                    boolean z = num.intValue() > 0;
                    if (SellCardControlUtil.this.mOnListener != null) {
                        SellCardControlUtil.this.mOnListener.onIsHasDevice(z);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SellCardControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    public void getOrder(int i, int i2, final int i3) {
        int i4;
        int i5;
        this.mSelectWay = i2;
        int payPaymentFlag = InvestorInfoUtilControl.getInstance().getPayPaymentFlag(9);
        List<PayPaymentBean> list = this.mPayPaymentBeanList;
        if (list == null || list.size() <= 0) {
            i4 = 0;
            i5 = 0;
        } else {
            i4 = this.mPayPaymentBeanList.get(this.mSelectWay).payFlag;
            i5 = this.mPayPaymentBeanList.get(this.mSelectWay).payFlagType;
        }
        V3BusinessControllers.getInstance().postCreateBluetoothOrder(this.mAccount, this.mInvestorId, this.mSchoolId, this.mUserInfo.studentId, 9, this.mUserInfo.studentMobile, payPaymentFlag, i4, i5, i, this.mUserInfo.studentName, new Listener<DMGetOrderBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SellCardControlUtil.this.mActivity, "下单中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DMGetOrderBean dMGetOrderBean, Object... objArr) {
                if (SellCardControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (i3 == 1) {
                        ToastUtils.show(SellCardControlUtil.this.mActivity, "支付成功");
                        SellCardControlUtil.this.getWalletInfo();
                    }
                    if (dMGetOrderBean.payInfo != null) {
                        PayWayControlUtil.getInstance().pay(SellCardControlUtil.this.mActivity, dMGetOrderBean, ((PayPaymentBean) SellCardControlUtil.this.mPayPaymentBeanList.get(SellCardControlUtil.this.mSelectWay)).payFlagType, SellCardControlUtil.this.mICBCIndex);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SellCardControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    public void getAuthData(final String str) {
        this.mFlowState = FlowState.startauth;
        V3BusinessControllers.getInstance().getSellCardAuthData(this.mAccount, this.mInvestorId, this.mSchoolId, str, str.substring(2, 10), this.mUserInfo.studentId, new Listener<AppointmentBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SellCardControlUtil.this.mActivity, "授权中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppointmentBean appointmentBean, Object... objArr) {
                if (SellCardControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SellCardControlUtil.this.mFlowState = FlowState.authend;
                    SellCardControlUtil.this.mAuthData = appointmentBean.communicationWord;
                    LogUtil.e(SellCardControlUtil.TAG, "授权成功：" + SellCardControlUtil.this.mAuthData + "  " + SellCardControlUtil.this.mConnectState);
                    if (StringUtils.isNotEmpty(SellCardControlUtil.this.mAuthData)) {
                        if (SellCardControlUtil.this.mConnectState == ConnectState.connected) {
                            BaseMaterialDialog.showMaterialDialog(SellCardControlUtil.this.mActivity, "出卡中..", false);
                            SellCardControlUtil sellCardControlUtil = SellCardControlUtil.this;
                            sellCardControlUtil.sendData(sellCardControlUtil.mAuthData);
                        } else if (SellCardControlUtil.this.mConnectState == ConnectState.none || SellCardControlUtil.this.mConnectState == ConnectState.connectfail) {
                            BaseMaterialDialog.showMaterialDialog(SellCardControlUtil.this.mActivity, "正在连接设备蓝牙.", false);
                            SellCardControlUtil.this.connectDecice(str);
                        } else {
                            BaseMaterialDialog.showMaterialDialog(SellCardControlUtil.this.mActivity, "正在连接设备蓝牙..", false);
                        }
                    } else {
                        SellCardControlUtil.this.showDialog(false, false, false, "授权异常，请联系管理员" + LocalDataUtil.getTraceID(SellCardControlUtil.this.mActivity));
                    }
                    if (SellCardControlUtil.this.mOnListener != null) {
                        SellCardControlUtil.this.mOnListener.onAuth();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SellCardControlUtil.this.mIsEnable) {
                    LogUtil.e(SellCardControlUtil.TAG, "getAuthData");
                    if (SellCardControlUtil.this.mOnListener != null) {
                        SellCardControlUtil.this.mOnListener.onAuth();
                    }
                    SellCardControlUtil.this.mFlowState = FlowState.authfail;
                    SellCardControlUtil.this.onError(clientException, false);
                }
            }
        });
    }

    public void initBluetooth() {
        BluetoothControlUtil.getInstance().setDeviceType(this.mDeviceVer);
        BluetoothControlUtil.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.6
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.e(SellCardControlUtil.TAG, "onConnected:" + SellCardControlUtil.this.mIsEnable + "  " + SellCardControlUtil.this.mFlowState);
                if (SellCardControlUtil.this.mIsEnable) {
                    SellCardControlUtil.this.mConnectState = ConnectState.connected;
                    if (SellCardControlUtil.this.mFlowState == FlowState.authend) {
                        SellCardControlUtil sellCardControlUtil = SellCardControlUtil.this;
                        sellCardControlUtil.sendData(sellCardControlUtil.mAuthData);
                        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (!BaseMaterialDialog.isShowMaterialDialog()) {
                                    BaseMaterialDialog.showMaterialDialog(SellCardControlUtil.this.mActivity, "正在出卡中....", false);
                                } else {
                                    BaseMaterialDialog.setConnectMaterialDialog("正在出卡中...");
                                }
                            }
                        });
                        return;
                    } else if (SellCardControlUtil.this.mFlowState != FlowState.authfail) {
                        SellCardControlUtil.this.sendData("AA");
                        return;
                    } else {
                        SellCardControlUtil.this.disconnect();
                        return;
                    }
                }
                SellCardControlUtil.this.disconnect();
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.e(SellCardControlUtil.TAG, "onFail" + i + "  " + str + "  " + SellCardControlUtil.this.mFlowState + "  " + SellCardControlUtil.this.mConnectState);
                if (SellCardControlUtil.this.mIsEnable) {
                    if (SellCardControlUtil.this.mFlowState == FlowState.authend && SellCardControlUtil.this.mConnectState != ConnectState.senddataend) {
                        SellCardControlUtil.this.onError(i, str, false);
                    }
                    SellCardControlUtil.this.mConnectState = ConnectState.connectfail;
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.e(SellCardControlUtil.TAG, "onReceivedData:" + str);
                if (SellCardControlUtil.this.mIsEnable && str.equalsIgnoreCase("AA")) {
                    ToastUtils.show(SellCardControlUtil.this.mActivity, "出卡成功，请取走卡片");
                    SellCardControlUtil.this.mConnectState = ConnectState.senddataend;
                    SellCardControlUtil.this.disconnect();
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseMaterialDialog.dissmisMaterialDialog();
                        }
                    });
                }
            }
        });
    }

    public void connectDecice(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() < 52) {
            return;
        }
        this.mConnectState = ConnectState.connecting;
        String mac = QrcodeUtil.getMac(str.substring(40, 52));
        this.mBluetoothDevice = new BluetoothDevice(mac, mac, 0);
        BluetoothControlUtil.getInstance().connectBluetooth(this.mBluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendData(String str) {
        LogUtil.e(TAG, "sendData:" + str);
        BluetoothControlUtil.getInstance().setSendTimeOut(3000);
        BluetoothControlUtil.getInstance().sendData(str);
    }

    public void disconnect() {
        LogUtil.e(TAG, "断开蓝牙连接");
        LogUtil.log("断开蓝牙连接");
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void showDialog(final boolean z, final boolean z2, final boolean z3, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.7
            @Override // java.lang.Runnable
            public void run() {
                BaseMaterialDialog.dissmisMaterialDialog();
                if (SellCardControlUtil.this.mOnListener != null) {
                    SellCardControlUtil.this.mOnListener.onError(-1);
                }
                String str2 = str;
                if (z2) {
                    str2 = str + "\n(" + LocalDataUtil.getTraceID(SellCardControlUtil.this.mActivity) + ")";
                }
                String str3 = str2;
                boolean z4 = z;
                if (z4 && !z3) {
                    SystemErrorTip.getInstance().showTipDialog(SellCardControlUtil.this.mActivity, "", str3, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.7.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            SellCardControlUtil.this.mActivity.finish();
                        }
                    });
                } else if (!z4 || !z3) {
                    SystemErrorTip.getInstance().showTipDialog(SellCardControlUtil.this.mActivity, str3);
                } else {
                    SystemErrorTip.getInstance().showTipDialog(SellCardControlUtil.this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.7.2
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            SellCardControlUtil.this.mActivity.finish();
                        }
                    }, str3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(final ClientException clientException, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.8
            @Override // java.lang.Runnable
            public void run() {
                BaseMaterialDialog.dissmisMaterialDialog();
                if (SellCardControlUtil.this.mOnListener != null) {
                    SellCardControlUtil.this.mOnListener.onError(clientException.getCode());
                }
                ClientException clientException2 = clientException;
                if (clientException2.isNeedTip(clientException2.getCode())) {
                    SellCardControlUtil.this.showDialog(z, false, false, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(SellCardControlUtil.this.mActivity) + ")");
                    return;
                }
                V3ErrorTipActivity.launch(SellCardControlUtil.this.mActivity, SellCardControlUtil.this.mTitleContent, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
                if (z) {
                    SellCardControlUtil.this.mActivity.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(final int i, final String str, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.9
            @Override // java.lang.Runnable
            public void run() {
                BaseMaterialDialog.dissmisMaterialDialog();
                V3ErrorTipActivity.launchBluetoothFail(SellCardControlUtil.this.mActivity, SellCardControlUtil.this.mTitleContent, str, i);
                if (z) {
                    SellCardControlUtil.this.mActivity.finish();
                }
            }
        });
    }
}

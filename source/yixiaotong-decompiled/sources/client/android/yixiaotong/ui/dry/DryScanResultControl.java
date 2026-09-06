package client.android.yixiaotong.ui.dry;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.wash.WashAuthorizeBean;
import client.android.yixiaotong.controller.bean.wash.WashHistoryOrderBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.qrcodeutil.QrcodeDataUtil;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DryScanResultControl {
    private Account mAccount;
    private Activity mActivity;
    private String mData;
    private String mDeviceNo;
    private boolean mIsEnable;
    private boolean mIsManager;
    private String mMac;
    private String mOrderID;
    private String mScanResult;
    private String mSystemData;
    private String mSystemTime;
    private WalletModel mWalletModel;
    private int mPay = 0;
    private int mFunctionType = 0;
    private boolean mIsConnected = false;
    private boolean mIsShouquaned = false;
    private boolean mIsUpdateInfoed = false;
    private boolean mIsFirstConnect = true;
    private SystemErrorTip.SystemErrorDialogListener systemErrorDialogListener = new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.dry.DryScanResultControl.5
        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
        public void onConfirm() {
            BluetoothSDK.getInstance().closeBLE();
            DryScanResultControl.this.mActivity.finish();
        }
    };

    public void onResume() {
        this.mIsEnable = true;
    }

    public void init(Activity activity, Account account, WalletModel walletModel, String str, String str2) {
        this.mActivity = activity;
        this.mAccount = account;
        this.mWalletModel = walletModel;
        this.mScanResult = str;
        if (StringUtils.isNotEmpty(str2)) {
            String[] strArrSplit = str2.split(",");
            if (strArrSplit.length == 2) {
                this.mOrderID = strArrSplit[0];
                this.mPay = Integer.parseInt(strArrSplit[1]);
            }
        }
        Log.e("teet", "dada:" + str2 + "  " + this.mOrderID);
        if (AppAccountManager.getInstance().getAppManagerAccount(this.mWalletModel.typeId) == this.mWalletModel.typeId) {
            this.mIsManager = true;
        } else {
            this.mIsManager = false;
        }
        initSW();
        BluetoothSDK.getInstance().closeBLE();
        checkCode();
    }

    public void onPause() {
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    public void onDestroy() {
        this.mIsEnable = false;
        BluetoothSDK.getInstance().setListener(null);
        SystemErrorTip.getInstance().dismiss(this.mActivity);
    }

    private void initSW() {
        SWCommandUtil.getInstance().initDataManage();
        SWCommandUtil.getInstance().setDataListener(new SoundWaveDataListener() { // from class: client.android.yixiaotong.ui.dry.DryScanResultControl.1
            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onGetQrcodeData(String str) {
            }

            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onQrcodeData(String str, String str2, int i) {
                DryScanResultControl.this.mDeviceNo = str;
                DryScanResultControl.this.mData = str2;
                DryScanResultControl.this.soundwaveCardUpdateInfo(str, str2);
            }
        });
    }

    private void checkCode() {
        if (this.mScanResult.contains("?")) {
            String[] strArrSplit = this.mScanResult.split("\\?");
            if (strArrSplit.length > 1) {
                this.mScanResult = strArrSplit[1];
            }
        }
        if (StringUtils.isNotEmpty(this.mScanResult) && this.mScanResult.length() >= 52 && QrcodeDataUtil.qrcodeFormat(this.mScanResult.substring(0, 52))) {
            String strSubstring = this.mScanResult.substring(40, 52);
            StringBuilder sb = new StringBuilder();
            sb.append(strSubstring);
            for (int i = 1; i <= 5; i++) {
                sb.insert(((i * 2) + i) - 1, x.bQ);
            }
            this.mMac = sb.toString();
            BluetoothDevice bluetoothDevice = new BluetoothDevice("test", sb.toString());
            BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.dry.DryScanResultControl.2
                @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
                public void onStart(BluetoothDevice bluetoothDevice2) {
                }

                @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
                public void onFail(final BluetoothDevice bluetoothDevice2, TimeOut timeOut, String str) {
                    if (DryScanResultControl.this.mIsEnable) {
                        DryScanResultControl.this.mIsConnected = false;
                        if (DryScanResultControl.this.mIsFirstConnect) {
                            DryScanResultControl.this.mIsFirstConnect = false;
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.dry.DryScanResultControl.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    BluetoothSDK.getInstance().ConnectManagerDevice(bluetoothDevice2);
                                }
                            }, 1500L);
                        } else if (StringUtils.isNotEmpty(str)) {
                            ErrorUtil.onFailBlueTooth(DryScanResultControl.this.mActivity, DryScanResultControl.this.mWalletModel.name, str, 204, true);
                        } else {
                            SystemErrorTip.getInstance().showTipDialog(DryScanResultControl.this.mActivity, DryScanResultControl.this.systemErrorDialogListener, "连接设备超时," + timeOut);
                        }
                    }
                }

                @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
                public void onBluetoothException(ClientException clientException) {
                    if (DryScanResultControl.this.mIsEnable) {
                        SystemErrorTip.getInstance().showTipDialog(DryScanResultControl.this.mActivity, DryScanResultControl.this.systemErrorDialogListener, "请打开手机蓝牙");
                    }
                }

                @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
                public void onSuccessConnect(BluetoothDevice bluetoothDevice2) {
                    if (DryScanResultControl.this.mIsEnable) {
                        BluetoothSDK.getInstance().SendDataManagerDevice("AA");
                        DryScanResultControl.this.mIsConnected = true;
                        if (!DryScanResultControl.this.mIsShouquaned || !StringUtils.isNotEmpty(DryScanResultControl.this.mOrderID)) {
                            if (DryScanResultControl.this.mIsUpdateInfoed && StringUtils.isEmpty(DryScanResultControl.this.mOrderID)) {
                                BaseMaterialDialog.dissmisMaterialDialog();
                                DrySelectOperateActivity.launch(DryScanResultControl.this.mActivity, DryScanResultControl.this.mWalletModel, DryScanResultControl.this.mMac, DryScanResultControl.this.mDeviceNo, DryScanResultControl.this.mData, DryScanResultControl.this.mIsConnected);
                                DryScanResultControl.this.mActivity.finish();
                                return;
                            }
                            return;
                        }
                        BaseMaterialDialog.dissmisMaterialDialog();
                        DryingActivity.launch(DryScanResultControl.this.mActivity, DryScanResultControl.this.mWalletModel, DryScanResultControl.this.mSystemTime, DryScanResultControl.this.mSystemData, DryScanResultControl.this.mOrderID, DryScanResultControl.this.mPay, DryScanResultControl.this.mFunctionType + "", "");
                        DryScanResultControl.this.mActivity.finish();
                    }
                }
            });
            BluetoothSDK.getInstance().ConnectManagerDevice(bluetoothDevice);
            SWCommandUtil.getInstance().sendQrcodeData(this.mScanResult.substring(0, 40), 40);
            return;
        }
        ToastUtils.show(this.mActivity, "不合法的设备码");
        this.mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthorize(String str, String str2) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().WashAuthorize(this.mAccount, this.mOrderID, "0", str, str2, this.mWalletModel.typeId + "", this.mPay + "", "1", randNumMaxStringNonO, "1", new Listener<WashAuthorizeBean>() { // from class: client.android.yixiaotong.ui.dry.DryScanResultControl.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (DryScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.setConnectMaterialDialog("正在授权中,请稍候...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashAuthorizeBean washAuthorizeBean, Object... objArr) {
                if (DryScanResultControl.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(washAuthorizeBean.systemData) && StringUtils.isNotEmpty(washAuthorizeBean.systemTime) && StringUtils.isNotEmpty(washAuthorizeBean.rand) && washAuthorizeBean.rand.equals(randNumMaxStringNonO)) {
                        DryScanResultControl.this.mIsShouquaned = true;
                        DryScanResultControl.this.mSystemTime = washAuthorizeBean.systemTime;
                        DryScanResultControl.this.mSystemData = washAuthorizeBean.systemData;
                        if (DryScanResultControl.this.mIsConnected) {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            DryingActivity.launch(DryScanResultControl.this.mActivity, DryScanResultControl.this.mWalletModel, washAuthorizeBean.systemTime, washAuthorizeBean.systemData, DryScanResultControl.this.mOrderID, DryScanResultControl.this.mPay, DryScanResultControl.this.mFunctionType + "", "");
                            DryScanResultControl.this.mActivity.finish();
                            return;
                        }
                        BaseMaterialDialog.setConnectMaterialDialog("正在连接设备中...");
                        return;
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SystemErrorTip.getInstance().showTipDialog(DryScanResultControl.this.mActivity, DryScanResultControl.this.systemErrorDialogListener, "数据出错");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DryScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorUtil.onFailResult(DryScanResultControl.this.mActivity, DryScanResultControl.this.mWalletModel.name, clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void soundwaveCardUpdateInfo(final String str, final String str2) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        Log.e("test", "orderid:" + this.mOrderID);
        BusinessControllers.getInstance().SoundWaveWashUpdateInfo(this.mAccount, this.mWalletModel.typeId, str, str2, 1, randNumMaxStringNonO, false, new Listener<WashHistoryOrderBean>() { // from class: client.android.yixiaotong.ui.dry.DryScanResultControl.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (DryScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.showMaterialDialog(DryScanResultControl.this.mActivity, "在匹配洗衣机...", false);
                    if (StringUtils.isEmpty(DryScanResultControl.this.mOrderID)) {
                        BaseMaterialDialog.setConnectMaterialDialog("二维码扫描成功，正在处理中...");
                    } else {
                        BaseMaterialDialog.setConnectMaterialDialog("二维码扫描成功，正在查询当前订单的状态...");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashHistoryOrderBean washHistoryOrderBean, Object... objArr) {
                if (DryScanResultControl.this.mIsEnable) {
                    DryScanResultControl.this.mIsUpdateInfoed = true;
                    if (!StringUtils.isNotEmpty(DryScanResultControl.this.mOrderID) || !StringUtils.isNotEmpty(washHistoryOrderBean.before_orderid) || !DryScanResultControl.this.mOrderID.equals(washHistoryOrderBean.before_orderid) || !washHistoryOrderBean.rand.equals(randNumMaxStringNonO)) {
                        if (StringUtils.isNotEmpty(DryScanResultControl.this.mOrderID)) {
                            DryScanResultControl dryScanResultControl = DryScanResultControl.this;
                            dryScanResultControl.getAuthorize(dryScanResultControl.mDeviceNo, DryScanResultControl.this.mData);
                            return;
                        } else if (DryScanResultControl.this.mIsConnected) {
                            DrySelectOperateActivity.launch(DryScanResultControl.this.mActivity, DryScanResultControl.this.mWalletModel, DryScanResultControl.this.mMac, str, str2, DryScanResultControl.this.mIsConnected);
                            DryScanResultControl.this.mActivity.finish();
                            return;
                        } else {
                            BaseMaterialDialog.setConnectMaterialDialog("正在连接设备中...");
                            return;
                        }
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SystemErrorTip.getInstance().showTipDialog(DryScanResultControl.this.mActivity, DryScanResultControl.this.systemErrorDialogListener, "当前订单已完成！");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DryScanResultControl.this.mIsEnable) {
                    if (clientException.getCode() == 4072) {
                        DryScanResultControl.this.mIsUpdateInfoed = true;
                        if (StringUtils.isNotEmpty(DryScanResultControl.this.mOrderID)) {
                            DryScanResultControl dryScanResultControl = DryScanResultControl.this;
                            dryScanResultControl.getAuthorize(dryScanResultControl.mDeviceNo, DryScanResultControl.this.mData);
                            return;
                        } else if (DryScanResultControl.this.mIsConnected) {
                            DrySelectOperateActivity.launch(DryScanResultControl.this.mActivity, DryScanResultControl.this.mWalletModel, DryScanResultControl.this.mMac, str, str2, DryScanResultControl.this.mIsConnected);
                            DryScanResultControl.this.mActivity.finish();
                            return;
                        } else {
                            BaseMaterialDialog.setConnectMaterialDialog("正在连接设备中...");
                            return;
                        }
                    }
                    ErrorUtil.onFailResult(DryScanResultControl.this.mActivity, DryScanResultControl.this.mWalletModel.name, clientException, true);
                }
            }
        });
    }
}

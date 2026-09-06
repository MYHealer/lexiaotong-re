package client.android.yixiaotong.ui.sellcard;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.sellcard.SellCardAuthorizeBean;
import client.android.yixiaotong.controller.bean.wash.WashHistoryOrderBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.qrcodeutil.QrcodeDataUtil;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SellCardScanResultControl {
    private Account mAccount;
    private Activity mActivity;
    private int mConnectCount;
    private boolean mIsEnable;
    private String mLanYaSendData;
    private String mMac;
    private String mMoney;
    private String mOrderID;
    private String mScanResult;
    private WalletModel mWalletModel;
    private SystemErrorTip.SystemErrorDialogListener systemErrorDialogListener = new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardScanResultControl.5
        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
        public void onConfirm() {
            SellCardScanResultControl.this.mActivity.finish();
        }
    };

    public void onResume() {
        this.mIsEnable = true;
    }

    static /* synthetic */ int access$508(SellCardScanResultControl sellCardScanResultControl) {
        int i = sellCardScanResultControl.mConnectCount;
        sellCardScanResultControl.mConnectCount = i + 1;
        return i;
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
                this.mMoney = strArrSplit[1];
            }
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
        if (StringUtils.isNotEmpty(this.mOrderID)) {
            BluetoothSDK.getInstance().setListener(null);
            BluetoothSDK.getInstance().closeBLE();
        }
        SystemErrorTip.getInstance().dismiss(this.mActivity);
    }

    private void initSW() {
        SWCommandUtil.getInstance().initDataManage();
        SWCommandUtil.getInstance().setDataListener(new SoundWaveDataListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardScanResultControl.1
            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onQrcodeData(String str, String str2, int i) {
                Log.e("test", str + "  " + str2 + "  " + i);
                SellCardScanResultControl.this.soundwaveCardUpdateInfo(str, str2);
            }

            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onGetQrcodeData(String str) {
                SellCardScanResultControl.this.mLanYaSendData = str;
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
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotEmpty(this.mScanResult) && this.mScanResult.length() >= 52) {
            if (QrcodeDataUtil.qrcodeFormat(this.mScanResult.substring(0, 52))) {
                sb.append(this.mScanResult.substring(40, 52));
                for (int i = 1; i <= 5; i++) {
                    sb.insert(((i * 2) + i) - 1, x.bQ);
                }
                this.mMac = sb.toString();
                SWCommandUtil.getInstance().sendQrcodeData(this.mScanResult.substring(0, 40), 40);
                return;
            }
            ToastUtils.show(this.mActivity, "不合法的设备码");
            this.mActivity.finish();
            return;
        }
        ToastUtils.show(this.mActivity, "不合法的设备码");
        this.mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLanYa() {
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardScanResultControl.2
            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onStart(BluetoothDevice bluetoothDevice) {
                Log.e("test", "onstart");
                if (BaseMaterialDialog.isShowMaterialDialog()) {
                    BaseMaterialDialog.setConnectMaterialDialog("正在连接设备中..");
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onBluetoothException(ClientException clientException) {
                if (SellCardScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SystemErrorTip.getInstance().showTipDialog(SellCardScanResultControl.this.mActivity, SellCardScanResultControl.this.systemErrorDialogListener, clientException.getDetail());
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                Log.e("test", "onFail  " + timeOut);
                if (SellCardScanResultControl.this.mIsEnable) {
                    SellCardScanResultControl.access$508(SellCardScanResultControl.this);
                    if (SellCardScanResultControl.this.mConnectCount > 1) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        SystemErrorTip.getInstance().showTipDialog(SellCardScanResultControl.this.mActivity, SellCardScanResultControl.this.systemErrorDialogListener, "连接设备失败");
                    } else {
                        Log.e("test", "onFail");
                        BluetoothSDK.getInstance().closeBLE();
                        BluetoothSDK.getInstance().ConnectManagerDevice(new BluetoothDevice("", SellCardScanResultControl.this.mMac));
                    }
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.sellcard.SellCardScanResultControl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        if (StringUtils.isNotEmpty(SellCardScanResultControl.this.mLanYaSendData)) {
                            BluetoothSDK.getInstance().SendDataManagerDevice(SellCardScanResultControl.this.mLanYaSendData);
                        }
                    }
                }, 200L);
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessSendData(BluetoothDevice bluetoothDevice, String str) {
                Log.e("test", "onSuccessSendData:" + str);
                BaseMaterialDialog.dissmisMaterialDialog();
                SystemErrorTip.getInstance().showTipDialog(SellCardScanResultControl.this.mActivity, SellCardScanResultControl.this.systemErrorDialogListener, "不要忘记拿卡哦~");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCardSalesAuth(String str, String str2) {
        String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        if (StringUtils.isNotEmpty(this.mMoney)) {
            BusinessControllers.getInstance().getCardSalesAuth(this.mAccount, 0, str, this.mWalletModel.typeId, 0, randNumMaxStringNonO, 1, this.mOrderID, str2, Integer.parseInt(this.mMoney), new Listener<SellCardAuthorizeBean>() { // from class: client.android.yixiaotong.ui.sellcard.SellCardScanResultControl.3
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    if (BaseMaterialDialog.isShowMaterialDialog()) {
                        BaseMaterialDialog.setConnectMaterialDialog("正在授权中..");
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SellCardAuthorizeBean sellCardAuthorizeBean, Object... objArr) {
                    if (SellCardScanResultControl.this.mIsEnable) {
                        if (sellCardAuthorizeBean != null && StringUtils.isNotEmpty(sellCardAuthorizeBean.systemData) && StringUtils.isNotEmpty(sellCardAuthorizeBean.systemTime)) {
                            SWCommandUtil.getInstance().sendGetQrcodeData(sellCardAuthorizeBean.systemData, sellCardAuthorizeBean.systemTime);
                            SellCardScanResultControl.this.initLanYa();
                            BluetoothSDK.getInstance().ConnectManagerDevice(new BluetoothDevice("", SellCardScanResultControl.this.mMac));
                        } else {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            SystemErrorTip.getInstance().showTipDialog(SellCardScanResultControl.this.mActivity, SellCardScanResultControl.this.systemErrorDialogListener, "授权数据出错");
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                    if (SellCardScanResultControl.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ErrorUtil.onFailResult(SellCardScanResultControl.this.mActivity, SellCardScanResultControl.this.mWalletModel.name, clientException, true);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void soundwaveCardUpdateInfo(final String str, final String str2) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().getUpdateMacForSalesCard(this.mAccount, this.mWalletModel.typeId, str, str2, 1, randNumMaxStringNonO, new Listener<WashHistoryOrderBean>() { // from class: client.android.yixiaotong.ui.sellcard.SellCardScanResultControl.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SellCardScanResultControl.this.mActivity, "二维码扫描状态", false);
                if (!StringUtils.isNotEmpty(SellCardScanResultControl.this.mOrderID)) {
                    BaseMaterialDialog.setConnectMaterialDialog("二维码扫描成功，正在处理中...");
                } else {
                    BaseMaterialDialog.setConnectMaterialDialog("二维码扫描成功，正在查询当前订单的状态...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashHistoryOrderBean washHistoryOrderBean, Object... objArr) {
                if (SellCardScanResultControl.this.mIsEnable) {
                    if (!StringUtils.isNotEmpty(SellCardScanResultControl.this.mOrderID) || !StringUtils.isNotEmpty(washHistoryOrderBean.before_orderid) || !SellCardScanResultControl.this.mOrderID.equals(washHistoryOrderBean.before_orderid)) {
                        if (StringUtils.isNotEmpty(SellCardScanResultControl.this.mOrderID)) {
                            SellCardScanResultControl.this.getCardSalesAuth(str, str2);
                            return;
                        }
                        BaseMaterialDialog.dissmisMaterialDialog();
                        SellCardActivity.launch(SellCardScanResultControl.this.mActivity, SellCardScanResultControl.this.mWalletModel, SellCardScanResultControl.this.mMac, str, str2);
                        SellCardScanResultControl.this.mActivity.finish();
                        return;
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (washHistoryOrderBean.rand.equals(randNumMaxStringNonO)) {
                        SystemErrorTip.getInstance().showTipDialog(SellCardScanResultControl.this.mActivity, SellCardScanResultControl.this.systemErrorDialogListener, "当前订单已完成！");
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(SellCardScanResultControl.this.mActivity, SellCardScanResultControl.this.systemErrorDialogListener, "数据出错");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (SellCardScanResultControl.this.mIsEnable) {
                    if (clientException.getCode() == 4072) {
                        if (StringUtils.isNotEmpty(SellCardScanResultControl.this.mOrderID)) {
                            SellCardScanResultControl.this.getCardSalesAuth(str, str2);
                            return;
                        } else {
                            SellCardActivity.launch(SellCardScanResultControl.this.mActivity, SellCardScanResultControl.this.mWalletModel, SellCardScanResultControl.this.mMac, str, str2);
                            SellCardScanResultControl.this.mActivity.finish();
                            return;
                        }
                    }
                    ErrorUtil.onFailResult(SellCardScanResultControl.this.mActivity, SellCardScanResultControl.this.mWalletModel.name, clientException, true);
                }
            }
        });
    }
}

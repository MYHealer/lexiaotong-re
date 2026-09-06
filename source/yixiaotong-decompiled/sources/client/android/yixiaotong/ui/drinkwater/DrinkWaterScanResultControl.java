package client.android.yixiaotong.ui.drinkwater;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SoundWaveBean;
import client.android.yixiaotong.controller.bean.SoundWaveOrderBean;
import client.android.yixiaotong.controller.bean.SoundWaveOrderRecordBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.ui.dialog.AppTipDialog;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.OrderIdUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.util.qrcodeutil.QrcodeDataUtil;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.openalliance.ad.constant.x;
import java.math.BigDecimal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DrinkWaterScanResultControl {
    private static final String TAG = "DrinkWaterScanResultControl";
    private static final String TYPE_BLUE_CONNECT_AGAIN = "type_blue_connect_again";
    private static final String TYPE_CLICK_DATA = "type_click_data";
    private static final String TYPE_IS_BLUE_CONNECT = "type_is_blue_connect";
    private Account mAccount;
    private Activity mActivity;
    private boolean mIsEnable;
    private String mOrderID;
    private String mScanResult;
    private String mSystemData;
    private String mSystemTime;
    private WalletModel mWalletModel;
    private int willpay;
    private boolean isAuthor = false;
    private int mConnectCount = 0;
    private boolean mIsNeedCloseBLE = true;
    private long lastApplyOrder = 0;
    private boolean mEnableOrder = true;
    private SystemErrorTip.SystemErrorDialogListener systemErrorDialogListener = new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl.6
        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
        public void onConfirm() {
            DrinkWaterScanResultControl.this.mActivity.finish();
        }
    };
    private AppTipDialog.TipDialogListener tipDialogListener = new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl.7
        @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
        public void onConfirt() {
            DrinkWaterScanResultControl.this.mIsNeedCloseBLE = false;
            DrinkWaterRecordActivity.launch(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.this.mWalletModel, DrinkWaterScanResultControl.this.mScanResult.substring(2, 10));
            DrinkWaterScanResultControl.this.mActivity.finish();
        }

        @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
        public void onCanle() {
            DrinkWaterScanResultControl.this.mActivity.finish();
        }
    };

    public void init(Activity activity, Account account, WalletModel walletModel, String str, String str2) {
        this.mActivity = activity;
        this.mAccount = account;
        this.mWalletModel = walletModel;
        this.mScanResult = str;
        this.mOrderID = str2;
        this.willpay = (int) new BigDecimal(Float.toString(PreferenceUtil.getFloat(activity, TYPE_CLICK_DATA + this.mAccount.getUid(), 0.0f))).multiply(new BigDecimal(Float.toString(100.0f))).floatValue();
        initBluetooth();
        checkCode();
    }

    public void onResume() {
        this.mIsEnable = true;
        this.mIsNeedCloseBLE = true;
        BluetoothControlUtil.getInstance().onResume();
    }

    public void onPause() {
        BluetoothControlUtil.getInstance().onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().dismiss(this.mActivity);
    }

    public void onDestroy() {
        this.mIsEnable = false;
        if (this.mIsNeedCloseBLE) {
            disconnect();
        }
    }

    private void checkCode() {
        if (this.mScanResult.contains("?")) {
            String[] strArrSplit = this.mScanResult.split("\\?");
            if (strArrSplit.length > 1) {
                this.mScanResult = strArrSplit[1];
            }
        }
        if (!this.mScanResult.isEmpty() && this.mScanResult.length() >= 52) {
            Log.e("test", this.mScanResult.length() + "  " + this.mScanResult);
            if (QrcodeDataUtil.qrcodeFormat(this.mScanResult.substring(0, 52))) {
                String strSubstring = this.mScanResult.substring(40, 52);
                StringBuilder sb = new StringBuilder();
                sb.append(strSubstring);
                for (int i = 1; i <= 5; i++) {
                    sb.insert(((i * 2) + i) - 1, x.bQ);
                }
                connectDecice(sb.toString());
                SWCommandUtil.getInstance().initDataManage();
                SWCommandUtil.getInstance().setDataListener(new SoundWaveDataListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl.1
                    @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
                    public void onGetQrcodeData(String str) {
                    }

                    @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
                    public void onQrcodeData(String str, String str2, int i2) {
                        LogUtil.e("TAG", str + "  " + str2 + "  " + i2);
                        if (StringUtils.isEmpty(DrinkWaterScanResultControl.this.mOrderID)) {
                            DrinkWaterScanResultControl drinkWaterScanResultControl = DrinkWaterScanResultControl.this;
                            drinkWaterScanResultControl.updateOrderFromServer(str, str2, drinkWaterScanResultControl.mScanResult);
                        } else {
                            DrinkWaterScanResultControl drinkWaterScanResultControl2 = DrinkWaterScanResultControl.this;
                            drinkWaterScanResultControl2.authorizeFromServer(str, str2, drinkWaterScanResultControl2.mOrderID, DrinkWaterScanResultControl.this.mScanResult);
                        }
                    }
                });
                SWCommandUtil.getInstance().sendQrcodeData(this.mScanResult.substring(0, 40), this.mScanResult.substring(0, 40).length());
                return;
            }
            showDialogForScan("不合法的设备码");
            return;
        }
        showDialogForScan("不合法的设备码！");
    }

    private void initEvent() {
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl.2
            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onStart(BluetoothDevice bluetoothDevice) {
                super.onStart(bluetoothDevice);
                PreferenceUtil.putIsBlueConnectAgain(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.TYPE_BLUE_CONNECT_AGAIN, false);
                PreferenceUtil.putIsBlueConnect(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.TYPE_IS_BLUE_CONNECT, false);
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onBluetoothException(ClientException clientException) {
                super.onBluetoothException(clientException);
                if (DrinkWaterScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    BluetoothSDK.getInstance().closeBLE();
                    DrinkWaterScanResultControl.this.showDialogForScan("请打开手机蓝牙");
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onFail(final BluetoothDevice bluetoothDevice, TimeOut timeOut, final String str) {
                super.onFail(bluetoothDevice, timeOut, str);
                Log.e(DrinkWaterScanResultControl.TAG, "onFail:" + timeOut + "  " + str);
                if (DrinkWaterScanResultControl.this.mIsEnable) {
                    new Thread(new Runnable() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                DrinkWaterScanResultControl.this.mConnectCount++;
                                BluetoothSDK.getInstance().closeBLE();
                                if (DrinkWaterScanResultControl.this.mConnectCount <= 1 && !DrinkWaterScanResultControl.this.mScanResult.substring(40, 46).equalsIgnoreCase("000E0B")) {
                                    Thread.sleep(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                                    BluetoothSDK.getInstance().ConnectManagerDevice(bluetoothDevice);
                                } else {
                                    BaseMaterialDialog.dissmisMaterialDialog();
                                    if (str != null) {
                                        ErrorUtil.onFailBlueTooth(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.this.mWalletModel.name, str, 204, true);
                                    } else {
                                        ToastUtils.show(DrinkWaterScanResultControl.this.mActivity, "连接设备失败");
                                        DrinkWaterScanResultControl.this.mActivity.finish();
                                    }
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
                super.onSuccessConnect(bluetoothDevice);
                if (DrinkWaterScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    PreferenceUtil.putIsBlueConnect(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.TYPE_IS_BLUE_CONNECT, true);
                    BluetoothSDK.getInstance().SendDataManagerDevice("AA");
                    if (DrinkWaterScanResultControl.this.isAuthor) {
                        DrinkWaterScanResultControl.this.mIsNeedCloseBLE = false;
                        DrinkWaterActivity.launch(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.this.mWalletModel, DrinkWaterScanResultControl.this.mSystemData, DrinkWaterScanResultControl.this.mSystemTime, DrinkWaterScanResultControl.this.mScanResult);
                        DrinkWaterScanResultControl.this.mActivity.finish();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authorizeFromServer(String str, String str2, String str3, final String str4) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().soundWaveWater(this.mAccount, str3, 0, str, str2, this.mWalletModel.typeId, 0, 0, this.mWalletModel.ID, this.willpay, randNumMaxStringNonO, new Listener<SoundWaveBean>() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                LocalBusinessStore.saveOrderMoney(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.this.mWalletModel.typeId, DrinkWaterScanResultControl.this.willpay + "");
                BaseMaterialDialog.showMaterialDialog(DrinkWaterScanResultControl.this.mActivity, "正在授权中...", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SoundWaveBean soundWaveBean, Object... objArr) {
                if (DrinkWaterScanResultControl.this.mIsEnable) {
                    DrinkWaterScanResultControl.this.mSystemData = soundWaveBean.systemData;
                    DrinkWaterScanResultControl.this.mSystemTime = soundWaveBean.systemTime;
                    boolean isBlueConnect = PreferenceUtil.getIsBlueConnect(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.TYPE_IS_BLUE_CONNECT, false);
                    boolean isBlueConnectAgain = PreferenceUtil.getIsBlueConnectAgain(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.TYPE_BLUE_CONNECT_AGAIN, false);
                    DrinkWaterScanResultControl.this.isAuthor = true;
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (!soundWaveBean.rand.equals(randNumMaxStringNonO)) {
                        SystemErrorTip.getInstance().showTipDialog(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.this.systemErrorDialogListener, "数据校验出错！");
                        return;
                    }
                    if (isBlueConnect || isBlueConnectAgain) {
                        DrinkWaterScanResultControl.this.mIsNeedCloseBLE = false;
                        DrinkWaterActivity.launch(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.this.mWalletModel, DrinkWaterScanResultControl.this.mSystemData, DrinkWaterScanResultControl.this.mSystemTime, str4);
                        DrinkWaterScanResultControl.this.mActivity.finish();
                        return;
                    }
                    BaseMaterialDialog.showMaterialDialog(DrinkWaterScanResultControl.this.mActivity, "正在连接设备中，请稍候", false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DrinkWaterScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    DrinkWaterScanResultControl.this.showUnFinishOederDialog(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOrderFromServer(final String str, final String str2, final String str3) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().soundWaveWaterOrderRecord(this.mAccount, this.mWalletModel.typeId, 0, str, str2, 1, randNumMaxStringNonO, new Listener<SoundWaveOrderRecordBean>() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DrinkWaterScanResultControl.this.mActivity, "正在提交订单，请稍候", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SoundWaveOrderRecordBean soundWaveOrderRecordBean, Object... objArr) {
                if (DrinkWaterScanResultControl.this.mIsEnable) {
                    if (!StringUtils.isNotEmpty(DrinkWaterScanResultControl.this.mOrderID) || !StringUtils.isNotEmpty(soundWaveOrderRecordBean.before_orderid) || !DrinkWaterScanResultControl.this.mOrderID.equals(soundWaveOrderRecordBean.before_orderid) || !soundWaveOrderRecordBean.rand.equals(randNumMaxStringNonO)) {
                        if (!StringUtils.isEmpty(DrinkWaterScanResultControl.this.mOrderID) || !soundWaveOrderRecordBean.rand.equals(randNumMaxStringNonO)) {
                            SystemErrorTip.getInstance().showTipDialog(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.this.systemErrorDialogListener, "数据异常！");
                            return;
                        } else {
                            DrinkWaterScanResultControl.this.applyOrderFromServer(str, str2, str3);
                            return;
                        }
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SystemErrorTip.getInstance().showTipDialog(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.this.systemErrorDialogListener, "当前订单已完成！");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DrinkWaterScanResultControl.this.mIsEnable) {
                    if (clientException.getCode() == 4072) {
                        DrinkWaterScanResultControl.this.applyOrderFromServer(str, str2, str3);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        DrinkWaterScanResultControl.this.showUnFinishOederDialog(clientException);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyOrderFromServer(final String str, final String str2, final String str3) {
        if (this.mEnableOrder) {
            this.mEnableOrder = false;
            if (StringUtils.isEmpty(this.mOrderID)) {
                String localDate = OrderIdUtils.getLocalDate("yyyyMMddHHmmss");
                if (System.currentTimeMillis() - this.lastApplyOrder <= 1000) {
                    return;
                }
                this.lastApplyOrder = System.currentTimeMillis();
                BusinessControllers.getInstance().soundWaveWaterOrder(this.mAccount, 1, OrderIdUtils.getWaterOrderID(this.mWalletModel.typeId), this.mWalletModel.typeId, localDate, this.mWalletModel.ID, 1, this.willpay, str3.substring(2, 10), new Listener<SoundWaveOrderBean>() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl.5
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        BaseMaterialDialog.setConnectMaterialDialog("正在下单中...");
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, SoundWaveOrderBean soundWaveOrderBean, Object... objArr) {
                        if (DrinkWaterScanResultControl.this.mIsEnable) {
                            DrinkWaterScanResultControl.this.mEnableOrder = true;
                            DrinkWaterScanResultControl.this.mOrderID = soundWaveOrderBean.orderId;
                            DrinkWaterScanResultControl drinkWaterScanResultControl = DrinkWaterScanResultControl.this;
                            drinkWaterScanResultControl.authorizeFromServer(str, str2, drinkWaterScanResultControl.mOrderID, str3);
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                        if (DrinkWaterScanResultControl.this.mIsEnable) {
                            DrinkWaterScanResultControl.this.mEnableOrder = true;
                            BaseMaterialDialog.dissmisMaterialDialog();
                            DrinkWaterScanResultControl.this.showUnFinishOederDialog(clientException);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUnFinishOederDialog(client.android.yixiaotong.exception.ClientException clientException) {
        if (clientException.getCode() == 4060) {
            new AppTipDialog().showTipDialog(this.mActivity, this.tipDialogListener, clientException.getDetail(), "取消", "去消费账单");
        } else if (clientException.getCode() == 4007) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, this.systemErrorDialogListener, "当前订单已完成！");
        } else {
            ErrorUtil.onFailResult(this.mActivity, this.mWalletModel.name, clientException, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogForScan(String str) {
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, this.systemErrorDialogListener, str);
    }

    private void connectDecice(String str) {
        com.lxt.bluetoothsdk.BluetoothSDK.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().setDeviceType("00,03");
        BluetoothControlUtil.getInstance().connectBluetooth(new com.lxt.bluetoothsdk.model.BluetoothDevice(str, str, 0));
    }

    private void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendData(String str) {
        BluetoothControlUtil.getInstance().setSendTimeOut(10000);
        BluetoothControlUtil.getInstance().sendData(str);
    }

    public void initBluetooth() {
        PreferenceUtil.putIsBlueConnectAgain(this.mActivity, TYPE_BLUE_CONNECT_AGAIN, false);
        PreferenceUtil.putIsBlueConnect(this.mActivity, TYPE_IS_BLUE_CONNECT, false);
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterScanResultControl.8
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                Log.e(DrinkWaterScanResultControl.TAG, "onConnected");
                if (DrinkWaterScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    PreferenceUtil.putIsBlueConnect(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.TYPE_IS_BLUE_CONNECT, true);
                    DrinkWaterScanResultControl.this.sendData("AA");
                    if (DrinkWaterScanResultControl.this.isAuthor) {
                        DrinkWaterScanResultControl.this.mIsNeedCloseBLE = false;
                        DrinkWaterActivity.launch(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.this.mWalletModel, DrinkWaterScanResultControl.this.mSystemData, DrinkWaterScanResultControl.this.mSystemTime, DrinkWaterScanResultControl.this.mScanResult);
                        DrinkWaterScanResultControl.this.mActivity.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                Log.e(DrinkWaterScanResultControl.TAG, "onFail" + i + "  " + str + "  " + DrinkWaterScanResultControl.this.mIsEnable);
                if (DrinkWaterScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (str != null) {
                        ErrorUtil.onFailBlueTooth(DrinkWaterScanResultControl.this.mActivity, DrinkWaterScanResultControl.this.mWalletModel.name, str, 204, true);
                    } else {
                        ToastUtils.show(DrinkWaterScanResultControl.this.mActivity, "连接设备失败");
                        DrinkWaterScanResultControl.this.mActivity.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                Log.e(DrinkWaterScanResultControl.TAG, "onReceivedData:" + str);
            }
        });
    }
}

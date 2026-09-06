package client.android.yixiaotong.sdk.runnable.ble;

import android.text.TextUtils;
import android.util.Log;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapperTwo;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.MoneyBackListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.executor.AsyncQueueExecutor;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import client.android.yixiaotong.util.TimeUtils;
import com.unionpay.tsmservice.data.Constant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MoneyBackRunnableV2 {
    private boolean isNetworkStatus;
    private short mBalance;
    private BluetoothDevice mCurrentHardware;
    private String mDeviceHexNo;
    private boolean mHasOffineRecord = false;
    private boolean mIsGetRecording = false;
    private MoneyBackListener mMoneyBackListener;
    private long mStudentNo;

    public void setOpenListener(MoneyBackListener moneyBackListener) {
        this.mMoneyBackListener = moneyBackListener;
    }

    public MoneyBackRunnableV2(BluetoothDevice bluetoothDevice, long j, short s) {
        this.mCurrentHardware = bluetoothDevice;
        this.mStudentNo = j;
        this.mBalance = s;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV2.1
            @Override // java.lang.Runnable
            public void run() {
                if (MoneyBackRunnableV2.this.mMoneyBackListener != null) {
                    MoneyBackRunnableV2.this.mMoneyBackListener.onStart(bluetoothDevice);
                }
            }
        });
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV2.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MoneyBackRunnableV2.this.mMoneyBackListener != null) {
                        MoneyBackRunnableV2.this.mMoneyBackListener.onSuccess(bluetoothDevice, z);
                    }
                } finally {
                    MoneyBackRunnableV2.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV2.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MoneyBackRunnableV2.this.mMoneyBackListener != null) {
                        MoneyBackRunnableV2.this.mMoneyBackListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    MoneyBackRunnableV2.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV2.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MoneyBackRunnableV2.this.mMoneyBackListener != null) {
                        MoneyBackRunnableV2.this.mMoneyBackListener.onBluetoothException(clientException);
                    }
                } finally {
                    MoneyBackRunnableV2.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean callNeedUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean) {
        try {
            MoneyBackListener moneyBackListener = this.mMoneyBackListener;
            if (moneyBackListener != null) {
                return moneyBackListener.needUploadOrder(bluetoothDevice, orderBean);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void callOnSuccessGetOfflineData(final BluetoothDevice bluetoothDevice, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV2.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MoneyBackRunnableV2.this.mMoneyBackListener != null) {
                        MoneyBackRunnableV2.this.mMoneyBackListener.onSuccessGetOffineData(bluetoothDevice, z);
                    }
                } finally {
                    MoneyBackRunnableV2.this.stopAndRelease();
                }
            }
        });
    }

    private String onf1(BluetoothDevice bluetoothDevice) {
        try {
            MoneyBackListener moneyBackListener = this.mMoneyBackListener;
            return moneyBackListener != null ? moneyBackListener.onf1(bluetoothDevice, this.mDeviceHexNo) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private void sendConnectData() {
        String str = new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
        boolean z = this.isNetworkStatus;
        if (z) {
            BluetoothManager.getInstance().sendData(TimeOut.SendConnect, 3000, CommandUtilsWrapperTwo.getOnlineConnectCommandTwo(this.mStudentNo, str, false, z));
        } else {
            callOnFail(this.mCurrentHardware, null, "不允许脱网使用");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConfirmData() {
        if (this.isNetworkStatus) {
            BluetoothManager.getInstance().sendData(TimeOut.SendConfirm, 3000, onf1(this.mCurrentHardware));
        } else {
            callOnFail(this.mCurrentHardware, null, "不允许脱网使用");
        }
    }

    private void sendAbortData() {
        BluetoothManager.getInstance().sendData(TimeOut.SendAbort, 3000, CommandUtilsWrapper.getAbortCommand());
    }

    private void sendConnectOffineRecordData(String str) {
        if (this.isNetworkStatus) {
            this.mIsGetRecording = true;
            BluetoothManager.getInstance().sendData(TimeOut.SendConnect, 3000, CommandUtilsWrapperTwo.getOnlineConnectCommandTwo(this.mStudentNo, str, true, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCollectOfflineConfirmData() {
        if (this.isNetworkStatus) {
            BluetoothManager.getInstance().sendData(TimeOut.SendConnect, 3000, CommandUtilsWrapperTwo.getOfflineDataCollectCommandTwo(this.mStudentNo, this.mBalance, this.mDeviceHexNo));
        }
    }

    public void receivedData(String str) {
        String str2;
        byte[] bArrHexToBuffer = HexString.hexToBuffer(str);
        if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer)) {
            if (CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer)) {
                String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer);
                if (!TextUtils.isEmpty(returnSettingDeviceIdResult) && returnSettingDeviceIdResult.startsWith("0212")) {
                    this.isNetworkStatus = true;
                    sendConnectData();
                } else {
                    callOnFail(this.mCurrentHardware, null, "终止消费失败");
                }
            } else {
                callOnFail(this.mCurrentHardware, null, "终止消费失败");
            }
        }
        if (CommandUtilsWrapper.isConnectResult(bArrHexToBuffer)) {
            short connectResultStatus = CommandUtilsWrapper.getConnectResultStatus(bArrHexToBuffer);
            if (connectResultStatus == 0) {
                if (this.isNetworkStatus) {
                    this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                    long connectResultUserId = CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer);
                    short sMax = (short) Math.max(0, (int) CommandUtilsWrapper.getConnectResultBalance(bArrHexToBuffer));
                    String connectResultTime = CommandUtilsWrapper.getConnectResultTime(bArrHexToBuffer);
                    short returnSettingResulttemperature = CommandUtilsWrapper.getReturnSettingResulttemperature();
                    try {
                        str2 = String.valueOf(Calendar.getInstance().get(1)) + new SimpleDateFormat("-MM-dd HH:mm:ss").format(new SimpleDateFormat("MMddHHmmss").parse(connectResultTime));
                    } catch (ParseException unused) {
                        str2 = new SimpleDateFormat(TimeUtils.FORMATDATETIME).format(new Date());
                    }
                    int posNumber = (!this.mIsGetRecording || CommandUtilsWrapperTwo.getMachineDataLength(bArrHexToBuffer) < 29) ? 0 : CommandUtilsWrapperTwo.getPosNumber(bArrHexToBuffer);
                    final OrderBean orderBean = new OrderBean();
                    orderBean.studentNo = connectResultUserId;
                    orderBean.money = sMax;
                    orderBean.time = str2;
                    orderBean.temperature = returnSettingResulttemperature;
                    orderBean.offineTimes = posNumber;
                    AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV2.6
                        @Override // java.lang.Runnable
                        public void run() {
                            MoneyBackRunnableV2 moneyBackRunnableV2 = MoneyBackRunnableV2.this;
                            if (moneyBackRunnableV2.callNeedUploadOrder(moneyBackRunnableV2.mCurrentHardware, orderBean)) {
                                if (!MoneyBackRunnableV2.this.mIsGetRecording) {
                                    MoneyBackRunnableV2.this.sendConfirmData();
                                    return;
                                } else {
                                    MoneyBackRunnableV2.this.sendCollectOfflineConfirmData();
                                    return;
                                }
                            }
                            MoneyBackRunnableV2 moneyBackRunnableV3 = MoneyBackRunnableV2.this;
                            moneyBackRunnableV3.callOnFail(moneyBackRunnableV3.mCurrentHardware, null, "不允许脱网使用");
                        }
                    });
                    Log.e("test00", (CommandUtilsWrapperTwo.isoffineRecordState(bArrHexToBuffer) == 1) + "");
                    if (CommandUtilsWrapperTwo.isoffineRecordState(bArrHexToBuffer) == 1) {
                        this.mHasOffineRecord = true;
                        return;
                    }
                    return;
                }
                this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                return;
            }
            if (connectResultStatus == 1) {
                callOnFail(this.mCurrentHardware, null, "连接失败");
                return;
            }
            if (connectResultStatus == 2) {
                if (this.isNetworkStatus) {
                    this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                    sendConfirmData();
                    Log.e("test02", (CommandUtilsWrapperTwo.isoffineRecordState(bArrHexToBuffer) == 1) + "");
                    if (CommandUtilsWrapperTwo.isoffineRecordState(bArrHexToBuffer) == 1) {
                        this.mHasOffineRecord = true;
                        return;
                    }
                    return;
                }
                callOnFail(this.mCurrentHardware, null, "余额不足");
                return;
            }
            if (connectResultStatus != 15) {
                if (connectResultStatus == 13) {
                    callOnFail(this.mCurrentHardware, null, "没有绑定，不能进行脱机消费");
                    return;
                } else {
                    callOnFail(this.mCurrentHardware, null, "连接失败");
                    return;
                }
            }
            String hexString = Long.toHexString(CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer));
            String hexString2 = Long.toHexString(this.mStudentNo);
            if (hexString.length() > 6) {
                hexString = hexString.substring(5);
            }
            if (hexString2.length() > 6) {
                hexString2 = hexString2.substring(5);
            }
            if (hexString.equals(hexString2)) {
                sendAbortData();
                return;
            } else {
                callOnFail(this.mCurrentHardware, null, "设备正忙,无法使用");
                return;
            }
        }
        if (CommandUtilsWrapper.isConfirmResult(bArrHexToBuffer)) {
            short confirmResultStatus = CommandUtilsWrapper.getConfirmResultStatus(bArrHexToBuffer);
            if (confirmResultStatus == 0) {
                callOnSuccess(this.mCurrentHardware, this.isNetworkStatus);
                if (this.mHasOffineRecord && !this.mIsGetRecording && this.isNetworkStatus) {
                    sendConnectOffineRecordData(Constant.DEFAULT_BALANCE);
                    return;
                }
                return;
            }
            if (confirmResultStatus == 1) {
                callOnFail(this.mCurrentHardware, null, "连接失败,确认订单上传失败");
                return;
            }
            if (confirmResultStatus == 2) {
                if (!this.mHasOffineRecord || this.mIsGetRecording) {
                    callOnFail(this.mCurrentHardware, null, "连接失败,余额不足");
                    return;
                } else {
                    if (this.isNetworkStatus) {
                        sendConnectOffineRecordData(Constant.DEFAULT_BALANCE);
                        return;
                    }
                    return;
                }
            }
            if (confirmResultStatus == 3) {
                callOnSuccess(this.mCurrentHardware, this.isNetworkStatus);
                if (this.mHasOffineRecord && !this.mIsGetRecording && this.isNetworkStatus) {
                    sendConnectOffineRecordData(Constant.DEFAULT_BALANCE);
                    return;
                }
                return;
            }
            if (confirmResultStatus == 5) {
                if (this.mIsGetRecording) {
                    sendConnectOffineRecordData(Constant.DEFAULT_BALANCE);
                    return;
                } else {
                    sendConnectData();
                    return;
                }
            }
            if (confirmResultStatus == 13) {
                callOnFail(this.mCurrentHardware, null, "空间不足,不允许脱网消费");
                return;
            }
            if (confirmResultStatus == 14) {
                callOnFail(this.mCurrentHardware, null, "写存储器失败");
                return;
            } else if (confirmResultStatus == 15) {
                callOnFail(this.mCurrentHardware, null, "设备正忙,无法使用");
                return;
            } else {
                callOnFail(this.mCurrentHardware, null, "连接失败,确认订单上传失败");
                return;
            }
        }
        if (CommandUtilsWrapper.isAbortResult(bArrHexToBuffer)) {
            if (CommandUtilsWrapper.getAbortResultStatus(bArrHexToBuffer)) {
                sendConnectData();
                return;
            } else {
                callOnFail(this.mCurrentHardware, null, "连接失败,请重启设备");
                return;
            }
        }
        if (CommandUtilsWrapperTwo.isConfirmOfflineResult(bArrHexToBuffer)) {
            this.mHasOffineRecord = false;
            callOnSuccessGetOfflineData(this.mCurrentHardware, this.isNetworkStatus);
        } else if (CommandUtilsWrapperTwo.isBindDeviceResult(bArrHexToBuffer)) {
            callOnFail(this.mCurrentHardware, null, "该账号未绑定设备,不能脱机使用");
        }
    }
}

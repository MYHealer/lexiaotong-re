package client.android.yixiaotong.sdk.runnable.ble;

import android.text.TextUtils;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.MoneyBackListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.executor.AsyncQueueExecutor;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import client.android.yixiaotong.util.TimeUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MoneyBackRunnableV1 {
    private boolean isNetworkStatus;
    private short mBalance;
    private BluetoothDevice mCurrentHardware;
    private String mDeviceHexNo;
    private MoneyBackListener mMoneyBackListener;
    private long mStudentNo;

    public void setOpenListener(MoneyBackListener moneyBackListener) {
        this.mMoneyBackListener = moneyBackListener;
    }

    public MoneyBackRunnableV1(BluetoothDevice bluetoothDevice, long j, short s) {
        this.mCurrentHardware = bluetoothDevice;
        this.mStudentNo = j;
        this.mBalance = s;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV1.1
            @Override // java.lang.Runnable
            public void run() {
                if (MoneyBackRunnableV1.this.mMoneyBackListener != null) {
                    MoneyBackRunnableV1.this.mMoneyBackListener.onStart(bluetoothDevice);
                }
            }
        });
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV1.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MoneyBackRunnableV1.this.mMoneyBackListener != null) {
                        MoneyBackRunnableV1.this.mMoneyBackListener.onSuccess(bluetoothDevice, z);
                    }
                } finally {
                    MoneyBackRunnableV1.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV1.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MoneyBackRunnableV1.this.mMoneyBackListener != null) {
                        MoneyBackRunnableV1.this.mMoneyBackListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    MoneyBackRunnableV1.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV1.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MoneyBackRunnableV1.this.mMoneyBackListener != null) {
                        MoneyBackRunnableV1.this.mMoneyBackListener.onBluetoothException(clientException);
                    }
                } finally {
                    MoneyBackRunnableV1.this.stopAndRelease();
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

    private void sendConnectData() {
        String str = new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
        if (this.isNetworkStatus) {
            BluetoothManager.getInstance().sendData(TimeOut.SendConnect, 10000, CommandUtilsWrapper.getOnlineConnectCommand(this.mStudentNo, str));
        } else {
            callOnFail(this.mCurrentHardware, null, "不允许脱网使用");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConfirmData() {
        if (this.isNetworkStatus) {
            BluetoothManager.getInstance().sendData(TimeOut.SendConfirm, 3000, CommandUtilsWrapper.getOnlineConfirmCommand(this.mStudentNo, this.mBalance, this.mDeviceHexNo));
        } else {
            callOnFail(this.mCurrentHardware, null, "不允许脱网使用");
        }
    }

    private void sendAbortData() {
        BluetoothManager.getInstance().sendData(TimeOut.SendAbort, 3000, CommandUtilsWrapper.getAbortCommand());
    }

    public void receivedData(String str) {
        String str2;
        byte[] bArrHexToBuffer = HexString.hexToBuffer(str);
        if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer)) {
            if (CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer)) {
                String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer);
                if (!TextUtils.isEmpty(returnSettingDeviceIdResult) && returnSettingDeviceIdResult.startsWith("0212")) {
                    sendConnectData();
                    return;
                } else {
                    callOnFail(this.mCurrentHardware, null, "终止消费失败");
                    return;
                }
            }
            callOnFail(this.mCurrentHardware, null, "终止消费失败");
            return;
        }
        if (CommandUtilsWrapper.isConnectResult(bArrHexToBuffer)) {
            short connectResultStatus = CommandUtilsWrapper.getConnectResultStatus(bArrHexToBuffer);
            if (connectResultStatus == 0) {
                if (this.isNetworkStatus) {
                    this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                    long connectResultUserId = CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer);
                    short sMax = (short) Math.max(0, (int) CommandUtilsWrapper.getConnectResultBalance(bArrHexToBuffer));
                    try {
                        str2 = String.valueOf(Calendar.getInstance().get(1)) + new SimpleDateFormat("-MM-dd HH:mm:ss").format(new SimpleDateFormat("MMddHHmmss").parse(CommandUtilsWrapper.getConnectResultTime(bArrHexToBuffer)));
                    } catch (ParseException unused) {
                        str2 = new SimpleDateFormat(TimeUtils.FORMATDATETIME).format(new Date());
                    }
                    final OrderBean orderBean = new OrderBean();
                    orderBean.studentNo = connectResultUserId;
                    orderBean.money = sMax;
                    orderBean.time = str2;
                    AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnableV1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            MoneyBackRunnableV1 moneyBackRunnableV1 = MoneyBackRunnableV1.this;
                            if (moneyBackRunnableV1.callNeedUploadOrder(moneyBackRunnableV1.mCurrentHardware, orderBean)) {
                                MoneyBackRunnableV1.this.sendConfirmData();
                            } else {
                                MoneyBackRunnableV1 moneyBackRunnableV2 = MoneyBackRunnableV1.this;
                                moneyBackRunnableV2.callOnFail(moneyBackRunnableV2.mCurrentHardware, null, "不允许脱网使用");
                            }
                        }
                    });
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
                    return;
                } else {
                    callOnFail(this.mCurrentHardware, null, "余额不足");
                    return;
                }
            }
            if (connectResultStatus == 15) {
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
            callOnFail(this.mCurrentHardware, null, "连接失败");
            return;
        }
        if (CommandUtilsWrapper.isConfirmResult(bArrHexToBuffer)) {
            short confirmResultStatus = CommandUtilsWrapper.getConfirmResultStatus(bArrHexToBuffer);
            if (confirmResultStatus == 0) {
                callOnSuccess(this.mCurrentHardware, this.isNetworkStatus);
                return;
            }
            if (confirmResultStatus == 1) {
                callOnFail(this.mCurrentHardware, null, "连接失败,确认订单上传失败");
                return;
            }
            if (confirmResultStatus == 2) {
                callOnFail(this.mCurrentHardware, null, "连接失败,余额不足");
                return;
            }
            if (confirmResultStatus == 3) {
                callOnSuccess(this.mCurrentHardware, this.isNetworkStatus);
                return;
            }
            if (confirmResultStatus == 5) {
                sendConnectData();
                return;
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
            } else {
                callOnFail(this.mCurrentHardware, null, "连接失败,请重启设备");
            }
        }
    }
}

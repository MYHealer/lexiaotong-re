package client.android.yixiaotong.sdk.runnable.ble;

import android.util.Log;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapperTwo;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.CloseListener;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.executor.AsyncQueueExecutor;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import client.android.yixiaotong.util.TimeUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CloseRunnableV2 {
    private boolean isNetworkStatus;
    private short mBalance;
    private CloseListener mCloseListener;
    private BluetoothDevice mCurrentHardware;
    private String mDeviceHexNo;
    private boolean mIsBind;
    private long mStudentNo;

    public void setCloseListener(CloseListener closeListener) {
        this.mCloseListener = closeListener;
    }

    public CloseRunnableV2(BluetoothDevice bluetoothDevice, long j, short s, boolean z, boolean z2) {
        this.mCurrentHardware = bluetoothDevice;
        this.mStudentNo = j;
        this.mBalance = s;
        this.isNetworkStatus = z;
        this.mIsBind = z2;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV2.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseRunnableV2.this.mCloseListener != null) {
                        CloseRunnableV2.this.mCloseListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    CloseRunnableV2.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV2.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseRunnableV2.this.mCloseListener != null) {
                        CloseRunnableV2.this.mCloseListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    CloseRunnableV2.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callNeedUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean, String str) {
        try {
            CloseListener closeListener = this.mCloseListener;
            if (closeListener != null) {
                closeListener.needUploadOrder(bluetoothDevice, orderBean, str);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String callOnCloseDate(BluetoothDevice bluetoothDevice) {
        try {
            CloseListener closeListener = this.mCloseListener;
            return closeListener != null ? closeListener.onCloseDate(bluetoothDevice) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private String onf1(BluetoothDevice bluetoothDevice) {
        try {
            CloseListener closeListener = this.mCloseListener;
            return closeListener != null ? closeListener.onf1(bluetoothDevice, this.mDeviceHexNo) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConnectData(String str) {
        boolean z = this.isNetworkStatus;
        if (!z) {
            BluetoothManager.getInstance().sendData(TimeOut.SendCloseConnect, 10000, CommandUtilsWrapperTwo.getOfflineConnectCommandTwo(this.mStudentNo, str));
        } else if (this.mIsBind) {
            BluetoothManager.getInstance().sendData(TimeOut.SendCloseConnect, 10000, CommandUtilsWrapperTwo.getOnlineConnectCommandTwo(this.mStudentNo, str, true, z));
        } else {
            BluetoothManager.getInstance().sendData(TimeOut.SendCloseConnect, 10000, CommandUtilsWrapperTwo.getOnlineConnectCommandTwo(this.mStudentNo, str, false, z));
        }
    }

    private void sendConfirmData() {
        if (this.isNetworkStatus) {
            BluetoothManager.getInstance().sendData(TimeOut.SendCloseConfirm, 5000, onf1(this.mCurrentHardware));
        } else {
            if (this.mBalance > 10000) {
                this.mBalance = (short) 10000;
            }
            BluetoothManager.getInstance().sendData(TimeOut.SendCloseConfirm, 5000, CommandUtilsWrapperTwo.getOfflineConfirmCommandTwo(this.mStudentNo, this.mBalance, this.mDeviceHexNo));
        }
    }

    private void sendAbortData() {
        BluetoothManager.getInstance().sendData(TimeOut.SendCloseAbort, 3000, CommandUtilsWrapper.getAbortCommand());
    }

    public void uploadOrder(boolean z) {
        if (z) {
            sendConfirmData();
        } else {
            callOnSuccess(this.mCurrentHardware);
        }
    }

    private String getOrderTime(String str) {
        String strValueOf;
        if (!StringUtils.isNotEmpty(str) || str.length() != 10) {
            strValueOf = null;
        } else if (Integer.parseInt(str.substring(0, 2)) > Calendar.getInstance().get(2) + 1) {
            strValueOf = String.valueOf(Calendar.getInstance().get(1) - 1);
        } else {
            strValueOf = String.valueOf(Calendar.getInstance().get(1));
        }
        try {
            return strValueOf + new SimpleDateFormat("-MM-dd HH:mm:ss").format(new SimpleDateFormat("MMddHHmmss").parse(str));
        } catch (ParseException unused) {
            return new SimpleDateFormat(TimeUtils.FORMATDATETIME).format(new Date());
        }
    }

    public void receivedData(final String str) {
        byte[] bArrHexToBuffer = HexString.hexToBuffer(str);
        if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer)) {
            if (CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer)) {
                CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer);
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        CloseRunnableV2 closeRunnableV2 = CloseRunnableV2.this;
                        String strCallOnCloseDate = closeRunnableV2.callOnCloseDate(closeRunnableV2.mCurrentHardware);
                        if (StringUtils.isNotEmpty(strCallOnCloseDate)) {
                            CloseRunnableV2.this.sendConnectData(strCallOnCloseDate);
                        }
                    }
                });
                return;
            }
            return;
        }
        if (CommandUtilsWrapper.isConnectResult(bArrHexToBuffer)) {
            short connectResultStatus = CommandUtilsWrapper.getConnectResultStatus(bArrHexToBuffer);
            if (connectResultStatus == 0) {
                if (this.isNetworkStatus) {
                    this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                    long connectResultUserId = CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer);
                    short sMax = (short) Math.max(0, (int) CommandUtilsWrapper.getConnectResultBalance(bArrHexToBuffer));
                    String orderTime = getOrderTime(CommandUtilsWrapper.getConnectResultTime(bArrHexToBuffer));
                    final OrderBean orderBean = new OrderBean();
                    orderBean.studentNo = connectResultUserId;
                    orderBean.money = sMax;
                    orderBean.time = orderTime;
                    AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            CloseRunnableV2 closeRunnableV2 = CloseRunnableV2.this;
                            closeRunnableV2.callNeedUploadOrder(closeRunnableV2.mCurrentHardware, orderBean, str.substring(22, 30));
                        }
                    });
                    return;
                }
                callOnSuccess(this.mCurrentHardware);
                this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                Log.e("test", this.mDeviceHexNo + "  " + CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer));
                return;
            }
            if (connectResultStatus != 15) {
                if (connectResultStatus == 1) {
                    callOnFail(this.mCurrentHardware, null, "关阀失败");
                    return;
                } else {
                    callOnSuccess(this.mCurrentHardware);
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
            CommandUtilsWrapper.getConfirmResultStatus(bArrHexToBuffer);
            callOnSuccess(this.mCurrentHardware);
        } else if (CommandUtilsWrapper.isAbortResult(bArrHexToBuffer)) {
            if (!CommandUtilsWrapper.getAbortResultStatus(bArrHexToBuffer)) {
                callOnFail(this.mCurrentHardware, null, "终止消费失败");
            } else if (this.isNetworkStatus) {
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        CloseRunnableV2 closeRunnableV2 = CloseRunnableV2.this;
                        String strCallOnCloseDate = closeRunnableV2.callOnCloseDate(closeRunnableV2.mCurrentHardware);
                        if (StringUtils.isNotEmpty(strCallOnCloseDate)) {
                            CloseRunnableV2.this.sendConnectData(strCallOnCloseDate);
                        }
                    }
                });
            } else {
                callOnSuccess(this.mCurrentHardware);
            }
        }
    }
}

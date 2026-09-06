package client.android.yixiaotong.sdk.runnable.ble;

import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
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
public class CloseRunnableV1 {
    private boolean isNetworkStatus;
    private short mBalance;
    private CloseListener mCloseListener;
    private BluetoothDevice mCurrentHardware;
    private String mDeviceHexNo;
    private long mStudentNo;

    public void setCloseListener(CloseListener closeListener) {
        this.mCloseListener = closeListener;
    }

    public CloseRunnableV1(BluetoothDevice bluetoothDevice, long j, short s, boolean z) {
        this.mCurrentHardware = bluetoothDevice;
        this.mStudentNo = j;
        this.mBalance = s;
        this.isNetworkStatus = z;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV1.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseRunnableV1.this.mCloseListener != null) {
                        CloseRunnableV1.this.mCloseListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    CloseRunnableV1.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV1.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseRunnableV1.this.mCloseListener != null) {
                        CloseRunnableV1.this.mCloseListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    CloseRunnableV1.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean callNeedUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean) {
        try {
            CloseListener closeListener = this.mCloseListener;
            if (closeListener != null) {
                return closeListener.needUploadOrder(bluetoothDevice, orderBean);
            }
            return false;
        } catch (Exception unused) {
            return false;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConnectData(String str) {
        BluetoothManager.getInstance().sendData(TimeOut.SendCloseConnect, 10000, CommandUtilsWrapper.getOnlineConnectCommand(this.mStudentNo, str));
    }

    private void sendConfirmData() {
        if (this.mBalance > 10000) {
            this.mBalance = (short) 10000;
        }
        BluetoothManager.getInstance().sendData(TimeOut.SendCloseConfirm, 3000, CommandUtilsWrapper.getOnlineConfirmCommand(this.mStudentNo, this.mBalance, this.mDeviceHexNo));
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

    public void receivedData(String str) {
        byte[] bArrHexToBuffer = HexString.hexToBuffer(str);
        if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer)) {
            if (CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer)) {
                CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer);
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        CloseRunnableV1 closeRunnableV1 = CloseRunnableV1.this;
                        String strCallOnCloseDate = closeRunnableV1.callOnCloseDate(closeRunnableV1.mCurrentHardware);
                        if (StringUtils.isNotEmpty(strCallOnCloseDate)) {
                            CloseRunnableV1.this.sendConnectData(strCallOnCloseDate);
                        }
                    }
                });
                return;
            } else {
                callOnFail(this.mCurrentHardware, null, "终止消费失败");
                return;
            }
        }
        if (CommandUtilsWrapper.isConnectResult(bArrHexToBuffer)) {
            short connectResultStatus = CommandUtilsWrapper.getConnectResultStatus(bArrHexToBuffer);
            if (connectResultStatus == 0) {
                this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                long connectResultUserId = CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer);
                short sMax = (short) Math.max(0, (int) CommandUtilsWrapper.getConnectResultBalance(bArrHexToBuffer));
                String orderTime = getOrderTime(CommandUtilsWrapper.getConnectResultTime(bArrHexToBuffer));
                final OrderBean orderBean = new OrderBean();
                orderBean.studentNo = connectResultUserId;
                orderBean.money = sMax;
                orderBean.time = orderTime;
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        CloseRunnableV1 closeRunnableV1 = CloseRunnableV1.this;
                        closeRunnableV1.callNeedUploadOrder(closeRunnableV1.mCurrentHardware, orderBean);
                    }
                });
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
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        CloseRunnableV1 closeRunnableV1 = CloseRunnableV1.this;
                        String strCallOnCloseDate = closeRunnableV1.callOnCloseDate(closeRunnableV1.mCurrentHardware);
                        if (StringUtils.isNotEmpty(strCallOnCloseDate)) {
                            CloseRunnableV1.this.sendConnectData(strCallOnCloseDate);
                        }
                    }
                });
            } else {
                callOnSuccess(this.mCurrentHardware);
            }
        }
    }
}

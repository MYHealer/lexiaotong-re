package client.android.yixiaotong.sdk.runnable.ble;

import android.content.Context;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.LocalBusinessStore;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.executor.AsyncQueueExecutor;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import client.android.yixiaotong.util.TimeUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class OpenRunnableV1 {
    private boolean isNetworkStatus;
    private short mBalance;
    private Context mContext;
    private BluetoothDevice mCurrentHardware;
    private String mDeviceHexNo;
    private OpenListener mOpenListener;
    private long mStudentNo;

    public void setOpenListener(OpenListener openListener) {
        this.mOpenListener = openListener;
    }

    public OpenRunnableV1(Context context, BluetoothDevice bluetoothDevice, long j, short s, boolean z) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
        this.mStudentNo = j;
        this.mBalance = s;
        this.isNetworkStatus = z;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV1.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnableV1.this.mOpenListener != null) {
                        OpenRunnableV1.this.mOpenListener.onSuccess(bluetoothDevice, z);
                    }
                } finally {
                    OpenRunnableV1.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV1.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnableV1.this.mOpenListener != null) {
                        OpenRunnableV1.this.mOpenListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    OpenRunnableV1.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean callNeedUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean) {
        try {
            OpenListener openListener = this.mOpenListener;
            if (openListener != null) {
                return openListener.needUploadOrder(bluetoothDevice, orderBean);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private short callBalance(BluetoothDevice bluetoothDevice) {
        try {
            OpenListener openListener = this.mOpenListener;
            if (openListener != null) {
                return openListener.callBalance(bluetoothDevice);
            }
            return (short) 0;
        } catch (Exception unused) {
            return (short) 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String callOnOpenDate(BluetoothDevice bluetoothDevice) {
        try {
            OpenListener openListener = this.mOpenListener;
            return openListener != null ? openListener.onOpenDate(bluetoothDevice) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private int callOnConsumptionTimes(BluetoothDevice bluetoothDevice) {
        try {
            OpenListener openListener = this.mOpenListener;
            if (openListener != null) {
                return openListener.callConsumptionTime(bluetoothDevice);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConnectData(String str) {
        if (this.isNetworkStatus) {
            BluetoothManager.getInstance().sendData(TimeOut.SendConnect, 8000, CommandUtilsWrapper.getOnlineConnectCommand(this.mStudentNo, str));
        } else {
            BluetoothManager.getInstance().sendData(TimeOut.SendConnect, 8000, CommandUtilsWrapper.getOfflineConnectCommand(this.mStudentNo, str));
        }
    }

    private void sendConfirmData() {
        if (callOnConsumptionTimes(this.mCurrentHardware) > 0) {
            if (this.mBalance > 10000) {
                this.mBalance = (short) 10000;
            }
            if (this.isNetworkStatus) {
                BluetoothManager.getInstance().sendData(TimeOut.SendConfirm, 5000, CommandUtilsWrapper.getOnlineConfirmCommand(this.mStudentNo, this.mBalance, this.mDeviceHexNo));
            } else {
                BluetoothManager.getInstance().sendData(TimeOut.SendConfirm, 5000, CommandUtilsWrapper.getOfflineConfirmCommand(this.mStudentNo, this.mBalance, this.mDeviceHexNo));
            }
        }
    }

    private void sendAbortData() {
        BluetoothManager.getInstance().sendData(TimeOut.SendAbort, 3000, CommandUtilsWrapper.getAbortCommand());
    }

    public void uploadOrder(boolean z) {
        if (z) {
            short sCallBalance = callBalance(this.mCurrentHardware);
            this.mBalance = sCallBalance;
            if (sCallBalance > 0) {
                LocalBusinessStore.saveOfflineCount(this.mContext, this.mStudentNo, 0);
                sendConfirmData();
                return;
            } else {
                callOnFail(this.mCurrentHardware, null, "余额不足");
                return;
            }
        }
        callOnFail(this.mCurrentHardware, null, "不允许脱网使用");
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
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        OpenRunnableV1 openRunnableV1 = OpenRunnableV1.this;
                        String strCallOnOpenDate = openRunnableV1.callOnOpenDate(openRunnableV1.mCurrentHardware);
                        if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                            OpenRunnableV1.this.sendConnectData(strCallOnOpenDate);
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
                    AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            OpenRunnableV1 openRunnableV1 = OpenRunnableV1.this;
                            openRunnableV1.callNeedUploadOrder(openRunnableV1.mCurrentHardware, orderBean);
                        }
                    });
                    return;
                }
                this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                sendConfirmData();
                return;
            }
            if (connectResultStatus == 1) {
                callOnFail(this.mCurrentHardware, null, "连接失败");
                return;
            }
            if (connectResultStatus == 2) {
                if (this.isNetworkStatus) {
                    LocalBusinessStore.saveOfflineCount(this.mContext, this.mStudentNo, 0);
                    this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                    sendConfirmData();
                    return;
                }
                callOnFail(this.mCurrentHardware, null, "余额不足");
                return;
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
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        OpenRunnableV1 openRunnableV1 = OpenRunnableV1.this;
                        String strCallOnOpenDate = openRunnableV1.callOnOpenDate(openRunnableV1.mCurrentHardware);
                        if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                            OpenRunnableV1.this.sendConnectData(strCallOnOpenDate);
                        }
                    }
                });
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
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        OpenRunnableV1 openRunnableV1 = OpenRunnableV1.this;
                        String strCallOnOpenDate = openRunnableV1.callOnOpenDate(openRunnableV1.mCurrentHardware);
                        if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                            OpenRunnableV1.this.sendConnectData(strCallOnOpenDate);
                        }
                    }
                });
            } else {
                callOnFail(this.mCurrentHardware, null, "连接失败,请重启设备");
            }
        }
    }
}

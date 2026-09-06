package client.android.yixiaotong.sdk.runnable.ble;

import android.content.Context;
import android.util.Log;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapperTwo;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
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
public class OpenRunnableV2 {
    private boolean isNetworkStatus;
    private short mBalance;
    private Context mContext;
    private BluetoothDevice mCurrentHardware;
    private String mDeviceHexNo;
    private boolean mIsBind;
    private OpenListener mOpenListener;
    private long mStudentNo;
    private String m_F0SecretKey;
    private boolean mHasOffineRecord = false;
    private int mConsumptionTimes = 0;
    private boolean mIsGetRecording = false;

    public void setOpenListener(OpenListener openListener) {
        this.mOpenListener = openListener;
    }

    public OpenRunnableV2(Context context, BluetoothDevice bluetoothDevice, long j, short s, boolean z, boolean z2) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
        this.mStudentNo = j;
        this.mBalance = s;
        this.isNetworkStatus = z;
        this.mIsBind = z2;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV2.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnableV2.this.mOpenListener != null) {
                        OpenRunnableV2.this.mOpenListener.onSuccess(bluetoothDevice, z);
                    }
                } finally {
                    if (!OpenRunnableV2.this.mHasOffineRecord) {
                        OpenRunnableV2.this.stopAndRelease();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV2.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnableV2.this.mOpenListener != null) {
                        OpenRunnableV2.this.mOpenListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    OpenRunnableV2.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callNeedUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean, String str) {
        try {
            OpenListener openListener = this.mOpenListener;
            if (openListener != null) {
                openListener.needUploadOrder(bluetoothDevice, orderBean, str);
            }
        } catch (Exception unused) {
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

    private String onf1(BluetoothDevice bluetoothDevice, String str) {
        try {
            OpenListener openListener = this.mOpenListener;
            return openListener != null ? openListener.onf1(bluetoothDevice, this.mDeviceHexNo, str) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private void callOnSuccessGetOfflineData(final BluetoothDevice bluetoothDevice, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV2.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnableV2.this.mOpenListener != null) {
                        OpenRunnableV2.this.mOpenListener.onSuccessGetOffineData(bluetoothDevice, z);
                    }
                } finally {
                    OpenRunnableV2.this.stopAndRelease();
                }
            }
        });
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
        boolean z = this.isNetworkStatus;
        if (z) {
            BluetoothManager.getInstance().sendData(TimeOut.SendConnect, 10000, CommandUtilsWrapperTwo.getOnlineConnectCommandTwo(this.mStudentNo, str, this.mIsBind, z));
        } else {
            BluetoothManager.getInstance().sendData(TimeOut.SendConnect, 10000, CommandUtilsWrapperTwo.getOfflineConnectCommandTwo(this.mStudentNo, str));
        }
    }

    private void sendConnectOffineRecordData(String str) {
        if (this.isNetworkStatus) {
            this.mIsGetRecording = true;
            String onlineConnectCommandTwo = CommandUtilsWrapperTwo.getOnlineConnectCommandTwo(this.mStudentNo, str, true, false);
            Log.e("test", "采集脱机数据：" + onlineConnectCommandTwo);
            BluetoothManager.getInstance().sendData(TimeOut.SendOffConnect, 10000, onlineConnectCommandTwo);
        }
    }

    private void sendCollectOfflineConfirmData() {
        if (this.isNetworkStatus) {
            onf1(this.mCurrentHardware, this.m_F0SecretKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConfirmData() {
        if (this.isNetworkStatus) {
            if (callOnConsumptionTimes(this.mCurrentHardware) > 0) {
                onf1(this.mCurrentHardware, this.m_F0SecretKey);
            }
        } else {
            if (this.mBalance > 10000) {
                this.mBalance = (short) 10000;
            }
            BluetoothManager.getInstance().sendData(TimeOut.SendConfirm, 10000, CommandUtilsWrapperTwo.getOfflineConfirmCommandTwo(this.mStudentNo, this.mBalance, this.mDeviceHexNo));
        }
    }

    private void sendAbortData() {
        BluetoothManager.getInstance().sendData(TimeOut.SendAbort, 3000, CommandUtilsWrapper.getAbortCommand());
    }

    public void uploadOrder(boolean z) {
        if (!z) {
            this.isNetworkStatus = false;
            String strCallOnOpenDate = callOnOpenDate(this.mCurrentHardware);
            if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                sendConnectData(strCallOnOpenDate);
                return;
            }
            return;
        }
        if (!this.mIsGetRecording) {
            short sCallBalance = callBalance(this.mCurrentHardware);
            this.mBalance = sCallBalance;
            if (sCallBalance > 0) {
                sendConfirmData();
                return;
            } else {
                callOnFail(this.mCurrentHardware, null, "余额不足");
                return;
            }
        }
        sendCollectOfflineConfirmData();
    }

    public void openForF1(String str) {
        BluetoothManager.getInstance().sendData(TimeOut.SendConfirm, 10000, str);
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

    public void receivedData(final String str, boolean z) {
        this.isNetworkStatus = z;
        final byte[] bArrHexToBuffer = HexString.hexToBuffer(str);
        if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer)) {
            if (CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer)) {
                CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer);
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        OpenRunnableV2 openRunnableV2 = OpenRunnableV2.this;
                        String strCallOnOpenDate = openRunnableV2.callOnOpenDate(openRunnableV2.mCurrentHardware);
                        if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                            OpenRunnableV2.this.sendConnectData(strCallOnOpenDate);
                        }
                    }
                });
                return;
            }
            return;
        }
        int posNumber = 0;
        if (CommandUtilsWrapper.isConnectResult(bArrHexToBuffer)) {
            short connectResultStatus = CommandUtilsWrapper.getConnectResultStatus(bArrHexToBuffer);
            if (str.length() > 30) {
                this.m_F0SecretKey = str.substring(22, 30);
            }
            if (connectResultStatus != 0) {
                if (connectResultStatus == 1) {
                    callOnFail(this.mCurrentHardware, null, "连接失败");
                    return;
                }
                if (connectResultStatus == 2) {
                    AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV2.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (OpenRunnableV2.this.isNetworkStatus) {
                                OpenRunnableV2.this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                                OpenRunnableV2.this.sendConfirmData();
                                if (CommandUtilsWrapperTwo.isoffineRecordState(bArrHexToBuffer) == 1) {
                                    OpenRunnableV2.this.mHasOffineRecord = true;
                                    return;
                                }
                                return;
                            }
                            OpenRunnableV2 openRunnableV2 = OpenRunnableV2.this;
                            openRunnableV2.callOnFail(openRunnableV2.mCurrentHardware, null, "余额不足");
                        }
                    });
                    return;
                }
                if (connectResultStatus == 15) {
                    if (Long.toHexString(CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer)).equals(Long.toHexString(this.mStudentNo))) {
                        sendAbortData();
                        return;
                    } else {
                        callOnFail(this.mCurrentHardware, null, "设备正忙,无法使用");
                        return;
                    }
                }
                if (connectResultStatus == 13) {
                    callOnFail(this.mCurrentHardware, null, "没有绑定，不能进行脱机消费");
                    return;
                } else if (connectResultStatus == 14) {
                    callOnFail(this.mCurrentHardware, null, "该设备已经绑满账号了");
                    return;
                } else {
                    callOnFail(this.mCurrentHardware, null, "连接失败");
                    return;
                }
            }
            if (this.isNetworkStatus) {
                this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
                long connectResultUserId = CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer);
                short sMax = (short) Math.max(0, (int) CommandUtilsWrapper.getConnectResultBalance(bArrHexToBuffer));
                String connectResultTime = CommandUtilsWrapper.getConnectResultTime(bArrHexToBuffer);
                short returnSettingResulttemperature = CommandUtilsWrapper.getReturnSettingResulttemperature();
                String orderTime = getOrderTime(connectResultTime);
                if (this.mIsGetRecording && CommandUtilsWrapperTwo.getMachineDataLength(bArrHexToBuffer) >= 29) {
                    posNumber = CommandUtilsWrapperTwo.getPosNumber(bArrHexToBuffer);
                }
                final OrderBean orderBean = new OrderBean();
                orderBean.studentNo = connectResultUserId;
                orderBean.money = sMax;
                orderBean.time = orderTime;
                orderBean.temperature = returnSettingResulttemperature;
                orderBean.offineTimes = posNumber;
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        OpenRunnableV2 openRunnableV2 = OpenRunnableV2.this;
                        openRunnableV2.callNeedUploadOrder(openRunnableV2.mCurrentHardware, orderBean, str.substring(22, 30));
                    }
                });
                if (CommandUtilsWrapperTwo.isoffineRecordState(bArrHexToBuffer) == 1) {
                    this.mHasOffineRecord = true;
                    return;
                }
                return;
            }
            this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer);
            sendConfirmData();
            return;
        }
        if (CommandUtilsWrapper.isConfirmResult(bArrHexToBuffer)) {
            short confirmResultStatus = CommandUtilsWrapper.getConfirmResultStatus(bArrHexToBuffer);
            if (confirmResultStatus == 0) {
                callOnSuccess(this.mCurrentHardware, this.isNetworkStatus);
                if (this.mHasOffineRecord && !this.mIsGetRecording && this.isNetworkStatus) {
                    sendConnectOffineRecordData(callOnOpenDate(this.mCurrentHardware));
                    return;
                }
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
                if (this.mIsGetRecording) {
                    sendConnectOffineRecordData(callOnOpenDate(this.mCurrentHardware));
                    return;
                } else {
                    AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV2.7
                        @Override // java.lang.Runnable
                        public void run() {
                            OpenRunnableV2 openRunnableV2 = OpenRunnableV2.this;
                            String strCallOnOpenDate = openRunnableV2.callOnOpenDate(openRunnableV2.mCurrentHardware);
                            if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                                OpenRunnableV2.this.sendConnectData(strCallOnOpenDate);
                            }
                        }
                    });
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
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV2.8
                    @Override // java.lang.Runnable
                    public void run() {
                        OpenRunnableV2 openRunnableV2 = OpenRunnableV2.this;
                        String strCallOnOpenDate = openRunnableV2.callOnOpenDate(openRunnableV2.mCurrentHardware);
                        if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                            OpenRunnableV2.this.sendConnectData(strCallOnOpenDate);
                        }
                    }
                });
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

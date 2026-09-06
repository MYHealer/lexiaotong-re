package client.android.yixiaotong.sdk.runnable.socket;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.socket.Device;
import client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.LocalBusinessStore;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.executor.AsyncQueueExecutor;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import client.android.yixiaotong.util.TimeUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class OpenSocketRunnable {
    private boolean isNetworkStatus;
    private boolean isRunning;
    private short mBalance;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private TextView mLogTextView;
    private OpenListener mOpenListener;
    private SmoothBluetooth mSmoothBluetooth;
    private SmoothBluetooth.Listener mSmoothBluetoothListener = new SmoothBluetooth.Listener() { // from class: client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable.6
        private String mDeviceHexNo;
        public StringBuilder stringBuilder;
        private byte[] mLastCharacteristicData = null;
        public int leftCount = 0;

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onBluetoothNotEnabled() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onBluetoothNotSupported() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnecting(Device device) {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnectionFailed(Device device) {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDeviceFound(Device device) {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDisconnected() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDiscoveryFinished() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDiscoveryStarted() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnected(Device device) {
            String address = device.getAddress();
            if (address == null || OpenSocketRunnable.this.mCurrentHardware == null || !address.equals(OpenSocketRunnable.this.mCurrentHardware.address) || OpenSocketRunnable.this.mCurrentHardware.isTimeout || !OpenSocketRunnable.this.isRunning) {
                return;
            }
            OpenSocketRunnable.this.checkTimeOut(TimeOut.SendGetDeviceSettingCommand, 1500);
            OpenSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(CommandUtilsWrapper.getReturnSettingCommand()));
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDataReceived(byte[] bArr) {
            if (OpenSocketRunnable.this.mCurrentHardware.isTimeout || !OpenSocketRunnable.this.isRunning) {
                return;
            }
            readData(bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendConnectData(String str) {
            if (OpenSocketRunnable.this.isNetworkStatus) {
                String onlineConnectCommand = CommandUtilsWrapper.getOnlineConnectCommand(OpenSocketRunnable.this.mStudentNo, str);
                OpenSocketRunnable.this.checkTimeOut(TimeOut.SendConnect, 15000);
                OpenSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(onlineConnectCommand));
            } else {
                String offlineConnectCommand = CommandUtilsWrapper.getOfflineConnectCommand(OpenSocketRunnable.this.mStudentNo, str);
                OpenSocketRunnable.this.checkTimeOut(TimeOut.SendConnect, 15000);
                OpenSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(offlineConnectCommand));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendConfirmData() {
            if (OpenSocketRunnable.this.isNetworkStatus) {
                String onlineConfirmCommand = CommandUtilsWrapper.getOnlineConfirmCommand(OpenSocketRunnable.this.mStudentNo, OpenSocketRunnable.this.mBalance, this.mDeviceHexNo);
                OpenSocketRunnable.this.checkTimeOut(TimeOut.SendConfirm, 15000);
                OpenSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(onlineConfirmCommand));
            } else {
                String offlineConfirmCommand = CommandUtilsWrapper.getOfflineConfirmCommand(OpenSocketRunnable.this.mStudentNo, OpenSocketRunnable.this.mBalance, this.mDeviceHexNo);
                OpenSocketRunnable.this.checkTimeOut(TimeOut.SendConfirm, 15000);
                OpenSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(offlineConfirmCommand));
            }
        }

        private void sendAbortData() {
            String abortCommand = CommandUtilsWrapper.getAbortCommand();
            OpenSocketRunnable.this.checkTimeOut(TimeOut.SendAbort, 1500);
            OpenSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(abortCommand));
        }

        private void readData(byte[] bArr) {
            StringBuilder sb;
            String str;
            byte[] bArr2 = this.mLastCharacteristicData;
            if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
                this.mLastCharacteristicData = bArr;
                String strBufferToHex = HexString.bufferToHex(bArr);
                if (!strBufferToHex.startsWith("550001") || strBufferToHex.length() < 8) {
                    StringBuilder sb2 = this.stringBuilder;
                    if (sb2 == null) {
                        return;
                    }
                    sb2.append(strBufferToHex);
                    this.leftCount -= strBufferToHex.length();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    this.stringBuilder = sb3;
                    sb3.append(strBufferToHex);
                    byte[] bArrHexToBuffer = HexString.hexToBuffer(strBufferToHex.substring(6, 8));
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(bArrHexToBuffer, 0, bArr3, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                    this.leftCount = ((IntegerUtils.bytesToInt2(bArr3, 0) - 1) * 2) - (strBufferToHex.length() - 6);
                }
                if (this.leftCount > 0 || (sb = this.stringBuilder) == null) {
                    return;
                }
                byte[] bArrHexToBuffer2 = HexString.hexToBuffer(sb.toString());
                this.stringBuilder = null;
                if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer2)) {
                    if (!CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer2)) {
                        OpenSocketRunnable openSocketRunnable = OpenSocketRunnable.this;
                        openSocketRunnable.callOnFail(openSocketRunnable.mCurrentHardware, null, "终止消费失败");
                        return;
                    }
                    String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer2);
                    if (TextUtils.isEmpty(returnSettingDeviceIdResult) || !returnSettingDeviceIdResult.startsWith("0212")) {
                        OpenSocketRunnable openSocketRunnable2 = OpenSocketRunnable.this;
                        openSocketRunnable2.callOnFail(openSocketRunnable2.mCurrentHardware, null, "终止消费失败");
                        return;
                    } else {
                        AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String strCallOnOpenDate = OpenSocketRunnable.this.callOnOpenDate(OpenSocketRunnable.this.mCurrentHardware);
                                if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                                    sendConnectData(strCallOnOpenDate);
                                }
                            }
                        });
                        return;
                    }
                }
                if (CommandUtilsWrapper.isConnectResult(bArrHexToBuffer2)) {
                    short connectResultStatus = CommandUtilsWrapper.getConnectResultStatus(bArrHexToBuffer2);
                    if (connectResultStatus == 0) {
                        if (OpenSocketRunnable.this.isNetworkStatus) {
                            this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer2);
                            long connectResultUserId = CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer2);
                            short sMax = (short) Math.max(0, (int) CommandUtilsWrapper.getConnectResultBalance(bArrHexToBuffer2));
                            try {
                                str = String.valueOf(Calendar.getInstance().get(1)) + new SimpleDateFormat("-MM-dd HH:mm:ss").format(new SimpleDateFormat("MMddHHmmss").parse(CommandUtilsWrapper.getConnectResultTime(bArrHexToBuffer2)));
                            } catch (ParseException unused) {
                                str = new SimpleDateFormat(TimeUtils.FORMATDATETIME).format(new Date());
                            }
                            final OrderBean orderBean = new OrderBean();
                            orderBean.studentNo = connectResultUserId;
                            orderBean.money = sMax;
                            orderBean.time = str;
                            AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable.6.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!OpenSocketRunnable.this.callNeedUploadOrder(OpenSocketRunnable.this.mCurrentHardware, orderBean)) {
                                        OpenSocketRunnable.this.callOnFail(OpenSocketRunnable.this.mCurrentHardware, null, "不允许脱网使用");
                                        return;
                                    }
                                    OpenSocketRunnable.this.mBalance = OpenSocketRunnable.this.callBalance(OpenSocketRunnable.this.mCurrentHardware);
                                    if (OpenSocketRunnable.this.mBalance > 0) {
                                        LocalBusinessStore.saveOfflineCount(OpenSocketRunnable.this.mContext, OpenSocketRunnable.this.mStudentNo, 0);
                                        sendConfirmData();
                                    } else {
                                        OpenSocketRunnable.this.callOnFail(OpenSocketRunnable.this.mCurrentHardware, null, "余额不足");
                                    }
                                }
                            });
                            return;
                        }
                        this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer2);
                        sendConfirmData();
                        return;
                    }
                    if (connectResultStatus == 1) {
                        OpenSocketRunnable openSocketRunnable3 = OpenSocketRunnable.this;
                        openSocketRunnable3.callOnFail(openSocketRunnable3.mCurrentHardware, null, "连接失败");
                        return;
                    }
                    if (connectResultStatus == 2) {
                        if (!OpenSocketRunnable.this.isNetworkStatus) {
                            OpenSocketRunnable openSocketRunnable4 = OpenSocketRunnable.this;
                            openSocketRunnable4.callOnFail(openSocketRunnable4.mCurrentHardware, null, "余额不足");
                            return;
                        } else {
                            this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer2);
                            sendConfirmData();
                            return;
                        }
                    }
                    if (connectResultStatus != 15) {
                        OpenSocketRunnable openSocketRunnable5 = OpenSocketRunnable.this;
                        openSocketRunnable5.callOnFail(openSocketRunnable5.mCurrentHardware, null, "连接失败");
                        return;
                    } else if (CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer2) != OpenSocketRunnable.this.mStudentNo) {
                        OpenSocketRunnable openSocketRunnable6 = OpenSocketRunnable.this;
                        openSocketRunnable6.callOnFail(openSocketRunnable6.mCurrentHardware, null, "设备正忙,无法使用");
                        return;
                    } else {
                        sendAbortData();
                        return;
                    }
                }
                if (CommandUtilsWrapper.isConfirmResult(bArrHexToBuffer2)) {
                    short confirmResultStatus = CommandUtilsWrapper.getConfirmResultStatus(bArrHexToBuffer2);
                    if (confirmResultStatus == 0) {
                        OpenSocketRunnable openSocketRunnable7 = OpenSocketRunnable.this;
                        openSocketRunnable7.callOnSuccess(openSocketRunnable7.mCurrentHardware, OpenSocketRunnable.this.isNetworkStatus);
                        return;
                    }
                    if (confirmResultStatus == 1) {
                        OpenSocketRunnable openSocketRunnable8 = OpenSocketRunnable.this;
                        openSocketRunnable8.callOnFail(openSocketRunnable8.mCurrentHardware, null, "连接失败,确认订单上传失败");
                        return;
                    }
                    if (confirmResultStatus == 2) {
                        OpenSocketRunnable openSocketRunnable9 = OpenSocketRunnable.this;
                        openSocketRunnable9.callOnFail(openSocketRunnable9.mCurrentHardware, null, "连接失败,余额不足");
                        return;
                    }
                    if (confirmResultStatus == 3) {
                        OpenSocketRunnable openSocketRunnable10 = OpenSocketRunnable.this;
                        openSocketRunnable10.callOnSuccess(openSocketRunnable10.mCurrentHardware, OpenSocketRunnable.this.isNetworkStatus);
                        return;
                    }
                    if (confirmResultStatus == 5) {
                        AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable.6.3
                            @Override // java.lang.Runnable
                            public void run() {
                                String strCallOnOpenDate = OpenSocketRunnable.this.callOnOpenDate(OpenSocketRunnable.this.mCurrentHardware);
                                if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                                    sendConnectData(strCallOnOpenDate);
                                }
                            }
                        });
                        return;
                    }
                    if (confirmResultStatus == 13) {
                        OpenSocketRunnable openSocketRunnable11 = OpenSocketRunnable.this;
                        openSocketRunnable11.callOnFail(openSocketRunnable11.mCurrentHardware, null, "空间不足,不允许脱网消费");
                        return;
                    } else if (confirmResultStatus == 14) {
                        OpenSocketRunnable openSocketRunnable12 = OpenSocketRunnable.this;
                        openSocketRunnable12.callOnFail(openSocketRunnable12.mCurrentHardware, null, "写存储器失败");
                        return;
                    } else if (confirmResultStatus == 15) {
                        OpenSocketRunnable openSocketRunnable13 = OpenSocketRunnable.this;
                        openSocketRunnable13.callOnFail(openSocketRunnable13.mCurrentHardware, null, "设备正忙,无法使用");
                        return;
                    } else {
                        OpenSocketRunnable openSocketRunnable14 = OpenSocketRunnable.this;
                        openSocketRunnable14.callOnFail(openSocketRunnable14.mCurrentHardware, null, "连接失败,确认订单上传失败");
                        return;
                    }
                }
                if (CommandUtilsWrapper.isAbortResult(bArrHexToBuffer2)) {
                    if (!CommandUtilsWrapper.getAbortResultStatus(bArrHexToBuffer2)) {
                        OpenSocketRunnable openSocketRunnable15 = OpenSocketRunnable.this;
                        openSocketRunnable15.callOnFail(openSocketRunnable15.mCurrentHardware, null, "连接失败,请重启设备");
                    } else {
                        AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable.6.4
                            @Override // java.lang.Runnable
                            public void run() {
                                String strCallOnOpenDate = OpenSocketRunnable.this.callOnOpenDate(OpenSocketRunnable.this.mCurrentHardware);
                                if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                                    sendConnectData(strCallOnOpenDate);
                                }
                            }
                        });
                    }
                }
            }
        }
    };
    private long mStudentNo;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setLogTextView(TextView textView) {
        this.mLogTextView = textView;
    }

    public void setOpenListener(OpenListener openListener) {
        this.mOpenListener = openListener;
    }

    public OpenSocketRunnable(Context context, BluetoothDevice bluetoothDevice, long j, short s, boolean z) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
        this.mStudentNo = j;
        this.mBalance = s;
        this.isNetworkStatus = z;
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        callOnStart(this.mCurrentHardware);
        if (BluetoothUtils.isBluetoothOn(this.mContext) && BluetoothUtils.isBond(this.mContext, this.mCurrentHardware.address)) {
            closeGatt();
            this.mCurrentHardware.isTimeout = false;
            checkTimeOut(TimeOut.Connect, 5000);
            SmoothBluetooth smoothBluetooth = new SmoothBluetooth(this.mContext, this.mSmoothBluetoothListener);
            this.mSmoothBluetooth = smoothBluetooth;
            smoothBluetooth.connect(new Device(this.mCurrentHardware.name, this.mCurrentHardware.address, true));
            return;
        }
        callOnBluetoothException(new ClientException("蓝牙不可用或不支持BLE"));
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        this.mCurrentHardware.isTimeout = false;
        closeGatt();
    }

    private void closeGatt() {
        SmoothBluetooth smoothBluetooth = this.mSmoothBluetooth;
        if (smoothBluetooth != null) {
            try {
                smoothBluetooth.cancelDiscovery();
            } catch (Exception unused) {
            }
            try {
                this.mSmoothBluetooth.disconnect();
            } catch (Exception unused2) {
            }
            try {
                this.mSmoothBluetooth.stop();
            } catch (Exception unused3) {
            }
            this.mSmoothBluetooth = null;
        }
    }

    private void appendLog(final String str) {
        if (this.mLogTextView == null) {
            return;
        }
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (OpenSocketRunnable.this.mLogTextView == null) {
                    return;
                }
                OpenSocketRunnable.this.mLogTextView.append(str);
                OpenSocketRunnable.this.mLogTextView.append("\n\n");
            }
        });
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (!OpenSocketRunnable.this.isRunning || OpenSocketRunnable.this.mOpenListener == null) {
                    return;
                }
                OpenSocketRunnable.this.mOpenListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenSocketRunnable.this.isRunning && OpenSocketRunnable.this.mOpenListener != null) {
                        OpenSocketRunnable.this.mOpenListener.onSuccess(bluetoothDevice, z);
                    }
                } finally {
                    OpenSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenSocketRunnable.this.isRunning && OpenSocketRunnable.this.mOpenListener != null) {
                        OpenSocketRunnable.this.mOpenListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    OpenSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenSocketRunnable.this.isRunning && OpenSocketRunnable.this.mOpenListener != null) {
                        OpenSocketRunnable.this.mOpenListener.onBluetoothException(clientException);
                    }
                } finally {
                    OpenSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean callNeedUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean) {
        OpenListener openListener;
        try {
            if (!this.isRunning || (openListener = this.mOpenListener) == null) {
                return false;
            }
            return openListener.needUploadOrder(bluetoothDevice, orderBean);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public short callBalance(BluetoothDevice bluetoothDevice) {
        OpenListener openListener;
        try {
            if (!this.isRunning || (openListener = this.mOpenListener) == null) {
                return (short) 0;
            }
            return openListener.callBalance(bluetoothDevice);
        } catch (Exception unused) {
            return (short) 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String callOnOpenDate(BluetoothDevice bluetoothDevice) {
        OpenListener openListener;
        try {
            return (!this.isRunning || (openListener = this.mOpenListener) == null) ? "" : openListener.onOpenDate(bluetoothDevice);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(TimeOut timeOut, int i) {
        this.mCurrentCheckTimeOut = timeOut;
        MainThreadExecutor.getInstance().executeDelayed(new CheckRunnable(timeOut), Math.max(i, 1000));
    }

    private class CheckRunnable implements Runnable {
        private TimeOut timeOut;

        public CheckRunnable(TimeOut timeOut) {
            this.timeOut = timeOut;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OpenSocketRunnable.this.isRunning && this.timeOut == OpenSocketRunnable.this.mCurrentCheckTimeOut) {
                OpenSocketRunnable.this.mCurrentHardware.isTimeout = true;
                OpenSocketRunnable openSocketRunnable = OpenSocketRunnable.this;
                openSocketRunnable.callOnFail(openSocketRunnable.mCurrentHardware, this.timeOut, null);
            }
        }
    }
}

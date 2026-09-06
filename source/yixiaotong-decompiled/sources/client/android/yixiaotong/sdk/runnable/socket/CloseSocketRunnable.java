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
import client.android.yixiaotong.sdk.runnable.listener.CloseListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.executor.AsyncQueueExecutor;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import client.android.yixiaotong.util.TimeUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CloseSocketRunnable {
    private boolean isNetworkStatus;
    private boolean isRunning;
    private short mBalance;
    private CloseListener mCloseListener;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private TextView mLogTextView;
    private SmoothBluetooth mSmoothBluetooth;
    private SmoothBluetooth.Listener mSmoothBluetoothListener = new SmoothBluetooth.Listener() { // from class: client.android.yixiaotong.sdk.runnable.socket.CloseSocketRunnable.6
        private String mDeviceHexNo;
        public StringBuilder stringBuilder;
        public int leftCount = 0;
        private byte[] mLastCharacteristicData = null;

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
            if (address == null || CloseSocketRunnable.this.mCurrentHardware == null || !address.equals(CloseSocketRunnable.this.mCurrentHardware.address) || CloseSocketRunnable.this.mCurrentHardware.isTimeout || !CloseSocketRunnable.this.isRunning) {
                return;
            }
            CloseSocketRunnable.this.checkTimeOut(TimeOut.SendGetDeviceSettingCommand, 1500);
            CloseSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(CommandUtilsWrapper.getReturnSettingCommand()));
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDataReceived(byte[] bArr) {
            if (CloseSocketRunnable.this.mCurrentHardware.isTimeout || !CloseSocketRunnable.this.isRunning) {
                return;
            }
            readData(bArr);
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
                        CloseSocketRunnable closeSocketRunnable = CloseSocketRunnable.this;
                        closeSocketRunnable.callOnFail(closeSocketRunnable.mCurrentHardware, null, "终止消费失败");
                        return;
                    }
                    String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer2);
                    if (TextUtils.isEmpty(returnSettingDeviceIdResult) || !returnSettingDeviceIdResult.startsWith("0212")) {
                        CloseSocketRunnable closeSocketRunnable2 = CloseSocketRunnable.this;
                        closeSocketRunnable2.callOnFail(closeSocketRunnable2.mCurrentHardware, null, "终止消费失败");
                        return;
                    } else {
                        sendAbortData();
                        return;
                    }
                }
                if (CommandUtilsWrapper.isConnectResult(bArrHexToBuffer2)) {
                    if (CommandUtilsWrapper.getConnectResultStatus(bArrHexToBuffer2) != 0) {
                        CloseSocketRunnable closeSocketRunnable3 = CloseSocketRunnable.this;
                        closeSocketRunnable3.callOnSuccess(closeSocketRunnable3.mCurrentHardware);
                        return;
                    }
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
                    AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.CloseSocketRunnable.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!CloseSocketRunnable.this.callNeedUploadOrder(CloseSocketRunnable.this.mCurrentHardware, orderBean)) {
                                CloseSocketRunnable.this.callOnSuccess(CloseSocketRunnable.this.mCurrentHardware);
                            } else {
                                sendConfirmData();
                            }
                        }
                    });
                    return;
                }
                if (CommandUtilsWrapper.isConfirmResult(bArrHexToBuffer2)) {
                    CloseSocketRunnable closeSocketRunnable4 = CloseSocketRunnable.this;
                    closeSocketRunnable4.callOnSuccess(closeSocketRunnable4.mCurrentHardware);
                    return;
                }
                if (CommandUtilsWrapper.isAbortResult(bArrHexToBuffer2)) {
                    if (CommandUtilsWrapper.getAbortResultStatus(bArrHexToBuffer2)) {
                        if (!CloseSocketRunnable.this.isNetworkStatus) {
                            CloseSocketRunnable closeSocketRunnable5 = CloseSocketRunnable.this;
                            closeSocketRunnable5.callOnSuccess(closeSocketRunnable5.mCurrentHardware);
                            return;
                        } else {
                            sendConnectData();
                            return;
                        }
                    }
                    CloseSocketRunnable closeSocketRunnable6 = CloseSocketRunnable.this;
                    closeSocketRunnable6.callOnFail(closeSocketRunnable6.mCurrentHardware, null, "终止消费失败");
                }
            }
        }

        private void sendConnectData() {
            String onlineConnectCommand = CommandUtilsWrapper.getOnlineConnectCommand(CloseSocketRunnable.this.mStudentNo, new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime()));
            CloseSocketRunnable.this.checkTimeOut(TimeOut.SendConnect, 1500, new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.CloseSocketRunnable.6.2
                @Override // java.lang.Runnable
                public void run() {
                    CloseSocketRunnable.this.callOnSuccess(CloseSocketRunnable.this.mCurrentHardware);
                }
            });
            CloseSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(onlineConnectCommand));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendConfirmData() {
            String onlineConfirmCommand = CommandUtilsWrapper.getOnlineConfirmCommand(CloseSocketRunnable.this.mStudentNo, CloseSocketRunnable.this.mBalance, this.mDeviceHexNo);
            CloseSocketRunnable.this.checkTimeOut(TimeOut.SendConfirm, 1500, new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.CloseSocketRunnable.6.3
                @Override // java.lang.Runnable
                public void run() {
                    CloseSocketRunnable.this.callOnSuccess(CloseSocketRunnable.this.mCurrentHardware);
                }
            });
            CloseSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(onlineConfirmCommand));
        }

        private void sendAbortData() {
            String abortCommand = CommandUtilsWrapper.getAbortCommand();
            CloseSocketRunnable.this.checkTimeOut(TimeOut.SendAbort, 1500);
            CloseSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(abortCommand));
        }
    };
    private long mStudentNo;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setCloseListener(CloseListener closeListener) {
        this.mCloseListener = closeListener;
    }

    public void setLogTextView(TextView textView) {
        this.mLogTextView = textView;
    }

    public CloseSocketRunnable(Context context, BluetoothDevice bluetoothDevice, long j, short s, boolean z) {
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
        callOnBluetoothException(new ClientException("蓝牙不可用或没有绑定设备"));
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
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.CloseSocketRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (CloseSocketRunnable.this.mLogTextView == null) {
                    return;
                }
                CloseSocketRunnable.this.mLogTextView.append(str);
                CloseSocketRunnable.this.mLogTextView.append("\n\n");
            }
        });
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.CloseSocketRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (!CloseSocketRunnable.this.isRunning || CloseSocketRunnable.this.mCloseListener == null) {
                    return;
                }
                CloseSocketRunnable.this.mCloseListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.CloseSocketRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseSocketRunnable.this.isRunning && CloseSocketRunnable.this.mCloseListener != null) {
                        CloseSocketRunnable.this.mCloseListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    CloseSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.CloseSocketRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseSocketRunnable.this.isRunning && CloseSocketRunnable.this.mCloseListener != null) {
                        CloseSocketRunnable.this.mCloseListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    CloseSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.CloseSocketRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseSocketRunnable.this.isRunning && CloseSocketRunnable.this.mCloseListener != null) {
                        CloseSocketRunnable.this.mCloseListener.onBluetoothException(clientException);
                    }
                } finally {
                    CloseSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean callNeedUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean) {
        CloseListener closeListener;
        try {
            if (!this.isRunning || (closeListener = this.mCloseListener) == null) {
                return false;
            }
            return closeListener.needUploadOrder(bluetoothDevice, orderBean);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(TimeOut timeOut, int i) {
        this.mCurrentCheckTimeOut = timeOut;
        MainThreadExecutor.getInstance().executeDelayed(new CheckRunnable(timeOut), Math.max(i, 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(TimeOut timeOut, int i, Runnable runnable) {
        this.mCurrentCheckTimeOut = timeOut;
        MainThreadExecutor.getInstance().executeDelayed(new CheckRunnable(timeOut, runnable), Math.max(i, 1000));
    }

    private class CheckRunnable implements Runnable {
        private Runnable runnable;
        private TimeOut timeOut;

        public CheckRunnable(TimeOut timeOut) {
            this.timeOut = timeOut;
        }

        public CheckRunnable(TimeOut timeOut, Runnable runnable) {
            this.timeOut = timeOut;
            this.runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CloseSocketRunnable.this.isRunning && this.timeOut == CloseSocketRunnable.this.mCurrentCheckTimeOut) {
                CloseSocketRunnable.this.mCurrentHardware.isTimeout = true;
                Runnable runnable = this.runnable;
                if (runnable == null) {
                    CloseSocketRunnable closeSocketRunnable = CloseSocketRunnable.this;
                    closeSocketRunnable.callOnFail(closeSocketRunnable.mCurrentHardware, this.timeOut, null);
                } else {
                    runnable.run();
                }
            }
        }
    }
}

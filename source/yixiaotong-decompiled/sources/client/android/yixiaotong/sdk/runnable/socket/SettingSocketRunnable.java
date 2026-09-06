package client.android.yixiaotong.sdk.runnable.socket;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.socket.Device;
import client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.SettingListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SettingSocketRunnable {
    private boolean isRunning;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private TextView mLogTextView;
    private SettingListener mSettingListener;
    private SmoothBluetooth mSmoothBluetooth;
    private SmoothBluetooth.Listener mSmoothBluetoothListener = new SmoothBluetooth.Listener() { // from class: client.android.yixiaotong.sdk.runnable.socket.SettingSocketRunnable.6
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
            if (address == null || SettingSocketRunnable.this.mCurrentHardware == null || !address.equals(SettingSocketRunnable.this.mCurrentHardware.address) || SettingSocketRunnable.this.mCurrentHardware.isTimeout || !SettingSocketRunnable.this.isRunning) {
                return;
            }
            SettingSocketRunnable.this.checkTimeOut(TimeOut.SendGetDeviceSettingCommand, 1500);
            SettingSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(CommandUtilsWrapper.getReturnSettingCommand()));
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDataReceived(byte[] bArr) {
            if (SettingSocketRunnable.this.mCurrentHardware.isTimeout || !SettingSocketRunnable.this.isRunning) {
                return;
            }
            readData(bArr);
        }

        private void readData(byte[] bArr) {
            StringBuilder sb;
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
                        SettingSocketRunnable settingSocketRunnable = SettingSocketRunnable.this;
                        settingSocketRunnable.callOnFail(settingSocketRunnable.mCurrentHardware, null);
                        return;
                    }
                    String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer2);
                    if (TextUtils.isEmpty(returnSettingDeviceIdResult) || !returnSettingDeviceIdResult.startsWith("0212")) {
                        SettingSocketRunnable settingSocketRunnable2 = SettingSocketRunnable.this;
                        settingSocketRunnable2.callOnFail(settingSocketRunnable2.mCurrentHardware, null);
                        return;
                    }
                    SettingSocketRunnable.this.checkTimeOut(TimeOut.WriteSetting, 1500);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(CommandUtilsWrapper.getReturnSettingResult(bArrHexToBuffer2).substring(0, 4));
                    sb4.append(SettingSocketRunnable.this.mWriteData);
                    sb4.append("00");
                    sb4.append(new SimpleDateFormat("yyMMddHHmm").format(Calendar.getInstance().getTime()));
                    sb4.append(CommandUtilsWrapper.getReturnSettingDeviceTypeStringResult(bArrHexToBuffer2));
                    sb4.append("0E0F");
                    if (sb4.toString().trim().length() != 32) {
                        SettingSocketRunnable settingSocketRunnable3 = SettingSocketRunnable.this;
                        settingSocketRunnable3.callOnFail(settingSocketRunnable3.mCurrentHardware, null);
                        return;
                    } else {
                        SettingSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(CommandUtilsWrapper.getSettingCommand(sb4.toString().trim(), client.android.yixiaotong.util.bluetooth.BluetoothDevice.DEFAULT_DEVICEHEXNO)));
                        return;
                    }
                }
                if (CommandUtilsWrapper.isSettingResult(bArrHexToBuffer2)) {
                    if (CommandUtilsWrapper.getSettingResultStatus(bArrHexToBuffer2)) {
                        SettingSocketRunnable settingSocketRunnable4 = SettingSocketRunnable.this;
                        settingSocketRunnable4.callOnSuccess(settingSocketRunnable4.mCurrentHardware);
                    } else {
                        SettingSocketRunnable settingSocketRunnable5 = SettingSocketRunnable.this;
                        settingSocketRunnable5.callOnFail(settingSocketRunnable5.mCurrentHardware, null);
                    }
                }
            }
        }
    };
    private long mStudentNo;
    private String mWriteData;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setLogTextView(TextView textView) {
        this.mLogTextView = textView;
    }

    public void setSettingListener(SettingListener settingListener) {
        this.mSettingListener = settingListener;
    }

    public SettingSocketRunnable(Context context, BluetoothDevice bluetoothDevice, String str, long j) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
        this.mWriteData = str;
        this.mStudentNo = j;
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
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.SettingSocketRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (SettingSocketRunnable.this.mLogTextView == null) {
                    return;
                }
                SettingSocketRunnable.this.mLogTextView.append(str);
                SettingSocketRunnable.this.mLogTextView.append("\n\n");
            }
        });
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.SettingSocketRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (!SettingSocketRunnable.this.isRunning || SettingSocketRunnable.this.mSettingListener == null) {
                    return;
                }
                SettingSocketRunnable.this.mSettingListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.SettingSocketRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SettingSocketRunnable.this.isRunning && SettingSocketRunnable.this.mSettingListener != null) {
                        SettingSocketRunnable.this.mSettingListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    SettingSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.SettingSocketRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SettingSocketRunnable.this.isRunning && SettingSocketRunnable.this.mSettingListener != null) {
                        SettingSocketRunnable.this.mSettingListener.onFail(bluetoothDevice, timeOut);
                    }
                } finally {
                    SettingSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.SettingSocketRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SettingSocketRunnable.this.isRunning && SettingSocketRunnable.this.mSettingListener != null) {
                        SettingSocketRunnable.this.mSettingListener.onBluetoothException(clientException);
                    }
                } finally {
                    SettingSocketRunnable.this.stopAndRelease();
                }
            }
        });
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
            if (SettingSocketRunnable.this.isRunning && this.timeOut == SettingSocketRunnable.this.mCurrentCheckTimeOut) {
                SettingSocketRunnable.this.mCurrentHardware.isTimeout = true;
                SettingSocketRunnable settingSocketRunnable = SettingSocketRunnable.this;
                settingSocketRunnable.callOnFail(settingSocketRunnable.mCurrentHardware, this.timeOut);
            }
        }
    }
}

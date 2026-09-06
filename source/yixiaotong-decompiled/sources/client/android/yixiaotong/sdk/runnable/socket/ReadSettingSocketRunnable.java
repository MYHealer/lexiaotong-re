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
import client.android.yixiaotong.sdk.runnable.listener.ReadSettingListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ReadSettingSocketRunnable {
    private boolean isRunning;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private TextView mLogTextView;
    private ReadSettingListener mReadSettingListener;
    private SmoothBluetooth mSmoothBluetooth;
    private SmoothBluetooth.Listener mSmoothBluetoothListener = new SmoothBluetooth.Listener() { // from class: client.android.yixiaotong.sdk.runnable.socket.ReadSettingSocketRunnable.6
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
            if (address == null || ReadSettingSocketRunnable.this.mCurrentHardware == null || !address.equals(ReadSettingSocketRunnable.this.mCurrentHardware.address) || ReadSettingSocketRunnable.this.mCurrentHardware.isTimeout || !ReadSettingSocketRunnable.this.isRunning) {
                return;
            }
            ReadSettingSocketRunnable.this.checkTimeOut(TimeOut.ReadSetting, 1500);
            ReadSettingSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(CommandUtilsWrapper.getReturnSettingCommand()));
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDataReceived(byte[] bArr) {
            if (ReadSettingSocketRunnable.this.mCurrentHardware.isTimeout || !ReadSettingSocketRunnable.this.isRunning) {
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
                        ReadSettingSocketRunnable readSettingSocketRunnable = ReadSettingSocketRunnable.this;
                        readSettingSocketRunnable.callOnFail(readSettingSocketRunnable.mCurrentHardware, null);
                        return;
                    }
                    String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer2);
                    if (TextUtils.isEmpty(returnSettingDeviceIdResult) || !returnSettingDeviceIdResult.startsWith("0212")) {
                        ReadSettingSocketRunnable readSettingSocketRunnable2 = ReadSettingSocketRunnable.this;
                        readSettingSocketRunnable2.callOnFail(readSettingSocketRunnable2.mCurrentHardware, null);
                    } else {
                        ReadSettingSocketRunnable readSettingSocketRunnable3 = ReadSettingSocketRunnable.this;
                        readSettingSocketRunnable3.callOnSuccess(readSettingSocketRunnable3.mCurrentHardware, CommandUtilsWrapper.getReturnSettingResult(bArrHexToBuffer2));
                    }
                }
            }
        }
    };

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setLogTextView(TextView textView) {
        this.mLogTextView = textView;
    }

    public void setReadSettingListener(ReadSettingListener readSettingListener) {
        this.mReadSettingListener = readSettingListener;
    }

    public ReadSettingSocketRunnable(Context context, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
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
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ReadSettingSocketRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (ReadSettingSocketRunnable.this.mLogTextView == null) {
                    return;
                }
                ReadSettingSocketRunnable.this.mLogTextView.append(str);
                ReadSettingSocketRunnable.this.mLogTextView.append("\n\n");
            }
        });
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ReadSettingSocketRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ReadSettingSocketRunnable.this.isRunning || ReadSettingSocketRunnable.this.mReadSettingListener == null) {
                    return;
                }
                ReadSettingSocketRunnable.this.mReadSettingListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ReadSettingSocketRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ReadSettingSocketRunnable.this.isRunning && ReadSettingSocketRunnable.this.mReadSettingListener != null) {
                        ReadSettingSocketRunnable.this.mReadSettingListener.onSuccess(bluetoothDevice, str);
                    }
                } finally {
                    ReadSettingSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ReadSettingSocketRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ReadSettingSocketRunnable.this.isRunning && ReadSettingSocketRunnable.this.mReadSettingListener != null) {
                        ReadSettingSocketRunnable.this.mReadSettingListener.onFail(bluetoothDevice, timeOut);
                    }
                } finally {
                    ReadSettingSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ReadSettingSocketRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ReadSettingSocketRunnable.this.isRunning && ReadSettingSocketRunnable.this.mReadSettingListener != null) {
                        ReadSettingSocketRunnable.this.mReadSettingListener.onBluetoothException(clientException);
                    }
                } finally {
                    ReadSettingSocketRunnable.this.stopAndRelease();
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
            if (ReadSettingSocketRunnable.this.isRunning && this.timeOut == ReadSettingSocketRunnable.this.mCurrentCheckTimeOut) {
                ReadSettingSocketRunnable.this.mCurrentHardware.isTimeout = true;
                ReadSettingSocketRunnable readSettingSocketRunnable = ReadSettingSocketRunnable.this;
                readSettingSocketRunnable.callOnFail(readSettingSocketRunnable.mCurrentHardware, this.timeOut);
            }
        }
    }
}

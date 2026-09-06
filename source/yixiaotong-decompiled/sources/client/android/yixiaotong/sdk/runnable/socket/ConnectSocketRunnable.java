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
import client.android.yixiaotong.sdk.runnable.listener.ConnectListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ConnectSocketRunnable {
    private boolean isRunning;
    private ConnectListener mConnectListener;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private TextView mLogTextView;
    private SmoothBluetooth mSmoothBluetooth;
    private SmoothBluetooth.Listener mSmoothBluetoothListener = new SmoothBluetooth.Listener() { // from class: client.android.yixiaotong.sdk.runnable.socket.ConnectSocketRunnable.6
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
            if (address == null || ConnectSocketRunnable.this.mCurrentHardware == null || !address.equals(ConnectSocketRunnable.this.mCurrentHardware.address) || ConnectSocketRunnable.this.mCurrentHardware.isTimeout || !ConnectSocketRunnable.this.isRunning) {
                return;
            }
            ConnectSocketRunnable.this.checkTimeOut(TimeOut.SendGetDeviceSettingCommand, 1500);
            ConnectSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(CommandUtilsWrapper.getReturnSettingCommand()));
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDataReceived(byte[] bArr) {
            if (ConnectSocketRunnable.this.mCurrentHardware.isTimeout || !ConnectSocketRunnable.this.isRunning) {
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
                        ConnectSocketRunnable connectSocketRunnable = ConnectSocketRunnable.this;
                        connectSocketRunnable.callOnFail(connectSocketRunnable.mCurrentHardware, null);
                        return;
                    }
                    String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer2);
                    if (TextUtils.isEmpty(returnSettingDeviceIdResult) || !returnSettingDeviceIdResult.startsWith("0212")) {
                        ConnectSocketRunnable connectSocketRunnable2 = ConnectSocketRunnable.this;
                        connectSocketRunnable2.callOnFail(connectSocketRunnable2.mCurrentHardware, null);
                    } else {
                        ConnectSocketRunnable connectSocketRunnable3 = ConnectSocketRunnable.this;
                        connectSocketRunnable3.callOnSuccess(connectSocketRunnable3.mCurrentHardware, returnSettingDeviceIdResult);
                    }
                }
            }
        }
    };

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setConnectListener(ConnectListener connectListener) {
        this.mConnectListener = connectListener;
    }

    public void setLogTextView(TextView textView) {
        this.mLogTextView = textView;
    }

    public ConnectSocketRunnable(Context context, BluetoothDevice bluetoothDevice) {
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
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ConnectSocketRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (ConnectSocketRunnable.this.mLogTextView == null) {
                    return;
                }
                ConnectSocketRunnable.this.mLogTextView.append(str);
                ConnectSocketRunnable.this.mLogTextView.append("\n\n");
            }
        });
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ConnectSocketRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ConnectSocketRunnable.this.isRunning || ConnectSocketRunnable.this.mConnectListener == null) {
                    return;
                }
                ConnectSocketRunnable.this.mConnectListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ConnectSocketRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ConnectSocketRunnable.this.isRunning && ConnectSocketRunnable.this.mConnectListener != null) {
                        ConnectSocketRunnable.this.mConnectListener.onSuccess(bluetoothDevice, str);
                    }
                } finally {
                    ConnectSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ConnectSocketRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ConnectSocketRunnable.this.isRunning && ConnectSocketRunnable.this.mConnectListener != null) {
                        ConnectSocketRunnable.this.mConnectListener.onFail(bluetoothDevice, timeOut);
                    }
                } finally {
                    ConnectSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ConnectSocketRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ConnectSocketRunnable.this.isRunning && ConnectSocketRunnable.this.mConnectListener != null) {
                        ConnectSocketRunnable.this.mConnectListener.onBluetoothException(clientException);
                    }
                } finally {
                    ConnectSocketRunnable.this.stopAndRelease();
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
            if (ConnectSocketRunnable.this.isRunning && this.timeOut == ConnectSocketRunnable.this.mCurrentCheckTimeOut) {
                ConnectSocketRunnable.this.mCurrentHardware.isTimeout = true;
                ConnectSocketRunnable connectSocketRunnable = ConnectSocketRunnable.this;
                connectSocketRunnable.callOnFail(connectSocketRunnable.mCurrentHardware, this.timeOut);
            }
        }
    }
}

package client.android.yixiaotong.sdk.runnable.socket;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.socket.Device;
import client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.runnable.listener.ScanListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ScanSocketDeviceRunnable {
    private boolean isRunning;
    private Context mContext;
    private TextView mLogTextView;
    private ScanListener mScanListener;
    private SmoothBluetooth mSmoothBluetooth;
    private SmoothBluetooth.Listener mSmoothBluetoothListener = new SmoothBluetooth.Listener() { // from class: client.android.yixiaotong.sdk.runnable.socket.ScanSocketDeviceRunnable.6
        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onBluetoothNotEnabled() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onBluetoothNotSupported() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnected(Device device) {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnecting(Device device) {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnectionFailed(Device device) {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDataReceived(byte[] bArr) {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDisconnected() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDiscoveryStarted() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDiscoveryFinished() {
            ScanSocketDeviceRunnable.this.callOnComplete();
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDeviceFound(Device device) {
            if (device == null || TextUtils.isEmpty(device.getAddress())) {
                return;
            }
            ScanSocketDeviceRunnable.this.appendLog("找到设备--->" + device.getAddress());
            ScanSocketDeviceRunnable.this.callOnScan(new BluetoothDevice(device.getName(), device.getAddress(), 0));
        }
    };

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setLogTextView(TextView textView) {
        this.mLogTextView = textView;
    }

    public void setScanListener(ScanListener scanListener) {
        this.mScanListener = scanListener;
    }

    public ScanSocketDeviceRunnable(Context context) {
        this.mContext = context;
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        callOnStart();
        if (BluetoothUtils.isBluetoothOn(this.mContext)) {
            closeGatt();
            appendLog("开始扫描设备--->");
            SmoothBluetooth smoothBluetooth = new SmoothBluetooth(this.mContext, this.mSmoothBluetoothListener);
            this.mSmoothBluetooth = smoothBluetooth;
            smoothBluetooth.doDiscovery();
            return;
        }
        appendLog("蓝牙不可用或不支持BLE--->");
        callOnBluetoothException(new ClientException("蓝牙不可用或不支持BLE"));
    }

    public void stopAndRelease() {
        this.isRunning = false;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void appendLog(final String str) {
        if (this.mLogTextView == null) {
            return;
        }
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ScanSocketDeviceRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (ScanSocketDeviceRunnable.this.mLogTextView == null) {
                    return;
                }
                ScanSocketDeviceRunnable.this.mLogTextView.append(str);
                ScanSocketDeviceRunnable.this.mLogTextView.append("\n\n");
            }
        });
    }

    private void callOnStart() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ScanSocketDeviceRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ScanSocketDeviceRunnable.this.isRunning || ScanSocketDeviceRunnable.this.mScanListener == null) {
                    return;
                }
                ScanSocketDeviceRunnable.this.mScanListener.onStart();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnScan(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ScanSocketDeviceRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                if (!ScanSocketDeviceRunnable.this.isRunning || ScanSocketDeviceRunnable.this.mScanListener == null) {
                    return;
                }
                ScanSocketDeviceRunnable.this.mScanListener.onScan(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnComplete() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ScanSocketDeviceRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanSocketDeviceRunnable.this.isRunning && ScanSocketDeviceRunnable.this.mScanListener != null) {
                        ScanSocketDeviceRunnable.this.mScanListener.onComplete();
                    }
                } finally {
                    ScanSocketDeviceRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.ScanSocketDeviceRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanSocketDeviceRunnable.this.isRunning && ScanSocketDeviceRunnable.this.mScanListener != null) {
                        ScanSocketDeviceRunnable.this.mScanListener.onBluetoothException(clientException);
                    }
                } finally {
                    ScanSocketDeviceRunnable.this.stopAndRelease();
                }
            }
        });
    }
}

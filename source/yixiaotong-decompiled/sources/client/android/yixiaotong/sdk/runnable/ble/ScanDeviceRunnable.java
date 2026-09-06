package client.android.yixiaotong.sdk.runnable.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.ScanListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ScanDeviceRunnable {
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: client.android.yixiaotong.sdk.runnable.ble.ScanDeviceRunnable.5
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bluetoothDevice == null || TextUtils.isEmpty(bluetoothDevice.getAddress())) {
                return;
            }
            ScanDeviceRunnable.this.callOnScan(new client.android.yixiaotong.sdk.bluetooth.BluetoothDevice(bluetoothDevice.getName(), bluetoothDevice.getAddress(), i));
        }
    };
    private TextView mLogTextView;
    private ScanListener mScanListener;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setScanListener(ScanListener scanListener) {
        this.mScanListener = scanListener;
    }

    public ScanDeviceRunnable(Context context, BluetoothAdapter bluetoothAdapter) {
        this.mContext = context;
        this.mBluetoothAdapter = bluetoothAdapter;
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        callOnStart();
        if (BluetoothUtils.isBluetoothOn(this.mContext) && BluetoothUtils.isBluetoothLeSupported(this.mContext)) {
            this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
            checkTimeOut(TimeOut.Scan, 8000);
            this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
            return;
        }
        callOnBluetoothException(new ClientException("请打开蓝牙！"));
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
    }

    private void callOnStart() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ScanDeviceRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ScanDeviceRunnable.this.isRunning || ScanDeviceRunnable.this.mScanListener == null) {
                    return;
                }
                ScanDeviceRunnable.this.mScanListener.onStart();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnScan(final client.android.yixiaotong.sdk.bluetooth.BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ScanDeviceRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ScanDeviceRunnable.this.isRunning || ScanDeviceRunnable.this.mScanListener == null) {
                    return;
                }
                ScanDeviceRunnable.this.mScanListener.onScan(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnComplete() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ScanDeviceRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanDeviceRunnable.this.isRunning && ScanDeviceRunnable.this.mScanListener != null) {
                        ScanDeviceRunnable.this.mScanListener.onComplete();
                    }
                } finally {
                    ScanDeviceRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ScanDeviceRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanDeviceRunnable.this.isRunning && ScanDeviceRunnable.this.mScanListener != null) {
                        ScanDeviceRunnable.this.mScanListener.onBluetoothException(clientException);
                    }
                } finally {
                    ScanDeviceRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void checkTimeOut(TimeOut timeOut, int i) {
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
            if (ScanDeviceRunnable.this.isRunning && this.timeOut == ScanDeviceRunnable.this.mCurrentCheckTimeOut) {
                ScanDeviceRunnable.this.callOnComplete();
            }
        }
    }
}

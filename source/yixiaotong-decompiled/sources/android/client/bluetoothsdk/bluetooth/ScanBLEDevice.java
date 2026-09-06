package android.client.bluetoothsdk.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.client.bluetoothsdk.listener.ScanListener;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ScanBLEDevice {
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private ScanListener mScanListener;
    private int mTimeOut;

    public void setScanListener(ScanListener scanListener) {
        this.mScanListener = scanListener;
    }

    private ScanBLEDevice() {
        this.mTimeOut = 10000;
        this.mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: android.client.bluetoothsdk.bluetooth.ScanBLEDevice.5
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(android.bluetooth.BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (bluetoothDevice == null || TextUtils.isEmpty(bluetoothDevice.getAddress())) {
                    return;
                }
                ScanBLEDevice.this.callOnScan(new BluetoothDevice(bluetoothDevice.getName(), bluetoothDevice.getAddress(), i));
            }
        };
    }

    private static class SignalHolder {
        private static final ScanBLEDevice INSTANCE = new ScanBLEDevice();

        private SignalHolder() {
        }
    }

    public static ScanBLEDevice getInstance() {
        return SignalHolder.INSTANCE;
    }

    public void init(Context context, int i) {
        this.mContext = context;
        this.mTimeOut = i;
        this.mBluetoothAdapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        callOnStart();
        if (this.mBluetoothAdapter.getState() != 12) {
            callOnBluetoothException(new ClientException("请打开蓝牙！"), 220);
            return;
        }
        this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
        checkTimeOut(TimeOut.Scan, this.mTimeOut);
        this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(this.mLeScanCallback);
        }
        this.mBluetoothAdapter = null;
        this.mContext = null;
        this.mScanListener = null;
    }

    private void callOnStart() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ScanBLEDevice.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ScanBLEDevice.this.isRunning || ScanBLEDevice.this.mScanListener == null) {
                    return;
                }
                ScanBLEDevice.this.mScanListener.onStart();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnScan(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ScanBLEDevice.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ScanBLEDevice.this.isRunning || ScanBLEDevice.this.mScanListener == null) {
                    return;
                }
                ScanBLEDevice.this.mScanListener.onScan(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnComplete() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ScanBLEDevice.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanBLEDevice.this.isRunning && ScanBLEDevice.this.mScanListener != null) {
                        ScanBLEDevice.this.mScanListener.onComplete();
                    }
                } finally {
                    ScanBLEDevice.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException, final int i) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ScanBLEDevice.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanBLEDevice.this.isRunning && ScanBLEDevice.this.mScanListener != null) {
                        ScanBLEDevice.this.mScanListener.onBluetoothException(clientException, i);
                    }
                } finally {
                    ScanBLEDevice.this.stopAndRelease();
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
            if (ScanBLEDevice.this.isRunning && this.timeOut == ScanBLEDevice.this.mCurrentCheckTimeOut) {
                ScanBLEDevice.this.callOnComplete();
            }
        }
    }
}

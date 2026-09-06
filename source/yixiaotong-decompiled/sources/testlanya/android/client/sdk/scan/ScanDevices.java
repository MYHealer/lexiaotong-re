package testlanya.android.client.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ScanDevices {
    private static final long SCAN_PERIOD = 10000;
    private BluetoothAdapter mBluetoothAdapter;
    public final Handler mHandler;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    ScanDevicesListener mScanDevicesListener;
    private boolean mScanning;

    private ScanDevices() {
        this.mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: testlanya.android.client.sdk.scan.ScanDevices.1
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(android.bluetooth.BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (ScanDevices.this.mScanDevicesListener != null) {
                    ScanDevices.this.mScanDevicesListener.onScanDevice(new BluetoothDevice(bluetoothDevice.getName(), bluetoothDevice.getAddress(), i));
                }
            }
        };
        this.mHandler = new Handler() { // from class: testlanya.android.client.sdk.scan.ScanDevices.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
            }
        };
    }

    public static ScanDevices getInstance() {
        return SingleHolder.INSTANCE;
    }

    private static class SingleHolder {
        private static ScanDevices INSTANCE = new ScanDevices();

        private SingleHolder() {
        }
    }

    public void startScan(Context context, ScanDevicesListener scanDevicesListener) {
        ScanDevicesListener scanDevicesListener2;
        ScanDevicesListener scanDevicesListener3;
        this.mScanDevicesListener = scanDevicesListener;
        if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") && (scanDevicesListener3 = this.mScanDevicesListener) != null) {
            scanDevicesListener3.onFail("手机不支持ble");
            return;
        }
        BluetoothAdapter adapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter == null && (scanDevicesListener2 = this.mScanDevicesListener) != null) {
            scanDevicesListener2.onFail("手机不支持ble");
        } else {
            scanLeDevice(true);
        }
    }

    public void stopScan() {
        scanLeDevice(false);
        ScanDevicesListener scanDevicesListener = this.mScanDevicesListener;
        if (scanDevicesListener != null) {
            scanDevicesListener.onStop();
        }
    }

    private void scanLeDevice(boolean z) {
        if (!z) {
            this.mScanning = false;
            this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
        } else {
            if (!this.mScanning) {
                this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
            }
            this.mScanning = true;
        }
    }
}

package client.android.yixiaotong.sdk.bluetooth.spp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.ScanListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SppScanDeviceServer {
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private ScanListener mScanListener;
    private int rssi;
    private boolean mIsBond = false;
    private BroadcastReceiver searchDevices = new BroadcastReceiver() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppScanDeviceServer.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.bluetooth.device.action.FOUND")) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice.getType() != 2) {
                    if (bluetoothDevice.getBondState() == 12) {
                        SppScanDeviceServer.this.mIsBond = true;
                    } else {
                        SppScanDeviceServer.this.mIsBond = false;
                    }
                    SppScanDeviceServer.this.rssi = intent.getExtras().getShort("android.bluetooth.device.extra.RSSI");
                    SppScanDeviceServer.this.callOnScan(new client.android.yixiaotong.sdk.bluetooth.BluetoothDevice(bluetoothDevice.getName(), bluetoothDevice.getAddress(), SppScanDeviceServer.this.rssi, SppScanDeviceServer.this.mIsBond));
                    return;
                }
                return;
            }
            if (!action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED") && action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                Log.e("test", "spp扫描结束:");
                SppScanDeviceServer.this.mContext.unregisterReceiver(SppScanDeviceServer.this.searchDevices);
                SppScanDeviceServer.this.callOnComplete();
            }
        }
    };

    public void setScanListener(ScanListener scanListener) {
        this.mScanListener = scanListener;
    }

    public SppScanDeviceServer(Context context, BluetoothAdapter bluetoothAdapter) {
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
        if (this.mBluetoothAdapter.getState() != 12) {
            callOnBluetoothException(new ClientException("请打开蓝牙！"));
            return;
        }
        if (this.mBluetoothAdapter.isDiscovering()) {
            return;
        }
        this.mContext.registerReceiver(this.searchDevices, new IntentFilter("android.bluetooth.device.action.FOUND"));
        this.mContext.registerReceiver(this.searchDevices, new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED"));
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppScanDeviceServer.1
            @Override // java.lang.Runnable
            public void run() {
                SppScanDeviceServer.this.checkTimeOut(TimeOut.Scan, 10000);
                SppScanDeviceServer.this.mBluetoothAdapter.startDiscovery();
            }
        }, 100L);
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
        }
    }

    private void callOnStart() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppScanDeviceServer.2
            @Override // java.lang.Runnable
            public void run() {
                if (!SppScanDeviceServer.this.isRunning || SppScanDeviceServer.this.mScanListener == null) {
                    return;
                }
                SppScanDeviceServer.this.mScanListener.onStart();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnScan(final client.android.yixiaotong.sdk.bluetooth.BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppScanDeviceServer.3
            @Override // java.lang.Runnable
            public void run() {
                if (!SppScanDeviceServer.this.isRunning || SppScanDeviceServer.this.mScanListener == null) {
                    return;
                }
                SppScanDeviceServer.this.mScanListener.onScan(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnComplete() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppScanDeviceServer.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SppScanDeviceServer.this.isRunning && SppScanDeviceServer.this.mScanListener != null) {
                        SppScanDeviceServer.this.mScanListener.onComplete();
                    }
                } finally {
                    SppScanDeviceServer.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppScanDeviceServer.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SppScanDeviceServer.this.isRunning && SppScanDeviceServer.this.mScanListener != null) {
                        SppScanDeviceServer.this.mScanListener.onBluetoothException(clientException);
                    }
                } finally {
                    SppScanDeviceServer.this.stopAndRelease();
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
            if (SppScanDeviceServer.this.isRunning && this.timeOut == SppScanDeviceServer.this.mCurrentCheckTimeOut) {
                SppScanDeviceServer.this.callOnComplete();
            }
        }
    }

    private void addPairedDevice() {
        Set<BluetoothDevice> bondedDevices = this.mBluetoothAdapter.getBondedDevices();
        if (bondedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                callOnScan(new client.android.yixiaotong.sdk.bluetooth.BluetoothDevice(bluetoothDevice.getName(), bluetoothDevice.getAddress(), 1));
            }
        }
    }
}

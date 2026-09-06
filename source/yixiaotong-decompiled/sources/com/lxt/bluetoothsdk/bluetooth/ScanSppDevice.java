package com.lxt.bluetoothsdk.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.lxt.bluetoothsdk.TimeOut;
import com.lxt.bluetoothsdk.listener.ScanListener;
import com.lxt.bluetoothsdk.utils.ClientException;
import com.lxt.bluetoothsdk.utils.executor.MainThreadExecutor;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ScanSppDevice {
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private boolean mIsBond;
    private boolean mReceiverTag;
    private ScanListener mScanListener;
    private int mTimeOut;
    private int rssi;
    private BroadcastReceiver searchDevices;

    public void setScanListener(ScanListener scanListener) {
        this.mScanListener = scanListener;
    }

    private ScanSppDevice() {
        this.mTimeOut = 10000;
        this.mReceiverTag = false;
        this.mIsBond = false;
        this.searchDevices = new BroadcastReceiver() { // from class: com.lxt.bluetoothsdk.bluetooth.ScanSppDevice.6
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals("android.bluetooth.device.action.FOUND")) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice.getType() != 2) {
                        if (bluetoothDevice.getBondState() == 12) {
                            ScanSppDevice.this.mIsBond = true;
                        } else {
                            ScanSppDevice.this.mIsBond = false;
                        }
                        ScanSppDevice.this.rssi = intent.getExtras().getShort("android.bluetooth.device.extra.RSSI");
                        ScanSppDevice.this.callOnScan(new com.lxt.bluetoothsdk.model.BluetoothDevice(bluetoothDevice.getName(), bluetoothDevice.getAddress(), ScanSppDevice.this.rssi, ScanSppDevice.this.mIsBond));
                        return;
                    }
                    return;
                }
                if (!action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED") && action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                    Log.e("test", "spp扫描结束:");
                    ScanSppDevice.this.callOnComplete();
                }
            }
        };
    }

    private static class SignalHolder {
        private static final ScanSppDevice INSTANCE = new ScanSppDevice();

        private SignalHolder() {
        }
    }

    public static ScanSppDevice getInstance() {
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
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        this.mContext.registerReceiver(this.searchDevices, intentFilter);
        this.mReceiverTag = true;
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: com.lxt.bluetoothsdk.bluetooth.ScanSppDevice.1
            @Override // java.lang.Runnable
            public void run() {
                ScanSppDevice.this.checkTimeOut(TimeOut.Scan, ScanSppDevice.this.mTimeOut);
                ScanSppDevice.this.mBluetoothAdapter.startDiscovery();
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
        if (this.mReceiverTag) {
            this.mContext.unregisterReceiver(this.searchDevices);
        }
        this.mReceiverTag = false;
    }

    private void callOnStart() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: com.lxt.bluetoothsdk.bluetooth.ScanSppDevice.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ScanSppDevice.this.isRunning || ScanSppDevice.this.mScanListener == null) {
                    return;
                }
                ScanSppDevice.this.mScanListener.onStart();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnScan(final com.lxt.bluetoothsdk.model.BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: com.lxt.bluetoothsdk.bluetooth.ScanSppDevice.3
            @Override // java.lang.Runnable
            public void run() {
                if (!ScanSppDevice.this.isRunning || ScanSppDevice.this.mScanListener == null) {
                    return;
                }
                ScanSppDevice.this.mScanListener.onScan(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnComplete() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: com.lxt.bluetoothsdk.bluetooth.ScanSppDevice.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanSppDevice.this.isRunning && ScanSppDevice.this.mScanListener != null) {
                        ScanSppDevice.this.mScanListener.onComplete();
                    }
                } finally {
                    ScanSppDevice.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException, final int i) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: com.lxt.bluetoothsdk.bluetooth.ScanSppDevice.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanSppDevice.this.isRunning && ScanSppDevice.this.mScanListener != null) {
                        ScanSppDevice.this.mScanListener.onBluetoothException(clientException, i);
                    }
                } finally {
                    ScanSppDevice.this.stopAndRelease();
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
            if (ScanSppDevice.this.isRunning && this.timeOut == ScanSppDevice.this.mCurrentCheckTimeOut) {
                ScanSppDevice.this.callOnComplete();
            }
        }
    }

    private void addPairedDevice() {
        Set<BluetoothDevice> bondedDevices = this.mBluetoothAdapter.getBondedDevices();
        if (bondedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                callOnScan(new com.lxt.bluetoothsdk.model.BluetoothDevice(bluetoothDevice.getName(), bluetoothDevice.getAddress(), 1));
            }
        }
    }
}

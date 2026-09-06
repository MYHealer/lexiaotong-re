package com.lxt.bluetoothsdk;

import android.content.Context;
import android.util.Log;
import com.lxt.bluetoothsdk.bluetooth.ConnectBLEDevice;
import com.lxt.bluetoothsdk.bluetooth.ConnectSppDevice;
import com.lxt.bluetoothsdk.bluetooth.ScanBLEDevice;
import com.lxt.bluetoothsdk.bluetooth.ScanSppDevice;
import com.lxt.bluetoothsdk.listener.ConnectListener;
import com.lxt.bluetoothsdk.listener.DataListener;
import com.lxt.bluetoothsdk.listener.ScanListener;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.lxt.bluetoothsdk.utils.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BluetoothSDK {
    private static final int BLE = 1;
    private static final int SPP = 2;
    private Context mContext;
    private boolean mIsBle;
    private int mMode;

    /* JADX INFO: renamed from: com.lxt.bluetoothsdk.BluetoothSDK$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void setmMode(int i) {
        this.mMode = i;
        if (i == 1) {
            this.mIsBle = true;
        } else if (i == 2) {
            this.mIsBle = false;
        }
    }

    /* synthetic */ BluetoothSDK(AnonymousClass1 anonymousClass1) {
        this();
    }

    private BluetoothSDK() {
        this.mIsBle = true;
        this.mMode = 1;
    }

    private static class SignalHolder {
        private static final BluetoothSDK INSTANCE = new BluetoothSDK(null);

        private SignalHolder() {
        }
    }

    public static BluetoothSDK getInstance() {
        return SignalHolder.INSTANCE;
    }

    public void startScanDevice(int i, ScanListener scanListener) {
        if (this.mContext == null) {
            return;
        }
        if (this.mIsBle) {
            ScanBLEDevice.getInstance().init(this.mContext, i);
            ScanBLEDevice.getInstance().setScanListener(scanListener);
            ScanBLEDevice.getInstance().start();
        } else {
            ScanSppDevice.getInstance().init(this.mContext, i);
            ScanSppDevice.getInstance().setScanListener(scanListener);
            ScanSppDevice.getInstance().start();
        }
    }

    public void stopScanDevice() {
        if (this.mContext == null) {
            return;
        }
        if (this.mIsBle) {
            ScanBLEDevice.getInstance().stopAndRelease();
        } else {
            ScanSppDevice.getInstance().stopAndRelease();
        }
    }

    public void setConnectListener(ConnectListener connectListener) {
        if (this.mIsBle) {
            ConnectBLEDevice.getInstance().setConnectListener(connectListener);
        } else {
            ConnectSppDevice.getInstance().setConnectListener(connectListener);
        }
    }

    public void setTime(int i, int i2) {
        if (this.mIsBle) {
            ConnectBLEDevice.getInstance().setTime(i, i2);
        }
    }

    public void unRegisterListener() {
        if (this.mIsBle) {
            ConnectBLEDevice.getInstance().unRegisterListener();
        } else {
            ConnectSppDevice.getInstance().unRegisterListener();
        }
    }

    public void connectDevice(Context context, BluetoothDevice bluetoothDevice) {
        Log.e("BluetoothSDK", "connectDevice:" + (this.mContext == null));
        if (this.mContext == null) {
            return;
        }
        if (this.mIsBle) {
            ConnectBLEDevice.getInstance().start(context, bluetoothDevice);
        } else {
            ConnectSppDevice.getInstance().start(context, bluetoothDevice);
        }
    }

    public void disconnectDevice() {
        LogUtil.log_e("BluetoothSDK", "disconnectDevice");
        if (this.mContext == null) {
            return;
        }
        if (this.mIsBle) {
            ConnectBLEDevice.getInstance().stopAndRelease();
        } else {
            ConnectSppDevice.getInstance().stopAndRelease();
        }
    }

    public void setDataListener(DataListener dataListener) {
        if (this.mIsBle) {
            ConnectBLEDevice.getInstance().setDataListener(dataListener);
        } else {
            ConnectSppDevice.getInstance().setDataListener(dataListener);
        }
    }

    public void sendData(String str) {
        if (this.mContext == null) {
            return;
        }
        if (this.mIsBle) {
            ConnectBLEDevice.getInstance().sendData(str);
        } else {
            ConnectSppDevice.getInstance().sendData(str);
        }
    }

    public void openLog(boolean z) {
        LogUtil.setOpenLog(z);
    }
}

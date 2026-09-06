package com.lxt.bluetoothsdk.listener;

import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ConnectListener {
    void onConnectException(BluetoothDevice bluetoothDevice, String str, int i);

    void onConnectFail(BluetoothDevice bluetoothDevice, String str, int i);

    void onConnectSuccess(BluetoothDevice bluetoothDevice);

    void onStartConnect(BluetoothDevice bluetoothDevice);
}

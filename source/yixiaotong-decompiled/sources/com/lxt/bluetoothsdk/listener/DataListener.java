package com.lxt.bluetoothsdk.listener;

import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface DataListener {
    void onReceivedData(BluetoothDevice bluetoothDevice, String str);

    void onSendDataFail(BluetoothDevice bluetoothDevice, String str, int i);
}

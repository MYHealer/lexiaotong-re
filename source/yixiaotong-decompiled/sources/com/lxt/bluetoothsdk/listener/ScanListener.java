package com.lxt.bluetoothsdk.listener;

import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.lxt.bluetoothsdk.utils.ClientException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ScanListener {
    void onBluetoothException(ClientException clientException, int i);

    void onComplete();

    void onScan(BluetoothDevice bluetoothDevice);

    void onStart();
}

package android.client.bluetoothsdk.listener;

import android.client.bluetoothsdk.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface DataListener {
    void onReceivedData(BluetoothDevice bluetoothDevice, String str);

    void onSendDataFail(BluetoothDevice bluetoothDevice, String str, int i);
}

package android.client.bluetoothsdk.listener;

import android.client.bluetoothsdk.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface ConnectListener {
    void onConnectException(BluetoothDevice bluetoothDevice, String str, int i);

    void onConnectFail(BluetoothDevice bluetoothDevice, String str, int i);

    void onConnectSuccess(BluetoothDevice bluetoothDevice);

    void onStartConnect(BluetoothDevice bluetoothDevice);
}

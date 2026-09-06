package client.android.yixiaotong.sdk.runnable.listener;

import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.utils.ClientException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface ScanListener {
    void onBluetoothException(ClientException clientException);

    void onComplete();

    void onScan(BluetoothDevice bluetoothDevice);

    void onStart();
}

package android.client.bluetoothsdk.listener;

import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.util.ClientException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface ScanListener {
    void onBluetoothException(ClientException clientException, int i);

    void onComplete();

    void onScan(BluetoothDevice bluetoothDevice);

    void onStart();
}

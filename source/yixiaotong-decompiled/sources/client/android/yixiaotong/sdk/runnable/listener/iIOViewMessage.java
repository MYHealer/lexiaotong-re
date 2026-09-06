package client.android.yixiaotong.sdk.runnable.listener;

import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.TimeOut;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface iIOViewMessage {
    void IOLayerCallOnBluetoothException(BluetoothDevice bluetoothDevice, String str);

    void IOLayerCallOnConnectSuccess(BluetoothDevice bluetoothDevice);

    void IOLayerCallOnFail(BluetoothDevice bluetoothDevice, TimeOut timeOut);

    void IOLayerCallOnNoneBond(BluetoothDevice bluetoothDevice);

    void IOLayerCallOnReceivedData(BluetoothDevice bluetoothDevice, String str);

    void IOLayerCallOnStart(BluetoothDevice bluetoothDevice);
}

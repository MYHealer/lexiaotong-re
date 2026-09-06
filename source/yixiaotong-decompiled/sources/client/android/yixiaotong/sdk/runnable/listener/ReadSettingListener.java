package client.android.yixiaotong.sdk.runnable.listener;

import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.utils.ClientException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface ReadSettingListener {
    void onBluetoothException(ClientException clientException);

    void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut);

    void onStart(BluetoothDevice bluetoothDevice);

    void onSuccess(BluetoothDevice bluetoothDevice, String str);
}

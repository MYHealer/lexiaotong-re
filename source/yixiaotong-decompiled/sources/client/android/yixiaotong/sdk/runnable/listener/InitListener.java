package client.android.yixiaotong.sdk.runnable.listener;

import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.DeviceBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.utils.ClientException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public abstract class InitListener {
    public abstract String needName(BluetoothDevice bluetoothDevice);

    public abstract byte[] needServerInit(BluetoothDevice bluetoothDevice, DeviceBean deviceBean);

    public void onBluetoothException(ClientException clientException) {
    }

    public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
    }

    public void onStart(BluetoothDevice bluetoothDevice) {
    }

    public void onSuccess(BluetoothDevice bluetoothDevice) {
    }
}

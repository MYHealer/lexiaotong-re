package android.client.bluetoothsdk.listener;

import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public abstract class BluetoothConnectListener {
    public void onBluetoothException(ClientException clientException) {
    }

    public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
    }

    public void onStart(BluetoothDevice bluetoothDevice) {
    }

    public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
    }

    public void onSuccessSendData(BluetoothDevice bluetoothDevice, String str) {
    }
}

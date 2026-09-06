package client.android.yixiaotong.sdk.runnable.listener;

import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.utils.ClientException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public abstract class CollectDataListener {
    public abstract boolean needUploadOrder(BluetoothDevice bluetoothDevice, String str, String str2);

    public void onBluetoothException(ClientException clientException) {
    }

    public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
    }

    public abstract String onGetOpenData(BluetoothDevice bluetoothDevice);

    public abstract String onGetStudentId(BluetoothDevice bluetoothDevice);

    public void onMachineRand(BluetoothDevice bluetoothDevice, String str) {
    }

    public void onStart(BluetoothDevice bluetoothDevice) {
    }

    public void onSuccess(BluetoothDevice bluetoothDevice, boolean z) {
    }
}

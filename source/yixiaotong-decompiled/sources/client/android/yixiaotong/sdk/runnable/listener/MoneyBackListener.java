package client.android.yixiaotong.sdk.runnable.listener;

import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.utils.ClientException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public abstract class MoneyBackListener {
    public abstract boolean needUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean);

    public void onBluetoothException(ClientException clientException) {
    }

    public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
    }

    public void onStart(BluetoothDevice bluetoothDevice) {
    }

    public void onSuccess(BluetoothDevice bluetoothDevice, boolean z) {
    }

    public void onSuccessGetOffineData(BluetoothDevice bluetoothDevice, boolean z) {
    }

    public abstract String onf1(BluetoothDevice bluetoothDevice, String str);
}

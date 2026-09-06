package client.android.yixiaotong.sdk.runnable.listener;

import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.utils.ClientException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public abstract class ConnectManagerListener {
    public abstract short callBalance(BluetoothDevice bluetoothDevice);

    public abstract boolean needUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean);

    public void onBluetoothException(ClientException clientException) {
    }

    public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
    }

    public abstract String onOpenDate(BluetoothDevice bluetoothDevice);

    public void onStart(BluetoothDevice bluetoothDevice) {
    }

    public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
    }

    public void onSuccessSendData(BluetoothDevice bluetoothDevice, boolean z) {
    }
}

package client.android.yixiaotong.sdk.runnable.listener;

import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.utils.ClientException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public abstract class OpenListener {
    public abstract short callBalance(BluetoothDevice bluetoothDevice);

    public abstract int callConsumptionTime(BluetoothDevice bluetoothDevice);

    public void needUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean, String str) {
    }

    public abstract boolean needUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean);

    public void onBluetoothException(ClientException clientException) {
    }

    public void onConnectBLESuccess(BluetoothDevice bluetoothDevice) {
    }

    public void onConnectSuccess(BluetoothDevice bluetoothDevice, String str) {
    }

    public void onConnectSuccessNew(BluetoothDevice bluetoothDevice, String str) {
    }

    public void onConnectSuccessV3(BluetoothDevice bluetoothDevice, String str) {
    }

    public void onDataV3(BluetoothDevice bluetoothDevice, String str) {
    }

    public void onDataV4(BluetoothDevice bluetoothDevice, String str, String str2) {
    }

    public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
    }

    public abstract String onGetAuthDataV4(BluetoothDevice bluetoothDevice);

    public abstract String onGetStudentId(BluetoothDevice bluetoothDevice);

    public void onNoneBond(BluetoothDevice bluetoothDevice) {
    }

    public abstract String onOpenDate(BluetoothDevice bluetoothDevice);

    public void onStart(BluetoothDevice bluetoothDevice) {
    }

    public void onSuccess(BluetoothDevice bluetoothDevice, boolean z) {
    }

    public void onSuccessGetOffineData(BluetoothDevice bluetoothDevice, boolean z) {
    }

    public abstract String onf1(BluetoothDevice bluetoothDevice, String str, String str2);
}

package client.android.yixiaotong.util.bluetooth;

import android.bluetooth.BluetoothAdapter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
interface IBluetoothManager {
    void addBluetoothDevice(BluetoothAdapter bluetoothAdapter, String str, String str2);

    void connect(BluetoothAdapter bluetoothAdapter, String str);

    void disConnect(String str);

    void disConnectAll();

    BluetoothDevice getBluetoothDevice(String str);

    void restartBluetooth(BluetoothAdapter bluetoothAdapter);

    void sendData(String str, byte[] bArr);

    void startScan(BluetoothAdapter bluetoothAdapter);

    void stopScan(BluetoothAdapter bluetoothAdapter);
}

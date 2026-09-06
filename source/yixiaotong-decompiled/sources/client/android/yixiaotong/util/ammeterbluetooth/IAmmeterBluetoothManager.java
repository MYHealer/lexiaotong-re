package client.android.yixiaotong.util.ammeterbluetooth;

import android.bluetooth.BluetoothAdapter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface IAmmeterBluetoothManager {
    void addBluetoothDevice(BluetoothAdapter bluetoothAdapter, String str, String str2, int i);

    void bleConnectState();

    void connect(BluetoothAdapter bluetoothAdapter, String str);

    void disConnect(String str);

    void disConnectAll();

    AmmeterBluetoothDevice getBluetoothDevice(String str);

    void restartBluetooth(BluetoothAdapter bluetoothAdapter);

    void sendData(String str, byte[] bArr);

    void startScan(BluetoothAdapter bluetoothAdapter);

    void stopScan(BluetoothAdapter bluetoothAdapter);
}

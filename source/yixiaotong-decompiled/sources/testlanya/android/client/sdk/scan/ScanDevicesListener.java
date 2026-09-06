package testlanya.android.client.sdk.scan;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface ScanDevicesListener {
    void onFail(String str);

    void onScanDevice(BluetoothDevice bluetoothDevice);

    void onStop();
}

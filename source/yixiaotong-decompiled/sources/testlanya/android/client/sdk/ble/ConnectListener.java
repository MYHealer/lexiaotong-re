package testlanya.android.client.sdk.ble;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface ConnectListener {
    void onConnectFail(String str);

    void onConnectSuccess();

    void onReceivedData(String str);
}

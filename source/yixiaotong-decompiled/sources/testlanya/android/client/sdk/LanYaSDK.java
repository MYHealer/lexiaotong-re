package testlanya.android.client.sdk;

import android.content.Context;
import testlanya.android.client.sdk.ble.ConnectBLE;
import testlanya.android.client.sdk.ble.ConnectListener;
import testlanya.android.client.sdk.scan.ScanDevices;
import testlanya.android.client.sdk.scan.ScanDevicesListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LanYaSDK {

    /* JADX INFO: renamed from: testlanya.android.client.sdk.LanYaSDK$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ LanYaSDK(AnonymousClass1 anonymousClass1) {
        this();
    }

    private LanYaSDK() {
    }

    public static LanYaSDK getInstance() {
        return SingleHolder.INSTANCE;
    }

    private static class SingleHolder {
        private static LanYaSDK INSTANCE = new LanYaSDK(null);

        private SingleHolder() {
        }
    }

    public void startScanDevice(Context context, ScanDevicesListener scanDevicesListener) {
        ScanDevices.getInstance().startScan(context, scanDevicesListener);
    }

    public void stopScanDevices() {
        ScanDevices.getInstance().stopScan();
    }

    public void init(Context context, String str, String str2, String str3) {
        ConnectBLE.getInstance().init(context, str, str2, str3);
    }

    public void setReadUUIDAndWriteUUID(String str, String str2, String str3) {
        ConnectBLE.getInstance().setReadUUIDAndWriteUUID(str, str2, str3);
    }

    public void setConnectListener(ConnectListener connectListener) {
        ConnectBLE.getInstance().setConnectListener(connectListener);
    }

    public void connect(String str) {
        ConnectBLE.getInstance().connect(str);
    }

    public void disConnect() {
        ConnectBLE.getInstance().disConnect();
    }

    public void closeBLE() {
        ConnectBLE.getInstance().closeBLE();
    }

    public void sendData(String str) {
        ConnectBLE.getInstance().sendData(str);
    }
}

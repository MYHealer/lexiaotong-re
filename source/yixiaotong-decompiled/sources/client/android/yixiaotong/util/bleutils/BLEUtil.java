package client.android.yixiaotong.util.bleutils;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BLEUtil {
    public static boolean isBluetoothLeSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }
}

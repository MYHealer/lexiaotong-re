package client.android.yixiaotong.sdk.bluetooth.utils;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import client.android.yixiaotong.sdk.utils.AndroidUtils;
import client.android.yixiaotong.sdk.utils.IntentUtils;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BluetoothUtils {
    private BluetoothUtils() {
    }

    public static void askUserToEnableBluetoothIfNeeded(Context context) {
        if (!isBluetoothLeSupported(context) || isBluetoothOn(context)) {
            return;
        }
        Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
        intent.setFlags(268435456);
        if (IntentUtils.isIntentAvailable(context, intent)) {
            context.startActivity(intent);
        }
    }

    public static void askUserToEnableBluetoothForResult(Activity activity, int i) {
        if (!isBluetoothLeSupported(activity) || isBluetoothOn(activity)) {
            return;
        }
        try {
            activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), i);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void openBluetoothActivity(Context context) {
        Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
        intent.setFlags(268435456);
        if (IntentUtils.isIntentAvailable(context, intent)) {
            context.startActivity(intent);
        }
    }

    public static BluetoothAdapter getBluetoothAdapter(Context context) {
        if (AndroidUtils.hasJellyBeanMr2()) {
            return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        }
        return BluetoothAdapter.getDefaultAdapter();
    }

    public static boolean isBluetoothLeSupported(Context context) {
        return AndroidUtils.hasJellyBeanMr2() && context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean isBluetoothOn(Context context) {
        BluetoothAdapter defaultAdapter;
        if (context == null) {
            return false;
        }
        if (AndroidUtils.hasJellyBeanMr2()) {
            defaultAdapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        } else {
            defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (defaultAdapter == null) {
            return false;
        }
        return defaultAdapter.isEnabled();
    }

    public static boolean isCloseBluetooth(Context context) {
        BluetoothAdapter defaultAdapter;
        if (context == null) {
            return false;
        }
        if (AndroidUtils.hasJellyBeanMr2()) {
            defaultAdapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        } else {
            defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (defaultAdapter == null) {
            return false;
        }
        return defaultAdapter.disable();
    }

    public static boolean isOpenBluetooth(Context context) {
        BluetoothAdapter defaultAdapter;
        if (context == null) {
            return false;
        }
        if (AndroidUtils.hasJellyBeanMr2()) {
            defaultAdapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        } else {
            defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (defaultAdapter == null) {
            return false;
        }
        return defaultAdapter.enable();
    }

    public static boolean isBond(Context context, String str) {
        BluetoothAdapter defaultAdapter;
        BluetoothDevice remoteDevice;
        if (str == null) {
            return false;
        }
        if (AndroidUtils.hasJellyBeanMr2()) {
            defaultAdapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        } else {
            defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        return (defaultAdapter == null || (remoteDevice = defaultAdapter.getRemoteDevice(str)) == null || remoteDevice.getBondState() != 12) ? false : true;
    }

    public static String getMac(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 12) {
            return str;
        }
        String[] strArr = new String[6];
        for (int i = 0; i <= 5; i++) {
            int i2 = i * 2;
            strArr[i] = str.substring(i2, i2 + 2);
        }
        String str2 = strArr[0];
        for (int i3 = 1; i3 < 6; i3++) {
            str2 = str2 + x.bQ + strArr[i3];
        }
        return str2.toUpperCase();
    }

    public static String getTrimMac(String str) {
        return TextUtils.isEmpty(str) ? str : str.replaceAll(x.bQ, "").toUpperCase();
    }

    public static String convertDeviceAddr(Context context, String str) {
        if (str.toLowerCase().startsWith("00:0E:0B".toLowerCase())) {
            return isBluetoothLeSupported(context) ? str : "00:0E:0E" + str.substring(8);
        }
        return (str.toLowerCase().startsWith("00:0E:0E".toLowerCase()) && isBluetoothLeSupported(context)) ? "00:0E:0B" + str.substring(8) : str;
    }
}

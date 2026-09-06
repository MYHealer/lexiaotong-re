package client.android.yixiaotong.sdk.utils;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class DeviceUtils {
    public static int getSDKVersionInt() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean hasFroyo() {
        return true;
    }

    public static boolean hasGingerbread() {
        return true;
    }

    public static boolean hasHoneycomb() {
        return true;
    }

    public static boolean hasHoneycombMR1() {
        return true;
    }

    public static boolean hasICS() {
        return true;
    }

    public static boolean hasJellyBean() {
        return true;
    }

    public static boolean hasJellyBeanMr1() {
        return true;
    }

    public static boolean hasJellyBeanMr2() {
        return true;
    }

    public static boolean hasKitkat() {
        return true;
    }

    public static String getSDKVersion() {
        return Build.VERSION.SDK;
    }

    public static boolean isZte() {
        return getDeviceModel().toLowerCase().indexOf("zte") != -1;
    }

    public static boolean isSamsung() {
        return getManufacturer().toLowerCase().indexOf("samsung") != -1;
    }

    public static boolean isHTC() {
        return getManufacturer().toLowerCase().indexOf("htc") != -1;
    }

    public static boolean isDevice(String... strArr) {
        String deviceModel = getDeviceModel();
        if (strArr != null && deviceModel != null) {
            for (String str : strArr) {
                if (deviceModel.indexOf(str) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getDeviceModel() {
        return StringUtils.trim(Build.MODEL);
    }

    public static String getManufacturer() {
        return StringUtils.trim(Build.MANUFACTURER);
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static boolean isHoneycombTablet(Context context) {
        return hasHoneycomb() && isTablet(context);
    }

    public static int dipToPX(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static String getCpuInfo() {
        try {
            if (!new File("/proc/cpuinfo").exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            String line = bufferedReader.readLine();
            bufferedReader.close();
            return line != null ? line.split(x.bQ)[1].trim().split(PPSLabelView.Code)[0] : line;
        } catch (IOException | Exception unused) {
            return "";
        }
    }

    public static boolean isSupportCameraLedFlash(PackageManager packageManager) {
        FeatureInfo[] systemAvailableFeatures;
        if (packageManager != null && (systemAvailableFeatures = packageManager.getSystemAvailableFeatures()) != null) {
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                if (featureInfo != null && "android.hardware.camera.flash".equals(featureInfo.name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSupportCameraHardware(Context context) {
        return context != null && context.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    public static int getScreenWidth(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static int getScreenHeight(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static String getDeviceId(Context context) {
        String deviceId;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return (telephonyManager == null || (deviceId = telephonyManager.getDeviceId()) == null) ? "null" : deviceId;
    }

    public static String getIMSI(Context context) {
        String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        return subscriberId == null ? "" : subscriberId;
    }
}

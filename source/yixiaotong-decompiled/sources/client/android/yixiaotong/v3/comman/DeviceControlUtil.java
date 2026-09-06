package client.android.yixiaotong.v3.comman;

import client.android.yixiaotong.util.StringUtils;
import com.unionpay.tsmservice.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceControlUtil {
    private static final String TAG = "DeviceControlUtil";

    public static int getTypeId(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        if (deviceInfo != null) {
            return deviceInfo.typeId;
        }
        return 0;
    }

    public static int getValves(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        if (deviceInfo != null) {
            return deviceInfo.valves;
        }
        return 1;
    }

    public static boolean isShiDevice(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        return (deviceInfo == null || deviceInfo.belong != 1 || deviceInfo.typeId == 0) ? false : true;
    }

    public static boolean isShiBLEDevice(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        return deviceInfo != null && deviceInfo.belong == 1 && deviceInfo.alise == 1;
    }

    public static boolean isLiDeviceAndUnTransfereed(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        return (deviceInfo == null || deviceInfo.belong != 0 || deviceInfo.isNeedTransfereed) ? false : true;
    }

    public static int getModeForLi(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        if (deviceInfo == null || deviceInfo.belong != 0) {
            return 0;
        }
        return deviceInfo.mode;
    }

    public static boolean isUnNeedCheckImeiForLi(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        return (deviceInfo == null || deviceInfo.belong != 0 || deviceInfo.isNeedCheckIMEI) ? false : true;
    }

    public static boolean is4GDeviceForLi(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        return deviceInfo != null && deviceInfo.belong == 0 && deviceInfo.alise == 4;
    }

    public static boolean isHasScreenForLi(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        return deviceInfo != null && deviceInfo.belong == 0 && deviceInfo.hasScreen;
    }

    public static int sdkTypeForLi(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        if (deviceInfo == null || deviceInfo.belong != 0) {
            return 0;
        }
        return deviceInfo.sdkType;
    }

    public static boolean isNeedSetPValue(String str) {
        return StringUtils.isNotEmpty(str) && str.length() == 5 && str.substring(0, 2).equals("06") && (str.substring(3).equals("61") || str.substring(3).equals(Constant.TRANS_TYPE_CASH_LOAD));
    }

    public static boolean isAuthTotalMoney(String str, String str2) {
        DeviceBean deviceInfo = DeviceTypeVersionController.getInstance().getDeviceInfo(str, str2);
        return deviceInfo != null && deviceInfo.belong == 0 && deviceInfo.totalMoney == 1;
    }

    public static int isLiBLEDevice(String str, String str2) {
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("00")) {
            return 1;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("01")) {
            return 1;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("02")) {
            return 1;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("03")) {
            return 6;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("04")) {
            return 3;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("07")) {
            return 16;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("05")) {
            return 8;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("08")) {
            return 9;
        }
        if (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("06")) {
            return 1;
        }
        return (str.equalsIgnoreCase("00") && str2.equalsIgnoreCase("03")) ? 1 : 0;
    }
}

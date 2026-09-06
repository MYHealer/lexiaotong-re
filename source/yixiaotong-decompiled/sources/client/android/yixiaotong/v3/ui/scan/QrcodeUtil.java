package client.android.yixiaotong.v3.ui.scan;

import client.android.yixiaotong.util.BathUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.comman.DeviceControlUtil;
import client.android.yixiaotong.v3.comman.DeviceTypeVersionController;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class QrcodeUtil {
    public static boolean isBluetoothDevice(String str) {
        String[] strArrSplit = str.split("\\?");
        if (strArrSplit.length == 1) {
            if (str.length() >= 30) {
                return DeviceControlUtil.getTypeId(BathUtil.receivedResult(str.substring(26, 28), str.substring(16, 18), str.substring(18, 20)), BathUtil.receivedResult(str.substring(28, 30), str.substring(16, 18), str.substring(18, 20))) == 0 || !str.substring(12, 14).equalsIgnoreCase("A5");
            }
            return false;
        }
        String str2 = strArrSplit[1];
        if (str2.length() >= 30) {
            return DeviceControlUtil.getTypeId(BathUtil.receivedResult(str2.substring(26, 28), str2.substring(16, 18), str2.substring(18, 20)), BathUtil.receivedResult(str2.substring(28, 30), str2.substring(16, 18), str2.substring(18, 20))) == 0 || !str2.substring(12, 14).equalsIgnoreCase("A5");
        }
        return false;
    }

    public static String getMac(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 1; i <= 5; i++) {
            sb.insert(((i * 2) + i) - 1, x.bQ);
        }
        return sb.toString();
    }

    public static boolean isNBor4GDevice(String str, int i) {
        String str2;
        if (str.contains("?")) {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length > 1) {
                str = strArrSplit[1];
            }
        }
        if (!StringUtils.isNotEmpty(str) || str.length() < 52 || !str.substring(12, 14).equalsIgnoreCase("A5")) {
            return false;
        }
        String strReceivedResult = BathUtil.receivedResult(str.substring(26, 28), str.substring(16, 18), str.substring(18, 20));
        if (i == 1) {
            str2 = "01";
        } else if (i == 6) {
            str2 = "02";
        } else if (i == 8) {
            str2 = "03";
        } else if (i == 3) {
            str2 = "04";
        } else {
            str2 = i == 16 ? "05" : "00";
        }
        return strReceivedResult.equals(str2);
    }

    public static boolean isNBor4GDevice(String str) {
        if (str.contains("?")) {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length > 1) {
                str = strArrSplit[1];
            }
        }
        if (!StringUtils.isNotEmpty(str) || str.length() < 52 || !str.substring(12, 14).equalsIgnoreCase("A5")) {
            return false;
        }
        String strReceivedResult = BathUtil.receivedResult(str.substring(26, 28), str.substring(16, 18), str.substring(18, 20));
        return strReceivedResult.equals("01") || strReceivedResult.equals("02") || strReceivedResult.equals("03") || strReceivedResult.equals("04") || strReceivedResult.equals("05") || strReceivedResult.equals(DeviceTypeVersionController.Bluetooth_Device_Ver_DM1);
    }

    public static boolean isNBor4GDeviceV4(String str) {
        if (str.contains("?")) {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length > 1) {
                str = strArrSplit[1];
            }
        }
        return StringUtils.isNotEmpty(str) && str.length() >= 52 && str.substring(12, 14).equalsIgnoreCase("A5");
    }

    public static String getSubQrcode(String str) {
        if (!StringUtils.isNotEmpty(str) || !str.contains("?")) {
            return str;
        }
        String[] strArrSplit = str.split("\\?");
        return strArrSplit.length > 1 ? strArrSplit[1] : str;
    }

    public static boolean isMacIllegal(String str) {
        if (str.equalsIgnoreCase("00:00:00:00:00:00")) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < '0' || str.charAt(i) > '9') && ((str.charAt(i) < 'A' || str.charAt(i) > 'F') && ((str.charAt(i) < 'a' || str.charAt(i) > 'f') && str.charAt(i) != ':'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumberIllegal(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumberLetterIllegal(String str) {
        if (!StringUtils.isNotEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < '0' || str.charAt(i) > ':') && (str.charAt(i) < 'A' || str.charAt(i) > 'F')) {
                return false;
            }
        }
        return true;
    }
}

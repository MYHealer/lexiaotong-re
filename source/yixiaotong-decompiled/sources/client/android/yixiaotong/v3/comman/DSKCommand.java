package client.android.yixiaotong.v3.comman;

import client.android.yixiaotong.sdk.utils.RandomUtil;
import com.lxt.bluetoothsdk.utils.StringUtils;
import com.unionpay.tsmservice.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DSKCommand {
    public static String getCollectData(String str, String str2) {
        StringBuilder sb = new StringBuilder("5A");
        sb.append(str.toUpperCase());
        sb.append("FFFFFFFFFFFF1212");
        if (str2.equals("0")) {
            sb.append("FFFFFFFF");
        } else {
            sb.append(getLenString(str2, 8));
        }
        sb.append(RandomUtil.getRandNumMaxString(12));
        sb.append("FFFFFF");
        sb.append(RandomUtil.getRandNumMaxString(4));
        sb.append(NBDeviceCommand.sumCheckCode(sb.toString()));
        return sb.toString().toUpperCase();
    }

    public static String getSetButtonCommand(String str, String str2) {
        StringBuilder sb = new StringBuilder("5AFFFFFFFFFFFF1F1F");
        sb.append(str);
        sb.append(RandomUtil.getRandNumMaxString(12));
        sb.append(str2);
        sb.append("FFFF");
        sb.append(RandomUtil.getRandNumMaxString(4));
        sb.append(NBDeviceCommand.sumCheckCode(sb.toString()));
        return sb.toString().toUpperCase();
    }

    private static String intToHexString(int i) {
        String hexString = Integer.toHexString(i);
        if (hexString.length() == 1) {
            return "0000000" + hexString;
        }
        if (hexString.length() == 2) {
            return "000000" + hexString;
        }
        if (hexString.length() == 3) {
            return "00000" + hexString;
        }
        if (hexString.length() == 4) {
            return "0000" + hexString;
        }
        if (hexString.length() == 5) {
            return Constant.DEFAULT_CVN2 + hexString;
        }
        if (hexString.length() == 6) {
            return "00" + hexString;
        }
        return hexString.length() == 7 ? "0" + hexString : hexString;
    }

    public static String getLenString(String str, int i) {
        if (!StringUtils.isNotEmpty(str) || str.length() >= i) {
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < i - str.length(); i2++) {
            str2 = str2 + "0";
        }
        return str2 + str;
    }
}

package client.android.yixiaotong.v4.ui.user;

import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4RegisterQrcodeControl {
    private static final String CUSTOMERID = "customerid=";
    private static final String CUSTOMERNAME = "customername=";
    private static final String TAG = "V4RegisterQrcodeControl";

    public static String isV4CustomerQrcode(String str) {
        String strSubstring = "";
        if (StringUtils.isNotEmpty(str) && str.toLowerCase().contains(CUSTOMERID)) {
            String[] strArrSplit = str.split("\\&");
            if (strArrSplit != null && strArrSplit.length > 1) {
                for (int i = 0; i < strArrSplit.length; i++) {
                    LogUtil.e(TAG, strArrSplit[i] + PPSLabelView.Code + strArrSplit.length);
                    if (strArrSplit[i].toLowerCase().contains(CUSTOMERID)) {
                        String str2 = strArrSplit[i];
                        strSubstring = str2.substring(str2.indexOf("=") + 1);
                        LogUtil.e(TAG, "isV4Qrcode:" + strSubstring + "  " + strArrSplit[i].indexOf("="));
                    }
                }
            }
            if (StringUtils.isNotEmpty(strSubstring)) {
            }
        }
        return strSubstring;
    }

    public static String isV4CustomerNameByQrcode(String str) {
        String strSubstring = "";
        if (StringUtils.isNotEmpty(str) && str.toLowerCase().contains(CUSTOMERNAME)) {
            String[] strArrSplit = str.split("\\&");
            if (strArrSplit != null && strArrSplit.length > 1) {
                for (int i = 0; i < strArrSplit.length; i++) {
                    LogUtil.e(TAG, strArrSplit[i] + PPSLabelView.Code + strArrSplit.length);
                    if (strArrSplit[i].toLowerCase().contains(CUSTOMERNAME)) {
                        String str2 = strArrSplit[i];
                        strSubstring = str2.substring(str2.indexOf("=") + 1);
                        LogUtil.e(TAG, "isV4CustomerNameByQrcode:" + strSubstring + "  " + strArrSplit[i].indexOf("="));
                    }
                }
            }
            if (StringUtils.isNotEmpty(strSubstring)) {
            }
        }
        return strSubstring;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    public static String isV4DeviceQrcode(String str) {
        String str2;
        if (str.contains("?")) {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length <= 1 || strArrSplit[1].length() < 52) {
                str2 = "";
            } else {
                str2 = strArrSplit[1];
            }
        } else {
            str2 = "";
        }
        return (StringUtils.isNotEmpty(str2) && str2.length() >= 52 && str2.substring(12, 14).equalsIgnoreCase("A5")) ? str2.substring(34, 50) : "";
    }
}

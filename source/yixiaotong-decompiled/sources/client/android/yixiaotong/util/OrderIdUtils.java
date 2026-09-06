package client.android.yixiaotong.util;

import client.android.yixiaotong.util.random.RandomUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class OrderIdUtils {
    public static String getOrderID(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 1) {
            sb.append("XZC");
        } else if (i == 2) {
            sb.append("GWC");
        } else if (i == 3) {
            sb.append("XYC");
        } else if (i == 4) {
            sb.append("QTC");
        } else if (i == 5) {
            sb.append("YCC");
        } else if (i == 6) {
            sb.append("YSC");
        } else if (i == 7) {
            sb.append("CDC");
        } else {
            sb.append("XXX");
        }
        sb.append(getLocalDate(TimeUtils.FORMATDATETIME1));
        sb.append("_");
        sb.append(RandomUtils.getRandNumMaxStringNonO(6));
        return sb.toString().trim().toUpperCase();
    }

    public static String getWaterOrderID(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 1) {
            sb.append("XZP");
        } else if (i == 2) {
            sb.append("GWP");
        } else if (i == 3) {
            sb.append("XYP");
        } else if (i == 4) {
            sb.append("QTP");
        } else if (i == 5) {
            sb.append("YCP");
        } else if (i == 6) {
            sb.append("YSP");
        } else if (i == 7) {
            sb.append("CDP");
        } else if (i == 8) {
            sb.append("CFP");
        } else if (i == 16) {
            sb.append("GYP");
        } else {
            sb.append("XXP");
        }
        sb.append(getLocalDate(TimeUtils.FORMATDATETIME1));
        sb.append("_");
        sb.append(RandomUtils.getRandNumMaxStringNonO(6));
        return sb.toString().trim().toUpperCase();
    }

    public static String getAmmeterOrderID(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 1) {
            sb.append("XZN");
        } else if (i == 2) {
            sb.append("GWN");
        } else if (i == 3) {
            sb.append("XYN");
        } else if (i == 4) {
            sb.append("QTN");
        } else if (i == 5) {
            sb.append("YCN");
        } else if (i == 6) {
            sb.append("YSN");
        } else if (i == 7) {
            sb.append("CDN");
        } else {
            sb.append("XXN");
        }
        sb.append(getLocalDate(TimeUtils.FORMATDATETIME1));
        sb.append("_");
        sb.append(RandomUtils.getRandNumMaxStringNonO(6));
        return sb.toString().trim().toUpperCase();
    }

    public static String getLocalDate(String str) {
        return new SimpleDateFormat(str).format(new Date());
    }
}

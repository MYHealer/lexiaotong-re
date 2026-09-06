package client.android.yixiaotong.util.drinkwater;

import client.android.yixiaotong.util.TimeUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ParseUtil {
    public static double mul(String str) {
        return new BigDecimal(str).doubleValue();
    }

    public static double parseDouble(int i) {
        return new BigDecimal(i).doubleValue();
    }

    public static int parseFen(String str) {
        return new BigDecimal(str).multiply(new BigDecimal(100.0d)).intValue();
    }

    public static BigDecimal parseYuan(String str) {
        return new BigDecimal(str).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
    }

    public static String millisToData(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtils.FORMATDATETIME);
        long jLongValue = Long.valueOf(str).longValue();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jLongValue);
        return simpleDateFormat.format(calendar.getTime());
    }
}

package client.android.yixiaotong.v4.util.comman;

import client.android.yixiaotong.util.BathUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4DeviceInfoUtil {
    private static final Set<String> PULSE_POOL;
    private static final String TAG = "V4DeviceInfoUtil";

    static {
        HashSet hashSet = new HashSet();
        PULSE_POOL = hashSet;
        hashSet.add("xxxx");
    }

    public static boolean contains(String str) {
        return PULSE_POOL.contains(str.replace(",", "").toUpperCase());
    }

    public static boolean isHasOrder(String str) {
        String byteState = getByteState(str);
        LogUtil.e(TAG, "isHasOrder:" + byteState);
        return StringUtils.isNotEmpty(byteState) && byteState.length() >= 8 && byteState.substring(6, 7).equals("1");
    }

    public static String getByteState(String str) {
        return (!StringUtils.isNotEmpty(str) || str.length() <= 22) ? "" : StringUtils.getByteString(Integer.toBinaryString(Integer.parseInt(getHexState(str), 16)));
    }

    public static String getHexState(String str) {
        return (!StringUtils.isNotEmpty(str) || str.length() <= 22) ? "" : BathUtil.receivedResult(str.substring(20, 22), str.substring(4, 6), str.substring(6, 8));
    }
}

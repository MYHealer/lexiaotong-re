package client.android.yixiaotong.util;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ClickUtils {
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - lastClickTime;
        if (0 < j && j < 800) {
            return true;
        }
        lastClickTime = jCurrentTimeMillis;
        return false;
    }
}

package client.android.yixiaotong.sdk.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class VersionUtil {
    public static boolean IsSmallAppVersion(String str) {
        if (str.startsWith("55") && str.length() == 40 && !str.startsWith("550001")) {
            return true;
        }
        return (str.length() == 18 && str.toUpperCase().startsWith("AA")) || str.toUpperCase().equals("A5") || str.toUpperCase().equals("AC");
    }
}

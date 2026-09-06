package client.android.yixiaotong.sdk.utils;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class LocalBusinessStore {
    public static void saveOfflineCount(Context context, long j, int i) {
        new LocalPreferencesHelper(context, "OfflineCount_" + j).saveOrUpdate("OfflineCount", i);
    }

    public static int getOfflineCount(Context context, long j) {
        return new LocalPreferencesHelper(context, "OfflineCount_" + j).getInt("OfflineCount");
    }

    public static void saveVersion(Context context, String str, int i) {
        new LocalPreferencesHelper(context, "bathversion_" + str).saveOrUpdate("bathversion", i);
    }

    public static int getVersion(Context context, String str) {
        return new LocalPreferencesHelper(context, "bathversion_" + str).getInt("bathversion");
    }

    public static void saveRand(Context context, String str) {
        new LocalPreferencesHelper(context, "rand").saveOrUpdate("rand", str);
    }

    public static String getRand(Context context) {
        return new LocalPreferencesHelper(context, "rand").getString("rand");
    }
}

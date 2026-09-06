package com.hihonor.adsdk.common.video.h;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String hnadsa = "PlayerLoadStrategy";
    private static final int hnadsb = 2016000;
    private static final int hnadsc = -1;
    public static final int hnadsd = 1;
    public static final int hnadse = 2;
    public static final int hnadsf = 3;
    private static int hnadsg = -1;
    private static final String hnadsh = "com.google.android.exoplayer2.ExoPlayerLibraryInfo";
    private static final String hnadsi = "androidx.media3.common.MediaLibraryInfo";

    public static com.hihonor.adsdk.common.video.a hnadsa(Context context) {
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "loadPlayer context is null", new Object[0]);
            return null;
        }
        int iHnadsb = hnadsb();
        hnadsg = iHnadsb;
        if (iHnadsb == 2) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "loadPlayer load exo", new Object[0]);
            return new com.hihonor.adsdk.common.video.exo.c.a(context);
        }
        if (iHnadsb == 3) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "loadPlayer load exo androidx", new Object[0]);
            return new com.hihonor.adsdk.common.video.exo.b.a(context);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "loadPlayer load media", new Object[0]);
        return new b(context);
    }

    private static boolean hnadsc() {
        return hnadsa(hnadsi) != -1;
    }

    private static boolean hnadsd() {
        return hnadsa(hnadsh) >= hnadsb;
    }

    public static boolean hnadse() {
        int iHnadsb = hnadsb();
        hnadsg = iHnadsb;
        return iHnadsb == 2 || iHnadsb == 3;
    }

    public static int hnadsb() {
        if (hnadsg == -1) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getPlayerType need check", new Object[0]);
            hnadsg = hnadsa();
        }
        return hnadsg;
    }

    public static boolean hnadsa(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "checkCurrentPlayerType newPlayerType = " + i, new Object[0]);
        if (i == 1 || ((i == 2 && hnadsd()) || (i == 3 && hnadsc()))) {
            hnadsg = i;
            return true;
        }
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "setCurrentType fail currentPlayerType " + hnadsa(), new Object[0]);
        return false;
    }

    private static int hnadsa() {
        if (hnadsd()) {
            return 2;
        }
        return hnadsc() ? 3 : 1;
    }

    private static int hnadsa(String str) {
        try {
            Object obj = Class.forName(str).getDeclaredField("VERSION_INT").get(null);
            if (obj == null) {
                return -1;
            }
            int iIntValue = ((Integer) obj).intValue();
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getExoVersion className = " + str + " version = " + iIntValue, new Object[0]);
            return iIntValue;
        } catch (Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getExoVersion error msg :" + th.getMessage(), new Object[0]);
            return -1;
        }
    }
}

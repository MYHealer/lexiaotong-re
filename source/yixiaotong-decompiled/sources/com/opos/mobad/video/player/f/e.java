package com.opos.mobad.video.player.f;

import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f8402a = true;

    public static void a(boolean z) {
        f8402a = z;
    }

    public static boolean a(AdItemData adItemData) {
        com.opos.cmn.an.f.a.b("WifiPlayUtils", "sPlayRemindAtCellular=" + f8402a);
        boolean z = true;
        try {
            if (!f8402a) {
                z = false;
            } else if (adItemData != null && !adItemData.v()) {
                f8402a = false;
                z = false;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("WifiPlayUtils", "", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("WifiPlayUtils", "checkPlayConfirm=" + z);
        return z;
    }
}

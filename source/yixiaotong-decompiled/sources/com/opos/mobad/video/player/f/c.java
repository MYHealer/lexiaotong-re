package com.opos.mobad.video.player.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {
    public static boolean a(int i) {
        com.opos.cmn.an.f.a.b("AdShowControllerUtils", "canShowFallbackVideo actionType=", Integer.valueOf(i));
        return i == 1;
    }

    public static boolean a(int i, String str, String str2) {
        com.opos.cmn.an.f.a.b("AdShowControllerUtils", "canShowFallbackVideo code=", Integer.valueOf(i), ", msg=", str);
        if (com.opos.mobad.j.a.a.a(i, str2) == i) {
            return false;
        }
        com.opos.cmn.an.f.a.b("AdShowControllerUtils", "canShowFallbackVideo");
        return true;
    }
}

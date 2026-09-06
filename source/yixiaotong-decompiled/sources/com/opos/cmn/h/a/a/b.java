package com.opos.cmn.h.a.a;

import com.tencent.mm.opensdk.openapi.IWXAPI;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    public static boolean a() {
        try {
            com.opos.cmn.an.f.a.b("Utils", "wx openSdk check class:" + IWXAPI.class.getCanonicalName());
            return true;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("Utils", "Not find wx openSdk!", th);
            return false;
        }
    }
}

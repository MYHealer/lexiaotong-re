package com.opos.mobad.l;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f7122a;
    private static final byte[] b = new byte[0];

    public static b a(Context context, a aVar) {
        b bVarA;
        if (context == null || aVar == null) {
            bVarA = null;
        } else {
            a();
            try {
                bVarA = f7122a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), aVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadTool", "download", (Throwable) e);
                bVarA = null;
            }
        }
        com.opos.cmn.an.f.a.b("DownloadTool", "download request=", aVar, "response=", bVarA);
        return bVarA;
    }

    private static void a() {
        if (f7122a == null) {
            synchronized (b) {
                if (f7122a == null) {
                    f7122a = new com.opos.mobad.l.a.a();
                }
            }
        }
    }
}

package com.meishu.sdk.core.webview.jsbridge;

import com.google.gson.Gson;
import com.meishu.sdk.core.utils.u;
import com.meishu.sdk.platform.ms.c;

/* JADX INFO: compiled from: OpenWebViewPage.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.core.webview.jsbridge.bean.a f4983a;
    public final c b;

    public b(c cVar) {
        this.b = cVar;
        if (cVar != null) {
            try {
                if (cVar.a() != null) {
                    Gson gson = u.f4948a;
                    this.f4983a = (com.meishu.sdk.core.webview.jsbridge.bean.a) gson.fromJson(gson.toJson(cVar.a()), com.meishu.sdk.core.webview.jsbridge.bean.a.class);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String a(boolean z, String str) {
        return "{\"open_status\":" + z + ",\"msg\":\"" + str + "\"}";
    }
}

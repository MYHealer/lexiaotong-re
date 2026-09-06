package com.opos.cmn.biz.web.c.b;

import android.content.Context;
import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f6053a;
    protected boolean b = false;
    protected boolean c;
    protected String d;

    public a(Context context, String str, boolean z) {
        this.f6053a = context;
        this.d = str;
        this.c = z;
    }

    @JavascriptInterface
    public boolean init(String str) {
        if (!this.b) {
            try {
                if (this.c) {
                    String str2 = this.d;
                    com.opos.cmn.an.f.a.b("JSCommonEngine", "src=" + (str != null ? str : "null") + "jsSign=" + str2);
                    if (!com.opos.cmn.an.d.a.a(str) && str.equals(str2)) {
                    }
                } else {
                    com.opos.cmn.an.f.a.c("JSCommonEngine", "forceJsInit=false.");
                }
                this.b = true;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSCommonEngine", "", e);
            }
        }
        StringBuilder sb = new StringBuilder("init src=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("JSCommonEngine", sb.append(str).append(",result=").append(this.b).toString());
        return this.b;
    }
}

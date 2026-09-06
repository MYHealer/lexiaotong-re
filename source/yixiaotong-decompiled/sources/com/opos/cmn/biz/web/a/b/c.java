package com.opos.cmn.biz.web.a.b;

import android.content.Context;
import android.webkit.WebResourceResponse;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements com.opos.cmn.biz.web.a.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f6040a = new byte[0];
    private static volatile c b;
    private com.opos.cmn.biz.web.a.a.a c = new com.opos.cmn.biz.web.a.a.b();

    private c() {
    }

    public static c a() {
        if (b == null) {
            synchronized (f6040a) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public WebResourceResponse a(String str) {
        return this.c.a(str);
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(Context context, b bVar) throws Exception {
        if (context == null || bVar == null) {
            throw new Exception("init params error");
        }
        this.c.a(context, bVar);
    }

    @Override // com.opos.cmn.biz.web.a.a.a
    public void a(List<a> list) {
        this.c.a(list);
    }
}

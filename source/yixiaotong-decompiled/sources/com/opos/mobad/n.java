package com.opos.mobad;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.cmn.func.adhandler.UnlockHandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n extends o {
    public n(Context context, int i) {
        super(new t(), new g(), new com.opos.mobad.activity.webview.a() { // from class: com.opos.mobad.n.1
            @Override // com.opos.mobad.activity.webview.a
            public com.opos.mobad.activity.webview.a.b a(Activity activity, com.opos.cmn.biz.web.c.b.c cVar, com.opos.mobad.activity.webview.b.b bVar) {
                return new com.opos.mobad.activity.webview.a.b(activity, cVar, bVar);
            }
        }, new q(), new UnlockHandler(context));
    }
}

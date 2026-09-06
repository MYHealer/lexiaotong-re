package com.opos.mobad.provider.openId;

import android.content.Context;
import android.text.TextUtils;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class IdModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.openId.IdModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IdModel getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            IdModelIdentify idModelIdentify = (IdModelIdentify) iBridgeTargetIdentify;
            return IdModel.b(StubApp.getOrigApplicationContext(context.getApplicationContext()), idModelIdentify.f7266a, idModelIdentify.b);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile IdModel f7265a;
    private Context b;
    private boolean c;
    private String d;
    private b e;

    private IdModel(Context context, boolean z, String str) {
        this.b = context;
        this.c = z;
        this.d = str;
        this.e = new b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IdModel b(Context context, boolean z, String str) {
        if (f7265a == null) {
            synchronized (IdModel.class) {
                if (f7265a == null) {
                    f7265a = new IdModel(context, z, str);
                }
            }
        }
        return f7265a;
    }

    @BridgeMethod
    public OpenIdData a() {
        String strB = com.opos.cmn.g.a.b.b(this.b);
        String strA = com.opos.cmn.g.a.b.a(this.b);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        String strC = com.opos.cmn.an.f.a.b(this.b) ? null : com.opos.cmn.g.a.b.c(this.b);
        com.opos.cmn.an.f.a.b("", "readOpenId");
        return new OpenIdData(strA, strB, strC);
    }

    @BridgeMethod
    public boolean b() {
        return com.opos.cmn.g.a.b.g(this.b);
    }

    @BridgeMethod
    public String c() {
        return "";
    }

    @BridgeMethod
    public OpenIdData d() {
        String strA = this.e.a();
        String strB = this.e.b();
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        com.opos.cmn.an.f.a.b("", "readOutOpenId");
        return new OpenIdData(strA, strB, "");
    }

    @BridgeMethod
    public OutOpenIdWrapper e() {
        return new OutOpenIdWrapper(b.f7268a.a());
    }

    @BridgeMethod
    public boolean f() {
        return com.opos.cmn.g.a.b.e(this.b);
    }

    @BridgeMethod
    public boolean g() {
        return this.e.c();
    }
}

package com.yfanads.android.oaid.impl;

import android.content.Context;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: XiaomiImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class u implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9676a;
    public final Class<?> b;
    public final Object c;

    public u(Context context) {
        this.f9676a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            YFLog.debug(e);
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        return this.c != null;
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9676a != null) {
            Class<?> cls = this.b;
            if (cls != null && this.c != null) {
                try {
                    String str = (String) cls.getMethod("getOAID", Context.class).invoke(this.c, this.f9676a);
                    if (str != null && str.length() != 0) {
                        YFLog.debug("OAID query success: ".concat(str));
                        aVar.onOAIDGetSuccess(str);
                        return;
                    }
                    throw new com.yfanads.android.oaid.a("OAID query failed");
                } catch (Exception e) {
                    YFLog.debug(e);
                    aVar.onOAIDGetFail(e);
                    return;
                }
            }
            aVar.onOAIDGetFail(new com.yfanads.android.oaid.a("Xiaomi IdProvider not exists"));
        }
    }
}

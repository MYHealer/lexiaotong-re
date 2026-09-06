package com.meishu.sdk.core.oaid.impl;

import android.content.Context;
import com.meishu.sdk.core.oaid.OAIDException;

/* JADX INFO: compiled from: XiaomiImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4843a;
    public Class<?> b;
    public Object c;

    public q(Context context) {
        this.f4843a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        return this.c != null;
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4843a == null || aVar == null) {
            return;
        }
        Class<?> cls = this.b;
        if (cls != null && this.c != null) {
            try {
                String str = (String) cls.getMethod("getOAID", Context.class).invoke(this.c, this.f4843a);
                if (str != null && str.length() != 0) {
                    ((com.meishu.sdk.core.utils.l) aVar).a(str);
                    return;
                }
                throw new OAIDException("OAID query failed");
            } catch (Exception e) {
                ((com.meishu.sdk.core.utils.l) aVar).a(e);
                return;
            }
        }
        ((com.meishu.sdk.core.utils.l) aVar).a(new OAIDException("Xiaomi IdProvider not exists"));
    }
}

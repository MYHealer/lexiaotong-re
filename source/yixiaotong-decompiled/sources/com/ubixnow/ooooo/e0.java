package com.ubixnow.ooooo;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e0 implements j {
    private final Context OooO00o;
    private Class<?> OooO0O0;
    private Object OooO0OO;

    public e0(Context context) {
        this.OooO00o = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.OooO0O0 = cls;
            this.OooO0OO = cls.newInstance();
        } catch (Exception e) {
            l.OooO00o(e);
        }
    }

    private String OooO0O0() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.OooO0O0.getMethod("getOAID", Context.class).invoke(this.OooO0OO, this.OooO00o);
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        if (this.OooO00o == null || iVar == null) {
            return;
        }
        if (this.OooO0O0 == null || this.OooO0OO == null) {
            iVar.OooO00o(new k("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strOooO0O0 = OooO0O0();
            if (strOooO0O0 == null || strOooO0O0.length() == 0) {
                throw new k("OAID query failed");
            }
            l.OooO00o("OAID query success: " + strOooO0O0);
            iVar.OooO00o(strOooO0O0);
        } catch (Exception e) {
            l.OooO00o(e);
            iVar.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        return this.OooO0OO != null;
    }
}

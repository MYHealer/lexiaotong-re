package com.ubixnow.ooooo;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class h implements i {
    private Application OooO00o;
    private String OooO0O0;

    public static /* synthetic */ class OooO00o {
    }

    public static class OooO0O0 {
        public static final h OooO00o = new h(null);

        private OooO0O0() {
        }
    }

    private h() {
    }

    public /* synthetic */ h(OooO00o oooO00o) {
        this();
    }

    public static String OooO00o() {
        String str = OooO0O0.OooO00o.OooO0O0;
        return str == null ? "" : str;
    }

    public static void OooO00o(Context context, i iVar) {
        z.OooO00o(context).OooO00o(iVar);
    }

    public static boolean OooO00o(Context context) {
        return z.OooO00o(context).OooO00o();
    }

    @Override // com.ubixnow.ooooo.i
    public void OooO00o(String str) {
        if (TextUtils.isEmpty(str)) {
            OooO00o(new k("OAID is empty"));
        } else {
            this.OooO0O0 = str;
        }
    }

    @Override // com.ubixnow.ooooo.i
    public void OooO00o(Throwable th) {
    }
}

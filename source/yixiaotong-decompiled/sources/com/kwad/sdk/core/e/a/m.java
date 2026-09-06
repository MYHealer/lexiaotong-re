package com.kwad.sdk.core.e.a;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class m {
    private Context mContext;

    public m(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str;
        Exception e;
        try {
            str = (String) i.callMethod(i.newInstance("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
            try {
                com.kwad.sdk.core.d.c.i("XiaomiDeviceIDHelper", "getOAID oaid:" + str);
            } catch (Exception e2) {
                e = e2;
                com.kwad.sdk.core.d.c.i("XiaomiDeviceIDHelper", "getOAID fail");
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        } catch (Exception e3) {
            str = "";
            e = e3;
        }
        return str;
    }
}

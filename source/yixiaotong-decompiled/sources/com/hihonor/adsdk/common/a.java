package com.hihonor.adsdk.common;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private Context hnadsa;

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.a$a, reason: collision with other inner class name */
    private static final class C0454a {
        private static final a hnadsa = new a();

        private C0454a() {
        }
    }

    public static a hnadsa() {
        return C0454a.hnadsa;
    }

    public void hnadsa(Context context) {
        this.hnadsa = context;
    }

    public Context hnadsb() {
        return this.hnadsa;
    }
}

package com.opos.mobad.template.g;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7821a;
    public final int b;

    public am(int i, int i2) {
        this.f7821a = i;
        this.b = i2;
    }

    public static am a(Context context) {
        int iA = com.opos.cmn.an.h.f.a.a(context, 360.0f);
        return new am(iA, (int) (((double) iA) * 0.6d));
    }
}

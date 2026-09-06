package com.opos.mobad.template.i;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i {
    public static final d a(Context context, j jVar, int i) {
        if (j.SHAKE == jVar) {
            return new q(context, i);
        }
        return j.SLIDE_UP == jVar ? new s(context, jVar, i) : new k(context, jVar);
    }

    public static final d b(Context context, j jVar, int i) {
        if (j.SHAKE == jVar) {
            return new r(context, i);
        }
        return j.SLIDE_UP == jVar ? new t(context, jVar, i) : new l(context, jVar);
    }
}

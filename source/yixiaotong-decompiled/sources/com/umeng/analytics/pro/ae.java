package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId;

/* JADX INFO: compiled from: LenovoDeviceIdSupplier.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ae implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f9095a = 1;
    private OpenDeviceId b;
    private boolean c = false;
    private boolean d = false;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.c) {
            OpenDeviceId openDeviceId = new OpenDeviceId();
            this.b = openDeviceId;
            this.d = openDeviceId.a(context, (OpenDeviceId.CallBack<String>) null) == 1;
            this.c = true;
        }
        al.a("getOAID", "isSupported", Boolean.valueOf(this.d));
        if (this.d && this.b.c()) {
            return this.b.a();
        }
        return null;
    }
}

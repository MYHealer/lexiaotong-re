package com.huawei.hms.ads;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ec {
    private final eb Code;
    private EGLSurface V;

    public ec(eb ebVar, Surface surface) {
        this.Code = ebVar;
        this.V = ebVar.Code(surface);
    }

    public void B() {
        this.Code.Code(this.V);
        this.V = EGL14.EGL_NO_SURFACE;
    }

    public int Code() {
        return this.Code.Code(this.V, 12375);
    }

    public void I() {
        this.Code.V(this.V);
    }

    public int V() {
        return this.Code.Code(this.V, 12374);
    }

    public void Z() {
        this.Code.I(this.V);
    }
}

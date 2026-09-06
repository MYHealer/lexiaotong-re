package com.ubix.ssp.ad.e.b0;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.SurfaceHolder;
import android.view.TextureView;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b implements TextureView.SurfaceTextureListener, SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SurfaceTexture f8755a;
    protected SurfaceHolder b;
    protected HandlerThread c;
    protected Handler d;
    protected Handler e;
    protected SoftReference<e> f;

    public b(e eVar) {
        this.f = new SoftReference<>(eVar);
    }

    protected abstract long a();

    protected abstract void a(float f, float f2);

    protected abstract void a(long j);

    protected abstract void a(a aVar);

    protected abstract void a(boolean z);

    protected abstract long b();

    protected abstract boolean c();

    protected abstract void d();

    protected abstract void e();
}

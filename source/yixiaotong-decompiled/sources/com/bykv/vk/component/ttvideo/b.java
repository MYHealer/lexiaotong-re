package com.bykv.vk.component.ttvideo;

import android.view.Surface;
import android.view.SurfaceHolder;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class b implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<TTVideoEngine> f2968a;

    public b(TTVideoEngine tTVideoEngine) {
        this.f2968a = new WeakReference<>(tTVideoEngine);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        TTVideoEngine tTVideoEngine = this.f2968a.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.a(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        TTVideoEngine tTVideoEngine = this.f2968a.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.a((Surface) null);
        }
    }
}

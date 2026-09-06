package com.fancy;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _j6 implements Runnable {
    public final /* synthetic */ SurfaceTexture _a;
    public final /* synthetic */ PtgCoreVideo _b;

    public _j6(PtgCoreVideo ptgCoreVideo, SurfaceTexture surfaceTexture) {
        this._b = ptgCoreVideo;
        this._a = surfaceTexture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _jb _jbVar;
        try {
            PtgCoreVideo ptgCoreVideo = this._b;
            if (ptgCoreVideo._f != null && (_jbVar = ptgCoreVideo._c) != null && _jbVar.getInfo() != null && this._a != null) {
                this._b._k = 0;
                this._b._l = 0;
                this._b.getClass();
                PtgCoreVideo ptgCoreVideo2 = this._b;
                ptgCoreVideo2._f.setDataSource(ptgCoreVideo2._c.getInfo()._a);
                Surface surface = this._b._g;
                if (surface != null) {
                    surface.release();
                }
                this._b._g = new Surface(this._a);
                PtgCoreVideo ptgCoreVideo3 = this._b;
                ptgCoreVideo3._f.setSurface(ptgCoreVideo3._g);
                this._b._f.prepareAsync();
                PtgCoreVideo ptgCoreVideo4 = this._b;
                ptgCoreVideo4._a = 1;
                ptgCoreVideo4._a(1);
            }
        } catch (Exception e) {
            Logger.e("openMediaPlayer", e.getMessage());
        }
    }
}

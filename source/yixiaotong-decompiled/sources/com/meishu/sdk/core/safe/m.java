package com.meishu.sdk.core.safe;

import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* JADX INFO: compiled from: SafeSurfaceTextureListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m implements TextureView.SurfaceTextureListener {
    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            safeOnSurfaceTextureAvailable(surfaceTexture, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        try {
            return safeOnSurfaceTextureDestroyed(surfaceTexture);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
            return false;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            safeOnSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        try {
            safeOnSurfaceTextureUpdated(surfaceTexture);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
        }
    }

    public void safeOnSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public boolean safeOnSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void safeOnSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void safeOnSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

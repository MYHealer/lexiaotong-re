package com.jd.ad.sdk.bl.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class VideoTextureView extends TextureView implements com.jd.ad.sdk.bl.video.jad_an {
    public com.jd.ad.sdk.bl.video.jad_an.InterfaceC0546jad_an jad_an;
    public SurfaceTexture jad_bo;
    public boolean jad_cp;
    public int jad_dq;
    public int jad_er;
    public Surface jad_fs;

    public static /* synthetic */ class jad_an {
    }

    public static final class jad_bo implements com.jd.ad.sdk.bl.video.jad_an.jad_bo {
        public WeakReference<Surface> jad_an;
        public WeakReference<VideoTextureView> jad_bo;

        public jad_bo(VideoTextureView videoTextureView, SurfaceTexture surfaceTexture) {
            this.jad_bo = new WeakReference<>(videoTextureView);
            this.jad_an = new WeakReference<>(new Surface(surfaceTexture));
        }
    }

    public class jad_cp implements TextureView.SurfaceTextureListener {
        public jad_cp() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public /* synthetic */ jad_cp(VideoTextureView videoTextureView, jad_an jad_anVar) {
            this();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            VideoTextureView videoTextureView = VideoTextureView.this;
            com.jd.ad.sdk.bl.video.jad_an.InterfaceC0546jad_an interfaceC0546jad_an = videoTextureView.jad_an;
            if (interfaceC0546jad_an != null) {
                jad_bo jad_boVar = new jad_bo(videoTextureView, surfaceTexture);
                VideoRenderView videoRenderView = ((com.jd.ad.sdk.bl.video.jad_bo) interfaceC0546jad_an).jad_an;
                videoRenderView.jad_jt = jad_boVar;
                MediaPlayer mediaPlayer = videoRenderView.jad_an;
                WeakReference<VideoTextureView> weakReference = jad_boVar.jad_bo;
                VideoTextureView videoTextureView2 = weakReference != null ? weakReference.get() : null;
                if (mediaPlayer == null || jad_boVar.jad_an == null || videoTextureView2 == null) {
                    return;
                }
                SurfaceTexture ownSurfaceTexture = videoTextureView2.getOwnSurfaceTexture();
                SurfaceTexture surfaceTexture2 = videoTextureView2.getSurfaceTexture();
                boolean z = false;
                boolean zIsReleased = ownSurfaceTexture != null ? ownSurfaceTexture.isReleased() : false;
                if (ownSurfaceTexture != null && !zIsReleased) {
                    z = true;
                }
                if (!videoTextureView2.jad_cp || !z) {
                    Surface surface = jad_boVar.jad_an.get();
                    if (surface != null) {
                        mediaPlayer.setSurface(surface);
                        videoTextureView2.setSurface(surface);
                        return;
                    }
                    return;
                }
                if (!ownSurfaceTexture.equals(surfaceTexture2)) {
                    videoTextureView2.setSurfaceTexture(ownSurfaceTexture);
                    return;
                }
                Surface surface2 = videoTextureView2.getSurface();
                if (surface2 != null) {
                    surface2.release();
                }
                Surface surface3 = new Surface(ownSurfaceTexture);
                mediaPlayer.setSurface(surface3);
                videoTextureView2.setSurface(surface3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            VideoTextureView videoTextureView = VideoTextureView.this;
            com.jd.ad.sdk.bl.video.jad_an.InterfaceC0546jad_an interfaceC0546jad_an = videoTextureView.jad_an;
            if (interfaceC0546jad_an != null) {
                new WeakReference(videoTextureView);
                new WeakReference(new Surface(surfaceTexture));
                ((com.jd.ad.sdk.bl.video.jad_bo) interfaceC0546jad_an).jad_an.jad_jt = null;
            }
            VideoTextureView videoTextureView2 = VideoTextureView.this;
            boolean z = videoTextureView2.jad_cp;
            if (z) {
                videoTextureView2.jad_bo = surfaceTexture;
            }
            return !z;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            VideoTextureView videoTextureView = VideoTextureView.this;
            if (videoTextureView.jad_an != null) {
                new WeakReference(videoTextureView);
                new WeakReference(new Surface(surfaceTexture));
            }
        }
    }

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public SurfaceTexture getOwnSurfaceTexture() {
        return this.jad_bo;
    }

    public View getRenderView() {
        return this;
    }

    public Surface getSurface() {
        return this.jad_fs;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        float f;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.jad_dq > 0 && this.jad_er > 0) {
            if (mode == 0 || mode2 == 0) {
                if (mode == 0) {
                    i = (int) (size2 * 0.5625f);
                } else if (mode2 == 0) {
                    f = size;
                    i2 = (int) (f / 0.5625f);
                    i = size;
                } else {
                    i = size;
                }
                i2 = size2;
            } else {
                f = size;
                float f2 = size2;
                if (f / f2 > 0.5625f) {
                    i2 = (int) (f / 0.5625f);
                    i = size;
                } else {
                    i = (int) (f2 * 0.5625f);
                    i2 = size2;
                }
            }
        }
        setMeasuredDimension(i, i2);
    }

    @Override // com.jd.ad.sdk.bl.video.jad_an
    public void setRenderCallback(com.jd.ad.sdk.bl.video.jad_an.InterfaceC0546jad_an interfaceC0546jad_an) {
        this.jad_an = interfaceC0546jad_an;
    }

    public void setSurface(Surface surface) {
        this.jad_fs = surface;
    }

    public void setTakeOverSurfaceTexture(boolean z) {
        this.jad_cp = z;
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setSurfaceTextureListener(new jad_cp(this, null));
    }

    @Override // com.jd.ad.sdk.bl.video.jad_an
    public void jad_an(int i, int i2) {
        this.jad_dq = i;
        this.jad_er = i2;
        requestLayout();
    }

    @Override // com.jd.ad.sdk.bl.video.jad_an
    public void jad_an() {
        SurfaceTexture surfaceTexture = this.jad_bo;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.jad_bo = null;
        }
        Surface surface = this.jad_fs;
        if (surface != null) {
            surface.release();
            this.jad_fs = null;
        }
        setSurfaceTextureListener(null);
    }
}

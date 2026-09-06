package com.opos.mobad.j.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.ad.constant.ba;
import com.huawei.openalliance.ad.constant.br;
import com.opos.exoplayer.a.c;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.h;
import com.opos.exoplayer.core.h.g;
import com.opos.exoplayer.core.h.k;
import com.opos.exoplayer.core.h.m;
import com.opos.exoplayer.core.j;
import com.opos.exoplayer.core.p;
import com.opos.exoplayer.core.q;
import com.opos.exoplayer.core.s;
import com.opos.exoplayer.core.y;
import com.opos.exoplayer.core.z;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements q.b, com.opos.mobad.d.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7050a;
    private y b;
    private RelativeLayout c;
    private ImageView d;
    private com.opos.exoplayer.a.a e;
    private c f;
    private g.a g;
    private e h;
    private List<com.opos.mobad.d.d.b> i = new ArrayList();
    private int j = 0;
    private long k = 0;
    private boolean l = true;
    private View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.j.c.a.3
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c cVar = a.this.f;
            if (cVar == null || cVar.isHardwareAccelerated()) {
                return;
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onViewAttachedToWindow switchSurfaceType");
            cVar.a(1);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    };

    public a(Context context, com.opos.mobad.d.d.b bVar) {
        this.f7050a = context;
        b(bVar);
        j();
    }

    private void a(SurfaceView surfaceView) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "showCoverWithSurfaceView()");
        if (surfaceView == null) {
            return;
        }
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        PixelCopy.request(surfaceView, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.j.c.a.2
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public void onPixelCopyFinished(int i) {
                a.this.d.setImageBitmap(bitmapCreateBitmap);
            }
        }, surfaceView.getHandler());
    }

    private void a(TextureView textureView) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "showCoverWithTextureView()");
        if (textureView == null) {
            return;
        }
        this.d.setImageBitmap(textureView.getBitmap());
    }

    private void b(boolean z) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "initPlayer unsupportedAudio=" + z);
        try {
            com.opos.mobad.j.b.c.a(z);
            com.opos.exoplayer.core.g.c cVar = new com.opos.exoplayer.core.g.c(new com.opos.exoplayer.core.g.a.C0926a(new k()));
            this.b = z ? j.a(new s(this.f7050a), cVar) : j.a(this.f7050a, cVar);
            this.b.a(this);
            this.b.a(this.l);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "initPlayer", e);
        }
    }

    private void c(String str) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "initMediaSource path=" + (str != null ? str : "null"));
        try {
            if (com.opos.cmn.an.d.a.a(str)) {
                com.opos.cmn.an.f.a.d("ExoVideoPlayer", "initMediaSource path is null!!!");
            } else {
                this.h = new com.opos.exoplayer.core.e.c.a(this.g).a(Uri.parse(str));
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "initMediaSource", e);
        }
    }

    private void j() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "init");
        try {
            b(false);
            k();
            Context context = this.f7050a;
            this.g = new m(context, com.opos.exoplayer.core.i.y.a(context, context.getPackageName()));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "init", e);
        }
    }

    private void k() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "initPlayerView");
        try {
            this.c = new RelativeLayout(this.f7050a);
            c cVar = new c(this.f7050a);
            this.f = cVar;
            cVar.addOnAttachStateChangeListener(this.m);
            this.f.b(0);
            this.f.a(false);
            this.f.a(this.b);
            this.c.addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
            com.opos.exoplayer.a.a aVar = new com.opos.exoplayer.a.a(this.f7050a);
            this.e = aVar;
            aVar.a(0);
            ImageView imageView = new ImageView(this.f7050a);
            this.d = imageView;
            imageView.setVisibility(8);
            this.e.addView(this.d, new FrameLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.c.addView(this.e, layoutParams);
            l();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "initPlayerView", e);
        }
    }

    private void l() {
        q.d dVarA = this.b.a();
        if (dVarA == null) {
            return;
        }
        dVarA.a(new com.opos.exoplayer.core.video.e() { // from class: com.opos.mobad.j.c.a.1
            @Override // com.opos.exoplayer.core.video.e
            public void a() {
                for (int i = 0; i < a.this.i.size(); i++) {
                    if (a.this.i.get(i) != null) {
                        ((com.opos.mobad.d.d.b) a.this.i.get(i)).j();
                    }
                }
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onRenderFirstFrame");
            }

            @Override // com.opos.exoplayer.core.video.e
            public void a(int i, int i2, int i3, float f) {
                float f2 = (i2 == 0 || i == 0) ? 1.0f : (i * f) / i2;
                c cVar = a.this.f;
                if (cVar == null) {
                    com.opos.cmn.an.f.a.c("ExoVideoPlayer", "callback but playerView null");
                    return;
                }
                View viewB = cVar.b();
                if (viewB != null && (viewB instanceof TextureView) && (i3 == 90 || i3 == 270)) {
                    f2 = 1.0f / f2;
                }
                a.this.e.a(f2);
            }
        });
    }

    private void m() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "playVideo mCurrentState=" + this.j);
        try {
            e eVar = this.h;
            if (eVar != null) {
                this.j = 1;
                this.b.a(eVar);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "prepareVideo", e);
        }
    }

    private void n() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "hideCover()");
        this.d.setVisibility(8);
    }

    private void o() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "showCover()");
        this.d.setVisibility(0);
        this.d.setImageBitmap(null);
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            c cVar = this.f;
            if (cVar == null) {
                return;
            }
            View viewB = cVar.b();
            if (viewB != null) {
                if (viewB instanceof TextureView) {
                    a((TextureView) viewB);
                } else if (viewB instanceof SurfaceView) {
                    a((SurfaceView) viewB);
                }
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "showCover() end cost=" + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("ExoVideoPlayer", "showCover() fail", th);
        }
    }

    private void p() {
        try {
            y yVar = this.b;
            if (yVar != null) {
                yVar.f();
            }
            b(true);
            this.f.a(this.b);
            l();
            this.j = 0;
            a(0L);
            m();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "resetPlayerWithoutAudio", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void a(float f) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "setVolume =" + f);
        this.b.a(f);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(int i) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onRepeatModeChanged repeatMode=" + i);
    }

    @Override // com.opos.mobad.d.d.a
    public void a(long j) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "seekTo position=" + j);
        if (j >= 0) {
            try {
                this.b.a(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("ExoVideoPlayer", "seekTo", e);
            }
        }
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(com.opos.exoplayer.core.e.m mVar, com.opos.exoplayer.core.g.g gVar) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onTracksChanged trackGroups=" + (mVar != null ? mVar.toString() : "null") + ",trackSelections=" + (gVar != null ? gVar.toString() : "null"));
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(h hVar) {
        Object[] objArr = new Object[3];
        objArr[0] = "onPlayerError error=";
        objArr[1] = hVar != null ? hVar.toString() : "null";
        objArr[2] = hVar;
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", objArr);
        int i = -1;
        try {
            this.j = -1;
            if (hVar != null && hVar.f6477a == 3) {
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPlayerError TYPE_AUDIO_RENDERER");
                p();
                return;
            }
            String str = "unknown error.";
            if (hVar != null) {
                i = hVar.f6477a;
                str = "cause: " + (hVar.getCause() != null ? hVar.getCause() : "null") + ", message: " + (hVar.getMessage() != null ? hVar.getMessage() : "null") + ", exceptionTag: " + hVar.a();
            }
            HashMap map = new HashMap();
            map.put(br.f.m, String.valueOf(i));
            map.put(FileDownloadModel.ERR_MSG, str);
            map.put("playerType", "2");
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                this.i.get(i2).a(map);
            }
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onError");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ExoVideoPlayer", "onPlayerError", e);
        }
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(p pVar) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPlaybackParametersChanged playbackParameters=" + (pVar != null ? pVar.toString() : "null"));
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(z zVar, Object obj, int i) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onTimelineChanged timeline=" + (zVar != null ? zVar.toString() : "null") + ",manifest=" + (obj != null ? obj.toString() : "null") + ",reason=" + i);
    }

    @Override // com.opos.mobad.d.d.a
    public void a(com.opos.mobad.d.d.b bVar) {
        b(bVar);
    }

    @Override // com.opos.mobad.d.d.a
    public void a(String str) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "setVideoPath path=" + (str != null ? str : "null"));
        try {
            c(str);
            m();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "setVideoPath", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void a(String str, boolean z) {
        y yVar;
        int i;
        if (z) {
            yVar = this.b;
            i = 2;
        } else {
            yVar = this.b;
            i = 0;
        }
        yVar.a(i);
        a(str);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(boolean z) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onLoadingChanged=" + z);
    }

    @Override // com.opos.exoplayer.core.q.b
    public void a(boolean z, int i) {
        String str;
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPlayerStateChanged playWhenReady=" + z + ",playbackState=" + i);
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "mCurrentState=" + this.j);
        int i2 = 0;
        try {
            if (i == 2) {
                if (z && 2 == this.j) {
                    this.k = d();
                    while (i2 < this.i.size()) {
                        this.i.get(i2).h();
                        i2++;
                    }
                    com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onBufferingStart");
                    this.j = 4;
                    return;
                }
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                this.j = 5;
                o();
                while (i2 < this.i.size()) {
                    this.i.get(i2).e();
                    i2++;
                }
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onComplete");
                return;
            }
            if (z) {
                n();
                int i3 = this.j;
                if (1 != i3 && 5 != i3) {
                    if (4 == i3) {
                        while (i2 < this.i.size()) {
                            this.i.get(i2).i();
                            i2++;
                        }
                        str = "onBufferingEnd";
                    }
                    this.j = 2;
                }
                while (i2 < this.i.size()) {
                    this.i.get(i2).c();
                    this.i.get(i2).d();
                    i2++;
                }
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPrepare");
                str = "onStart";
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", str);
                this.j = 2;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "onPlayerStateChanged", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public Bitmap b(String str) {
        c cVar = this.f;
        if (cVar == null) {
            return null;
        }
        return com.opos.mobad.j.a.b.a(cVar.b(), str);
    }

    @Override // com.opos.mobad.d.d.a
    public View b() {
        return this.c;
    }

    @Override // com.opos.exoplayer.core.q.b
    public void b(int i) {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPositionDiscontinuity reason=" + i);
    }

    public void b(com.opos.mobad.d.d.b bVar) {
        if (bVar != null) {
            this.i.add(bVar);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public long c() {
        long jL = 0;
        try {
            jL = this.b.l();
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "getDuration=" + jL);
            return jL;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "getDuration", e);
            return jL;
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void c(int i) {
        try {
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "setResizeMode=" + i);
            com.opos.exoplayer.a.a aVar = this.e;
            if (aVar != null) {
                aVar.a(i);
            }
            c cVar = this.f;
            if (cVar != null) {
                cVar.b(i);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "setResizeMode", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public long d() {
        long jM = 0;
        try {
            jM = this.b.m();
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "getCurrentPosition=" + jM);
            return jM;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "getCurrentPosition", e);
            return jM;
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void d(int i) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.c(i);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void e() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "start mCurrentState=" + this.j);
        try {
            y yVar = this.b;
            if (yVar != null) {
                yVar.a(true);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "start", e);
        }
    }

    @Override // com.opos.exoplayer.core.q.b
    public void e_() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onSeekProcessed");
    }

    @Override // com.opos.mobad.d.d.a
    public void f() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "pauseVideo mCurrentState=" + this.j);
        try {
            int i = this.j;
            if (1 == i || 2 == i || 4 == i) {
                o();
                this.b.a(false);
                this.k = d();
                if (2 == this.j) {
                    this.j = 3;
                }
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    this.i.get(i2).g();
                }
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onPause");
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "pause", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void g() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "resume mCurrentState=" + this.j);
        try {
            com.opos.cmn.an.f.a.b("ExoVideoPlayer", "mCurrentState=" + this.j);
            int i = this.j;
            if (1 == i || 3 == i || 4 == i) {
                n();
                a(this.k);
                this.b.a(true);
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", ba.ag);
                if (3 == this.j) {
                    this.j = 2;
                }
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    this.i.get(i2).f();
                }
                com.opos.cmn.an.f.a.b("ExoVideoPlayer", "onResume");
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", ba.ag, e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public void h() {
        com.opos.cmn.an.f.a.b("ExoVideoPlayer", "releaseExoVideoPlayer mCurrentState=" + this.j);
        try {
            y yVar = this.b;
            if (yVar != null) {
                yVar.f();
            }
            c cVar = this.f;
            if (cVar != null) {
                cVar.removeOnAttachStateChangeListener(this.m);
                this.f = null;
            }
            this.c = null;
            if (this.h != null) {
                this.h = null;
            }
            if (this.g != null) {
                this.g = null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ExoVideoPlayer", "release", e);
        }
    }

    @Override // com.opos.mobad.d.d.a
    public int i() {
        return this.j;
    }
}

package com.opos.exoplayer.core;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.opos.exoplayer.core.metadata.Metadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class y implements i, q.c, q.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final t[] f6567a;
    private final i b;
    private final b c;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.video.e> d;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.f.j> e;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.metadata.e> f;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.video.f> g;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.a.e> h;
    private Format i;
    private Format j;
    private Surface k;
    private boolean l;
    private int m;
    private SurfaceHolder n;
    private TextureView o;
    private com.opos.exoplayer.core.b.d p;
    private com.opos.exoplayer.core.b.d q;
    private int r;
    private com.opos.exoplayer.core.a.b s;
    private float t;

    static /* synthetic */ class a {
    }

    private final class b implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.opos.exoplayer.core.a.e, com.opos.exoplayer.core.f.j, com.opos.exoplayer.core.metadata.e, com.opos.exoplayer.core.video.f {
        private b() {
        }

        /* synthetic */ b(y yVar, a aVar) {
            this();
        }

        @Override // com.opos.exoplayer.core.a.e
        public void a(int i) {
            y.this.r = i;
            Iterator it = y.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).a(i);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(int i, int i2, int i3, float f) {
            Iterator it = y.this.d.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.e) it.next()).a(i, i2, i3, f);
            }
            Iterator it2 = y.this.g.iterator();
            while (it2.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it2.next()).a(i, i2, i3, f);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(int i, long j) {
            Iterator it = y.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(i, j);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void a(int i, long j, long j2) {
            Iterator it = y.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).a(i, j, j2);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(Surface surface) {
            if (y.this.k == surface) {
                Iterator it = y.this.d.iterator();
                while (it.hasNext()) {
                    ((com.opos.exoplayer.core.video.e) it.next()).a();
                }
            }
            Iterator it2 = y.this.g.iterator();
            while (it2.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it2.next()).a(surface);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(Format format) {
            y.this.i = format;
            Iterator it = y.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(format);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(com.opos.exoplayer.core.b.d dVar) {
            y.this.p = dVar;
            Iterator it = y.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(dVar);
            }
        }

        @Override // com.opos.exoplayer.core.metadata.e
        public void a(Metadata metadata) {
            Iterator it = y.this.f.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.metadata.e) it.next()).a(metadata);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(String str, long j, long j2) {
            Iterator it = y.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(str, j, j2);
            }
        }

        @Override // com.opos.exoplayer.core.f.j
        public void a(List<com.opos.exoplayer.core.f.b> list) {
            Iterator it = y.this.e.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.f.j) it.next()).a(list);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void b(Format format) {
            y.this.j = format;
            Iterator it = y.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).b(format);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void b(com.opos.exoplayer.core.b.d dVar) {
            Iterator it = y.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).b(dVar);
            }
            y.this.i = null;
            y.this.p = null;
        }

        @Override // com.opos.exoplayer.core.a.e
        public void b(String str, long j, long j2) {
            Iterator it = y.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).b(str, j, j2);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void c(com.opos.exoplayer.core.b.d dVar) {
            y.this.q = dVar;
            Iterator it = y.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).c(dVar);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void d(com.opos.exoplayer.core.b.d dVar) {
            Iterator it = y.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).d(dVar);
            }
            y.this.j = null;
            y.this.q = null;
            y.this.r = 0;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            y.this.a(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            y.this.a((Surface) null, true);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            y.this.a(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            y.this.a((Surface) null, false);
        }
    }

    protected y(w wVar, com.opos.exoplayer.core.g.h hVar, n nVar) {
        this(wVar, hVar, nVar, com.opos.exoplayer.core.i.e.f6500a);
    }

    protected y(w wVar, com.opos.exoplayer.core.g.h hVar, n nVar, com.opos.exoplayer.core.i.e eVar) {
        b bVar = new b(this, null);
        this.c = bVar;
        this.d = new CopyOnWriteArraySet<>();
        this.e = new CopyOnWriteArraySet<>();
        this.f = new CopyOnWriteArraySet<>();
        this.g = new CopyOnWriteArraySet<>();
        this.h = new CopyOnWriteArraySet<>();
        t[] tVarArrA = wVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), bVar, bVar, bVar, bVar);
        this.f6567a = tVarArrA;
        this.t = 1.0f;
        this.r = 0;
        this.s = com.opos.exoplayer.core.a.b.f6236a;
        this.m = 1;
        this.b = a(tVarArrA, hVar, nVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        Surface surface2;
        ArrayList arrayList = new ArrayList();
        for (t tVar : this.f6567a) {
            if (tVar.a() == 2) {
                arrayList.add(this.b.a(tVar).a(1).a(surface).i());
            }
        }
        Surface surface3 = this.k;
        if (surface3 != null && surface3 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((r) it.next()).j();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            try {
                if (this.l && (surface2 = this.k) != null) {
                    surface2.release();
                }
            } catch (Exception unused2) {
            }
        }
        this.k = surface;
        this.l = z;
    }

    private void q() {
        TextureView textureView = this.o;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.c) {
                com.opos.cmn.an.f.a.c("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.o.setSurfaceTextureListener(null);
            }
            this.o = null;
        }
        SurfaceHolder surfaceHolder = this.n;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.c);
            this.n = null;
        }
    }

    protected i a(t[] tVarArr, com.opos.exoplayer.core.g.h hVar, n nVar, com.opos.exoplayer.core.i.e eVar) {
        return new aa(tVarArr, hVar, nVar, eVar);
    }

    @Override // com.opos.exoplayer.core.q
    public q.d a() {
        return this;
    }

    @Override // com.opos.exoplayer.core.i
    public r a(r.b bVar) {
        return this.b.a(bVar);
    }

    public void a(float f) {
        this.t = f;
        for (t tVar : this.f6567a) {
            if (tVar.a() == 1) {
                this.b.a(tVar).a(2).a(Float.valueOf(f)).i();
            }
        }
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i) {
        this.b.a(i);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i, long j) {
        this.b.a(i, j);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(long j) {
        this.b.a(j);
    }

    public void a(SurfaceHolder surfaceHolder) {
        q();
        this.n = surfaceHolder;
        Surface surface = null;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this.c);
            Surface surface2 = surfaceHolder.getSurface();
            if (surface2 != null && surface2.isValid()) {
                surface = surface2;
            }
        }
        a(surface, false);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void a(SurfaceView surfaceView) {
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.opos.exoplayer.core.q.d
    public void a(TextureView textureView) {
        q();
        this.o = textureView;
        Surface surface = null;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != null) {
                com.opos.cmn.an.f.a.c("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.c);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            if (surfaceTexture != null) {
                surface = new Surface(surfaceTexture);
            }
        }
        a(surface, true);
    }

    @Override // com.opos.exoplayer.core.i
    public void a(com.opos.exoplayer.core.e.e eVar) {
        this.b.a(eVar);
    }

    @Override // com.opos.exoplayer.core.q.c
    public void a(com.opos.exoplayer.core.f.j jVar) {
        this.e.add(jVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(q.b bVar) {
        this.b.a(bVar);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void a(com.opos.exoplayer.core.video.e eVar) {
        this.d.add(eVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(boolean z) {
        this.b.a(z);
    }

    @Override // com.opos.exoplayer.core.q
    public int b(int i) {
        return this.b.b(i);
    }

    @Override // com.opos.exoplayer.core.q
    public q.c b() {
        return this;
    }

    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null || surfaceHolder != this.n) {
            return;
        }
        a((SurfaceHolder) null);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void b(SurfaceView surfaceView) {
        b(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.opos.exoplayer.core.q.d
    public void b(TextureView textureView) {
        if (textureView == null || textureView != this.o) {
            return;
        }
        a((TextureView) null);
    }

    @Override // com.opos.exoplayer.core.q.c
    public void b(com.opos.exoplayer.core.f.j jVar) {
        this.e.remove(jVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void b(q.b bVar) {
        this.b.b(bVar);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void b(com.opos.exoplayer.core.video.e eVar) {
        this.d.remove(eVar);
    }

    @Override // com.opos.exoplayer.core.q
    public int c() {
        return this.b.c();
    }

    @Override // com.opos.exoplayer.core.q
    public boolean d() {
        return this.b.d();
    }

    @Override // com.opos.exoplayer.core.q
    public p e() {
        return this.b.e();
    }

    @Override // com.opos.exoplayer.core.q
    public void f() {
        this.b.f();
        q();
        Surface surface = this.k;
        if (surface != null) {
            if (this.l) {
                surface.release();
            }
            this.k = null;
        }
        CopyOnWriteArraySet<com.opos.exoplayer.core.video.e> copyOnWriteArraySet = this.d;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.clear();
        }
    }

    @Override // com.opos.exoplayer.core.q
    public com.opos.exoplayer.core.g.g g() {
        return this.b.g();
    }

    @Override // com.opos.exoplayer.core.q
    public z h() {
        return this.b.h();
    }

    @Override // com.opos.exoplayer.core.q
    public int i() {
        return this.b.i();
    }

    @Override // com.opos.exoplayer.core.q
    public int j() {
        return this.b.j();
    }

    @Override // com.opos.exoplayer.core.q
    public int k() {
        return this.b.k();
    }

    @Override // com.opos.exoplayer.core.q
    public long l() {
        return this.b.l();
    }

    @Override // com.opos.exoplayer.core.q
    public long m() {
        return this.b.m();
    }

    @Override // com.opos.exoplayer.core.q
    public long n() {
        return this.b.n();
    }

    @Override // com.opos.exoplayer.core.q
    public boolean o() {
        return this.b.o();
    }

    @Override // com.opos.exoplayer.core.q
    public long p() {
        return this.b.p();
    }
}

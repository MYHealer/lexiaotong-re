package com.opos.mobad.video.player.c.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.C;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b>, com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a, com.opos.mobad.video.player.c.a.a.d.InterfaceC1036a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f8351a;
    private com.opos.mobad.video.player.c.a.a.c b;
    private C1038b c;
    private com.opos.mobad.video.player.c.a.a.a d;
    private d e;
    private FrameLayout f;
    private boolean g;
    private boolean h;
    private boolean i;
    private a k;
    private com.opos.mobad.video.player.c.a.a.b l;
    private final Handler j = new Handler(Looper.getMainLooper());
    private long m = -1;
    private long n = -1;

    private static class a implements com.opos.mobad.video.player.c.a.a.InterfaceC1034a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CopyOnWriteArrayList<com.opos.mobad.video.player.c.a.a.InterfaceC1034a> f8354a;

        private a() {
            this.f8354a = new CopyOnWriteArrayList<>();
        }

        @Override // com.opos.mobad.video.player.c.a.a.InterfaceC1034a
        public void a() {
            com.opos.cmn.an.f.a.b("TTLightInteractive", "onInteractiveShow");
            Iterator<com.opos.mobad.video.player.c.a.a.InterfaceC1034a> it = this.f8354a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.opos.mobad.video.player.c.a.a.InterfaceC1034a
        public void a(int i, int[] iArr) {
            com.opos.cmn.an.f.a.b("TTLightInteractive", "onInteractiveClick");
            Iterator<com.opos.mobad.video.player.c.a.a.InterfaceC1034a> it = this.f8354a.iterator();
            while (it.hasNext()) {
                it.next().a(i, iArr);
            }
        }

        public void a(com.opos.mobad.video.player.c.a.a.InterfaceC1034a interfaceC1034a) {
            if (this.f8354a.contains(interfaceC1034a)) {
                return;
            }
            this.f8354a.add(interfaceC1034a);
        }

        @Override // com.opos.mobad.video.player.c.a.a.InterfaceC1034a
        public void b() {
            com.opos.cmn.an.f.a.b("TTLightInteractive", "onInteractiveDismiss");
            Iterator<com.opos.mobad.video.player.c.a.a.InterfaceC1034a> it = this.f8354a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.video.player.c.a.a.b$b, reason: collision with other inner class name */
    private static class C1038b implements com.opos.mobad.video.player.c.a.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.mobad.video.player.c.a.a.d f8355a;
        private boolean b;

        private C1038b() {
        }

        private boolean b(com.opos.mobad.video.player.c.a.a.d dVar) {
            return dVar == null || this.b;
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public void a(com.opos.mobad.video.player.c.a.a.d.InterfaceC1036a interfaceC1036a) {
            com.opos.mobad.video.player.c.a.a.d dVar = this.f8355a;
            if (b(dVar)) {
                return;
            }
            dVar.a(interfaceC1036a);
        }

        public void a(com.opos.mobad.video.player.c.a.a.d dVar) {
            this.f8355a = dVar;
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public void a(Object obj, String str) {
            com.opos.mobad.video.player.c.a.a.d dVar = this.f8355a;
            if (b(dVar)) {
                return;
            }
            dVar.a(obj, str);
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public void a(String str) {
            com.opos.mobad.video.player.c.a.a.d dVar = this.f8355a;
            if (b(dVar)) {
                return;
            }
            dVar.a(str);
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public void b(String str) {
            com.opos.mobad.video.player.c.a.a.d dVar = this.f8355a;
            if (b(dVar)) {
                return;
            }
            dVar.b(str);
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public View f() {
            com.opos.mobad.video.player.c.a.a.d dVar = this.f8355a;
            if (dVar != null) {
                return dVar.f();
            }
            return null;
        }

        @Override // com.opos.mobad.video.player.c.a.a.d
        public void g() {
            this.b = true;
            com.opos.mobad.video.player.c.a.a.d dVar = this.f8355a;
            if (dVar != null) {
                dVar.g();
            }
        }
    }

    public b(Context context) {
        this.c = new C1038b();
        this.f8351a = new c(context, this);
        this.e = new d(context);
        this.k = new a();
        this.f8351a.a(this.c);
        this.f8351a.a(this.k);
        this.k.a(this.f8351a);
        this.e.setVisibility(4);
        this.e.a(this.f8351a);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f = frameLayout;
        this.e.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public FrameLayout a() {
        return this.e;
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a
    public void a(final long j, final long j2) {
        this.m = j;
        this.n = j2;
        this.j.post(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.i) {
                    return;
                }
                if (b.this.l == null || !b.this.l.c()) {
                    b.this.f8351a.a(j, j2);
                    View viewF = b.this.c.f();
                    if (!b.this.g && b.this.d != null) {
                        String strB = b.this.d.b();
                        if (!TextUtils.isEmpty(strB)) {
                            b.this.g = true;
                            b.this.c.a(strB);
                            com.opos.cmn.an.f.a.a("TTLightInteractive", "loadUrl,h=" + (viewF != null ? viewF.getHeight() : 0) + ",w=" + (viewF != null ? viewF.getWidth() : 0) + ",webUrl=" + strB);
                        }
                    }
                    long jD = b.this.d != null ? b.this.d.d() : C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
                    if (!b.this.h || j <= jD || viewF == null || b.this.e.isShown()) {
                        return;
                    }
                    b.this.k.a();
                    b.this.e.setVisibility(0);
                }
            }
        });
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void a(com.opos.mobad.video.player.c.a.a.InterfaceC1034a interfaceC1034a) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "setInteractiveListener,listener=" + interfaceC1034a);
        this.k.a(interfaceC1034a);
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void a(com.opos.mobad.video.player.c.a.a.b bVar) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "setIInterceptor,interceptor=" + bVar);
        this.l = bVar;
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void a(com.opos.mobad.video.player.c.a.a.c cVar) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "setPlayer,player=" + cVar);
        this.b = cVar;
        this.f8351a.a(cVar);
        com.opos.mobad.video.player.c.a.a.c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(this);
        }
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void a(com.opos.mobad.video.player.c.a.a.d dVar) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "setWebView,webView=" + dVar);
        this.c.a(dVar);
        this.j.post(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                View viewF = b.this.c.f();
                if (viewF != null) {
                    b.this.f.removeAllViews();
                    ViewParent parent = viewF.getParent();
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewF);
                    }
                    b.this.f.addView(viewF, new FrameLayout.LayoutParams(-1, -1));
                    b.this.c.a(b.this.f8351a, "nativeGlobal");
                    b.this.c.a(b.this);
                    b.this.e.setBackgroundColor(0);
                    viewF.setBackgroundColor(0);
                    viewF.setLayerType(1, null);
                    com.opos.cmn.an.f.a.a("TTLightInteractive", "setWebView,add view=" + viewF);
                }
            }
        });
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void a(com.opos.mobad.video.player.c.a.b bVar) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "bindData,ITTLightData=" + bVar);
        com.opos.mobad.video.player.c.a.a.a aVar = new com.opos.mobad.video.player.c.a.a.a(bVar);
        this.d = aVar;
        this.f8351a.a(aVar);
    }

    @Override // com.opos.mobad.video.player.c.a.a
    public void b() {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "destroy,isWebClosed=" + this.i);
        if (this.i) {
            return;
        }
        this.i = true;
        this.k.b();
        this.e.setVisibility(8);
        this.c.g();
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a
    public void b(long j, long j2) {
        this.f8351a.b(j, j2);
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a
    public void c() {
        this.f8351a.c();
    }

    @Override // com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a
    public void c(long j, long j2) {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "onComplete,position=" + j + ",duration=" + j2);
        this.f8351a.c(j, j2);
        b();
    }

    @Override // com.opos.mobad.video.player.c.a.a.d.InterfaceC1036a
    public void d() {
        this.h = true;
        com.opos.cmn.an.f.a.a("TTLightInteractive", "web onLoadSuccess,position=" + this.m + ",duration=" + this.n);
    }

    @Override // com.opos.mobad.video.player.c.a.a.d.InterfaceC1036a
    public void e() {
        com.opos.cmn.an.f.a.a("TTLightInteractive", "web onLoadFail,position=" + this.m + ",duration=" + this.n);
        this.h = false;
        b();
    }
}

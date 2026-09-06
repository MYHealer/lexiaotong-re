package com.opos.mobad.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.C;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8270a;

    public h(Context context, d dVar, FrameLayout frameLayout, boolean z) {
        super(context, dVar, frameLayout, z);
        this.f8270a = false;
    }

    private void a(Context context, final String str) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.3
            @Override // java.lang.Runnable
            public void run() {
                String strA = com.opos.cmn.d.d.a(h.this.c, str);
                boolean zIsEmpty = TextUtils.isEmpty(strA);
                if (zIsEmpty) {
                    strA = str;
                }
                final Bitmap bitmapA = com.opos.mobad.j.a.b.a(strA, zIsEmpty);
                if (bitmapA == null) {
                    return;
                }
                com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.ui.a.h.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.m.setImageBitmap(bitmapA);
                    }
                });
            }
        });
    }

    @Override // com.opos.mobad.ui.a.a
    protected void O() {
        com.opos.cmn.an.f.a.b("MediaCreative", "resetDisappearTime");
        this.H.removeMessages(1);
        if ((this.y || this.w) && !this.x) {
            this.H.sendMessageDelayed(this.H.obtainMessage(1), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
    }

    @Override // com.opos.mobad.ui.a.a
    protected void P() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch");
        int iC = k.a().c(this.B);
        if (iC == 2) {
            com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch isShowPauseCover" + this.y);
            if (this.y) {
                G();
                A();
            } else {
                F();
                z();
            }
        }
        if (iC != 3) {
            return;
        }
        com.opos.cmn.an.f.a.b("MediaCreative", "ChangeUIOnTouch isShowContinueCover" + this.x);
        if (this.x) {
            C();
            A();
        } else {
            B();
            z();
        }
    }

    public void Q() {
        com.opos.cmn.an.f.a.b("MediaCreative", "pauseVideo");
        k.a().b(this.B);
    }

    protected long R() {
        if (k.a() != null) {
            return k.a().d(this.B);
        }
        return -1L;
    }

    protected void S() {
        k.a().c();
    }

    protected void T() {
        this.H.removeMessages(1);
    }

    protected void U() {
        if (this.v != null) {
            this.v.a(k.a().e(this.B));
        }
    }

    protected void V() {
        if (this.v != null) {
            this.v.a();
        }
    }

    public void W() {
        this.f8270a = true;
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.m != null) {
                    h.this.e.removeView(h.this.m);
                }
                if (h.this.n == null || h.this.n.isRecycled()) {
                    return;
                }
                h.this.n.recycle();
            }
        });
    }

    protected void X() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitCoverStatus");
        r();
        D();
        y();
        u();
        K();
        I();
        w();
        u();
    }

    protected void Y() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitBufferCoverStatus");
        r();
        L();
        C();
        G();
        K();
    }

    protected void Z() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitWifiCoverStatus");
        r();
        v();
        C();
        G();
        K();
        u();
    }

    public void a(long j) {
        com.opos.cmn.an.f.a.b("MediaCreative", "seekTo:" + j);
        if (k.a() != null) {
            k.a().a(this.B, j);
        }
    }

    protected void a(long j, long j2) {
        if (this.f == null || k.a().c(this.B) != 2) {
            return;
        }
        com.opos.cmn.an.f.a.b("MediaCreative", "currentPosition=" + j + ",totalPosition=" + j2);
        if (j < 0 || j2 <= 0) {
            this.g.setProgress(0);
            return;
        }
        this.h.setText(com.opos.mobad.cmn.func.b.f.a(500 + j));
        int i = (int) ((j * 100) / j2);
        com.opos.cmn.an.f.a.b("MediaCreative", "currentProgress=" + i + ",mLastProgress=" + this.C);
        if (i - this.C >= 1) {
            this.g.setProgress(i);
        }
        this.C = i;
    }

    protected abstract void a(String str);

    @Override // com.opos.mobad.ui.a.f
    public void a(final String str, final long j) {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.9
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f8270a) {
                    return;
                }
                if (!TextUtils.isEmpty(h.this.B) && h.this.B.equals(str)) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "mCountDown:" + k.a().e(h.this.B));
                    if (h.this.D && h.this.f != null) {
                        h.this.a(j, h.this.R());
                    }
                    if (h.this.v != null) {
                        h.this.v.c(h.this.o, j);
                    }
                }
                h.this.s();
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void a(final Map<String, String> map) {
        com.opos.cmn.an.f.a.b("MediaCreative", "onError,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.6
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f8270a) {
                    return;
                }
                h.this.ah();
                if (h.this.v != null) {
                    h.this.v.a(map);
                }
            }
        });
    }

    protected boolean a(a.C1028a c1028a) {
        if (this.m != null) {
            if (this.m.getDrawable() != null) {
                com.opos.cmn.an.f.a.b("MediaCreative", "createAndLoadCoverImg cover is not null ");
                return true;
            }
            if (c1028a != null) {
                String str = c1028a.f8267a;
                if (!TextUtils.isEmpty(str)) {
                    a(str);
                    return true;
                }
                String str2 = c1028a.b;
                if (TextUtils.isEmpty(str2)) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "videoUrl is empty");
                    return false;
                }
                a(this.c, str2);
                return true;
            }
        }
        return false;
    }

    protected void aa() {
        com.opos.cmn.an.f.a.b("MediaCreative", "ShowInitClickBufferStatus");
        L();
        w();
        u();
        G();
        C();
    }

    protected void ab() {
        L();
        w();
        C();
        G();
        u();
    }

    protected void ac() {
        M();
    }

    protected void ad() {
        p();
        M();
        s();
        E();
        w();
        K();
        u();
        G();
    }

    protected void ae() {
        I();
        M();
        K();
        u();
        B();
    }

    protected void af() {
        p();
        M();
        s();
        K();
        E();
        w();
        u();
        F();
        O();
    }

    protected void ag() {
        M();
        G();
        C();
        q();
        r();
        J();
    }

    protected void ah() {
        M();
        G();
        C();
        w();
        t();
    }

    @Override // com.opos.mobad.d.d.b
    public void c() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onPrepare,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.1
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f8270a || h.this.f == null) {
                    return;
                }
                h.this.C = 0;
                h.this.g.setProgress(0);
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void d() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onStart,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.4
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f8270a) {
                    return;
                }
                h hVar = h.this;
                hVar.a(hVar.d);
                if (h.this.f != null && h.this.i != null) {
                    h.this.i.setText(com.opos.mobad.cmn.func.b.f.a(k.a().d(h.this.B)));
                }
                h.this.ad();
                if (h.this.v != null) {
                    h.this.v.a(h.this.o);
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void e() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onComplete,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.5
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f8270a) {
                    return;
                }
                if (h.this.f != null) {
                    h.this.g.setProgress(100);
                }
                h.this.ag();
                if (h.this.v != null) {
                    h.this.v.b(h.this.o);
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void f() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onResume,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.7
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f8270a) {
                    return;
                }
                if (h.this.f != null && h.this.i != null && h.this.h != null) {
                    com.opos.cmn.an.f.a.b("MediaCreative", "onResume:" + com.opos.mobad.cmn.func.b.f.a(k.a().d(h.this.B)));
                    long jD = k.a().d(h.this.B);
                    h.this.i.setText(com.opos.mobad.cmn.func.b.f.a(jD));
                    long jE = k.a().e(h.this.B);
                    h.this.h.setText(com.opos.mobad.cmn.func.b.f.a(jE));
                    if (jD != 0) {
                        int i = (int) ((jE * 100) / jD);
                        h.this.g.setProgress(i);
                        h.this.C = i;
                    }
                }
                h.this.af();
                if (h.this.v != null) {
                    h.this.v.b(h.this.o, k.a().e(h.this.B));
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void g() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onPause,url:" + this.B);
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.8
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f8270a) {
                    return;
                }
                h.this.ae();
                if (h.this.v != null) {
                    h.this.v.a(h.this.o, k.a().e(h.this.B));
                }
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void h() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onBufferingStart");
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.10
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f8270a) {
                    return;
                }
                h.this.ab();
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void i() {
        com.opos.cmn.an.f.a.b("MediaCreative", "onBufferingEnd");
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.h.11
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f8270a) {
                    return;
                }
                h.this.ac();
            }
        });
    }

    @Override // com.opos.mobad.d.d.b
    public void j() {
    }

    @Override // com.opos.mobad.ui.a.a
    protected void r() {
        if (this.d == null || this.m == null || this.m.getDrawable() != null) {
            super.r();
        } else if (a(this.d)) {
            super.r();
        } else {
            s();
        }
    }
}

package com.ubix.ssp.ad.e.b0;

import android.content.Context;
import android.media.AudioManager;
import android.view.View;
import android.widget.FrameLayout;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.k;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.g.k.j;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class e extends FrameLayout implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f8775a;
    public static int b;
    public static com.ubix.ssp.ad.e.b0.h.f c;
    protected volatile c A;
    public j B;
    private b C;
    protected ArrayList<Integer> D;
    private long E;
    protected boolean F;
    public a G;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public com.ubix.ssp.ad.e.b0.a h;
    public int i;
    public int j;
    public com.ubix.ssp.ad.e.b0.b k;
    public int l;
    protected long m;
    protected int n;
    public com.ubix.ssp.ad.e.b0.k.a o;
    public com.ubix.ssp.ad.e.b0.j.a p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    protected volatile Timer w;
    protected int x;
    protected int y;
    protected AudioManager z;

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f8776a;

        public a(e eVar) {
            this.f8776a = eVar;
        }

        public void a() {
            u.b("onPrepared  [" + hashCode() + "] " + e.this.E);
            e eVar = e.this;
            eVar.f = 3;
            if (!eVar.r) {
                eVar.setState(5);
                return;
            }
            f();
            if (e.this.h != null) {
                u.b("play current url:" + e.this.h.a());
                if (e.this.h.a().toString().toLowerCase().contains("mp3") || e.this.h.a().toString().toLowerCase().contains("wma") || e.this.h.a().toString().toLowerCase().contains("aac") || e.this.h.a().toString().toLowerCase().contains("m4a") || e.this.h.a().toString().toLowerCase().contains("wav")) {
                    b(false);
                }
            }
        }

        public void a(int i) {
        }

        public void a(int i, int i2) {
            u.b("onError " + i + " - " + i2 + " [" + hashCode() + "] ");
            if (i == 38 || i2 == -38 || i == -38 || i2 == 38 || i2 == -19) {
                return;
            }
            d();
        }

        public void a(boolean z) {
            e eVar;
            long duration;
            if (z) {
                eVar = e.this;
                duration = eVar.getDuration();
            } else {
                eVar = e.this;
                duration = eVar.getCurrentPositionWhenPlaying();
            }
            eVar.E = duration;
            u.b("onAutoCompletion  [" + hashCode() + "] " + e.this.E);
            e.this.g();
            c();
            try {
                f.a(e.this.getContext()).getWindow().clearFlags(128);
                e eVar2 = e.this;
                eVar2.z.abandonAudioFocus(eVar2.C);
            } catch (Exception e) {
                e.printStackTrace();
            }
            e eVar3 = e.this;
            if (eVar3.h != null) {
                f.a(eVar3.getContext(), e.this.h.a(), 0L);
            }
        }

        public void b() {
            e eVar = e.this;
            if (eVar.F || eVar.getState() == 5) {
                return;
            }
            e eVar2 = e.this;
            eVar2.k.a(eVar2.t);
        }

        public void b(int i, int i2) {
            u.b("onInfo what - " + i + " extra - " + i2 + ";" + e.this.f + ";" + e.this.e);
            if (i == 3 || i == 9090) {
                e eVar = e.this;
                if (eVar.e) {
                    j jVar = eVar.B;
                    if (jVar != null) {
                        jVar.j(0);
                    }
                } else {
                    this.f8776a.e = true;
                    j jVar2 = eVar.B;
                    if (jVar2 != null) {
                        jVar2.h(0);
                    }
                }
                int i3 = e.this.f;
                if (i3 == 3 || i3 == 4 || i3 == 2) {
                    b(true);
                }
            }
        }

        public void b(boolean z) {
            e eVar = e.this;
            if (!eVar.a(eVar.D)) {
                u.b("onStatePlaying  [" + hashCode() + "]   isRealPlaying " + z);
                e eVar2 = e.this;
                if (eVar2.f == 3) {
                    long jA = eVar2.h != null ? f.a(eVar2.getContext(), e.this.h.a()) : 0L;
                    if (jA != 0) {
                        e.this.k.a(jA);
                    } else {
                        e eVar3 = e.this;
                        eVar3.k.a(eVar3.t);
                    }
                }
                e.this.f = 4;
            }
            if (z) {
                e.this.o();
                this.f8776a.e = true;
                try {
                    e eVar4 = e.this;
                    if (eVar4.t) {
                        return;
                    }
                    if (eVar4.z == null) {
                        eVar4.z = (AudioManager) StubApp.getOrigApplicationContext(eVar4.getContext().getApplicationContext()).getSystemService("audio");
                    }
                    e eVar5 = e.this;
                    eVar5.z.requestAudioFocus(eVar5.C, 3, 2);
                    e.this.k.a(1.0f, 1.0f);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public void c() {
            u.b("onStateAutoComplete  [" + hashCode() + "] ");
            e eVar = e.this;
            eVar.f = 6;
            eVar.g();
            j jVar = e.this.B;
            if (jVar != null) {
                jVar.c(0);
            }
            e eVar2 = e.this;
            eVar2.F = true;
            eVar2.r = false;
        }

        public void c(int i, int i2) {
            if (i * i2 == 0) {
                return;
            }
            e eVar = e.this;
            com.ubix.ssp.ad.e.b0.k.a aVar = eVar.o;
            if (aVar != null) {
                int i3 = eVar.l;
                if (i3 != 0) {
                    aVar.setRotation(i3);
                }
                e.this.o.a(i, i2);
            }
            e eVar2 = e.this;
            com.ubix.ssp.ad.e.b0.j.a aVar2 = eVar2.p;
            if (aVar2 != null) {
                int i4 = eVar2.l;
                if (i4 != 0) {
                    aVar2.setRotation(i4);
                }
                e.this.p.a(i, i2);
            }
        }

        public void d() {
            u.b("onStateError  [" + hashCode() + "] ");
            e eVar = e.this;
            eVar.f = 7;
            eVar.g();
            e eVar2 = e.this;
            j jVar = eVar2.B;
            if (jVar != null) {
                jVar.a(0, eVar2.f);
            }
        }

        public void e() {
            u.b("onStatePause [" + hashCode() + "] " + e.this.F + " seekto" + e.this.E);
            e eVar = e.this;
            if (eVar.F) {
                eVar.k.a(eVar.E);
                return;
            }
            eVar.E = 0 == eVar.getCurrentPositionWhenPlaying() ? e.this.E : e.this.getCurrentPositionWhenPlaying();
            e eVar2 = e.this;
            eVar2.E = eVar2.E >= 0 ? e.this.E : 0L;
            u.b("onStatePause resumePosition=" + e.this.E + " [" + hashCode() + "] ");
            e eVar3 = e.this;
            eVar3.f = 5;
            j jVar = eVar3.B;
            if (jVar != null) {
                jVar.g(0);
            }
            try {
                e eVar4 = e.this;
                if (eVar4.z != null && eVar4.C != null) {
                    e eVar5 = e.this;
                    eVar5.z.abandonAudioFocus(eVar5.C);
                }
                e.this.k.a(0.0f, 0.0f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void f() {
            u.b("onStatePlaying  [" + hashCode() + "] " + e.this.E);
            e eVar = e.this;
            int i = eVar.f;
            if (i == 3 || i == 5) {
                long j = eVar.E;
                if (j > 0) {
                    e.this.k.a(j);
                } else {
                    e eVar2 = e.this;
                    eVar2.k.a(eVar2.t);
                }
            }
            e.this.f = 4;
        }
    }

    private static class b implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SoftReference<e> f8777a;

        public b(e eVar) {
            this.f8777a = new SoftReference<>(eVar);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            StringBuilder sb;
            e eVar;
            String str;
            SoftReference<e> softReference;
            e eVar2;
            if (i != -3) {
                try {
                    if (i == -2) {
                        SoftReference<e> softReference2 = this.f8777a;
                        if (softReference2 == null || (eVar = softReference2.get()) == null) {
                            return;
                        }
                        if (eVar.f != 4 || eVar.r) {
                            str = "AUDIO_FOCUS_LOSS_TRANSIENT pause play -false";
                        } else {
                            eVar.f = 5;
                            str = "AUDIO_FOCUS_LOSS_TRANSIENT pause play true";
                        }
                        u.b(str);
                        return;
                    }
                    if (i != -1) {
                        if (i != 1 || (softReference = this.f8777a) == null || (eVar2 = softReference.get()) == null || eVar2.f == 4 || !eVar2.d) {
                            return;
                        }
                        eVar2.f = 4;
                        eVar2.k.a(this.f8777a.get().t);
                        return;
                    }
                    sb = new StringBuilder("AUDIO_FOCUS_LOSS [");
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            } else {
                sb = new StringBuilder("AUDIO_FOCUS_LOSS_TRANSIENT_CAN_DUCK [");
            }
            u.b(sb.append(hashCode()).append("]").toString());
        }
    }

    public static class c extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<e> f8778a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (c.this.a() != null && c.this.a().f == 4 && c.this.a().e) {
                        long currentPositionWhenPlaying = c.this.a().getCurrentPositionWhenPlaying();
                        long duration = c.this.a().getDuration();
                        int i = (int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration));
                        if (c.this.a().B != null) {
                            c.this.a().B.a(i, currentPositionWhenPlaying, duration);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public c(e eVar) {
            this.f8778a = new WeakReference<>(eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public e a() {
            WeakReference<e> weakReference = this.f8778a;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            return this.f8778a.get();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (a() != null) {
                a().post(new a());
            }
        }
    }

    private static class d implements com.ubix.ssp.ad.e.b0.h.s.c {
        @Override // com.ubix.ssp.ad.e.b0.h.s.c
        public String a(String str) {
            return str.hashCode() + "";
        }
    }

    public e(Context context, int i) {
        this(context, i, 0L);
    }

    public e(Context context, int i, long j) {
        super(context);
        this.f = -1;
        this.g = -1;
        this.i = 0;
        this.j = 0;
        this.l = 0;
        this.m = 0L;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = -1;
        this.v = 1;
        this.C = new b(this);
        this.D = null;
        this.F = false;
        this.E = j;
        setDisplayViewType(i);
        a(context);
        h();
    }

    public static void a(Context context) {
        if (c == null) {
            c = new com.ubix.ssp.ad.e.b0.h.f.b(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(k.f(StubApp.getOrigApplicationContext(context.getApplicationContext()))).a(new d()).a();
        }
    }

    private void d() {
        u.b("addSurfaceView [" + this.n + "] ");
        com.ubix.ssp.ad.e.b0.j.a aVar = this.p;
        if (aVar == null) {
            this.p = new com.ubix.ssp.ad.e.b0.j.a(getContext());
        } else {
            removeView(aVar);
        }
        this.p.setId(900131);
        this.p.setSurfaceViewCallback(this.k);
        addView(this.p, new FrameLayout.LayoutParams(-1, -1, 17));
        setBackgroundColor(-16777216);
    }

    private void e() {
        u.b("addTextureView [" + this.n + "] ");
        com.ubix.ssp.ad.e.b0.k.a aVar = this.o;
        if (aVar != null) {
            removeView(aVar);
        }
        com.ubix.ssp.ad.e.b0.k.a aVar2 = new com.ubix.ssp.ad.e.b0.k.a(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        this.o = aVar2;
        aVar2.setId(900130);
        this.o.setSurfaceTextureListener(this.k);
        addView(this.o, new FrameLayout.LayoutParams(-1, -1, 17));
        setBackgroundColor(-16777216);
    }

    public void a(int i, int i2, int i3) {
        u.b("state:" + i);
        if (i == 0) {
            n();
            return;
        }
        if (i == 4) {
            this.G.b(false);
            return;
        }
        if (i == 5) {
            this.G.e();
        } else if (i == 6) {
            this.G.c();
        } else {
            if (i != 7) {
                return;
            }
            this.G.d();
        }
    }

    public void a(com.ubix.ssp.ad.e.b0.a aVar, int i) {
        this.n = hashCode();
        this.h = aVar;
        this.g = i;
        n();
        if (this.k.c()) {
            return;
        }
        this.k.a(aVar);
    }

    public void a(String str, String str2) {
        u.b("ori :" + str);
        if (str.startsWith("http")) {
            str = c.d(str);
        }
        u.b("new :" + str);
        a(new com.ubix.ssp.ad.e.b0.a(str, str2), 0);
    }

    public void a(String str, String str2, int i) {
        if (str.startsWith("http")) {
            str = c.d(str);
        }
        a(new com.ubix.ssp.ad.e.b0.a(str, str2), i);
    }

    protected boolean a(List<Integer> list) {
        return com.ubix.ssp.ad.e.a0.y.c.a((View) this, true, false, list) || com.ubix.ssp.ad.e.a0.y.c.a(this);
    }

    protected boolean f() {
        return true;
    }

    public void g() {
        u.b("---cancelProgressTimer");
        if (this.w != null) {
            this.w.cancel();
            this.w = null;
        }
        if (this.A != null) {
            this.A.cancel();
            this.A = null;
        }
    }

    public long getCurrentPositionWhenPlaying() {
        int i = this.f;
        if (i == 4 || i == 5) {
            try {
                return this.k.a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public long getDuration() {
        try {
            return this.k.b();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public a getMediaPlayerCallback() {
        return this.G;
    }

    public int getState() {
        return this.f;
    }

    public void h() {
        this.x = getContext().getResources().getDisplayMetrics().widthPixels;
        this.y = getContext().getResources().getDisplayMetrics().heightPixels;
        this.f = -1;
        this.u = -1;
        this.G = new a(this);
        l();
    }

    public void i() {
        if (this.k != null) {
            try {
                int i = this.f;
                if (i == 5 || i == 0) {
                    return;
                }
                setState(5);
                this.k.d();
                g();
            } catch (Exception e) {
                u.b(e.toString());
            }
        }
    }

    public void j() {
        com.ubix.ssp.ad.e.b0.b bVar = this.k;
        if (bVar != null) {
            try {
                if (this.F) {
                    bVar.a(this.E);
                    return;
                }
                if (this.f != 4) {
                    u.b("----state:" + getState() + ";" + this.E);
                    setState(4);
                    long j = this.E;
                    if (0 != j) {
                        this.k.a(j);
                    } else {
                        this.k.a(this.t);
                        this.B.h(0);
                    }
                    o();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void k() {
        u.a("onStartPlayError");
        m();
        l();
    }

    public void l() {
        u.b("startVideo [" + this.n + "]--");
        try {
            this.k = new com.ubix.ssp.ad.e.b0.c(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.z = (AudioManager) StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getSystemService("audio");
        if (this.v == 1) {
            d();
        } else {
            e();
        }
        this.f = 1;
        this.u = 1;
        u.b("onStatePreparing  [" + this.n + "] ");
    }

    public void m() {
        u.b("--reset  [" + this.n + "] ");
        int i = this.f;
        if (i == 4 || i == 5) {
            long currentPositionWhenPlaying = getCurrentPositionWhenPlaying();
            if (this.h != null) {
                f.a(getContext(), this.h.a(), currentPositionWhenPlaying);
            }
        }
        g();
        n();
        ((AudioManager) StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getSystemService("audio")).abandonAudioFocus(this.C);
        com.ubix.ssp.ad.e.b0.b bVar = this.k;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void n() {
        u.b("onStateNormal  [" + this.n + "] ");
        this.f = 0;
        this.u = 0;
        g();
    }

    public void o() {
        u.b("---startProgressTimer" + this.u);
        if (this.u == 6) {
            return;
        }
        g();
        this.w = new Timer();
        this.A = new c(this);
        this.w.schedule(this.A, 0L, 300L);
    }

    public void setAutoPlay(boolean z) {
        this.r = z;
    }

    public void setCanRePlay(boolean z) {
        this.s = z;
    }

    public void setDisplayViewType(int i) {
        this.v = i;
    }

    public void setIsMuteStart(boolean z) {
        this.t = z;
    }

    public void setIsShowPlayButton(boolean z) {
        this.q = z;
    }

    public void setMute(boolean z) {
        b bVar;
        try {
            this.t = z;
            if (!z) {
                if (this.z == null) {
                    this.z = (AudioManager) StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getSystemService("audio");
                }
                this.z.requestAudioFocus(this.C, 3, 2);
                this.k.a(1.0f, 1.0f);
                return;
            }
            AudioManager audioManager = this.z;
            if (audioManager != null && (bVar = this.C) != null) {
                audioManager.abandonAudioFocus(bVar);
            }
            this.k.a(0.0f, 0.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setState(int i) {
        this.f = i;
        a(i, 0, 0);
    }

    public void setVideoImageDisplayType(int i) {
        b = i;
    }

    public void setVideoViewListener(j jVar) {
        this.B = jVar;
    }
}

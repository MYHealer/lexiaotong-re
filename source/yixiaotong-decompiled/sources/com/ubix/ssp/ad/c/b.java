package com.ubix.ssp.ad.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import com.ubix.ssp.ad.d.l;
import com.ubix.ssp.ad.e.a0.f;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.a0.v;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.AdSize;
import com.ubix.ssp.open.ParamsReview;
import java.lang.ref.SoftReference;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends com.ubix.ssp.ad.a implements com.ubix.ssp.ad.g.k.a {
    private static volatile int C = -1;
    private static volatile String D = "";
    private int E;
    private boolean F;
    private boolean G;
    private com.ubix.ssp.ad.g.a H;
    private boolean I;
    private SoftReference<RelativeLayout> J;
    public ScheduledExecutorService K;
    private SoftReference<Context> L;
    private com.ubix.ssp.ad.d.a M;
    private AdSize N;
    private l O;
    private com.ubix.ssp.ad.g.c P;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8579a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.f8579a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                v.b(StubApp.getOrigApplicationContext(this.f8579a.getApplicationContext()), "ubix_sp_capacity", "b_cur", b.C);
                v.b(StubApp.getOrigApplicationContext(this.f8579a.getApplicationContext()), "ubix_sp_capacity", "b_cur_time", this.b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.c.b$b, reason: collision with other inner class name */
    class ThreadFactoryC1059b implements ThreadFactory {
        ThreadFactoryC1059b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.OtherRequestExecuteThread");
        }
    }

    class c implements com.ubix.ssp.ad.e.v.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f8581a;
        final /* synthetic */ com.ubix.ssp.ad.b b;

        c(Bundle bundle, com.ubix.ssp.ad.b bVar) {
            this.f8581a = bundle;
            this.b = bVar;
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(com.ubix.ssp.ad.e.v.e eVar, String str, String str2, boolean z) {
            Bundle bundleA = b.this.a(str);
            bundleA.putAll(this.f8581a);
            if (b.this.M == null || b.this.M.f8604a == null || b.this.M.f8604a.d == null) {
                AdError adErrorG = com.ubix.ssp.ad.e.a0.a0.a.g(12, "参数异常");
                b bVar = b.this;
                bVar.o(bVar.E);
                b.this.a(0, adErrorG);
                return;
            }
            if (b.this.O.b()) {
                bundleA.putString("AD_SOURCE", b.this.M.f8604a.d.t);
            }
            this.b.b(bundleA);
            com.ubix.ssp.ad.e.y.a.a.b bVar2 = b.this.M.f8604a.d;
            if (com.ubix.ssp.ad.e.a0.c.a(bVar2)) {
                this.b.a(bVar2.g, bVar2.A, bVar2.z, bVar2.h, bVar2.H, bVar2.I, bVar2.G);
            }
            b.this.n(0);
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
            b bVar = b.this;
            bVar.o(bVar.E);
            b.this.a(0, adError);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8582a;

        public d(int i) {
            this.f8582a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.I) {
                return;
            }
            u.b("run into RequestRunnable, refreshTime is " + this.f8582a);
            ((com.ubix.ssp.ad.a) b.this).k = UUID.randomUUID().toString().replace(x.A, "");
            b bVar = b.this;
            bVar.m(bVar.E);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8583a;

        public e(int i) {
            this.f8583a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.o(this.f8583a);
        }
    }

    public b(Context context, String str) {
        this(context, str, new AdSize(0, 0));
    }

    public b(Context context, String str, AdSize adSize) {
        super(context, str);
        this.F = true;
        this.G = false;
        this.L = new SoftReference<>(context);
        this.i = 4;
        this.N = adSize == null ? new AdSize(0, 0) : adSize;
        if (C == -1) {
            C = v.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ubix_sp_capacity", "b_cur", 0);
        }
        if (TextUtils.isEmpty(D)) {
            D = v.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ubix_sp_capacity", "b_cur_time", Calendar.getInstance().get(1) + "/" + Calendar.getInstance().get(2) + "/" + Calendar.getInstance().get(5));
        }
        this.J = new SoftReference<>(new RelativeLayout(context));
        F();
    }

    private void F() {
        ScheduledExecutorService scheduledExecutorService = this.K;
        if (scheduledExecutorService == null || scheduledExecutorService.isTerminated()) {
            this.K = Executors.newScheduledThreadPool(1, new ThreadFactoryC1059b());
        }
    }

    private boolean G() {
        l lVar;
        return this.M != null && (lVar = this.O) != null && lVar.l0() && System.currentTimeMillis() / 1000 > this.M.j;
    }

    private void J() {
        com.ubix.ssp.ad.g.a aVar = this.H;
        if (aVar != null) {
            aVar.onAdLoadSucceed();
        }
    }

    private void K() {
        com.ubix.ssp.ad.e.y.a.a aVar;
        String str;
        String str2;
        Bundle bundle = new Bundle();
        bundle.putInt("AD_WIDTH", this.N.getWidth());
        bundle.putInt("AD_HEIGHT", this.N.getHeight());
        bundle.putInt("VIDEO_RENDER_TYPE", this.O.k0());
        bundle.putBoolean("IS_UNNAMED", this.O.G0());
        com.ubix.ssp.ad.d.a aVar2 = this.M;
        if (aVar2 != null && (aVar = aVar2.f8604a) != null && aVar.d != null) {
            bundle.putInt("AUTO_PLAY", this.O.c());
            bundle.putInt("TEMPLATE_ID", this.M.f8604a.d.s);
            bundle.putBoolean("IS_DOWNLOAD", com.ubix.ssp.ad.e.a0.c.a(this.M.f8604a.d));
            if (TextUtils.isEmpty(this.M.f8604a.d.f)) {
                str = TextUtils.isEmpty(this.M.f8604a.d.e) ? "" : this.M.f8604a.d.e;
            } else {
                str = this.M.f8604a.d.f;
            }
            bundle.putString("TITLE", str);
            com.ubix.ssp.ad.e.y.a.a.b.l lVar = this.M.f8604a.d.k;
            if (lVar != null && (str2 = lVar.b) != null) {
                bundle.putString("VIDEO_URL", str2);
            }
        }
        SoftReference<Context> softReference = this.L;
        if (softReference == null || softReference.get() == null) {
            a(0, com.ubix.ssp.ad.e.a0.a0.a.g(4, "Activity/Context为空"));
            return;
        }
        com.ubix.ssp.ad.b bVarA = com.ubix.ssp.ad.b.a(this.L.get(), bundle, 4, true);
        bVarA.setInnerListener(this);
        bVarA.setShowCloseBtnDelay(0);
        SoftReference<RelativeLayout> softReference2 = this.J;
        if (softReference2 == null || softReference2.get() == null) {
            a(0, com.ubix.ssp.ad.e.a0.a0.a.g(5, "广告外层为空或者广告不可见"));
            return;
        }
        this.J.get().removeAllViews();
        this.J.get().addView(bVarA, -2, -2);
        com.ubix.ssp.ad.e.v.e.b().a(b(this.M.f8604a) ? this.M.f8604a.d.k.c : this.M.f8604a.d.j[0].c, new c(bundle, bVarA));
    }

    private void e(AdError adError) {
        com.ubix.ssp.ad.g.a aVar = this.H;
        if (aVar != null) {
            aVar.onAdLoadFailed(adError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o(int i) {
        u.b("run into rotateAd, refreshTime is " + i);
        ScheduledExecutorService scheduledExecutorService = this.K;
        if (scheduledExecutorService != null && !scheduledExecutorService.isTerminated()) {
            if (((ScheduledThreadPoolExecutor) this.K).getQueue().size() > 0) {
                u.b("queue only need 1 thread,returned.");
                return;
            }
            if (i <= 0) {
                u.b("run into rotateAd, need to stop  is " + i);
                return;
            }
            if (this.I) {
                return;
            }
            SoftReference<RelativeLayout> softReference = this.J;
            if (softReference != null && softReference.get() != null && this.J.get().getParent() != null) {
                SoftReference<RelativeLayout> softReference2 = this.J;
                if (softReference2 == null || softReference2.get() == null || this.J.get().isShown()) {
                    F();
                    this.K.schedule(new d(i), i, TimeUnit.SECONDS);
                    return;
                } else {
                    F();
                    this.K.schedule(new e(i), i, TimeUnit.SECONDS);
                    return;
                }
            }
            u.b("banner lost parent, terminal.");
            L();
            return;
        }
        u.b("may be terminated");
    }

    private void p(int i) {
        if (i <= 0) {
            i = -1;
        }
        if (i > 0 && i < 30) {
            i = 30;
        }
        if (i >= 120) {
            i = 120;
        }
        this.E = i;
    }

    public View C() {
        SoftReference<RelativeLayout> softReference = this.J;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public ParamsReview D() {
        return super.a(this.M.f8604a, this.O.x0(), this.O.H0());
    }

    public long E() {
        return super.g(this.M);
    }

    public boolean H() {
        return this.G && !G();
    }

    public void I() {
        m(-1);
    }

    public void L() {
        try {
            u.b("stopRequest " + this.I);
            this.I = true;
            ScheduledExecutorService scheduledExecutorService = this.K;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                this.K = null;
            }
            SoftReference<RelativeLayout> softReference = this.J;
            if (softReference != null && softReference.get() != null) {
                ViewParent parent = this.J.get().getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.J.get());
                }
                this.J.get().removeAllViews();
            }
            if (this.r != null) {
                com.ubix.ssp.ad.e.s.c.a().a(this.r, "");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void a(int i, View view) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        String str;
        if (!H()) {
            o(this.E);
            AdError adErrorD = com.ubix.ssp.ad.e.a0.a0.a.d(4, "文件已经过期");
            com.ubix.ssp.ad.g.a aVar2 = this.H;
            if (aVar2 != null) {
                aVar2.onAdExposeFailed(adErrorD);
                return;
            }
            return;
        }
        d(this.M);
        c(this.M);
        o(this.E);
        com.ubix.ssp.ad.g.a aVar3 = this.H;
        if (aVar3 != null) {
            aVar3.onAdExposed();
        }
        com.ubix.ssp.ad.d.a aVar4 = this.M;
        if (aVar4 == null || (aVar = aVar4.f8604a) == null || (bVar = aVar.d) == null || (str = bVar.i) == null) {
            return;
        }
        f(str);
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(int i, com.ubix.ssp.ad.d.a aVar) {
        com.ubix.ssp.ad.b bVar;
        super.a(i, aVar);
        try {
            if (com.ubix.ssp.ad.d.b.v) {
                SoftReference<RelativeLayout> softReference = this.J;
                if (softReference != null && softReference.get() != null) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.J.get().getChildCount()) {
                            bVar = null;
                            break;
                        } else {
                            if (this.J.get().getChildAt(i2) instanceof com.ubix.ssp.ad.b) {
                                bVar = (com.ubix.ssp.ad.b) this.J.get().getChildAt(i2);
                                break;
                            }
                            i2++;
                        }
                    }
                } else {
                    bVar = null;
                    break;
                }
                if (bVar != null) {
                    a(this.c, this.M, bVar.getClickMap());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i, AdError adError) {
        this.G = false;
        e(adError);
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(int i, Object... objArr) {
        com.ubix.ssp.ad.g.a aVar;
        if (this.O.n0() && i != 0) {
            super.a(i, objArr);
        }
        u.e("runClickCallback " + i + ";canRun=" + ((!this.O.n0() && i == 0) || (this.O.n0() && i != 0)));
        if (((this.O.n0() || i != 0) && (!this.O.n0() || i == 0)) || (aVar = this.H) == null) {
            return;
        }
        aVar.onAdClicked();
    }

    public void a(long j) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.M;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null) {
            return;
        }
        super.a(aVar, j);
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(Message message) {
        int i = message.what;
        if (i != 5) {
            if (i != 6) {
                return;
            }
            o(this.E);
            e((AdError) message.obj);
            return;
        }
        com.ubix.ssp.ad.d.a aVar = (com.ubix.ssp.ad.d.a) ((List) message.obj).get(0);
        this.M = aVar;
        l lVarA = a(aVar.f8604a);
        this.O = lVarA;
        if (this.M.f8604a.d.N) {
            p(lVarA.d());
        } else {
            this.E = -1;
        }
        K();
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        super.a(aVar, map);
        if (this.r != null) {
            com.ubix.ssp.ad.e.s.c.a().a(this.r, null);
            this.r = null;
        }
    }

    public void a(com.ubix.ssp.ad.g.a aVar) {
        this.H = aVar;
    }

    @Override // com.ubix.ssp.ad.a
    protected boolean a(Context context) {
        String str = Calendar.getInstance().get(1) + "/" + Calendar.getInstance().get(2) + "/" + Calendar.getInstance().get(5);
        if (!str.equals(D)) {
            C = 0;
            D = str;
        }
        boolean z = C + 1 > com.ubix.ssp.ad.d.b.A;
        if (!z) {
            C++;
        }
        try {
            com.ubix.ssp.ad.e.a0.c.z();
            com.ubix.ssp.ad.e.a0.c.e.execute(new a(context, str));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void b(int i) {
        f.a(this.c, this.e.get(i).f8604a.d.F, 0, this.O, this.d, null);
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void b(int i, View view, HashMap<String, String> map) {
        if (map == null) {
            try {
                map = ((com.ubix.ssp.ad.b) this.J.get().getChildAt(0)).getClickMap();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        b(this.M, map);
    }

    @Override // com.ubix.ssp.ad.a
    protected void b(int i, com.ubix.ssp.ad.d.a aVar) {
        super.b(i, aVar);
        if (i == 3) {
            a(2, new Object[0]);
        }
    }

    public void b(HashMap<String, String> map) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.M;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null) {
            return;
        }
        super.a(aVar, map);
    }

    @Override // com.ubix.ssp.ad.a
    protected boolean b(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        super.b(aVar, map);
        if (!i()) {
            map.put("__CLICK_AREA__", "1");
            int iA = a(aVar, 4, map, aVar.o, false, this.P);
            if (iA == 4 || iA == 6) {
                a(4, new Object[0]);
                if (com.ubix.ssp.ad.e.s.b.c().b(aVar.o) == 44 && this.r == null) {
                    this.r = a(map, this.e.indexOf(aVar), this.y);
                    com.ubix.ssp.ad.e.s.c.a().a(this.r);
                }
            } else if (iA == 2 || iA == 5 || iA == 31) {
                if (iA == 31) {
                    g((String) null);
                }
                a(this.c, aVar, map);
            } else if (iA == 22) {
                b(this.c, aVar, map, this.O.q());
            } else if (iA == 23) {
                a(this.c, aVar, map, this.O.q());
                a(2, new Object[0]);
            } else if (iA == 3) {
                b(this.c);
            } else if (iA == 33) {
                a(33, new Object[0]);
            } else {
                a(1, new Object[0]);
            }
        }
        a(0, new Object[0]);
        return true;
    }

    @Override // com.ubix.ssp.ad.a
    protected void c(Context context, Intent intent, long j, BroadcastReceiver broadcastReceiver) {
        a(3, new Object[0]);
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void e(int i) {
        com.ubix.ssp.ad.g.a aVar = this.H;
        if (aVar != null) {
            aVar.onAdClosed();
        }
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void f(int i) {
        f.a(this.c, this.e.get(i).f8604a.d.C, 0, this.O, this.d, null);
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void i(int i) {
        f.a(this.c, this.e.get(i).f8604a.d.B, 0, this.O, this.d, null);
    }

    @Override // com.ubix.ssp.ad.a
    protected AdError j(com.ubix.ssp.ad.d.a aVar) {
        int i;
        String str;
        com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b;
        com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.f8604a.d;
        int i2 = bVar.s;
        if (i2 == 4003) {
            com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr = bVar.j;
            if (c1109bArr != null && c1109bArr.length != 0 && (c1109b = c1109bArr[0]) != null && !TextUtils.isEmpty(c1109b.c)) {
                return null;
            }
            i = 10;
            str = "图片资源链接异常";
        } else if (i2 == 4004) {
            com.ubix.ssp.ad.e.y.a.a.b.l lVar = bVar.k;
            if (lVar == null || TextUtils.isEmpty(lVar.c)) {
                i = 13;
                str = "封面图资源链接异常";
            } else {
                com.ubix.ssp.ad.e.y.a.a.b.l lVar2 = aVar.f8604a.d.k;
                if (lVar2 != null && !TextUtils.isEmpty(lVar2.b)) {
                    return null;
                }
                i = 12;
                str = "视频资源链接异常";
            }
        } else {
            i = 16;
            str = "广告模板Id异常,或资源与模板不匹配";
        }
        return com.ubix.ssp.ad.e.a0.a0.a.k(i, str);
    }

    @Override // com.ubix.ssp.ad.a
    public void m(int i) {
        p(i);
        super.m(4);
    }

    public void n(int i) {
        this.G = true;
        J();
    }
}

package com.ubix.ssp.ad.j;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.k;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.a0.v;
import com.ubix.ssp.ad.g.k.i;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.ParamsReview;
import com.ubixnow.ooooo.oOO00O0;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends com.ubix.ssp.ad.k.b implements i {
    public static final String Z = "b";
    private com.ubix.ssp.ad.g.i a0;
    private Context b0;
    private com.ubix.ssp.ad.b c0;
    private int d0;
    private int e0;
    private volatile boolean f0;
    private volatile boolean g0;
    private AtomicInteger h0;
    private com.ubix.ssp.ad.e.a0.g i0;
    private transient boolean j0;
    private int k0;
    private long l0;
    private boolean m0;
    private HashMap<String, String> n0;
    private boolean o0;

    class a implements com.ubix.ssp.ad.e.v.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9020a;

        a(boolean z) {
            this.f9020a = z;
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(com.ubix.ssp.ad.e.v.e eVar, String str, String str2, boolean z) {
            if (this.f9020a) {
                b.this.q(0);
            }
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
            if (this.f9020a) {
                b.this.a(0, adError);
            }
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.j.b$b, reason: collision with other inner class name */
    class C1123b implements com.ubix.ssp.ad.e.v.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9021a;

        C1123b(boolean z) {
            this.f9021a = z;
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(com.ubix.ssp.ad.e.v.e eVar, String str, String str2, boolean z) {
            if (this.f9021a) {
                b.this.q(0);
            }
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
            u.a("onFailure " + adError.getErrorMessage());
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.a(((com.ubix.ssp.ad.a) b.this).c, "ubix_sp_gold", OapsKey.KEY_DOWNLOAD_COUNT + ((com.ubix.ssp.ad.a) b.this).d, ((com.ubix.ssp.ad.a) b.this).B);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f9023a;

        d(HashMap map) {
            this.f9023a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.h0.decrementAndGet() == 0) {
                    this.f9023a.put("__CLICK_AREA__", BaseWrapper.ENTER_ID_AD_SDK);
                    this.f9023a.put("__CLICK_TRIGGER__", BaseWrapper.ENTER_ID_AD_SDK);
                    this.f9023a.put("__CLICK_UNREAL_TRIGGER__", BaseWrapper.ENTER_ID_AD_SDK);
                }
                b bVar = b.this;
                bVar.a(((com.ubix.ssp.ad.k.b) bVar).F, b.this.c0, ((com.ubix.ssp.ad.k.b) b.this).N, (HashMap<String, String>) this.f9023a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.a(((com.ubix.ssp.ad.a) b.this).c, "ubix_sp_gold", "lsat" + ((com.ubix.ssp.ad.a) b.this).d, System.currentTimeMillis());
            u.e("set lsat by CLICK_TRIGGER_AREA_OOPS_CLICK");
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f9025a;
        final /* synthetic */ int b;
        final /* synthetic */ float[] c;

        f(long[] jArr, int i, float[] fArr) {
            this.f9025a = jArr;
            this.b = i;
            this.c = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.c0 != null && b.this.c0.getRootView() != null) {
                    long[] jArr = this.f9025a;
                    long j = jArr[0] + 5 + ((long) this.b);
                    jArr[0] = j;
                    long j2 = j + j;
                    long jCurrentTimeMillis = ((long) this.b) + System.currentTimeMillis();
                    float[] fArr = this.c;
                    MotionEvent motionEventObtain = MotionEvent.obtain(j2, jCurrentTimeMillis, 1, fArr[0], fArr[1], 0);
                    b.this.c0.getRootView().dispatchTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                b.this.h0.incrementAndGet();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class g implements com.ubix.ssp.ad.e.a0.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f9026a;

        g(HashMap map) {
            this.f9026a = map;
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a() {
            u.e("1111 onFinish");
            try {
                b bVar = b.this;
                com.ubix.ssp.ad.d.a aVar = ((com.ubix.ssp.ad.k.b) bVar).F;
                HashMap map = this.f9026a;
                int i = ((com.ubix.ssp.ad.k.b) b.this).F.o;
                boolean z = true;
                if (((com.ubix.ssp.ad.k.b) b.this).N.o() != 1) {
                    z = false;
                }
                bVar.a(aVar, 1, (HashMap<String, String>) map, i, z, (com.ubix.ssp.ad.g.c) null);
                b.this.r();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a(long j) {
            u.e("1111 onTick=" + j);
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void b() {
        }
    }

    class h extends com.ubix.ssp.ad.e.a0.b0.a.C1061a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f9027a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.ubix.ssp.ad.e.a0.b0.b.a() != 1 && h.this.f9027a.get()) {
                        h.this.f9027a.set(false);
                        if (b.this.i0.b()) {
                            b.this.i0.d();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        h(AtomicBoolean atomicBoolean) {
            this.f9027a = atomicBoolean;
        }

        @Override // com.ubix.ssp.ad.e.a0.b0.a.C1061a
        public void c(Activity activity) {
            super.c(activity);
            try {
                activity.getWindow().getDecorView().post(new a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.b0.a.C1061a
        public void e(Activity activity) {
            super.e(activity);
            try {
                if (com.ubix.ssp.ad.e.a0.b0.b.a() == 1) {
                    this.f9027a.set(true);
                    if (b.this.i0.b()) {
                        return;
                    }
                    b.this.i0.c();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public b(Context context, String str) {
        super(context, str);
        this.d0 = 5000;
        this.e0 = 5000;
        this.f0 = false;
        this.g0 = false;
        this.h0 = new AtomicInteger(0);
        this.j0 = false;
        this.k0 = 500;
        this.l0 = 0L;
        this.m0 = false;
        this.n0 = null;
        this.o0 = false;
        this.b0 = context;
        this.i = 1;
    }

    private boolean T() {
        com.ubix.ssp.ad.e.y.a.a aVar;
        if (this.c0 != null) {
            return true;
        }
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null || aVar.d == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("TEMPLATE_ID", this.F.f8604a.d.s);
        bundle.putInt("SKIP_VIEW_STYLE", this.N.f0());
        bundle.putInt("SKIP_COUNT_TIME", this.N.g0() == -1 ? this.e0 : this.N.g0() * 1000);
        bundle.putBoolean("IS_DOWNLOAD", com.ubix.ssp.ad.e.a0.c.a(this.F.f8604a.d));
        bundle.putInt("VIDEO_RENDER_TYPE", this.N.k0());
        bundle.putBoolean("SUPPORT_FEED_BACK", this.F.f8604a.k);
        bundle.putInt("S_A_T", this.N.c0());
        bundle.putLong("S_A_T_I", this.N.d0());
        bundle.putLong("G_B_U", this.N.K());
        u.e("get lsat by renderAd= " + v.c(this.b0, "ubix_sp_gold", "lsat" + this.d));
        bundle.putLong("L_S_A_T_I", v.c(this.b0, "ubix_sp_gold", "lsat" + this.d));
        bundle.putBoolean("IS_UNNAMED", this.N.G0());
        com.ubix.ssp.ad.b bVarA = com.ubix.ssp.ad.b.a(this.b0, bundle, 1, false);
        this.c0 = bVarA;
        if (bVarA == null) {
            a(0, com.ubix.ssp.ad.e.a0.a0.a.g(6, "创建ViewClass失败，请勿重试"));
            return false;
        }
        bVarA.setInnerListener(this);
        return true;
    }

    private String a(String str, boolean z, boolean z2) {
        File file = new File(k.f(com.ubix.ssp.ad.e.a0.c.e()), str.hashCode() + "");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        if (!z) {
            return null;
        }
        e(str, z2);
        return null;
    }

    private boolean a(long j, HashMap<String, String> map) {
        try {
            if (this.i0 != null) {
                return false;
            }
            com.ubix.ssp.ad.e.a0.g gVar = new com.ubix.ssp.ad.e.a0.g(j);
            this.i0 = gVar;
            gVar.a(new g(map));
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.i0.e();
            new com.ubix.ssp.ad.e.a0.b0.a((Application) StubApp.getOrigApplicationContext(this.b0.getApplicationContext())).a(new h(atomicBoolean));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private boolean a(com.ubix.ssp.ad.d.a aVar, boolean z) {
        if (aVar == null) {
            return false;
        }
        com.ubix.ssp.ad.e.y.a.a aVar2 = aVar.f8604a;
        com.ubix.ssp.ad.e.y.a.a.b bVar = aVar2.d;
        switch (bVar.s) {
            case 1001:
            case 1004:
                com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b = bVar.j[0];
                return (c1109b == null || TextUtils.isEmpty(c1109b.c)) ? false : true;
            case 1002:
            case 1005:
                b(aVar2, z);
                return true;
            case 1003:
            default:
                return false;
        }
    }

    private boolean a(com.ubix.ssp.ad.e.y.a.a aVar, boolean z) {
        com.ubix.ssp.ad.e.y.a.a.b.l lVar = aVar.d.k;
        if (lVar == null || TextUtils.isEmpty(lVar.b)) {
            return false;
        }
        if (z) {
            com.ubix.ssp.ad.e.v.e.b().a(aVar.d.k.c, (com.ubix.ssp.ad.e.v.e.b) null);
        }
        return a(aVar.d.k.b, z, false) != null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0129  */
    private boolean a(HashMap<String, String> map, Rect rect) {
        View viewFindViewById;
        StringBuilder sbAppend;
        boolean z;
        int i;
        com.ubix.ssp.ad.b bVar;
        boolean z2 = false;
        try {
            float[] fArr = new float[2];
            if (rect == null) {
                com.ubix.ssp.ad.b bVar2 = this.c0;
                if (bVar2 == null || (viewFindViewById = bVar2.findViewById(910301)) == null) {
                    z = false;
                    i = 1;
                } else {
                    Rect rect2 = new Rect();
                    viewFindViewById.getGlobalVisibleRect(rect2);
                    float fWidth = (float) (((double) (rect2.left + (rect2.width() * 0.15f))) + (((double) (rect2.width() * 0.7f)) * Math.random()));
                    float fHeight = (float) (((double) (rect2.top + (rect2.height() * 0.15f))) + (((double) (rect2.height() * 0.7f)) * Math.random()));
                    fArr[0] = fWidth;
                    fArr[1] = fHeight;
                    sbAppend = new StringBuilder("visibleRect=").append(rect2).append(";rx=").append(fWidth).append(";ry=").append(fHeight).append(";SystemClock.uptimeMillis()=").append(SystemClock.uptimeMillis());
                    u.e(sbAppend.toString());
                    i = 1;
                    z = true;
                }
            } else if (this.c0 != null) {
                Rect rect3 = new Rect();
                this.c0.getGlobalVisibleRect(rect3);
                int iWidth = rect3.width();
                int iHeight = rect3.height();
                int i2 = (int) (rect3.left + ((rect.left * iWidth) / 100.0f));
                rect3.left = i2;
                rect3.top = (int) (rect3.top + ((rect.top * iHeight) / 100.0f));
                rect3.right = (int) (rect3.right - ((iWidth * rect.right) / 100.0f));
                rect3.bottom = (int) (rect3.bottom - ((iHeight * rect.bottom) / 100.0f));
                float fWidth2 = (float) (((double) i2) + (((double) rect3.width()) * Math.random()));
                float fHeight2 = (float) (((double) rect3.top) + (((double) rect3.height()) * Math.random()));
                fArr[0] = fWidth2;
                fArr[1] = fHeight2;
                sbAppend = new StringBuilder("visibleRect use rect =").append(rect3).append(fWidth2).append(";ry=").append(fHeight2).append(";SystemClock.uptimeMillis()=").append(SystemClock.uptimeMillis());
                u.e(sbAppend.toString());
                i = 1;
                z = true;
            } else {
                z = false;
                i = 1;
            }
            try {
                long[] jArr = new long[i];
                jArr[0] = SystemClock.uptimeMillis();
                if (!z || (bVar = this.c0) == null || bVar.getRootView() == null) {
                    return z;
                }
                map.put("__CLICK_AREA__", BaseWrapper.ENTER_ID_AD_SDK);
                map.put("__CLICK_TRIGGER__", BaseWrapper.ENTER_ID_AD_SDK);
                map.put("__CLICK_UNREAL_TRIGGER__", BaseWrapper.ENTER_ID_AD_SDK);
                int iRandom = ((int) (Math.random() * 40.0d)) + 10;
                long j = jArr[0];
                MotionEvent motionEventObtain = MotionEvent.obtain(j, j, 0, fArr[0], fArr[1], 0);
                this.c0.getRootView().dispatchTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                this.c0.postDelayed(new f(jArr, iRandom, fArr), iRandom);
                return z;
            } catch (Throwable th) {
                th = th;
                z2 = z;
                th.printStackTrace();
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean b(com.ubix.ssp.ad.e.y.a.a aVar, boolean z) {
        return a(aVar, z);
    }

    private void c(com.ubix.ssp.ad.e.y.a.a aVar) {
        if (aVar != null) {
            try {
                this.N = a(aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void c(String str, boolean z) {
        com.ubix.ssp.ad.e.v.e.b().a(str, 5, new a(z));
    }

    private void c(HashMap<String, String> map) {
        com.ubix.ssp.ad.b bVar = this.c0;
        if (bVar != null) {
            bVar.postDelayed(new d(map), 100L);
        }
    }

    private void d(String str, boolean z) {
        if (TextUtils.isEmpty(this.F.f8604a.d.k.c)) {
            q(0);
        } else {
            c(this.F.f8604a.d.k.c, z);
        }
    }

    private boolean d(HashMap<String, String> map) {
        return BaseWrapper.ENTER_ID_AD_SDK.equals(map.get("__CLICK_UNREAL_TRIGGER__")) || "6".equals(map.get("__CLICK_AREA__")) || "3".equals(map.get("__CLICK_AREA__"));
    }

    private void e(String str, boolean z) {
        com.ubix.ssp.ad.e.v.e.c().a(str, new C1123b(z));
    }

    private void m(com.ubix.ssp.ad.d.a aVar) {
        this.J = true;
        p(aVar);
    }

    private void p(com.ubix.ssp.ad.d.a aVar) {
        super.v();
        c(aVar.f8604a);
        c(aVar.f8604a, true);
        if (this.a0 == null || this.f0) {
            return;
        }
        this.a0.onAdResponseSucceed();
        T();
    }

    private boolean t(int i) {
        int i2;
        if (this.o0) {
            return true;
        }
        Bundle bundle = new Bundle();
        u.a(Z, "showAdWithType type:" + i);
        if (i == 1002 || i == 1005) {
            bundle = a(this.F.f8604a.d.k.c);
            bundle.putString("VIDEO_URL", this.F.f8604a.d.k.b);
            bundle.putBoolean("IS_VIDEO", true);
            bundle.putBoolean("AUTO_MUTE", false);
            bundle.putInt("VIDEO_RENDER_TYPE", this.N.k0());
        } else if (i == 1001 || i == 1004) {
            bundle = a(this.F.f8604a.d.j[0].c);
            bundle.putBoolean("IS_VIDEO", false);
        }
        if (this.N.b()) {
            bundle.putString("AD_SOURCE", this.F.f8604a.d.t);
        }
        com.ubix.ssp.ad.e.y.a.a.b.f fVar = this.F.f8604a.d.L;
        if (fVar != null && (i2 = fVar.b) != 0) {
            bundle.putInt("RENDER_MODE", i2);
            bundle.putFloat("SCALE_IGNORE_PERCENT", (this.F.f8604a.d.L.c * 1.0f) / 100.0f);
            bundle.putInt("SCALE_HORIZONTAL_MARGIN", this.F.f8604a.d.L.d);
            bundle.putInt("SCALE_VERTICAL_MARGIN", this.F.f8604a.d.L.e);
        }
        bundle.putBoolean("IS_UNNAMED", this.N.G0());
        bundle.putInt("SKIP_VIEW_STYLE", this.N.f0());
        bundle.putInt("SKIP_COUNT_TIME", this.N.g0() == -1 ? this.e0 : this.N.g0() * 1000);
        com.ubix.ssp.ad.b bVar = this.c0;
        if (bVar != null) {
            bVar.b(bundle);
        }
        this.o0 = true;
        return true;
    }

    @Override // com.ubix.ssp.ad.k.b
    public String B() {
        return l(1);
    }

    @Override // com.ubix.ssp.ad.k.b
    public ParamsReview C() {
        return super.a(this.F.f8604a, this.N.x0(), this.N.H0());
    }

    @Override // com.ubix.ssp.ad.k.b
    public long D() {
        return super.g(this.F);
    }

    @Override // com.ubix.ssp.ad.k.b
    public String E() {
        return super.E();
    }

    @Override // com.ubix.ssp.ad.k.b
    public void O() {
        this.f.sendEmptyMessage(3);
        super.m(1);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.g.k.b
    public void a(int i) {
        a(this.F, this.N);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.g.k.j
    public void a(int i, long j, long j2) {
        super.a(i, j, j2);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.g.k.b
    public void a(int i, Bundle bundle) {
        super.a(bundle);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.g.k.b
    public void a(int i, View view) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        String str;
        y();
        d(this.F);
        c(this.F);
        com.ubix.ssp.ad.g.i iVar = this.a0;
        if (iVar != null) {
            iVar.onAdExposed();
        }
        b(this.c0, this.N);
        a(this.c0, this.N);
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null || (bVar = aVar.d) == null || (str = bVar.i) == null) {
            return;
        }
        f(str);
    }

    @Override // com.ubix.ssp.ad.g.k.i
    public void a(int i, View view, HashMap<String, String> map) {
        if (this.q) {
            return;
        }
        if (map == null) {
            map = this.c0.getClickMap();
            map.put("__CLICK_TRIGGER__", "");
        }
        u.e("onAdClicked =" + map.get("__CLICK_TRIGGER__"));
        try {
            boolean zM0 = this.N.m0();
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z = zM0 && this.N.q0() && d(map) && !this.F.w && jCurrentTimeMillis - this.B > this.N.m() && !map.containsKey("__MULTI_CLICK_KEY__");
            u.e("是否满足条件：" + z);
            if (z) {
                this.B = jCurrentTimeMillis;
                this.j0 = true;
                map.put("__CLICK_AREA__", BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING);
                map.remove("__CLICK_UNREAL_TRIGGER__");
                if (!this.m0) {
                    this.m0 = true;
                    q();
                }
                this.n0 = map;
                com.ubix.ssp.ad.e.a0.c.y();
                com.ubix.ssp.ad.e.a0.c.d.execute(new c());
                return;
            }
            if (("3".equals(map.get("__CLICK_TRIGGER__")) || "6".equals(map.get("__CLICK_TRIGGER__"))) && System.currentTimeMillis() - this.l0 > this.k0) {
                this.l0 = System.currentTimeMillis();
                if (this.N.b0() == 1) {
                    a(map, (Rect) null);
                    return;
                } else if (this.N.b0() == 2 && this.N.a0() != null) {
                    a(map, this.N.a0());
                    if (this.c0 != null) {
                        c(map);
                        return;
                    }
                }
            }
            a(this.F, this.c0, this.N, map);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.a
    protected void a(int i, com.ubix.ssp.ad.d.a aVar) {
        super.a(i, aVar);
        try {
            a(this.c0.getContext(), this.N.y0(), this.N.k());
            if (com.ubix.ssp.ad.d.b.v) {
                a(this.c0.getContext(), this.F, this.c0.getClickMap());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.k.b
    public void a(int i, AdError adError) {
        super.c(adError);
        this.f0 = true;
        this.f.removeMessages(3);
        this.f.removeMessages(4);
        if (this.a0 == null || this.g0) {
            return;
        }
        this.g0 = true;
        super.a(adError);
        this.a0.onAdLoadFailed(adError);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.a
    protected void a(int i, Object... objArr) {
        if (this.N.n0() && i != 0) {
            super.a(i, objArr);
        }
        u.e("runClickCallback " + i + ";canRun=" + ((!this.N.n0() && i == 0) || (this.N.n0() && i != 0)));
        if (((this.N.n0() || i != 0) && (!this.N.n0() || i == 0)) || this.a0 == null || this.N.m0()) {
            return;
        }
        this.a0.onAdClicked(null);
    }

    @Override // com.ubix.ssp.ad.k.b
    public void a(long j) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null) {
            return;
        }
        super.a(aVar, j);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.a
    protected void a(Message message) {
        String str;
        String str2;
        com.ubix.ssp.ad.d.a aVarB;
        AdError adErrorK;
        String str3;
        StringBuilder sb;
        int i = message.what;
        if (i == 3) {
            Message message2 = new Message();
            message2.what = 4;
            message2.setAsynchronous(true);
            this.f.sendMessageDelayed(message2, this.d0);
            str = Z;
            str2 = "ad is start requestTimeout:" + this.d0 + "ms";
        } else {
            if (i != 4) {
                if (i != 5) {
                    if (i != 6) {
                        switch (i) {
                            case 12:
                                m();
                                break;
                        }
                        return;
                    }
                    b((AdError) message.obj);
                    return;
                }
                com.ubix.ssp.ad.d.a aVar = (com.ubix.ssp.ad.d.a) ((List) message.obj).get(0);
                this.F = aVar;
                com.ubix.ssp.ad.d.a aVarB2 = b(aVar, true);
                this.F = aVarB2;
                if (aVarB2 != null && aVarB2.b) {
                    if (a(aVarB2, false)) {
                        aVarB = this.F;
                        m(aVarB);
                        u.c(Z, "ad is loadSuccess:");
                        return;
                    } else {
                        adErrorK = com.ubix.ssp.ad.e.a0.a0.a.h(1, "加载本地文件失败");
                        b(adErrorK);
                        str3 = Z;
                        sb = new StringBuilder("ad is loadFail code:");
                        u.c(str3, sb.append(adErrorK.getErrorCode()).append(";msg:").append(adErrorK.getErrorMessage()).toString());
                        return;
                    }
                }
                aVarB = b(aVarB2, true);
                this.F = aVarB;
                if (aVarB == null) {
                    adErrorK = com.ubix.ssp.ad.e.a0.a0.a.k(3, "加载本地文件失败");
                    a(0, adErrorK);
                    str3 = Z;
                    sb = new StringBuilder("ad is renderFail code:");
                    u.c(str3, sb.append(adErrorK.getErrorCode()).append(";msg:").append(adErrorK.getErrorMessage()).toString());
                    return;
                }
                m(aVarB);
                u.c(Z, "ad is loadSuccess:");
                return;
            }
            h(com.ubix.ssp.ad.e.a0.a0.a.k(3, oOO00O0.ubix_timeout_msg));
            str = Z;
            str2 = "ad is timeout";
        }
        u.e(str, str2);
    }

    public void a(ViewGroup viewGroup) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        x();
        if (viewGroup == null) {
            AdError adErrorB = com.ubix.ssp.ad.e.a0.a0.a.b(5, "广告外层为空或者广告不可见");
            d(adErrorB);
            com.ubix.ssp.ad.g.i iVar = this.a0;
            if (iVar != null) {
                iVar.onAdExposeFailed(adErrorB);
            }
            this.a0 = null;
            return;
        }
        if (this.f0) {
            AdError adErrorD = com.ubix.ssp.ad.e.a0.a0.a.d(6, "加载本地文件失败");
            d(adErrorD);
            com.ubix.ssp.ad.g.i iVar2 = this.a0;
            if (iVar2 != null) {
                iVar2.onAdExposeFailed(adErrorD);
                return;
            }
            return;
        }
        if (J()) {
            AdError adErrorC = com.ubix.ssp.ad.e.a0.a0.a.c(3, "广告重复展示");
            d(adErrorC);
            com.ubix.ssp.ad.g.i iVar3 = this.a0;
            if (iVar3 != null) {
                iVar3.onAdExposeFailed(adErrorC);
                return;
            }
            return;
        }
        if (!K()) {
            AdError adErrorD2 = com.ubix.ssp.ad.e.a0.a0.a.d(5, "内容加载失败");
            d(adErrorD2);
            com.ubix.ssp.ad.g.i iVar4 = this.a0;
            if (iVar4 != null) {
                iVar4.onAdExposeFailed(adErrorD2);
                return;
            }
            return;
        }
        if (I()) {
            AdError adErrorD3 = com.ubix.ssp.ad.e.a0.a0.a.d(4, "文件已经过期");
            d(adErrorD3);
            com.ubix.ssp.ad.g.i iVar5 = this.a0;
            if (iVar5 != null) {
                iVar5.onAdExposeFailed(adErrorD3);
            }
            this.a0 = null;
            return;
        }
        if (this.c0 == null) {
            T();
        }
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null || (bVar = aVar.d) == null || !t(bVar.s)) {
            AdError adErrorD4 = com.ubix.ssp.ad.e.a0.a0.a.d(9, "内容加载失败");
            d(adErrorD4);
            com.ubix.ssp.ad.g.i iVar6 = this.a0;
            if (iVar6 != null) {
                iVar6.onAdExposeFailed(adErrorD4);
            }
            this.a0 = null;
            return;
        }
        com.ubix.ssp.ad.e.y.a.a.b bVar2 = this.F.f8604a.d;
        try {
            if (com.ubix.ssp.ad.e.a0.c.a(bVar2)) {
                this.c0.a(bVar2.g, bVar2.A, bVar2.z, bVar2.h, bVar2.H, bVar2.I, bVar2.G);
            }
            if (this.a0 != null && !this.g0) {
                this.g0 = true;
                this.f.removeMessages(3);
                this.f.removeMessages(4);
                super.u();
                this.a0.onAdLoadSucceed();
            }
            try {
                viewGroup.addView(this.c0);
            } catch (Throwable unused) {
                AdError adErrorC2 = com.ubix.ssp.ad.e.a0.a0.a.c(3, "广告重复展示");
                d(adErrorC2);
                com.ubix.ssp.ad.g.i iVar7 = this.a0;
                if (iVar7 != null) {
                    iVar7.onAdExposeFailed(adErrorC2);
                }
            }
            this.K = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            AdError adErrorD5 = com.ubix.ssp.ad.e.a0.a0.a.d(10, "合规六要素创建失败");
            d(adErrorD5);
            com.ubix.ssp.ad.g.i iVar8 = this.a0;
            if (iVar8 != null) {
                iVar8.onAdExposeFailed(adErrorD5);
            }
            this.a0 = null;
        }
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.a
    protected void a(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        super.a(aVar, map);
        try {
            this.g = false;
            this.c0.o();
        } catch (Exception unused) {
        }
    }

    public void a(com.ubix.ssp.ad.g.i iVar) {
        this.a0 = iVar;
    }

    @Override // com.ubix.ssp.ad.g.k.i
    public boolean a(int i, long j) {
        u.e("onAdSkipped =" + this.a0);
        com.ubix.ssp.ad.b bVar = this.c0;
        if (bVar != null) {
            bVar.i();
        }
        com.ubix.ssp.ad.d.a aVar = this.F;
        b(aVar.f8604a, super.a(aVar, this.H, this.G, 5000L));
        com.ubix.ssp.ad.g.i iVar = this.a0;
        if (iVar != null) {
            iVar.onAdSkipped();
        }
        p();
        if (this.j0) {
            a(this.N.n() + this.N.l(), this.n0);
        }
        this.a0 = null;
        return false;
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.a
    protected boolean a(com.ubix.ssp.ad.d.a aVar, boolean z, HashMap<String, String> map) {
        try {
            int iB = com.ubix.ssp.ad.e.s.b.c().b(aVar.o);
            b(aVar);
            if (iB == 47) {
                this.r = null;
            }
            if (!z && iB == 44) {
                com.ubix.ssp.ad.e.s.b.c().a(this.c, aVar.o);
                SoftReference<com.ubix.ssp.ad.e.z.h> softReference = this.s;
                if (softReference != null && softReference.get() != null) {
                    ((com.ubix.ssp.ad.e.z.e) this.s.get()).setText("下载继续");
                }
                return false;
            }
            if (iB == 45) {
                com.ubix.ssp.ad.e.s.b.c().b(this.c, aVar.o);
                if (this.r == null) {
                    this.r = a(map, this.e.indexOf(aVar), this.y);
                }
                com.ubix.ssp.ad.e.s.c.a().a(this.r);
                return false;
            }
            if (iB == 43 || iB == 46) {
                if (this.r == null) {
                    this.r = a(map, this.e.indexOf(aVar), this.y);
                }
                com.ubix.ssp.ad.e.s.c.a().a(this.r);
            }
            if (this.r != null) {
                return true;
            }
            com.ubix.ssp.ad.e.s.c cVarA = com.ubix.ssp.ad.e.s.c.a();
            com.ubix.ssp.ad.a.z zVarA = a(map, this.e.indexOf(aVar), this.y);
            this.r = zVarA;
            cVarA.a(zVarA);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    protected com.ubix.ssp.ad.d.a b(com.ubix.ssp.ad.d.a aVar, boolean z) {
        if (aVar != null && a(aVar, z)) {
            return aVar;
        }
        return null;
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.g.k.b
    public void b(int i) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null || aVar.d == null) {
            return;
        }
        if (this.N.y() != 1) {
            com.ubix.ssp.ad.e.a0.f.a(this.b0, this.F.f8604a.d.F, 1, this.N, this.d, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("TYPE", 6);
        bundle.putString("TITLE", "应用介绍");
        bundle.putString("TARGET_URL", this.F.f8604a.d.F);
        com.ubix.ssp.ad.e.a0.c.a(this.b0, bundle, (com.ubix.ssp.ad.e.z.h.c) null, (com.ubix.ssp.ad.e.z.h.b) null);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.g.k.b
    public void b(int i, View view, HashMap<String, String> map) {
        if (this.q) {
            return;
        }
        if (map == null) {
            map = this.c0.getClickMap();
            map.put("__CLICK_TRIGGER__", "");
        }
        if ("15".equals(map.get("__CLICK_TRIGGER__"))) {
            com.ubix.ssp.ad.e.a0.c.y();
            com.ubix.ssp.ad.e.a0.c.d.execute(new e());
        }
        a(this.F, this.c0, this.N, map);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.a
    protected void b(int i, com.ubix.ssp.ad.d.a aVar) {
        com.ubix.ssp.ad.b bVar;
        super.b(i, aVar);
        if (i == 3) {
            com.ubix.ssp.ad.b bVar2 = this.c0;
            if (bVar2 != null) {
                bVar2.o();
            }
            a(2, new Object[0]);
            return;
        }
        if (i != 2 || (bVar = this.c0) == null) {
            return;
        }
        bVar.o();
    }

    @Override // com.ubix.ssp.ad.a
    protected void b(AdError adError) {
        super.b(adError);
        super.a(adError);
        this.f.removeMessages(3);
        this.f.removeMessages(4);
        com.ubix.ssp.ad.g.i iVar = this.a0;
        if (iVar != null) {
            iVar.onAdLoadFailed(adError);
        }
        this.a0 = null;
    }

    @Override // com.ubix.ssp.ad.k.b
    public void b(HashMap<String, String> map) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null) {
            return;
        }
        super.a(aVar, map);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.a
    protected boolean b(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        if (i()) {
            map.remove("__CLICK_AREA__");
            map.remove("__CLICK_TRIGGER__");
            map.remove("__CLICK_UNREAL_TRIGGER__");
        } else {
            super.b(aVar, map);
            com.ubix.ssp.ad.b bVar = this.c0;
            if (bVar != null) {
                bVar.k();
                if (com.ubix.ssp.ad.d.b.E == 1 && this.c0.m()) {
                    this.c0.a(this.N.B(), this.N.A());
                }
            }
            int iA = a(aVar, 1, map, aVar.o, this.N.o() == 1, (com.ubix.ssp.ad.g.c) null);
            map.remove("__CLICK_AREA__");
            map.remove("__CLICK_UNREAL_TRIGGER__");
            if (iA == 4 || iA == 6) {
                com.ubix.ssp.ad.b bVar2 = this.c0;
                if (bVar2 != null) {
                    bVar2.o();
                }
                a(4, new Object[0]);
            } else if (iA == 2 || iA == 31) {
                if (iA == 31) {
                    g((String) null);
                }
                this.c0.c(iA, this.N.M());
                a(this.c0.getContext(), aVar, map);
                a(this.c0.getContext(), this.N.y0(), this.N.k());
                if (com.ubix.ssp.ad.d.b.v) {
                    String str = aVar.f8604a.d.J;
                    a(this.c0.getContext(), str, c(str));
                }
            } else if (iA == 22) {
                this.c0.c(iA, this.N.M());
                b(this.c0.getContext(), aVar, map, this.N.q());
            } else if (iA == 23) {
                a(this.c0.getContext(), aVar, map, this.N.q());
                a(2, new Object[0]);
            } else if (iA == 3) {
                b(StubApp.getOrigApplicationContext(this.b0.getApplicationContext()));
            } else if (iA == 5) {
                a(this.c0.getContext(), aVar, map);
            } else if (iA == 33) {
                a(33, new Object[0]);
            } else {
                a(1, new Object[0]);
            }
            this.j0 = false;
            a(0, new Object[0]);
            map.put("__MULTI_CLICK_KEY__", "TRUE");
        }
        return true;
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.a
    protected void c(Context context, Intent intent, long j, BroadcastReceiver broadcastReceiver) {
        super.c(context, intent, j, broadcastReceiver);
        a(3, new Object[0]);
    }

    protected boolean c(com.ubix.ssp.ad.e.y.a.a aVar, boolean z) {
        String str;
        StringBuilder sbAppend;
        try {
            com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.d;
            int i = bVar.s;
            if (i == 1002 || i == 1005) {
                d(bVar.k.b, z);
                str = Z;
                sbAppend = new StringBuilder("material preloadVideo:").append(aVar.d.k.b);
            } else {
                if (i != 1001 && i != 1004) {
                    return true;
                }
                c(bVar.j[0].c, z);
                str = Z;
                sbAppend = new StringBuilder("material preloadImage:").append(aVar.d.j[0].c);
            }
            u.e(str, sbAppend.toString());
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.d("------preLoadImg Exception " + e2.getMessage());
            AdError adErrorG = com.ubix.ssp.ad.e.a0.a0.a.g(5, "图片资源链接异常");
            a(0, adErrorG);
            u.c(Z, "ad is material fail code:" + adErrorG.getErrorCode() + "msg:" + adErrorG.getErrorMessage());
            return false;
        }
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.g.k.b
    public void e(int i) {
        com.ubix.ssp.ad.b bVar = this.c0;
        if (bVar != null) {
            bVar.i();
        }
        com.ubix.ssp.ad.d.a aVar = this.F;
        b(aVar.f8604a, super.a(aVar, 5000L, this.G, 5000L));
        com.ubix.ssp.ad.g.i iVar = this.a0;
        if (iVar != null) {
            iVar.onAdClosed();
        }
        n();
        if (this.j0) {
            a(this.N.n() + this.N.l(), this.n0);
        }
        this.a0 = null;
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.g.k.b
    public void f(int i) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null || aVar.d == null) {
            return;
        }
        if (this.N.y() != 1) {
            com.ubix.ssp.ad.e.a0.f.a(this.b0, this.F.f8604a.d.C, 1, this.N, this.d, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("TYPE", 6);
        bundle.putString("TITLE", "权限");
        bundle.putString("TARGET_URL", this.F.f8604a.d.C);
        com.ubix.ssp.ad.e.a0.c.a(this.b0, bundle, (com.ubix.ssp.ad.e.z.h.c) null, (com.ubix.ssp.ad.e.z.h.b) null);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.a
    public void h() {
        ViewGroup viewGroup;
        super.h();
        try {
            SoftReference<com.ubix.ssp.ad.e.z.h> softReference = this.s;
            if (softReference != null && softReference.get() != null && !this.s.get().c()) {
                this.s.get().a();
            }
            if (this.c0 != null) {
                if (com.ubix.ssp.ad.d.b.J && (viewGroup = (ViewGroup) this.c0.getParent()) != null) {
                    viewGroup.removeView(this.c0);
                }
                this.c0.i();
                this.c0.j();
                this.c0 = null;
            }
            this.a0 = null;
        } catch (Exception unused) {
        }
    }

    protected void h(AdError adError) {
        super.a(adError);
        this.f.removeMessages(3);
        this.f.removeMessages(4);
        com.ubix.ssp.ad.g.i iVar = this.a0;
        if (iVar != null) {
            iVar.onAdLoadFailed(adError);
        }
        this.a0 = null;
    }

    @Override // com.ubix.ssp.ad.k.b
    public void h(String str) {
        if (TextUtils.isEmpty(str)) {
            b(com.ubix.ssp.ad.e.a0.a0.a.j(10, "竞价广告体为空或解析异常，请检查传入的参数是否正确"));
        } else {
            e(str);
        }
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.g.k.b
    public void i(int i) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null || aVar.d == null) {
            return;
        }
        if (this.N.y() != 1) {
            com.ubix.ssp.ad.e.a0.f.a(this.b0, this.F.f8604a.d.B, 1, this.N, this.d, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("TYPE", 6);
        bundle.putString("TITLE", "隐私");
        bundle.putString("TARGET_URL", this.F.f8604a.d.B);
        com.ubix.ssp.ad.e.a0.c.a(this.b0, bundle, (com.ubix.ssp.ad.e.z.h.c) null, (com.ubix.ssp.ad.e.z.h.b) null);
    }

    @Override // com.ubix.ssp.ad.k.b, com.ubix.ssp.ad.a
    protected AdError j(com.ubix.ssp.ad.d.a aVar) {
        int i;
        String str;
        com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b;
        com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.f8604a.d;
        int i2 = bVar.s;
        if (i2 == 1001 || i2 == 1004) {
            com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr = bVar.j;
            if (c1109bArr != null && c1109bArr.length != 0 && (c1109b = c1109bArr[0]) != null && !TextUtils.isEmpty(c1109b.c)) {
                return null;
            }
            i = 10;
            str = "图片资源链接异常";
        } else if (i2 == 1002 || i2 == 1005) {
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

    @Override // com.ubix.ssp.ad.k.b
    public void q(int i) {
        super.w();
        this.f.removeMessages(3);
        this.f.removeMessages(4);
        t(this.F.f8604a.d.s);
        if (this.a0 == null || this.g0) {
            return;
        }
        this.g0 = true;
        super.u();
        this.a0.onAdLoadSucceed();
    }

    public void r(int i) {
        String str;
        if (this.f.hasMessages(3)) {
            str = "Timer has been started,set it ahead of loadAd()";
        } else {
            if (i >= 3000 && i <= 30000) {
                this.d0 = i;
                return;
            }
            str = "Timeout must between 3*1000 and 30*1000 milliseconds";
        }
        u.a(str);
    }

    public void s(int i) {
        int i2 = 3000;
        if (i >= 3000) {
            i2 = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
            if (i <= 30000) {
                this.e0 = i;
                return;
            }
        }
        this.e0 = i2;
    }
}

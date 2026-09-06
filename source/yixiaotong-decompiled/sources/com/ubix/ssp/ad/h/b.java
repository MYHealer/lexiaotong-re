package com.ubix.ssp.ad.h;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.f;
import com.ubix.ssp.ad.e.a0.l;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.g.c;
import com.ubix.ssp.ad.g.k.e;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.ParamsReview;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends com.ubix.ssp.ad.a implements e {
    private com.ubix.ssp.ad.g.e C;
    private com.ubix.ssp.ad.b D;
    private Context E;
    private com.ubix.ssp.ad.d.a F;
    private l G;
    private Dialog H;
    private com.ubix.ssp.ad.d.l I;
    private boolean J;
    private boolean K;
    private boolean L;
    boolean M;
    private c N;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8966a;

        a(Context context) {
            this.f8966a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.I.z() == 1) {
                    b bVar = b.this;
                    bVar.H = com.ubix.ssp.ad.e.a0.c.a(this.f8966a, bVar.D);
                    b.this.H.show();
                } else {
                    b bVar2 = b.this;
                    bVar2.G = new l(bVar2.D, 0, 0);
                    b.this.G.b(((Activity) this.f8966a).getWindow().getDecorView(), 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                AdError adErrorD = com.ubix.ssp.ad.e.a0.a0.a.d(5, "创建/展示Popupwindow失败");
                b.this.d(adErrorD);
                if (b.this.C != null) {
                    b.this.C.onAdExposeFailed(adErrorD);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.h.b$b, reason: collision with other inner class name */
    class C1116b implements com.ubix.ssp.ad.e.v.e.b {

        /* JADX INFO: renamed from: com.ubix.ssp.ad.h.b$b$a */
        class a implements com.ubix.ssp.ad.e.v.e.b {
            a() {
            }

            @Override // com.ubix.ssp.ad.e.v.e.b
            public void a(com.ubix.ssp.ad.e.v.e eVar, String str, String str2, boolean z) {
            }

            @Override // com.ubix.ssp.ad.e.v.e.b
            public void a(AdError adError) {
            }
        }

        C1116b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(com.ubix.ssp.ad.e.v.e eVar, String str, String str2, boolean z) {
            try {
                ((com.ubix.ssp.ad.e.v.a) eVar).c(str);
                if (eVar.b(str) == null) {
                    b.this.a(0, com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误"));
                    return;
                }
                if (b.this.I()) {
                    com.ubix.ssp.ad.e.v.e.c().a(b.this.F.f8604a.d.k.b, new a());
                }
                b.this.n(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
            b.this.a(0, adError);
        }
    }

    public b(Context context, String str) {
        super(context, str);
        this.M = false;
        this.E = context;
        this.i = 6;
    }

    private boolean E() {
        com.ubix.ssp.ad.d.l lVar;
        return this.F != null && (lVar = this.I) != null && lVar.l0() && System.currentTimeMillis() / 1000 > this.F.j;
    }

    private boolean F() {
        return this.K;
    }

    private boolean G() {
        return this.J;
    }

    private void K() {
        try {
            com.ubix.ssp.ad.e.v.e.b().a(I() ? this.F.f8604a.d.k.c : this.F.f8604a.d.j[0].c, new C1116b());
        } catch (Throwable th) {
            th.printStackTrace();
            a(0, com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误"));
        }
    }

    private void m(com.ubix.ssp.ad.d.a aVar) {
        n(aVar);
    }

    public String B() {
        return l(6);
    }

    public ParamsReview C() {
        return super.a(this.F.f8604a, this.I.x0(), this.I.H0());
    }

    public long D() {
        return super.g(this.F);
    }

    public boolean H() {
        return (!G() || F() || E()) ? false : true;
    }

    public boolean I() {
        com.ubix.ssp.ad.d.a aVar = this.F;
        if (aVar == null) {
            return false;
        }
        int i = aVar.f8604a.d.s;
        return i == 6012 || i == 6013 || i == 6014;
    }

    public void J() {
        super.m(6);
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void a(int i) {
        a(this.F, this.I);
    }

    @Override // com.ubix.ssp.ad.g.k.e
    public void a(int i, long j, long j2) {
        if (j2 > 0) {
            a(this.F, i, j, j2, 0L);
            if (i <= 98 || this.M) {
                return;
            }
            this.M = true;
            com.ubix.ssp.ad.d.a aVar = this.F;
            b(aVar.f8604a, a(aVar, j, j2, j2));
        }
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void a(int i, Bundle bundle) {
        super.a(bundle);
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void a(int i, View view) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        String str;
        super.y();
        this.K = true;
        d(this.F);
        c(this.F);
        com.ubix.ssp.ad.g.e eVar = this.C;
        if (eVar != null) {
            eVar.onAdExposed();
        }
        b(this.D, this.I);
        a(this.D, this.I);
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null || (bVar = aVar.d) == null || (str = bVar.i) == null) {
            return;
        }
        f(str);
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(int i, com.ubix.ssp.ad.d.a aVar) {
        super.a(i, aVar);
        try {
            a(this.D.getContext(), this.F, this.D.getClickMap());
            e(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i, AdError adError) {
        super.c(adError);
        super.a(adError);
        this.J = false;
        com.ubix.ssp.ad.g.e eVar = this.C;
        if (eVar != null) {
            eVar.onAdLoadFailed(adError);
        }
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(int i, Object... objArr) {
        if (this.I.n0() && i != 0) {
            super.a(i, objArr);
        }
        u.e("runClickCallback " + i + ";canRun=" + ((!this.I.n0() && i == 0) || (this.I.n0() && i != 0)));
        if (((this.I.n0() || i != 0) && (!this.I.n0() || i == 0)) || this.C == null || this.I.m0()) {
            return;
        }
        this.C.onAdClicked();
        if (!this.I.n0() || i == 4) {
            return;
        }
        e(0);
    }

    public void a(long j) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null) {
            return;
        }
        super.a(aVar, j);
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(Context context, Intent intent, long j, BroadcastReceiver broadcastReceiver) {
        super.a(context, intent, j, broadcastReceiver);
        if (this.I.n0()) {
            e(0);
        }
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(Message message) {
        int i = message.what;
        if (i != 5) {
            if (i != 6) {
                if (i != 10) {
                    if (i != 11) {
                        return;
                    }
                }
            }
            b((AdError) message.obj);
            return;
        }
        com.ubix.ssp.ad.d.a aVar = (com.ubix.ssp.ad.d.a) ((List) message.obj).get(0);
        this.F = aVar;
        m(aVar);
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        super.a(aVar, map);
        try {
            this.g = false;
            if (this.r != null) {
                com.ubix.ssp.ad.e.s.c.a().a(this.r, null);
            }
            com.ubix.ssp.ad.b bVar = this.D;
            if (bVar != null) {
                if (com.ubix.ssp.ad.d.b.E == 1 && bVar.m()) {
                    return;
                }
                this.D.a((ImageView) null);
            }
        } catch (Exception unused) {
        }
    }

    public void a(com.ubix.ssp.ad.g.e eVar) {
        this.C = eVar;
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void b(int i) {
        f.a(this.E, this.e.get(i).f8604a.d.F, 0, this.I, this.d, null);
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void b(int i, View view, HashMap<String, String> map) {
        if (map == null) {
            map = this.D.getClickMap();
            map.put("__CLICK_TRIGGER__", "");
        }
        a(this.F, this.D, this.I, map);
    }

    @Override // com.ubix.ssp.ad.a
    protected void b(int i, com.ubix.ssp.ad.d.a aVar) {
        super.b(i, aVar);
        if (i == 3) {
            a(2, new Object[0]);
        }
        e(0);
    }

    @Override // com.ubix.ssp.ad.a
    protected void b(AdError adError) {
        super.b(adError);
        super.a(adError);
        com.ubix.ssp.ad.g.e eVar = this.C;
        if (eVar != null) {
            eVar.onAdLoadFailed(adError);
        }
    }

    public void b(HashMap<String, String> map) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null) {
            return;
        }
        super.a(aVar, map);
    }

    @Override // com.ubix.ssp.ad.a
    protected boolean b(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        if (!i()) {
            super.b(aVar, map);
            com.ubix.ssp.ad.b bVar = this.D;
            if (bVar != null && com.ubix.ssp.ad.d.b.E == 1 && bVar.m()) {
                this.D.a(this.I.B(), this.I.A());
            }
            int iA = a(aVar, 6, map, aVar.o, this.I.o() == 1, this.N);
            if (iA == 4 || iA == 6) {
                a(4, new Object[0]);
            } else if (iA == 22) {
                b(this.D.getContext(), aVar, map, this.I.q());
            } else if (iA == 23) {
                a(this.D.getContext(), aVar, map, this.I.q());
                a(2, new Object[0]);
            } else if (iA == 2 || iA == 5 || iA == 31) {
                if (iA == 31) {
                    g((String) null);
                }
                a(this.D.getContext(), aVar, map);
            } else if (iA == 3) {
                b(StubApp.getOrigApplicationContext(this.E.getApplicationContext()));
            } else if (iA == 33) {
                a(33, new Object[0]);
            } else {
                a(1, new Object[0]);
            }
            try {
                a(0, new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            map.put("__MULTI_CLICK_KEY__", "TRUE");
            if (!this.I.n0() && iA != 6 && iA != 32) {
                e(0);
            }
        }
        return true;
    }

    public void c(Context context) {
        Bundle bundleA;
        Bitmap bitmapB;
        int width;
        int i;
        x();
        if (context == null) {
            AdError adErrorB = com.ubix.ssp.ad.e.a0.a0.a.b(4, "Activity/Context为空");
            d(adErrorB);
            com.ubix.ssp.ad.g.e eVar = this.C;
            if (eVar != null) {
                eVar.onAdExposeFailed(adErrorB);
                return;
            }
            return;
        }
        int iG0 = 5;
        if (!G()) {
            AdError adErrorD = com.ubix.ssp.ad.e.a0.a0.a.d(5, "内容加载失败");
            d(adErrorD);
            com.ubix.ssp.ad.g.e eVar2 = this.C;
            if (eVar2 != null) {
                eVar2.onAdExposeFailed(adErrorD);
                return;
            }
            return;
        }
        if (F()) {
            AdError adErrorC = com.ubix.ssp.ad.e.a0.a0.a.c(3, "广告重复展示");
            d(adErrorC);
            com.ubix.ssp.ad.g.e eVar3 = this.C;
            if (eVar3 != null) {
                eVar3.onAdExposeFailed(adErrorC);
            }
        }
        if (E()) {
            AdError adErrorD2 = com.ubix.ssp.ad.e.a0.a0.a.d(4, "文件已经过期");
            d(adErrorD2);
            com.ubix.ssp.ad.g.e eVar4 = this.C;
            if (eVar4 != null) {
                eVar4.onAdExposeFailed(adErrorD2);
                return;
            }
            return;
        }
        try {
            if (I()) {
                bundleA = a(this.F.f8604a.d.k.c);
                bundleA.putInt("VIDEO_RENDER_TYPE", this.I.k0());
                bitmapB = com.ubix.ssp.ad.e.v.e.b().b(this.F.f8604a.d.k.c);
                bundleA.putString("VIDEO_URL", this.F.f8604a.d.k.b);
                bundleA.putBoolean("AUTO_MUTE", this.I.K0());
                width = bitmapB.getWidth();
            } else {
                bundleA = a(this.F.f8604a.d.j[0].c);
                com.ubix.ssp.ad.e.v.e.b().c(this.F.f8604a.d.j[0].c);
                bitmapB = com.ubix.ssp.ad.e.v.e.b().b(this.F.f8604a.d.j[0].c);
                width = bitmapB.getWidth();
            }
            bundleA.putInt("AD_WIDTH", width);
            bundleA.putInt("AD_HEIGHT", bitmapB.getHeight());
            bundleA.putBoolean("IS_DOWNLOAD", com.ubix.ssp.ad.e.a0.c.a(this.F.f8604a.d));
            bundleA.putInt("TEMPLATE_ID", this.F.f8604a.d.s);
            bundleA.putInt("AD_INDEX", this.e.indexOf(this.F));
            com.ubix.ssp.ad.e.y.a.a.b.f fVar = this.F.f8604a.d.L;
            if (fVar != null && (i = fVar.b) != 0) {
                bundleA.putInt("RENDER_MODE", i);
                bundleA.putFloat("SCALE_IGNORE_PERCENT", (this.F.f8604a.d.L.c * 1.0f) / 100.0f);
                bundleA.putInt("SCALE_HORIZONTAL_MARGIN", this.F.f8604a.d.L.d);
                bundleA.putInt("SCALE_VERTICAL_MARGIN", this.F.f8604a.d.L.e);
            }
            if (this.I.b()) {
                bundleA.putString("AD_SOURCE", this.F.f8604a.d.t);
            }
            bundleA.putBoolean("SUPPORT_FEED_BACK", this.F.f8604a.k);
            bundleA.putInt("SKIP_VIEW_STYLE", this.I.D());
            if (this.I.g0() != -1) {
                iG0 = this.I.g0();
            }
            bundleA.putInt("SKIP_COUNT_TIME", iG0);
            bundleA.putBoolean("IS_UNNAMED", this.I.G0());
            com.ubix.ssp.ad.b bVarA = com.ubix.ssp.ad.b.a(context, bundleA, 6, false);
            this.D = bVarA;
            bVarA.setInnerListener(this);
            this.D.b(bundleA);
            this.D.setShowCloseBtnDelay(this.I.e0());
            com.ubix.ssp.ad.e.y.a.a.b bVar = this.F.f8604a.d;
            if (com.ubix.ssp.ad.e.a0.c.a(bVar)) {
                this.D.a(bVar.g, bVar.A, bVar.z, bVar.h, bVar.H, bVar.I, bVar.G);
            }
            if (this.D == null) {
                AdError adErrorD3 = com.ubix.ssp.ad.e.a0.a0.a.d(9, "内容加载失败");
                d(adErrorD3);
                com.ubix.ssp.ad.g.e eVar5 = this.C;
                if (eVar5 != null) {
                    eVar5.onAdExposeFailed(adErrorD3);
                    return;
                }
                return;
            }
            try {
                if (this.f != null) {
                    ((Activity) context).getWindow().getDecorView().post(new a(context));
                } else {
                    AdError adErrorD4 = com.ubix.ssp.ad.e.a0.a0.a.d(9, "内容加载失败");
                    d(adErrorD4);
                    com.ubix.ssp.ad.g.e eVar6 = this.C;
                    if (eVar6 != null) {
                        eVar6.onAdExposeFailed(adErrorD4);
                    }
                }
            } catch (Exception unused) {
                AdError adErrorD5 = com.ubix.ssp.ad.e.a0.a0.a.d(9, "Activity/Context为空");
                d(adErrorD5);
                com.ubix.ssp.ad.g.e eVar7 = this.C;
                if (eVar7 != null) {
                    eVar7.onAdExposeFailed(adErrorD5);
                }
            }
        } catch (Exception unused2) {
            AdError adErrorD6 = com.ubix.ssp.ad.e.a0.a0.a.d(9, "内容加载失败");
            d(adErrorD6);
            com.ubix.ssp.ad.g.e eVar8 = this.C;
            if (eVar8 != null) {
                eVar8.onAdExposeFailed(adErrorD6);
            }
        }
    }

    @Override // com.ubix.ssp.ad.a
    protected void c(Context context, Intent intent, long j, BroadcastReceiver broadcastReceiver) {
        a(3, new Object[0]);
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void e(int i) {
        try {
            com.ubix.ssp.ad.b bVar = this.D;
            if (bVar != null) {
                bVar.i();
            }
            Dialog dialog = this.H;
            if (dialog != null && dialog.isShowing()) {
                this.H.dismiss();
            }
            l lVar = this.G;
            if (lVar != null && lVar.b()) {
                this.G.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ubix.ssp.ad.g.e eVar = this.C;
        if (eVar == null || this.L) {
            return;
        }
        this.L = true;
        eVar.onAdClosed();
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void f(int i) {
        f.a(this.E, this.e.get(i).f8604a.d.C, 0, this.I, this.d, null);
    }

    @Override // com.ubix.ssp.ad.a
    public void h() {
        try {
            e(0);
            com.ubix.ssp.ad.b bVar = this.D;
            if (bVar != null) {
                bVar.removeAllViews();
                this.D.j();
                this.D = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void h(String str) {
        if (TextUtils.isEmpty(str)) {
            b(com.ubix.ssp.ad.e.a0.a0.a.j(10, "竞价广告体为空或解析异常，请检查传入的参数是否正确"));
        } else {
            e(str);
        }
    }

    @Override // com.ubix.ssp.ad.g.k.b
    public void i(int i) {
        f.a(this.E, this.e.get(i).f8604a.d.B, 0, this.I, this.d, null);
    }

    @Override // com.ubix.ssp.ad.a
    protected AdError j(com.ubix.ssp.ad.d.a aVar) {
        int i;
        String str;
        com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b;
        com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.f8604a.d;
        int i2 = bVar.s;
        if (i2 == 6001 || i2 == 6002 || i2 == 6003 || i2 == 6004) {
            com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr = bVar.j;
            if (c1109bArr != null && c1109bArr.length != 0 && (c1109b = c1109bArr[0]) != null && !TextUtils.isEmpty(c1109b.c)) {
                return null;
            }
            i = 10;
            str = "图片资源链接异常";
        } else if (i2 == 6013 || i2 == 6012 || i2 == 6014) {
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

    public void n(int i) {
        super.w();
        super.u();
        this.J = true;
        com.ubix.ssp.ad.g.e eVar = this.C;
        if (eVar != null) {
            eVar.onAdLoadSucceed();
        }
    }

    protected void n(com.ubix.ssp.ad.d.a aVar) {
        super.v();
        this.I = a(aVar.f8604a);
        K();
    }
}

package com.opos.mobad.k.b;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.ad.d.h;
import com.opos.mobad.ad.d.i;
import com.opos.mobad.ad.d.k;
import com.opos.mobad.ad.d.t;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {
    private com.opos.mobad.k.c.a.a A;
    private AdItemData B;
    private MaterialData C;
    private MaterialFileData D;
    private String E;
    private com.opos.mobad.cmn.func.adhandler.a.c F;
    private ComplianceInfo G;
    private com.opos.mobad.ad.privacy.b H;
    private int I;
    private boolean J;
    private com.opos.mobad.template.e.c.a K;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.cmn.func.adhandler.a f7082a;
    private com.opos.mobad.b b;
    private boolean k;
    private com.opos.mobad.d.e.a p;
    private FrameLayout q;
    private FrameLayout r;
    private i y;
    private k z;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private int h = 0;
    private String i = "";
    private boolean j = false;
    private boolean l = false;
    private int m = 0;
    private long n = 0;
    private long o = 0;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private com.opos.mobad.d.e.a.InterfaceC0958a M = new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.k.b.d.13
        @Override // com.opos.mobad.d.e.a.InterfaceC0958a
        public void a(boolean z) {
            i iVar;
            int i;
            d.this.s = z;
            if (!d.this.t) {
                d dVar = d.this;
                if (z) {
                    if (!dVar.x) {
                        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "NativeAdvance view is visible");
                        d.this.t = true;
                        d.this.f7082a.b(d.this.B);
                        d.this.f7082a.a(d.this.B);
                        d.this.a(true);
                        d.this.h();
                        if (d.this.y != null) {
                            d.this.y.b();
                        }
                    } else if (d.this.y != null) {
                        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "NativeAdvance view is visible but destroy");
                        iVar = d.this.y;
                        i = 10216;
                        iVar.a(i, "native advance exp failed.");
                    }
                } else if (dVar.y != null) {
                    com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "NativeAdvance view is invisible");
                    iVar = d.this.y;
                    i = 10212;
                    iVar.a(i, "native advance exp failed.");
                }
            }
            if (z && d.this.L) {
                d.this.K.c().setVisibility(0);
            }
        }
    };
    private com.opos.mobad.d.e.a.c N = new com.opos.mobad.d.e.a.c() { // from class: com.opos.mobad.k.b.d.14
        @Override // com.opos.mobad.d.e.a.c
        public void a(boolean z, boolean z2) {
            if (d.this.u || d.this.x) {
                return;
            }
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "NativeAdvance onViewVisibleWithoutFocus: isVisibleRect: " + z + "isAttachedToWindow: " + z2);
            d.this.u = true;
            HashMap map = new HashMap();
            map.put("isVisibleRect", String.valueOf(z));
            map.put("isAttached", String.valueOf(z2));
            if (d.this.r != null) {
                com.opos.mobad.cmn.func.b.e.a(d.this.r, map);
            }
            com.opos.mobad.cmn.func.b.e.b(d.this.b, d.this.r, d.this.E, d.this.B, d.this.C, true, d.this.I, map);
        }
    };
    private com.opos.mobad.k.a.a O = new com.opos.mobad.k.a.a() { // from class: com.opos.mobad.k.b.d.2
        @Override // com.opos.mobad.k.a.a
        public void a(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayStart");
            d.this.d();
        }

        @Override // com.opos.mobad.k.a.a
        public void a(View view, AdItemData adItemData, long j) {
            d.this.h = 2;
            d.this.n = j;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayPause:" + j);
        }

        @Override // com.opos.mobad.k.a.a
        public void a(View view, int[] iArr, long j, com.opos.mobad.cmn.func.b.a aVar) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoClick ");
            if (!com.opos.mobad.k.f.a(d.this.B, aVar) || d.this.x || d.this.f7082a == null) {
                return;
            }
            HashMap map = new HashMap();
            map.put("nativeCoordinate", Arrays.toString(iArr));
            d.this.f7082a.a(d.this.B, !d.this.v, iArr, d.this.r, aVar, view, d.this.i, d.this.P, d.this.v, d.this.k ? Long.valueOf(d.this.n) : null, map);
            d.this.b();
            if (d.this.v) {
                return;
            }
            if (d.this.y != null) {
                d.this.y.a(2);
            }
            d.this.v = true;
        }

        @Override // com.opos.mobad.k.a.a
        public void a(Map<String, String> map) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayError");
            d.this.a(map);
        }

        @Override // com.opos.mobad.k.a.a
        public void b(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayComplete");
            d.this.e();
        }

        @Override // com.opos.mobad.k.a.a
        public void b(View view, AdItemData adItemData, long j) {
            d.this.h = 1;
            d.this.n = j;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayResume:" + j);
        }

        @Override // com.opos.mobad.k.a.a
        public void c(View view, AdItemData adItemData, long j) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayProgress :" + j);
            d dVar = d.this;
            dVar.a(j, dVar.o, d.this.f());
            d.this.n = j;
        }
    };
    private com.opos.mobad.t.c.a P = new com.opos.mobad.t.c.a() { // from class: com.opos.mobad.k.b.d.3
        private void d() {
            d.this.n = 0L;
            d.this.h = -2;
            if (!d.this.g) {
                d.this.c = false;
                d.this.d = false;
                d.this.e = false;
                d.this.f = false;
            }
            if (d.this.A != null) {
                d.this.A.a(d.this.B);
            }
        }

        @Override // com.opos.mobad.t.c
        public void a() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoClose mCurrentState:" + d.this.h);
            if (!com.opos.cmn.an.h.c.a.e(d.this.b.b()) && !d.this.C.U()) {
                if (!com.opos.cmn.an.h.c.a.d(d.this.b.b()) || d.this.A == null) {
                    return;
                }
                d.this.A.a(d.this.B);
                return;
            }
            int i = d.this.h;
            if (i != -1) {
                if (i == 2) {
                    d dVar = d.this;
                    dVar.b(dVar.B, d.this.i);
                    return;
                } else if (i != 3 && i != 4) {
                    return;
                }
            }
            d();
        }

        @Override // com.opos.mobad.t.c
        public void a(long j) {
            if (d.this.h != 1) {
                d.this.h = 1;
            }
            d.this.n = j;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoProgress :" + j);
            d dVar = d.this;
            dVar.a(j, dVar.o, d.this.f());
        }

        @Override // com.opos.mobad.t.c
        public void a(Bundle bundle) {
            Map<String, String> mapA = com.opos.mobad.model.utils.c.a(bundle);
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoError :" + mapA);
            d.this.a(mapA);
        }

        @Override // com.opos.mobad.t.c
        public void b() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoStart ");
            d.this.d();
        }

        @Override // com.opos.mobad.t.c
        public void b(long j) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoPause " + j);
            d.this.h = 2;
            d.this.n = j;
        }

        @Override // com.opos.mobad.t.c
        public void c() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoComplete ");
            d.this.e();
            d();
        }

        @Override // com.opos.mobad.t.c
        public void c(long j) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoUserPause ");
            d.this.h = 4;
            d.this.n = j;
        }
    };
    private com.opos.mobad.d.e.a.InterfaceC0958a Q = new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.k.b.d.4
        @Override // com.opos.mobad.d.e.a.InterfaceC0958a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onViewVisibile isViewVisible:" + z + ",mCurrentState:" + d.this.h + ",url:" + d.this.i);
            d.this.j = z;
            if (!z) {
                d.this.b();
                if (d.this.h == -2) {
                    d.this.h = -3;
                    return;
                }
                return;
            }
            if (d.this.h == -2 || d.this.h == 4) {
                return;
            }
            if (com.opos.cmn.an.h.c.a.e(d.this.b.b()) || d.this.C.U()) {
                d.this.c();
            }
        }
    };
    private com.opos.mobad.template.e.c.b R = new com.opos.mobad.template.e.c.b() { // from class: com.opos.mobad.k.b.d.5
        @Override // com.opos.mobad.template.e.c.b
        public void a(int i, int[] iArr) {
        }

        @Override // com.opos.mobad.template.e.c.b
        public void a(View view, int[] iArr) {
        }

        @Override // com.opos.mobad.template.e.c.b
        public void a(int[] iArr) {
        }

        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
        }

        @Override // com.opos.mobad.template.c
        public void b(int[] iArr) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onShake");
            d.this.a((View) null, com.opos.mobad.cmn.func.b.a.SHAKE, (int[]) null, iArr);
        }
    };

    /* JADX INFO: renamed from: com.opos.mobad.k.b.d$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7093a;

        static {
            int[] iArr = new int[com.opos.mobad.template.e.a.values().length];
            f7093a = iArr;
            try {
                iArr[com.opos.mobad.template.e.a.SHAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static class a implements com.opos.mobad.cmn.func.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private h.a f7097a;

        public a(h.a aVar) {
            this.f7097a = aVar;
        }

        @Override // com.opos.mobad.cmn.func.b.a
        public void a() {
            h.a aVar = this.f7097a;
            if (aVar == null) {
                return;
            }
            aVar.a();
        }

        @Override // com.opos.mobad.cmn.func.b.a
        public void a(View view) {
            h.a aVar = this.f7097a;
            if (aVar == null) {
                return;
            }
            aVar.a(view);
        }
    }

    public d(com.opos.mobad.b bVar, com.opos.mobad.cmn.func.adhandler.a aVar, AdItemData adItemData, String str, com.opos.mobad.ad.privacy.b bVar2) {
        this.k = false;
        this.b = bVar;
        this.E = str;
        this.B = adItemData;
        MaterialData materialData = adItemData.i().get(0);
        this.C = materialData;
        this.k = com.opos.mobad.ui.c.f.a(materialData.Z());
        this.f7082a = aVar;
        this.p = new com.opos.mobad.d.e.a(this.b.b());
        this.q = new FrameLayout(this.b.b());
        com.opos.mobad.cmn.func.adhandler.a.c cVarA = g.a(bVar.b(), this.p);
        this.F = cVarA;
        this.f7082a.a(cVarA);
        if (this.k) {
            this.D = g.a(adItemData);
            a(this.B);
        }
        if (this.B.T() != null) {
            this.G = com.opos.mobad.cmn.func.b.a(this.B);
        }
        this.H = bVar2;
        this.J = com.opos.cmn.an.h.d.a.d(this.b.b(), this.C.i());
    }

    private float a(long j, long j2) {
        if (0 != j) {
            return j2 / (j * 1.0f);
        }
        return 0.0f;
    }

    private com.opos.mobad.template.e.c.a a(Context context, com.opos.mobad.template.e.a aVar, boolean z, int i) {
        if (AnonymousClass6.f7093a[aVar.ordinal()] == 1) {
            if (i == 0) {
                return new com.opos.mobad.template.e.c.b.b(context, aVar, 0, z, null);
            }
            if (i == 1) {
                return new com.opos.mobad.template.e.c.d(context, aVar, 0, 0, z);
            }
        }
        return null;
    }

    private Map<String, String> a(String str, AdItemData adItemData, long j) {
        HashMap map = new HashMap();
        try {
            return (com.opos.cmn.an.d.a.a(str) || adItemData == null) ? map : com.opos.mobad.cmn.func.b.e.a(str, j, b(adItemData));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
            return map;
        }
    }

    private void a(final int i, final String str) {
        try {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "notifyOnAdFailed code=" + i + ",msg=" + (str != null ? str : "null"));
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.k.b.d.12
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.z != null) {
                        k kVar = d.this.z;
                        int i2 = i;
                        String str2 = str;
                        if (str2 == null) {
                            str2 = "";
                        }
                        kVar.a(i2, str2);
                    }
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    private void a(int i, String str, boolean z, Map<String, String> map) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "code=" + i);
        if (this.x) {
            return;
        }
        com.opos.mobad.cmn.func.b.e.a(this.b, this.E, this.B, this.C, z, "", com.opos.mobad.cmn.func.b.e.a(i, str, map));
    }

    private void a(long j) {
        if (this.C.v() == null || this.C.v().size() <= 0) {
            return;
        }
        a(this.b.b(), this.C.v(), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, boolean z) {
        try {
            long jB = b(this.B);
            this.o = j;
            if (!this.d && a(jB, j, j2, 0.25f)) {
                a(z, j);
                this.d = true;
            } else if (!this.e && a(jB, j, j2, 0.5f)) {
                b(z, j);
                this.e = true;
            } else if (!this.f && a(jB, j, j2, 0.75f)) {
                c(z, j);
                this.f = true;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    private void a(Context context, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (this.q.getParent() != null) {
            ((ViewGroup) this.q.getParent()).removeView(this.q);
        }
        frameLayout.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        if (this.A == null) {
            if (this.p.getParent() != null) {
                ((ViewGroup) this.p.getParent()).removeView(this.p);
            }
            this.q.addView(this.p, 0, 0);
            this.A = new com.opos.mobad.k.c.a.b(context, this.O, this.q);
        }
        this.A.a(this.B);
        this.p.a(this.Q);
    }

    private void a(final Context context, final RelativeLayout relativeLayout, final t tVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(20, -1);
        layoutParams.addRule(10, -1);
        layoutParams.setMargins(com.opos.cmn.an.h.f.a.a(context, tVar.q), com.opos.cmn.an.h.f.a.a(context, tVar.r), 0, 0);
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "start:" + tVar.q, "top:" + tVar.r);
        View viewC = this.K.c();
        relativeLayout.addView(viewC, layoutParams);
        this.K.a(this.R);
        Context contextB = this.b.b();
        com.opos.mobad.b bVar = this.b;
        AdItemData adItemData = this.B;
        MaterialData materialData = this.C;
        this.K.a(com.opos.mobad.template.e.b.a.a(com.opos.mobad.model.a.a(contextB, bVar, adItemData, materialData, this.J, materialData.b()).a()));
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "add interactiveComponent");
        viewC.post(new Runnable() { // from class: com.opos.mobad.k.b.d.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    View viewC2 = d.this.K.c();
                    int width = relativeLayout.getWidth() - viewC2.getWidth();
                    int height = relativeLayout.getHeight() - viewC2.getHeight();
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewC2.getLayoutParams();
                    if (com.opos.cmn.an.h.f.a.a(context, tVar.q) > width) {
                        layoutParams2.leftMargin = width;
                        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "startMargin update:" + width);
                    }
                    if (com.opos.cmn.an.h.f.a.a(context, tVar.r) > height) {
                        layoutParams2.topMargin = height;
                        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "TopMargin update:" + height);
                    }
                    viewC2.setLayoutParams(layoutParams2);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("NativeAdvancePresenter", "update interactiveView error:", e);
                }
            }
        });
    }

    private void a(Context context, List<String> list, long j) {
        try {
            com.opos.mobad.service.f.c.a().a(list).a(j).a(this.b.b());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.opos.mobad.cmn.func.b.a aVar, int[] iArr, int[] iArr2) {
        i iVar;
        if (!this.s) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "click but not attach");
            i iVar2 = this.y;
            if (iVar2 != null) {
                iVar2.a(10202, "ad hasn't exposed.");
                return;
            }
            return;
        }
        if (!com.opos.mobad.k.f.a(this.B, aVar) || this.x) {
            return;
        }
        boolean z = aVar == com.opos.mobad.cmn.func.b.a.CLICK_BT ? this.v : this.w;
        HashMap map = new HashMap();
        map.put("nativeCoordinate", Arrays.toString(iArr2));
        this.f7082a.a(this.B, !z, iArr2, this.r, aVar, view, this.i, this.P, z, this.k ? Long.valueOf(this.n) : null, map);
        b();
        if (!z && (iVar = this.y) != null) {
            iVar.a(aVar == com.opos.mobad.cmn.func.b.a.CLICK_BT ? 1 : 2);
        }
        if (aVar == com.opos.mobad.cmn.func.b.a.CLICK_BT) {
            this.v = true;
        } else {
            this.w = true;
        }
    }

    private void a(AdItemData adItemData) {
        if (adItemData == null || 2 != adItemData.t() || this.D == null) {
            return;
        }
        com.opos.mobad.j.a.d.a(this.b.b(), this.D.a(), adItemData.V(), new com.opos.mobad.j.a.d.a() { // from class: com.opos.mobad.k.b.d.11
            @Override // com.opos.mobad.j.a.d.a
            public void a(String str) {
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "ping success url =" + str);
                d.this.i = str;
                d dVar = d.this;
                dVar.a(dVar.B, d.this.i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdItemData adItemData, String str) {
        if (TextUtils.isEmpty(str) || !this.j) {
            return;
        }
        c(adItemData, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, String> map) {
        this.h = -1;
        int iA = com.opos.mobad.j.a.c.a(map);
        String strB = com.opos.mobad.j.a.c.b(map);
        int iB = com.opos.mobad.m.f.b(iA, com.opos.mobad.j.a.c.c(map));
        a(iB, strB, f(), map);
        String strA = com.opos.mobad.ad.a.a(iB);
        k kVar = this.z;
        if (kVar != null) {
            kVar.a(iB, strA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            HashMap map = new HashMap();
            FrameLayout frameLayout = this.r;
            if (frameLayout != null) {
                com.opos.mobad.cmn.func.b.e.a(frameLayout, map);
            }
            com.opos.mobad.cmn.func.b.e.a(this.b, this.r, this.E, this.B, this.C, z, this.I, map);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    private void a(boolean z, long j) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayProgress25Report  currentPosition=" + j);
        if (this.x) {
            return;
        }
        a(z, a("25", this.B, j));
        b(j);
    }

    private void a(boolean z, Map<String, String> map) {
        try {
            com.opos.mobad.cmn.func.b.e.a(this.b, this.E, this.B, this.C, z, map);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    private boolean a(long j, long j2, long j3, float f) {
        boolean z = false;
        if (0 == j) {
            return false;
        }
        try {
            if (a(j, j3) >= f || a(j, j2) < f) {
                return false;
            }
            z = true;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getVideoPercent videoDuration =" + j + ",lastPostion=" + j3 + ",currentPosition" + j2);
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "meetVideoPercent percent=" + f + ",result=true");
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
            return z;
        }
    }

    private long b(AdItemData adItemData) {
        if (adItemData == null) {
            return 0L;
        }
        try {
            return adItemData.i().get(0).s();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
            return 0L;
        }
    }

    private void b(long j) {
        if (this.C.w() == null || this.C.w().size() <= 0) {
            return;
        }
        a(this.b.b(), this.C.w(), j);
    }

    private void b(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2, List<View> list3, h.a aVar3) {
        if (this.G == null) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bind to Compliance view but without complianceInfo");
        } else {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bind to Compliance view");
            com.opos.mobad.cmn.func.b.a(context, list, new a(aVar), list2, new a(aVar2), list3, new a(aVar3), this.H, this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdItemData adItemData, String str) {
        com.opos.mobad.k.c.a.a aVar;
        if (adItemData == null || TextUtils.isEmpty(str) || (aVar = this.A) == null) {
            return;
        }
        aVar.b(adItemData, str);
        this.l = true;
    }

    private void b(boolean z) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayStartReport isValid=" + z);
        try {
            if (this.x) {
                return;
            }
            a(z, a("0", this.B, 0L));
            a(0L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    private void b(boolean z, long j) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayProgress50Report  currentPosition=" + j);
        if (this.x) {
            return;
        }
        a(z, a("50", this.B, j));
        c(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i;
        String str;
        int i2;
        String str2;
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "playVideo");
        if (this.B == null) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "empty adItemData");
            i2 = 10402;
            str2 = "no video to play.";
        } else if (com.opos.cmn.an.h.c.a.d(this.b.b())) {
            int iT = this.B.t();
            if (iT == 1 || iT == 2) {
                if (TextUtils.isEmpty(this.D.a())) {
                    if (iT == 1) {
                        i = 10401;
                        str = "no local cached video to play.";
                    } else {
                        if (iT != 2) {
                            return;
                        }
                        i = 10400;
                        str = "no stream video to play.";
                    }
                    a(i, str);
                    return;
                }
                if (iT == 1) {
                    if (TextUtils.isEmpty(this.i)) {
                        this.i = com.opos.cmn.d.d.a(this.b.b(), this.D.a(), this.D.b());
                    }
                    c(this.B, this.i);
                    return;
                } else {
                    if (iT == 2) {
                        a(this.B, this.i);
                        return;
                    }
                    return;
                }
            }
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "error playMode");
            i2 = 10407;
            str2 = "暂时没有视频了，稍后再试试吧";
        } else {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "not net");
            i2 = 10403;
            str2 = "no net,can't play video.";
        }
        a(i2, str2);
    }

    private void c(long j) {
        if (this.C.x() == null || this.C.x().size() <= 0) {
            return;
        }
        a(this.b.b(), this.C.x(), j);
    }

    private void c(AdItemData adItemData, String str) {
        com.opos.mobad.k.c.a.a aVar;
        if (adItemData == null || TextUtils.isEmpty(str) || (aVar = this.A) == null) {
            return;
        }
        aVar.a(adItemData, str);
        this.l = true;
    }

    private void c(boolean z, long j) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayProgress75Report  currentPosition=" + j);
        if (this.x) {
            return;
        }
        a(z, a("75", this.B, j));
        d(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.h = 1;
        this.m++;
        this.n = 0L;
        this.o = 0L;
        if (!this.g) {
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = false;
        }
        if (!this.c) {
            b(f());
            this.c = true;
        }
        k kVar = this.z;
        if (kVar != null) {
            kVar.a();
        }
    }

    private void d(long j) {
        if (this.C.y() == null || this.C.y().size() <= 0) {
            return;
        }
        a(this.b.b(), this.C.y(), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.h = 3;
        this.n = b(this.B);
        if (!this.g) {
            this.g = true;
            g();
        }
        k kVar = this.z;
        if (kVar != null) {
            kVar.b();
        }
    }

    private void e(long j) {
        if (this.C.z() == null || this.C.z().size() <= 0) {
            return;
        }
        a(this.b.b(), this.C.z(), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.m <= 1;
    }

    private void g() {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayCompleteReport ");
        if (this.x) {
            return;
        }
        AdItemData adItemData = this.B;
        a(true, a("100", adItemData, b(adItemData)));
        e(b(this.B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            if (this.C.l() == null || this.C.l().size() <= 0) {
                return;
            }
            com.opos.mobad.service.f.c.a(this.b.b(), this.C.l());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    public void a() {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "release");
        this.y = null;
        this.z = null;
        com.opos.mobad.k.c.a.a aVar = this.A;
        if (aVar != null) {
            aVar.a();
            this.A = null;
        }
        com.opos.mobad.cmn.func.adhandler.a.c cVar = this.F;
        if (cVar != null) {
            cVar.a();
        }
        com.opos.mobad.ad.privacy.b bVar = this.H;
        if (bVar != null) {
            bVar.a();
        }
        com.opos.mobad.template.e.c.a aVar2 = this.K;
        if (aVar2 != null) {
            aVar2.f();
            this.K.j();
        }
        this.t = false;
        this.u = false;
        this.r = null;
        this.f7082a.b();
        this.x = true;
    }

    public void a(int i) {
        this.I = i;
    }

    /* JADX WARN: Code duplicated, block: B:149:0x06cb  */
    /* JADX WARN: Code duplicated, block: B:151:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:152:0x0701  */
    /* JADX WARN: Code duplicated, block: B:155:0x0716  */
    /* JADX WARN: Code duplicated, block: B:157:0x0734  */
    /* JADX WARN: Code duplicated, block: B:159:0x0765  */
    /* JADX WARN: Code duplicated, block: B:162:0x0778  */
    /* JADX WARN: Code duplicated, block: B:166:0x07a7  */
    /* JADX WARN: Code duplicated, block: B:168:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:170:0x080a  */
    public void a(Context context, FrameLayout frameLayout, t tVar, List<View> list, List<View> list2, boolean z, boolean z2, boolean z3) {
        final FrameLayout frameLayout2;
        List<View> list3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        RelativeLayout.LayoutParams layoutParams;
        int i6;
        LinearLayout linearLayout;
        View view;
        String str;
        Rect rect;
        com.opos.mobad.template.e.c.a aVar;
        if (context == null || frameLayout == null) {
            return;
        }
        List<View> arrayList = new ArrayList<>();
        if (tVar != null) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bindToView() params:", tVar);
            final RelativeLayout relativeLayout = new RelativeLayout(context);
            boolean z4 = (!z2 || this.B.T() == null || (TextUtils.isEmpty(this.B.T().e) && TextUtils.isEmpty(this.B.T().d) && TextUtils.isEmpty(this.B.T().c))) ? false : true;
            boolean z5 = (!z2 || this.B.T() == null || (TextUtils.isEmpty(this.B.T().b) && TextUtils.isEmpty(this.B.T().f7189a) && TextUtils.isEmpty(this.B.T().f))) ? false : true;
            this.K = a(context, com.opos.mobad.template.e.a.a(this.C.af()), context.getResources().getConfiguration().orientation == 1, tVar.s);
            this.L = tVar.p == 1 && (aVar = this.K) != null && aVar.c() != null && this.K.e();
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "shouldShowInteractiveComponent:" + this.L, "isShowInteractiveComponent：" + tVar.p);
            int width = frameLayout.getWidth() > 0 ? frameLayout.getWidth() : com.opos.cmn.an.h.f.a.b(context);
            int height = frameLayout.getHeight() > 0 ? frameLayout.getHeight() : com.opos.cmn.an.h.f.a.c(context);
            Rect rect2 = tVar.b == 2 ? new Rect(com.opos.cmn.an.h.f.a.a(context, tVar.c), height - com.opos.cmn.an.h.f.a.a(context, tVar.d + 20), com.opos.cmn.an.h.f.a.a(context, tVar.c + 130), height - com.opos.cmn.an.h.f.a.a(context, tVar.d)) : new Rect(com.opos.cmn.an.h.f.a.a(context, tVar.c), height - com.opos.cmn.an.h.f.a.a(context, tVar.d + 10), com.opos.cmn.an.h.f.a.a(context, tVar.c + 224), height - com.opos.cmn.an.h.f.a.a(context, tVar.d));
            Rect rect3 = new Rect(com.opos.cmn.an.h.f.a.a(context, tVar.e), height - com.opos.cmn.an.h.f.a.a(context, tVar.f + 10), com.opos.cmn.an.h.f.a.a(context, tVar.e + 110), height - com.opos.cmn.an.h.f.a.a(context, tVar.f));
            Rect rect4 = new Rect(width - com.opos.cmn.an.h.f.a.a(context, tVar.i + tVar.g), height - com.opos.cmn.an.h.f.a.a(context, tVar.j + tVar.h), width - com.opos.cmn.an.h.f.a.a(context, tVar.i), height - com.opos.cmn.an.h.f.a.a(context, tVar.j));
            if (z4 && z5 && z3) {
                int i7 = tVar.f6652a;
                if (i7 == 0) {
                    rect = new Rect(0, 0, com.opos.cmn.an.h.f.a.a(context, 24.0f), com.opos.cmn.an.h.f.a.a(context, 24.0f));
                } else if (i7 != 2) {
                    rect = i7 != 3 ? new Rect(width - com.opos.cmn.an.h.f.a.a(context, 24.0f), 0, width, com.opos.cmn.an.h.f.a.a(context, 24.0f)) : new Rect(width - com.opos.cmn.an.h.f.a.a(context, 24.0f), height - com.opos.cmn.an.h.f.a.a(context, 24.0f), width, height);
                } else {
                    rect = new Rect(0, height - com.opos.cmn.an.h.f.a.a(context, 24.0f), com.opos.cmn.an.h.f.a.a(context, 24.0f), height);
                }
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "appInfoRect:" + rect2);
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "privacyRect:" + rect3);
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "closeRect:" + rect);
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "buttonRect:" + rect4);
                if (a(rect2, rect) || a(rect3, rect) || a(rect2, rect3) || a(rect2, rect4) || a(rect3, rect4) || a(rect, rect4)) {
                    com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "overlap set default with close");
                    tVar.c = 16;
                    tVar.d = 38;
                    tVar.e = 16;
                    tVar.f = 16;
                    tVar.g = 74;
                    tVar.h = 32;
                    tVar.i = 16;
                    tVar.j = 16;
                    tVar.f6652a = 1;
                }
            } else if (z4 && z5 && a(rect2, rect3)) {
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "overlap set default");
                tVar.c = 16;
                tVar.d = 38;
                tVar.e = 16;
                tVar.f = 16;
            }
            if (z) {
                TextView textView = new TextView(this.b.b());
                textView.setGravity(17);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(tVar.m);
                gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.b.b(), tVar.l));
                gradientDrawable.setStroke(com.opos.cmn.an.h.f.a.a(this.b.b(), 1.0f), tVar.o);
                textView.setBackground(gradientDrawable);
                textView.setTextColor(tVar.n);
                textView.setTextSize(tVar.k);
                String str2 = this.B.i().get(0).f7196a;
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.B.F() == 2 ? "立即下载" : "查看详情";
                }
                textView.setText(str2);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.b.b(), tVar.g), com.opos.cmn.an.h.f.a.a(this.b.b(), tVar.h));
                layoutParams2.addRule(21, -1);
                layoutParams2.addRule(12, -1);
                layoutParams2.setMargins(0, 0, com.opos.cmn.an.h.f.a.a(this.b.b(), tVar.i), com.opos.cmn.an.h.f.a.a(this.b.b(), tVar.j));
                relativeLayout.addView(textView, layoutParams2);
                list3 = arrayList;
                list3.add(textView);
            } else {
                list3 = arrayList;
            }
            if (z2) {
                List<View> arrayList2 = new ArrayList<>();
                List<View> arrayList3 = new ArrayList<>();
                List<View> arrayList4 = new ArrayList<>();
                if (2 == tVar.b) {
                    LinearLayout linearLayout2 = new LinearLayout(context);
                    linearLayout2.setOrientation(1);
                    linearLayout2.setMinimumWidth(com.opos.cmn.an.h.f.a.a(context, 58.0f));
                    LinearLayout linearLayout3 = new LinearLayout(context);
                    linearLayout3.setOrientation(0);
                    linearLayout3.setGravity(16);
                    linearLayout3.setMinimumWidth(com.opos.cmn.an.h.f.a.a(context, 58.0f));
                    linearLayout2.addView(linearLayout3);
                    if (this.B.T() != null) {
                        if (TextUtils.isEmpty(this.B.T().e)) {
                            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData appName null");
                        } else {
                            TextView textView2 = new TextView(context);
                            textView2.setText(this.B.T().e);
                            textView2.setMinWidth(com.opos.cmn.an.h.f.a.a(context, 18.0f));
                            textView2.setMaxWidth(com.opos.cmn.an.h.f.a.a(context, 60.0f));
                            textView2.setTextSize(10.0f);
                            textView2.setLines(1);
                            textView2.setTextColor(922746880);
                            textView2.setEllipsize(TextUtils.TruncateAt.END);
                            linearLayout3.addView(textView2);
                        }
                        if (TextUtils.isEmpty(this.B.T().d)) {
                            list3 = list3;
                            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData verName null");
                        } else {
                            TextView textView3 = new TextView(context);
                            textView3.setText(this.B.T().d);
                            textView3.setMinWidth(com.opos.cmn.an.h.f.a.a(context, 18.0f));
                            textView3.setMaxWidth(com.opos.cmn.an.h.f.a.a(context, 60.0f));
                            textView3.setTextSize(10.0f);
                            textView3.setLines(1);
                            textView3.setTextColor(922746880);
                            textView3.setEllipsize(TextUtils.TruncateAt.END);
                            if (!TextUtils.isEmpty(this.B.T().e)) {
                                View view2 = new View(context);
                                view2.setBackgroundColor(503316480);
                                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 10.0f));
                                layoutParams3.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 5.0f));
                                layoutParams3.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 5.0f));
                                linearLayout3.addView(view2, layoutParams3);
                            }
                            linearLayout3.addView(textView3);
                        }
                        if (TextUtils.isEmpty(this.B.T().c)) {
                            str = "getAppPrivacyData developerName null";
                        } else {
                            TextView textView4 = new TextView(context);
                            textView4.setText(this.B.T().c);
                            textView4.setMinWidth(com.opos.cmn.an.h.f.a.a(context, 18.0f));
                            textView4.setMaxWidth(com.opos.cmn.an.h.f.a.a(context, 130.0f));
                            textView4.setTextSize(10.0f);
                            textView4.setLines(1);
                            textView4.setTextColor(922746880);
                            textView4.setEllipsize(TextUtils.TruncateAt.END);
                            linearLayout2.addView(textView4);
                        }
                        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(12, -1);
                        layoutParams.addRule(20, -1);
                        layoutParams.setMargins(com.opos.cmn.an.h.f.a.a(context, tVar.c), 0, 0, com.opos.cmn.an.h.f.a.a(context, tVar.d));
                        view = linearLayout2;
                    } else {
                        list3 = list3;
                        str = "getAppPrivacyData appInfo null";
                    }
                    com.opos.cmn.an.f.a.b("NativeAdvancePresenter", str);
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(12, -1);
                    layoutParams.addRule(20, -1);
                    layoutParams.setMargins(com.opos.cmn.an.h.f.a.a(context, tVar.c), 0, 0, com.opos.cmn.an.h.f.a.a(context, tVar.d));
                    view = linearLayout2;
                } else {
                    list3 = list3;
                    LinearLayout linearLayout4 = new LinearLayout(context);
                    linearLayout4.setOrientation(0);
                    linearLayout4.setMinimumWidth(com.opos.cmn.an.h.f.a.a(context, 72.0f));
                    if (this.B.T() != null) {
                        if (TextUtils.isEmpty(this.B.T().e)) {
                            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData appName null");
                        } else {
                            TextView textView5 = new TextView(context);
                            textView5.setText(this.B.T().e);
                            textView5.setMinWidth(com.opos.cmn.an.h.f.a.a(context, 18.0f));
                            textView5.setMaxWidth(com.opos.cmn.an.h.f.a.a(context, 60.0f));
                            textView5.setTextSize(10.0f);
                            textView5.setLines(1);
                            textView5.setTextColor(922746880);
                            textView5.setEllipsize(TextUtils.TruncateAt.END);
                            linearLayout4.addView(textView5);
                        }
                        if (TextUtils.isEmpty(this.B.T().d)) {
                            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData verName null");
                        } else {
                            TextView textView6 = new TextView(context);
                            textView6.setText(this.B.T().d);
                            textView6.setMinWidth(com.opos.cmn.an.h.f.a.a(context, 18.0f));
                            textView6.setMaxWidth(com.opos.cmn.an.h.f.a.a(context, 54.0f));
                            textView6.setTextSize(10.0f);
                            textView6.setLines(1);
                            textView6.setTextColor(922746880);
                            textView6.setEllipsize(TextUtils.TruncateAt.END);
                            if (!TextUtils.isEmpty(this.B.T().e)) {
                                View view3 = new View(context);
                                view3.setBackgroundColor(503316480);
                                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 10.0f));
                                layoutParams4.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 5.0f));
                                layoutParams4.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 5.0f));
                                linearLayout4.addView(view3, layoutParams4);
                            }
                            linearLayout4.addView(textView6);
                        }
                        if (TextUtils.isEmpty(this.B.T().c)) {
                            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData developerName null");
                        } else {
                            TextView textView7 = new TextView(context);
                            textView7.setText(this.B.T().c);
                            textView7.setMinWidth(com.opos.cmn.an.h.f.a.a(context, 18.0f));
                            textView7.setMaxWidth(com.opos.cmn.an.h.f.a.a(context, 110.0f));
                            textView7.setTextSize(10.0f);
                            textView7.setLines(1);
                            textView7.setTextColor(922746880);
                            textView7.setEllipsize(TextUtils.TruncateAt.END);
                            if (!TextUtils.isEmpty(this.B.T().e) || !TextUtils.isEmpty(this.B.T().d)) {
                                View view4 = new View(context);
                                view4.setBackgroundColor(503316480);
                                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 10.0f));
                                layoutParams5.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 5.0f));
                                layoutParams5.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 5.0f));
                                linearLayout4.addView(view4, layoutParams5);
                            }
                            linearLayout4.addView(textView7);
                        }
                        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(12, -1);
                        layoutParams.addRule(20, -1);
                        layoutParams.setMargins(com.opos.cmn.an.h.f.a.a(context, tVar.c), 0, 0, com.opos.cmn.an.h.f.a.a(context, tVar.d));
                        view = linearLayout4;
                    } else {
                        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData appInfo null");
                    }
                    if (this.B.T() != null) {
                        linearLayout = new LinearLayout(context);
                        linearLayout.setGravity(16);
                        linearLayout.setOrientation(0);
                        if (TextUtils.isEmpty(this.B.T().b)) {
                            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData privacyUrl null");
                        } else {
                            TextView textView8 = new TextView(context);
                            textView8.setText("隐私");
                            textView8.setTextSize(10.0f);
                            textView8.setTextColor(-16750849);
                            linearLayout.addView(textView8);
                            arrayList2.add(textView8);
                        }
                        if (TextUtils.isEmpty(this.B.T().f7189a)) {
                            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData permissionUrl null");
                        } else {
                            TextView textView9 = new TextView(context);
                            textView9.setText("权限");
                            textView9.setTextSize(10.0f);
                            textView9.setTextColor(-16750849);
                            if (!TextUtils.isEmpty(this.B.T().b)) {
                                View view5 = new View(context);
                                view5.setBackgroundColor(503316480);
                                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 10.0f));
                                layoutParams6.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 7.0f));
                                layoutParams6.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 7.0f));
                                linearLayout.addView(view5, layoutParams6);
                            }
                            linearLayout.addView(textView9);
                            arrayList3.add(textView9);
                        }
                        if (TextUtils.isEmpty(this.B.T().f)) {
                            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData funcDescUrl null");
                        } else {
                            TextView textView10 = new TextView(context);
                            textView10.setText("应用介绍");
                            textView10.setTextSize(10.0f);
                            textView10.setTextColor(-16750849);
                            if (TextUtils.isEmpty(this.B.T().b) || !TextUtils.isEmpty(this.B.T().f7189a)) {
                                View view6 = new View(context);
                                view6.setBackgroundColor(503316480);
                                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 10.0f));
                                layoutParams7.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 7.0f));
                                layoutParams7.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 7.0f));
                                linearLayout.addView(view6, layoutParams7);
                            }
                            linearLayout.addView(textView10);
                            arrayList4.add(textView10);
                        }
                        i6 = -2;
                        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 110.0f), -2);
                        layoutParams8.addRule(12, -1);
                        layoutParams8.addRule(20, -1);
                        layoutParams8.setMargins(com.opos.cmn.an.h.f.a.a(context, tVar.e), 0, 0, com.opos.cmn.an.h.f.a.a(context, tVar.f));
                        relativeLayout.addView(linearLayout, layoutParams8);
                    } else {
                        i6 = -2;
                        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData privacy null");
                    }
                    i2 = 2;
                    i = i6;
                    arrayList = list3;
                    b(context, arrayList2, null, arrayList3, null, arrayList4, null);
                }
                relativeLayout.addView(view, layoutParams);
                if (this.B.T() != null) {
                    linearLayout = new LinearLayout(context);
                    linearLayout.setGravity(16);
                    linearLayout.setOrientation(0);
                    if (TextUtils.isEmpty(this.B.T().b)) {
                        TextView textView11 = new TextView(context);
                        textView11.setText("隐私");
                        textView11.setTextSize(10.0f);
                        textView11.setTextColor(-16750849);
                        linearLayout.addView(textView11);
                        arrayList2.add(textView11);
                    } else {
                        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData privacyUrl null");
                    }
                    if (TextUtils.isEmpty(this.B.T().f7189a)) {
                        TextView textView12 = new TextView(context);
                        textView12.setText("权限");
                        textView12.setTextSize(10.0f);
                        textView12.setTextColor(-16750849);
                        if (!TextUtils.isEmpty(this.B.T().b)) {
                            View view7 = new View(context);
                            view7.setBackgroundColor(503316480);
                            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 10.0f));
                            layoutParams9.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 7.0f));
                            layoutParams9.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 7.0f));
                            linearLayout.addView(view7, layoutParams9);
                        }
                        linearLayout.addView(textView12);
                        arrayList3.add(textView12);
                    } else {
                        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData permissionUrl null");
                    }
                    if (TextUtils.isEmpty(this.B.T().f)) {
                        TextView textView13 = new TextView(context);
                        textView13.setText("应用介绍");
                        textView13.setTextSize(10.0f);
                        textView13.setTextColor(-16750849);
                        if (TextUtils.isEmpty(this.B.T().b)) {
                            View view8 = new View(context);
                            view8.setBackgroundColor(503316480);
                            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 10.0f));
                            layoutParams10.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 7.0f));
                            layoutParams10.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 7.0f));
                            linearLayout.addView(view8, layoutParams10);
                        } else {
                            View view9 = new View(context);
                            view9.setBackgroundColor(503316480);
                            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 10.0f));
                            layoutParams11.setMarginStart(com.opos.cmn.an.h.f.a.a(context, 7.0f));
                            layoutParams11.setMarginEnd(com.opos.cmn.an.h.f.a.a(context, 7.0f));
                            linearLayout.addView(view9, layoutParams11);
                        }
                        linearLayout.addView(textView13);
                        arrayList4.add(textView13);
                    } else {
                        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData funcDescUrl null");
                    }
                    i6 = -2;
                    RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 110.0f), -2);
                    layoutParams12.addRule(12, -1);
                    layoutParams12.addRule(20, -1);
                    layoutParams12.setMargins(com.opos.cmn.an.h.f.a.a(context, tVar.e), 0, 0, com.opos.cmn.an.h.f.a.a(context, tVar.f));
                    relativeLayout.addView(linearLayout, layoutParams12);
                } else {
                    i6 = -2;
                    com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getAppPrivacyData privacy null");
                }
                i2 = 2;
                i = i6;
                arrayList = list3;
                b(context, arrayList2, null, arrayList3, null, arrayList4, null);
            } else {
                arrayList = list3;
                i = -2;
                i2 = 2;
            }
            if (this.L) {
                a(context, relativeLayout, tVar);
            }
            if (z3) {
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.drawable.mob_native_ad_close);
                RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(i, i);
                int i8 = tVar.f6652a;
                if (i8 != 0) {
                    if (i8 != i2) {
                        i4 = -1;
                        layoutParams13.addRule(i8 != 3 ? 10 : 12, -1);
                        i5 = 11;
                    } else {
                        i3 = 12;
                    }
                    layoutParams13.addRule(i5, i4);
                    int iA = com.opos.cmn.an.h.f.a.a(context, 8.0f);
                    layoutParams13.setMargins(iA, iA, iA, iA);
                    relativeLayout.addView(imageView, layoutParams13);
                    frameLayout2 = frameLayout;
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.k.b.d.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view10) {
                            if (d.this.y != null) {
                                d.this.y.a();
                            }
                            frameLayout2.removeAllViews();
                            d.this.a();
                        }
                    });
                } else {
                    i3 = 10;
                }
                i4 = -1;
                layoutParams13.addRule(i3, -1);
                i5 = 9;
                layoutParams13.addRule(i5, i4);
                int iA2 = com.opos.cmn.an.h.f.a.a(context, 8.0f);
                layoutParams13.setMargins(iA2, iA2, iA2, iA2);
                relativeLayout.addView(imageView, layoutParams13);
                frameLayout2 = frameLayout;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.k.b.d.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view10) {
                        if (d.this.y != null) {
                            d.this.y.a();
                        }
                        frameLayout2.removeAllViews();
                        d.this.a();
                    }
                });
            } else {
                frameLayout2 = frameLayout;
            }
            frameLayout2.post(new Runnable() { // from class: com.opos.mobad.k.b.d.9
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "container:width-" + frameLayout2.getWidth() + ", height-" + frameLayout2.getHeight());
                    frameLayout2.addView(relativeLayout, new FrameLayout.LayoutParams(frameLayout2.getWidth(), frameLayout2.getHeight()));
                    relativeLayout.bringToFront();
                }
            });
        } else {
            frameLayout2 = frameLayout;
        }
        List<View> arrayList5 = new ArrayList<>();
        if (list != null && list.size() > 0) {
            arrayList5.addAll(list);
        }
        if (list2 != null && list2.size() > 0) {
            arrayList5.addAll(list2);
        }
        a(context, frameLayout2, arrayList5, arrayList);
    }

    public void a(final Context context, FrameLayout frameLayout, List<View> list, List<View> list2) {
        com.opos.mobad.d.e.a aVar;
        if (context == null || frameLayout == null) {
            return;
        }
        this.r = frameLayout;
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bind to view");
        int childCount = frameLayout.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                aVar = null;
                break;
            }
            View childAt = frameLayout.getChildAt(childCount);
            if (childAt instanceof com.opos.mobad.d.e.a) {
                aVar = (com.opos.mobad.d.e.a) childAt;
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "empty not null");
                break;
            }
            childCount--;
        }
        if (aVar == null) {
            aVar = new com.opos.mobad.d.e.a(context);
            frameLayout.addView(aVar, 0, 0);
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "empty is null, new one");
        }
        aVar.a(this.M);
        aVar.a(this.N, this.r);
        if (list != null && list.size() > 0) {
            for (View view : list) {
                com.opos.cmn.module.ui.a aVar2 = new com.opos.cmn.module.ui.a() { // from class: com.opos.mobad.k.b.d.1
                    @Override // com.opos.cmn.module.ui.a
                    public void a(View view2, int[] iArr) {
                        d.this.a(view2, com.opos.mobad.cmn.func.b.a.NON_CLICK_BT, com.opos.mobad.ui.c.d.a(context, d.this.r, view2, iArr), iArr);
                    }
                };
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "set listener " + view);
                if (view != null) {
                    view.setOnTouchListener(aVar2);
                    view.setOnClickListener(aVar2);
                }
            }
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (View view2 : list2) {
            com.opos.cmn.module.ui.a aVar3 = new com.opos.cmn.module.ui.a() { // from class: com.opos.mobad.k.b.d.7
                @Override // com.opos.cmn.module.ui.a
                public void a(View view3, int[] iArr) {
                    d.this.a(view3, com.opos.mobad.cmn.func.b.a.CLICK_BT, com.opos.mobad.ui.c.d.a(context, d.this.r, view3, iArr), iArr);
                }
            };
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "set buttonView listener " + view2);
            if (view2 != null) {
                view2.setOnTouchListener(aVar3);
                view2.setOnClickListener(aVar3);
            }
        }
    }

    public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2) {
        if (context == null || list == null || list.size() <= 0 || list2 == null || list2.size() <= 0) {
            com.opos.cmn.an.f.a.d("NativeAdvancePresenter", "bind to Compliance view but null params " + context + "," + list + "," + list2);
        } else {
            b(context, list, aVar, list2, aVar2, null, null);
        }
    }

    public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2, List<View> list3, h.a aVar3) {
        if (context == null || list == null || list.size() <= 0 || list2 == null || list2.size() <= 0 || list3 == null || list3.size() <= 0) {
            com.opos.cmn.an.f.a.d("NativeAdvancePresenter", "bind to Compliance view but null params " + context + "," + list + "," + list2 + "," + list3);
        } else {
            b(context, list, aVar, list2, aVar2, list3, aVar3);
        }
    }

    public void a(FrameLayout frameLayout, k kVar) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bindMediaView nativeMediaView: " + frameLayout + ",listener: " + kVar);
        if (!this.k) {
            com.opos.cmn.an.f.a.d("NativeAdvancePresenter", "native data is not video data");
            return;
        }
        if (kVar != null) {
            this.z = kVar;
        }
        if (frameLayout == null) {
            com.opos.cmn.an.f.a.c("NativeAdvancePresenter", "bindMediaView but bindMediaView is null");
            a(10210, "MediaView container is null");
        } else if (com.opos.mobad.k.f.a(this.r, frameLayout)) {
            a(this.b.b(), frameLayout);
        } else {
            com.opos.cmn.an.f.a.c("NativeAdvancePresenter", "bindMediaView but nativeMediaView is not contained");
            a(10211, "NativeAdvanceContainer is not contain MediaView");
        }
    }

    public void a(i iVar) {
        this.y = iVar;
    }

    public boolean a(Rect rect, Rect rect2) {
        if (rect != null && rect2 != null) {
            if (rect.left >= 0 && rect.right >= 0 && rect.top >= 0 && rect.bottom >= 0 && rect2.left >= 0 && rect2.right >= 0 && rect2.top >= 0 && rect2.bottom >= 0) {
                return rect.left <= rect2.right && rect2.left <= rect.right && rect.top <= rect2.bottom && rect2.top <= rect.bottom;
            }
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "invalid rect");
        }
        return false;
    }

    public void b() {
        String str;
        com.opos.mobad.k.c.a.a aVar;
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "pauseVideo: mHasVideoStart = " + this.l);
        HashMap map = new HashMap();
        if (!this.l || (aVar = this.A) == null) {
            str = "2";
        } else {
            aVar.b();
            this.l = false;
            str = "1";
        }
        map.put("vStatus", str);
        com.opos.mobad.cmn.func.b.e.a(this.b, this.E, this.B, this.C, f(), map);
    }
}

package com.ubix.ssp.ad.i;

import android.os.Bundle;
import android.view.View;
import com.stub.StubApp;
import com.ubix.ssp.ad.d.l;
import com.ubix.ssp.ad.e.a0.f;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.v.e;
import com.ubix.ssp.ad.g.k.g;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.nativee.NativeAd;
import com.ubix.ssp.open.nativee.UBiXNativeInteractionListener;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressVideoListener;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SoftReference<com.ubix.ssp.ad.i.c> f8973a;
    private SoftReference<NativeAd> b;
    private SoftReference<com.ubix.ssp.ad.i.a> c;
    private ConcurrentHashMap<Integer, HashMap<String, Object>> d;
    private int e = 0;
    private l f;

    class a implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXNativeExpressInteractionListener f8974a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ ArrayList c;

        a(UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener, ArrayList arrayList, ArrayList arrayList2) {
            this.f8974a = uBiXNativeExpressInteractionListener;
            this.b = arrayList;
            this.c = arrayList2;
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(e eVar, String str, String str2, boolean z) {
            if (b.this.a() == null) {
                AdError adErrorG = com.ubix.ssp.ad.e.a0.a0.a.g(2, "内容加载失败");
                if (b.this.f8973a != null && b.this.f8973a.get() != null) {
                    ((com.ubix.ssp.ad.i.c) b.this.f8973a.get()).c(adErrorG);
                }
                u.e("onAdRenderFailed in");
                UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener = this.f8974a;
                if (uBiXNativeExpressInteractionListener != null) {
                    uBiXNativeExpressInteractionListener.onAdRenderFailed(adErrorG);
                }
                u.e("onAdRenderFailed out");
                return;
            }
            this.b.add(str);
            if (b.this.a() != null && b.this.a().getCustomizeVideo() != null) {
                this.c.add(((NativeAd) b.this.b.get()).getCustomizeVideo().getVideoUrl());
            }
            b bVar = b.this;
            bVar.a(((NativeAd) bVar.b.get()).hashCode());
            if (b.this.f8973a != null && b.this.f8973a.get() != null) {
                ((com.ubix.ssp.ad.i.c) b.this.f8973a.get()).w();
            }
            try {
                u.e("onAdRenderSucceed in");
                UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener2 = this.f8974a;
                if (uBiXNativeExpressInteractionListener2 != null) {
                    uBiXNativeExpressInteractionListener2.onAdRenderSucceed((View) ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("native_parent_view_key"));
                    u.e("onAdRenderSucceed out");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            b.this.a(this.f8974a);
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
            if (b.this.f8973a != null && b.this.f8973a.get() != null) {
                ((com.ubix.ssp.ad.i.c) b.this.f8973a.get()).c(adError);
            }
            u.e("onAdRenderFailed in");
            UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener = this.f8974a;
            if (uBiXNativeExpressInteractionListener != null) {
                uBiXNativeExpressInteractionListener.onAdRenderFailed(adError);
            }
            u.e("onAdRenderFailed out");
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.i.b$b, reason: collision with other inner class name */
    class C1118b implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f8975a;
        final /* synthetic */ UBiXNativeExpressInteractionListener b;
        final /* synthetic */ AtomicInteger c;
        final /* synthetic */ AtomicInteger d;

        C1118b(ArrayList arrayList, UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
            this.f8975a = arrayList;
            this.b = uBiXNativeExpressInteractionListener;
            this.c = atomicInteger;
            this.d = atomicInteger2;
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(e eVar, String str, String str2, boolean z) {
            this.f8975a.add(str);
            if (b.this.c() == null) {
                AdError adErrorG = com.ubix.ssp.ad.e.a0.a0.a.g(2, "广告View为空");
                if (b.this.f8973a != null && b.this.f8973a.get() != null) {
                    ((com.ubix.ssp.ad.i.c) b.this.f8973a.get()).c(adErrorG);
                }
                u.e("onAdRenderFailed in");
                UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener = this.b;
                if (uBiXNativeExpressInteractionListener != null) {
                    uBiXNativeExpressInteractionListener.onAdRenderFailed(adErrorG);
                }
                u.e("onAdRenderFailed out");
                return;
            }
            if (this.c.decrementAndGet() + this.d.get() != ((NativeAd) b.this.b.get()).getImageList().size() || this.c.get() >= ((NativeAd) b.this.b.get()).getImageList().size()) {
                return;
            }
            if (b.this.a() == null) {
                AdError adErrorG2 = com.ubix.ssp.ad.e.a0.a0.a.g(2, "广告View为空");
                if (b.this.f8973a != null && b.this.f8973a.get() != null) {
                    ((com.ubix.ssp.ad.i.c) b.this.f8973a.get()).c(adErrorG2);
                }
                u.e("onAdRenderFailed in");
                UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener2 = this.b;
                if (uBiXNativeExpressInteractionListener2 != null) {
                    uBiXNativeExpressInteractionListener2.onAdRenderFailed(adErrorG2);
                }
                u.e("onAdRenderFailed out");
                return;
            }
            b bVar = b.this;
            bVar.a(((NativeAd) bVar.b.get()).hashCode());
            if (b.this.f8973a != null && b.this.f8973a.get() != null) {
                ((com.ubix.ssp.ad.i.c) b.this.f8973a.get()).w();
            }
            try {
                u.e("onAdRenderSucceed out");
                UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener3 = this.b;
                if (uBiXNativeExpressInteractionListener3 != null) {
                    uBiXNativeExpressInteractionListener3.onAdRenderSucceed((View) ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("native_parent_view_key"));
                }
                u.e("onAdRenderSucceed out");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            b.this.a(this.b);
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
            if (this.d.decrementAndGet() == 0) {
                if (b.this.f8973a != null && b.this.f8973a.get() != null) {
                    ((com.ubix.ssp.ad.i.c) b.this.f8973a.get()).c(adError);
                }
                UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener = this.b;
                if (uBiXNativeExpressInteractionListener != null) {
                    uBiXNativeExpressInteractionListener.onAdRenderFailed(adError);
                }
            }
        }
    }

    class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.i.c f8976a;
        final /* synthetic */ UBiXNativeExpressInteractionListener b;

        class a implements com.ubix.ssp.ad.a.y {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f8977a;
            final /* synthetic */ com.ubix.ssp.ad.d.a b;

            a(int i, com.ubix.ssp.ad.d.a aVar) {
                this.f8977a = i;
                this.b = aVar;
            }

            @Override // com.ubix.ssp.ad.a.y
            public void a() {
                if (b.this.c == null || b.this.c.get() == null) {
                    return;
                }
                ((com.ubix.ssp.ad.i.a) b.this.c.get()).q = true;
            }

            @Override // com.ubix.ssp.ad.a.y
            public boolean a(boolean z) {
                com.ubix.ssp.ad.i.a aVar;
                if (z) {
                    int i = this.f8977a;
                    if (i == 44) {
                        com.ubix.ssp.ad.e.s.b.c().a(((com.ubix.ssp.ad.i.a) b.this.c.get()).getContext(), this.b.o);
                    } else if (i == 45) {
                        com.ubix.ssp.ad.e.s.b.c().b(((com.ubix.ssp.ad.i.a) b.this.c.get()).getContext(), this.b.o);
                    } else {
                        int i2 = 46;
                        if (i == 46) {
                            if (b.this.c != null && b.this.c.get() != null) {
                                aVar = (com.ubix.ssp.ad.i.a) b.this.c.get();
                                aVar.d(i2, 0);
                            }
                        } else if (b.this.c != null && b.this.c.get() != null) {
                            aVar = (com.ubix.ssp.ad.i.a) b.this.c.get();
                            i2 = 42;
                            aVar.d(i2, 0);
                        }
                    }
                    c.this.h();
                    return false;
                }
                c.this.h();
                return true;
            }
        }

        c(com.ubix.ssp.ad.i.c cVar, UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener) {
            this.f8976a = cVar;
            this.b = uBiXNativeExpressInteractionListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            if (b.this.c == null || b.this.c.get() == null) {
                return;
            }
            ((com.ubix.ssp.ad.i.a) b.this.c.get()).q = false;
            ((com.ubix.ssp.ad.i.a) b.this.c.get()).setShakeSensor(null);
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void a(int i, long j, long j2) {
            UBiXNativeExpressVideoListener uBiXNativeExpressVideoListener;
            com.ubix.ssp.ad.i.c cVar;
            com.ubix.ssp.ad.d.a aVarN;
            int i2;
            if (b.this.a() == null || b.this.a().getCustomizeVideo() == null) {
                return;
            }
            if (j2 > 0 && ((int) ((100 * j) / j2)) >= b.this.e * 25) {
                if (b.this.e == 0) {
                    ((NativeAd) b.this.b.get()).getCustomizeVideo().reportVideoStart();
                } else {
                    if (b.this.e == 1) {
                        cVar = this.f8976a;
                        aVarN = cVar.n(i);
                        i2 = 5025;
                    } else if (b.this.e == 2) {
                        cVar = this.f8976a;
                        aVarN = cVar.n(i);
                        i2 = 5050;
                    } else if (b.this.e == 3) {
                        cVar = this.f8976a;
                        aVarN = cVar.n(i);
                        i2 = 5075;
                    }
                    cVar.a(aVarN, i2);
                }
                b.h(b.this);
            }
            if (b.this.d.get(Integer.valueOf(((NativeAd) b.this.b.get()).hashCode())) == null || (uBiXNativeExpressVideoListener = (UBiXNativeExpressVideoListener) ((HashMap) b.this.d.get(Integer.valueOf(((NativeAd) b.this.b.get()).hashCode()))).get("video_listener_key")) == null) {
                return;
            }
            uBiXNativeExpressVideoListener.onVideoProgressUpdate(j, j2);
        }

        @Override // com.ubix.ssp.ad.g.k.g, com.ubix.ssp.ad.g.k.b
        public void a(int i, Bundle bundle) {
            if (b.this.c() != null) {
                b.this.c().a(bundle);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void a(int i, AdError adError) {
            if (b.this.a() == null || b.this.d.get(Integer.valueOf(b.this.a().hashCode())) == null) {
                return;
            }
            com.ubix.ssp.ad.i.c cVar = this.f8976a;
            cVar.a(cVar.n(i), 5200);
            UBiXNativeExpressVideoListener uBiXNativeExpressVideoListener = (UBiXNativeExpressVideoListener) ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("video_listener_key");
            if (uBiXNativeExpressVideoListener != null) {
                uBiXNativeExpressVideoListener.onVideoError(adError);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g, com.ubix.ssp.ad.g.k.b
        public void b(int i) {
            try {
                if (b.this.b == null || b.this.b.get() == null) {
                    return;
                }
                f.a(StubApp.getOrigApplicationContext(((com.ubix.ssp.ad.i.a) b.this.c.get()).getContext().getApplicationContext()), ((NativeAd) b.this.b.get()).getAppIntroduceLink(), 0, b.this.f, "", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g, com.ubix.ssp.ad.g.k.b
        public void b(int i, View view, HashMap<String, String> map) {
            com.ubix.ssp.ad.i.c cVarC = b.this.c();
            if (cVarC == null) {
                return;
            }
            if (map == null) {
                if (b.this.b() == null) {
                    return;
                } else {
                    map = ((com.ubix.ssp.ad.i.a) b.this.c.get()).getClickMap();
                }
            }
            com.ubix.ssp.ad.d.a aVarN = cVarC.n(i);
            int iB = com.ubix.ssp.ad.e.s.b.c().b(aVarN.o);
            if (iB == 46) {
                try {
                    if (!map.containsKey("__NO_CLICK_CONFIRM_KEY__")) {
                        map.put("__NO_CLICK_CONFIRM_KEY__", "TRUE");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            cVarC.a(cVarC.n(i), new a(iB, aVarN));
            Object obj = (b.this.a() == null || b.this.d.get(Integer.valueOf(b.this.a().hashCode())) == null) ? null : ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("native_custom_confirm_window_listener_key");
            if (cVarC.a(cVarC.n(i), view, map, (UBiXNativeInteractionListener) null, this.b, obj == null ? null : (com.ubix.ssp.ad.g.c) obj)) {
                aVarN.s = true;
                ((com.ubix.ssp.ad.i.a) b.this.c.get()).k();
                ((com.ubix.ssp.ad.i.a) b.this.c.get()).s();
                if ("12".equals(map.get("__CLICK_AREA__"))) {
                    ((com.ubix.ssp.ad.i.a) b.this.c.get()).setSlideTrigger(true);
                    aVarN.t = true;
                }
                map.put("__MULTI_CLICK_KEY__", "TRUE");
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void c(int i) {
            if (b.this.a() != null) {
                if (b.this.a().getCustomizeVideo() != null) {
                    b.this.a().getCustomizeVideo().reportVideoComplete();
                }
                if (b.this.d.get(Integer.valueOf(b.this.a().hashCode())) != null) {
                    com.ubix.ssp.ad.i.c cVar = this.f8976a;
                    cVar.a(cVar.n(i), 5200);
                    UBiXNativeExpressVideoListener uBiXNativeExpressVideoListener = (UBiXNativeExpressVideoListener) ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("video_listener_key");
                    if (uBiXNativeExpressVideoListener != null) {
                        uBiXNativeExpressVideoListener.onVideoComplete();
                    }
                }
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g, com.ubix.ssp.ad.g.k.f
        public void d(int i) {
            if (b.this.b == null || b.this.b.get() == null) {
                return;
            }
            b bVar = b.this;
            bVar.a(((NativeAd) bVar.b.get()).hashCode());
        }

        @Override // com.ubix.ssp.ad.g.k.g, com.ubix.ssp.ad.g.k.b
        public void e(int i) {
            try {
                com.ubix.ssp.ad.d.a aVarN = this.f8976a.n(i);
                if (aVarN.f8604a.k) {
                    this.f8976a.a(aVarN, this.b);
                    return;
                }
                u.e("onAdClosed in");
                UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener = this.b;
                if (uBiXNativeExpressInteractionListener != null) {
                    uBiXNativeExpressInteractionListener.onAdClosed();
                }
                u.e("onAdClosed out");
            } catch (Throwable th) {
                th.printStackTrace();
                u.e("onAdClosed in");
                UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener2 = this.b;
                if (uBiXNativeExpressInteractionListener2 != null) {
                    uBiXNativeExpressInteractionListener2.onAdClosed();
                }
                u.e("onAdClosed out");
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g, com.ubix.ssp.ad.g.k.b
        public void f(int i) {
            try {
                if (b.this.b == null || b.this.b.get() == null) {
                    return;
                }
                f.a(StubApp.getOrigApplicationContext(((com.ubix.ssp.ad.i.a) b.this.c.get()).getContext().getApplicationContext()), ((NativeAd) b.this.b.get()).getAppPermissionLink(), 0, b.this.f, "", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void g(int i) {
            if (b.this.a() == null || b.this.d.get(Integer.valueOf(b.this.a().hashCode())) == null) {
                return;
            }
            try {
                Object obj = ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("lst_sts");
                Object obj2 = ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("lst_stp");
                boolean z = obj != null ? Boolean.parseBoolean(obj + "") : false;
                if ((obj2 == null || !Boolean.parseBoolean(obj2 + "")) && !z) {
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            HashMap map = (HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()));
            Boolean bool = Boolean.FALSE;
            map.put("lst_sts", bool);
            ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).put("lst_stp", bool);
            UBiXNativeExpressVideoListener uBiXNativeExpressVideoListener = (UBiXNativeExpressVideoListener) ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("video_listener_key");
            if (uBiXNativeExpressVideoListener != null) {
                uBiXNativeExpressVideoListener.onVideoPause();
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void h(int i) {
            if (b.this.a() != null) {
                try {
                    Object obj = ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("lst_sts");
                    if (obj != null && Boolean.parseBoolean(obj + "")) {
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (b.this.d.get(Integer.valueOf(b.this.a().hashCode())) != null) {
                    ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).put("lst_sts", Boolean.TRUE);
                    UBiXNativeExpressVideoListener uBiXNativeExpressVideoListener = (UBiXNativeExpressVideoListener) ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("video_listener_key");
                    if (uBiXNativeExpressVideoListener != null) {
                        uBiXNativeExpressVideoListener.onVideoStart();
                    }
                }
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g, com.ubix.ssp.ad.g.k.b
        public void i(int i) {
            try {
                if (b.this.b == null || b.this.b.get() == null) {
                    return;
                }
                f.a(StubApp.getOrigApplicationContext(((com.ubix.ssp.ad.i.a) b.this.c.get()).getContext().getApplicationContext()), ((NativeAd) b.this.b.get()).getAppPrivacyLink(), 0, b.this.f, "", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void j(int i) {
            if (b.this.a() == null || b.this.d.get(Integer.valueOf(b.this.a().hashCode())) == null) {
                return;
            }
            long j = 0;
            boolean z = false;
            try {
                Object obj = ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("lst_res");
                Object obj2 = ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("lst_stp");
                j = obj != null ? Long.parseLong(obj + "") : 0L;
                if (obj2 != null) {
                    z = Boolean.parseBoolean(obj2 + "");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (System.currentTimeMillis() - j <= 100 || z) {
                return;
            }
            try {
                ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).put("lst_res", Long.valueOf(System.currentTimeMillis()));
                HashMap map = (HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()));
                Boolean bool = Boolean.TRUE;
                map.put("lst_sts", bool);
                ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).put("lst_stp", bool);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            UBiXNativeExpressVideoListener uBiXNativeExpressVideoListener = (UBiXNativeExpressVideoListener) ((HashMap) b.this.d.get(Integer.valueOf(b.this.a().hashCode()))).get("video_listener_key");
            if (uBiXNativeExpressVideoListener != null) {
                uBiXNativeExpressVideoListener.onVideoResume();
            }
        }
    }

    class d implements UBiXNativeInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXNativeExpressInteractionListener f8978a;

        d(UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener) {
            this.f8978a = uBiXNativeExpressInteractionListener;
        }

        @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
        public void onAdClicked(View view) {
            if (this.f8978a == null || b.this.f.m0()) {
                return;
            }
            this.f8978a.onAdClicked(view);
        }

        @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
        public void onAdClosed() {
            UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener = this.f8978a;
            if (uBiXNativeExpressInteractionListener != null) {
                uBiXNativeExpressInteractionListener.onAdClosed();
            }
        }

        @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
        public void onAdExposeFailed(AdError adError) {
            UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener = this.f8978a;
            if (uBiXNativeExpressInteractionListener != null) {
                uBiXNativeExpressInteractionListener.onAdExposeFailed(adError);
            }
        }

        @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
        public void onAdExposed() {
            UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener = this.f8978a;
            if (uBiXNativeExpressInteractionListener != null) {
                uBiXNativeExpressInteractionListener.onAdExposed();
            }
        }

        @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
        public void onAdStatusChanged() {
        }
    }

    public b(com.ubix.ssp.ad.i.c cVar, NativeAd nativeAd, com.ubix.ssp.ad.i.a aVar, l lVar, ConcurrentHashMap<Integer, HashMap<String, Object>> concurrentHashMap) {
        this.d = new ConcurrentHashMap<>();
        this.f8973a = new SoftReference<>(cVar);
        this.b = new SoftReference<>(nativeAd);
        this.c = new SoftReference<>(aVar);
        this.d = concurrentHashMap;
        this.f = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NativeAd a() {
        SoftReference<NativeAd> softReference = this.b;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x007f  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:56:0x010a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x010c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0123  */
    /* JADX WARN: Code duplicated, block: B:67:0x013c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0147  */
    /* JADX WARN: Code duplicated, block: B:78:0x019c  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:84:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    public void a(int i) {
        ArrayList arrayList;
        int i2;
        com.ubix.ssp.ad.e.y.a.a.b.f fVar;
        UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener;
        int i3;
        HashMap<String, Object> map = this.d.get(Integer.valueOf(i));
        if (map != null) {
            NativeAd nativeAd = (NativeAd) map.get("native_ad_bean_key");
            int iB = b(i);
            if (iB == -1) {
                return;
            }
            com.ubix.ssp.ad.d.a aVarN = this.f8973a.get().n(iB);
            if (map.containsKey("native_core_view") && map.containsKey("native_images_array_key") && map.containsKey("native_videos_array_key")) {
                Bundle bundle = new Bundle();
                com.ubix.ssp.ad.b bVar = (com.ubix.ssp.ad.b) map.get("native_core_view");
                Object obj = map.get("native_images_array_key");
                Object obj2 = map.get("native_videos_array_key");
                if (nativeAd == null || bVar == null) {
                    return;
                }
                ArrayList arrayList2 = null;
                if (obj != null) {
                    try {
                        arrayList = (ArrayList) obj;
                    } catch (Exception e) {
                        e = e;
                        arrayList = null;
                        e.printStackTrace();
                        i2 = aVarN.p;
                        if (i2 == 2005) {
                            if (arrayList != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        if (i2 != 2013) {
                            if (arrayList != null) {
                                bundle.putStringArray("IMAGE_URL", new String[]{(String) arrayList.get(0)});
                            }
                            if (arrayList2 != null) {
                                bundle.putStringArray("VIDEO_URL", new String[]{(String) arrayList2.get(0)});
                            }
                            if (bundle.getStringArray("IMAGE_URL") == null) {
                                bundle.putStringArray("IMAGE_URL", new String[0]);
                            }
                            if (bundle.getStringArray("VIDEO_URL") == null) {
                                bundle.putStringArray("VIDEO_URL", new String[0]);
                            }
                        } else {
                            if (arrayList != null) {
                                bundle.putStringArray("IMAGE_URL", new String[]{(String) arrayList.get(0)});
                            }
                            if (arrayList2 != null) {
                                bundle.putStringArray("VIDEO_URL", new String[]{(String) arrayList2.get(0)});
                            }
                            if (bundle.getStringArray("IMAGE_URL") == null) {
                                bundle.putStringArray("IMAGE_URL", new String[0]);
                            }
                            if (bundle.getStringArray("VIDEO_URL") == null) {
                                bundle.putStringArray("VIDEO_URL", new String[0]);
                            }
                        }
                        fVar = aVarN.f8604a.d.L;
                        if (fVar != null) {
                            bundle.putInt("RENDER_MODE", i3);
                            bundle.putFloat("SCALE_IGNORE_PERCENT", (aVarN.f8604a.d.L.c * 1.0f) / 100.0f);
                            bundle.putInt("SCALE_HORIZONTAL_MARGIN", aVarN.f8604a.d.L.d);
                            bundle.putInt("SCALE_VERTICAL_MARGIN", aVarN.f8604a.d.L.e);
                        }
                        bundle.putBoolean("IS_UNNAMED", this.f.G0());
                        if (!bVar.b(bundle)) {
                            uBiXNativeExpressInteractionListener = (UBiXNativeExpressInteractionListener) map.get("interaction_listener_key");
                            if (uBiXNativeExpressInteractionListener != null) {
                                uBiXNativeExpressInteractionListener.onAdRenderFailed(com.ubix.ssp.ad.e.a0.a0.a.g(2, "内容加载失败"));
                                return;
                            }
                            return;
                        }
                        if (c() != null) {
                            c().a(iB, bVar);
                        }
                        if (nativeAd.isDownloadAd()) {
                            bVar.a(nativeAd.getAppName(), nativeAd.getAppVersion(), nativeAd.getAppPublisher(), nativeAd.getAppPackageName(), nativeAd.getAppICPNumber(), nativeAd.getAppSuitableAge(), nativeAd.getAppDownloadSize());
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (obj2 != null) {
                    try {
                        arrayList2 = (ArrayList) obj2;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                }
                i2 = aVarN.p;
                if (i2 == 2005) {
                    if (arrayList != null || arrayList.isEmpty()) {
                        return;
                    }
                    String[] strArr = new String[3];
                    int size = arrayList.size();
                    if (size == 1) {
                        strArr[0] = (String) arrayList.get(0);
                        strArr[1] = (String) arrayList.get(0);
                        strArr[2] = (String) arrayList.get(0);
                    } else if (size != 2) {
                        strArr[0] = (String) arrayList.get(0);
                        strArr[1] = (String) arrayList.get(1);
                        strArr[2] = (String) arrayList.get(2);
                    } else {
                        strArr[0] = (String) arrayList.get(0);
                        strArr[1] = (String) arrayList.get(1);
                        strArr[2] = (String) arrayList.get(0);
                    }
                    bundle.putStringArray("IMAGE_URL", strArr);
                } else if (i2 != 2013 || i2 == 2012 || i2 == 2014 || i2 == 2011) {
                    if (arrayList != null && arrayList.size() > 0) {
                        bundle.putStringArray("IMAGE_URL", new String[]{(String) arrayList.get(0)});
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        bundle.putStringArray("VIDEO_URL", new String[]{(String) arrayList2.get(0)});
                    }
                    if (bundle.getStringArray("IMAGE_URL") == null) {
                        bundle.putStringArray("IMAGE_URL", new String[0]);
                    }
                    if (bundle.getStringArray("VIDEO_URL") == null) {
                        bundle.putStringArray("VIDEO_URL", new String[0]);
                    }
                } else if (arrayList != null && arrayList.size() > 0) {
                    bundle.putStringArray("IMAGE_URL", new String[]{(String) arrayList.get(0)});
                }
                fVar = aVarN.f8604a.d.L;
                if (fVar != null && (i3 = fVar.b) != 0) {
                    bundle.putInt("RENDER_MODE", i3);
                    bundle.putFloat("SCALE_IGNORE_PERCENT", (aVarN.f8604a.d.L.c * 1.0f) / 100.0f);
                    bundle.putInt("SCALE_HORIZONTAL_MARGIN", aVarN.f8604a.d.L.d);
                    bundle.putInt("SCALE_VERTICAL_MARGIN", aVarN.f8604a.d.L.e);
                }
                bundle.putBoolean("IS_UNNAMED", this.f.G0());
                if (!bVar.b(bundle)) {
                    uBiXNativeExpressInteractionListener = (UBiXNativeExpressInteractionListener) map.get("interaction_listener_key");
                    if (uBiXNativeExpressInteractionListener != null) {
                        uBiXNativeExpressInteractionListener.onAdRenderFailed(com.ubix.ssp.ad.e.a0.a0.a.g(2, "内容加载失败"));
                        return;
                    }
                    return;
                }
                if (c() != null) {
                    c().a(iB, bVar);
                }
                if (nativeAd.isDownloadAd()) {
                    bVar.a(nativeAd.getAppName(), nativeAd.getAppVersion(), nativeAd.getAppPublisher(), nativeAd.getAppPackageName(), nativeAd.getAppICPNumber(), nativeAd.getAppSuitableAge(), nativeAd.getAppDownloadSize());
                }
            }
        }
    }

    private int b(int i) {
        HashMap<String, Object> map = this.d.get(Integer.valueOf(i));
        if (map != null && map.get("native_ad_index_key") != null) {
            try {
                return Integer.parseInt(map.get("native_ad_index_key") + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ubix.ssp.ad.i.a b() {
        SoftReference<com.ubix.ssp.ad.i.a> softReference = this.c;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ubix.ssp.ad.i.c c() {
        SoftReference<com.ubix.ssp.ad.i.c> softReference = this.f8973a;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    static /* synthetic */ int h(b bVar) {
        int i = bVar.e;
        bVar.e = i + 1;
        return i;
    }

    public void a(com.ubix.ssp.ad.d.a aVar, UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (a() == null) {
            AdError adErrorG = com.ubix.ssp.ad.e.a0.a0.a.g(2, "广告View为空");
            SoftReference<com.ubix.ssp.ad.i.c> softReference = this.f8973a;
            if (softReference != null && softReference.get() != null) {
                this.f8973a.get().c(adErrorG);
            }
            u.e("onAdRenderFailed in");
            if (uBiXNativeExpressInteractionListener != null) {
                uBiXNativeExpressInteractionListener.onAdRenderFailed(adErrorG);
            }
            u.e("onAdRenderFailed out");
            return;
        }
        SoftReference<com.ubix.ssp.ad.i.a> softReference2 = this.c;
        if (softReference2 != null && softReference2.get() != null && aVar.s) {
            this.c.get().k();
        }
        int i = aVar.p;
        if (i == 2013 || i == 2012 || i == 2014 || i == 2011) {
            if (this.b.get().getCustomizeVideo() != null) {
                e.b().a(this.b.get().getCustomizeVideo().getCoverUrl(), -1, new a(uBiXNativeExpressInteractionListener, arrayList, arrayList2));
                return;
            }
            AdError adErrorG2 = com.ubix.ssp.ad.e.a0.a0.a.g(2, "Custom视频内容为空");
            SoftReference<com.ubix.ssp.ad.i.c> softReference3 = this.f8973a;
            if (softReference3 != null && softReference3.get() != null) {
                this.f8973a.get().c(adErrorG2);
            }
            u.e("onAdRenderFailed in");
            if (uBiXNativeExpressInteractionListener != null) {
                uBiXNativeExpressInteractionListener.onAdRenderFailed(adErrorG2);
            }
            u.e("onAdRenderFailed out");
            return;
        }
        if (a().getImageList() == null) {
            AdError adErrorG3 = com.ubix.ssp.ad.e.a0.a0.a.g(2, "广告View为空");
            SoftReference<com.ubix.ssp.ad.i.c> softReference4 = this.f8973a;
            if (softReference4 != null && softReference4.get() != null) {
                this.f8973a.get().c(adErrorG3);
            }
            u.e("onAdRenderFailed in");
            if (uBiXNativeExpressInteractionListener != null) {
                uBiXNativeExpressInteractionListener.onAdRenderFailed(adErrorG3);
            }
            u.e("onAdRenderFailed out");
        }
        AtomicInteger atomicInteger = new AtomicInteger(this.b.get().getImageList().size());
        AtomicInteger atomicInteger2 = new AtomicInteger(this.b.get().getImageList().size());
        for (int i2 = 0; i2 < this.b.get().getImageList().size(); i2++) {
            e.b().a(this.b.get().getImageList().get(i2).getUrl(), new C1118b(arrayList, uBiXNativeExpressInteractionListener, atomicInteger, atomicInteger2));
        }
    }

    public void a(UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener) {
        this.b.get().registerViews(this.c.get(), new ArrayList(), null, new d(uBiXNativeExpressInteractionListener));
    }

    public void b(UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener) {
        com.ubix.ssp.ad.i.c cVarC = c();
        SoftReference<com.ubix.ssp.ad.i.a> softReference = this.c;
        if (softReference == null || softReference.get() == null || cVarC == null) {
            return;
        }
        this.c.get().setInnerListener(new c(cVarC, uBiXNativeExpressInteractionListener));
    }
}

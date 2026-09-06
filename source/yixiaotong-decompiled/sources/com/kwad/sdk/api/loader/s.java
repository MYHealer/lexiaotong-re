package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.am;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class s {

    public interface c<T> {
        void m(T t);
    }

    public interface f<T> {
        void a(ab abVar, c<T> cVar);
    }

    static f<Boolean> HK() {
        return new e(new g(new d(new h(new b()))));
    }

    static abstract class a<T> implements c<T> {
        c<T> aID;

        a(c<T> cVar) {
            this.aID = cVar;
        }
    }

    static class e implements f<Boolean> {
        f<com.kwad.sdk.api.loader.a.C0726a> aIH;

        e(f<com.kwad.sdk.api.loader.a.C0726a> fVar) {
            this.aIH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<Boolean> cVar) {
            this.aIH.a(abVar, new c<com.kwad.sdk.api.loader.a.C0726a>() { // from class: com.kwad.sdk.api.loader.s.e.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void m(com.kwad.sdk.api.loader.a.C0726a c0726a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        l.b(c0726a);
                        if (!com.kwad.sdk.api.loader.d.a(abVar.getContext(), getClass().getClassLoader(), c0726a.aHE.getPath(), c0726a.sdkVersion)) {
                            a(c0726a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        i.t(abVar.getContext(), c0726a.sdkVersion);
                        j.j(c0726a.aHE);
                        l.b(c0726a, System.currentTimeMillis() - jCurrentTimeMillis);
                        cVar.m(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0726a, 2, th);
                    }
                }

                private void a(com.kwad.sdk.api.loader.a.C0726a c0726a, int i, Throwable th) {
                    j.j(c0726a.aHE);
                    l.b(c0726a, i, Log.getStackTraceString(th));
                }
            });
        }
    }

    static class g implements f<com.kwad.sdk.api.loader.a.C0726a> {
        f<com.kwad.sdk.api.loader.a.C0726a> aIH;

        g(f<com.kwad.sdk.api.loader.a.C0726a> fVar) {
            this.aIH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(ab abVar, final c<com.kwad.sdk.api.loader.a.C0726a> cVar) {
            this.aIH.a(abVar, new a<com.kwad.sdk.api.loader.a.C0726a>(cVar) { // from class: com.kwad.sdk.api.loader.s.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void m(com.kwad.sdk.api.loader.a.C0726a c0726a) {
                    try {
                        File file = c0726a.aHE;
                        if (!x.k(file)) {
                            a(c0726a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!x.a(file, c0726a.md5)) {
                            a(c0726a, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            cVar.m(c0726a);
                        }
                    } catch (Throwable th) {
                        a(c0726a, 3, th);
                    }
                }

                private void a(com.kwad.sdk.api.loader.a.C0726a c0726a, int i, Throwable th) {
                    j.j(c0726a.aHE);
                    l.a(c0726a, i, th.getMessage());
                }
            });
        }
    }

    static class d implements f<com.kwad.sdk.api.loader.a.C0726a> {
        f<com.kwad.sdk.api.loader.a.C0726a> aIH;

        d(f<com.kwad.sdk.api.loader.a.C0726a> fVar) {
            this.aIH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<com.kwad.sdk.api.loader.a.C0726a> cVar) {
            this.aIH.a(abVar, new a<com.kwad.sdk.api.loader.a.C0726a>(cVar) { // from class: com.kwad.sdk.api.loader.s.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void m(com.kwad.sdk.api.loader.a.C0726a c0726a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    File fileV = null;
                    try {
                        l.a(c0726a);
                        fileV = j.v(abVar.getContext(), c0726a.sdkVersion);
                        k.c(c0726a.aHD, fileV);
                        l.a(c0726a, System.currentTimeMillis() - jCurrentTimeMillis);
                        c0726a.aHE = fileV;
                        cVar.m(c0726a);
                    } catch (Throwable th) {
                        l.a(c0726a, System.currentTimeMillis() - jCurrentTimeMillis, Log.getStackTraceString(th));
                        j.j(fileV);
                    }
                }
            });
        }
    }

    static class h implements f<com.kwad.sdk.api.loader.a.C0726a> {
        f<com.kwad.sdk.api.loader.a.C0726a> aIH;

        h(f<com.kwad.sdk.api.loader.a.C0726a> fVar) {
            this.aIH = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<com.kwad.sdk.api.loader.a.C0726a> cVar) {
            this.aIH.a(abVar, new c<com.kwad.sdk.api.loader.a.C0726a>() { // from class: com.kwad.sdk.api.loader.s.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void m(com.kwad.sdk.api.loader.a.C0726a c0726a) {
                    String strBo = i.bo(abVar.getContext());
                    if (TextUtils.isEmpty(strBo)) {
                        strBo = com.kwad.sdk.api.c.Hu().getSDKVersion();
                    }
                    String str = c0726a.sdkVersion;
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), am.aT, c0726a.interval);
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0726a.HB()) {
                        aa.bv(abVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + strBo);
                    } else if (i.N(c0726a.sdkVersion, strBo) && c0726a.HA()) {
                        cVar.m(c0726a);
                    } else {
                        new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0726a.sdkVersion + " currentDynamicVersion:" + strBo + " dynamicType:" + c0726a.aHC);
                    }
                }
            });
        }
    }

    static class b implements f<com.kwad.sdk.api.loader.a.C0726a> {
        b() {
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<com.kwad.sdk.api.loader.a.C0726a> cVar) {
            try {
                new com.kwad.sdk.api.loader.h(abVar).a(new com.kwad.sdk.api.loader.h.a() { // from class: com.kwad.sdk.api.loader.s.b.1
                    @Override // com.kwad.sdk.api.loader.h.a
                    public final void a(com.kwad.sdk.api.loader.a.b bVar) {
                        new StringBuilder("ConfigProducer onSuccess data:").append(bVar);
                        if (bVar.isLegal()) {
                            cVar.m(bVar.aHF);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.f.bn(abVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}

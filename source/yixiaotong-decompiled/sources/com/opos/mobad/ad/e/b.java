package com.opos.mobad.ad.e;

import com.opos.mobad.ad.j;
import com.opos.mobad.ad.l;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface b extends j, l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6654a = new b() { // from class: com.opos.mobad.ad.e.b.1
        @Override // com.opos.mobad.ad.b.a
        public void a() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdReady");
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdFailed code:" + i + ",msg:" + str);
        }

        @Override // com.opos.mobad.ad.e.b, com.opos.mobad.ad.l.b
        public void a(long j) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdClick currentPosition=" + j);
        }

        @Override // com.opos.mobad.ad.l.b
        public void a(String str) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdShow");
        }

        @Override // com.opos.mobad.ad.j
        public void a(Object... objArr) {
            StringBuilder sb = new StringBuilder("onReward objects=");
            Object obj = objArr;
            if (objArr == null) {
                obj = "null";
            }
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", sb.append(obj).toString());
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onAdClose");
        }

        @Override // com.opos.mobad.ad.e.b
        public void b(long j) {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayClose currentPosition=" + j);
        }

        @Override // com.opos.mobad.ad.e.b
        public void b(String str) {
            StringBuilder sb = new StringBuilder("onVideoPlayError msg=");
            if (str == null) {
                str = "null";
            }
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", sb.append(str).toString());
        }

        @Override // com.opos.mobad.ad.e.b
        public void c() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayStart");
        }

        @Override // com.opos.mobad.ad.e.b
        public void d() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onVideoPlayComplete");
        }

        @Override // com.opos.mobad.ad.e.b
        public void e() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onLandingPageOpen");
        }

        @Override // com.opos.mobad.ad.e.b
        public void f() {
            com.opos.cmn.an.f.a.b("IRewardVideoAdListener", "onLandingPageClose");
        }
    };

    void a(long j);

    void b(long j);

    void b(String str);

    void c();

    void d();

    void e();

    void f();
}

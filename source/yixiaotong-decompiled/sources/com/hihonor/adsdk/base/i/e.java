package com.hihonor.adsdk.base.i;

import android.os.SystemClock;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import com.hihonor.adsdk.base.g.j.d.h0;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class e {
    private static final String hnadsa = "StartAppEngine";
    public static final int hnadsb = 0;
    public static final int hnadsc = 1;

    private static class a implements c {
        private final c hnadsa;
        private final com.hihonor.adsdk.base.i.j.a hnadsb;

        public a(com.hihonor.adsdk.base.i.j.a aVar, c cVar) {
            this.hnadsa = cVar;
            this.hnadsb = aVar;
        }

        @Override // com.hihonor.adsdk.base.i.c
        public void hnadsa(com.hihonor.adsdk.base.i.i.b bVar) {
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsa, "proxy start listener back onStart code=" + bVar.hnadsa() + ",msg=" + bVar.hnadsc(), new Object[0]);
            if (Objects.nonNull(this.hnadsa) && bVar.hnadse()) {
                this.hnadsa.hnadsa(bVar);
            }
            this.hnadsb.hnadsa(bVar);
            this.hnadsb.hnadsa();
        }
    }

    private e() {
    }

    public static g hnadsa(BaseAd baseAd) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "with base ad", new Object[0]);
        return new b(baseAd);
    }

    public static g hnadsa(com.hihonor.adsdk.base.download.g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "with ad download info", new Object[0]);
        return new b(gVar);
    }

    private static final class b implements g {
        private final d hnadsa;
        private c hnadsb;
        private com.hihonor.adsdk.base.i.j.a hnadsc;
        private com.hihonor.adsdk.base.i.b hnadsd;
        private int hnadse;
        private int hnadsf = 0;

        public b(BaseAd baseAd) {
            this.hnadsa = new d.a(baseAd).hnadsa();
        }

        @Override // com.hihonor.adsdk.base.i.g
        public g hnadsa() {
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsa, "select type is start app", new Object[0]);
            this.hnadsc = new com.hihonor.adsdk.base.i.j.b(this.hnadsa);
            this.hnadsd = new f(this.hnadsa);
            this.hnadsf = 0;
            return this;
        }

        @Override // com.hihonor.adsdk.base.i.g
        public g hnadsb() {
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsa, "select type is start deeplink", new Object[0]);
            this.hnadsc = new com.hihonor.adsdk.base.i.j.c(this.hnadsa);
            this.hnadsd = new h(this.hnadsa);
            this.hnadsf = 1;
            return this;
        }

        @Override // com.hihonor.adsdk.base.i.g
        public void start() {
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsa, "start enter.", new Object[0]);
            if (this.hnadsf == 0) {
                com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsa, "start enter report open app.", new Object[0]);
                new h0(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsa), this.hnadsa.hnadsj(), this.hnadse, this.hnadsa.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa)).hnadse();
            }
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsa, "start enter reporter is null? " + Objects.nonNull(this.hnadsc) + ", isStartApp is null? " + Objects.nonNull(this.hnadsd), new Object[0]);
            if (Objects.nonNull(this.hnadsc)) {
                this.hnadsc.hnadsa(SystemClock.elapsedRealtime());
            }
            if (Objects.nonNull(this.hnadsd)) {
                new com.hihonor.adsdk.base.g.j.d.b(this.hnadsa.hnadsj(), this.hnadsa.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa)).hnadsb(com.hihonor.adsdk.base.j.f.hnadsa(this.hnadsa.hnadsn(), this.hnadsa.hnadsk())).hnadsa(this.hnadsa.hnadsg()).hnadse();
                this.hnadsd.hnadsa(new a(this.hnadsc, this.hnadsb));
            }
        }

        @Override // com.hihonor.adsdk.base.i.g
        public g hnadsa(c cVar) {
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsa, "set start app listener", new Object[0]);
            this.hnadsb = cVar;
            return this;
        }

        public b(com.hihonor.adsdk.base.download.g gVar) {
            this.hnadsa = new d.a(gVar).hnadsa();
        }

        @Override // com.hihonor.adsdk.base.i.g
        public g hnadsa(int i) {
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsa, "set scene = " + i, new Object[0]);
            this.hnadse = i;
            return this;
        }

        @Override // com.hihonor.adsdk.base.i.g
        public g hnadsa(boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(e.hnadsa, "setIsRemote = " + z, new Object[0]);
            this.hnadsa.hnadsa(z);
            return this;
        }

        public b(InstallNotifyBean installNotifyBean) {
            this.hnadsa = new d.a(installNotifyBean).hnadsa();
        }
    }

    public static g hnadsa(InstallNotifyBean installNotifyBean) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "with install notify bean", new Object[0]);
        return new b(installNotifyBean);
    }
}

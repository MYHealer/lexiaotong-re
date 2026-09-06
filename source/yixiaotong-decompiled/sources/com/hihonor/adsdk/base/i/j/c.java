package com.hihonor.adsdk.base.i.j;

import android.os.SystemClock;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.g.j.d.i;
import com.hihonor.adsdk.base.g.j.d.j;
import com.hihonor.adsdk.base.g.k.c.g;
import com.hihonor.adsdk.base.i.d;
import com.hihonor.adsdk.base.j.f;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends a {
    private static final String hnadsd = "StartDeeplinkReporter";

    public c(d dVar) {
        super(dVar);
    }

    private void hnadsb() {
        if (Objects.isNull(this.hnadsb) || Objects.isNull(this.hnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "Unable to call reportStartDeeplinkSuccess method,Cause by mRemoteResult or mStartAppBean is null.", new Object[0]);
            return;
        }
        int iHnadsa = f.hnadsa(this.hnadsa.hnadsn(), this.hnadsa.hnadsk());
        String strHnadsc = this.hnadsa.hnadsc();
        int iHnadsn = this.hnadsa.hnadsn();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.hnadsc;
        new j(this.hnadsa, strHnadsc, com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa)).hnadsc(iHnadsa).hnadsa(this.hnadsa.hnadsg()).hnadsa(com.hihonor.adsdk.base.g.j.e.a.X0, String.valueOf(this.hnadsb.hnadsd())).hnadsa("cost_time", String.valueOf(jElapsedRealtime)).hnadse();
        new g(f.hnadsa(iHnadsn), this.hnadsb.hnadsd()).hnadsc(this.hnadsa.hnadsa(), this.hnadsa.hnadsc(), this.hnadsa.hnadso(), this.hnadsa.hnadsh());
    }

    private void hnadsc() {
        if (Objects.isNull(this.hnadsb) || Objects.isNull(this.hnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "Unable to call reportStartFail method,Cause by mRemoteResult or mStartAppBean is null.", new Object[0]);
            return;
        }
        int iHnadsa = f.hnadsa(this.hnadsa.hnadsn(), this.hnadsa.hnadsk());
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa);
        com.hihonor.adsdk.base.g.j.d.h1.b bVar = new com.hihonor.adsdk.base.g.j.d.h1.b();
        bVar.hnadsb(String.valueOf(iHnadsa));
        bVar.hnadsc(String.valueOf(this.hnadsa.hnadsj()));
        bVar.hnadse(this.hnadsa.hnadsg());
        new i(this.hnadsa.hnadsc(), aVarHnadsa, bVar, ErrorCode.c.hnadsa, this.hnadsb.hnadsc()).hnadsa(this.hnadsb.hnadsd()).hnadsa(SystemClock.elapsedRealtime() - this.hnadsc).hnadsa("code", String.valueOf(this.hnadsb.hnadsa())).hnadsa(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(this.hnadsa.hnadsi())).hnadse();
        new com.hihonor.adsdk.base.g.k.c.f(ErrorCode.c.hnadsa, this.hnadsb.hnadsc(), f.hnadsa(this.hnadsa.hnadsn()), this.hnadsb.hnadsd()).hnadsc(this.hnadsa.hnadsa(), this.hnadsa.hnadsc(), this.hnadsa.hnadso(), this.hnadsa.hnadse());
        com.hihonor.adsdk.common.b.b.hnadse(hnadsd, this.hnadsb.hnadsc(), new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.i.j.a
    public void hnadsa() {
        if (Objects.isNull(this.hnadsb) || Objects.isNull(this.hnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "Unable to call onReport method,Cause by mRemoteResult or mStartAppBean is null.", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "StartDeeplinkReporter reportCode= " + this.hnadsb.hnadsa() + ",msg= " + this.hnadsb.hnadsc(), new Object[0]);
        if (this.hnadsb.hnadsa() == 0) {
            hnadsb();
        } else {
            hnadsc();
        }
    }
}

package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.components.h;
import com.kwad.sdk.components.p;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.utils.t;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static final AtomicBoolean aWP = new AtomicBoolean(false);
    private static volatile JSONArray aWQ;
    public String Np;
    public String Nq;
    public String Nr;
    public String Ns;
    public String Nt;
    public int Sp;
    public int Sq;
    public String aQZ;
    public String aRa;
    public String aWR;
    public String aWS;
    public String aWT;
    public String aWU;
    public String aWV;
    public int aWW;
    public int aWX;
    public String aWY;
    public String aWZ;
    public String aXa;
    public String aXb;
    public JSONArray aXc;
    public String aXd;
    public String aXe;
    public String aXg;
    public String aXh;
    public String aXi;

    @Deprecated
    public String aXk;
    public String aXl;
    public int aXm;
    public int apb;
    public int aqw;
    public int aqy;
    public String aqz;
    public String uaid;
    public int aXf = 0;
    public long aXj = 0;

    public static b Nr() {
        b bVar = new b();
        try {
            bVar.aRa = bf.getOaid();
            bVar.Nt = bf.getDeviceId();
            bVar.Np = bt.WK();
            bVar.aqw = 1;
            bVar.aqy = bt.WX();
            bVar.Nr = bt.getOsVersion();
            bVar.aXb = ai.getEGid();
            if (ai.Vr()) {
                bVar.aXd = ai.Vq();
            }
            if (ai.Vs() && !TextUtils.isEmpty(ai.Vp())) {
                bVar.uaid = ai.Vp();
            }
            h hVar = (h) com.kwad.sdk.components.d.f(h.class);
            if (hVar != null) {
                bVar.aXa = hVar.qQ();
            }
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
                bVar.aQZ = bf.dO(ServiceProvider.Ud());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    public static b h(boolean z, int i) {
        b bVar = new b();
        try {
            Context contextUd = ServiceProvider.Ud();
            bVar.aQZ = bf.dO(contextUd);
            bVar.aWR = bf.dR(contextUd);
            bVar.aWS = bf.dS(contextUd);
            bVar.aWT = bt.ev(contextUd);
            bVar.aRa = bf.getOaid();
            bVar.Np = bt.WK();
            bVar.Nq = bt.WM();
            bVar.aqw = 1;
            bVar.aqy = bt.WX();
            bVar.Nr = bt.getOsVersion();
            bVar.aqz = n.getLanguage();
            bVar.Sp = n.getScreenHeight(contextUd);
            bVar.Sq = n.getScreenWidth(contextUd);
            bVar.aWW = n.dd(contextUd);
            bVar.aWX = n.de(contextUd);
            bVar.aWY = bf.dP(contextUd);
            if (z) {
                bVar.aXc = ca(contextUd);
            }
            bVar.aXm = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Gl();
            bVar.aXe = bt.WW();
            if (ai.Vr()) {
                bVar.aXd = ai.Vq();
            }
            if (ai.Vs() && !TextUtils.isEmpty(ai.Vp())) {
                bVar.uaid = ai.Vp();
            }
            bVar.Nt = bf.getDeviceId();
            bVar.aXj = bt.WL();
            bVar.aWZ = bt.WU();
            bVar.aXb = ai.getEGid();
            h hVar = (h) com.kwad.sdk.components.d.f(h.class);
            if (hVar != null) {
                bVar.aXa = hVar.qQ();
            }
            bVar.apb = bt.WV();
            try {
                com.kwad.sdk.core.d.c.W("DeviceInfo", a((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class), bVar, contextUd));
            } catch (Exception unused) {
            }
            bVar.aXe = bt.WW();
            bVar.aXf = i;
            if (FM() && com.kwad.sdk.app.b.HO() != null) {
                bVar.aXg = com.kwad.sdk.app.b.HO().getVersion(contextUd, "com.smile.gifmaker");
                bVar.aXh = com.kwad.sdk.app.b.HO().getVersion(contextUd, "com.kuaishou.nebula");
                bVar.aXi = com.kwad.sdk.app.b.HO().getVersion(contextUd, "com.tencent.mm");
            }
            bVar.Ns = bt.WS();
            bVar.aWV = ao.dx(contextUd);
            bVar.aXl = bt.iq("/data/data");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    public final void i(boolean z, int i) {
        JSONArray jSONArray;
        Context contextUd = ServiceProvider.Ud();
        if (TextUtils.isEmpty(this.aQZ)) {
            this.aQZ = bf.dO(contextUd);
        }
        if (TextUtils.isEmpty(this.aWR)) {
            this.aWR = bf.dR(contextUd);
        }
        if (TextUtils.isEmpty(this.aWS)) {
            this.aWS = bf.dS(contextUd);
        }
        if (TextUtils.isEmpty(this.aWT)) {
            this.aWT = bt.ev(contextUd);
        }
        if (TextUtils.isEmpty(this.aRa)) {
            this.aRa = bf.getOaid();
        }
        if (TextUtils.isEmpty(this.aWY)) {
            this.aWY = bf.dP(contextUd);
        }
        if (TextUtils.isEmpty(this.Nt)) {
            this.Nt = bf.getDeviceId();
        }
        if (z && ((jSONArray = this.aXc) == null || jSONArray.length() == 0)) {
            this.aXc = ca(contextUd);
        }
        this.aXf = i;
    }

    private static boolean FM() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FM();
    }

    private static boolean FN() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FN();
    }

    private static String a(com.kwad.sdk.service.a.f fVar, b bVar, Context context) {
        StringBuilder sbAppend = new StringBuilder("i=").append(fVar.getAppId()).append(",n=").append(fVar.getAppName()).append(",external:").append(fVar.Fu()).append(",v1:").append(fVar.getApiVersion()).append(",v2:5.4.10.1,d:").append(bVar.Nt).append(",dh:");
        String str = bVar.Nt;
        String string = sbAppend.append(str != null ? Integer.valueOf(str.hashCode()) : "").append(",b:396,p:").append(ba.isInMainProcess(context)).append(",dy:").append(com.kwad.framework.a.a.ayN).toString();
        return !FN() ? string + ",o:" + bVar.aRa : string;
    }

    private static JSONArray ca(Context context) {
        if (aWP.compareAndSet(false, true)) {
            p pVar = (p) com.kwad.sdk.components.d.f(p.class);
            com.kwad.sdk.core.d.c.d("DeviceInfo", "getAppList: OptDataFetchComponent: " + pVar);
            if (pVar != null && t.UK()) {
                pVar.a(context, new com.kwad.sdk.g.a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(JSONArray jSONArray) {
                        g(jSONArray);
                    }

                    private static void g(JSONArray jSONArray) {
                        JSONArray unused = b.aWQ = jSONArray;
                    }
                });
            }
        }
        JSONArray jSONArray = aWQ;
        if (jSONArray == null) {
            return null;
        }
        aWQ = null;
        return jSONArray;
    }
}

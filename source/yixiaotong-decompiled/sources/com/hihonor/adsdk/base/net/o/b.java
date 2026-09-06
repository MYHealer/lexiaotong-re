package com.hihonor.adsdk.base.net.o;

import android.os.SystemClock;
import android.text.TextUtils;
import com.hihonor.adsdk.base.g.j.d.c0;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final String hnadsb = "AdLoadMonitor";
    public static final int hnadsc = 0;
    public static final int hnadsd = 1;
    public static final int hnadse = 2;
    public static final int hnadsf = 3;
    public static final int hnadsg = 4;
    public static final int hnadsh = 5;
    public static final int hnadsi = 6;
    public static final int hnadsj = 7;
    public static final int hnadsk = 8;
    public static final int hnadsl = 9;
    public static final int hnadsm = 10;
    public static final int hnadsn = 11;
    public static final int hnadso = 12;
    public static final int hnadsp = 13;
    public static final int hnadsq = 14;
    public static final int hnadsr = 15;
    public static final int hnadss = 16;
    public static final int hnadst = 17;
    public static final int hnadsu = 18;
    public static final int hnadsv = 19;
    public static final int hnadsw = 20;
    public static final int hnadsx = 21;
    private final Map<String, com.hihonor.adsdk.base.net.o.a> hnadsa;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.net.o.b$b, reason: collision with other inner class name */
    static class C0446b {
        static final b hnadsa = new b(null);

        C0446b() {
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b hnadsa() {
        return C0446b.hnadsa;
    }

    public void hnadsb(String str) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsb, (Object) ("removeCostTime clientReqId: " + str));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hnadsa.remove(str);
    }

    private b() {
        this.hnadsa = new ConcurrentHashMap();
    }

    public void hnadsa(String str, int i) {
        if (TextUtils.isEmpty(str)) {
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.hihonor.adsdk.base.net.o.a aVar = this.hnadsa.get(str);
        switch (i) {
            case 0:
                if (aVar == null) {
                    aVar = new com.hihonor.adsdk.base.net.o.a();
                    this.hnadsa.put(str, aVar);
                }
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsb, (Object) ("createCostTime clientReqId: " + str));
                aVar.hnadsj(jElapsedRealtime);
                break;
            case 1:
                if (aVar != null) {
                    aVar.hnadsi(jElapsedRealtime);
                }
                break;
            case 2:
                if (aVar != null) {
                    aVar.hnadsb(jElapsedRealtime);
                }
                break;
            case 3:
                if (aVar != null) {
                    aVar.hnadsa(jElapsedRealtime);
                }
                break;
            case 4:
                if (aVar != null) {
                    aVar.hnadsf(jElapsedRealtime);
                }
                break;
            case 5:
                if (aVar != null) {
                    aVar.hnadse(jElapsedRealtime);
                }
                break;
            case 6:
                if (aVar != null) {
                    aVar.hnadsr(jElapsedRealtime);
                }
                break;
            case 7:
                if (aVar != null) {
                    aVar.hnadsq(jElapsedRealtime);
                }
                break;
            case 8:
                if (aVar != null) {
                    aVar.hnadsp(jElapsedRealtime);
                }
                break;
            case 9:
                if (aVar != null) {
                    aVar.hnadso(jElapsedRealtime);
                }
                break;
            case 10:
                if (aVar != null) {
                    aVar.hnadsv(jElapsedRealtime);
                }
                break;
            case 11:
                if (aVar != null) {
                    aVar.hnadsu(jElapsedRealtime);
                }
                break;
            case 12:
                if (aVar != null) {
                    aVar.hnadst(jElapsedRealtime);
                }
                break;
            case 13:
                if (aVar != null) {
                    aVar.hnadss(jElapsedRealtime);
                }
                break;
            case 14:
                if (aVar != null) {
                    aVar.hnadsl(jElapsedRealtime);
                }
                break;
            case 15:
                if (aVar != null) {
                    aVar.hnadsk(jElapsedRealtime);
                }
                break;
            case 16:
                if (aVar != null) {
                    aVar.hnadsn(jElapsedRealtime);
                }
                break;
            case 17:
                if (aVar != null) {
                    aVar.hnadsm(jElapsedRealtime);
                }
                break;
            case 18:
                if (aVar != null) {
                    aVar.hnadsh(jElapsedRealtime);
                }
                break;
            case 19:
                if (aVar != null) {
                    aVar.hnadsg(jElapsedRealtime);
                }
                break;
            case 20:
                if (aVar != null) {
                    aVar.hnadsc(jElapsedRealtime);
                }
                break;
            case 21:
                if (aVar != null) {
                    aVar.hnadsd(jElapsedRealtime);
                }
                break;
        }
    }

    public void hnadsb(String str, String str2, String str3, int i, int i2, int i3) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "reportForMediation enter.clientReqId: " + str2, new Object[0]);
        com.hihonor.adsdk.base.net.o.a aVarHnadsa = hnadsa().hnadsa(str2);
        if (aVarHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "requestCostTime is null.", new Object[0]);
        } else {
            new c0(str, com.hihonor.adsdk.base.g.j.g.b.hnadsa(str2, str3, i, i2, "-1", "mediation"), aVarHnadsa.h(), aVarHnadsa.hnadsp() - aVarHnadsa.hnadso(), aVarHnadsa.hnadsf(), aVarHnadsa.hnadsr(), aVarHnadsa.g(), aVarHnadsa.hnadsh(), aVarHnadsa.hnadsx(), aVarHnadsa.hnadsu(), aVarHnadsa.d(), aVarHnadsa.a(), aVarHnadsa.hnadsk(), aVarHnadsa.hnadsc()).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsd, String.valueOf(i3)).hnadse();
        }
    }

    public com.hihonor.adsdk.base.net.o.a hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsb, (Object) ("getCostTime clientReqId: " + str));
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.hnadsa.get(str);
    }

    public void hnadsa(String str, String str2, String str3, int i, int i2, int i3) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "report enter.clientReqId: " + str2, new Object[0]);
        com.hihonor.adsdk.base.net.o.a aVarHnadsa = hnadsa().hnadsa(str2);
        if (aVarHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "requestCostTime is null.", new Object[0]);
        } else {
            new c0(str, com.hihonor.adsdk.base.g.j.g.b.hnadsa(str2, str3, i, i2, AdnConfig.b.hnadsa, AdnConfig.a.hnadsa), aVarHnadsa.h(), aVarHnadsa.hnadsg(), aVarHnadsa.hnadsf(), aVarHnadsa.hnadsr(), aVarHnadsa.g(), aVarHnadsa.hnadsh(), aVarHnadsa.hnadsx(), aVarHnadsa.hnadsu(), aVarHnadsa.d(), aVarHnadsa.a(), aVarHnadsa.hnadsk(), aVarHnadsa.hnadsc()).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsd, String.valueOf(i3)).hnadse();
        }
    }
}

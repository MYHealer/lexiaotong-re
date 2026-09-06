package com.hihonor.adsdk.base.g.j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.download.q;
import com.hihonor.adsdk.base.g.j.d.b0;
import com.hihonor.adsdk.base.g.j.d.r0;
import com.hihonor.adsdk.base.init.HnAdConfig;
import com.hihonor.adsdk.base.init.HnCustomController;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.common.f.i;
import com.hihonor.adsdk.common.f.t;
import com.hihonor.hianalytics.process.HiAnalyticsConfig;
import com.hihonor.hianalytics.process.HiAnalyticsInstance;
import com.hihonor.hianalytics.v2.HiAnalytics;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsq = "HiAnalyticsConfig";
    private static final String hnadsr = "HONOR_AD_SDK_SERVICE";
    private HiAnalyticsInstance.Builder hnadsl;
    private volatile HiAnalyticsInstance hnadsm;
    public String hnadsa = "";
    public String hnadsb = "";
    public String hnadsc = "";
    public String hnadsd = "";
    public String hnadse = "";
    public String hnadsf = "";
    public String hnadsg = "";
    public String hnadsh = "";
    private final int hnadsi = 150;
    private final int hnadsj = 100;
    private final String hnadsk = "com.hihonor.adsdk";
    private List<c> hnadsn = new ArrayList(150);
    private int hnadso = 0;
    private volatile boolean hnadsp = false;

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.g.j.a$a, reason: collision with other inner class name */
    private static class C0434a {
        private static final a hnadsa = new a();

        private C0434a() {
        }
    }

    public static a hnadsa() {
        return C0434a.hnadsa;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    private static void hnadse() {
        ?? IsCanGetAllPackages;
        ?? r2;
        HnCustomController customController;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "reportPermission enter.", new Object[0]);
        HnAdConfig cfg = HnAds.get().getCfg();
        if (cfg == null || (customController = cfg.getCustomController()) == null) {
            IsCanGetAllPackages = -1;
            r2 = -1;
        } else {
            boolean zIsCanUseLocation = customController.isCanUseLocation();
            IsCanGetAllPackages = customController.isCanGetAllPackages();
            r2 = zIsCanUseLocation;
        }
        com.hihonor.adsdk.base.init.b.C0440b c0440bHnadsf = com.hihonor.adsdk.base.init.b.hnadsc().hnadsf();
        new r0(r2, IsCanGetAllPackages, c0440bHnadsf != null ? c0440bHnadsf.hnadsb() : -1).hnadse();
    }

    private void hnadsh() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "tryInitReport isReportPermission=" + this.hnadsp, new Object[0]);
        if (!this.hnadsp) {
            this.hnadsp = true;
            hnadse();
        }
        boolean zHnadsa = i.hnadsa(t.hnadsc().hnadsa(com.hihonor.adsdk.base.c.x1.hnadsa, 0L));
        boolean zHnadsa2 = com.hihonor.adsdk.base.j.i.hnadsa();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "tryInitReport isReportInstalledToday=" + zHnadsa + "  isCanGetAllPackages=" + zHnadsa2, new Object[0]);
        if (zHnadsa || !zHnadsa2) {
            return;
        }
        new b0(hnadsb(), "", com.hihonor.adsdk.base.g.j.g.b.hnadsb()).hnadse();
        t.hnadsc().hnadsb(com.hihonor.adsdk.base.c.x1.hnadsa, System.currentTimeMillis());
    }

    public synchronized void hnadsb(Context context) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "do init.", new Object[0]);
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, " Ha init but Context is null!!!", new Object[0]);
            return;
        }
        if (hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, " Ha init is true.", new Object[0]);
            return;
        }
        this.hnadsa = Build.MODEL;
        this.hnadsb = j.hnadsg();
        this.hnadsc = j.hnadsi();
        this.hnadsd = j.hnadsa();
        this.hnadse = context.getPackageName();
        this.hnadsf = com.hihonor.adsdk.base.j.b.hnadsg(context);
        this.hnadsg = com.hihonor.adsdk.base.j.b.hnadsh(context);
        this.hnadsh = String.valueOf(hnadsa(context));
        String string = context.getResources().getString(R.string.ads_ha_url);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsq, (Object) ("ads_ha_url=" + string));
        hnadsb(string);
    }

    public boolean hnadsc() {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsq, (Object) (" isInit " + (this.hnadsm != null)));
        return this.hnadsm != null;
    }

    public synchronized void hnadsf() {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsq, (Object) "reportToTemp sta.");
        if (this.hnadsn.isEmpty()) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsq, (Object) "reportTemp tempReportList isEmpty");
        } else {
            for (int i = 0; i < this.hnadsn.size(); i++) {
                c cVar = this.hnadsn.get(i);
                if (cVar == null || cVar.hnadsc().isEmpty()) {
                    com.hihonor.adsdk.common.b.b.hnadsa(hnadsq, (Object) "reportToTemp but  tempBean isNull, or tempBean.getTempReportList().isEmpty()");
                } else {
                    if (cVar.hnadsa() == 0) {
                        HiAnalytics.onEvent(0, cVar.hnadsb(), cVar.hnadsc());
                    }
                    HiAnalytics.onEvent(1, cVar.hnadsb(), cVar.hnadsc());
                    com.hihonor.adsdk.common.b.b.hnadsa(hnadsq, "reportToTemp dataFilter=%s ,eventId=%s, reportChannel=%s, mapValue=%s", Integer.valueOf(cVar.hnadsc().size()), cVar.hnadsb(), Integer.valueOf(cVar.hnadsa()), cVar.hnadsc());
                }
            }
            this.hnadsn.clear();
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsq, (Object) "reportToTemp end.");
    }

    public synchronized void hnadsg() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "refresh oaid : " + hnadsc(), new Object[0]);
        if (this.hnadsm != null) {
            this.hnadsm.setHonorOAID(0, com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb());
            this.hnadsm.setHonorOAID(1, com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb());
        }
    }

    private int hnadsa(Context context) {
        return q.hnadsa(context) ? 1 : 0;
    }

    public void hnadsd() {
        if (this.hnadsm != null) {
            this.hnadsm.onReport(0);
            this.hnadsm.onReport(1);
        }
    }

    private synchronized void hnadsa(String str) {
        if (this.hnadsm != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "once again createHiAnalytics is succeed : " + hnadsc(), new Object[0]);
            return;
        }
        if (this.hnadsl == null) {
            this.hnadsl = new HiAnalyticsInstance.Builder(hnadsb());
        }
        this.hnadsl.setOperConf(new HiAnalyticsConfig.Builder().setCollectURL(str).setHonorOAID(com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb()).setAutoReportThreshold(100).build()).setMaintConf(new HiAnalyticsConfig.Builder().setCollectURL(str).setHonorOAID(com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb()).setAutoReportThreshold(100).build()).setAppId("com.hihonor.adsdk");
        this.hnadsm = this.hnadsl.create(hnadsr);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "createHiAnalytics is succeed : " + hnadsc(), new Object[0]);
    }

    public void hnadsc(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.hnadsm != null) {
            this.hnadsm.onEvent(0, str, linkedHashMap);
        }
    }

    private Context hnadsb() {
        return HnAds.get().getContext();
    }

    private void hnadsb(String str) {
        if (TextUtils.isEmpty(str)) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsq, "initHa url isNullOrEmpty!!", new Object[0]);
            return;
        }
        hnadsa(str);
        hnadsf();
        hnadsh();
    }

    public void hnadsa(String str, LinkedHashMap<String, String> linkedHashMap) {
        hnadsc(str, linkedHashMap);
        hnadsb(str, linkedHashMap);
    }

    public synchronized void hnadsa(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.hnadsn == null) {
            this.hnadsn = new ArrayList(150);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, " Ha onEventTemp but tempIdList is null!!!", new Object[0]);
        }
        c cVar = new c();
        cVar.hnadsa(str);
        cVar.hnadsa(linkedHashMap);
        cVar.hnadsa(i);
        if (this.hnadsn.size() >= 150) {
            this.hnadsn.set(this.hnadso, cVar);
            this.hnadso = (this.hnadso + 1) % 150;
        } else {
            this.hnadsn.add(cVar);
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsq, (Object) ("onEventTemp tempReportList.size():----tempIdList.size():" + this.hnadsn.size()));
    }

    public void hnadsb(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.hnadsm != null) {
            this.hnadsm.onEvent(1, str, linkedHashMap);
        }
    }
}

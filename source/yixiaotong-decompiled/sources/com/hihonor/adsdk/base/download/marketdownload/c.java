package com.hihonor.adsdk.base.download.marketdownload;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.api.e;
import com.hihonor.adsdk.base.bean.DetailPageCtrl;
import com.hihonor.adsdk.base.download.d;
import com.hihonor.adsdk.base.download.g;
import com.hihonor.adsdk.base.g.j.d.i;
import com.hihonor.adsdk.base.g.j.d.j;
import com.hihonor.adsdk.base.g.k.c.f;
import com.hihonor.adsdk.base.g.k.c.p;
import com.hihonor.adsdk.base.init.HnAdConfig;
import com.hihonor.adsdk.common.f.q;
import com.hihonor.adsdk.common.f.z;
import com.hihonor.dlinstall.DownloadInstallClient;
import com.hihonor.dlinstall.DownloadInstallTask;
import com.hihonor.dlinstall.ability.syncapp.AdAppReport;
import com.hihonor.dlinstall.report.DlInstallReportConfig;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String hnadsc = "MarketDownLoadManager";
    private static volatile c hnadsd;
    private final int hnadsa = -1;
    private final long hnadsb = 1000;

    private int hnadsb(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getStoreChannel storeChannel = %s", str);
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return q.hnadsd(str, true);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "getStoreChannel, exception = " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public static c hnadsa() {
        if (hnadsd == null) {
            synchronized (c.class) {
                if (hnadsd == null) {
                    hnadsd = new c();
                }
            }
        }
        return hnadsd;
    }

    public DownloadInstallTask hnadsa(Context context, g gVar, int i, boolean z) {
        if (gVar != null && context != null) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            hnadsa(linkedHashMap);
            List<String> listHnadsa = hnadsa(gVar.hnadsh(), linkedHashMap);
            hnadsa(i, gVar.hnadss(), linkedHashMap);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getDownloadInstallTask params size = %d, scene = %d", Integer.valueOf(linkedHashMap.size()), Integer.valueOf(i));
            List<String> listHnadsa2 = hnadsa(gVar.hnadsn(), linkedHashMap);
            List<String> listHnadsa3 = hnadsa(gVar.hnadso(), linkedHashMap);
            List<String> listHnadsa4 = hnadsa(gVar.hnadst(), linkedHashMap);
            List<String> listHnadsa5 = hnadsa(gVar.hnadsj(), linkedHashMap);
            return hnadsa(context, gVar, new DlInstallReportConfig.Builder().addDownloadStartReportUrl(listHnadsa2).addDownloadSuccessReportUrl(listHnadsa3).addDownloadFailReportUrl(listHnadsa5).addInstallStartReportUrl(listHnadsa5).addInstallSuccessReportUrl(listHnadsa4).addInstallFailReportUrl(listHnadsa5).addCommonsReportUrl(listHnadsa5).addClickReportUrl(listHnadsa).build(), z).build();
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getDownloadInstallTask adDIInfo is null or context is null", new Object[0]);
        return null;
    }

    public boolean hnadsb() {
        long serviceVersion;
        Context context = HnAds.get().getContext();
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getServiceVersion context is null", new Object[0]);
            return true;
        }
        try {
            serviceVersion = DownloadInstallClient.getServiceVersion(context);
            try {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getServiceVersion serviceVersion = %d", Long.valueOf(serviceVersion));
            } catch (Exception e) {
                e = e;
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "getServiceVersion error msg = " + e.getMessage(), new Object[0]);
            }
        } catch (Exception e2) {
            e = e2;
            serviceVersion = 0;
        }
        return serviceVersion < 11;
    }

    private DownloadInstallTask.Builder hnadsa(Context context, g gVar, DlInstallReportConfig dlInstallReportConfig, boolean z) {
        int iHnadsb = hnadsb(gVar.l());
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getDownloadInstallTask storeChannel = %d, subChannel = %s, packageName = %s", Integer.valueOf(iHnadsb), gVar.m(), gVar.hnadsd());
        DownloadInstallTask.Builder builderNewTaskBuilder = DownloadInstallClient.newTaskBuilder(context, gVar.hnadsd());
        builderNewTaskBuilder.setChannel(iHnadsb).setWifiRequired(!hnadsb()).setReportConfig(dlInstallReportConfig).setAdAppReport(hnadsa(gVar)).setSubChannel(gVar.m()).setUseDialogTip(true).setReferrer(gVar.hnadsg() == null ? "" : gVar.hnadsg());
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getDownloadInstallTask status = %s", Integer.valueOf(gVar.k()));
        if (gVar.k() == -1 || gVar.k() == 2008) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis / 1000;
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getDownloadInstallTask currentTimeMillis = %s, currentTimeSecond = %s", Long.valueOf(jCurrentTimeMillis), Long.valueOf(j));
            builderNewTaskBuilder.setClickTime(Long.valueOf(j));
        }
        DetailPageCtrl detailPageCtrlHnadsl = gVar.hnadsl();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getDownloadInstallTask detailPageCtrl: " + detailPageCtrlHnadsl, new Object[0]);
        if (z && detailPageCtrlHnadsl != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getDownloadInstallTask detailPageCtrl partner = %s, ts = %s, detailType = %d, downloadType = %d", detailPageCtrlHnadsl.getPartner(), detailPageCtrlHnadsl.getTs(), Integer.valueOf(detailPageCtrlHnadsl.getDetailType()), Integer.valueOf(detailPageCtrlHnadsl.getDownloadType()));
            int detailType = detailPageCtrlHnadsl.getDetailType();
            if (detailType != 0 && detailType != 1) {
                builderNewTaskBuilder.setPartner(detailPageCtrlHnadsl.getPartner() == null ? "" : detailPageCtrlHnadsl.getPartner()).setAuthSign(detailPageCtrlHnadsl.getSign() == null ? "" : detailPageCtrlHnadsl.getSign()).setTs(detailPageCtrlHnadsl.getTs() != null ? detailPageCtrlHnadsl.getTs() : "").setDetailType(detailPageCtrlHnadsl.getDetailType()).setDownloadType(detailPageCtrlHnadsl.getDownloadType());
            }
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getDownloadInstallTask download partner = %s, ts = %s", gVar.b(), Long.valueOf(gVar.p()));
            builderNewTaskBuilder.setPartner(gVar.b()).setAuthSign(gVar.j()).setTs(String.valueOf(gVar.p()));
        }
        return builderNewTaskBuilder;
    }

    private void hnadsa(LinkedHashMap<String, String> linkedHashMap) {
        String strHnadsb = com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb();
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.c.hnadsk, strHnadsb);
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.c.hnadsl, com.hihonor.adsdk.base.j.b.hnadsc(strHnadsb.getBytes(StandardCharsets.UTF_8)));
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.c.hnadss, com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsh);
    }

    private void hnadsa(int i, int i2, LinkedHashMap<String, String> linkedHashMap) {
        String strHnadsa;
        try {
            strHnadsa = z.hnadsa(new JSONObject().put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd, i).put("installType", i2).toString());
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "setSuccessExt, Set ext exception., Exception: " + e.getMessage(), new Object[0]);
            strHnadsa = "";
        }
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.c.hnadsp, strHnadsa);
    }

    private String hnadsa(String str, LinkedHashMap<String, String> linkedHashMap) {
        for (String str2 : linkedHashMap.keySet()) {
            String str3 = linkedHashMap.get(str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            str = str.replace(str2, Uri.encode(str3));
        }
        return str;
    }

    private List<String> hnadsa(List<String> list, LinkedHashMap<String, String> linkedHashMap) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(hnadsa(it.next(), linkedHashMap));
        }
        return arrayList;
    }

    private AdAppReport hnadsa(g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "getAdAppReport", new Object[0]);
        AdAppReport adAppReport = new AdAppReport();
        adAppReport.setAdId(gVar.hnadsa());
        adAppReport.setAdType(String.valueOf(gVar.hnadsb()));
        adAppReport.setAdUnitId(gVar.hnadsc());
        adAppReport.setChannelInfo(gVar.hnadsg());
        adAppReport.setExtraJson(gVar.hnadsq());
        adAppReport.setAdRequestId(gVar.g());
        HnAdConfig cfg = HnAds.get().getCfg();
        if (cfg != null && !TextUtils.isEmpty(cfg.getAppId())) {
            adAppReport.setMediaId(cfg.getAppId());
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsc, (Object) ("getAdAppReport adAppReport = " + adAppReport));
        return adAppReport;
    }

    private void hnadsa(boolean z, BaseAd baseAd, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "reportOpenMarketDetailPage", new Object[0]);
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "reportOpenMarketDetailPage , but ad is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
        if (z) {
            new j(baseAd, baseAd.getAdUnitId(), aVarHnadsa, baseAd.getSequence(), 1).hnadsa(com.hihonor.adsdk.base.g.j.e.a.C0, String.valueOf(baseAd.getLandingPageType())).hnadsa(com.hihonor.adsdk.base.g.j.e.a.D0, String.valueOf(baseAd.getNewLandingPageType())).hnadsa(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(i)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.g1, String.valueOf(hnadsa(baseAd.getDetailPageCtrl()))).hnadse();
            new com.hihonor.adsdk.base.g.k.c.g(1, 0).hnadsa(baseAd, baseAd.getTrackUrl().getDpSuccess());
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.b bVar = new com.hihonor.adsdk.base.g.j.d.h1.b();
        bVar.hnadsc(String.valueOf(baseAd.getSequence()));
        bVar.hnadsb(String.valueOf(1));
        bVar.hnadse(baseAd.getDeeplinkUrl());
        bVar.hnadsd(String.valueOf(baseAd.getLandingPageType()));
        bVar.hnadsf(String.valueOf(baseAd.getNewLandingPageType()));
        new i(baseAd.getAdUnitId(), aVarHnadsa, bVar, ErrorCode.AD_WEB_MARKET_ERROR, ErrorCode.STR_AD_WEB_MARKET_ERROR).hnadsa(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(baseAd.getItemPosition())).hnadsa(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(i)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.g1, String.valueOf(hnadsa(baseAd.getDetailPageCtrl()))).hnadse();
        new f(ErrorCode.AD_WEB_MARKET_ERROR, ErrorCode.STR_AD_WEB_MARKET_ERROR, 1, 0).hnadsa(baseAd, baseAd.getTrackUrl().getCommons());
    }

    private int hnadsa(DetailPageCtrl detailPageCtrl) {
        if (detailPageCtrl == null) {
            return 2;
        }
        return detailPageCtrl.getDetailType();
    }

    public boolean hnadsa(BaseAd baseAd, Activity activity, int i) {
        boolean zHnadsa;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "openMarketDetailPage", new Object[0]);
        if (activity != null && baseAd != null) {
            DownloadInstallTask downloadInstallTaskHnadsa = hnadsa((Context) activity, com.hihonor.adsdk.base.download.f.hnadsa(baseAd).hnadsa(), 0, true);
            if (downloadInstallTaskHnadsa == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "openMarketDetailPage downloadInstallTask is null", new Object[0]);
                return false;
            }
            DetailPageCtrl detailPageCtrl = baseAd.getDetailPageCtrl();
            if (detailPageCtrl == null) {
                zHnadsa = hnadsa(activity, downloadInstallTaskHnadsa);
            } else {
                int detailType = detailPageCtrl.getDetailType();
                if (detailType != 0 && detailType != 1) {
                    zHnadsa = hnadsa(activity, downloadInstallTaskHnadsa);
                } else {
                    zHnadsa = hnadsa(activity, downloadInstallTaskHnadsa, detailPageCtrl.getDetailType(), 2);
                }
            }
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "openMarketDetailPage isOpenDetailPageSuccess = %s", Boolean.valueOf(zHnadsa));
            hnadsa(zHnadsa, baseAd, i);
            if (zHnadsa) {
                e.hnadsa().hnadsa(baseAd.getAppPackage());
            }
            return zHnadsa;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "openMarketDetailPage context is null or ad is null", new Object[0]);
        return false;
    }

    private boolean hnadsa(Activity activity, DownloadInstallTask downloadInstallTask) {
        if (activity != null && downloadInstallTask != null) {
            return DownloadInstallClient.openDetailPage(activity, downloadInstallTask);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "openDistributionStationsDetailPage context is null or downloadInstallTask is null", new Object[0]);
        return false;
    }

    private boolean hnadsa(Activity activity, DownloadInstallTask downloadInstallTask, int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "openNoDistributionStationsDetailPage detailType = %d, screenType = %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (activity != null && downloadInstallTask != null) {
            return DownloadInstallClient.openDetailPage(activity, downloadInstallTask, i, i2);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "openNoDistributionStationsDetailPage context is null or downloadInstallTask is null", new Object[0]);
        return false;
    }

    public void hnadsa(boolean z, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "reportOpenTrafficDownloadPage isOpenTrafficDownloadPage = %b", Boolean.valueOf(z));
        g gVarHnadsa = hnadsa(str);
        if (gVarHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "reportOpenTrafficDownloadPage adDIInfo is null", new Object[0]);
        } else if (z) {
            new com.hihonor.adsdk.base.g.j.d.g1.c(com.hihonor.adsdk.base.g.j.g.c.hnadsa(gVarHnadsa), gVarHnadsa.h(), String.valueOf(1), gVarHnadsa.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(gVarHnadsa)).hnadse();
            new p(gVarHnadsa.h()).hnadsc(gVarHnadsa.hnadsa(), gVarHnadsa.hnadsc(), gVarHnadsa.g(), gVarHnadsa.hnadsj());
        }
    }

    public g hnadsa(String str) {
        com.hihonor.adsdk.base.download.f fVarHnadsa = d.hnadsa().hnadsa(str);
        if (fVarHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "onOpenApp adDIHandler is null", new Object[0]);
            return null;
        }
        return fVarHnadsa.hnadsa();
    }
}

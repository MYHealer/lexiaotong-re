package com.hihonor.adsdk.base.download;

import android.net.Uri;
import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.z;
import com.hihonor.updater.installsdk.api.AppStatusCallback;
import com.hihonor.updater.installsdk.api.AppStatusInfo;
import com.hihonor.updater.installsdk.api.DIInfo;
import com.hihonor.updater.installsdk.api.DownloadInstallClient;
import com.hihonor.updater.installsdk.api.DownloadInstallListener;
import com.hihonor.updater.installsdk.api.ResultCallback;
import com.hihonor.updater.installsdk.api.TraceUrlData;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j implements com.hihonor.adsdk.base.download.c {
    private static final String hnadsg = "ChinaDownloadClient";
    private static final String hnadsh = "com.hihonor.servicecenter";
    private static final int hnadsi = 4207;
    private static final int hnadsj = 3001;
    private static final int hnadsk = 3103;
    private static final int hnadsl = 3104;
    private com.hihonor.adsdk.base.download.e hnadsa;
    private String hnadsb = "";
    private int hnadsc = -1;
    private final String hnadsd = "channelInfo";
    private final String hnadse = "extraJson";
    private final DownloadInstallListener hnadsf = new a();

    class a implements DownloadInstallListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hnadsa() {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onServiceShutdown", new Object[0]);
            if (j.this.hnadsa != null) {
                j.this.hnadsa.hnadsa(0);
            }
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onAppUninstalled(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onAppUninstalled: " + appStatusInfo.getPackageName(), new Object[0]);
            j.this.hnadsa(dIInfo, appStatusInfo);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onDownloadInstallCancel(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onDownloadInstallCancel: " + appStatusInfo.getPackageName(), new Object[0]);
            j.this.hnadsa(dIInfo, appStatusInfo);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onDownloadPause(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onDownloadPause: " + appStatusInfo.getPackageName(), new Object[0]);
            j.this.hnadsa(dIInfo, appStatusInfo);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onDownloadProgress(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onDownloadProgress: " + appStatusInfo.getPackageName(), new Object[0]);
            j.this.hnadsa(dIInfo, appStatusInfo);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onDownloadStart(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onDownloadStart: " + appStatusInfo.getPackageName(), new Object[0]);
            j.this.hnadsa(dIInfo, appStatusInfo);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onDownloadSuccess(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onDownloadSuccess: " + appStatusInfo.getPackageName(), new Object[0]);
            j.this.hnadsa(dIInfo, appStatusInfo);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onDownloadWaiting(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onDownloadWaiting: " + appStatusInfo.getPackageName(), new Object[0]);
            j.this.hnadsa(dIInfo, appStatusInfo);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onInstallStart(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onInstallStart: " + appStatusInfo.getPackageName(), new Object[0]);
            j.this.hnadsa(dIInfo, appStatusInfo);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onInstallSuccess(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onInstallSuccess: " + appStatusInfo.getPackageName(), new Object[0]);
            j.this.hnadsa(dIInfo, appStatusInfo);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onServiceConnected() {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onServiceConnected", new Object[0]);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onServiceShutdown() {
            a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.j$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa();
                }
            });
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onDownloadFail(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onDownloadFail:packageName = %s, code = %d, message = %s", appStatusInfo.getPackageName(), Integer.valueOf(appStatusInfo.getCode()), appStatusInfo.getMessage());
            j.this.hnadsa(dIInfo, appStatusInfo);
        }

        @Override // com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onInstallFail(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "===onInstallFail: packageName = %s, code = %d, message = %s", appStatusInfo.getPackageName(), Integer.valueOf(appStatusInfo.getCode()), appStatusInfo.getMessage());
            j.this.hnadsa(dIInfo, appStatusInfo);
        }
    }

    class b implements ResultCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hnadsa(String str, int i) {
            j.this.hnadsb = str;
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "checkCallSupport code:" + i + " msg: " + str, new Object[0]);
            if (j.this.hnadsa != null) {
                j.this.hnadsc = i;
                j.this.hnadsa.hnadsa(i == 0, i, str, 0);
            }
        }

        @Override // com.hihonor.updater.installsdk.api.ResultCallback
        public void onCall(final int i, final String str) {
            a0.hnadsh(new Runnable() { // from class: com.hihonor.adsdk.base.download.j$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(str, i);
                }
            });
        }
    }

    class c implements ResultCallback {
        final /* synthetic */ com.hihonor.adsdk.base.download.g hnadsa;

        c(com.hihonor.adsdk.base.download.g gVar) {
            this.hnadsa = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hnadsa(int i, String str, com.hihonor.adsdk.base.download.g gVar) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "startDownload code= " + i + "  msg=" + str, new Object[0]);
            if (i == 0 || j.this.hnadsa == null) {
                return;
            }
            j.this.hnadsa.hnadsc(gVar.hnadsd(), i, str);
        }

        @Override // com.hihonor.updater.installsdk.api.ResultCallback
        public void onCall(final int i, final String str) {
            final com.hihonor.adsdk.base.download.g gVar = this.hnadsa;
            a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.j$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(i, str, gVar);
                }
            });
        }
    }

    class d implements ResultCallback {
        final /* synthetic */ com.hihonor.adsdk.base.download.g hnadsa;

        d(com.hihonor.adsdk.base.download.g gVar) {
            this.hnadsa = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hnadsa(int i, String str, com.hihonor.adsdk.base.download.g gVar) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "startInstall code= " + i + "  msg=" + str, new Object[0]);
            if (i == 0 || j.this.hnadsa == null) {
                return;
            }
            j.this.hnadsa.hnadsd(gVar.hnadsd(), i, str);
        }

        @Override // com.hihonor.updater.installsdk.api.ResultCallback
        public void onCall(final int i, final String str) {
            final com.hihonor.adsdk.base.download.g gVar = this.hnadsa;
            a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.j$d$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(i, str, gVar);
                }
            });
        }
    }

    class e implements ResultCallback {
        final /* synthetic */ com.hihonor.adsdk.base.download.g hnadsa;

        e(com.hihonor.adsdk.base.download.g gVar) {
            this.hnadsa = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hnadsa(int i, String str, com.hihonor.adsdk.base.download.g gVar) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "pause dIResultCode= " + i + "  msg=" + str, new Object[0]);
            if (i == 0 || j.this.hnadsa == null) {
                return;
            }
            j.this.hnadsa.hnadsa(gVar.hnadsd(), i, str);
        }

        @Override // com.hihonor.updater.installsdk.api.ResultCallback
        public void onCall(final int i, final String str) {
            final com.hihonor.adsdk.base.download.g gVar = this.hnadsa;
            a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.j$e$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(i, str, gVar);
                }
            });
        }
    }

    class f implements ResultCallback {
        final /* synthetic */ com.hihonor.adsdk.base.download.g hnadsa;

        f(com.hihonor.adsdk.base.download.g gVar) {
            this.hnadsa = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hnadsa(int i, String str, com.hihonor.adsdk.base.download.g gVar) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "cancelDownload code= " + i + "  msg=" + str, new Object[0]);
            if (i == 0 || j.this.hnadsa == null) {
                return;
            }
            j.this.hnadsa.hnadsb(gVar.hnadsd(), i, str);
        }

        @Override // com.hihonor.updater.installsdk.api.ResultCallback
        public void onCall(final int i, final String str) {
            final com.hihonor.adsdk.base.download.g gVar = this.hnadsa;
            a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.j$f$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(i, str, gVar);
                }
            });
        }
    }

    class g implements AppStatusCallback {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hnadsa(int i, List list) {
            com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "=================onStatusLoaded dIResultCode=" + i + " list=" + (list == null ? 0 : list.size()), new Object[0]);
            if (list == null) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AppStatusInfo appStatusInfo = (AppStatusInfo) it.next();
                com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "onStatusLoaded,status = %d", Integer.valueOf(appStatusInfo.getStatus()));
                if (j.this.hnadsa == null) {
                    com.hihonor.adsdk.common.b.b.hnadsc(j.hnadsg, "onStatusLoaded,listener is null", new Object[0]);
                } else {
                    if (i != 0) {
                        j.this.hnadsa.hnadse(appStatusInfo.getPackageName(), i, "");
                        return;
                    }
                    j.this.hnadsa.hnadsa(appStatusInfo.getPackageName(), j.this.hnadsa(appStatusInfo));
                }
            }
        }

        @Override // com.hihonor.updater.installsdk.api.AppStatusCallback
        public void onStatusLoaded(final int i, final List<AppStatusInfo> list) {
            a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.j$g$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(i, list);
                }
            });
        }
    }

    @Override // com.hihonor.adsdk.base.download.c
    public String hnadsb() {
        return this.hnadsb;
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsb(com.hihonor.adsdk.base.download.g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "cancelDownload", new Object[0]);
        DownloadInstallClient.cancel(HnAds.get().getContext(), hnadsa(gVar, false), new f(gVar));
    }

    @Override // com.hihonor.adsdk.base.download.c
    public boolean hnadsc() {
        boolean zCheckVersionSupport = DownloadInstallClient.checkVersionSupport(HnAds.get().getContext());
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "old versionSupport: " + zCheckVersionSupport, new Object[0]);
        int i = this.hnadsc;
        if (i > 0) {
            zCheckVersionSupport = (i == 3001 || i == 3103 || i == 3104) ? false : true;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "new versionSupport: " + zCheckVersionSupport + " initTag=" + this.hnadsc, new Object[0]);
        return zCheckVersionSupport;
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsd(com.hihonor.adsdk.base.download.g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "pause", new Object[0]);
        DownloadInstallClient.pause(HnAds.get().getContext(), hnadsa(gVar, false), new e(gVar));
    }

    @Override // com.hihonor.adsdk.base.download.c
    public boolean hnadsd() {
        return this.hnadsc == 0;
    }

    @Override // com.hihonor.adsdk.base.download.c
    public int hnadse() {
        return this.hnadsc;
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsf() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "unRegisterListener", new Object[0]);
        DownloadInstallClient.unRegisterListener(this.hnadsf);
    }

    private String hnadse(com.hihonor.adsdk.base.download.g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "getExtra", new Object[0]);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channelInfo", gVar.hnadsg());
            jSONObject.put("extraJson", gVar.hnadsq());
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "getExtra jsonObject = " + jSONObject, new Object[0]);
            return jSONObject.toString();
        } catch (JSONException e2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "getExtra errorMessage = " + e2.getMessage(), new Object[0]);
            return "";
        }
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsb(List<com.hihonor.adsdk.base.download.g> list) {
        if (list != null && !list.isEmpty()) {
            for (com.hihonor.adsdk.base.download.g gVar : list) {
                if (gVar.d() == 2) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "changeAllAppStatus is HONOR_MARKET continue, appPackage: " + gVar.hnadsd() + ",status: " + gVar.k(), new Object[0]);
                } else {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "ChinaDownloadClient changeAllAppStatus," + gVar.hnadsd() + ",status: " + gVar.k(), new Object[0]);
                    int iK = gVar.k();
                    if (iK == 2003 || iK == 2004 || iK == 2009) {
                        gVar.hnadsn(2007);
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "ChinaDownloadClient changeAllAppStatus change status,package: %s", gVar.hnadsd());
                        gVar.hnadsb(30032);
                        hnadsa(gVar.hnadsd(), "", gVar, HnAds.get().getContext().getPackageName());
                    } else if (iK != 2011) {
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "changeAllAppStatus status no match", new Object[0]);
                    } else {
                        gVar.hnadsn(2013);
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "ChinaDownloadClient changeAllAppStatus change status,package: %s", gVar.hnadsd());
                        gVar.hnadsb(30032);
                        hnadsa(gVar.hnadsd(), "", gVar, HnAds.get().getContext().getPackageName());
                    }
                }
            }
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "changeAllAppStatus,downloadInfoList is empty", new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsa(com.hihonor.adsdk.base.download.e eVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "init", new Object[0]);
        this.hnadsa = eVar;
        DownloadInstallClient.checkCallSupport(HnAds.get().getContext(), new b());
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsc(com.hihonor.adsdk.base.download.g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "startDownload", new Object[0]);
        hnadsa(gVar, new c(gVar));
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsa() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "registerListener", new Object[0]);
        DownloadInstallClient.registerListener(this.hnadsf);
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsa(com.hihonor.adsdk.base.download.g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "startInstall", new Object[0]);
        hnadsa(gVar, new d(gVar));
    }

    private void hnadsa(com.hihonor.adsdk.base.download.g gVar, ResultCallback resultCallback) {
        DownloadInstallClient.start(HnAds.get().getContext(), hnadsa(gVar, true), resultCallback);
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsa(List<com.hihonor.adsdk.base.download.g> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "getAppStatus", new Object[0]);
        if (list.isEmpty()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "getAppStatus,invalid list", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.hihonor.adsdk.base.download.g> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().hnadsd());
        }
        DownloadInstallClient.getAppStatus(HnAds.get().getContext(), arrayList, new g());
    }

    private DIInfo hnadsa(com.hihonor.adsdk.base.download.g gVar, boolean z) {
        TraceUrlData traceUrlData = new TraceUrlData();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        hnadsa(linkedHashMap);
        hnadsb(gVar.h(), gVar.hnadss(), linkedHashMap);
        hnadsa(traceUrlData, TraceUrlData.UrlType.DOWNLOAD_START, gVar.hnadsn(), linkedHashMap);
        hnadsa(traceUrlData, "downloadSuccess", gVar.hnadso(), linkedHashMap);
        hnadsa(traceUrlData, "installSuccess", gVar.hnadst(), linkedHashMap);
        linkedHashMap.clear();
        hnadsa(linkedHashMap);
        hnadsa(traceUrlData, gVar.h(), 2, TraceUrlData.UrlType.DOWNLOAD_FAIL, gVar.hnadsj(), linkedHashMap);
        hnadsa(traceUrlData, gVar.h(), 3, TraceUrlData.UrlType.INSTALL_FAIL, gVar.hnadsj(), linkedHashMap);
        linkedHashMap.clear();
        return new DIInfo.Builder(gVar.hnadsd()).setDownloadUrl(gVar.a()).setAppName(gVar.hnadsf()).setSdkUser(hnadsh).setShowAgreement(z).setSupportMobileNet(gVar.r()).setSign(gVar.c()).setTraceID(gVar.g()).setTraceUrlData(traceUrlData).setExtra(hnadse(gVar)).build();
    }

    public void hnadsb(int i, int i2, LinkedHashMap<String, String> linkedHashMap) {
        String strHnadsa;
        try {
            strHnadsa = z.hnadsa(new JSONObject().put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd, i).put("installType", i2).toString());
        } catch (JSONException e2) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsg, "setSuccessExt, Set ext exception, Exception: " + e2.getMessage(), new Object[0]);
            strHnadsa = "";
        }
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.c.hnadsp, strHnadsa);
    }

    private void hnadsa(TraceUrlData traceUrlData, String str, List<String> list, LinkedHashMap<String, String> linkedHashMap) {
        if (list != null && list.size() >= 1) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                traceUrlData.addReportUrl(str, hnadsa(it.next(), linkedHashMap));
            }
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "setTrackUrl,but trackUrls is empty", new Object[0]);
    }

    private void hnadsa(TraceUrlData traceUrlData, int i, int i2, String str, List<String> list, LinkedHashMap<String, String> linkedHashMap) {
        if (list != null && list.size() >= 1) {
            hnadsa(i, i2, linkedHashMap);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                traceUrlData.addReportUrl(str, hnadsa(it.next(), linkedHashMap));
            }
            linkedHashMap.clear();
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "setTrackUrlFail,but trackUrls is empty", new Object[0]);
    }

    protected void hnadsa(LinkedHashMap<String, String> linkedHashMap) {
        String strHnadsb = com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb();
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.c.hnadsk, strHnadsb);
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.c.hnadsl, com.hihonor.adsdk.base.j.b.hnadsc(strHnadsb.getBytes(StandardCharsets.UTF_8)));
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.c.hnadss, com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsh);
    }

    public void hnadsa(int i, int i2, LinkedHashMap<String, String> linkedHashMap) {
        String strHnadsa;
        try {
            strHnadsa = z.hnadsa(new JSONObject().put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd, i).toString());
        } catch (JSONException e2) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsg, "setFailAction, Set ext exception, Exception: " + e2.getMessage(), new Object[0]);
            strHnadsa = "";
        }
        linkedHashMap.put(com.hihonor.adsdk.base.g.j.e.c.hnadsp, strHnadsa);
        linkedHashMap.put("__ACTION__", i2 + "");
    }

    protected String hnadsa(String str, LinkedHashMap<String, String> linkedHashMap) {
        for (String str2 : linkedHashMap.keySet()) {
            String str3 = linkedHashMap.get(str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            str = str.replace(str2, Uri.encode(str3));
        }
        return str;
    }

    private void hnadsa(String str, String str2, com.hihonor.adsdk.base.download.g gVar, String str3) {
        com.hihonor.adsdk.base.download.e eVar;
        if (gVar == null || (eVar = this.hnadsa) == null) {
            return;
        }
        eVar.hnadsa(str, str2, gVar, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.hihonor.adsdk.base.download.g hnadsa(AppStatusInfo appStatusInfo) {
        com.hihonor.adsdk.base.download.g gVar = new com.hihonor.adsdk.base.download.g();
        hnadsa(gVar, appStatusInfo);
        gVar.hnadsk(appStatusInfo.getProgress());
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsa(final DIInfo dIInfo, final AppStatusInfo appStatusInfo) {
        a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.j$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsa(appStatusInfo, dIInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(AppStatusInfo appStatusInfo, DIInfo dIInfo) {
        String sdkUser;
        String process;
        com.hihonor.adsdk.base.download.g gVarHnadsa = hnadsa(appStatusInfo);
        if (dIInfo != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "updateAppStatus,process: " + dIInfo.getProcess() + ",sdkUser: " + dIInfo.getSdkUser(), new Object[0]);
            sdkUser = dIInfo.getSdkUser();
            process = dIInfo.getProcess();
        } else {
            sdkUser = null;
            process = null;
        }
        hnadsa(appStatusInfo.getPackageName(), sdkUser, gVarHnadsa, process);
    }

    private void hnadsa(com.hihonor.adsdk.base.download.g gVar, AppStatusInfo appStatusInfo) {
        gVar.hnadsb(appStatusInfo.getCode());
        gVar.hnadsh(appStatusInfo.getMessage());
        int status = appStatusInfo.getStatus();
        int i = -1;
        if (status != -1) {
            switch (status) {
                case 2002:
                    i = 2002;
                    break;
                case 2003:
                    i = 2003;
                    break;
                case 2004:
                    i = 2004;
                    break;
                case 2005:
                    i = 2005;
                    break;
                case 2006:
                    i = 2006;
                    break;
                case 2007:
                    if (appStatusInfo.getCode() == hnadsi) {
                        gVar.hnadsb(30034);
                    }
                    i = 2007;
                    break;
                case 2008:
                    i = 2008;
                    break;
                case 2009:
                    i = 2009;
                    break;
                default:
                    switch (status) {
                        case 2011:
                            i = 2011;
                            break;
                        case 2012:
                            i = 2012;
                            break;
                        case 2013:
                            i = 2013;
                            break;
                    }
                    break;
            }
        }
        gVar.hnadsn(i);
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsa(String str, final m mVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        DownloadInstallClient.getAppStatus(HnAds.get().getContext(), arrayList, new AppStatusCallback() { // from class: com.hihonor.adsdk.base.download.j$$ExternalSyntheticLambda0
            @Override // com.hihonor.updater.installsdk.api.AppStatusCallback
            public final void onStatusLoaded(int i, List list) {
                j.hnadsa(mVar, i, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsa(m mVar, int i, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AppStatusInfo appStatusInfo = (AppStatusInfo) it.next();
            if (mVar != null) {
                mVar.hnadsa(appStatusInfo.getPackageName(), appStatusInfo.getStatus());
            }
        }
    }
}

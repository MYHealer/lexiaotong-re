package com.hihonor.adsdk.base.download;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import com.hihonor.adsdk.base.g.j.d.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d implements b, e {
    private static final String hnadsf = "AdDownloadManager";
    private static final String hnadsg = "package";
    private final ConcurrentHashMap<String, f> hnadsa = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, c> hnadsb = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, l> hnadsc = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, OnDownloadStatusChangedListener> hnadsd = new ConcurrentHashMap<>();
    private AppInstallReceiver hnadse;

    private static class a {
        private static final d hnadsa = new d();

        private a() {
        }
    }

    public static d hnadsa() {
        return a.hnadsa;
    }

    private void hnadsf(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "initDownloadClient pkgType = " + i, new Object[0]);
        c cVarHnadsa = this.hnadsb.get(Integer.valueOf(i));
        if (cVarHnadsa == null && (cVarHnadsa = i.hnadsa().hnadsa(i)) != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "initDownloadClient,register listener", new Object[0]);
            cVarHnadsa.hnadsa();
            this.hnadsb.put(Integer.valueOf(i), cVarHnadsa);
        }
        if (cVarHnadsa != null) {
            cVarHnadsa.hnadsa(this);
        }
    }

    @Override // com.hihonor.adsdk.base.download.b
    public boolean hnadsb(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "checkVersionSupportAndInitResult,pkgType: " + i, new Object[0]);
        c cVarHnadsa = hnadsa(i, "checkVersionSupport,client is null");
        return cVarHnadsa != null && cVarHnadsa.hnadsc();
    }

    public void hnadsc() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "initRegisterReceiver enter", new Object[0]);
        hnadsd();
    }

    @Override // com.hihonor.adsdk.base.download.b
    public void hnadsd(g gVar) {
        int iD = gVar.d();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "pause, pkgType:" + iD, new Object[0]);
        if (hnadsc(iD)) {
            l lVarHnadsd = hnadsd(iD);
            hnadsa(gVar.hnadsd(), lVarHnadsd.hnadsa(), lVarHnadsd.hnadsb());
        } else {
            c cVar = this.hnadsb.get(Integer.valueOf(iD));
            if (cVar != null) {
                cVar.hnadsd(gVar);
            }
        }
    }

    public void hnadse(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "init pkgType：" + i, new Object[0]);
        hnadsf(i);
    }

    private c hnadsa(int i, String str) {
        c cVar = this.hnadsb.get(Integer.valueOf(i));
        if (cVar != null) {
            return cVar;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, str, new Object[0]);
        hnadse(i);
        return this.hnadsb.get(Integer.valueOf(i));
    }

    private boolean hnadsc(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "checkClientIsNullOrUnInit pkgType：" + i, new Object[0]);
        c cVarHnadsa = hnadsa(i, "checkClientIsNullOrUnInit,client is null");
        l lVarHnadsd = hnadsd(i);
        if (cVarHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "isClientUnLegal,client is null", new Object[0]);
            if (lVarHnadsd != null) {
                lVarHnadsd.hnadsa(30031);
                lVarHnadsd.hnadsa("client is null.");
                this.hnadsc.put(Integer.valueOf(i), lVarHnadsd);
            }
            return true;
        }
        lVarHnadsd.hnadsa(cVarHnadsa.hnadsd());
        lVarHnadsd.hnadsa(cVarHnadsa.hnadse());
        lVarHnadsd.hnadsa(cVarHnadsa.hnadsb());
        if (lVarHnadsd.hnadsc() || !cVarHnadsa.hnadsc() || lVarHnadsd.hnadsa() == 3103) {
            return false;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "isClientUnLegal,non hasInitSuccess", new Object[0]);
        hnadse(i);
        return true;
    }

    @Override // com.hihonor.adsdk.base.download.e
    public void hnadse(String str, int i, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onGetAppStatusFail appPackage:" + str + ",code = " + i + ",msg=" + str2, new Object[0]);
        f fVarHnadsa = hnadsa(str);
        if (fVarHnadsa != null) {
            fVarHnadsa.hnadsb(i, str2);
        }
    }

    @Override // com.hihonor.adsdk.base.download.b
    public void hnadsb(g gVar) {
        int iD = gVar.d();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "cancel, pkgType:" + iD, new Object[0]);
        if (hnadsc(iD)) {
            l lVarHnadsd = hnadsd(iD);
            hnadsb(gVar.hnadsd(), lVarHnadsd.hnadsa(), lVarHnadsd.hnadsb());
        } else {
            c cVar = this.hnadsb.get(Integer.valueOf(iD));
            if (cVar != null) {
                cVar.hnadsb(gVar);
            }
        }
    }

    @Override // com.hihonor.adsdk.base.download.b
    public void hnadsa(g gVar) {
        int iD = gVar.d();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startInstall, pkgType:" + iD, new Object[0]);
        c cVar = this.hnadsb.get(Integer.valueOf(iD));
        if (hnadsc(iD)) {
            if ((cVar instanceof j) && cVar.hnadse() == 3102) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startInstall after not agreed", new Object[0]);
                cVar.hnadsa(gVar);
                return;
            } else {
                l lVarHnadsd = hnadsd(iD);
                hnadsd(gVar.hnadsd(), lVarHnadsd.hnadsa(), lVarHnadsd.hnadsb());
                return;
            }
        }
        c cVar2 = this.hnadsb.get(Integer.valueOf(iD));
        if (cVar2 != null) {
            cVar2.hnadsa(gVar);
        }
    }

    @Override // com.hihonor.adsdk.base.download.e
    public void hnadsd(String str, int i, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onStartInstallFail appPackage:" + str + ",code = " + i + ",msg=" + str2, new Object[0]);
        k.hnadsa().hnadsa(str);
        f fVarHnadsa = hnadsa(str);
        if (fVarHnadsa != null) {
            fVarHnadsa.hnadse(i, str2);
        }
    }

    public void hnadsb(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "removeDownloadListener() appPackageName =" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hnadsd.remove(str);
    }

    private void hnadsd() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "registerReceiver, receiver is null: " + (this.hnadse == null), new Object[0]);
        if (this.hnadse == null) {
            this.hnadse = new AppInstallReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
            intentFilter.addDataScheme("package");
            try {
                HnAds.get().getContext().registerReceiver(this.hnadse, intentFilter);
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsf, "registerReceiver fail msg = " + e.getMessage(), new Object[0]);
            }
        }
    }

    private void hnadsb(String str, g gVar) {
        if (!TextUtils.isEmpty(str) && gVar != null) {
            OnDownloadStatusChangedListener onDownloadStatusChangedListener = this.hnadsd.get(str);
            if (onDownloadStatusChangedListener != null) {
                onDownloadStatusChangedListener.onStatusChanged(gVar.k());
                return;
            }
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "notifyDownloadListener() appPackage or adDIInfo is null", new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.download.b
    public void hnadsa(List<g> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getAppStatus enter", new Object[0]);
        for (g gVar : list) {
            int iD = gVar.d();
            c cVarHnadsa = hnadsa(iD, "getAppStatus,client is null,return");
            if (hnadsc(iD)) {
                l lVarHnadsd = hnadsd(iD);
                hnadse(gVar.hnadsd(), lVarHnadsd.hnadsa(), lVarHnadsd.hnadsb());
                return;
            } else if (cVarHnadsa != null) {
                cVarHnadsa.hnadsa(list);
            }
        }
    }

    @Override // com.hihonor.adsdk.base.download.b
    public void hnadsc(g gVar) {
        int iD = gVar.d();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startDownload, pkgType:" + iD, new Object[0]);
        c cVarHnadsa = hnadsa(iD, "startDownload,client is null,return");
        if (!hnadsc(iD)) {
            if (cVarHnadsa != null) {
                cVarHnadsa.hnadsc(gVar);
            }
        } else if ((cVarHnadsa instanceof j) && cVarHnadsa.hnadse() == 3102) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startDownload after not agreed", new Object[0]);
            cVarHnadsa.hnadsc(gVar);
        } else {
            l lVarHnadsd = hnadsd(iD);
            hnadsc(gVar.hnadsd(), lVarHnadsd.hnadsa(), lVarHnadsd.hnadsb());
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startDownload onStartDownloadFail", new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.base.download.e
    public void hnadsb(String str, int i, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onCancelFail appPackage:" + str + ",code = " + i + ",msg=" + str2, new Object[0]);
        f fVarHnadsa = hnadsa(str);
        if (fVarHnadsa != null) {
            fVarHnadsa.hnadsa(i, str2);
        }
    }

    public l hnadsd(int i) {
        l lVar = this.hnadsc.get(Integer.valueOf(i));
        return lVar == null ? new l() : lVar;
    }

    private List<g> hnadsb() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, f>> it = this.hnadsa.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue().hnadsa());
        }
        return arrayList;
    }

    public void hnadsa(String str, OnDownloadStatusChangedListener onDownloadStatusChangedListener) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "addDownloadListener() appPackageName =" + str + "listener= " + onDownloadStatusChangedListener, new Object[0]);
        if (TextUtils.isEmpty(str) || onDownloadStatusChangedListener == null) {
            return;
        }
        this.hnadsd.put(str, onDownloadStatusChangedListener);
    }

    @Override // com.hihonor.adsdk.base.download.e
    public void hnadsa(String str, String str2, g gVar, String str3) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onStatusChange appPackage = " + str, new Object[0]);
        k.hnadsa().hnadsb(str, gVar.k());
        hnadsc(str, gVar);
        hnadsa(str, gVar, str2);
        f fVarHnadsa = hnadsa(str);
        if (fVarHnadsa != null) {
            fVarHnadsa.hnadsa(gVar, str3);
        }
        hnadsb(str, gVar);
    }

    private void hnadsc(String str, g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onStatusChange", new Object[0]);
        if (gVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "no adDIInfo", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "adDIInfo.getStatus(): " + gVar.k() + "adDIInfo.getStatus()：" + gVar.e(), new Object[0]);
        int iK = gVar.k();
        if (iK == 2003) {
            com.hihonor.adsdk.base.api.e.hnadsa().hnadsb(str, 2);
        } else if (iK == 2005) {
            com.hihonor.adsdk.base.api.e.hnadsa().hnadsb(str, 3);
        } else {
            if (iK != 2012) {
                return;
            }
            com.hihonor.adsdk.base.api.e.hnadsa().hnadsb(str, 4);
        }
    }

    private void hnadsa(String str, g gVar, String str2) {
        com.hihonor.adsdk.base.dialog.a.hnadsc().hnadsa(str, gVar);
        if (gVar.k() == 2012) {
            com.hihonor.adsdk.base.dialog.a.hnadsc().hnadsa(str, str2);
        }
    }

    @Override // com.hihonor.adsdk.base.download.e
    public void hnadsa(String str, g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onGetAppStatus " + gVar.k(), new Object[0]);
        f fVarHnadsa = hnadsa(str);
        if (fVarHnadsa != null) {
            fVarHnadsa.hnadsa(gVar);
        }
    }

    @Override // com.hihonor.adsdk.base.download.e
    public void hnadsa(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "changeAllAppStatus pkgType:" + i, new Object[0]);
        c cVarHnadsa = hnadsa(i, "changeAllAppStatus,client is null,return");
        List<g> listHnadsb = hnadsb();
        if (cVarHnadsa != null) {
            cVarHnadsa.hnadsb(listHnadsb);
        }
    }

    @Override // com.hihonor.adsdk.base.download.e
    public void hnadsa(String str, int i, m mVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "queryAppStatus pkgType:" + i, new Object[0]);
        c cVarHnadsa = hnadsa(i, "queryAppStatus,client is null,return");
        if (cVarHnadsa != null) {
            cVarHnadsa.hnadsa(str, mVar);
        }
    }

    @Override // com.hihonor.adsdk.base.download.e
    public void hnadsc(String str, int i, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onStartDownloadFail appPackage:" + str + ",code = " + i + ",msg=" + str2, new Object[0]);
        k.hnadsa().hnadsa(str);
        f fVarHnadsa = hnadsa(str);
        if (fVarHnadsa != null) {
            fVarHnadsa.hnadsd(i, str2);
        }
    }

    @Override // com.hihonor.adsdk.base.download.e
    public void hnadsa(boolean z, int i, String str, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onInitResult,code = " + i + ",msg: " + str + ",pkgType: " + i2, new Object[0]);
        if (this.hnadsc.get(Integer.valueOf(i2)) == null) {
            this.hnadsc.put(Integer.valueOf(i2), new l(z, i, str));
        }
        if (!z) {
            new q0(2, String.valueOf(i), str).hnadse();
        }
        k.hnadsa().hnadsb();
    }

    public void hnadsc(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "removeHandler", new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hnadsa.remove(str);
    }

    @Override // com.hihonor.adsdk.base.download.e
    public void hnadsa(String str, int i, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onPauseFail appPackage:" + str + ",code = " + i + ",msg=" + str2, new Object[0]);
        f fVarHnadsa = hnadsa(str);
        if (fVarHnadsa != null) {
            fVarHnadsa.hnadsc(i, str2);
        }
    }

    public void hnadsa(String str, f fVar) {
        if (!TextUtils.isEmpty(str) && fVar != null) {
            com.hihonor.adsdk.base.dialog.a.hnadsc().hnadsa(str, new InstallNotifyBean(fVar.hnadsa()));
            boolean zContainsKey = this.hnadsa.containsKey(str);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "addHandler isHandlerExist: " + zContainsKey, new Object[0]);
            if (zContainsKey) {
                return;
            }
            this.hnadsa.put(str, fVar);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "addHandler appPackage or handler is null", new Object[0]);
    }

    public f hnadsa(String str) {
        if (TextUtils.isEmpty(str)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getHandler appPackage is null", new Object[0]);
            return null;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getHandler isHandlerExist: " + this.hnadsa.containsKey(str), new Object[0]);
        return this.hnadsa.get(str);
    }

    public void hnadsa(String str, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "updateAppStatusWhenInstall,packageName: " + str + ",status: " + i, new Object[0]);
        f fVarHnadsa = hnadsa(str);
        if (fVarHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "updateAppStatusWhenInstall,handler is null,return", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "updateAppStatusWhenInstall,status: " + i, new Object[0]);
        g gVarHnadsa = fVarHnadsa.hnadsa();
        if (i == gVarHnadsa.k()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "updateAppStatusWhenInstall,status is current,return", new Object[0]);
        } else {
            fVarHnadsa.hnadsb((p) null, gVarHnadsa.h());
        }
    }
}

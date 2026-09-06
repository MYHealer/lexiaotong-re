package com.hihonor.adsdk.base.download.marketdownload;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.f;
import com.hihonor.adsdk.base.download.AdDIStatus;
import com.hihonor.adsdk.base.download.d;
import com.hihonor.adsdk.base.download.e;
import com.hihonor.adsdk.base.download.g;
import com.hihonor.adsdk.base.download.m;
import com.hihonor.adsdk.base.download.n;
import com.hihonor.adsdk.base.g.j.d.h0;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.j.h;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.dlinstall.DownloadInstallBtnListener;
import com.hihonor.dlinstall.DownloadInstallClient;
import com.hihonor.dlinstall.DownloadInstallTask;
import com.hihonor.dlinstall.DownloadInstallV3Listener;
import com.hihonor.dlinstall.state.DIDownloadPausedState;
import com.hihonor.dlinstall.state.DIDownloadSuccessState;
import com.hihonor.dlinstall.state.DIDownloadingState;
import com.hihonor.dlinstall.state.DIInstallingState;
import com.hihonor.dlinstall.state.DINoneState;
import com.hihonor.dlinstall.state.DIState;
import com.hihonor.dlinstall.state.DIWaitingState;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b implements com.hihonor.adsdk.base.download.c {
    private static final String hnadsf = "MarketDownLoadDIClient";
    private static final int hnadsg = 0;
    private static final int hnadsh = 0;
    private static final String hnadsi = null;
    private static final String hnadsj = "com.hihonor.appmarket";
    private e hnadsa;
    private final int hnadsb = 0;
    private final float hnadsc = 0.0f;
    private final DownloadInstallV3Listener hnadsd = new a();
    private final DownloadInstallBtnListener hnadse = new C0430b();

    class a implements DownloadInstallV3Listener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void hnadsa() {
            if (b.this.hnadsa != null) {
                b.this.hnadsa.hnadsa(2);
            }
        }

        @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
        public void onDownloadPause(int i, String str, long j, long j2, int i2) {
            int iHnadsa = b.this.hnadsa(j2, j);
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadPause channel = %d, pkgName = %s, currSize = %d, totalSize = %d, taskType = %d, progress = %d", Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(iHnadsa));
            b.this.hnadsa(str, iHnadsa, 2007, 0, b.hnadsi);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
        public void onDownloadProgress(int i, String str, long j, long j2, float f, int i2) {
            int iHnadsa = b.this.hnadsa(j2, j);
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadProgress channel = %d, pkgName = %s, currSize = %d, totalSize = %d, speed = %f, taskType = %d, progress = %d", Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(iHnadsa));
            b.this.hnadsa(str, iHnadsa, 2004, 0, b.hnadsi);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
        public void onDownloadStart(int i, String str, long j, long j2, int i2) {
            int iHnadsa = b.this.hnadsa(j2, j);
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadStart channel = %d, pkgName = %s, currSize = %d, totalSize = %d, taskType = %d, progress = %d", Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(iHnadsa));
            b.this.hnadsa(str, iHnadsa, 2003, 0, b.hnadsi);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
        public void onDownloadWaiting(int i, String str, long j, long j2, int i2, int i3) {
            int iHnadsa = b.this.hnadsa(j2, j);
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadWaiting channel = %d, pkgName = %s, currSize = %d, totalSize = %d, state = %d, taskType = %d, progress = %d", Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iHnadsa));
            b.this.hnadsa(str, iHnadsa, 2009, 0, b.hnadsi);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallListener
        public void onInstallStart(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onInstallStart channel = %d, pkgName = %s", Integer.valueOf(i), str);
            b.this.hnadsa(str, 0, 2011, 0, b.hnadsi);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallListener
        public void onInstallSuccess(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onInstallSuccess channel = %d, pkgName = %s", Integer.valueOf(i), str);
            b.this.hnadsa(str, 0, 2012, 0, b.hnadsi);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallListener
        public void onServiceShutdown() {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onServiceShutdown", new Object[0]);
            a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.marketdownload.b$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa();
                }
            });
        }

        @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
        public void onTrafficDownload(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onTrafficDownload channel = %d, pkgName = %s", Integer.valueOf(i), str);
            Context contextHnadsb = com.hihonor.adsdk.base.a.hnadsa().hnadsb();
            if (contextHnadsb == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onTrafficDownload getResumeActivity is null", new Object[0]);
                contextHnadsb = HnAds.get().getContext();
            }
            if (contextHnadsb instanceof Activity) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onTrafficDownload context is instanceof Activity", new Object[0]);
                boolean zOpenTrafficDownloadPage = DownloadInstallClient.openTrafficDownloadPage((Activity) contextHnadsb, i, str);
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onTrafficDownload isOpenTrafficDownloadPage = %b", Boolean.valueOf(zOpenTrafficDownloadPage));
                c.hnadsa().hnadsa(zOpenTrafficDownloadPage, str);
                return;
            }
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onTrafficDownload context is not instanceof Activity", new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putInt(com.hihonor.adsdk.base.download.marketdownload.a.hnadsb, 2);
            bundle.putInt("channel", i);
            bundle.putString(com.hihonor.adsdk.base.download.marketdownload.a.hnadse, str);
            f fVarHnadsa = h.hnadsa(contextHnadsb, OpenMarketPageActivity.class, bundle);
            if (Objects.isNull(fVarHnadsa)) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onTrafficDownload resultBean is null", new Object[0]);
                return;
            }
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onTrafficDownload startActivity code:" + fVarHnadsa.hnadsa() + ",msg=" + fVarHnadsa.hnadsb(), new Object[0]);
            if (fVarHnadsa.hnadsa() != 0) {
                g gVarHnadsa = c.hnadsa().hnadsa(str);
                if (Objects.isNull(gVarHnadsa)) {
                    com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onTrafficDownload adDIInfo is null", new Object[0]);
                } else {
                    new x(gVarHnadsa.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_CODE_START_ACTIVITY_FAILED, fVarHnadsa.hnadsb()).hnadsa("code", String.valueOf(fVarHnadsa.hnadsa())).hnadse();
                }
            }
        }

        @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
        public void onDownloadFail(int i, String str, int i2, String str2, int i3) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadFail channel = %d, pkgName = %s, errorCode = %d, errorMsg = %s, taskType = %d", Integer.valueOf(i), str, Integer.valueOf(i2), str2, Integer.valueOf(i3));
            if (i2 == 111) {
                return;
            }
            if (i2 != 401) {
                b.this.hnadsa(str, 0, 2006, i2, str2);
            } else if (com.hihonor.adsdk.base.j.b.hnadsa(b.this.hnadsh(), str)) {
                b.this.hnadsa(str, 0, AdDIStatus.HAS_INSTALL_SUCCESS, i2, str2);
            } else {
                b.this.hnadsa(str, 0, 2008, i2, str2);
            }
        }

        @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
        public void onDownloadSuccess(int i, String str, int i2) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadSuccess channel = %d, pkgName = %s, taskType = %d", Integer.valueOf(i), str, Integer.valueOf(i2));
            b.this.hnadsa(str, 0, 2005, 0, b.hnadsi);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallV3Listener
        public void onFailResult(int i, String str, int i2, String str2) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onFailResult channel = %d, pkgName = %s, errorCode = %d, errorMsg = %s", Integer.valueOf(i), str, Integer.valueOf(i2), str2);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallListener
        public void onInstallFail(int i, String str, int i2, String str2) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onInstallFail channel = %d, pkgName = %s, errorCode = %d, errorMsg = %s", Integer.valueOf(i), str, Integer.valueOf(i2), str2);
            b.this.hnadsa(str, 0, 2013, i2, str2);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallListener
        public void onDownloadSuccess(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadSuccess channel = %d, pkgName = %s", Integer.valueOf(i), str);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallListener
        public void onDownloadPause(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadPause channel = %d, pkgName = %s", Integer.valueOf(i), str);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallListener
        public void onDownloadStart(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadStart channel = %d, pkgName = %s", Integer.valueOf(i), str);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallListener
        public void onDownloadWaiting(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadWaiting channel = %d, pkgName = %s", Integer.valueOf(i), str);
        }

        @Override // com.hihonor.dlinstall.DownloadInstallListener
        public void onDownloadProgress(int i, String str, long j, long j2, float f) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadProgress channel = %d, pkgName = %s, currSize = %d, totalSize = %d, speed = %f", Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f));
        }

        @Override // com.hihonor.dlinstall.DownloadInstallListener
        public void onDownloadFail(int i, String str, int i2, String str2) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onDownloadFail channel = %d, pkgName = %s, errorCode = %d, errorMsg = %s", Integer.valueOf(i), str, Integer.valueOf(i2), str2);
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.download.marketdownload.b$b, reason: collision with other inner class name */
    class C0430b implements DownloadInstallBtnListener {
        C0430b() {
        }

        @Override // com.hihonor.dlinstall.DownloadInstallBtnListener
        public void onOpenApp(String str, int i, boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onOpenApp channel = %d, pkgName = %s, isSuccess = %b", Integer.valueOf(i), str, Boolean.valueOf(z));
            if (z) {
                com.hihonor.adsdk.base.api.e.hnadsa().hnadsb(str, 5);
            }
            g gVarHnadsa = c.hnadsa().hnadsa(str);
            if (gVarHnadsa == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onOpenApp adDIInfo is null", new Object[0]);
                return;
            }
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(gVarHnadsa);
            new h0(com.hihonor.adsdk.base.g.j.g.c.hnadsa(gVarHnadsa), gVarHnadsa.i(), 0, gVarHnadsa.hnadsc(), aVarHnadsa).hnadse();
            if (z) {
                return;
            }
            new x(com.hihonor.adsdk.base.g.j.g.c.hnadsa(gVarHnadsa), ErrorCode.AD_OPEN_ERROR, ErrorCode.STR_OPEN_ACTIVITY, gVarHnadsa.hnadsc(), aVarHnadsa).hnadse();
        }

        @Override // com.hihonor.dlinstall.DownloadInstallBtnListener
        public void onClickDownloadInstallBtn(String str, int i, int i2) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onClickDownloadInstallBtn channel = %d, pkgName = %s, state = %d", Integer.valueOf(i), str, Integer.valueOf(i2));
            com.hihonor.adsdk.base.download.f fVarHnadsa = d.hnadsa().hnadsa(str);
            if (fVarHnadsa == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onClickDownloadInstallBtn adDIHandler is null", new Object[0]);
                return;
            }
            fVarHnadsa.hnadsd();
            g gVarHnadsa = fVarHnadsa.hnadsa();
            if (gVarHnadsa == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onClickDownloadInstallBtn downloadInfo is null", new Object[0]);
                return;
            }
            new com.hihonor.adsdk.base.g.j.d.f(com.hihonor.adsdk.base.g.j.g.c.hnadsa(gVarHnadsa), gVarHnadsa.i(), 6, gVarHnadsa.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(gVarHnadsa), 1).hnadse();
            new com.hihonor.adsdk.base.g.k.c.b(0, 0, 0, 0, 6, 0.0f, 1).hnadsc(gVarHnadsa.hnadsa(), gVarHnadsa.hnadsc(), gVarHnadsa.g(), gVarHnadsa.hnadsh());
            if (i2 == 0) {
                n.hnadsa().hnadsd(gVarHnadsa, 0);
                return;
            }
            if (i2 == 1) {
                n.hnadsa().hnadse(gVarHnadsa, 0);
                return;
            }
            if (i2 == 2) {
                n.hnadsa().hnadsa(gVarHnadsa, 0);
            } else if (i2 != 4) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsf, "onClickDownloadInstallBtn state default", new Object[0]);
            } else {
                n.hnadsa().hnadsb(gVarHnadsa, 0);
                n.hnadsa().hnadsc(gVarHnadsa, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsd(List list) {
        hnadsc((List<DIState>) list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadse(List list) {
        if (hnadsh() == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "context is null", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getAppStatus adDIInfo is null.", new Object[0]);
            } else {
                arrayList.add(gVar.hnadsd());
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getAppStatus packageNameList = " + arrayList, new Object[0]);
        if (arrayList.isEmpty()) {
            return;
        }
        final List<DIState> statuses = DownloadInstallClient.getStatuses(hnadsh(), arrayList);
        if (statuses != null && !statuses.isEmpty()) {
            a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.marketdownload.b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsd(statuses);
                }
            });
            return;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final g gVar2 = (g) it2.next();
            if (com.hihonor.adsdk.base.j.b.hnadsa(hnadsh(), gVar2.hnadsd())) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getAppStatus package has installed", new Object[0]);
                gVar2.hnadsn(2012);
            } else if (gVar2.k() == 2100 || gVar2.k() == 2012) {
                gVar2.hnadsn(-1);
            }
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getAppStatus state = " + gVar2.k(), new Object[0]);
            a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.marketdownload.b$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsf(gVar2);
                }
            });
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getAppStatus stateList is null or stateList is empty", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsf(g gVar) {
        hnadsa(gVar.hnadsd(), gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context hnadsh() {
        return HnAds.get().getContext();
    }

    @Override // com.hihonor.adsdk.base.download.c
    public String hnadsb() {
        return "success";
    }

    @Override // com.hihonor.adsdk.base.download.c
    public boolean hnadsc() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "checkVersionSupportAndInitResult", new Object[0]);
        try {
            if (hnadsh() != null) {
                boolean zHnadsa = com.hihonor.adsdk.base.j.b.hnadsa(hnadsh(), hnadsj);
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "checkVersionSupportAndInitResult isAppInstalled = " + zHnadsa, new Object[0]);
                if (!zHnadsa) {
                    return false;
                }
                long sdkVersion = DownloadInstallClient.getSdkVersion();
                long serviceVersion = DownloadInstallClient.getServiceVersion(hnadsh());
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "checkVersionSupportAndInitResult sdkVersion = " + sdkVersion + ", serviceVersion = " + serviceVersion, new Object[0]);
                if (serviceVersion > 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "checkVersionSupportAndInitResult, checkVersionSupportAndInitResult error, Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    @Override // com.hihonor.adsdk.base.download.c
    public boolean hnadsd() {
        return true;
    }

    @Override // com.hihonor.adsdk.base.download.c
    public int hnadse() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsi() {
        e eVar = this.hnadsa;
        if (eVar != null) {
            eVar.hnadsa(true, 0, "success", 2);
        }
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsb(g gVar) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, Constant.CASH_LOAD_CANCEL, new Object[0]);
            Context contextHnadsh = hnadsh();
            if (contextHnadsh == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "cancel context is null.", new Object[0]);
                return;
            }
            DownloadInstallTask downloadInstallTaskHnadsa = c.hnadsa().hnadsa(contextHnadsh, gVar, gVar.h(), false);
            if (downloadInstallTaskHnadsa != null) {
                downloadInstallTaskHnadsa.cancel();
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "cancel error = " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsd(g gVar) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "pause", new Object[0]);
            Context contextHnadsh = hnadsh();
            if (contextHnadsh == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "pause context is null.", new Object[0]);
                return;
            }
            DownloadInstallTask downloadInstallTaskHnadsa = c.hnadsa().hnadsa(contextHnadsh, gVar, gVar.h(), false);
            if (downloadInstallTaskHnadsa != null) {
                downloadInstallTaskHnadsa.pause();
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "pause, error = " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsf() {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "unRegisterListener", new Object[0]);
            DownloadInstallClient.unregisterListener(this.hnadsd);
            DownloadInstallClient.unregisterBtnListener(this.hnadse);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "unRegisterListener, error = " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsa(e eVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "init adDIClientResultListener = " + eVar, new Object[0]);
        this.hnadsa = eVar;
        a0.hnadsh(new Runnable() { // from class: com.hihonor.adsdk.base.download.marketdownload.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsi();
            }
        });
    }

    private void hnadsf(g gVar, DIState dIState) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDIWaitingState", new Object[0]);
        DIWaitingState dIWaitingState = (DIWaitingState) dIState;
        String pkgName = dIWaitingState.getPkgName();
        long totalSize = dIWaitingState.getTotalSize();
        long currSize = dIWaitingState.getCurrSize();
        int iHnadsa = hnadsa(totalSize, currSize);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDIWaitingState pkgName = %s, totalSize = %s, currSize = %s, progress = %d, taskType = %d, state = %d", pkgName, Long.valueOf(totalSize), Long.valueOf(currSize), Integer.valueOf(iHnadsa), Integer.valueOf(dIWaitingState.getTaskType()), Integer.valueOf(dIWaitingState.getState()));
        gVar.hnadsn(2009);
        gVar.hnadsk(iHnadsa);
        hnadsa(pkgName, gVar);
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsa() {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "registerListener", new Object[0]);
            DownloadInstallClient.registerListener(this.hnadsd);
            DownloadInstallClient.registerBtnListener(this.hnadse);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "registerListener, error = " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsa(final List<g> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getAppStatus", new Object[0]);
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.base.download.marketdownload.b$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.hnadse(list);
                        }
                    });
                    return;
                }
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "getAppStatus, Exception: " + e.getMessage(), new Object[0]);
                return;
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getAppStatus downloadInfoList is null or downloadInfoList is empty", new Object[0]);
    }

    private void hnadsd(g gVar, DIState dIState) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDIInstallingState", new Object[0]);
        String pkgName = ((DIInstallingState) dIState).getPkgName();
        gVar.hnadsn(2011);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDIInstallingState pkgName: " + pkgName, new Object[0]);
        hnadsa(pkgName, gVar);
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsb(List<g> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "changeAllAppStatus", new Object[0]);
        if (list != null && !list.isEmpty()) {
            for (g gVar : list) {
                if (gVar.d() == 0) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "changeAllAppStatus is THIRD_APP continue, appPackage: " + gVar.hnadsd() + ",status: " + gVar.k(), new Object[0]);
                } else {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "MarketDownLoadDIClient changeAllAppStatus," + gVar.hnadsd() + ",status: " + gVar.k(), new Object[0]);
                    int iK = gVar.k();
                    if (iK == 2003 || iK == 2004 || iK == 2009) {
                        gVar.hnadsn(2007);
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "MarketDownLoadDIClient changeAllAppStatus change status,package: %s", gVar.hnadsd());
                        gVar.hnadsb(ErrorCode.AD_DOWN_CODE_MARKET_CLIENT_UN_CONNECTED);
                        hnadsa(gVar.hnadsd(), "", gVar, HnAds.get().getContext().getPackageName());
                    } else if (iK != 2011) {
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "changeAllAppStatus status no match", new Object[0]);
                    } else {
                        gVar.hnadsn(2013);
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "MarketDownLoadDIClient changeAllAppStatus change status,package: %s", gVar.hnadsd());
                        gVar.hnadsb(ErrorCode.AD_DOWN_CODE_MARKET_CLIENT_UN_CONNECTED);
                        hnadsa(gVar.hnadsd(), "", gVar, HnAds.get().getContext().getPackageName());
                    }
                }
            }
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "changeAllAppStatus,downloadInfoList is empty", new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsc(g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startDownload", new Object[0]);
        hnadse(gVar);
    }

    private void hnadsc(List<DIState> list) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleAppStatus", new Object[0]);
        g gVar = new g();
        for (DIState dIState : list) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getAppStatus diState : " + dIState, new Object[0]);
            if (dIState instanceof DIDownloadPausedState) {
                hnadsa(gVar, dIState);
            }
            if (dIState instanceof DINoneState) {
                hnadse(gVar, dIState);
            }
            if (dIState instanceof DIDownloadingState) {
                hnadsc(gVar, dIState);
            }
            if (dIState instanceof DIDownloadSuccessState) {
                hnadsb(gVar, dIState);
            }
            if (dIState instanceof DIInstallingState) {
                hnadsd(gVar, dIState);
            }
            if (dIState instanceof DIWaitingState) {
                hnadsf(gVar, dIState);
            }
        }
    }

    private void hnadsc(g gVar, DIState dIState) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDIDownloadingState", new Object[0]);
        DIDownloadingState dIDownloadingState = (DIDownloadingState) dIState;
        String pkgName = dIDownloadingState.getPkgName();
        long totalSize = dIDownloadingState.getTotalSize();
        long currSize = dIDownloadingState.getCurrSize();
        float speed = dIDownloadingState.getSpeed();
        int iHnadsa = hnadsa(totalSize, currSize);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDIDownloadingState pkgName = %s, totalSize = %s, currSize = %s, speed = %s, progress = %d, taskType = %d", pkgName, Long.valueOf(totalSize), Long.valueOf(currSize), Float.valueOf(speed), Integer.valueOf(iHnadsa), Integer.valueOf(dIDownloadingState.getTaskType()));
        gVar.hnadsn(2004);
        gVar.hnadsk(iHnadsa);
        hnadsa(pkgName, gVar);
    }

    private void hnadse(g gVar, DIState dIState) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDINoneState", new Object[0]);
        String pkgName = ((DINoneState) dIState).getPkgName();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDINoneState pkgName: " + pkgName, new Object[0]);
        if (com.hihonor.adsdk.base.j.b.hnadsa(hnadsh(), pkgName)) {
            gVar.hnadsn(AdDIStatus.HAS_INSTALL_SUCCESS);
        } else {
            gVar.hnadsn(-1);
        }
        hnadsa(pkgName, gVar);
    }

    private void hnadsb(g gVar, DIState dIState) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDIDownloadSuccessState", new Object[0]);
        DIDownloadSuccessState dIDownloadSuccessState = (DIDownloadSuccessState) dIState;
        String pkgName = dIDownloadSuccessState.getPkgName();
        long totalSize = dIDownloadSuccessState.getTotalSize();
        int taskType = dIDownloadSuccessState.getTaskType();
        gVar.hnadsn(2005);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDIDownloadSuccessState pkgName = %s, totalSize = %s, taskType = %d", pkgName, Long.valueOf(totalSize), Integer.valueOf(taskType));
        hnadsa(pkgName, gVar);
    }

    private void hnadse(g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "doStartDownload", new Object[0]);
        try {
            Context contextHnadsh = hnadsh();
            if (contextHnadsh == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "doStartDownload context is null.", new Object[0]);
                return;
            }
            DownloadInstallTask downloadInstallTaskHnadsa = c.hnadsa().hnadsa(contextHnadsh, gVar, gVar.h(), false);
            if (downloadInstallTaskHnadsa != null) {
                downloadInstallTaskHnadsa.start();
                com.hihonor.adsdk.base.api.e.hnadsa().hnadsa(gVar.hnadsd());
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "doStartDownload, error = " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsa(g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startInstall", new Object[0]);
        hnadse(gVar);
    }

    @Override // com.hihonor.adsdk.base.download.c
    public void hnadsa(String str, m mVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        hnadsa(str, DownloadInstallClient.getStatuses(HnAds.get().getContext(), arrayList), mVar);
    }

    private void hnadsa(String str, List<DIState> list, m mVar) {
        if (list.isEmpty()) {
            if (mVar != null) {
                mVar.hnadsa(str, -1);
                return;
            }
            return;
        }
        for (DIState dIState : list) {
            if (dIState instanceof DINoneState) {
                if (mVar != null) {
                    mVar.hnadsa(str, -1);
                }
            } else if (dIState instanceof DIDownloadSuccessState) {
                if (mVar != null) {
                    mVar.hnadsa(str, 2005);
                }
            } else if ((dIState instanceof DIInstallingState) && mVar != null) {
                mVar.hnadsa(str, 2011);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsa(final String str, final int i, final int i2, final int i3, final String str2) {
        a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.download.marketdownload.b$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsa(i3, str2, i2, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(int i, String str, int i2, int i3, String str2) {
        g gVar = new g();
        gVar.hnadsb(i);
        gVar.hnadsh(str);
        gVar.hnadsn(i2);
        gVar.hnadsk(i3);
        if (i == 111) {
            gVar.hnadsn(AdDIStatus.HAS_INSTALL_SUCCESS);
        }
        hnadsa(str2, "", gVar, hnadsh() != null ? hnadsh().getPackageName() : "");
    }

    private void hnadsa(String str, String str2, g gVar, String str3) {
        e eVar;
        if (gVar == null || (eVar = this.hnadsa) == null) {
            return;
        }
        eVar.hnadsa(str, str2, gVar, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hnadsa(long j, long j2) {
        if (j <= 0) {
            return 0;
        }
        return (int) ((j2 * 100) / j);
    }

    private void hnadsa(g gVar, DIState dIState) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDIDownloadPausedState", new Object[0]);
        DIDownloadPausedState dIDownloadPausedState = (DIDownloadPausedState) dIState;
        String pkgName = dIDownloadPausedState.getPkgName();
        long totalSize = dIDownloadPausedState.getTotalSize();
        long currSize = dIDownloadPausedState.getCurrSize();
        int iHnadsa = hnadsa(totalSize, currSize);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "handleDIDownloadPausedState pkgName = %s, totalSize = %s, currSize = %s, progress = %d, taskType = %d", pkgName, Long.valueOf(totalSize), Long.valueOf(currSize), Integer.valueOf(iHnadsa), Integer.valueOf(dIDownloadPausedState.getTaskType()));
        gVar.hnadsn(2007);
        gVar.hnadsk(iHnadsa);
        hnadsa(pkgName, gVar);
    }

    private void hnadsa(String str, g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onGetAppStatus", new Object[0]);
        e eVar = this.hnadsa;
        if (eVar != null) {
            eVar.hnadsa(str, gVar);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "onGetAppStatus listener is null", new Object[0]);
        }
    }
}

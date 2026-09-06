package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.adsdk.base.ErrorCode;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.wrapper.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d implements NetworkMonitor.a, com.kwad.sdk.core.download.c, com.kwad.sdk.core.webview.a {
    private AdTemplate Rn;
    private boolean Ro;
    private a Rp;
    private DialogInterface.OnShowListener Rq;
    private List<KsAppDownloadListener> Rr;
    private boolean downloadPauseEnable;
    private Handler jk;
    private AdInfo mAdInfo;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public final void a(a aVar) {
        this.Rp = aVar;
    }

    public final void e(JSONObject jSONObject) {
        this.mReportExtData = jSONObject;
    }

    public final AdTemplate qt() {
        return this.Rn;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.Rq = onShowListener;
    }

    public d(AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.jk = new Handler(Looper.getMainLooper());
        this.Rr = new ArrayList();
        this.Rn = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        qm();
        this.downloadPauseEnable = com.kwad.sdk.core.response.helper.a.cO(com.kwad.sdk.core.response.helper.e.eO(this.Rn));
        ql();
        com.kwad.sdk.a.a.c.Hl().bv(this.Rn);
    }

    public final void ql() {
        com.kwad.sdk.core.download.b.Lz().a(this, this.Rn);
        if (com.kwad.sdk.core.config.e.Kc()) {
            NetworkMonitor.getInstance().a(ServiceProvider.getContext(), this, this.Rn);
        }
    }

    private void qm() {
        com.kwad.sdk.core.download.b.Lz();
        int iEy = com.kwad.sdk.core.download.b.ey(qo());
        if (iEy != 0) {
            this.mAdInfo.status = iEy;
        }
        qs();
        qr();
    }

    public final void aS(int i) {
        this.Rn.downloadSource = i;
    }

    public final int qn() {
        qs();
        if (this.mAdInfo.status == 3) {
            return 2;
        }
        return this.mAdInfo.status;
    }

    public d(AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public d(AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public d(AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public d(AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        this.mAdInfo.adConversionInfo.appDownloadUrl = str;
        this.mAdInfo.adBaseInfo.appPackageName = str2;
        this.mAdInfo.downloadId = an.md5(str);
    }

    @Override // com.kwad.sdk.core.download.c
    public final String qo() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String qp() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 1;
            qr();
            if (eVar.LD()) {
                this.mAdInfo.mStartDownloadTime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.adlog.c.co(this.Rn);
                eVar.LC();
                com.kwad.sdk.commercial.a.a.B(this.Rn);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i, int i2, int i3) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 3;
            this.mAdInfo.progress = i;
            this.mAdInfo.soFarBytes = i2;
            this.mAdInfo.totalBytes = i3;
            qr();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.downloadFilePath = str2;
            this.mAdInfo.progress = 100;
            this.mAdInfo.status = 8;
            qr();
            if (eVar.LD()) {
                eVar.LC();
                com.kwad.sdk.core.adlog.c.c(this.Rn, this.mReportExtData);
                com.kwad.sdk.commercial.a.a.k(this.Rn, SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime);
                com.kwad.sdk.core.a.IH().e(str, this.Rn);
                i.execute(new Runnable() { // from class: com.kwad.components.core.e.d.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
                    }
                });
                com.kwad.sdk.a.a.c.Hl().bx(this.Rn);
                com.kwad.sdk.a.a.c.Hl().bv(this.Rn);
                com.kwad.sdk.a.a.b.Hi().bq(this.Rn);
                ApkCacheManager.getInstance().Lm();
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            qr();
            if (eVar.LD()) {
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a(i, str2);
                com.kwad.sdk.core.adlog.c.a(this.Rn, aVar);
                com.kwad.components.core.p.a.vL().a(this.Rn, this.mAdInfo.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                eVar.LC();
                com.kwad.sdk.commercial.a.a.i(this.Rn, i, str2);
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.Ro || SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime >= this.mAdInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.aY(this.mAdInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(ServiceProvider.getContext(), this.Rn);
            this.Ro = true;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && eVar.LD()) {
                com.kwad.sdk.core.adlog.c.a(this.Rn, this.mReportExtData);
                eVar.LC();
                com.kwad.sdk.commercial.a.a.bC(this.Rn);
            }
            this.mAdInfo.status = 4;
            qr();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void c(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            Integer num = com.kwad.sdk.core.download.b.aRY.get(str);
            if (num != null && num.intValue() == 2) {
                this.Rn.downLoadType = 2;
                com.kwad.sdk.core.download.b.aRY.remove(str);
            }
            if (this.mAdInfo.status != 2 && eVar.LD()) {
                com.kwad.sdk.core.adlog.c.b(this.Rn, this.mReportExtData);
                eVar.LC();
                com.kwad.sdk.commercial.a.a.bD(this.Rn);
            }
            this.mAdInfo.status = 2;
            qr();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void d(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && eVar.LD()) {
                com.kwad.sdk.core.adlog.c.d(this.Rn, this.mReportExtData);
                eVar.LC();
                com.kwad.sdk.commercial.a.a.bE(this.Rn);
            }
            com.kwad.sdk.a.a.c.Hl().bw(this.Rn);
            com.kwad.sdk.a.a.b.Hi().br(this.Rn);
            this.mAdInfo.status = 5;
            qr();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void e(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 9;
            qr();
            if (eVar.LD()) {
                com.kwad.sdk.core.adlog.c.l(this.Rn, 2);
                eVar.LC();
                com.kwad.sdk.commercial.a.a.bG(this.Rn);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        final boolean zQq;
        this.mAdInfo.status = 12;
        qr();
        if (eVar.LD()) {
            com.kwad.sdk.core.adlog.c.e(this.Rn, this.mReportExtData);
            eVar.LC();
            com.kwad.sdk.commercial.a.a.bH(this.Rn);
            zQq = qq();
            com.kwad.sdk.a.a.c.Hl().by(this.Rn);
            com.kwad.sdk.a.a.c.Hl().bw(this.Rn);
            com.kwad.sdk.a.a.b.Hi().br(this.Rn);
            com.kwad.components.core.e.a.e.pu().aE(this.Rn);
            com.kwad.sdk.core.a.IH().dV(qo());
        } else {
            zQq = false;
        }
        i.execute(new bi() { // from class: com.kwad.components.core.e.d.d.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
    }

    @Override // com.kwad.sdk.core.download.c
    public final void f(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            qs();
            if (eVar.LD()) {
                eVar.LC();
                com.kwad.sdk.commercial.a.a.bI(this.Rn);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, Throwable th, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 11;
            qr();
            if (eVar.LD()) {
                eVar.LC();
                com.kwad.sdk.commercial.a.a.j(this.Rn, ErrorCode.d.hnadse, Log.getStackTraceString(th));
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void g(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str) && eVar.LD()) {
            eVar.LC();
            com.kwad.sdk.core.adlog.c.cp(this.Rn);
            com.kwad.sdk.commercial.a.a.bF(this.Rn);
        }
    }

    private boolean qq() {
        boolean zQw = false;
        if (Build.VERSION.SDK_INT < 29) {
            if (this.Rn.mIsFromContent && com.kwad.sdk.core.config.e.Jj()) {
                zQw = qw();
                if (zQw) {
                    com.kwad.sdk.core.adlog.c.cr(this.Rn);
                }
            } else if (!this.Rn.mIsFromContent && com.kwad.sdk.core.config.e.JQ()) {
                boolean zAA = com.kwad.components.core.m.b.aA(ServiceProvider.getContext());
                com.kwad.sdk.core.d.c.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + zAA);
                zQw = zAA ? qw() : false;
                if (zQw) {
                    com.kwad.sdk.core.adlog.c.cs(this.Rn);
                }
            }
        }
        return zQw;
    }

    private void qr() {
        this.jk.post(new bi() { // from class: com.kwad.components.core.e.d.d.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(d.this.Rr.size());
                arrayList.addAll(d.this.Rr);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        d.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KsAppDownloadListener ksAppDownloadListener) {
        int iGj = com.kwad.sdk.core.config.e.Gj();
        boolean zGi = com.kwad.sdk.core.config.e.Gi();
        com.kwad.sdk.core.d.c.d("ApkDownloadHelper", "DownloadProgressTransformUtil  go in updateDownloadProgress");
        int iA = v.a(this.mAdInfo.soFarBytes, this.mAdInfo.totalBytes, zGi, iGj);
        switch (this.mAdInfo.status) {
            case 0:
            case 5:
                ksAppDownloadListener.onIdle();
                break;
            case 1:
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onDownloadStarted();
                } else {
                    try {
                        ksAppDownloadListener.onDownloadStarted();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        return;
                    }
                }
                break;
            case 2:
            case 3:
                ksAppDownloadListener.onProgressUpdate(iA);
                break;
            case 4:
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onPaused(iA);
                }
                try {
                    if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                        ((KsApkDownloadListener) ksAppDownloadListener).onPaused(iA);
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 7:
                ksAppDownloadListener.onDownloadFailed();
                break;
            case 8:
            case 9:
                ksAppDownloadListener.onDownloadFinished();
                break;
            case 12:
                ksAppDownloadListener.onInstalled();
                break;
        }
    }

    public final void qs() {
        if (au.ax(ServiceProvider.getContext(), this.mAdInfo.adBaseInfo.appPackageName)) {
            this.mAdInfo.status = 12;
            return;
        }
        if (this.mAdInfo.status == 12) {
            this.mAdInfo.status = 0;
            this.mAdInfo.progress = 0;
        }
        if (this.mAdInfo.status == 8 || this.mAdInfo.status == 9) {
            String str = this.mAdInfo.downloadFilePath;
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                this.mAdInfo.status = 0;
                this.mAdInfo.progress = 0;
            }
        }
        if (this.mAdInfo.status == 0) {
            String strJ = com.kwad.sdk.core.download.a.J(this.mAdInfo);
            if (TextUtils.isEmpty(strJ) || !new File(strJ).exists()) {
                return;
            }
            this.mAdInfo.downloadFilePath = strJ;
            this.mAdInfo.status = 8;
        }
    }

    public final int u(com.kwad.components.core.e.d.a.C0661a c0661a) {
        int i = this.mAdInfo.status;
        if (i != 0 && i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    return qx();
                case 12:
                    return D(c0661a);
                default:
                    return 0;
            }
        }
        return x(c0661a) ? 11 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int v(com.kwad.components.core.e.d.a.C0661a c0661a) {
        this.Ro = false;
        qs();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return y(c0661a);
            case 2:
            case 3:
                if (c0661a.pW() && this.downloadPauseEnable) {
                    return qz();
                }
                return 0;
            case 4:
                return qA();
            case 8:
            case 9:
            case 11:
                return qx();
            case 10:
            default:
                return 0;
            case 12:
                return D(c0661a);
        }
    }

    public final boolean w(com.kwad.components.core.e.d.a.C0661a c0661a) {
        return this.mAdInfo.status == 0 && x(c0661a);
    }

    private boolean x(com.kwad.components.core.e.d.a.C0661a c0661a) {
        boolean zL = com.kwad.sdk.utils.f.l(c0661a.getContext(), this.Rn);
        if (zL) {
            com.kwad.sdk.core.adlog.c.o(this.Rn, 0);
        }
        return zL;
    }

    private int y(com.kwad.components.core.e.d.a.C0661a c0661a) {
        Context context = c0661a.getContext();
        if (com.kwad.sdk.utils.f.a(context, com.kwad.sdk.core.response.helper.a.dd(this.mAdInfo), this.Rn)) {
            com.kwad.sdk.core.adlog.c.o(this.Rn, 1);
            return 11;
        }
        if (x(c0661a)) {
            return 11;
        }
        if (qu()) {
            return 10;
        }
        if (!aq.isNetworkConnected(context)) {
            ae.V(context, ag.dl(context));
            return 2;
        }
        if (c0661a.qf() && com.kwad.sdk.core.config.e.JC()) {
            return z(c0661a);
        }
        if (com.kwad.sdk.core.response.helper.e.fd(this.Rn) && c0661a.qh() != 2) {
            return d(c0661a.getContext(), c0661a.getAdTemplate());
        }
        if (c0661a.qb()) {
            return A(c0661a);
        }
        if (B(c0661a)) {
            return 8;
        }
        return qy();
    }

    private int z(com.kwad.components.core.e.d.a.C0661a c0661a) {
        Context context = c0661a.getContext();
        AdTemplate adTemplate = c0661a.getAdTemplate();
        int iQg = c0661a.qg();
        if (iQg == 1) {
            return qy();
        }
        if (iQg != 2) {
            return 1;
        }
        if (!com.kwad.sdk.core.response.helper.b.dQ(adTemplate)) {
            return 8;
        }
        com.kwad.components.core.e.c.b.a(context, new com.kwad.components.core.e.c.b.a().aH(adTemplate).ao(com.kwad.sdk.core.response.helper.b.dP(adTemplate)).a(this.Rq).c(this.mOnDismissListener).pJ());
        return 8;
    }

    private int A(com.kwad.components.core.e.d.a.C0661a c0661a) {
        Context context = c0661a.getContext();
        AdTemplate adTemplate = c0661a.getAdTemplate();
        int iE = E(c0661a);
        if (iE == 1) {
            if (com.kwad.sdk.core.response.helper.b.dQ(adTemplate)) {
                com.kwad.components.core.e.c.b.a(context, new com.kwad.components.core.e.c.b.a().aH(adTemplate).ao(com.kwad.sdk.core.response.helper.b.dP(adTemplate)).a(this.Rq).c(this.mOnDismissListener).pJ());
            }
            return 8;
        }
        if (iE == 2) {
            return d(c0661a.getContext(), c0661a.getAdTemplate());
        }
        if (iE == 3) {
            return 1;
        }
        if (B(c0661a)) {
            return 8;
        }
        return qy();
    }

    private boolean B(com.kwad.components.core.e.d.a.C0661a c0661a) {
        if (c0661a.pY() || this.mAdInfo.status == 4 || !com.kwad.sdk.core.response.helper.b.dT(this.Rn) || !C(c0661a)) {
            return false;
        }
        return com.kwad.components.core.e.c.b.a(c0661a.getContext(), new com.kwad.components.core.e.c.b.a().aH(this.Rn).ao(com.kwad.sdk.core.response.helper.b.dS(this.Rn)).a(this.Rq).c(this.mOnDismissListener).pJ());
    }

    private static boolean C(com.kwad.components.core.e.d.a.C0661a c0661a) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(c0661a.getAdTemplate());
        if (com.kwad.sdk.core.response.helper.a.bC(adInfoEO) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0661a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.helper.a.bD(adInfoEO) && !aq.isWifiConnected(c0661a.getContext());
    }

    private boolean qu() {
        a aVar = this.Rp;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.e.d.d.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (i == -1) {
                        switch (d.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 5:
                            case 6:
                            case 7:
                                d.this.qy();
                                break;
                            case 4:
                                d.this.qA();
                                break;
                            case 8:
                            case 9:
                            case 11:
                                d.this.qx();
                                break;
                            case 12:
                                d.this.qv();
                                break;
                        }
                    }
                }
            });
        }
        return false;
    }

    private int D(com.kwad.components.core.e.d.a.C0661a c0661a) {
        Activity activityFromContext = m.getActivityFromContext(c0661a.getContext());
        if (activityFromContext != null && com.kwad.sdk.core.response.helper.a.W(this.mAdInfo) && !c0661a.pP() && !c0661a.pU()) {
            c0661a.aK(1);
            com.kwad.components.core.e.e.e.a(activityFromContext, c0661a);
            return 18;
        }
        return qv();
    }

    public final int qv() {
        i.execute(new bi() { // from class: com.kwad.components.core.e.d.d.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
        if (!au.az(ServiceProvider.getContext(), com.kwad.sdk.core.response.helper.a.aE(this.mAdInfo))) {
            return 6;
        }
        com.kwad.sdk.core.adlog.c.cq(this.Rn);
        return 6;
    }

    private boolean qw() {
        Context context = ServiceProvider.getContext();
        if (e.a(new com.kwad.components.core.e.d.a.C0661a(context).aJ(this.Rn), 1) == 1) {
            return true;
        }
        boolean zAz = au.az(context, com.kwad.sdk.core.response.helper.a.aE(this.mAdInfo));
        if (zAz) {
            com.kwad.sdk.core.adlog.c.cq(this.Rn);
        }
        return zAz;
    }

    public final int qx() {
        au.a(this.mAdInfo.downloadFilePath, new au.a() { // from class: com.kwad.components.core.e.d.d.6
            @Override // com.kwad.sdk.utils.au.a
            public final void qD() {
                com.kwad.sdk.core.adlog.c.l(d.this.Rn, 1);
                com.kwad.sdk.commercial.a.a.bG(d.this.Rn);
            }

            @Override // com.kwad.sdk.utils.au.a
            public final void d(Throwable th) {
                com.kwad.sdk.commercial.a.a.j(d.this.Rn, ErrorCode.d.hnadse, Log.getStackTraceString(th));
            }
        });
        return 7;
    }

    public final int qy() {
        com.kwad.sdk.core.download.a.K(this.mAdInfo);
        return 3;
    }

    public final int qz() {
        com.kwad.sdk.core.download.a.ev(this.mAdInfo.downloadId);
        return 4;
    }

    public final int qA() {
        this.Rn.downLoadType = 2;
        qy();
        return 5;
    }

    private int qB() {
        this.Rn.downLoadType = 1;
        qy();
        return 5;
    }

    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.Rr.contains(ksAppDownloadListener)) {
                this.Rr.add(0, ksAppDownloadListener);
            }
        } else {
            this.jk.post(new bi() { // from class: com.kwad.components.core.e.d.d.7
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (d.this.Rr.contains(ksAppDownloadListener)) {
                        return;
                    }
                    d.this.Rr.add(0, ksAppDownloadListener);
                }
            });
        }
        qs();
        a(ksAppDownloadListener);
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.Rr.remove(ksAppDownloadListener);
        } else {
            this.jk.post(new bi() { // from class: com.kwad.components.core.e.d.d.8
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    d.this.Rr.remove(ksAppDownloadListener);
                }
            });
        }
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        qs();
        a(ksAppDownloadListener);
    }

    public static int E(com.kwad.components.core.e.d.a.C0661a c0661a) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(c0661a.getAdTemplate());
        if (adInfoEO.downloadSafeInfo.complianceInfo == null) {
            return 0;
        }
        int iEd = c0661a.ed();
        if (iEd == 2) {
            return adInfoEO.downloadSafeInfo.complianceInfo.describeBarType;
        }
        if (iEd == 3) {
            return adInfoEO.downloadSafeInfo.complianceInfo.materialJumpType;
        }
        return adInfoEO.downloadSafeInfo.complianceInfo.actionBarType;
    }

    private static int d(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return 9;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
        return 9;
    }

    public final void clear() {
        qC();
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void qC() {
        List<KsAppDownloadListener> list = this.Rr;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            qB();
        }
    }
}

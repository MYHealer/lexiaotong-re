package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.innerEc.logger.InnerEcError;
import com.kwad.components.core.innerEc.logger.InnerEcEvent;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.wrapper.m;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    private static List<WeakReference<k.b>> QH;
    public static InnerEcEvent QI;
    public static InnerEcError QJ;

    public interface b {
        void onAdClicked();
    }

    public static int a(Context context, AdTemplate adTemplate, b bVar, d dVar, boolean z, boolean z2, boolean z3, boolean z4) {
        com.kwad.sdk.commercial.convert.a.h(adTemplate, true);
        adTemplate.converted = true;
        e.aD(false);
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        C0661a c0661aAv = new C0661a(context).aJ(adTemplate).a(bVar).b(dVar).as(z).at(z2).ap(z4).av(false);
        int iAt = com.kwad.sdk.core.response.helper.a.at(adInfoEO);
        if (!z3 && c0661aAv.qh() != 2 && c0661aAv.qh() != 1 && !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.aY(adInfoEO)) && !c0661aAv.qd()) {
            if (iAt == 1) {
                if (com.kwad.sdk.core.response.helper.a.bo(adInfoEO)) {
                    return k(c0661aAv);
                }
                return l(c0661aAv);
            }
            if (iAt == 2) {
                int iH = h(c0661aAv);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.helper.a.bo(adInfoEO)) {
                    return k(c0661aAv);
                }
                return l(c0661aAv);
            }
        }
        int iH2 = h(c0661aAv);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            if (j(c0661aAv)) {
                return 11;
            }
            return l(c0661aAv);
        }
        int iM = m(c0661aAv);
        if (adInfoEO.status != 2 && adInfoEO.status != 3) {
            e(c0661aAv);
        }
        return iM;
    }

    public static int a(C0661a c0661a) {
        Context context = c0661a.getContext();
        AdTemplate adTemplate = c0661a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        e.aD(false);
        if (c0661a.pV()) {
            return b(c0661a);
        }
        if (c0661a.qe()) {
            return a(context, adTemplate, c0661a.pR(), c0661a.iv(), c0661a.QT, c0661a.pY(), false, c0661a.pU());
        }
        com.kwad.sdk.commercial.convert.a.h(adTemplate, false);
        if (c(c0661a)) {
            f(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        boolean zAK = com.kwad.components.core.innerEc.f.aK(adTemplate);
        if (com.kwad.sdk.core.response.helper.a.dG(adInfoEO)) {
            com.kwad.components.core.innerEc.logger.a.d(adTemplate, c0661a.qk());
        }
        if (zAK && !adTemplate.hasInnerEcFailed() && !c0661a.qk()) {
            QJ = InnerEcError.createEmptyError(adTemplate);
            QI = InnerEcEvent.createEmptyEvent(adTemplate);
            e(c0661a);
            c0661a.aB(true);
            int iA = com.kwad.components.core.innerEc.f.a(context, adTemplate, c0661a);
            if (iA == 1) {
                return 14;
            }
            if (iA == 2) {
                com.kwad.components.core.innerEc.qcpx.b.h(context, adTemplate);
                if (com.kwad.sdk.core.response.helper.e.fm(adTemplate)) {
                    com.kwad.components.core.innerEc.live.b.c(com.kwad.sdk.core.c.b.LW().getApplication());
                    com.kwad.components.core.innerEc.live.b.b(context, adTemplate, c0661a);
                    return 14;
                }
                com.kwad.components.core.innerEc.f.g(context, adTemplate);
                return 14;
            }
            if (iA == 3) {
                return com.kwad.components.core.innerEc.f.G(c0661a);
            }
        }
        int iAt = com.kwad.sdk.core.response.helper.a.at(adInfoEO);
        if (c0661a.qh() != 2 && c0661a.qh() != 1 && !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.aY(adInfoEO)) && !c0661a.qd()) {
            if (iAt == 1) {
                if (com.kwad.sdk.core.response.helper.a.bo(adInfoEO)) {
                    return k(c0661a);
                }
                return l(c0661a);
            }
            if (iAt == 2) {
                int iH = h(c0661a);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.helper.a.bo(adInfoEO)) {
                    return k(c0661a);
                }
                return l(c0661a);
            }
        }
        int iH2 = h(c0661a);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        int i = i(c0661a);
        if (i == 1) {
            return 12;
        }
        if (i == 2) {
            return 17;
        }
        if (c0661a.qc() && !com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            return n(c0661a);
        }
        if (!com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            if (adTemplate.isWebViewDownload) {
                int iM = m(c0661a);
                adTemplate.isWebViewDownload = false;
                return iM;
            }
            if (j(c0661a)) {
                return 11;
            }
            return l(c0661a);
        }
        if (c0661a.qh() == 2 || c0661a.qh() == 1) {
            c0661a.av(false);
            e(c0661a);
            return m(c0661a);
        }
        if (c0661a.qc() && com.kwad.sdk.core.response.helper.a.b(adInfoEO, com.kwad.sdk.core.config.e.JJ()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.aY(adInfoEO)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
            int iU = c0661a.iv().u(c0661a);
            if (iU == 0) {
                return k(c0661a);
            }
            e(c0661a);
            f(adTemplate, iU);
            return iU;
        }
        e(c0661a);
        c0661a.av(true);
        return m(c0661a);
    }

    private static int b(C0661a c0661a) {
        Context context = c0661a.getContext();
        AdTemplate adTemplate = c0661a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        Activity activityFromContext = m.getActivityFromContext(context);
        if (activityFromContext != null && com.kwad.sdk.core.response.helper.a.Y(adInfoEO) && !c0661a.pP() && !c0661a.pU()) {
            c0661a.aK(2);
            com.kwad.components.core.e.e.e.a(activityFromContext, c0661a);
            f(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0680a().aZ(com.kwad.sdk.core.response.helper.b.dm(adTemplate)).aY(adTemplate).aR(true).ua());
        f(adTemplate, 20);
        return 20;
    }

    public static boolean c(C0661a c0661a) {
        if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(c0661a.getAdTemplate()))) {
            return !c0661a.qf() && d.E(c0661a) == 3;
        }
        return d(c0661a) == 1;
    }

    private static int d(C0661a c0661a) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(c0661a.getAdTemplate());
        if (adInfoEO.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int iEd = c0661a.ed();
        if (iEd == 2) {
            return adInfoEO.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        if (iEd == 3) {
            return adInfoEO.unDownloadConf.unDownloadRegionConf.materialJumpType;
        }
        return adInfoEO.unDownloadConf.unDownloadRegionConf.actionBarType;
    }

    private static void e(C0661a c0661a) {
        if (c0661a.pP() || c0661a.qj()) {
            return;
        }
        g(c0661a);
        f(c0661a);
        if (c0661a.pR() != null) {
            try {
                c0661a.pR().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.convert.a.bK(c0661a.getAdTemplate());
        aI(c0661a.getAdTemplate());
    }

    private static void aI(AdTemplate adTemplate) {
        AdInfo adInfoEO;
        if (adTemplate == null || (adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate)) == null) {
            return;
        }
        adInfoEO.convertCount++;
    }

    private static void f(C0661a c0661a) {
        if (c0661a.pZ()) {
            com.kwad.sdk.core.adlog.c.a(c0661a.adTemplate, c0661a.qa(), c0661a.iK());
        }
    }

    public static void a(k.b bVar) {
        if (QH == null) {
            QH = new CopyOnWriteArrayList();
        }
        QH.add(new WeakReference<>(bVar));
    }

    public static void b(k.b bVar) {
        if (QH == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= QH.size()) {
                i = -1;
                break;
            }
            WeakReference<k.b> weakReference = QH.get(i);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            QH.remove(i);
        }
    }

    private static void g(C0661a c0661a) {
        k.b bVar;
        List<WeakReference<k.b>> list = QH;
        if (list == null || list.isEmpty() || c0661a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : QH) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.Y(com.kwad.sdk.core.response.helper.e.eY(c0661a.adTemplate));
            }
        }
    }

    private static int h(C0661a c0661a) {
        AdTemplate adTemplate = c0661a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        int iA = e.a(c0661a, 1);
        if (iA == 1) {
            e.aD(true);
            e(c0661a);
            if ((com.kwad.sdk.core.response.helper.a.cX(adInfoEO) || com.kwad.sdk.core.response.helper.a.cY(adInfoEO)) && !c0661a.qi()) {
                com.kwad.sdk.core.adlog.c.q(c0661a.getAdTemplate(), (int) Math.ceil(c0661a.pX() / 1000.0f));
            }
            f(adTemplate, 13);
        } else if (iA == 2) {
            e(c0661a);
            f(adTemplate, 16);
        }
        return iA;
    }

    private static int i(C0661a c0661a) {
        Context context = c0661a.getContext();
        AdTemplate adTemplate = c0661a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(c0661a.getAdTemplate());
        Activity activityFromContext = m.getActivityFromContext(c0661a.getContext());
        if (activityFromContext != null && com.kwad.sdk.core.response.helper.a.W(adInfoEO) && !c0661a.pP() && f.G(adInfoEO) && !c0661a.pU()) {
            c0661a.aK(1);
            com.kwad.components.core.e.e.e.a(activityFromContext, c0661a);
            e(c0661a);
            f(adTemplate, 17);
            return 2;
        }
        int iE = f.e(context, adTemplate);
        if (iE == 1) {
            e(c0661a);
            f(adTemplate, 12);
        }
        return iE;
    }

    private static boolean j(C0661a c0661a) {
        AdTemplate adTemplate = c0661a.getAdTemplate();
        boolean zL = com.kwad.sdk.utils.f.l(c0661a.getContext(), adTemplate);
        if (zL) {
            e(c0661a);
            com.kwad.sdk.core.adlog.c.o(adTemplate, 0);
            f(adTemplate, 11);
        }
        return zL;
    }

    private static int k(C0661a c0661a) {
        e(c0661a);
        AdTemplate adTemplate = c0661a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(c0661a.getAdTemplate());
        Activity activityFromContext = m.getActivityFromContext(c0661a.getContext());
        if (activityFromContext != null && com.kwad.sdk.core.response.helper.a.Y(adInfoEO) && !c0661a.pP() && !c0661a.pU()) {
            c0661a.aK(2);
            com.kwad.components.core.e.e.e.a(activityFromContext, c0661a);
            f(adTemplate, 19);
            return 19;
        }
        AdWebViewVideoActivityProxy.launch(c0661a.getContext(), adTemplate);
        f(adTemplate, 15);
        return 15;
    }

    private static int l(C0661a c0661a) {
        e(c0661a);
        Context context = c0661a.getContext();
        AdTemplate adTemplate = c0661a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        Activity activityFromContext = m.getActivityFromContext(context);
        if (activityFromContext != null && com.kwad.sdk.core.response.helper.a.Y(adInfoEO) && !c0661a.pP() && !c0661a.pU()) {
            c0661a.aK(2);
            com.kwad.components.core.e.e.e.a(activityFromContext, c0661a);
            f(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0680a().aZ(com.kwad.sdk.core.response.helper.b.dm(adTemplate)).aY(adTemplate).aS(c0661a.pS()).bv(com.kwad.components.core.innerEc.f.aK(adTemplate) ? 2 : 1).ua());
        f(adTemplate, 14);
        return 14;
    }

    private static int m(C0661a c0661a) {
        d dVarIv = c0661a.iv();
        if (dVarIv == null) {
            dVarIv = new d(c0661a.adTemplate);
            c0661a.b(dVarIv);
        }
        int iV = dVarIv.v(c0661a);
        f(c0661a.getAdTemplate(), iV);
        return iV;
    }

    public static void f(AdTemplate adTemplate, int i) {
        switch (i) {
            case 0:
                com.kwad.sdk.commercial.convert.a.ca(adTemplate);
                break;
            case 1:
                com.kwad.sdk.commercial.convert.a.bP(adTemplate);
                break;
            case 2:
                com.kwad.sdk.commercial.convert.a.bZ(adTemplate);
                break;
            case 3:
                com.kwad.sdk.commercial.convert.a.bR(adTemplate);
                break;
            case 4:
                com.kwad.sdk.commercial.convert.a.bX(adTemplate);
                break;
            case 5:
                com.kwad.sdk.commercial.convert.a.bY(adTemplate);
                break;
            case 6:
                com.kwad.sdk.commercial.convert.a.bS(adTemplate);
                break;
            case 7:
                com.kwad.sdk.commercial.convert.a.bT(adTemplate);
                break;
            case 8:
                com.kwad.sdk.commercial.convert.a.bU(adTemplate);
                break;
            case 9:
                com.kwad.sdk.commercial.convert.a.bW(adTemplate);
                break;
            case 10:
                com.kwad.sdk.commercial.convert.a.bV(adTemplate);
                break;
            case 11:
                com.kwad.sdk.commercial.convert.a.bO(adTemplate);
                break;
            case 12:
                com.kwad.sdk.commercial.convert.a.bN(adTemplate);
                break;
            case 13:
                com.kwad.sdk.commercial.convert.a.bM(adTemplate);
                break;
            case 14:
                com.kwad.sdk.commercial.convert.a.bL(adTemplate);
                break;
            case 15:
                com.kwad.sdk.commercial.convert.a.bQ(adTemplate);
                break;
            case 16:
                com.kwad.sdk.commercial.convert.a.cc(adTemplate);
                break;
            case 17:
                com.kwad.sdk.commercial.convert.a.cf(adTemplate);
                break;
            case 18:
                com.kwad.sdk.commercial.convert.a.cb(adTemplate);
                break;
            case 19:
                com.kwad.sdk.commercial.convert.a.cd(adTemplate);
                break;
            case 20:
                com.kwad.sdk.commercial.convert.a.ce(adTemplate);
                break;
        }
    }

    private static int n(C0661a c0661a) {
        AdTemplate adTemplate = c0661a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (j(c0661a)) {
            return 11;
        }
        if (com.kwad.sdk.core.response.helper.a.b(adInfoEO, com.kwad.sdk.core.config.e.JJ()) && !adTemplate.mAdWebVideoPageShowing) {
            return k(c0661a);
        }
        return l(c0661a);
    }

    /* JADX INFO: renamed from: com.kwad.components.core.e.d.a$a, reason: collision with other inner class name */
    public static class C0661a {
        private boolean QK;
        private boolean QL;
        private boolean QM;
        private boolean QN;
        private boolean QO;
        private boolean QP;
        private boolean QQ;
        private b QR;
        private d QS;
        private boolean QT;
        private boolean QU;
        private long QV;
        private boolean QW;
        public String QY;
        public com.kwad.sdk.core.adlog.a.C0733a QZ;
        private JSONObject Rc;
        private boolean Re;
        private int Rf;
        private int Rg;
        private int Rh;
        private int Ri;
        private Callable<String> Rj;
        private String Rk;
        private boolean Rl;
        private boolean Rm;
        private AdTemplate adTemplate;
        private final Context context;
        private boolean needReport;
        private int nk;
        private int nm;
        public al.a no;
        public long zV;
        public int QX = -1;
        public int Ra = 0;
        public int Rb = -1;
        private boolean Rd = false;

        public final C0661a D(long j) {
            this.QV = j;
            return this;
        }

        public final C0661a E(long j) {
            this.zV = j;
            return this;
        }

        public final C0661a a(b bVar) {
            this.QR = bVar;
            return this;
        }

        public final C0661a a(Callable<String> callable) {
            this.Rj = callable;
            return this;
        }

        public final C0661a aA(boolean z) {
            this.QM = true;
            return this;
        }

        public final void aB(boolean z) {
            this.Rl = true;
        }

        public final void aC(boolean z) {
            this.Rm = true;
        }

        public final C0661a aJ(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final void aK(int i) {
            this.Rg = i;
        }

        public final C0661a aL(int i) {
            this.Ri = i;
            return this;
        }

        public final C0661a aM(int i) {
            this.nm = i;
            return this;
        }

        public final C0661a aN(int i) {
            this.nk = i;
            return this;
        }

        public final C0661a aO(int i) {
            this.Ra = i;
            return this;
        }

        public final C0661a aP(int i) {
            this.Rb = i;
            return this;
        }

        public final C0661a aQ(int i) {
            this.Rf = i;
            return this;
        }

        public final C0661a aR(int i) {
            this.Rh = i;
            return this;
        }

        public final void ao(boolean z) {
            this.QU = true;
        }

        public final C0661a ap(String str) {
            this.Rk = str;
            return this;
        }

        public final C0661a ap(boolean z) {
            this.QP = z;
            return this;
        }

        public final C0661a aq(String str) {
            this.QY = str;
            return this;
        }

        public final C0661a aq(boolean z) {
            this.QQ = true;
            return this;
        }

        public final C0661a ar(boolean z) {
            this.QO = true;
            return this;
        }

        public final C0661a as(boolean z) {
            this.QT = z;
            return this;
        }

        public final C0661a at(boolean z) {
            this.QW = z;
            return this;
        }

        public final C0661a au(boolean z) {
            this.needReport = z;
            return this;
        }

        public final C0661a av(boolean z) {
            this.Rd = z;
            return this;
        }

        public final C0661a aw(boolean z) {
            this.QL = z;
            return this;
        }

        public final C0661a ax(boolean z) {
            this.QN = true;
            return this;
        }

        public final C0661a ay(boolean z) {
            this.QK = z;
            return this;
        }

        public final C0661a az(boolean z) {
            this.Re = z;
            return this;
        }

        public final C0661a b(d dVar) {
            this.QS = dVar;
            return this;
        }

        public final C0661a d(al.a aVar) {
            this.no = aVar;
            return this;
        }

        public final C0661a d(JSONObject jSONObject) {
            this.Rc = jSONObject;
            return this;
        }

        public final int ed() {
            return this.nk;
        }

        public final int eg() {
            return this.nm;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final Context getContext() {
            return this.context;
        }

        public final JSONObject iK() {
            return this.Rc;
        }

        public final d iv() {
            return this.QS;
        }

        public final String pN() {
            return this.Rk;
        }

        public final Callable<String> pO() {
            return this.Rj;
        }

        public final boolean pP() {
            return this.QU;
        }

        public final int pQ() {
            return this.Rg;
        }

        public final b pR() {
            return this.QR;
        }

        public final boolean pS() {
            return this.QO;
        }

        public final int pT() {
            return this.Ri;
        }

        public final boolean pU() {
            return this.QP;
        }

        public final boolean pV() {
            return this.QQ;
        }

        public final boolean pW() {
            return this.QT;
        }

        public final long pX() {
            return this.QV;
        }

        public final boolean pY() {
            return this.QW;
        }

        public final boolean pZ() {
            return this.needReport;
        }

        public final boolean qb() {
            return this.Rd;
        }

        public final boolean qc() {
            return this.QL;
        }

        public final boolean qd() {
            return this.QN;
        }

        public final boolean qe() {
            return this.QK;
        }

        public final boolean qf() {
            return this.Re;
        }

        public final int qg() {
            return this.Rf;
        }

        public final int qh() {
            return this.Rh;
        }

        public final boolean qi() {
            return this.QM;
        }

        public final boolean qj() {
            return this.Rl;
        }

        public final boolean qk() {
            return this.Rm;
        }

        public C0661a(Context context) {
            this.context = context;
        }

        public final com.kwad.sdk.core.adlog.c.a qa() {
            return com.kwad.sdk.core.adlog.c.a.Jf().dW(this.nm).eb(this.QY).e(this.no).dX(this.Ra).dY(this.Rb).aA(this.zV).a(this.QZ).dZ(this.QX);
        }

        public final C0661a a(String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            if (this.QZ == null) {
                this.QZ = new com.kwad.sdk.core.adlog.a.C0733a();
            }
            this.QZ.a(this.adTemplate, null, null, null);
            return this;
        }
    }
}

package com.hihonor.adsdk.base.download;

import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.a0;
import com.hihonor.adsdk.base.g.j.d.t;
import com.hihonor.adsdk.base.g.j.d.w;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.k.c.d0;
import com.hihonor.adsdk.common.f.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f {
    private static final String hnadse = "AdDIHandler";
    private int hnadsa;
    private boolean hnadsb;
    private final g hnadsc = new g();
    private final List<p> hnadsd = Collections.synchronizedList(new ArrayList());

    public static f hnadsa(BaseAd baseAd) {
        if (Objects.isNull(baseAd)) {
            return new f();
        }
        f fVarHnadsa = d.hnadsa().hnadsa(baseAd.getAppPackage());
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "get,adDIHandler = %s, packageName = %s", fVarHnadsa, baseAd.getAppPackage());
        if (Objects.isNull(fVarHnadsa)) {
            fVarHnadsa = new f();
        }
        fVarHnadsa.hnadsc.hnadsa(baseAd);
        return fVarHnadsa;
    }

    public g hnadsa() {
        return this.hnadsc;
    }

    public void hnadsb(p pVar, int i) {
        if (!hnadsb()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getAppStatus,App package invalid", new Object[0]);
            return;
        }
        hnadsa(pVar, i);
        boolean z = this.hnadsc.hnadss() == 1;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getAppStatus,isPreInstallPkg: " + z, new Object[0]);
        if (!z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.hnadsc);
            d.hnadsa().hnadsa(arrayList);
        } else {
            boolean zHnadsa = q.hnadsa(HnAds.get().getContext(), this.hnadsc.hnadsd());
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getAppStatus,isInstall = %s", Boolean.valueOf(zHnadsa));
            if (zHnadsa) {
                this.hnadsc.hnadsn(2012);
            } else {
                this.hnadsc.hnadsn(-1);
            }
            hnadsa(this.hnadsc);
        }
    }

    public void hnadsc(p pVar, int i) {
        if (!hnadsb()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "handleCancelClick,App package invalid", new Object[0]);
            return;
        }
        int iK = this.hnadsc.k();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "handleCancelClick,app status: " + iK, new Object[0]);
        if (iK == -1 || iK == 2011 || iK == 2008) {
            return;
        }
        if (pVar != null && !this.hnadsd.contains(pVar)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "handleCancelClick,add listener", new Object[0]);
            this.hnadsd.add(pVar);
        }
        this.hnadsa = i;
        this.hnadsc.hnadsl(i);
        d.hnadsa().hnadsb(this.hnadsc);
    }

    public void hnadsd(p pVar, int i) {
        if (!hnadsb()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "handleStart,App package invalid", new Object[0]);
            return;
        }
        hnadsa(pVar, i);
        k.hnadsa().hnadsb(this.hnadsc);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "handleStart,app status: " + this.hnadsc.k(), new Object[0]);
        int iK = this.hnadsc.k();
        if (iK != -1) {
            if (iK != 2002) {
                if (iK == 2100 || iK == 2012) {
                    com.hihonor.adsdk.base.i.e.hnadsa(this.hnadsc).hnadsa(true).hnadsa().hnadsa(i).start();
                    return;
                }
                if (iK != 2013) {
                    switch (iK) {
                    }
                    return;
                }
                if (this.hnadsc.hnadss() == 1) {
                    hnadsc();
                    return;
                } else {
                    hnadse(this.hnadsc);
                    return;
                }
            }
            n.hnadsa().hnadsb(this.hnadsc, i);
            n.hnadsa().hnadsc(this.hnadsc, i);
            hnadsd(this.hnadsc);
            return;
        }
        if (this.hnadsc.hnadss() == 1) {
            n.hnadsa().hnadsf(this.hnadsc, i);
            hnadsc();
        } else {
            n.hnadsa().hnadsd(this.hnadsc, i);
            hnadsd(this.hnadsc);
        }
    }

    public void hnadse(p pVar, int i) {
        if (!hnadsb()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "handleStartOrPauseClick,App package invalid", new Object[0]);
            return;
        }
        hnadsa(pVar, i);
        k.hnadsa().hnadsb(this.hnadsc);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "handleStartOrPauseClick,app status: " + this.hnadsc.k(), new Object[0]);
        int iK = this.hnadsc.k();
        if (iK != -1) {
            if (iK == 2100 || iK == 2012) {
                com.hihonor.adsdk.base.i.e.hnadsa(this.hnadsc).hnadsa(true).hnadsa().hnadsa(i).start();
                return;
            }
            if (iK != 2013) {
                switch (iK) {
                    case 2002:
                    case 2007:
                        n.hnadsa().hnadsb(this.hnadsc, i);
                        n.hnadsa().hnadsc(this.hnadsc, i);
                        hnadsd(this.hnadsc);
                        break;
                    case 2003:
                    case 2004:
                        hnadsc(this.hnadsc);
                        n.hnadsa().hnadsa(this.hnadsc, i);
                        break;
                    case 2009:
                        if (com.hihonor.adsdk.common.f.o.hnadsd(HnAds.get().getContext()) && this.hnadsc.d() == 2) {
                            n.hnadsa().hnadse(this.hnadsc, i);
                            hnadsd(this.hnadsc);
                        } else {
                            hnadsc(this.hnadsc);
                            if (this.hnadsc.d() != 2) {
                                n.hnadsa().hnadsa(this.hnadsc, i);
                            } else {
                                n.hnadsa().hnadse(this.hnadsc, i);
                            }
                        }
                        break;
                }
                return;
            }
            if (this.hnadsc.hnadss() == 1) {
                hnadsc();
                return;
            } else {
                hnadse(this.hnadsc);
                return;
            }
        }
        if (this.hnadsc.hnadss() == 1) {
            n.hnadsa().hnadsf(this.hnadsc, i);
            hnadsc();
        } else {
            n.hnadsa().hnadsd(this.hnadsc, i);
            hnadsd(this.hnadsc);
        }
    }

    public void hnadsf(g gVar) {
        int iK = gVar.k();
        int iE = gVar.e();
        int iHnadsi = gVar.hnadsi();
        this.hnadsc.hnadsn(iK);
        this.hnadsc.hnadsk(iE);
        this.hnadsc.hnadsb(iHnadsi);
        this.hnadsc.hnadsh(gVar.hnadsx());
        this.hnadsc.hnadsi(gVar.hnadsz());
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "updateInfoAndNotifyListeners status = %d, progress = %d, code = %d, packageName = %s, listenerListSize = %d", Integer.valueOf(iK), Integer.valueOf(iE), Integer.valueOf(iHnadsi), this.hnadsc.hnadsd(), Integer.valueOf(this.hnadsd.size()));
        Iterator<p> it = this.hnadsd.iterator();
        while (it.hasNext()) {
            it.next().hnadsa(this.hnadsc);
        }
    }

    private void hnadsa(p pVar, int i) {
        this.hnadsc.hnadsa(this.hnadsb);
        d.hnadsa().hnadsa(this.hnadsc.hnadsd(), this);
        k.hnadsa().hnadsa(this.hnadsc);
        if (pVar != null && !this.hnadsd.contains(pVar)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "doSomethingBeforeCall,add listener, packageName = %s", this.hnadsc.hnadsd());
            this.hnadsd.add(pVar);
        }
        this.hnadsc.hnadsl(i);
        this.hnadsa = i;
    }

    private void hnadsc() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "recoverSysApp", new Object[0]);
        if (q.hnadsb(this.hnadsc.hnadsd())) {
            this.hnadsc.hnadsn(2012);
        } else {
            this.hnadsc.hnadsn(2013);
        }
        hnadsa(this.hnadsc, HnAds.get().getContext().getPackageName());
    }

    public void hnadsa(p pVar, int i, boolean z) {
        this.hnadsb = z;
        hnadse(pVar, i);
    }

    public void hnadsa(int i, String str) {
        Iterator<p> it = this.hnadsd.iterator();
        while (it.hasNext()) {
            it.next().hnadse(i, str);
        }
    }

    public void hnadsb(int i, String str) {
        Iterator<p> it = this.hnadsd.iterator();
        while (it.hasNext()) {
            it.next().hnadsd(i, str);
        }
    }

    public void hnadsa(g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onGetAppStatus", new Object[0]);
        gVar.hnadsi(1);
        hnadsf(gVar);
    }

    public void hnadsb(g gVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onStatusChangeByReceiver", new Object[0]);
        hnadsf(gVar);
    }

    public void hnadsa(g gVar, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onStatusChange,process: " + str, new Object[0]);
        hnadsf(gVar);
        if (HnAds.get().getContext().getPackageName().equals(str)) {
            hnadsa(this.hnadsc.k());
        }
    }

    private boolean hnadsb() {
        if (!TextUtils.isEmpty(this.hnadsc.hnadsd())) {
            return true;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "checkAdValidity ad pkgName isEmpty", new Object[0]);
        return false;
    }

    private void hnadsc(g gVar) {
        d.hnadsa().hnadsd(gVar);
    }

    public void hnadsc(int i, String str) {
        Iterator<p> it = this.hnadsd.iterator();
        while (it.hasNext()) {
            it.next().hnadsc(i, str);
        }
    }

    public void hnadsa(int i) {
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsc);
        switch (i) {
            case 2003:
                new t(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsc), this.hnadsc.i(), this.hnadsa, this.hnadsc.hnadsc(), aVarHnadsa).hnadse();
                new d0(this.hnadsa, this.hnadsc.hnadss()).hnadsc(this.hnadsc.hnadsa(), this.hnadsc.hnadsc(), this.hnadsc.g(), this.hnadsc.hnadsn());
                break;
            case 2005:
                new com.hihonor.adsdk.base.g.j.d.n(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsc), this.hnadsc.i(), this.hnadsa, this.hnadsc.hnadsc(), aVarHnadsa).hnadse();
                new com.hihonor.adsdk.base.g.k.c.h(this.hnadsa, this.hnadsc.hnadss()).hnadsc(this.hnadsc.hnadsa(), this.hnadsc.hnadsc(), this.hnadsc.g(), this.hnadsc.hnadso());
                break;
            case 2006:
                new com.hihonor.adsdk.base.g.j.d.o(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsc), this.hnadsc.i(), this.hnadsc.hnadsi(), this.hnadsc.hnadsx(), this.hnadsa, this.hnadsc.hnadsc(), aVarHnadsa).hnadse();
                new com.hihonor.adsdk.base.g.k.c.i(this.hnadsc.hnadsi(), this.hnadsc.hnadsx(), this.hnadsa).hnadsc(this.hnadsc.hnadsa(), this.hnadsc.hnadsc(), this.hnadsc.g(), this.hnadsc.hnadsj());
                break;
            case 2007:
                new com.hihonor.adsdk.base.g.j.d.q(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsc), this.hnadsc.i(), this.hnadsa, this.hnadsc.hnadsi(), this.hnadsc.hnadsc(), aVarHnadsa).hnadse();
                break;
            case 2008:
                new x(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsc), ErrorCode.AD_DOWN_LOAD_CANCEL, z.hnadsa(this.hnadsc.hnadsi(), "AD pack app down cancel, by  msg:" + this.hnadsc.hnadsx()), this.hnadsc.hnadsc(), aVarHnadsa).hnadse();
                break;
            case 2009:
                new w(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsc), this.hnadsc.i(), this.hnadsa, this.hnadsc.hnadsi(), this.hnadsc.hnadsc(), aVarHnadsa).hnadse();
                break;
            case 2012:
                com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "install success", new Object[0]);
                new com.hihonor.adsdk.base.g.j.d.z(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsc), this.hnadsc.i(), this.hnadsa, this.hnadsc.hnadss(), this.hnadsc.hnadsc(), aVarHnadsa).hnadse();
                new com.hihonor.adsdk.base.g.k.c.k(this.hnadsa, this.hnadsc.hnadss()).hnadsc(this.hnadsc.hnadsa(), this.hnadsc.hnadsc(), this.hnadsc.g(), this.hnadsc.hnadst());
                if (this.hnadsc.hnadss() == 1) {
                    com.hihonor.adsdk.base.api.e.hnadsa().hnadsb(this.hnadsc.hnadsd(), 4);
                }
                break;
            case 2013:
                if (this.hnadsc.hnadsi() == 0 && this.hnadsc.hnadss() == 1) {
                    this.hnadsc.hnadsb(ErrorCode.AD_INSTALL_FAIL);
                    this.hnadsc.hnadsh(ErrorCode.REPORT_AD_INSTALL_FAIL);
                }
                new a0(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsc), this.hnadsc.i(), this.hnadsc.hnadsi(), this.hnadsc.hnadsx(), this.hnadsa, this.hnadsc.hnadss(), this.hnadsc.hnadsc(), aVarHnadsa).hnadse();
                new com.hihonor.adsdk.base.g.k.c.l(this.hnadsc.hnadsi(), this.hnadsc.hnadsx(), this.hnadsa, this.hnadsc.hnadss()).hnadsc(this.hnadsc.hnadsa(), this.hnadsc.hnadsc(), this.hnadsc.g(), this.hnadsc.hnadsj());
                break;
        }
    }

    private void hnadsd(g gVar) {
        d.hnadsa().hnadsc(gVar);
    }

    public void hnadsd(int i, String str) {
        new com.hihonor.adsdk.base.g.j.d.o(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsc), this.hnadsc.i(), i, str, this.hnadsa, this.hnadsc.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsc)).hnadse();
        new com.hihonor.adsdk.base.g.k.c.i(i, str, this.hnadsa).hnadsc(this.hnadsc.hnadsa(), this.hnadsc.hnadsc(), this.hnadsc.g(), this.hnadsc.hnadsj());
        Iterator<p> it = this.hnadsd.iterator();
        while (it.hasNext()) {
            it.next().hnadsb(i, str);
        }
    }

    public void hnadsd() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "setSceneClickMarketDetailPageButton", new Object[0]);
        this.hnadsa = 0;
        this.hnadsc.hnadsl(0);
    }

    private void hnadse(g gVar) {
        d.hnadsa().hnadsa(gVar);
    }

    public void hnadse(int i, String str) {
        new a0(com.hihonor.adsdk.base.g.j.g.c.hnadsa(this.hnadsc), this.hnadsc.i(), i, str, this.hnadsa, this.hnadsc.hnadss(), this.hnadsc.hnadsc(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsc)).hnadse();
        new com.hihonor.adsdk.base.g.k.c.l(i, str, this.hnadsa, this.hnadsc.hnadss()).hnadsc(this.hnadsc.hnadsa(), this.hnadsc.hnadsc(), this.hnadsc.g(), this.hnadsc.hnadsj());
        Iterator<p> it = this.hnadsd.iterator();
        while (it.hasNext()) {
            it.next().hnadsa(i, str);
        }
    }

    public void hnadsa(p pVar) {
        this.hnadsd.remove(pVar);
        if (this.hnadsd.isEmpty()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "removeListener,removeHandler, packageName = %s", this.hnadsc.hnadsd());
            d.hnadsa().hnadsc(this.hnadsc.hnadsd());
        }
    }
}

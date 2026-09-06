package com.hihonor.adsdk.base.mediation.core.imp;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseExpressAd;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.k.c.t;
import com.hihonor.adsdk.base.init.i;
import com.hihonor.adsdk.base.j.g;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.hihonor.adsdk.base.mediation.core.imp.b;
import com.hihonor.adsdk.base.net.resp.AdUnitInfo;
import com.hihonor.adsdk.common.f.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class c<K extends BaseExpressAd, T extends b<K>> implements com.hihonor.adsdk.base.mediation.a.b {
    private static final String hnadsl = "BaseManager";
    protected AdSlot hnadsa;
    private List<T> hnadsd;
    private long hnadsg;
    private long hnadsh;
    private long hnadsi;
    private AdUnitInfo hnadsj;
    private String hnadsk;
    private int hnadsc = 0;
    private boolean hnadse = false;
    private Handler hnadsf = new Handler(Looper.getMainLooper());
    protected String hnadsb = UUID.randomUUID().toString();

    public c() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "init BaseManager mMediaRequestId=" + this.hnadsb, new Object[0]);
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsb, 0);
    }

    private void hnadsh() {
        long timeOutMillis = this.hnadsa.getTimeOutMillis();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "handleTimeout timeOutMillis = " + timeOutMillis, new Object[0]);
        if (timeOutMillis > 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "handleTimeout timeOutMillis is greater than 0", new Object[0]);
            Handler handler = this.hnadsf;
            if (handler == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "handleTimeout mHandler is null", new Object[0]);
            } else {
                handler.postDelayed(new Runnable() { // from class: com.hihonor.adsdk.base.mediation.core.imp.c$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.hnadsi();
                    }
                }, timeOutMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsi() {
        this.hnadsh = System.currentTimeMillis();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "handleTimeout mTimeOutCurrentTimeMillis = " + this.hnadsh, new Object[0]);
        this.hnadse = true;
        hnadsa(String.valueOf(ErrorCode.AD_LOADING_TIME_OUT), String.format("The polymerization ad media loading process exceeded the timeout period set by the developer.The expected time is less than %s ms.", Long.valueOf(this.hnadsa.getTimeOutMillis())));
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsb);
    }

    private void hnadsl() {
        this.hnadsi = SystemClock.elapsedRealtime();
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsb, 14);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "sortAndBid mStartBiddingTime = " + this.hnadsi, new Object[0]);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.hnadsd.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (-1 == next.hnadsp()) {
                arrayList.add(next);
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, " pr mInstanceList =" + this.hnadsd.size() + ", mIsTimeOut = " + this.hnadse, new Object[0]);
        this.hnadsd.removeAll(arrayList);
        if (f.hnadsa((Collection<?>) this.hnadsd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "no instance", new Object[0]);
            hnadsk();
            com.hihonor.adsdk.base.g.a.hnadsa(this.hnadsa.getSlotId(), this.hnadsb, "", ErrorCode.NO_SUCCESS_INSTANCE, ErrorCode.STR_NO_SUCCESS_INSTANCE, this.hnadsa.getDataType(), com.hihonor.adsdk.base.g.c.hnadsa(this.hnadsa));
            if (!this.hnadse) {
                hnadsa(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY), "no instance");
            }
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsb);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "mInstanceList =" + this.hnadsd.size(), new Object[0]);
        AdUnitInfo adUnitInfo = this.hnadsj;
        List<K> listHnadsa = e.hnadsa(this.hnadsd, adUnitInfo != null ? adUnitInfo.sameShow : 0, this.hnadsa, hnadsd());
        if (f.hnadsa((Collection<?>) listHnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "no ad resp", new Object[0]);
            hnadsk();
            com.hihonor.adsdk.base.g.a.hnadsa(this.hnadsa.getSlotId(), this.hnadsb, "", ErrorCode.BID_RESULT_EMPTY, ErrorCode.STR_BID_RESULT_EMPTY, this.hnadsa.getDataType(), com.hihonor.adsdk.base.g.c.hnadsa(this.hnadsa));
            if (!this.hnadse) {
                hnadsa(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY), "no ad resp");
            }
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsb);
            return;
        }
        hnadsk();
        if (this.hnadse) {
            hnadsb(listHnadsa);
        } else {
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsb, 15);
            hnadsa(listHnadsa);
            AdSlot adSlot = this.hnadsa;
            int dataType = adSlot != null ? adSlot.getDataType() : 0;
            AdSlot adSlot2 = this.hnadsa;
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsk, this.hnadsb, "", hnadsd(), dataType, adSlot2 != null ? adSlot2.getLoadType() : -1);
        }
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsb);
    }

    protected abstract void hnadsa(String str, String str2);

    protected abstract void hnadsa(List<K> list);

    public void hnadsc(List<T> list) {
        this.hnadsd = list;
    }

    public abstract int hnadsd();

    public String hnadse() {
        return this.hnadsk;
    }

    public String hnadsf() {
        return this.hnadsb;
    }

    protected com.hihonor.adsdk.base.g.j.d.c.a hnadsg() {
        return new com.hihonor.adsdk.base.g.j.d.c.a().hnadsc(this.hnadsa.getSlotId()).hnadsm(this.hnadsb).hnadsd(-1).hnadsb(hnadsd());
    }

    public void hnadsj() {
        this.hnadsg = SystemClock.elapsedRealtime();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "load mStartRequestTime = " + this.hnadsg, new Object[0]);
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsb, 1);
        hnadsh();
        if (this.hnadsd.isEmpty()) {
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsb);
        }
        Iterator<T> it = this.hnadsd.iterator();
        while (it.hasNext()) {
            it.next().hnadsa(this, this.hnadsg);
        }
    }

    public void hnadsa(AdSlot adSlot) {
        this.hnadsa = adSlot;
        AdUnitInfo adUnitInfoHnadsa = i.hnadsa(adSlot.getSlotId());
        this.hnadsj = adUnitInfoHnadsa;
        this.hnadsk = adUnitInfoHnadsa != null ? adUnitInfoHnadsa.adUnitId : "";
    }

    @Override // com.hihonor.adsdk.base.mediation.a.b
    public void hnadsb() {
        this.hnadsc++;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "handleAdLoaded size=" + this.hnadsd.size() + " isCount=" + this.hnadsc, new Object[0]);
        if (this.hnadsc == this.hnadsd.size()) {
            hnadsl();
        }
    }

    public void hnadsc() {
        hnadsk();
    }

    protected void hnadsk() {
        Handler handler = this.hnadsf;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.hnadsf = null;
        }
    }

    private void hnadsb(List<K> list) {
        TrackUrl trackUrl;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportTimeOut currentTimeMillis= " + jElapsedRealtime, new Object[0]);
        long j = jElapsedRealtime - this.hnadsi;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportTimeOut adOutTimeConsume= " + j, new Object[0]);
        String str = String.format("The polymerization ad media loading process exceeded the timeout period set by the developer.The expected time is less than %s ms. result time is %s", Long.valueOf(this.hnadsa.getTimeOutMillis()), Long.valueOf(j));
        com.hihonor.adsdk.base.g.a.hnadsa(this.hnadsa.getSlotId(), this.hnadsb, "", ErrorCode.AD_LOADING_TIME_OUT, str, this.hnadsa.getDataType(), com.hihonor.adsdk.base.g.c.hnadsa(this.hnadsa));
        if (f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportTimeOut list is null or list size is 0", new Object[0]);
            return;
        }
        for (K k : list) {
            if (k != null) {
                hnadsa(j, k);
                if ("0".equals(k.getAdnType()) && (trackUrl = k.getTrackUrl()) != null) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportAdTrackShowFail trackUrl is not null", new Object[0]);
                    new t(ErrorCode.AD_LOADING_TIME_OUT, str).hnadsc(k.getAdId(), this.hnadsa.getSlotId(), this.hnadsb, trackUrl.getCommons());
                }
            }
        }
    }

    @Override // com.hihonor.adsdk.base.mediation.a.b
    public void hnadsa() {
        this.hnadsc++;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "onAdFail size=" + this.hnadsd.size() + " isCount=" + this.hnadsc, new Object[0]);
        if (this.hnadsc == this.hnadsd.size()) {
            hnadsl();
        }
    }

    private void hnadsa(long j, K k) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportAdEventShowFailed", new Object[0]);
        com.hihonor.adsdk.base.g.j.d.c cVarHnadsa = new com.hihonor.adsdk.base.g.j.d.c.a().hnadsc(this.hnadsa.getSlotId()).hnadsm(this.hnadsb).hnadsf(hnadsa(k.getAdnType())).hnadso(k.getAppPackage()).hnadse(k.getAppVersion()).hnadsg(k.getChannelInfo()).hnadsw(k.getAdnId()).hnadsr(k.getRequestId()).hnadsd(k.getAdnType()).hnadsa(k.getAdId()).hnadsj(String.valueOf(ErrorCode.AD_LOADING_TIME_OUT)).hnadsk("media is timeout").hnadsb(hnadsd()).hnadsd(-1).hnadsd(this.hnadsa.getTimeOutMillis()).hnadsb("MEDIA").hnadsb(j).hnadsf(this.hnadsg).hnadse(this.hnadsh).hnadsy(k.getUnInstallFilter()).hnadsa();
        AdUnitInfo adUnitInfoHnadsa = i.hnadsa(this.hnadsa.getSlotId());
        if (adUnitInfoHnadsa != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportAdEventShowFailed adUnitInfo.timeout = " + adUnitInfoHnadsa.timeout, new Object[0]);
            cVarHnadsa.hnadsa(adUnitInfoHnadsa.timeout);
        }
        new s0(cVarHnadsa, cVarHnadsa.hnadsl(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVarHnadsa)).hnadse();
    }

    protected void hnadsb(String str, String str2) {
        com.hihonor.adsdk.base.g.j.d.c cVarHnadsa = hnadsg().hnadsa();
        new com.hihonor.adsdk.base.g.j.d.j1.e(cVarHnadsa, cVarHnadsa.hnadsl(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVarHnadsa), str, str2, (String) null).hnadse();
    }

    protected static String hnadsa(String str) {
        if (str.equals("0")) {
            return AdnConfig.a.hnadsa;
        }
        if (str.equals("1")) {
            return AdnConfig.a.hnadsb;
        }
        return str.equals("2") ? AdnConfig.a.hnadsc : "";
    }

    protected void hnadsa(List<K> list, boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportToMediaSuccess isOnlyOne:" + z, new Object[0]);
        if (f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "reportToMediaSuccess baseExpressAdList is empty", new Object[0]);
            return;
        }
        ArrayList<BaseExpressAd> arrayList = new ArrayList();
        if (z) {
            arrayList.add(list.get(0));
        } else {
            arrayList.addAll(list);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        for (BaseExpressAd baseExpressAd : arrayList) {
            String adnId = "";
            arrayList2.add(baseExpressAd != null ? baseExpressAd.getAdId() : "");
            arrayList3.add(baseExpressAd != null ? baseExpressAd.getAdnType() : "");
            arrayList4.add(baseExpressAd != null ? hnadsa(baseExpressAd.getAdnType()) : "");
            arrayList5.add(baseExpressAd != null ? baseExpressAd.getRequestId() : "");
            arrayList6.add(baseExpressAd != null ? baseExpressAd.getAppPackage() : "");
            if (baseExpressAd != null) {
                adnId = baseExpressAd.getAdnId();
            }
            arrayList7.add(adnId);
        }
        com.hihonor.adsdk.base.g.j.d.c cVarHnadsa = hnadsg().hnadsa(g.hnadsa(arrayList2)).hnadsd(g.hnadsa(arrayList3)).hnadsf(g.hnadsa(arrayList4)).hnadsr(g.hnadsa(arrayList5)).hnadso(g.hnadsa(arrayList6)).hnadsw(g.hnadsa(arrayList7)).hnadsa();
        new com.hihonor.adsdk.base.g.j.d.j1.f(cVarHnadsa, String.valueOf(1), cVarHnadsa.hnadsl(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVarHnadsa)).hnadse();
    }
}

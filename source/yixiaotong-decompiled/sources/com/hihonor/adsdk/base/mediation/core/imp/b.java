package com.hihonor.adsdk.base.mediation.core.imp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseExpressAd;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.k.c.t;
import com.hihonor.adsdk.base.init.i;
import com.hihonor.adsdk.base.mediation.comm.adevent.ADEvent;
import com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter;
import com.hihonor.adsdk.base.net.resp.AdUnitInfo;
import com.hihonor.adsdk.common.f.f;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.ubixnow.ooooo.o0OO000o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class b<T extends BaseExpressAd> implements com.hihonor.adsdk.base.mediation.comm.adevent.a {
    private static final String hnadsq = "BaseInstance";
    public long hnadsa;
    public long hnadsb;
    protected BaseAdapter<T> hnadsc;
    protected com.hihonor.adsdk.base.mediation.a.b hnadsd;
    protected int hnadse;
    protected List<T> hnadsg;
    protected long hnadsh;
    protected a hnadsi;
    protected String hnadsj;
    private long hnadsm;
    private long hnadso;
    private long hnadsp;
    protected Map<String, Object> hnadsf = new HashMap();
    private Handler hnadsk = new Handler(Looper.getMainLooper());
    private boolean hnadsl = false;
    private long hnadsn = 0;

    public b(a aVar) {
        aVar = aVar == null ? new a() : aVar;
        this.hnadsi = aVar;
        this.hnadsj = aVar.hnadsn();
        hnadsy();
    }

    private void hnadsf(int i) {
        this.hnadse = i;
    }

    private long hnadsg() {
        this.hnadsp = System.currentTimeMillis();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "getAdOutTimeConsume currentTimeMillisGetAdResponse = " + this.hnadsp + PPSLabelView.Code + hnadsm() + ", mStartTime = " + this.hnadsa + ", mTimeOutRequestStartTime = " + this.hnadsm, new Object[0]);
        return this.hnadsp - this.hnadsm;
    }

    private com.hihonor.adsdk.base.g.j.d.c.a hnadsu() {
        return new com.hihonor.adsdk.base.g.j.d.c.a().hnadsc(hnadsh()).hnadsw(hnadsl()).hnadsm(this.hnadsj).hnadsb(this.hnadsi.hnadsd()).hnadsf(this.hnadsi.hnadsh()).hnadsd(this.hnadsi.hnadsi()).hnadsd(this.hnadsi.hnadsk()).hnadsf(hnadsm());
    }

    private void hnadsx() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "handleTimeout mIsTimeOut = " + this.hnadsl + ", getAdSlotId = " + hnadsh(), new Object[0]);
        AdUnitInfo adUnitInfoHnadsa = i.hnadsa(hnadsh());
        if (adUnitInfoHnadsa != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "handleTimeout adUnitInfo.timeout = " + adUnitInfoHnadsa.timeout + ", getTimeOutMillis = " + hnadsv(), new Object[0]);
            this.hnadsn = adUnitInfoHnadsa.timeout;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "handleTimeout timeOutMillis = " + this.hnadsn + ", " + hnadsm() + PPSLabelView.Code + hnadsi() + ", mHandler = " + this.hnadsk + ", mStartTime = " + this.hnadsa + ", mTimeOutRequestStartTime = " + this.hnadsm, new Object[0]);
        if (this.hnadsn > 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "handleTimeout timeOutMillis is greater than 0", new Object[0]);
            Handler handler = this.hnadsk;
            if (handler == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "handleTimeout mHandler is null", new Object[0]);
            } else {
                handler.postDelayed(new Runnable() { // from class: com.hihonor.adsdk.base.mediation.core.imp.b$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.hnadsz();
                    }
                }, this.hnadsn);
            }
        }
    }

    private void hnadsy() {
        this.hnadsf.put("context", HnAds.get().getContext());
        this.hnadsf.put("appId", hnadsl());
        this.hnadsf.put("posId", hnadsi());
        this.hnadsf.put(o0OO000o.o00O0O0O, "");
        this.hnadsf.put("adCount", Integer.valueOf(hnadsd()));
        this.hnadsf.put("adContext", hnadsc());
        this.hnadsf.put("adWidth", Integer.valueOf(hnadsj()));
        this.hnadsf.put("adHeight", Integer.valueOf(hnadse()));
        this.hnadsf.put("timeOutMillis", Long.valueOf(hnadsv()));
        this.hnadsf.put("mediaRequestId", this.hnadsj);
        this.hnadsf.put("loadType", Integer.valueOf(this.hnadsi.hnadsk()));
        this.hnadsf.put("brandType", this.hnadsi.hnadsh());
        this.hnadsf.put("adnType", this.hnadsi.hnadsi());
        this.hnadsf.put("adType", Integer.valueOf(this.hnadsi.hnadsd()));
        this.hnadsf.put("rewardAmount", Double.valueOf(this.hnadsi.hnadso()));
        this.hnadsf.put("rewardName", this.hnadsi.hnadsp());
        this.hnadsc = hnadsa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsz() {
        this.hnadso = System.currentTimeMillis();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, hnadsm() + PPSLabelView.Code + hnadsi() + " is timeout, mTimeOutCurrentTimeMillis = " + this.hnadso, new Object[0]);
        this.hnadsl = true;
        hnadsf(-1);
        hnadsa(String.valueOf(ErrorCode.AD_RESOURCE_REQUEST_LOADING_TIME_OUT), "timeout error");
    }

    protected abstract BaseAdapter<T> hnadsa();

    public void hnadsa(int i) {
        this.hnadsi.hnadsa(i);
    }

    public void hnadsb(int i) {
        this.hnadsi.hnadsb(i);
    }

    public void hnadsb(long j) {
        this.hnadsb = j;
    }

    public String hnadsc() {
        return this.hnadsi.hnadsa();
    }

    public void hnadsd(int i) {
        this.hnadsi.hnadse(i);
    }

    public void hnadse(int i) {
        this.hnadsh = i;
    }

    public List<T> hnadsf() {
        return this.hnadsg;
    }

    public String hnadsh() {
        return this.hnadsi.hnadsq();
    }

    public String hnadsi() {
        return this.hnadsi.hnadse();
    }

    public int hnadsj() {
        return this.hnadsi.hnadsf();
    }

    public BaseAdapter<T> hnadsk() {
        return this.hnadsc;
    }

    public String hnadsl() {
        return this.hnadsi.hnadsg();
    }

    public String hnadsm() {
        return this.hnadsi.hnadsh();
    }

    public String hnadsn() {
        return this.hnadsi.hnadsi();
    }

    public int hnadso() {
        return this.hnadsi.hnadsj();
    }

    public int hnadsp() {
        return this.hnadse;
    }

    public long hnadsq() {
        return this.hnadsh;
    }

    public String hnadsr() {
        return this.hnadsi.hnadsl();
    }

    public String hnadss() {
        return this.hnadsi.hnadsm();
    }

    public String hnadst() {
        return this.hnadsj;
    }

    public long hnadsv() {
        return this.hnadsi.hnadsr();
    }

    public long hnadsw() {
        return this.hnadsb;
    }

    private void a() {
        com.hihonor.adsdk.base.mediation.a.b bVar = this.hnadsd;
        if (bVar != null) {
            bVar.hnadsb();
            this.hnadsd = null;
        }
    }

    protected void b() {
        Handler handler = this.hnadsk;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.hnadsk = null;
        }
    }

    public void hnadsa(String str) {
        this.hnadsi.hnadsa(str);
    }

    public void hnadsc(int i) {
        this.hnadsi.hnadsd(i);
    }

    public int hnadsd() {
        return this.hnadsi.hnadsb();
    }

    public int hnadse() {
        return this.hnadsi.hnadsc();
    }

    public void hnadsa(long j) {
        this.hnadsi.hnadsa(j);
    }

    protected List<T> hnadsb(List<T> list) {
        if (f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsq, "adInstallDataFilteredByPackName but Ad info list is empty", new Object[0]);
            return list;
        }
        Context context = HnAds.get().getContext();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (next.isDownload() && com.hihonor.adsdk.base.j.b.hnadsa(context, next.getAppPackage())) {
                it.remove();
            }
        }
        return list;
    }

    public void hnadsa(com.hihonor.adsdk.base.mediation.a.b bVar, long j) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "load fetchAdOnly", new Object[0]);
        this.hnadsm = j;
        this.hnadsa = System.currentTimeMillis();
        com.hihonor.adsdk.base.g.b.hnadsa(0, hnadsu().hnadsa());
        this.hnadsd = bVar;
        if (this.hnadsc != null) {
            hnadsx();
            this.hnadsc.fetchAdOnly();
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "mAdapter is null", new Object[0]);
            hnadsf(-1);
            hnadsa(String.valueOf(ErrorCode.AD_ADAPTER_IS_NULL), "adapter is null");
            com.hihonor.adsdk.base.g.b.hnadsa(107, hnadsu().hnadsj(String.valueOf(ErrorCode.AD_ADAPTER_IS_NULL)).hnadsk("load ad,but adapter is null").hnadsa());
        }
    }

    public void hnadsb() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "destroy adapter adnType=%s", hnadsn());
        b();
        BaseAdapter<T> baseAdapter = this.hnadsc;
        if (baseAdapter != null) {
            baseAdapter.release();
            this.hnadsc = null;
        }
    }

    @Override // com.hihonor.adsdk.base.mediation.comm.adevent.a
    public void hnadsa(ADEvent aDEvent) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "onADEvent type=" + aDEvent.getType() + " name=" + hnadsm(), new Object[0]);
        b();
        com.hihonor.adsdk.base.g.j.d.c cVar = (com.hihonor.adsdk.base.g.j.d.c) aDEvent.getParam(com.hihonor.adsdk.base.g.j.d.c.class);
        if (100 == aDEvent.getType()) {
            long jHnadsg = hnadsg();
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "onADEvent getAdUnitId = " + hnadsi() + ", mIsTimeOut = " + this.hnadsl + ", adOutTimeConsume = " + jHnadsg, new Object[0]);
            cVar = (com.hihonor.adsdk.base.g.j.d.c) aDEvent.getParam(1, com.hihonor.adsdk.base.g.j.d.c.class);
            this.hnadsb = System.currentTimeMillis() - this.hnadsa;
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "do onAdLoaded start", new Object[0]);
            this.hnadsg = (List) aDEvent.getParam(ArrayList.class);
            if (!"0".equals(this.hnadsi.hnadsi())) {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsq, (Object) "filter");
                this.hnadsg = hnadsb(this.hnadsg);
            }
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "mAdParameterEntity.getAdnType():" + this.hnadsi.hnadsi(), new Object[0]);
            if (!this.hnadsl) {
                if (f.hnadsa((Collection<?>) this.hnadsg)) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "mAdDataList is null", new Object[0]);
                    hnadsf(-1);
                    hnadsa(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY), "ad is empty");
                } else {
                    hnadsa(this.hnadsg);
                    hnadsf(1);
                    a();
                }
            } else {
                hnadsa(cVar, jHnadsg);
            }
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "do onAdLoaded end", new Object[0]);
        } else if (107 == aDEvent.getType() || 101 == aDEvent.getType()) {
            long jHnadsg2 = hnadsg();
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "onADEvent getAdUnitId = " + hnadsi() + ", mIsTimeOut = " + this.hnadsl + ", adOutTimeConsume = " + jHnadsg2, new Object[0]);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "#AdEvent#Ad fail type:", Integer.valueOf(aDEvent.getType()));
            if (!this.hnadsl) {
                hnadsf(-1);
                hnadsa(String.valueOf(ErrorCode.RESPONSE_FAIL), "request error");
            } else {
                hnadsa(cVar, jHnadsg2);
            }
        }
        cVar.hnadsd(this.hnadsi.hnadsi());
        com.hihonor.adsdk.base.g.b.hnadsa(aDEvent.getType(), cVar);
        hnadsb();
    }

    private void hnadsa(com.hihonor.adsdk.base.g.j.d.c cVar, long j) {
        TrackUrl trackUrl;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "reportTimeOut adOutTimeConsume：" + j, new Object[0]);
        String str = String.format("The polymerization ad resource loading process exceeded the timeout period set by the developer.The expected time is less than %s ms. result time is %s", Long.valueOf(this.hnadsn), Long.valueOf(j));
        if (f.hnadsa((Collection<?>) this.hnadsg)) {
            return;
        }
        cVar.hnadsi(String.valueOf(ErrorCode.AD_RESOURCE_REQUEST_LOADING_TIME_OUT));
        for (T t : this.hnadsg) {
            hnadsa(cVar, j, t);
            if (Objects.equals(cVar.hnadsm(), "0") && (trackUrl = t.getTrackUrl()) != null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "reportAdTrackShowFail trackUrl is not null", new Object[0]);
                new t(ErrorCode.AD_RESOURCE_REQUEST_LOADING_TIME_OUT, str).hnadsc(t.getAdId(), hnadsi(), t.getRequestId(), trackUrl.getCommons());
            }
        }
    }

    private void hnadsa(String str, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "#onFail#code=%s,msg=%s", str, str2);
        com.hihonor.adsdk.base.mediation.a.b bVar = this.hnadsd;
        if (bVar != null) {
            bVar.hnadsa();
            this.hnadsd = null;
        }
    }

    protected void hnadsa(List<T> list) {
        for (T t : list) {
            t.setAdnId(hnadsl());
            t.setLevel(hnadso());
            t.setUseTime(this.hnadsb);
            long ecpm = t.getEcpm();
            if (ecpm > this.hnadsh) {
                this.hnadsh = ecpm;
            }
        }
    }

    private void hnadsa(com.hihonor.adsdk.base.g.j.d.c cVar, long j, T t) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsq, "reportAdEventShowFailed", new Object[0]);
        cVar.hnadsi(String.valueOf(ErrorCode.AD_RESOURCE_REQUEST_LOADING_TIME_OUT));
        cVar.hnadsj("adResource is timeout");
        cVar.hnadsc(hnadsi());
        cVar.hnadsa(this.hnadsn);
        cVar.hnadsd(hnadsv());
        cVar.hnadsb("CLOUD");
        cVar.hnadsc(j);
        cVar.hnadsf(this.hnadsm);
        cVar.hnadsg(this.hnadsp);
        cVar.hnadse(this.hnadso);
        if (t != null) {
            cVar.hnadsn(t.getAppPackage());
            cVar.hnadse(t.getAppVersion());
            cVar.hnadsa(t.getAdId());
            cVar.hnadsx(t.getUnInstallFilter());
        }
        new s0(cVar, cVar.hnadsl(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVar)).hnadse();
    }
}

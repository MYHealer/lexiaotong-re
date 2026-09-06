package com.hihonor.adsdk.base.callback;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.base.bean.EventAdImpl;
import com.hihonor.adsdk.base.callback.filter.ResFilterBean;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.k.c.b0;
import com.hihonor.adsdk.base.g.k.c.t;
import com.hihonor.adsdk.base.g.k.c.x;
import com.hihonor.adsdk.base.g.k.c.y;
import com.hihonor.adsdk.base.init.HnAdConfig;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.hihonor.adsdk.base.net.request.TrackAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f extends i<BaseAdInfoResp> {
    private static final String hnadsf = "ApiCallbackBackWrap";
    private final com.hihonor.adsdk.base.bean.b hnadsd;
    private final List<BaseAdInfo> hnadse;

    public f(com.hihonor.adsdk.base.bean.b bVar, e<BaseAdInfoResp> eVar) {
        super(eVar);
        this.hnadse = new ArrayList();
        this.hnadsd = bVar;
        hnadsa();
    }

    private void hnadsg(BaseAdInfoResp baseAdInfoResp) {
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) baseAdInfoResp.getList())) {
            return;
        }
        this.hnadse.addAll(baseAdInfoResp.getList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.adsdk.base.callback.i
    /* JADX INFO: renamed from: hnadse, reason: merged with bridge method [inline-methods] */
    public void hnadsc(BaseAdInfoResp baseAdInfoResp) {
        super.hnadsc(baseAdInfoResp);
        if (!com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) hnadsd2(baseAdInfoResp))) {
            hnadsc2(baseAdInfoResp);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "Resp is success,but data is empty.", new Object[0]);
            hnadsa(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY), "Resp is success,but data is empty", baseAdInfoResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.adsdk.base.callback.i
    /* JADX INFO: renamed from: hnadsf, reason: merged with bridge method [inline-methods] */
    public void hnadsd(BaseAdInfoResp baseAdInfoResp) {
        super.hnadsd(baseAdInfoResp);
        List<BaseAdInfo> list = baseAdInfoResp.getList();
        if (list == null || list.isEmpty() || this.hnadsd == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "-------- reportTimeoutAdShowFail but adInfoRespList is null： " + (list == null ? " true." : " ,adInfoRespList.isEmpty():" + list.isEmpty()) + " ,mAdReport == null： " + (this.hnadsd == null), new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsd.hnadsg(), 15);
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(com.hihonor.adsdk.base.j.c.hnadsa(baseAdInfoResp), this.hnadsd.hnadsg(), com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp), this.hnadsd.hnadsa(), this.hnadsd.hnadsb(), this.hnadsd.hnadse());
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsd.hnadsg());
        long jCurrentTimeMillis = System.currentTimeMillis() - this.hnadsd.hnadsi();
        String str = String.format("The ad loading process exceeded the timeout period set by the developer.The expected time is less than %s ms. result time is %s", Long.valueOf(this.hnadsd.hnadsk()), Long.valueOf(jCurrentTimeMillis));
        Iterator<BaseAdInfo> it = list.iterator();
        while (it.hasNext()) {
            EventAdImpl eventAdImpl = new EventAdImpl(it.next());
            new t(ErrorCode.AD_LOADING_TIME_OUT, str).hnadsa(eventAdImpl, eventAdImpl.getTrackUrl().getCommons());
            new s0(ErrorCode.AD_LOADING_TIME_OUT, str, eventAdImpl.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(eventAdImpl)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.t, String.valueOf(this.hnadsd.hnadsk())).hnadsa(com.hihonor.adsdk.base.g.j.e.a.u, String.valueOf(jCurrentTimeMillis)).hnadse();
        }
        com.hihonor.adsdk.base.g.a.hnadsa(this.hnadsd.hnadsh(), this.hnadsd.hnadsg(), com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp), ErrorCode.AD_LOADING_TIME_OUT, str, this.hnadsd.hnadsb(), this.hnadsd.hnadsc());
    }

    private void hnadsb(BaseAdInfoResp baseAdInfoResp) {
        if (this.hnadsd != null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf, "AdPackNameFilterHandler, All ads in the ads list are filtered, call AdTrackShowFail#onReportWorkFlow", new Object[0]);
            com.hihonor.adsdk.base.g.a.hnadsa(com.hihonor.adsdk.base.j.c.hnadsa(baseAdInfoResp), this.hnadsd.hnadsg(), com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp), ErrorCode.HI_AD_PACK_INSTALLED, ErrorCode.REPORT_AD_PACK_HI_AD_PACK_SLOT, this.hnadsd.hnadsb(), this.hnadsd.hnadsc());
        }
    }

    /* JADX INFO: renamed from: hnadsc, reason: avoid collision after fix types in other method */
    private void hnadsc2(BaseAdInfoResp baseAdInfoResp) {
        if (this.hnadsd == null || baseAdInfoResp == null || com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) hnadsd2(baseAdInfoResp))) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "adRequestSuccessTrack but mAdReport or baseAdInfos is null", new Object[0]);
            return;
        }
        List<BaseAdInfo> listHnadsd2 = hnadsd2(baseAdInfoResp);
        ArrayList arrayList = new ArrayList(listHnadsd2.size());
        List<String> arrayList2 = new ArrayList<>(listHnadsd2.size());
        for (int i = 0; i < listHnadsd2.size(); i++) {
            hnadsa(arrayList, listHnadsd2, i);
            hnadsb(arrayList2, listHnadsd2, i);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "adRequestSuccessTrack and adList size :" + arrayList.size(), new Object[0]);
        String strHnadsb = com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd, strHnadsb);
        com.hihonor.adsdk.base.bean.b bVar = this.hnadsd;
        new com.hihonor.adsdk.base.g.j.d.j1.i(bVar, bVar.hnadsh(), aVarHnadsa, arrayList, arrayList2).hnadse();
        new y(this.hnadsd.hnadsg(), strHnadsb, this.hnadsd.hnadsb(), this.hnadsd.hnadsc()).hnadsa(com.hihonor.adsdk.base.j.c.hnadsa(baseAdInfoResp), strHnadsb);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsf, (Object) "-------- adRequestSuccessReport end");
    }

    /* JADX INFO: renamed from: hnadsd, reason: avoid collision after fix types in other method */
    private List<BaseAdInfo> hnadsd2(BaseAdInfoResp baseAdInfoResp) {
        return com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) this.hnadse) ? baseAdInfoResp.getList() : this.hnadse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.adsdk.base.callback.i
    public void hnadsa(String str, BaseAdInfoResp baseAdInfoResp, String str2) {
        super.hnadsa(str, baseAdInfoResp, str2);
        hnadsa(str, str2, baseAdInfoResp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.adsdk.base.callback.i
    public ResFilterBean hnadsa(BaseAdInfoResp baseAdInfoResp) {
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsd.hnadsg(), 18);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "adDataFiltered, adDataFiltered sta.", new Object[0]);
        ResFilterBean resFilterBean = new ResFilterBean(true);
        if (baseAdInfoResp != null && baseAdInfoResp.getList() != null && baseAdInfoResp.getList().size() != 0) {
            hnadsg(baseAdInfoResp);
            resFilterBean.setListSourceData(baseAdInfoResp);
            h.b bVar = new h.b();
            bVar.hnadsa(new c(this.hnadsd.hnadsa()));
            if (this.hnadsd.hnadsl()) {
                bVar.hnadsa(new com.hihonor.adsdk.base.callback.filter.a());
            }
            HnAdConfig cfg = HnAds.get().getCfg();
            if (cfg != null && com.hihonor.adsdk.base.c.hnadsc.equals(cfg.getAppId()) && cfg.isUseTestTools()) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "adDataFiltered,test env and use test tools", new Object[0]);
                bVar.hnadsa(new d());
            }
            bVar.hnadsa().hnadsa(resFilterBean);
            if (resFilterBean.isEmptyResult()) {
                hnadsb(baseAdInfoResp);
            }
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "adDataFiltered, adDataFiltered end.", new Object[0]);
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsd.hnadsg(), 19);
            return resFilterBean;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "adDataFiltered, Resp is success,but data is empty.", new Object[0]);
        resFilterBean.setNeedFilter(false);
        return resFilterBean;
    }

    private void hnadsb() {
        TrackAdRequest trackAdRequest = new TrackAdRequest();
        trackAdRequest.setAdUnitId(this.hnadsd.hnadsh());
        trackAdRequest.setAdType(this.hnadsd.hnadsa());
        trackAdRequest.setMediaRequestId(this.hnadsd.hnadsg());
        trackAdRequest.setLoadType(this.hnadsd.hnadse());
        trackAdRequest.setSdkVersionName("10024300");
        trackAdRequest.setThirdPlatformId(AdnConfig.b.hnadsa);
        trackAdRequest.setLoadAction(String.valueOf(this.hnadsd.hnadsd()));
        trackAdRequest.setOaid(com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb());
        trackAdRequest.setDataType(String.valueOf(this.hnadsd.hnadsb()));
        trackAdRequest.setKeyTerms(this.hnadsd.hnadsc());
        trackAdRequest.setPackageName(HnAds.get().getContext() != null ? HnAds.get().getContext().getPackageName() : "");
        new b0(trackAdRequest).hnadsa(this.hnadsd.hnadsh(), this.hnadsd.hnadsg());
    }

    private void hnadsb(List<String> list, List<BaseAdInfo> list2, int i) {
        list.add((com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list2) || Objects.isNull(list2.get(i))) ? " channelInfo is null." : list2.get(i).getChannelInfo());
    }

    private void hnadsa() {
        com.hihonor.adsdk.base.bean.b bVar = this.hnadsd;
        if (bVar != null) {
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(bVar, "");
            com.hihonor.adsdk.base.bean.b bVar2 = this.hnadsd;
            new com.hihonor.adsdk.base.g.j.d.j1.h(bVar2, bVar2.hnadsh(), aVarHnadsa).hnadse();
            hnadsb();
        }
    }

    private void hnadsa(String str, String str2, BaseAdInfoResp baseAdInfoResp) {
        if (this.hnadsd != null) {
            String strHnadsb = com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp);
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsd, strHnadsb);
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsd.hnadsg(), 15);
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(com.hihonor.adsdk.base.j.c.hnadsa(baseAdInfoResp), this.hnadsd.hnadsg(), strHnadsb, this.hnadsd.hnadsa(), this.hnadsd.hnadsb(), this.hnadsd.hnadse());
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsd.hnadsg());
            com.hihonor.adsdk.base.bean.b bVar = this.hnadsd;
            new com.hihonor.adsdk.base.g.j.d.j1.g(bVar, bVar.hnadsh(), aVarHnadsa, str, str2).hnadse();
            if (String.valueOf(ErrorCode.RESPONSE_FAIL).equals(str)) {
                new x(String.valueOf(ErrorCode.c.hnadsd), str2, this.hnadsd.hnadsg(), this.hnadsd.hnadsb(), strHnadsb, this.hnadsd.hnadsc()).hnadsa(this.hnadsd.hnadsh(), strHnadsb);
            } else {
                new x(str, str2, this.hnadsd.hnadsg(), this.hnadsd.hnadsb(), strHnadsb, this.hnadsd.hnadsc()).hnadsa(this.hnadsd.hnadsh(), strHnadsb);
            }
        }
    }

    private void hnadsa(List<String> list, List<BaseAdInfo> list2, int i) {
        list.add((com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list2) || Objects.isNull(list2.get(i))) ? " ad is null." : list2.get(i).getAdId());
    }
}

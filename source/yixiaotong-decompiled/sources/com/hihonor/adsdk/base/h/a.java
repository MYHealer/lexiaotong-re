package com.hihonor.adsdk.base.h;

import android.text.TextUtils;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.k.c.v;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.base.net.request.TrackAdRequest;
import com.hihonor.adsdk.common.f.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsa = "AdRepository";
    private static volatile a hnadsb;

    private BaseAdInfoResp hnadsb(List<BaseAdInfo> list) {
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getBaseAdInfoResp baseAdInfoList is empty", new Object[0]);
            return null;
        }
        if (Objects.isNull(list.get(0))) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getBaseAdInfoResp baseAdInfoList get(0) is null", new Object[0]);
            return null;
        }
        BaseAdInfoResp baseAdInfoResp = new BaseAdInfoResp();
        baseAdInfoResp.setRequestId(list.get(0).getAdRequestId());
        baseAdInfoResp.setAdUnitId(list.get(0).getAdUnitId());
        baseAdInfoResp.setResponseTimeMillis(System.currentTimeMillis());
        baseAdInfoResp.setCachedData(true);
        baseAdInfoResp.setList(list);
        return baseAdInfoResp;
    }

    private void hnadsd(final AdSlot adSlot, final String str, final int i, final com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> eVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "requestAdCache mClientReqMarker: " + str, new Object[0]);
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(str, 1);
        a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.base.h.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsa(adSlot, str, i, eVar);
            }
        });
    }

    protected void hnadsc(AdSlot adSlot, String str, int i, com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> eVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "requestAd", new Object[0]);
        c.hnadsa(adSlot.getDataType()).hnadsa(new com.hihonor.adsdk.base.bean.a.C0425a().hnadsa(adSlot).hnadsa(i).hnadsa(str).hnadsa(eVar).hnadsa());
    }

    public static a hnadsa() {
        if (hnadsb == null) {
            synchronized (a.class) {
                if (hnadsb == null) {
                    hnadsb = new a();
                }
            }
        }
        return hnadsb;
    }

    public void hnadsa(String str, com.hihonor.adsdk.base.d.b bVar) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "queryAdCache adUnitId = %s, queryAdDataListener = %s", str, bVar);
            List<BaseAdInfo> listHnadsb = com.hihonor.adsdk.base.d.a.hnadsb().hnadsb(str);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "queryAdCache adCacheList = " + listHnadsb, new Object[0]);
            if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) listHnadsb)) {
                if (bVar != null) {
                    bVar.hnadsa(new ArrayList());
                }
            } else {
                BaseAdInfo baseAdInfo = listHnadsb.get(0);
                if (baseAdInfo != null) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "queryAdCache adUnitMarker = " + baseAdInfo.getAdUnitId() + ", adRequestMarker = " + baseAdInfo.getAdRequestId() + ", expirationTime = " + baseAdInfo.getExpirationTime(), new Object[0]);
                }
                if (bVar != null) {
                    bVar.hnadsa(listHnadsb);
                }
            }
        } catch (Exception e) {
            String str2 = ErrorCode.STR_DB_CACHE_GET_EXCEPTION + e.getMessage() + "adUnitMarker is " + str;
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "queryAdCache, getCacheADData error, Exception: " + e.getMessage(), new Object[0]);
            new x(str, com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.DB_CACHE_GET_EXCEPTION, str2).hnadse();
            if (bVar != null) {
                bVar.hnadsa(new ArrayList());
            }
        }
    }

    private void hnadsc(BaseAdInfo baseAdInfo) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "preload video cover.", new Object[0]);
        Video video = baseAdInfo.getVideo();
        if (video == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "preload video cover fail. cause by video is null.", new Object[0]);
        } else {
            new GlideLoadBuild.Builder().setContext(HnAds.get().getContext()).setUrl(video.getCoverUrl()).build().preload();
        }
    }

    public void hnadsb(AdSlot adSlot, String str, int i, com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> eVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "preLoadAd loadType:" + adSlot.getLoadType(), new Object[0]);
        if (adSlot.getLoadType() != 0) {
            hnadsc(adSlot, str, i, eVar);
        } else {
            hnadsd(adSlot, str, i, eVar);
        }
    }

    private void hnadsb(BaseAdInfo baseAdInfo) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "preload video.", new Object[0]);
        Video video = baseAdInfo.getVideo();
        if (video == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "preload video fail. cause by video is null.", new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "preloadVideo", new Object[0]);
            com.hihonor.adsdk.common.video.g.b.hnadsa().hnadsb().hnadsb(HnAds.get().getContext(), video.getVideoUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(AdSlot adSlot, String str, int i, com.hihonor.adsdk.base.callback.e eVar, List list) {
        hnadsa((List<BaseAdInfo>) list, adSlot, str, i, (com.hihonor.adsdk.base.callback.e<BaseAdInfoResp>) eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(final AdSlot adSlot, final String str, final int i, final com.hihonor.adsdk.base.callback.e eVar) {
        hnadsa(adSlot.getSlotId(), new com.hihonor.adsdk.base.d.b() { // from class: com.hihonor.adsdk.base.h.a$$ExternalSyntheticLambda0
            @Override // com.hihonor.adsdk.base.d.b
            public final void hnadsa(List list) {
                this.f$0.hnadsa(adSlot, str, i, eVar, list);
            }
        });
    }

    private void hnadsa(List<BaseAdInfo> list, AdSlot adSlot, String str, int i, com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> eVar) {
        List<BaseAdInfo> listHnadsa = com.hihonor.adsdk.base.callback.b.hnadsa(list);
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) listHnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "Ad cache is null", new Object[0]);
            new x(adSlot.getSlotId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(str, "", -1, 0), ErrorCode.DB_CACHE_AD_NULL, "db getAdData, but ad is null.adSlot getSlotId " + adSlot.getSlotId()).hnadse();
            hnadsc(adSlot, str, i, eVar);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "query cache success", new Object[0]);
        BaseAdInfoResp baseAdInfoRespHnadsb = hnadsb(listHnadsa);
        hnadsa(adSlot, listHnadsa, str);
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(str, 14);
        eVar.hnadsa(baseAdInfoRespHnadsb);
    }

    private void hnadsa(AdSlot adSlot, List<BaseAdInfo> list, String str) {
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "report but baseAdInfoList is null", new Object[0]);
            return;
        }
        if (Objects.isNull(list.get(0))) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "report baseAdInfoList get(0) is null", new Object[0]);
            return;
        }
        String adUnitId = list.get(0).getAdUnitId();
        String adRequestId = list.get(0).getAdRequestId();
        int dataType = adSlot.getDataType();
        int adType = list.get(0).getAdType();
        String strHnadsa = com.hihonor.adsdk.base.g.c.hnadsa(adSlot);
        new x(adUnitId, com.hihonor.adsdk.base.g.j.g.b.hnadsa(list.get(0)), ErrorCode.DB_CACHE_AD_NORMAL, "db getAdData, ad is normal. return to mediaadSlot getSlotId " + adSlot.getSlotId()).hnadsa(com.hihonor.adsdk.base.g.j.e.a.K0, strHnadsa).hnadsa("ad_id", com.hihonor.adsdk.base.j.g.hnadsa(hnadsa(list))).hnadse();
        TrackAdRequest trackAdRequest = new TrackAdRequest();
        trackAdRequest.setAdUnitId(adUnitId);
        trackAdRequest.setAdType(adType);
        trackAdRequest.setMediaRequestId(str);
        trackAdRequest.setLoadType(adSlot.getLoadType());
        trackAdRequest.setLoadAction(String.valueOf(com.hihonor.adsdk.base.b.hnadsa(adSlot)));
        trackAdRequest.setDataType(String.valueOf(dataType));
        trackAdRequest.setKeyTerms(strHnadsa);
        trackAdRequest.setSdkVersionName("10024300");
        trackAdRequest.setThirdPlatformId(AdnConfig.b.hnadsa);
        trackAdRequest.setOaid(com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb());
        trackAdRequest.setPackageName(HnAds.get().getContext() != null ? HnAds.get().getContext().getPackageName() : "");
        trackAdRequest.setRequestId(adRequestId);
        new v(trackAdRequest).hnadsa(adUnitId, adRequestId);
    }

    private List<String> hnadsa(List<BaseAdInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (!com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            for (BaseAdInfo baseAdInfo : list) {
                if (Objects.nonNull(baseAdInfo)) {
                    arrayList.add(baseAdInfo.getAdId());
                }
            }
        }
        return arrayList;
    }

    public void hnadsa(BaseAdInfoResp baseAdInfoResp, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "save cache.", new Object[0]);
        if (baseAdInfoResp != null && baseAdInfoResp.getList() != null && !baseAdInfoResp.getList().isEmpty()) {
            try {
                List<BaseAdInfo> list = baseAdInfoResp.getList();
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "saveAdData list size = " + list.size(), new Object[0]);
                com.hihonor.adsdk.base.d.a.hnadsb().hnadsa(list, str);
                for (int i = 0; i < list.size(); i++) {
                    BaseAdInfo baseAdInfo = list.get(i);
                    hnadsa(baseAdInfo);
                    hnadsc(baseAdInfo);
                    hnadsb(baseAdInfo);
                }
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "saveAdData, save Ad data end");
                new x(com.hihonor.adsdk.base.j.c.hnadsa(baseAdInfoResp), com.hihonor.adsdk.base.g.j.g.b.hnadsa(str, com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp), -1, 0), ErrorCode.DB_CACHE_INFO_DONE, ErrorCode.STR_DB_CACHE_INFO_DONE).hnadse();
                return;
            } catch (Exception e) {
                String str2 = "db saveAdData, but has Exception.saveAdData:" + e.getMessage();
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "saveAdData, save Ad data error, Exception: " + str2, new Object[0]);
                new x(com.hihonor.adsdk.base.j.c.hnadsa(baseAdInfoResp), com.hihonor.adsdk.base.g.j.g.b.hnadsa(str, com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp), -1, 0), ErrorCode.DB_CACHE_INFO_EXCEPTION, str2).hnadse();
                return;
            }
        }
        new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.DB_CACHE_INFO_ERROR, ErrorCode.STR_DB_CACHE_INFO_ERROR).hnadse();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "save cache fail but ad info is null.", new Object[0]);
    }

    private void hnadsa(BaseAdInfo baseAdInfo) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "preload image.", new Object[0]);
        try {
            if (baseAdInfo.getImgUrls() != null && !baseAdInfo.getImgUrls().isEmpty()) {
                for (int i = 0; i < baseAdInfo.getImgUrls().size(); i++) {
                    String str = baseAdInfo.getImgUrls().get(i);
                    if (TextUtils.isEmpty(str)) {
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "preloadImg fail cause by: ad imgUrl is empty.id: " + baseAdInfo.getAdId(), new Object[0]);
                    } else {
                        new GlideLoadBuild.Builder().setContext(HnAds.get().getContext()).setUrl(str).build().preload();
                    }
                }
                return;
            }
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "preloadImg fail cause by: ad imgUrls is empty.");
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "preloadImg, Exception: " + e.getMessage(), new Object[0]);
        }
    }
}

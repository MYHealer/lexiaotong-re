package com.hihonor.adsdk.base.callback;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.EventAdImpl;
import com.hihonor.adsdk.base.callback.filter.AdFilteringLog;
import com.hihonor.adsdk.base.callback.filter.FilterAd;
import com.hihonor.adsdk.base.callback.filter.ResFilterBean;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.k.c.t;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends a {
    private static final String hnadsb = "AdTypeFilterHandler";
    private final int hnadsa;

    public c(int i) {
        this.hnadsa = i;
    }

    private void hnadsb(int i, ResFilterBean resFilterBean) {
        Iterator<BaseAdInfo> it = resFilterBean.getListSourceData().iterator();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "AdTypeFilterHandler , filter sta.", new Object[0]);
        while (it.hasNext()) {
            BaseAdInfo next = it.next();
            if (next.getAdType() == i) {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsb, (Object) "The ad type is match, check next ad");
            } else {
                resFilterBean.addListResultsData(new FilterAd(ErrorCode.HI_AD_TYPE_MISMATCH, next.getAdId(), next.getAppPackage(), next.getPromotionPurpose()));
                it.remove();
                AdFilteringLog.info(AdFilteringLog.FILTER_TYPE_HN, "AD type mismatch, and remove the ad packName=", "AdId:" + next.getAdId(), "AdRequestId:" + next.getAdRequestId(), "PromotionPurpose:" + next.getPromotionPurpose(), "ErrCode:30010", "PackName:" + next.getAppPackage());
                EventAdImpl eventAdImpl = new EventAdImpl(next);
                new t(ErrorCode.HI_AD_TYPE_MISMATCH, ErrorCode.REPORT_AD_TYPE_MISMATCH).hnadsa(eventAdImpl, eventAdImpl.getTrackUrl().getCommons());
                new s0(ErrorCode.HI_AD_TYPE_MISMATCH, "", eventAdImpl.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(eventAdImpl)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsb, String.valueOf(i)).hnadse();
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "AdTypeFilterHandler , filter end.", new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.callback.a
    public void hnadsa(ResFilterBean resFilterBean) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "AdTypeFilterHandler , filterData sta.", new Object[0]);
        hnadsa(this.hnadsa, resFilterBean);
    }

    public void hnadsa(int i, ResFilterBean resFilterBean) {
        if (resFilterBean.getListSourceData() != null && resFilterBean.getListSourceData().size() != 0) {
            hnadsb(i, resFilterBean);
        } else {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "adDataFilteredByType but Ad info list is empty", new Object[0]);
        }
    }
}

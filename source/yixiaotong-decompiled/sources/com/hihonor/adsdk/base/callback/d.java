package com.hihonor.adsdk.base.callback;

import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.callback.filter.ResFilterBean;
import com.hihonor.adsdk.common.f.q;
import com.hihonor.adsdk.common.f.t;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends a {
    private static final String hnadse = "AdTypeProPurFilterHandler";
    private final String hnadsa = "";
    private final String hnadsb = "honor_ad_tools_pro";
    private int hnadsc = -1;
    private int hnadsd = -1;

    private void hnadsb(List<BaseAdInfo> list) {
        Iterator<BaseAdInfo> it = list.iterator();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "filter sta.", new Object[0]);
        while (it.hasNext()) {
            BaseAdInfo next = it.next();
            if (next.getPromotionPurpose() != this.hnadsd) {
                it.remove();
                com.hihonor.adsdk.common.b.b.hnadse(hnadse, "filter,ad PromotionPurpose is not match , and remove the ad packName=" + next.getAppPackage(), new Object[0]);
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "filter end.", new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.callback.a
    public void hnadsa(ResFilterBean resFilterBean) {
        try {
            String strHnadsa = t.hnadsc().hnadsa("honor_ad_tools_pro", "");
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "filterData,test tool purposeStr: " + strHnadsa, new Object[0]);
            if ("".equals(strHnadsa)) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "filterData,mInvalidTestProPurStr not set,return", new Object[0]);
                return;
            }
            this.hnadsd = q.hnadsd(strHnadsa, true);
            if (this.hnadsd == this.hnadsc) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "filterData,mTestPromotionPurpose not set,return", new Object[0]);
                return;
            }
            List<BaseAdInfo> listSourceData = resFilterBean.getListSourceData();
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "filterData,before size: " + (listSourceData == null ? 0 : listSourceData.size()), new Object[0]);
            hnadsa(listSourceData);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadse, "filterData,on exception: " + e.getMessage(), new Object[0]);
        }
    }

    private void hnadsa(List<BaseAdInfo> list) {
        if (list != null && list.size() != 0) {
            hnadsb(list);
        } else {
            com.hihonor.adsdk.common.b.b.hnadse(hnadse, "adFilterByPromotionPurpose, but Ad info list is empty", new Object[0]);
        }
    }
}

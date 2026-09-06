package com.hihonor.adsdk.base.api.f;

import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements com.hihonor.adsdk.base.api.b.e {
    private static final String hnadsa = "HandleInstallNotify";

    @Override // com.hihonor.adsdk.base.api.b.e
    public void hnadsa(List<BaseAdInfo> list) {
        if (list == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "notifyAdInfo baseAdInfoList is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "notifyAdInfo start", new Object[0]);
        for (BaseAdInfo baseAdInfo : list) {
            if (baseAdInfo.getPromotionPurpose() == 0) {
                com.hihonor.adsdk.base.dialog.a.hnadsc().hnadsa(baseAdInfo.getAppPackage(), new InstallNotifyBean(baseAdInfo));
            }
        }
    }
}

package com.hihonor.adsdk.base.widget.download;

import com.hihonor.adsdk.base.api.BaseAd;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String hnadsa = "HnDownloadButtonUtil";

    private c() {
    }

    public static List<String> hnadsa(BaseAd baseAd) {
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getAppReservations--->baseAd is null", new Object[0]);
            return new ArrayList();
        }
        if (baseAd.getTrackUrl() != null) {
            return baseAd.getTrackUrl().getReservations();
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getAppReservations--->trackUrl is null", new Object[0]);
        return new ArrayList();
    }

    public static boolean hnadsb(BaseAd baseAd) {
        if (!Objects.isNull(baseAd)) {
            return baseAd.getPromotionPurpose() == 0;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isAppPopularizeDownload--->baseAd is null", new Object[0]);
        return false;
    }

    public static boolean hnadsc(BaseAd baseAd) {
        if (!Objects.isNull(baseAd)) {
            return baseAd.getPromotionPurpose() == 4;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isAppReserveDownload--->baseAd is null", new Object[0]);
        return false;
    }
}

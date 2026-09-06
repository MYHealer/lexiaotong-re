package com.hihonor.adsdk.base.g.k.b;

import com.hihonor.adsdk.base.dp.entity.AdTrack;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends a {
    @Override // com.hihonor.adsdk.base.g.k.b.a
    protected int hnadsa() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.g.k.b.a
    protected String hnadsb() {
        return "AdTrackingAdapter";
    }

    @Override // com.hihonor.adsdk.base.g.k.b.a
    protected List<AdTrack> hnadsb(List<AdTrack> list) {
        return list;
    }

    @Override // com.hihonor.adsdk.base.g.k.b.a
    protected void hnadsd(List<AdTrack> list) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsb(), (Object) "Will be have adTrack repay report fail count more than max count.");
    }
}

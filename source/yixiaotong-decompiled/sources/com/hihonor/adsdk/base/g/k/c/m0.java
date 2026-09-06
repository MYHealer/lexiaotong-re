package com.hihonor.adsdk.base.g.k.c;

import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.net.request.TrackAdReqBase;
import com.hihonor.adsdk.base.net.request.TrackAdRequest;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class m0 extends k0 {
    protected TrackAdReqBase<TrackAdRequest> hnadsd = new TrackAdReqBase<>();

    protected void hnadsa(TrackAdRequest trackAdRequest) {
        this.hnadsd.setMediaId(HnAds.get().getCfg().getAppId());
        this.hnadsd.setSdkVersion("1.0.24.300");
        this.hnadsd.setData(trackAdRequest);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.hnadsd);
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadst, com.hihonor.adsdk.base.j.g.hnadsa(arrayList));
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsu, "POST");
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    protected int hnadsc() {
        return 1;
    }
}

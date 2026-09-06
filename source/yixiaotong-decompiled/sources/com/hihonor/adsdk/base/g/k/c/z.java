package com.hihonor.adsdk.base.g.k.c;

import com.hihonor.adsdk.base.net.request.TrackAdRequest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class z extends m0 {
    public z(String str, String str2, String str3, int i, String str4, int i2, String str5) {
        this.hnadsd.setScene(com.hihonor.adsdk.base.c.e2.hnadsf);
        this.hnadsd.setRequestId(str2 == null ? "" : str2);
        TrackAdRequest trackAdRequest = new TrackAdRequest();
        trackAdRequest.setRequestId(str2 == null ? "" : str2);
        trackAdRequest.setMediaRequestId(str3 == null ? "" : str3);
        trackAdRequest.setAdUnitId(str);
        trackAdRequest.setCode(String.valueOf(i));
        trackAdRequest.setMsg(str4);
        trackAdRequest.setDataType(String.valueOf(i2));
        trackAdRequest.setKeyTerms(str5);
        hnadsa(trackAdRequest);
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 8;
    }
}

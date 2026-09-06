package com.hihonor.adsdk.base.g.k.c;

import com.hihonor.adsdk.base.net.request.TrackAdRequest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class y extends m0 {
    public y(String str, String str2, int i, String str3) {
        this.hnadsd.setRequestId(str2 == null ? "" : str2);
        this.hnadsd.setScene(com.hihonor.adsdk.base.c.e2.hnadse);
        TrackAdRequest trackAdRequest = new TrackAdRequest();
        trackAdRequest.setRequestId(str2 == null ? "" : str2);
        trackAdRequest.setMediaRequestId(str);
        trackAdRequest.setCode(String.valueOf(0));
        trackAdRequest.setMsg("success");
        trackAdRequest.setDataType(String.valueOf(i));
        trackAdRequest.setKeyTerms(str3);
        hnadsa(trackAdRequest);
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 13;
    }
}

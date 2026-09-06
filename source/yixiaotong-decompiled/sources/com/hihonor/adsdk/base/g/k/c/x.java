package com.hihonor.adsdk.base.g.k.c;

import com.hihonor.adsdk.base.net.request.TrackAdRequest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class x extends m0 {
    public x(String str, String str2, String str3, int i, String str4, String str5) {
        this.hnadsd.setScene(com.hihonor.adsdk.base.c.e2.hnadse);
        this.hnadsd.setRequestId(str4 == null ? "" : str4);
        TrackAdRequest trackAdRequest = new TrackAdRequest();
        trackAdRequest.setRequestId(str4 == null ? "" : str4);
        trackAdRequest.setMediaRequestId(str3);
        trackAdRequest.setCode(str);
        trackAdRequest.setMsg(str2);
        trackAdRequest.setDataType(String.valueOf(i));
        trackAdRequest.setKeyTerms(str5);
        hnadsa(trackAdRequest);
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 14;
    }
}

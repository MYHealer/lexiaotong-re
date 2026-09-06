package com.hihonor.adsdk.base.g.k.c;

import com.hihonor.adsdk.base.bean.DislikeInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends j0 {
    public c(String str) {
        hnadsa(new DislikeInfo(str));
    }

    private void hnadsa(DislikeInfo dislikeInfo) {
        hnadsa(6, 0, "ad close", "{\"reason\":\"" + dislikeInfo.getCode() + "\",\"desc\":\"" + dislikeInfo.getText() + "\"}");
    }

    @Override // com.hihonor.adsdk.base.g.k.c.k0
    public int hnadsb() {
        return 12;
    }

    public c(DislikeInfo dislikeInfo) {
        hnadsa(dislikeInfo);
    }
}

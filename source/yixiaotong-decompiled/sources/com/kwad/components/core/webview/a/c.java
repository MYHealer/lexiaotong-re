package com.kwad.components.core.webview.a;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public String PC;
    public String apm;
    public String apn;
    public int apo;

    public final AdInfo.SmallAppJumpInfo bB(String str) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        smallAppJumpInfo.mediaSmallAppId = str;
        smallAppJumpInfo.originId = this.apm;
        smallAppJumpInfo.smallAppJumpUrl = this.apn;
        return smallAppJumpInfo;
    }
}

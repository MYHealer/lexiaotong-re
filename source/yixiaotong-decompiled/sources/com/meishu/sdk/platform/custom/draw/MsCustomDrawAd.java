package com.meishu.sdk.platform.custom.draw;

import com.meishu.sdk.core.ad.draw.DrawAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class MsCustomDrawAd extends DrawAd {
    public MsCustomDrawAd(MsCustomDrawAdapter msCustomDrawAdapter) {
        this(msCustomDrawAdapter, "CUSTOM");
    }

    public MsCustomDrawAd(MsCustomDrawAdapter msCustomDrawAdapter, String str) {
        super(msCustomDrawAdapter, str);
    }
}

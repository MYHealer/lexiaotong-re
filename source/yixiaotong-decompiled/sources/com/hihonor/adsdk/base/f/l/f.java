package com.hihonor.adsdk.base.f.l;

import com.hihonor.adsdk.base.api.BaseAd;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f extends d {
    private static final String hnadsh = "WeChatMiniHandler";

    public f(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.f.l.d, com.hihonor.adsdk.base.f.f
    public String hnadsa() {
        return hnadsh;
    }

    @Override // com.hihonor.adsdk.base.f.l.c
    protected int hnadsh() {
        return 107;
    }

    @Override // com.hihonor.adsdk.base.f.l.d
    protected BaseReq hnadsj() {
        if (!hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "Unable to call startInternal, Cause by BaseAd is null.", new Object[0]);
            return null;
        }
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = this.hnadsa.getMiniProgramId();
        req.path = this.hnadsa.getMiniProgramPath();
        req.miniprogramType = 0;
        return req;
    }
}

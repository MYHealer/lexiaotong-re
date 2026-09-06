package com.hihonor.adsdk.base.f.l;

import android.text.TextUtils;
import com.hihonor.adsdk.base.api.BaseAd;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends d {
    private static final String hnadsh = "WeChatPageHandler";

    public g(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.f.l.d, com.hihonor.adsdk.base.f.f
    public String hnadsa() {
        return hnadsh;
    }

    @Override // com.hihonor.adsdk.base.f.l.c, com.hihonor.adsdk.base.f.a
    protected int hnadsb() {
        return 5;
    }

    @Override // com.hihonor.adsdk.base.f.l.c
    protected int hnadsh() {
        return 5;
    }

    @Override // com.hihonor.adsdk.base.f.l.d
    protected BaseReq hnadsj() {
        if (!hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "Unable to call startInternal, Cause by BaseAd is null.", new Object[0]);
            return null;
        }
        String wechatExtInfo = this.hnadsa.getWechatExtInfo();
        if (TextUtils.isEmpty(wechatExtInfo)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), "wechatExtInfo is empty", new Object[0]);
            return null;
        }
        WXOpenBusinessView.Req req = new WXOpenBusinessView.Req();
        req.businessType = "nativeOpenAdCanvas";
        req.extInfo = wechatExtInfo;
        return req;
    }
}

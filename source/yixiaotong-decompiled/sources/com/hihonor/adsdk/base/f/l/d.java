package com.hihonor.adsdk.base.f.l;

import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.j;
import com.hihonor.adsdk.base.init.HnAdConfig;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class d extends c {
    private static final String hnadsg = "BaseWeChatHandler";
    protected final com.hihonor.adsdk.base.g.j.d.h1.b hnadsf;

    public d(BaseAd baseAd) {
        super(baseAd);
        com.hihonor.adsdk.base.g.j.d.h1.b bVar = new com.hihonor.adsdk.base.g.j.d.h1.b();
        this.hnadsf = bVar;
        bVar.hnadsd(hnadsl());
        bVar.hnadsc(hnadsk());
    }

    public static int hnadsk() {
        return Build.SDK_INT;
    }

    public static int hnadsl() {
        try {
            HnAdConfig cfg = HnAds.get().getCfg();
            if (cfg != null && !TextUtils.isEmpty(cfg.getWxOpenAppId())) {
                return WXAPIFactory.createWXAPI(HnAds.get().getContext(), cfg.getWxOpenAppId(), false).getWXAppSupportAPI();
            }
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "getWxSupportApi hnAdConfig is null or wxOpenAppId is null", new Object[0]);
            return 0;
        } catch (Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "getWxSupportApi error msg = " + th.getMessage(), new Object[0]);
            return 0;
        }
    }

    private void hnadsm() {
        if (!hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "Unable to call reportStartSuccess,Cause by BaseAd is null.", new Object[0]);
            return;
        }
        int iHnadsa = com.hihonor.adsdk.base.j.f.hnadsa(this.hnadsa.getPromotionPurpose(), this.hnadsa.getMiniProgramType());
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "WeChatHandler#reportStartSuccess dpType=" + iHnadsa, new Object[0]);
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa);
        BaseAd baseAd = this.hnadsa;
        new j(baseAd, baseAd.getAdUnitId(), aVarHnadsa, this.hnadsa.getSequence(), iHnadsa).hnadsa(-2).hnadsa(this.hnadsa.getDeeplinkUrl()).hnadsa(0L).hnadsb(this.hnadsa.getSequence()).hnadse();
        com.hihonor.adsdk.base.g.k.c.g gVar = new com.hihonor.adsdk.base.g.k.c.g(2, 0);
        BaseAd baseAd2 = this.hnadsa;
        gVar.hnadsa(baseAd2, baseAd2.getTrackUrl().getDpSuccess());
    }

    @Override // com.hihonor.adsdk.base.f.f
    public String hnadsa() {
        return hnadsg;
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected void hnadsa(com.hihonor.adsdk.base.f.a.b bVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "start WeChat internal.", new Object[0]);
        if (!hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "Unable to call startInternal, Cause by BaseAd is null.", new Object[0]);
            return;
        }
        new com.hihonor.adsdk.base.g.j.d.b(this.hnadsa.getSequence(), this.hnadsa.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa)).hnadsb(hnadsh()).hnadsa(-2).hnadsa(this.hnadsa.getDeeplinkUrl()).hnadse();
        if (!hnadsi()) {
            String str = String.format(Locale.ENGLISH, "startMiniAppFail#Start mini app fail. %s APP is not install", hnadsf());
            hnadsa(hnadsh(), -2, this.hnadsf);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), str, new Object[0]);
            hnadsa(false, ErrorCode.c.hnadsa, 0, str, bVar);
            return;
        }
        HnAdConfig cfg = HnAds.get().getCfg();
        if (cfg != null && !TextUtils.isEmpty(cfg.getWxOpenAppId())) {
            hnadsa(cfg, bVar);
            return;
        }
        String str2 = String.format(Locale.ENGLISH, "startWeChatMiniApp#WeChat start mini app fail.case by:%s", cfg == null ? "hnAdConfig is null" : "wxOpenAppId is empty");
        hnadsa(str2, 1010, hnadsh(), -2, this.hnadsf);
        hnadsa(false, ErrorCode.c.hnadsa, 0, str2, bVar);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), str2, new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected boolean hnadsd() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.f.l.c
    protected String hnadsf() {
        return HnAds.get().getContext().getString(R.string.ads_app_name_we_chat);
    }

    @Override // com.hihonor.adsdk.base.f.l.c
    protected String hnadsg() {
        return (hnadsc() && !TextUtils.isEmpty(this.hnadsa.getAppPackage())) ? this.hnadsa.getAppPackage() : "com.tencent.mm";
    }

    protected abstract BaseReq hnadsj();

    private void hnadsa(HnAdConfig hnAdConfig, com.hihonor.adsdk.base.f.a.b bVar) {
        try {
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(HnAds.get().getContext(), hnAdConfig.getWxOpenAppId(), false);
            if (iwxapiCreateWXAPI.getWXAppSupportAPI() < 620823808) {
                String str = String.format(Locale.ENGLISH, "startWeChatMiniApp#WeChat unsupported start mini app.WX app support API is %s.", Integer.valueOf(iwxapiCreateWXAPI.getWXAppSupportAPI()));
                hnadsa(str, 1011, hnadsh(), -2, this.hnadsf);
                hnadsa(false, ErrorCode.c.hnadsa, 0, str, bVar);
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), str, new Object[0]);
                return;
            }
            BaseReq baseReqHnadsj = hnadsj();
            if (Objects.isNull(baseReqHnadsj)) {
                hnadsa("startWeChatMiniApp#send request to WeChat,but baseReq is null", 1012, hnadsh(), -2, this.hnadsf);
                hnadsa(false, ErrorCode.c.hnadsa, 0, "startWeChatMiniApp#send request to WeChat,but baseReq is null", bVar);
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), "startWeChatMiniApp#send request to WeChat,but baseReq is null", new Object[0]);
                return;
            }
            boolean zSendReq = iwxapiCreateWXAPI.sendReq(baseReqHnadsj);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "WeChatHandler# call start wechat result =" + zSendReq, new Object[0]);
            if (!zSendReq) {
                hnadsa("startWeChatMiniApp#send request to WeChat,but WeChat back fail.Result is false.", 1013, hnadsh(), -2, this.hnadsf);
                hnadsa(false, ErrorCode.c.hnadsa, 0, "startWeChatMiniApp#send request to WeChat,but WeChat back fail.Result is false.", bVar);
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "startWeChatMiniApp#send request to WeChat,but WeChat back fail.Result is false.", new Object[0]);
            } else {
                hnadsm();
                hnadsa(true, 0, 0, "WeChat Success", bVar);
            }
        } catch (Throwable th) {
            String str2 = String.format(Locale.ENGLISH, "startWeChatMiniApp#Media APP start mini app exception. msg = %s", th.getMessage());
            hnadsa(str2, 1014, hnadsh(), -2, this.hnadsf);
            hnadsa(false, ErrorCode.c.hnadsa, 0, str2, bVar);
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), str2, new Object[0]);
        }
    }
}

package com.meishu.sdk.platform.ms.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.ResultBean;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.meishu_ad.interstitial.c;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MeishuInterstitialAdAdapter extends InterstitialAd {
    private com.meishu.sdk.core.ad.interstitial.b apiAdListener;
    private c interstitialAd;

    public MeishuInterstitialAdAdapter(c cVar, com.meishu.sdk.core.ad.interstitial.b bVar) {
        super(null, "MS");
        this.interstitialAd = cVar;
        this.apiAdListener = bVar;
    }

    public com.meishu.sdk.core.ad.interstitial.b getAdListener() {
        return this.apiAdListener;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCid(this.interstitialAd.a().getCid());
        resultBean.setCat(this.interstitialAd.a().getCat());
        resultBean.setAderId(this.interstitialAd.a().getAder_id());
        resultBean.setFromId(this.interstitialAd.a().getFromId());
        resultBean.setDrawing(this.interstitialAd.a().getDrawing());
        resultBean.setPid(this.interstitialAd.a().getPosId());
        resultBean.setReqId(this.interstitialAd.a().getReq_id());
        resultBean.setPrice(this.interstitialAd.a().getEcpm());
        resultBean.setEcpm(this.interstitialAd.a().getEcpm() + "");
        resultBean.setS_code(this.interstitialAd.a().getS_code());
        resultBean.setS_ext(this.interstitialAd.a().getS_ext());
        resultBean.setSdkName("MS");
        resultBean.setAdInfo(com.meishu.sdk.core.utils.a.a((BaseAdSlot) this.interstitialAd.a()));
        return resultBean;
    }

    public String getDeepLink() {
        if (com.meishu.sdk.core.utils.a.a(this.interstitialAd.a().getAder_id())) {
            return this.interstitialAd.a().getDeep_link();
        }
        return null;
    }

    public String[] getImgUrls() {
        if (com.meishu.sdk.core.utils.a.a(this.interstitialAd.a().getAder_id())) {
            return this.interstitialAd.a().getImageUrls();
        }
        return null;
    }

    public boolean getIsOperationContent() {
        return com.meishu.sdk.core.utils.a.a(this.interstitialAd.a().getAder_id());
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = this.interstitialAd.a().getExpire_timestamp();
            return SystemClock.uptimeMillis() - this.interstitialAd.a().getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        z.a(AdSdk.getContext(), this.interstitialAd.a().getLossUrl(), (Map<String, Object>) map);
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        z.b(AdSdk.getContext(), this.interstitialAd.a().getWinUrl(), map);
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public void setInteractionListener(InteractionListener interactionListener) {
        super.setInteractionListener(interactionListener);
        c cVar = this.interstitialAd;
        if (cVar != null) {
            cVar.setInteractionListener(interactionListener);
        }
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        c cVar = this.interstitialAd;
        if (cVar != null) {
            cVar.getClass();
            try {
                cVar.a((Activity) cVar.f5023a.getContext());
            } catch (Throwable th) {
                com.meishu.sdk.meishu_ad.interstitial.a aVar = cVar.b;
                if (aVar != null) {
                    ((a) aVar).onAdRenderFail("插屏渲染失败,showAd", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
                }
                th.printStackTrace();
            }
            if (this.interstitialAd.a() != null) {
                o1.b(this.interstitialAd.a().getEventUrl());
            }
        }
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        c cVar = this.interstitialAd;
        if (cVar != null) {
            cVar.getClass();
            try {
                cVar.a(activity);
            } catch (Throwable th) {
                if (cVar.b != null) {
                    ((a) cVar.b).onAdRenderFail("插屏渲染失败,showAd", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
                }
                th.printStackTrace();
            }
            if (this.interstitialAd.a() != null) {
                o1.b(this.interstitialAd.a().getEventUrl());
            }
        }
    }
}

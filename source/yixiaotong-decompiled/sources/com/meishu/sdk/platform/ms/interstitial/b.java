package com.meishu.sdk.platform.ms.interstitial;

import android.util.Log;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.meishu_ad.e0;
import com.meishu.sdk.meishu_ad.interstitial.c;
import com.meishu.sdk.meishu_ad.v;
import com.meishu.sdk.platform.ms.g;

/* JADX INFO: compiled from: MeishuAdNativeWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends g<com.meishu.sdk.meishu_ad.interstitial.b, InterstitialAdLoader, com.meishu.sdk.core.ad.interstitial.b> {
    public v b;

    public b(InterstitialAdLoader interstitialAdLoader, com.meishu.sdk.meishu_ad.interstitial.b bVar) {
        super(interstitialAdLoader, bVar);
        this.b = new v(interstitialAdLoader.getContext());
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        Log.e("MeishuAdNativeWrapper", "loadAd: ");
        if (getLoaderListener() != 0) {
            ((com.meishu.sdk.core.ad.interstitial.b) getLoaderListener()).onAdLoaded(null);
        }
        v vVar = this.b;
        a aVar = new a(this, (com.meishu.sdk.core.ad.interstitial.b) getLoaderListener());
        vVar.getClass();
        com.meishu.sdk.meishu_ad.interstitial.b bVar = (com.meishu.sdk.meishu_ad.interstitial.b) this.f5177a;
        try {
            vVar.d = bVar.getEventUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bVar.getImageUrls() == null || bVar.getImageUrls().length == 0) {
            LogUtil.i("AdNative", "empty srcUrls");
            vVar.a(aVar, "empty srcUrls", ErrorCodeUtil.EMPTY_SRC_URL);
        } else {
            SdkHandler.getInstance().runOnUiThread(new e0(vVar, aVar, new c(this, aVar)));
        }
    }
}

package com.fancy;

import android.view.View;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _q {
    public static final _a _a = new _a();
    public static final _b _b = new _b();

    public class _a implements PtgNativeExpressAd.AdInteractionListener {
        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdDismiss() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(AdError adError) {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(View view) {
        }
    }

    public class _b implements PtgInteractionAd.AdInteractionListener {
        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdClicked() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdDismiss() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onAdShow() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgInteractionAd.AdInteractionListener
        public final void onRenderError(AdError adError) {
        }
    }
}

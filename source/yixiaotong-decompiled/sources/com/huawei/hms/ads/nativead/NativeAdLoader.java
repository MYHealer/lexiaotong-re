package com.huawei.hms.ads.nativead;

import android.content.Context;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.i;
import com.huawei.hms.ads.p;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class NativeAdLoader {
    private p Code;

    /* JADX INFO: renamed from: com.huawei.hms.ads.nativead.NativeAdLoader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private p Code;

        public Builder(Context context, String str) {
            this.Code = new i(context, str);
        }

        public NativeAdLoader build() {
            return new NativeAdLoader(this, null);
        }

        public Builder setAdListener(AdListener adListener) {
            this.Code.Code(adListener);
            return this;
        }

        public Builder setAdsReturnedFromThread(boolean z) {
            this.Code.Code(z);
            return this;
        }

        public Builder setNativeAdLoadedListener(NativeAd.NativeAdLoadedListener nativeAdLoadedListener) {
            this.Code.Code(nativeAdLoadedListener);
            return this;
        }

        public Builder setNativeAdOptions(NativeAdConfiguration nativeAdConfiguration) {
            this.Code.Code(nativeAdConfiguration);
            return this;
        }
    }

    private NativeAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    /* synthetic */ NativeAdLoader(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public boolean isLoading() {
        return this.Code.Code();
    }

    public void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }

    public void loadAds(AdParam adParam, int i) {
        this.Code.Code(adParam, i);
    }
}

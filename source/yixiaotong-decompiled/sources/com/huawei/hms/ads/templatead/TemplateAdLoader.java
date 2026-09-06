package com.huawei.hms.ads.templatead;

import android.content.Context;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.i;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.p;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class TemplateAdLoader {
    private p Code;

    /* JADX INFO: renamed from: com.huawei.hms.ads.templatead.TemplateAdLoader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private p Code;

        public Builder(Context context, String str) {
            this.Code = new i(context, str);
        }

        public TemplateAdLoader build() {
            return new TemplateAdLoader(this, null);
        }

        public Builder setAdListener(AdListener adListener) {
            this.Code.Code(adListener);
            return this;
        }

        public Builder setAdsReturnedFromThread(boolean z) {
            this.Code.Code(z);
            return this;
        }

        public Builder setNativeAdOptions(NativeAdConfiguration nativeAdConfiguration) {
            this.Code.Code(nativeAdConfiguration);
            return this;
        }

        public Builder setTemplateAdListener(TemplateAdListener templateAdListener) {
            return this;
        }
    }

    private TemplateAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    /* synthetic */ TemplateAdLoader(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public void loadNativeAd(AdParam adParam) {
        this.Code.Code(adParam);
    }
}

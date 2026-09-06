package com.huawei.hms.ads.instreamad;

import android.content.Context;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.aa;
import com.huawei.hms.ads.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class InstreamAdLoader {
    private z Code;

    /* JADX INFO: renamed from: com.huawei.hms.ads.instreamad.InstreamAdLoader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private z Code;

        public Builder(Context context, String str) {
            this.Code = new aa(context, str);
        }

        public InstreamAdLoader build() {
            return new InstreamAdLoader(this, null);
        }

        public Builder setInstreamAdLoadListener(InstreamAdLoadListener instreamAdLoadListener) {
            this.Code.Code(instreamAdLoadListener);
            return this;
        }

        public Builder setMaxCount(int i) {
            this.Code.V(i);
            return this;
        }

        public Builder setTotalDuration(int i) {
            this.Code.Code(i);
            return this;
        }
    }

    private InstreamAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    /* synthetic */ InstreamAdLoader(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public boolean isLoading() {
        return this.Code.Code();
    }

    public void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }
}

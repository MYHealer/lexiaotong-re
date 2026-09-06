package com.huawei.hms.ads.reward;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RewardVerifyConfig {
    private String Code;
    private String V;

    /* JADX INFO: renamed from: com.huawei.hms.ads.reward.RewardVerifyConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private String Code;
        private String V;

        public RewardVerifyConfig build() {
            return new RewardVerifyConfig(this, null);
        }

        public Builder setData(String str) {
            this.Code = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.V = str;
            return this;
        }
    }

    private RewardVerifyConfig() {
    }

    private RewardVerifyConfig(Builder builder) {
        if (builder != null) {
            this.Code = builder.Code;
            this.V = builder.V;
        }
    }

    /* synthetic */ RewardVerifyConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String getData() {
        return this.Code;
    }

    public String getUserId() {
        return this.V;
    }
}

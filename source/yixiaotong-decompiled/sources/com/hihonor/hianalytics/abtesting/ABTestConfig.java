package com.hihonor.hianalytics.abtesting;

import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.process.HiAnalyticsConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class ABTestConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HiAnalyticsConfig f3614a;
    private com.hihonor.hianalytics.hnha.a b;

    public static final class Builder {
        private HiAnalyticsConfig config;
        private int expSyncInterval = 1440;
        private String secretKey;
        private String url;
        private String userId;

        public ABTestConfig build() {
            return new ABTestConfig(this, null);
        }

        public Builder setExpSyncInterval(int i) {
            j2.c("ABTest/ABTestConfig", "setExpSyncInterval() is execute");
            if (i < 10) {
                j2.c("ABTest/ABTestConfig", " setExpSyncInterval : expSyncInterval check failed");
                i = 10;
            }
            this.expSyncInterval = i;
            return this;
        }

        public Builder setHiAnalyticsConfig(HiAnalyticsConfig hiAnalyticsConfig) {
            j2.c("ABTest/ABTestConfig", "setHiAnalyticsConfig() is execute");
            this.config = hiAnalyticsConfig;
            return this;
        }

        public Builder setSecretKey(String str) {
            j2.c("ABTest/ABTestConfig", "setSecretKey() is execute");
            if (TextUtils.isEmpty(str) || str.length() > 200) {
                j2.c("ABTest/ABTestConfig", " setSecretKey : secretKey check failed");
                str = "";
            }
            this.secretKey = str;
            return this;
        }

        public Builder setUrl(String str) {
            j2.c("ABTest/ABTestConfig", "setUrl() is execute");
            this.url = str;
            return this;
        }

        public Builder setUserId(String str) {
            j2.c("ABTest/ABTestConfig", "setUserId() is execute");
            if (TextUtils.isEmpty(str) || str.length() > 128) {
                j2.c("ABTest/ABTestConfig", " setUserId : userId check failed");
                str = "";
            }
            this.userId = str;
            return this;
        }
    }

    static /* synthetic */ class a {
    }

    private ABTestConfig(Builder builder) {
        this.f3614a = builder.config;
        com.hihonor.hianalytics.hnha.a aVar = new com.hihonor.hianalytics.hnha.a();
        this.b = aVar;
        aVar.b(builder.url);
        this.b.a(builder.secretKey);
        this.b.c(builder.userId);
        this.b.a(builder.expSyncInterval);
    }

    /* synthetic */ ABTestConfig(Builder builder, a aVar) {
        this(builder);
    }

    public com.hihonor.hianalytics.hnha.a a() {
        return this.b;
    }

    public HiAnalyticsConfig b() {
        return this.f3614a;
    }
}

package com.adprof.sdk.api;

import com.adprof.sdk.he;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AdprofSdkConfig {
    public String appId;
    public String appSecret;
    public String channelId;
    public boolean collectCrashInfo;
    public CustomController customController;
    public Map<String, Object> customData;
    public InitCallback initCallback;
    public boolean initOnWorkerThread;
    public boolean showLog;
    public boolean useHttps;
    public String userId;

    /* JADX INFO: renamed from: com.adprof.sdk.api.AdprofSdkConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CustomController f1046a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public InitCallback f65a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f66a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map f67a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f68a;
        public String b;
        public String c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f70c;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f69b = true;
        public boolean d = true;

        public Builder addCustomData(Map<String, Object> map) {
            this.f67a = map;
            return this;
        }

        public Builder appId(String str) {
            this.f66a = str;
            return this;
        }

        public Builder appSecret(String str) {
            this.b = str;
            return this;
        }

        public AdprofSdkConfig build() {
            if (this.f1046a == null) {
                this.f1046a = new CustomController(this) { // from class: com.adprof.sdk.api.AdprofSdkConfig.Builder.1
                    @Override // com.adprof.sdk.api.CustomController
                    public String getOaid() {
                        return he.m644a().i();
                    }
                };
            }
            return new AdprofSdkConfig(this);
        }

        public Builder customController(CustomController customController) {
            this.f1046a = customController;
            return this;
        }

        public Builder initOnWorkerThread(boolean z) {
            this.f70c = z;
            return this;
        }

        public Builder setInitCallback(InitCallback initCallback) {
            this.f65a = initCallback;
            return this;
        }

        public Builder showLog(boolean z) {
            this.f68a = z;
            return this;
        }

        public Builder useHttps(boolean z) {
            this.f69b = z;
            return this;
        }

        public Builder userId(String str) {
            this.c = str;
            return this;
        }
    }

    public AdprofSdkConfig(Builder builder) {
        this.useHttps = true;
        this.collectCrashInfo = true;
        this.appId = builder.f66a;
        this.appSecret = builder.b;
        this.userId = builder.c;
        this.customData = builder.f67a;
        this.customController = builder.f1046a;
        this.initCallback = builder.f65a;
        this.showLog = builder.f68a;
        this.useHttps = builder.f69b;
        this.initOnWorkerThread = builder.f70c;
        this.collectCrashInfo = builder.d;
    }
}

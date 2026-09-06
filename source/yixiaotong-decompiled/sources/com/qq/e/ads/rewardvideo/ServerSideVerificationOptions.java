package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ServerSideVerificationOptions {
    public static final String ACTION = "rewardAction";
    public static final String TRANS_ID = "transId";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8485a;
    private String b;
    private final JSONObject c;

    /* JADX INFO: renamed from: com.qq.e.ads.rewardvideo.ServerSideVerificationOptions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8486a;
        private String b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, null);
        }

        public Builder setCustomData(String str) {
            this.f8486a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.c = new JSONObject();
        this.f8485a = builder.f8486a;
        this.b = builder.b;
    }

    public String getCustomData() {
        return this.f8485a;
    }

    public JSONObject getOptions() {
        return this.c;
    }

    public String getUserId() {
        return this.b;
    }

    /* synthetic */ ServerSideVerificationOptions(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}

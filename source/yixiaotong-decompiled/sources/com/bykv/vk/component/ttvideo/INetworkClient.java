package com.bykv.vk.component.ttvideo;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface INetworkClient {

    /* JADX INFO: renamed from: com.bykv.vk.component.ttvideo.INetworkClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    Result doPost(String str, String str2);

    Result doRequest(String str, String str2);

    public static class Result {
        public final String body;
        public final int code;
        public final Exception e;
        public final String header;
        public final JSONObject response;

        /* synthetic */ Result(Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        private Result(Builder builder) {
            this.response = builder.response;
            this.body = builder.body;
            this.header = builder.header;
            this.e = builder.e;
            this.code = builder.code;
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        public static class Builder {
            String body;
            int code;
            Exception e;
            String header;
            JSONObject response;

            public Builder setBody(String str) {
                this.body = str;
                return this;
            }

            public Builder setCode(int i) {
                this.code = i;
                return this;
            }

            public Builder setException(Exception exc) {
                this.e = exc;
                return this;
            }

            public Builder setHeader(String str) {
                this.header = str;
                return this;
            }

            public Builder setResponse(JSONObject jSONObject) {
                this.response = jSONObject;
                return this;
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
            }

            public Result build() {
                return new Result(this, null);
            }
        }
    }
}

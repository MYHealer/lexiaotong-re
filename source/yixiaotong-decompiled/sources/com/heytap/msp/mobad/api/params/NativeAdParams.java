package com.heytap.msp.mobad.api.params;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class NativeAdParams {
    public final long fetchTimeout;

    public static class Builder {
        private static final long MAX_FETCH_TIMEOUT = 30000;
        private static final long MIX_FETCH_TIMEOUT = 500;
        private long fetchTimeout = MAX_FETCH_TIMEOUT;

        public NativeAdParams build() {
            return new NativeAdParams(this);
        }

        public Builder setFetchTimeout(long j) {
            if (j >= 500 && j <= MAX_FETCH_TIMEOUT) {
                this.fetchTimeout = j;
            }
            return this;
        }
    }

    public NativeAdParams(Builder builder) {
        this.fetchTimeout = builder.fetchTimeout;
    }

    public String toString() {
        return "NativeAdParams{fetchTimeout=" + this.fetchTimeout + '}';
    }
}

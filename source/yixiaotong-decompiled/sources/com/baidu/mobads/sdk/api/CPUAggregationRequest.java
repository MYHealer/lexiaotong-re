package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import com.hihonor.adsdk.base.g.j.e.a;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CPUAggregationRequest {
    private HashMap<String, Object> mParameters;

    /* JADX INFO: renamed from: com.baidu.mobads.sdk.api.CPUAggregationRequest$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
    }

    public HashMap<String, Object> getExtras() {
        return this.mParameters;
    }

    /* synthetic */ CPUAggregationRequest(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private CPUAggregationRequest(Builder builder) {
        this.mParameters = new HashMap<>();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters = builder.mExtras;
    }

    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public Builder setAccessType(int i) {
            this.mExtras.put("accessType", Integer.valueOf(i));
            return this;
        }

        public Builder setLpFontSize(CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public Builder setLpDarkMode(boolean z) {
            if (z) {
                this.mExtras.put("preferscolortheme", "dark");
            } else {
                this.mExtras.put("preferscolortheme", "light");
            }
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerUid", str);
            return this;
        }

        public Builder setSubChannelId(String str) {
            this.mExtras.put("subChannelId", str);
            return this;
        }

        public Builder setCity(String str) {
            this.mExtras.put(a.p, str);
            return this;
        }

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public CPUAggregationRequest build() {
            return new CPUAggregationRequest(this, null);
        }
    }
}

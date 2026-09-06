package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import com.hihonor.adsdk.base.g.j.e.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CPUWebAdRequestParam {
    private static final String DARK_MODE = "dark";
    private static final String LIGHT_MODE = "light";
    private final Map<String, Object> mParameters;

    /* JADX INFO: renamed from: com.baidu.mobads.sdk.api.CPUWebAdRequestParam$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
    }

    public Map<String, Object> getParameters() {
        return this.mParameters;
    }

    /* synthetic */ CPUWebAdRequestParam(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private CPUWebAdRequestParam(Builder builder) {
        HashMap map = new HashMap();
        this.mParameters = map;
        if (builder == null || builder.mExtras == null) {
            return;
        }
        map.putAll(builder.mExtras);
    }

    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerId", str);
            return this;
        }

        public Builder setSubChannelId(String str) {
            this.mExtras.put("scid", str);
            return this;
        }

        public Builder setLpDarkMode(boolean z) {
            this.mExtras.put("preferscolortheme", z ? CPUWebAdRequestParam.DARK_MODE : CPUWebAdRequestParam.LIGHT_MODE);
            return this;
        }

        public Builder setLpFontSize(CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public Builder setCityIfLocalChannel(String str) {
            this.mExtras.put(a.p, str);
            return this;
        }

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public CPUWebAdRequestParam build() {
            return new CPUWebAdRequestParam(this, null);
        }
    }
}

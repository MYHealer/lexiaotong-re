package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import com.hihonor.adsdk.base.c;
import com.hihonor.adsdk.base.g.j.e.a;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CPUAdRequest {
    private static final String TAG = "NativeCPUAd";
    private HashMap<String, Object> mParameters;

    /* JADX INFO: renamed from: com.baidu.mobads.sdk.api.CPUAdRequest$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
    }

    public HashMap<String, Object> getExtras() {
        return this.mParameters;
    }

    /* synthetic */ CPUAdRequest(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private CPUAdRequest(Builder builder) {
        this.mParameters = new HashMap<>();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters = builder.mExtras;
    }

    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerUid", str);
            return this;
        }

        public Builder setSubChannelId(String str) {
            this.mExtras.put("subChannelId", str);
            return this;
        }

        public Builder setListScene(int i) {
            this.mExtras.put("listScene", Integer.valueOf(i));
            return this;
        }

        public Builder setAccessType(int i) {
            this.mExtras.put("accessType", Integer.valueOf(i));
            return this;
        }

        @Deprecated
        public Builder setDownloadAppConfirmPolicy(int i) {
            this.mExtras.put("downloadAppConfirmPolicy", Integer.valueOf(i));
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

        public Builder setBarType(CpuLpActionBar cpuLpActionBar) {
            this.mExtras.put("customizedBar", cpuLpActionBar.getVlaue());
            return this;
        }

        public Builder setCityIfLocalChannel(String str) {
            this.mExtras.put("listScene", 6);
            this.mExtras.put(a.p, str);
            return this;
        }

        public Builder setKeyWords(String str) {
            this.mExtras.put(c.y.hnadsa, str);
            return this;
        }

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public CPUAdRequest build() {
            return new CPUAdRequest(this, null);
        }
    }
}

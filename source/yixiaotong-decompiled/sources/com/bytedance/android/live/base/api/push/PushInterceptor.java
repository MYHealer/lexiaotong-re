package com.bytedance.android.live.base.api.push;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface PushInterceptor {

    public static class InterceptResult {
        public boolean intercept;
        public String interceptReason;

        public InterceptResult() {
        }

        public InterceptResult(boolean z) {
            this(z, "");
        }

        public InterceptResult(boolean z, String str) {
            this.intercept = z;
            this.interceptReason = "";
        }
    }

    InterceptResult intercept();
}

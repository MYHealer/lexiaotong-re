package com.bytedance.sdk.openadsdk.mediation.init;

import com.byazt.zqa.c;
import com.umeng.analytics.pro.i;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@c(c = {0, 80, 81, 82, 83, 84, 1837})
public class MediationConfig implements IMediationConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f3109a;
    private String c;
    private boolean da;
    private boolean i;
    private boolean n;
    private String sl;
    private boolean sp;
    private boolean tt;
    private Map<String, Object> uj;
    private MediationConfigUserInfoForSegment ve;
    private String x;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.mediation.init.MediationConfig$1, reason: invalid class name */
    @c(c = {0, 80, 81, 82, 83, 84, 1527})
    static /* synthetic */ class AnonymousClass1 {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.f3109a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.uj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.ve;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.da;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.sp;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.sl;
    }

    /* synthetic */ MediationConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    private MediationConfig() {
    }

    @c(c = {0, 80, 81, 82, 83, 84, i.b})
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f3110a;
        private String c;
        private boolean da;
        private boolean i;
        private boolean n;
        private String sl;
        private boolean sp;
        private boolean tt;
        private Map<String, Object> uj;
        private MediationConfigUserInfoForSegment ve;
        private String x;

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.f3110a = jSONObject;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.n = z;
            return this;
        }

        @Deprecated
        public Builder setLocalExtra(Map<String, Object> map) {
            this.uj = map;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.ve = mediationConfigUserInfoForSegment;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.tt = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.x = str;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.c = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.i = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.da = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.sl = str;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.sp = z;
            return this;
        }

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig(null);
            mediationConfig.c = this.c;
            mediationConfig.tt = this.tt;
            mediationConfig.ve = this.ve;
            mediationConfig.uj = this.uj;
            mediationConfig.n = this.n;
            mediationConfig.f3109a = this.f3110a;
            mediationConfig.sp = this.sp;
            mediationConfig.x = this.x;
            mediationConfig.i = this.i;
            mediationConfig.da = this.da;
            mediationConfig.sl = this.sl;
            return mediationConfig;
        }
    }
}

package com.opos.cmn.an.custom.policy;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PolicyConfig {
    public final Map<String, Boolean> canReadUserDataMap;

    /* JADX INFO: renamed from: com.opos.cmn.an.custom.policy.PolicyConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, Boolean> f5881a;

        public PolicyConfig build() {
            return new PolicyConfig(this, null);
        }

        public Builder setCanReadUserDataMap(Map<String, Boolean> map) {
            if (map != null && map.size() > 0) {
                Map<String, Boolean> map2 = this.f5881a;
                if (map2 == null) {
                    this.f5881a = new HashMap();
                } else {
                    map2.clear();
                }
                this.f5881a.putAll(map);
            }
            return this;
        }
    }

    public static class UserData {
        public static final String KEY_ANDROID_ID = "opos_android_id";
        public static final String KEY_IMEI = "opos_imei";
        public static final String KEY_SN = "opos_sn";
    }

    private PolicyConfig(Builder builder) {
        this.canReadUserDataMap = builder.f5881a;
    }

    /* synthetic */ PolicyConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String toString() {
        return "PolicyConfig{canReadUserDataMap=" + this.canReadUserDataMap + '}';
    }
}

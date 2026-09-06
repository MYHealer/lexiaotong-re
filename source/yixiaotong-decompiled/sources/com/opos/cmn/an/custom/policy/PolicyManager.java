package com.opos.cmn.an.custom.policy;

import android.text.TextUtils;
import com.opos.cmn.an.f.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PolicyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f5882a = new byte[0];
    private static volatile PolicyManager b;
    private PolicyConfig c = null;

    private PolicyManager() {
    }

    public static PolicyManager getInstance() {
        if (b == null) {
            synchronized (f5882a) {
                if (b == null) {
                    b = new PolicyManager();
                }
            }
        }
        return b;
    }

    public boolean canReadUserData(String str) {
        PolicyConfig policyConfig;
        boolean zBooleanValue = (TextUtils.isEmpty(str) || (policyConfig = this.c) == null || policyConfig.canReadUserDataMap == null || !this.c.canReadUserDataMap.containsKey(str)) ? true : this.c.canReadUserDataMap.get(str).booleanValue();
        a.b("PolicyManager", "canReadUserData key=" + str + ",value=" + zBooleanValue);
        return zBooleanValue;
    }

    public PolicyConfig getPolicyConfig() {
        return this.c;
    }

    public synchronized void setPolicyConfig(PolicyConfig policyConfig) {
        if (this.c == null && policyConfig != null) {
            this.c = policyConfig;
        }
        a.b("PolicyManager", "setPolicyConfig mPolicyConfig=" + this.c);
    }
}

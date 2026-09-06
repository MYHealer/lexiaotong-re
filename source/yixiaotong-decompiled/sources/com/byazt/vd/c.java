package com.byazt.vd;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.dd;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1582, 20})
public abstract class c {
    public static final HashSet<String> c = new HashSet<>(Arrays.asList("convert", com.byazt.dyf.tt.AD_TAG_DISLIKE, "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", "close", dd.F, "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f2812a;
    public String n;
    public String sp;
    public com.byazt.pm.a.c tt;
    public String uj;
    public com.byazt.xj.ve ve;
    public String x;

    public abstract void c();

    public c(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
        this.ve = veVar;
        this.tt = cVar;
        this.sp = str;
        n();
    }

    private void n() {
        com.byazt.pm.a.c cVar = this.tt;
        if (cVar == null) {
            return;
        }
        this.uj = cVar.c();
        this.n = this.tt.tt();
        Map<String, Object> mapVe = this.tt.ve();
        this.f2812a = mapVe;
        if (mapVe == null || mapVe.isEmpty() || !this.f2812a.containsKey("emitCustomEvent") || !(this.f2812a.get("emitCustomEvent") instanceof String)) {
            return;
        }
        this.x = (String) this.f2812a.get("emitCustomEvent");
    }

    public void tt() {
        ve();
    }

    public void ve() {
        if (uj()) {
            com.byazt.pm.a.c cVar = new com.byazt.pm.a.c();
            cVar.c(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
            cVar.tt("emit");
            HashMap map = new HashMap();
            map.put("name", this.x);
            cVar.c(map);
            new tt(this.ve, this.n, cVar).c();
        }
    }

    public boolean uj() {
        return !TextUtils.isEmpty(this.x);
    }

    /* JADX INFO: renamed from: com.byazt.vd.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1582, 44})
    public static class C0303c {
        public static c c(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
            if (cVar == null) {
                return null;
            }
            com.byazt.pm.tt ttVarC = com.byazt.pm.uj.c(cVar.tt());
            if (ttVarC == null && (TextUtils.isEmpty(cVar.c()) || !TextUtils.equals(cVar.c(), "global"))) {
                ttVarC = com.byazt.pm.uj.c(cVar.n());
            }
            if (ttVarC == null) {
                return new ve(veVar, str, cVar);
            }
            c cVarC = ttVarC.c(veVar, str, cVar);
            return cVarC == null ? new ve(veVar, str, cVar) : cVarC;
        }
    }
}

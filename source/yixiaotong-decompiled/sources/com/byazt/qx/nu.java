package com.byazt.qx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.meishu.sdk.activity.MeishuOpenDeepLinkActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 163, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME})
public class nu extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.ete.ic c;

    public nu(com.byazt.ete.ic icVar) {
        this.c = icVar;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.ete.ic icVar) {
        nuVar.c("getLiveSaasAuthStatus", (com.byazt.pct.n<?, ?>) new nu(icVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        com.byazt.ete.sv svVarC;
        com.byazt.ete.ic icVar;
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.ete.nu nuVar = null;
        if (jSONObject != null) {
            try {
                svVarC = com.byazt.ete.sv.c(jSONObject.optJSONObject("live_info"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MeishuOpenDeepLinkActivity.KEY_DEEP_LINK);
                if (jSONObjectOptJSONObject != null) {
                    nuVar = new com.byazt.ete.nu(jSONObjectOptJSONObject);
                }
            } catch (Throwable th) {
                com.byazt.nr.m.uj("glsas", "method:" + th.getMessage());
            }
        } else {
            svVarC = null;
        }
        if (nuVar == null && (icVar = this.c) != null) {
            nuVar = icVar.yp();
        }
        if (svVarC == null) {
            svVarC = this.c.sl();
        }
        boolean z = true;
        jSONObject2.put("has_live_silent_auth", svVarC != null && svVarC.ve());
        jSONObject2.put("has_install_douyin", com.byazt.wu.c.c(nuVar));
        jSONObject2.put("has_live_authed", com.byazt.apd.tt.c().n() == 2);
        boolean z2 = svVarC != null && svVarC.uj();
        if (z2) {
            if (com.byazt.apd.tt.c().ve() != 2) {
                z = false;
            }
            z2 = z;
        }
        jSONObject2.put("has_playable_auth_switch", z2);
        JSONObject jSONObject3 = new JSONObject();
        if (svVarC != null) {
            jSONObject3.put("aweme_agreements", svVarC.n());
            jSONObject3.put("aweme_privacy", svVarC.a());
        }
        jSONObject2.put("aweme_auth_protocol", jSONObject3);
        return jSONObject2;
    }
}

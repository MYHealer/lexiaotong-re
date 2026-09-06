package com.byazt.du;

import com.byazt.nr.m;
import com.byazt.xl.u;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ads.ClickAreaSource;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 441, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp implements x {
    public com.byazt.wl.tt c;

    @Override // com.byazt.du.x
    public void c(com.byazt.wl.tt ttVar) {
        this.c = ttVar;
    }

    @Override // com.byazt.du.x
    public void c(final u uVar) {
        if (uVar.yp() == 1) {
            tt(uVar);
        } else {
            com.byazt.or.n.c(new com.byazt.bwm.sp("dynamicparse") { // from class: com.byazt.du.sp.1
                @Override // java.lang.Runnable
                public void run() {
                    sp.this.tt(uVar);
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(u uVar) {
        try {
            JSONObject jSONObjectN = uVar.n();
            JSONObject jSONObject = new JSONObject(jSONObjectN.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectN.optJSONObject(ClickAreaSource.CREATIVE);
            com.byazt.aq.x xVarC = new a(jSONObject, jSONObjectOptJSONObject, jSONObjectN.optJSONObject("AdSize"), new JSONObject(jSONObjectN.optString("diff_template_Plugin"))).c(uVar.uj(), uVar.t(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), uVar);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("dynamic_creative"));
                xVarC.c(jSONObject2.optString("color"));
                xVarC.c(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.c.c(xVarC);
        } catch (Exception e) {
            m.c(e);
        }
    }
}

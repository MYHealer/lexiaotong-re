package com.byazt.cj;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z implements com.byazt.kkb.ve {

    @com.byazt.ls.c(c = "label")
    public String c;

    @com.byazt.ls.c(c = "log_extra")
    public String tt;

    @com.byazt.ls.c(c = "material_meta")
    public ic ve;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        if (!c()) {
            com.byazt.nr.m.uj("UChain_ReportEventAction", "ifHasAllRequiredParam = false");
            cVar.c(map2, (com.byazt.qb.c) null);
            return false;
        }
        JSONObject jSONObjectC = c(map);
        com.byazt.ddx.uj.tt(this.ve, nb.tt(this.ve), this.c, jSONObjectC);
        cVar.c(map2);
        return true;
    }

    private JSONObject c(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add("label");
            hashSet.add("ad_id");
            hashSet.add("log_extra");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!hashSet.contains(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private boolean c() {
        return (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.tt) || this.ve == null) ? false : true;
    }
}

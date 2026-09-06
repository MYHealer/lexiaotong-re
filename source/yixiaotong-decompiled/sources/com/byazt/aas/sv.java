package com.byazt.aas;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BARRAGE_MASK})
public class sv extends com.byazt.va.n {
    public sv(com.byazt.gqp.t tVar) {
        super(tVar);
    }

    public void c(JSONObject jSONObject, String str) {
        Pair<Integer, ?> pairC;
        try {
            pairC = com.byazt.by.a.c().c(jSONObject.toString(), str);
        } catch (Throwable th) {
            com.byazt.nr.m.ve(th.getMessage());
            pairC = null;
        }
        if (pairC != null && pairC.first != null) {
            if (((Integer) pairC.first).intValue() == 4) {
                c("application/octet-stream", (byte[]) pairC.second);
                c(true);
                tt("x-pglcypher", String.valueOf(pairC.first));
                return;
            }
            c((JSONObject) pairC.second);
            return;
        }
        com.byazt.ukr.yp.c().c(-1, -1L, str, -1);
        ve(com.byazt.nr.c.c(jSONObject).toString());
    }

    public void tt(JSONObject jSONObject, String str) {
        if (com.byazt.omf.gt.tt().sd()) {
            c(jSONObject, str);
        } else {
            ve(com.byazt.nr.c.c(jSONObject).toString());
        }
    }

    public void ve(JSONObject jSONObject, String str) {
        if (com.byazt.omf.gt.tt().di()) {
            c(jSONObject, str);
        } else {
            ve(com.byazt.nr.c.c(jSONObject).toString());
        }
    }
}

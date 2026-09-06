package com.byazt.lr;

import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 155, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public static void c(String str, long j) {
        com.byazt.nn.n nVarN = com.byazt.nn.a.c().n(j);
        if (nVarN.gr()) {
            return;
        }
        nVarN.ve.setRefer(str);
        com.byazt.zn.c.c().tt("lp_app_dialog_click", nVarN);
    }

    public static void tt(String str, long j) {
        c(str, null, j);
    }

    public static void c(String str, JSONObject jSONObject, long j) {
        com.byazt.zn.c.c().tt(str, jSONObject, com.byazt.nn.a.c().n(j));
    }

    public static void c(String str, com.byazt.nn.n nVar) {
        com.byazt.zn.c.c().tt(str, nVar);
    }

    public static void c(int i, com.byazt.nn.n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.zn.c.c().tt("lp_compliance_error", jSONObject, nVar);
    }

    public static void c(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.zn.c.c().tt("lp_compliance_error", jSONObject, com.byazt.nn.a.c().n(j));
    }
}

package com.byazt.bnf;

import android.text.TextUtils;
import com.byazt.nr.gt;
import com.byazt.omf.p;
import com.byazt.vif.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 20})
public final class c {
    public static String c(com.byazt.dna.c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "ads_layer_default";
        }
        if (tt()) {
            str = uj(cVar, str);
        }
        return c(str, cVar != null && cVar.isSupportMultiProcess(), cVar.getAppId());
    }

    public static String tt(com.byazt.dna.c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "ads_global_default";
        }
        if (tt()) {
            str = uj(cVar, str) + "_global";
        }
        return c(str, cVar != null && cVar.isSupportMultiProcess(), cVar.getAppId());
    }

    public static String ve(com.byazt.dna.c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "ads_version_default";
        }
        if (tt()) {
            str = uj(cVar, str);
        }
        return c(str, cVar != null && cVar.isSupportMultiProcess(), cVar.getAppId());
    }

    private static String c(String str, boolean z, String str2) {
        return (z || gt.c(com.byazt.omf.gt.getContext()) || !uj.tt()) ? str : str + gt.tt(com.byazt.omf.gt.getContext());
    }

    private static boolean tt() {
        if (c()) {
            return false;
        }
        return uj.c();
    }

    private static String uj(com.byazt.dna.c cVar, String str) {
        return (cVar == null || TextUtils.isEmpty(cVar.getAppId())) ? str : cVar.getAppId() + "_" + str;
    }

    public static boolean c() {
        return p.uj < 7500;
    }
}

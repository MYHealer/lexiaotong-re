package com.byazt.eu;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 15})
public class uj {
    public static String c() {
        return "TTMediationSDK_";
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return c();
        }
        return "TTMediationSDK_" + str + "_";
    }

    public static String c(com.byazt.nbs.tt ttVar) {
        if (ttVar == null || TextUtils.isEmpty(ttVar.nb())) {
            return c();
        }
        return "TTMediationSDK_" + ttVar.nb() + "_";
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return c();
        }
        if (TextUtils.isEmpty(str2)) {
            return c(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }

    public static String tt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return c();
        }
        if (TextUtils.isEmpty(str2)) {
            return c(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }
}

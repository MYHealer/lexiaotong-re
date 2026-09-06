package com.byazt.pct;

import android.text.TextUtils;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.NewDevice4GDrinkOTA_1, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public final class gr {
    public static boolean c;

    public static String c() {
        return "";
    }

    public static void c(boolean z) {
        c = z;
    }

    public static String c(Throwable th) {
        return "{\"code\":" + (th instanceof rh ? ((rh) th).c : 0) + com.alipay.sdk.util.i.d;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String strSubstring = c ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!strSubstring.isEmpty()) {
            return str2 + "," + strSubstring + com.alipay.sdk.util.i.d;
        }
        return str2 + com.alipay.sdk.util.i.d;
    }
}

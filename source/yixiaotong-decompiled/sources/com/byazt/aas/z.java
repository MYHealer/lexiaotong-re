package com.byazt.aas;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z {
    public static volatile String c;
    public static String tt;

    public static void c(String str) {
        if (com.byazt.lkt.c.c() != null) {
            com.byazt.lkt.c.c().c(str);
        }
        if (TextUtils.isEmpty(str) || str.equals(c)) {
            return;
        }
        com.byazt.omf.tt.c().put("did", str);
        c = str;
    }

    public static String c() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String str = com.byazt.omf.tt.c().get("did", tt);
        c = str;
        return str;
    }
}

package com.byazt.zb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 184, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public static c c;

    public interface c {
        void c(String str, String str2, Throwable th);
    }

    public static void c(c cVar) {
        c = cVar;
    }

    public static boolean c() {
        return c != null;
    }

    public static void c(String str, String str2, Throwable th) {
        if (c == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        c.c(str, str2, th);
    }
}

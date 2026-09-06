package com.byazt.rx;

import android.os.Handler;
import android.os.HandlerThread;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 152, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public static volatile HandlerThread c;
    public static volatile Handler tt;
    public static volatile Handler ve;

    public static HandlerThread c() {
        if (c == null) {
            synchronized (sp.class) {
                if (c == null) {
                    HandlerThread handlerThread = new HandlerThread("default_npth_thread");
                    c = handlerThread;
                    handlerThread.start();
                    tt = new Handler(c.getLooper());
                }
            }
        }
        return c;
    }

    public static Handler tt() {
        if (tt == null) {
            c();
        }
        return tt;
    }
}

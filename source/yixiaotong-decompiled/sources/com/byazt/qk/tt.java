package com.byazt.qk;

import android.os.Handler;
import android.os.Looper;
import com.byazt.nr.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 13})
public class tt {
    public static final Handler c = new Handler(Looper.getMainLooper());

    public static void c(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            c.post(runnable);
        }
    }

    public static void tt(Runnable runnable) {
        c.post(runnable);
    }

    public static void ve(Runnable runnable) {
        da.ve().post(runnable);
    }
}

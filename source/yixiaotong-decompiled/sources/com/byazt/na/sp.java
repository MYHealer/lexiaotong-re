package com.byazt.na;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 662, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public final class sp {
    public static a c;
    public static long tt;

    private sp() {
    }

    public static a c() {
        synchronized (sp.class) {
            a aVar = c;
            if (aVar != null) {
                c = aVar.f2489a;
                aVar.f2489a = null;
                tt -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return aVar;
            }
            return new a();
        }
    }

    public static void c(a aVar) {
        if (aVar.f2489a != null || aVar.sp != null) {
            throw new IllegalArgumentException();
        }
        if (aVar.uj) {
            return;
        }
        synchronized (sp.class) {
            long j = tt;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            tt = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            aVar.f2489a = c;
            aVar.ve = 0;
            aVar.tt = 0;
            c = aVar;
        }
    }
}

package com.byazt.gqp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME})
public abstract class nu implements Closeable {
    public abstract long c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract da n();

    public abstract String tt();

    public abstract byte[] uj();

    public abstract InputStream ve();
}

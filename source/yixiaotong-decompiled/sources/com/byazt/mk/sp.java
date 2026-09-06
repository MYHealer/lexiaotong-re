package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public abstract class sp implements rh {
    public final rh c;

    public sp(rh rhVar) {
        if (rhVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.c = rhVar;
    }

    @Override // com.byazt.mk.rh
    public void a_(ve veVar, long j) throws IOException {
        this.c.a_(veVar, j);
    }

    @Override // com.byazt.mk.rh, java.io.Flushable
    public void flush() throws IOException {
        this.c.flush();
    }

    @Override // com.byazt.mk.rh
    public gt c() {
        return this.c.c();
    }

    @Override // com.byazt.mk.rh, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.c.toString() + ")";
    }
}

package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 71})
public abstract class x implements my {
    public final my c;

    public final my tt() {
        return this.c;
    }

    public x(my myVar) {
        if (myVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.c = myVar;
    }

    @Override // com.byazt.mk.my
    public long c(ve veVar, long j) throws IOException {
        return this.c.c(veVar, j);
    }

    @Override // com.byazt.mk.my
    public gt c() {
        return this.c.c();
    }

    @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.c.toString() + ")";
    }
}

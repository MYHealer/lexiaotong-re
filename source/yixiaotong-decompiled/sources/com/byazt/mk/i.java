package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 42})
public class i extends gt {
    public gt c;

    public final gt c() {
        return this.c;
    }

    public i(gt gtVar) {
        if (gtVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.c = gtVar;
    }

    public final i c(gt gtVar) {
        if (gtVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.c = gtVar;
        return this;
    }

    @Override // com.byazt.mk.gt
    public gt c(long j, TimeUnit timeUnit) {
        return this.c.c(j, timeUnit);
    }

    @Override // com.byazt.mk.gt
    public long n_() {
        return this.c.n_();
    }

    @Override // com.byazt.mk.gt
    public boolean ve() {
        return this.c.ve();
    }

    @Override // com.byazt.mk.gt
    public long o_() {
        return this.c.o_();
    }

    @Override // com.byazt.mk.gt
    public gt c(long j) {
        return this.c.c(j);
    }

    @Override // com.byazt.mk.gt
    public gt n() {
        return this.c.n();
    }

    @Override // com.byazt.mk.gt
    public gt a() {
        return this.c.a();
    }

    @Override // com.byazt.mk.gt
    public void sp() throws IOException {
        this.c.sp();
    }
}

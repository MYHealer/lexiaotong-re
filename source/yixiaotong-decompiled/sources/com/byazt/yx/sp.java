package com.byazt.yx;

import com.byazt.eg.gt;
import com.byazt.eg.h;
import com.byazt.eg.m;
import com.byazt.eg.yv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public final class sp implements gt.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yv f2904a;
    public final List<gt> c;
    public final int da;
    public final int i;
    public final int n;
    public final int sl;
    public final com.byazt.eg.n sp;
    public int t;
    public final com.byazt.iq.sp tt;
    public final com.byazt.iq.ve uj;
    public final ve ve;
    public final m x;

    public com.byazt.iq.sp a() {
        return this.tt;
    }

    @Override // com.byazt.eg.gt.c
    public yv c() {
        return this.f2904a;
    }

    @Override // com.byazt.eg.gt.c
    public com.byazt.eg.n call() {
        return this.sp;
    }

    public com.byazt.eg.i n() {
        return this.uj;
    }

    public ve sp() {
        return this.ve;
    }

    @Override // com.byazt.eg.gt.c
    public int tt() {
        return this.i;
    }

    @Override // com.byazt.eg.gt.c
    public int uj() {
        return this.sl;
    }

    @Override // com.byazt.eg.gt.c
    public int ve() {
        return this.da;
    }

    public m x() {
        return this.x;
    }

    public sp(List<gt> list, com.byazt.iq.sp spVar, ve veVar, com.byazt.iq.ve veVar2, int i, yv yvVar, com.byazt.eg.n nVar, m mVar, int i2, int i3, int i4) {
        this.c = list;
        this.uj = veVar2;
        this.tt = spVar;
        this.ve = veVar;
        this.n = i;
        this.f2904a = yvVar;
        this.sp = nVar;
        this.x = mVar;
        this.i = i2;
        this.da = i3;
        this.sl = i4;
    }

    @Override // com.byazt.eg.gt.c
    public h c(yv yvVar) throws IOException {
        return c(yvVar, this.tt, this.ve, this.uj);
    }

    public h c(yv yvVar, com.byazt.iq.sp spVar, ve veVar, com.byazt.iq.ve veVar2) throws IOException {
        if (this.n >= this.c.size()) {
            throw new AssertionError();
        }
        this.t++;
        if (this.ve != null && !this.uj.c(yvVar.c())) {
            throw new IllegalStateException("network interceptor " + this.c.get(this.n - 1) + " must retain the same host and port");
        }
        if (this.ve != null && this.t > 1) {
            throw new IllegalStateException("network interceptor " + this.c.get(this.n - 1) + " must call proceed() exactly once");
        }
        sp spVar2 = new sp(this.c, spVar, veVar, veVar2, this.n + 1, yvVar, this.sp, this.x, this.i, this.da, this.sl);
        gt gtVar = this.c.get(this.n);
        h hVarC = gtVar.c(spVar2);
        if (veVar != null && this.n + 1 < this.c.size() && spVar2.t != 1) {
            throw new IllegalStateException("network interceptor " + gtVar + " must call proceed() exactly once");
        }
        if (hVarC == null) {
            throw new NullPointerException("interceptor " + gtVar + " returned a null response");
        }
        if (hVarC.x() != null) {
            return hVarC;
        }
        throw new IllegalStateException("interceptor " + gtVar + " returned a response with no body");
    }
}

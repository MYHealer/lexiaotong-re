package com.byazt.zy;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1698, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2939a;
    public final String n;
    public final com.byazt.dg.c<Integer, Integer> sp;
    public final com.byazt.zk.ve uj;
    public com.byazt.dg.c<ColorFilter, ColorFilter> x;

    public gt(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.rh rhVar) {
        super(xVar, veVar, rhVar.sp().c(), rhVar.x().c(), rhVar.i(), rhVar.ve(), rhVar.uj(), rhVar.n(), rhVar.a());
        this.uj = veVar;
        this.n = rhVar.c();
        this.f2939a = rhVar.da();
        com.byazt.dg.c<Integer, Integer> cVarC = rhVar.tt().c();
        this.sp = cVarC;
        cVarC.c(this);
        veVar.c(cVarC);
    }

    @Override // com.byazt.zy.c, com.byazt.zy.n
    public void c(Canvas canvas, Matrix matrix, int i) {
        if (this.f2939a) {
            return;
        }
        this.tt.setColor(((com.byazt.dg.tt) this.sp).i());
        if (this.x != null) {
            this.tt.setColorFilter(this.x.sp());
        }
        super.c(canvas, matrix, i);
    }
}

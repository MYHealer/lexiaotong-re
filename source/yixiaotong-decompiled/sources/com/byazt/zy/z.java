package com.byazt.zy;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1698, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z implements sl, u, com.byazt.dg.c.InterfaceC0132c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.dg.c<?, PointF> f2949a;
    public final com.byazt.ga.x n;
    public boolean sl;
    public final com.byazt.dg.c<?, PointF> sp;
    public final boolean uj;
    public final String ve;
    public final com.byazt.dg.c<?, Float> x;
    public final Path c = new Path();
    public final RectF tt = new RectF();
    public final tt i = new tt();
    public com.byazt.dg.c<Float, Float> da = null;

    public z(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.sl slVar) {
        this.ve = slVar.c();
        this.uj = slVar.n();
        this.n = xVar;
        com.byazt.dg.c<PointF, PointF> cVarC = slVar.uj().c();
        this.f2949a = cVarC;
        com.byazt.dg.c<PointF, PointF> cVarC2 = slVar.ve().c();
        this.sp = cVarC2;
        com.byazt.dg.c<Float, Float> cVarC3 = slVar.tt().c();
        this.x = cVarC3;
        veVar.c(cVarC);
        veVar.c(cVarC2);
        veVar.c(cVarC3);
        cVarC.c(this);
        cVarC2.c(this);
        cVarC3.c(this);
    }

    @Override // com.byazt.dg.c.InterfaceC0132c
    public void c() {
        tt();
    }

    private void tt() {
        this.sl = false;
        this.n.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[SYNTHETIC] */
    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        for (int i = 0; i < list.size(); i++) {
            ve veVar = list.get(i);
            if (veVar instanceof rl) {
                rl rlVar = (rl) veVar;
                if (rlVar.getType() == com.byazt.jx.my.c.SIMULTANEOUSLY) {
                    this.i.c(rlVar);
                    rlVar.c(this);
                } else if (veVar instanceof nu) {
                    this.da = ((nu) veVar).tt();
                }
            } else if (veVar instanceof nu) {
                this.da = ((nu) veVar).tt();
            }
        }
    }

    @Override // com.byazt.zy.u
    public Path uj() {
        com.byazt.dg.c<Float, Float> cVar;
        if (this.sl) {
            return this.c;
        }
        this.c.reset();
        if (this.uj) {
            this.sl = true;
            return this.c;
        }
        PointF pointFSp = this.sp.sp();
        float f = pointFSp.x / 2.0f;
        float f2 = pointFSp.y / 2.0f;
        com.byazt.dg.c<?, Float> cVar2 = this.x;
        float fI = cVar2 == null ? 0.0f : ((com.byazt.dg.uj) cVar2).i();
        if (fI == 0.0f && (cVar = this.da) != null) {
            fI = Math.min(cVar.sp().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fI > fMin) {
            fI = fMin;
        }
        PointF pointFSp2 = this.f2949a.sp();
        this.c.moveTo(pointFSp2.x + f, (pointFSp2.y - f2) + fI);
        this.c.lineTo(pointFSp2.x + f, (pointFSp2.y + f2) - fI);
        if (fI > 0.0f) {
            float f3 = fI * 2.0f;
            this.tt.set((pointFSp2.x + f) - f3, (pointFSp2.y + f2) - f3, pointFSp2.x + f, pointFSp2.y + f2);
            this.c.arcTo(this.tt, 0.0f, 90.0f, false);
        }
        this.c.lineTo((pointFSp2.x - f) + fI, pointFSp2.y + f2);
        if (fI > 0.0f) {
            float f4 = fI * 2.0f;
            this.tt.set(pointFSp2.x - f, (pointFSp2.y + f2) - f4, (pointFSp2.x - f) + f4, pointFSp2.y + f2);
            this.c.arcTo(this.tt, 90.0f, 90.0f, false);
        }
        this.c.lineTo(pointFSp2.x - f, (pointFSp2.y - f2) + fI);
        if (fI > 0.0f) {
            float f5 = fI * 2.0f;
            this.tt.set(pointFSp2.x - f, pointFSp2.y - f2, (pointFSp2.x - f) + f5, (pointFSp2.y - f2) + f5);
            this.c.arcTo(this.tt, 180.0f, 90.0f, false);
        }
        this.c.lineTo((pointFSp2.x + f) - fI, pointFSp2.y - f2);
        if (fI > 0.0f) {
            float f6 = fI * 2.0f;
            this.tt.set((pointFSp2.x + f) - f6, pointFSp2.y - f2, pointFSp2.x + f, (pointFSp2.y - f2) + f6);
            this.c.arcTo(this.tt, 270.0f, 90.0f, false);
        }
        this.c.close();
        this.i.c(this.c);
        this.sl = true;
        return this.c;
    }
}

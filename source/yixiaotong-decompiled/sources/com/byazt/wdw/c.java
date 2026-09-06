package com.byazt.wdw;

import android.content.Context;
import android.view.View;
import com.byazt.aas.pf;
import com.byazt.ete.da;
import com.byazt.ete.gr;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 20})
public class c extends tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2837a;
    public com.byazt.ouz.ve n;

    public void c(int i) {
        this.f2837a = i;
    }

    public void c(com.byazt.ouz.ve veVar) {
        this.n = veVar;
    }

    public c() {
    }

    public c(ic icVar, Context context) {
        this.c = icVar;
        this.tt = context;
    }

    @Override // com.byazt.zo.c
    public void c(View view) {
        this.uj = view;
    }

    @Override // com.byazt.zo.c
    public int c(Map<String, Object> map, com.byazt.zo.ve veVar) {
        if (this.n == null) {
            return 0;
        }
        if (this.ve == null) {
            this.ve = new da();
        }
        View viewI = this.ve.i();
        int[] iArrC = new int[2];
        int[] iArrVe = new int[2];
        if (viewI != null) {
            iArrC = pf.c(viewI);
            iArrVe = pf.ve(viewI);
        }
        this.n.c(this.uj, this.f2837a, new gr.c().uj(this.ve.nu()).ve(this.ve.rh()).tt(this.ve.my()).c(this.ve.gt()).tt(this.ve.z()).c(this.ve.m()).c(iArrC[0]).tt(iArrC[1]).ve(iArrVe[0]).uj(iArrVe[1]).c(this.ve.x()).c(this.ve.u()).c());
        return 1;
    }
}

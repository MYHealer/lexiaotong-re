package com.byazt.dqg;

import android.view.View;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.iym.RewardDrawRecyclerView;
import com.byazt.iym.RewardGuideSlideUp;
import com.byazt.kt.RecyclerView;
import com.byazt.lcf.TTBaseVideoActivity;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 74, 15})
public class uj extends tt {
    public float gt;
    public RewardDrawRecyclerView m;
    public float my;
    public com.byazt.iym.c nu;
    public boolean qy;
    public com.byazt.iym.ve rh;
    public boolean rl;
    public boolean yp;
    public RewardGuideSlideUp z;

    public RecyclerView tt() {
        return this.m;
    }

    public com.byazt.iym.ve uj() {
        return this.rh;
    }

    public com.byazt.iym.c ve() {
        return this.nu;
    }

    public uj(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, boolean z) {
        super(tTBaseVideoActivity, icVar, z);
        this.rl = true;
    }

    public void c(float[] fArr) {
        this.my = fArr[0];
        this.gt = fArr[1];
    }

    @Override // com.byazt.dqg.tt
    public void c() {
        super.c();
        this.m = (RewardDrawRecyclerView) this.sp.findViewById(2114387885);
        com.byazt.iym.ve veVar = new com.byazt.iym.ve(this.tt, 0, false);
        this.rh = veVar;
        this.m.setLayoutManager(veVar);
        com.byazt.iym.c cVar = new com.byazt.iym.c(this.tt, this.my, this.gt);
        this.nu = cVar;
        this.m.setAdapter(cVar);
        if (this.yp) {
            RewardGuideSlideUp rewardGuideSlideUp = (RewardGuideSlideUp) this.sp.findViewById(2114387966);
            this.z = rewardGuideSlideUp;
            rewardGuideSlideUp.c();
        }
    }

    public void n() {
        if (this.yp && this.rl) {
            this.sp.postDelayed(new Runnable() { // from class: com.byazt.dqg.uj.1
                @Override // java.lang.Runnable
                public void run() {
                    if (uj.this.yp && uj.this.rl) {
                        uj.this.rl = false;
                        pf.c((View) uj.this.z, 0);
                        uj.this.z.getSlideUpAnimatorSet().start();
                        uj.this.qy = true;
                        uj.this.sp.postDelayed(new Runnable() { // from class: com.byazt.dqg.uj.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                uj.this.a();
                            }
                        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    }
                }
            }, 0L);
        }
    }

    public void a() {
        if (this.yp) {
            this.rl = false;
            if (this.qy) {
                pf.c((View) this.z, 8);
                RewardGuideSlideUp rewardGuideSlideUp = this.z;
                if (rewardGuideSlideUp != null) {
                    rewardGuideSlideUp.tt();
                }
                this.qy = false;
            }
        }
    }

    public void c(boolean z) {
        com.byazt.iym.ve veVar = this.rh;
        if (veVar == null) {
            return;
        }
        veVar.tt(false);
    }

    @Override // com.byazt.dqg.tt
    public void da() {
        super.da();
        a();
    }
}

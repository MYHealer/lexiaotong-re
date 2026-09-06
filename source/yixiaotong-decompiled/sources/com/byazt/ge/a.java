package com.byazt.ge;

import android.view.View;
import com.byazt.ete.ic;
import com.byazt.fcd.x;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.qq.da;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 758, 34})
public class a extends ve {
    public a(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, com.byazt.kcl.tt ttVar, com.byazt.kcl.n nVar, boolean z) {
        super(tTBaseVideoActivity, icVar, ttVar, nVar, z);
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void ve(View view) {
        super.ve(view);
        this.f2248a.ve("video_player");
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void tt(View view) {
        super.tt(view);
        if (this.f2248a.to() instanceof x) {
            this.f2248a.qp();
        }
        this.f2248a.cu();
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void c(View view) {
        super.c(view);
        if (c()) {
            return;
        }
        this.f2248a.lt().c();
        if (this.f2248a.to().to()) {
            tt();
        } else {
            ve();
        }
    }

    private void tt() {
        da daVar = new da() { // from class: com.byazt.ge.a.1
            @Override // com.byazt.qq.da
            public void tt() {
                a.this.f2248a.yp();
                a.this.f2248a.nb().postDelayed(new Runnable() { // from class: com.byazt.ge.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f2248a.tt();
                    }
                }, 100L);
            }
        };
        int iN = this.f2248a.n(2);
        if (this.tt.wn() != 7 ? iN == 1 : !(!this.tt.dh() || this.f2248a.tk())) {
            if (c(daVar)) {
                return;
            }
            daVar.tt();
            return;
        }
        this.f2248a.ve();
    }

    private void ve() {
        da daVar = new da() { // from class: com.byazt.ge.a.2
            @Override // com.byazt.qq.da
            public void tt() {
                a.this.f2248a.ve();
            }
        };
        if (c(daVar)) {
            return;
        }
        daVar.tt();
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void a(View view) {
        super.a(view);
        c(view);
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void sp(View view) {
        super.sp(view);
        this.f2248a.v();
    }
}

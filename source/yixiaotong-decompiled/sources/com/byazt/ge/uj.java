package com.byazt.ge;

import android.view.View;
import com.byazt.ete.ic;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.qq.da;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 758, 15})
public class uj extends ve {
    public uj(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, com.byazt.kcl.tt ttVar, com.byazt.kcl.n nVar, boolean z) {
        super(tTBaseVideoActivity, icVar, ttVar, nVar, z);
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void ve(View view) {
        super.ve(view);
        this.f2248a.ve(this.uj.nb());
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void tt(View view) {
        super.tt(view);
        this.f2248a.qp();
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void c(View view) {
        super.c(view);
        if (c()) {
            return;
        }
        this.f2248a.lt().tt();
        if (this.uj.bx()) {
            this.f2248a.tt();
        } else if (this.f2248a.to().to()) {
            tt();
        } else {
            ve();
        }
    }

    @Override // com.byazt.ge.ve, com.byazt.ge.tt
    public void a(View view) {
        super.a(view);
        c(view);
    }

    private void tt() {
        da daVar = new da() { // from class: com.byazt.ge.uj.1
            @Override // com.byazt.qq.da
            public void tt() {
                uj.this.f2248a.tt();
            }
        };
        if (c(daVar)) {
            this.sp--;
        } else {
            daVar.tt();
        }
    }

    private void ve() {
        this.f2248a.tt();
    }
}

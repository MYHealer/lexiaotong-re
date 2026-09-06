package com.byazt.yzg;

import com.byazt.ete.gt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 776, 13})
public class tt extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2906a = false;
    public int sp = 0;
    public int x = -1;

    public void c(int i) {
        this.sp = i;
    }

    public void ve(boolean z) {
        this.f2906a = z;
    }

    @Override // com.byazt.yzg.c
    public boolean ve() {
        this.uj = 1;
        boolean z = a.uj;
        int iC = gt.c(this.tt.u_());
        if (z) {
            iC = 0;
            a.uj = false;
        }
        if (this.n) {
            return n();
        }
        if (this.f2906a) {
            int i = this.sp;
            if (i == 2) {
                return n();
            }
            if (iC == 2 && i == 1) {
                return n();
            }
        }
        if (iC == 0) {
            return n();
        }
        return true;
    }

    private boolean n() {
        this.uj = uj();
        return this.uj != -1;
    }
}

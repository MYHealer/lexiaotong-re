package com.byazt.biq;

import com.byazt.omf.x;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 12, 15})
public class uj implements com.byazt.aas.c.tt {
    public long c;
    public long tt;
    public long ve;

    @Override // com.byazt.aas.c.tt
    public void onAppExit() {
    }

    @Override // com.byazt.aas.c.tt
    public void onAppStart() {
    }

    public void ve() {
        this.tt = 0L;
        this.ve = 0L;
        this.c = 0L;
    }

    public uj() {
        x.m().c(this);
    }

    public void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.tt;
        if (j != 0) {
            this.c += jCurrentTimeMillis - j;
        }
        this.tt = jCurrentTimeMillis;
    }

    public void tt() {
        if (this.tt == 0) {
            return;
        }
        this.c += System.currentTimeMillis() - this.tt;
        this.tt = 0L;
        this.ve = 0L;
    }

    public long c(TimeUnit timeUnit) {
        return timeUnit != null ? timeUnit.convert(this.c, TimeUnit.MILLISECONDS) : this.c;
    }

    @Override // com.byazt.aas.c.tt
    public void onAppBackground() {
        tt();
    }

    @Override // com.byazt.aas.c.tt
    public void onAppForeground() {
        c();
    }
}

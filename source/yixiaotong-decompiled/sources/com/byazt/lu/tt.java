package com.byazt.lu;

import com.byazt.yv.da;
import org.json.JSONException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 772, 13})
public abstract class tt {
    public final uj c;
    public int tt = 0;
    public volatile boolean uj;
    public boolean ve;

    public boolean a() {
        return this.ve;
    }

    public abstract long c();

    public void n() {
        this.ve = true;
    }

    public abstract long[] tt();

    public abstract String uj();

    public abstract boolean ve() throws JSONException;

    public tt(uj ujVar) {
        this.c = ujVar;
    }

    public final long sp() {
        long jC = c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.uj) {
            this.uj = false;
            jC = 0;
        }
        if (jC <= 1000 + jCurrentTimeMillis) {
            try {
                if (ve()) {
                    this.tt = 0;
                    jC = c();
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
            } catch (Exception e) {
                da.tt(e);
            }
            long[] jArrTt = tt();
            int i = this.tt;
            this.tt = i + 1;
            return jArrTt[i % jArrTt.length];
        }
        return jC - jCurrentTimeMillis;
    }

    public void x() {
        da.c("setImmediately, " + uj());
        this.uj = true;
    }
}

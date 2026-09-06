package com.byazt.ke;

import com.huawei.openalliance.ad.constant.x;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 723, 13})
public abstract class tt implements Comparable<tt>, Runnable {
    public int c = 5;
    public String tt = UUID.randomUUID().toString() + x.A + String.valueOf(System.nanoTime());
    public String ve;

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public tt(String str) {
        this.ve = str;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(tt ttVar) {
        if (c() < ttVar.c()) {
            return 1;
        }
        return c() >= ttVar.c() ? -1 : 0;
    }
}

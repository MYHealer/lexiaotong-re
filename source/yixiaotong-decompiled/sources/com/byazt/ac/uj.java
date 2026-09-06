package com.byazt.ac;

import com.byazt.at.n;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 89, 15})
public class uj extends com.byazt.vgp.uj {
    public final WeakReference<n> c;

    public uj(n nVar) {
        this.c = new WeakReference<>(nVar);
    }

    @Override // com.byazt.zb.c
    public void c() {
        if (this.c.get() != null) {
            this.c.get().c(0);
        }
    }

    @Override // com.byazt.zb.c
    public void c(int i, String str) {
        WeakReference<n> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.c.get();
    }
}

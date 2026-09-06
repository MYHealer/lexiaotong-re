package com.byazt.zy;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1698, 13})
public class tt {
    public final List<rl> c = new ArrayList();

    public void c(rl rlVar) {
        this.c.add(rlVar);
    }

    public void c(Path path) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            com.byazt.kk.da.c(path, this.c.get(size));
        }
    }
}

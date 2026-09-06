package com.byazt.rob;

import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1211, 13})
public class tt {
    public static tt c;
    public Map<Integer, Bundle> tt = Collections.synchronizedMap(new HashMap());

    private tt() {
    }

    public static synchronized tt c() {
        if (c == null) {
            c = new tt();
        }
        return c;
    }

    public void c(int i, Bundle bundle) {
        this.tt.put(Integer.valueOf(i), bundle);
    }

    public Bundle c(int i) {
        return this.tt.get(Integer.valueOf(i));
    }

    public void tt(int i) {
        this.tt.remove(Integer.valueOf(i));
    }
}

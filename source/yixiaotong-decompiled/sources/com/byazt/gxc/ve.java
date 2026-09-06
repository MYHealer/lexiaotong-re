package com.byazt.gxc;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2215, 54})
public class ve {
    public static Function<SparseArray<Object>, Object> c(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        return com.byazt.rl.c.tt;
    }
}
